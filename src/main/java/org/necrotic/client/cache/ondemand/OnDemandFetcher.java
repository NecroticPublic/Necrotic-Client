package org.necrotic.client.cache.ondemand;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;

import org.necrotic.Configuration;
import org.necrotic.client.Client;
import org.necrotic.client.Signlink;
import org.necrotic.client.cache.Archive;
import org.necrotic.client.cache.node.Deque;
import org.necrotic.client.cache.node.NodeSubList;
import org.necrotic.client.io.ByteBuffer;

public final class OnDemandFetcher extends OnDemandFetcherParent implements Runnable {

	/**
	 * Grabs the checksum of a file from the cache.
	 *
	 * @param type The type of file (0 = model, 1 = anim, 2 = midi, 3 = map).
	 * @param id The id of the file.
	 * @return
	 */
	public int getChecksum(int type, int id) {
		int crc = 0;
		byte[] data = clientInstance.decompressors[type + 1].decompress(id);
		if (data != null) {
			int length = data.length - 2;
			crc32.reset();
			crc32.update(data, 0, length);
			crc = (int) crc32.getValue();
		}
		return crc;
	}

	public void dump() {
		int exceptions = 0;
		for (int element : mapIndices2) {
			try {
				byte abyte[] = clientInstance.decompressors[4].decompress(element);
				File map = new File(Signlink.getCacheDirectory() + "/mapdata/" + element + ".gz");
				FileOutputStream fos = new FileOutputStream(map);
				fos.write(abyte);
				fos.close();
			} catch (Exception e) {
				// e.printStackTrace();
				exceptions++;
			}
		}
		for (int element : mapIndices3) {
			try {
				byte abyte[] = clientInstance.decompressors[4].decompress(element);
				File map = new File(Signlink.getCacheDirectory() + "/mapdata/" + element + ".gz");
				FileOutputStream fos = new FileOutputStream(map);
				fos.write(abyte);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
				exceptions++;
			}
		}

		System.out.println("dumped maps with " + exceptions + " exceptions.");
	}

	/**
	 * Grabs the version of a file from the cache.
	 *
	 * @param type The type of file (0 = model, 1 = anim, 2 = midi, 3 = map).
	 * @param id The id of the file.
	 * @return
	 */
	public int getVersion(int type, int id) {
		int version = 1;
		byte[] data = clientInstance.decompressors[type + 1].decompress(id);
		if (data != null) {
			int length = data.length - 2;
			version = ((data[length] & 0xff) << 8) + (data[length + 1] & 0xff);
		}
		return version;
	}

	/**
	 * Writes the checksum list for the specified archive type and length.
	 *
	 * @param type The type of archive (0 = model, 1 = anim, 2 = midi, 3 = map).
	 * @param length The number of files in the archive.
	 */
	public void writeChecksumList(int type) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(Signlink.getCacheDirectory(), type + "_crc.dat")));
			for (int index = 0; index < clientInstance.decompressors[type + 1].getFileCount(); index++) {
				out.writeInt(getChecksum(type, index));
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes the version list for the specified archive type and length.
	 *
	 * @param type The type of archive (0 = model, 1 = anim, 2 = midi, 3 = map).
	 * @param length The number of files in the archive.
	 */
	public void writeVersionList(int type) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(Signlink.getCacheDirectory(), type + "_version.dat")));
			for (int index = 0; index < clientInstance.decompressors[type + 1].getFileCount(); index++) {
				out.writeShort(getVersion(type, index));
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int totalFiles;
	private final Deque requested;
	private int anInt1332;
	public String statusString;
	private int writeLoopCycle;
	private long openSocketTime;
	private int[] mapIndices3;
	private final CRC32 crc32;
	private final byte[] ioBuffer;
	private final byte[][] fileStatus;
	private Client clientInstance;
	private final Deque extraFilesList;
	private int completedSize;
	private int expectedSize;
	private int[] anIntArray1348;
	private int[] mapIndices2;
	private int filesLoaded;
	private boolean running;
	private OutputStream outputStream;
	private int[] mapIndices4;
	private boolean waiting;
	private final Deque incompleteList;
	private final byte[] gzipInputBuffer;
	private final NodeSubList queue;
	private InputStream inputStream;
	private Socket socket;
	private final int[][] crcs;
	private int uncompletedCount;
	private int completedCount;
	private final Deque next;
	private OnDemandRequest current;
	private final Deque loadRequestList;
	private int[] mapIndices1;
	private int loopCycle;
	private byte[] modelIndices;
	public int anInt1349;

	public OnDemandFetcher() {
		requested = new Deque();
		statusString = "";
		crc32 = new CRC32();
		ioBuffer = new byte[500];
		fileStatus = new byte[5][];
		extraFilesList = new Deque();
		running = true;
		waiting = false;
		incompleteList = new Deque();
		gzipInputBuffer = new byte[3000000];
		queue = new NodeSubList();
		crcs = new int[5][];
		next = new Deque();
		loadRequestList = new Deque();
	}

	private void checkReceived() {
		OnDemandRequest onDemandData;
		synchronized (loadRequestList) {
			onDemandData = (OnDemandRequest) loadRequestList.popHead();
		}
		while (onDemandData != null) {
			waiting = true;
			byte abyte0[] = null;
			if (clientInstance.decompressors[0] != null) {
				abyte0 = clientInstance.decompressors[onDemandData.getDataType() + 1].decompress(onDemandData.getId());
			}
			if (Configuration.JAGCACHED_ENABLED) {
				if (!crcMatches(crcs[onDemandData.getDataType()][onDemandData.getId()], abyte0)) {
					// abyte0 = null;
				}
			}
			synchronized (loadRequestList) {
				if (abyte0 == null) {
					next.insertHead(onDemandData);
				} else {
					onDemandData.setBuffer(abyte0);
					synchronized (incompleteList) {
						incompleteList.insertHead(onDemandData);
					}
				}
				onDemandData = (OnDemandRequest) loadRequestList.popHead();
			}
		}
	}

	/**
	 * Request data to update server.
	 *
	 * @param onDemandRequest : Request to be sent to update server.
	 */
	private void closeRequest(OnDemandRequest onDemandRequest) {
		try {
			if (socket == null) {
				long currentTime = System.currentTimeMillis();

				if (currentTime - openSocketTime < 4000L) {
					return;
				}

				openSocketTime = currentTime;
				socket = clientInstance.createFileServerSocket(43594 + Client.portOff);
				inputStream = socket.getInputStream();
				outputStream = socket.getOutputStream();
				outputStream.write(15);

				for (int j = 0; j < 8; j++) {
					inputStream.read();
				}

				loopCycle = 0;
			}

			ioBuffer[0] = (byte) onDemandRequest.getDataType();
			ioBuffer[1] = (byte) (onDemandRequest.getId() >> 8);
			ioBuffer[2] = (byte) onDemandRequest.getId();

			if (onDemandRequest.incomplete) {
				ioBuffer[3] = 2;
			} else if (!clientInstance.loggedIn) {
				ioBuffer[3] = 1;
			} else {
				ioBuffer[3] = 0;
			}

			outputStream.write(ioBuffer, 0, 4);
			writeLoopCycle = 0;
			anInt1349 = -10000;
			return;
		} catch (IOException ioexception) {
			anInt1349++;
		}

		try {
			socket.close();
		} catch (Exception _ex) {
		}

		socket = null;
		inputStream = null;
		outputStream = null;
		expectedSize = 0;
		anInt1349++;
	}

	private boolean crcMatches(int j, byte abyte0[]) {
		if (abyte0 == null || abyte0.length < 2) {
			return false;
		}

		int k = abyte0.length - 2;
		crc32.reset();
		crc32.update(abyte0, 0, k);
		int i1 = (int) crc32.getValue();
		return i1 == j;
	}

	/**
	 * Stop On Demand Fetcher service
	 */
	public void dispose() {
		running = false;
	}

	@Override
	public void get(int i) {
		requestFileData(0, i);
	}

	private void getExtras() {
		while (uncompletedCount == 0 && completedCount < 10) {
			if (anInt1332 == 0) {
				break;
			}

			OnDemandRequest onDemandData;

			synchronized (extraFilesList) {
				onDemandData = (OnDemandRequest) extraFilesList.popHead();
			}

			while (onDemandData != null) {
				if (fileStatus[onDemandData.getDataType()][onDemandData.getId()] != 0) {
					fileStatus[onDemandData.getDataType()][onDemandData.getId()] = 0;
					requested.insertHead(onDemandData);
					closeRequest(onDemandData);
					waiting = true;

					if (filesLoaded < totalFiles) {
						filesLoaded++;
					}

					statusString = "Loading extra files - " + filesLoaded * 100 / totalFiles + "%";
					completedCount++;

					if (completedCount == 10) {
						return;
					}
				}

				synchronized (extraFilesList) {
					onDemandData = (OnDemandRequest) extraFilesList.popHead();
				}
			}

			for (int j = 0; j < 4; j++) {
				byte abyte0[] = fileStatus[j];
				int k = abyte0.length;

				for (int l = 0; l < k; l++) {
					if (abyte0[l] == anInt1332) {
						abyte0[l] = 0;
						OnDemandRequest extras = new OnDemandRequest();
						extras.setDataType(j);
						extras.setId(l);
						extras.incomplete = false;
						requested.insertHead(extras);
						closeRequest(extras);
						waiting = true;

						if (filesLoaded < totalFiles) {
							filesLoaded++;
						}

						statusString = "Downloading Extra files - " + filesLoaded * 100 / totalFiles + "% Compelete";
						completedCount++;

						if (completedCount == 10) {
							return;
						}
					}
				}
			}

			anInt1332--;
		}
	}

	/**
	 * Get total of files in a cache index.
	 *
	 * @param cacheIndex : Index of the cache.
	 * @return: Amount of files that contains the cache at index
	 *          {@code cacheIndex}
	 */
	public int getFileCount(int j) {
		return crcs[j].length;
	}

	/*public int getMapCount(int arg0, int arg1, int arg2) {
		int id = (arg2 << 8) + arg1;

		for (int i = 0; i < mapIndices1.length; i++) {
			if (mapIndices1[i] == id) {
				if (arg0 == 0) {
					return mapIndices2[i] > 3535 ? -1 : mapIndices2[i];
				} else {
					return mapIndices3[i] > 3535 ? -1 : mapIndices3[i];
				}
			}
		}
		return -1;
	}*/

	public final int getMapCount(int landscapeOrObject, int regionY, int regionX)
	{
		int mapCount2;
		int mapCount3;
		int regionId = (regionX << 8) + regionY;
		for(int j1 = 0; j1 < mapIndices1.length; j1++)
			if(mapIndices1[j1] == regionId) {
				if(landscapeOrObject == 0) {
					//Soulwars
					if(mapIndices2[j1] >= 3700 && mapIndices2[j1] <= 3840) 
						return mapIndices2[j1];
					for(int cheapHax : cheapHaxValues)
						if(mapIndices2[j1] == cheapHax)
							return mapIndices2[j1];
					mapCount2 =  mapIndices2[j1] > 3535 ? -1 : mapIndices2[j1];
					return mapCount2;
				} else {
					if(mapIndices3[j1] >= 3700 && mapIndices3[j1] <= 3840) 
						return mapIndices3[j1];
					for(int cheapHax : cheapHaxValues)
						if(mapIndices3[j1] == cheapHax)
							return mapIndices3[j1];
					mapCount3 = mapIndices3[j1] > 3535 ? -1 : mapIndices3[j1];
					return mapCount3;
				}
			}
		return -1;
	}

	int[] cheapHaxValues = new int[]{
			3627,    		3628,    		
			3655,    		3656,    		
			3625,    		3626,    		
			3629,    		3630,
			4071,   		4072,
			5253,  			1816,
			1817,    		3653,
			3654,    		4067,    		
			4068,    		3639,    		
			3640,    		1976,    		
			1977,    		3571,    		
			3572,    		5129,    		
			5130,			2066,   
			2067,    		3545,  
			3546,    		3559,
			3560,    		3569,   
			3570,    		3551,  
			3552,    		3579,
			3580,    		3575,  
			3576,    		1766,   
			1767,    		3547,
			3548,    		3682,			
			3683,    		3696,
			3697,    		3692,
			3693,			4013,    		
			4079,    		4080,
			4082,    		3996,
			4083,    		4084,
			4075,    		4076,
			3664,    		3993,
			3994,    		3995,
			4077,    		4078,
			4073,    		4074,    		
			4011,    		4012,    
			3998,    		3999,   
			4081,
	};
	
	public void setExtraPriority(byte byte0, int i, int j) {
		try {
			if (clientInstance.decompressors[0] == null) {
				return;
			}
			byte[] abyte0 = clientInstance.decompressors[i + 1].decompress(j);
			if (crcMatches(crcs[i][j], abyte0)) {
				// return;
			}
			fileStatus[i][j] = byte0;
			if (byte0 > anInt1332) {
				anInt1332 = byte0;
			}
			totalFiles++;
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void loadRegions(boolean members) {
		try {
			int total = mapIndices1.length;
			for (int k = 0; k < total; k++) {
				if (members || mapIndices4[k] != 0) {
					setExtraPriority((byte) 2, 3, mapIndices3[k]);
					setExtraPriority((byte) 2, 3, mapIndices2[k]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public OnDemandRequest getNextNode() {
		OnDemandRequest onDemandData;
		synchronized (incompleteList) {
			onDemandData = (OnDemandRequest) incompleteList.popHead();
		}
		if (onDemandData == null) {
			return null;
		}
		synchronized (queue) {
			onDemandData.unlinkSub();
		}
		if (onDemandData.getBuffer() == null) {
			return onDemandData;
		}
		int i = 0;
		try {
			GZIPInputStream gzipinputstream = new GZIPInputStream(new ByteArrayInputStream(onDemandData.getBuffer()));
			do {
				if (i == gzipInputBuffer.length) {
					throw new RuntimeException("buffer overflow!");
				}
				int k = gzipinputstream.read(gzipInputBuffer, i, gzipInputBuffer.length - i);
				if (k == -1) {
					break;
				}
				i += k;
			} while (true);
		} catch (IOException _ex) {
			System.out.println("Failed to unzip - Data type: " + onDemandData.getDataType() + ". File id: " + onDemandData.getId());
			// throw new RuntimeException("error unzipping");
			return null;
		}
		onDemandData.setBuffer(new byte[i]);
		System.arraycopy(gzipInputBuffer, 0, onDemandData.getBuffer(), 0, i);

		return onDemandData;
	}

	/**
	 * Get total of data left to be downloaded.
	 *
	 * @return: Total of data to be downloaded.
	 */
	public int getRemaining() {
		synchronized (queue) {
			return queue.getSize();
		}
	}

	private void handleFailed() {
		uncompletedCount = 0;
		completedCount = 0;
		for (OnDemandRequest onDemandData = (OnDemandRequest) requested.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandRequest) requested.reverseGetNext()) {
			if (onDemandData.incomplete) {
				uncompletedCount++;
			} else {
				completedCount++;
			}
		}
		
		while (uncompletedCount < 10) {
			OnDemandRequest onDemandData_1 = (OnDemandRequest) next.popHead();
			if (onDemandData_1 == null) {
				break;
			}
			System.out.println(""+onDemandData_1.getId()+",");
			try {
				if (fileStatus[onDemandData_1.getDataType()][onDemandData_1.getId()] != 0) {
					filesLoaded++;
				}
				fileStatus[onDemandData_1.getDataType()][onDemandData_1.getId()] = 0;
				requested.insertHead(onDemandData_1);
				uncompletedCount++;
				closeRequest(onDemandData_1);
				waiting = true;
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("missing: type: " + onDemandData_1.getDataType() + " ID" + onDemandData_1.getId());
			}
		}
	}

	public void method560(int file, int cache) {
		if (clientInstance.decompressors[0] == null) {
			return;
		}
		if (fileStatus[cache][file] == 0) {
			return;
		}
		if (anInt1332 == 0) {
			return;
		}
		OnDemandRequest onDemandData = new OnDemandRequest();
		onDemandData.setDataType(cache);
		onDemandData.setId(file);
		onDemandData.incomplete = false;
		synchronized (extraFilesList) {
			extraFilesList.insertHead(onDemandData);
		}
	}

	public boolean method564(int i) {
		for (int k = 0; k < mapIndices1.length; k++) {
			if (mapIndices3[k] == i) {
				return true;
			}
		}

		return false;
	}

	public void method566() {
		synchronized (extraFilesList) {
			extraFilesList.removeAll();
		}
	}

	/**
	 * Read received data from Update Server First read 6 bytes. Put those 6
	 * bytes in a byte array {@code ioBuffer}; Decode array into file type, file
	 * ID, size of the file and chunk of the file.
	 */
	private void readData() {
		try {
			int available = inputStream.available();
			if (expectedSize == 0 && available >= 7) {
				waiting = true;
				for (int k = 0; k < 7; k += inputStream.read(ioBuffer, k, 7 - k)) {
					;
				}
				int dataType = ioBuffer[0] & 0xff;
				int fileID = ((ioBuffer[1] & 0xff) << 8) + (ioBuffer[2] & 0xff);
				int fileLength = ((ioBuffer[3] & 0xff) << 16) + ((ioBuffer[4] & 0xff) << 8) + (ioBuffer[5] & 0xff);
				int chunk = ioBuffer[6] & 0xff;
				current = null;
				for (OnDemandRequest onDemandData = (OnDemandRequest) requested.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandRequest) requested.reverseGetNext()) {
					if (onDemandData.getDataType() == dataType && onDemandData.getId() == fileID) {
						current = onDemandData;
					}
					if (current != null) {
						onDemandData.loopCycle = 0;
					}
				}

				if (current != null) {
					loopCycle = 0;
					if (fileLength == 0) {
						Signlink.reportError("Rej: " + dataType + "," + fileID);
						current.setBuffer(null);
						if (current.incomplete) {
							synchronized (incompleteList) {
								incompleteList.insertHead(current);
							}
						} else {
							current.unlink();
						}
						current = null;
					} else {
						if (current.getBuffer() == null && chunk == 0) {
							current.setBuffer(new byte[fileLength]);
						}
						if (current.getBuffer() == null && chunk != 0) {
							throw new IOException("missing start of file");
						}
					}
				}
				completedSize = chunk * 500;
				expectedSize = 500;
				if (expectedSize > fileLength - chunk * 500) {
					expectedSize = fileLength - chunk * 500;
				}
			}
			if (expectedSize > 0 && available >= expectedSize) {
				waiting = true;
				byte buf[] = ioBuffer;
				int i1 = 0;
				if (current != null) {
					buf = current.getBuffer();
					i1 = completedSize;
				}
				for (int k1 = 0; k1 < expectedSize; k1 += inputStream.read(buf, k1 + i1, expectedSize - k1)) {
					;
				}
				if (expectedSize + completedSize >= buf.length && current != null) {
					if (clientInstance.decompressors[0] != null) {
						clientInstance.decompressors[current.getDataType() + 1].method234(buf.length, buf, current.getId());
					}
					if (!current.incomplete && current.getDataType() == 3) {
						current.incomplete = true;
						current.setDataType(93);
					}
					if (current.incomplete) {
						synchronized (incompleteList) {
							incompleteList.insertHead(current);
						}
					} else {
						current.unlink();
					}
				}
				expectedSize = 0;
			}
		} catch (IOException ioexception) {
			try {
				socket.close();
			} catch (Exception _ex) {
			}
			socket = null;
			inputStream = null;
			outputStream = null;
			expectedSize = 0;
		}
	}

	/**
	 * Start a file data request, if it wasn't requested already.
	 *
	 * @param dataType : Data type of the file.
	 * @param fileID : ID of the file.
	 */
	public void requestFileData(int dataType, int fileID) {
		if (dataType < 0 || fileID < 0) {
			return;
		}

		synchronized (queue) {
			for (OnDemandRequest onDemandData = (OnDemandRequest) queue.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandRequest) queue.reverseGetNext()) {
				if (onDemandData.getDataType() == dataType && onDemandData.getId() == fileID) {
					return;
				}
			}

			OnDemandRequest onDemandData_1 = new OnDemandRequest();
			onDemandData_1.setDataType(dataType);
			onDemandData_1.setId(fileID);
			onDemandData_1.incomplete = true;

			synchronized (loadRequestList) {
				loadRequestList.insertHead(onDemandData_1);
			}

			queue.insertHead(onDemandData_1);
		}
	}

	@Override
	public void run() {
		try {
			while (running) {
				int i = 20;
				if (anInt1332 == 0 && clientInstance.decompressors[0] != null) {
					i = 50;
				}
				try {
					Thread.sleep(i);
				} catch (Exception _ex) {
				}
				waiting = true;
				for (int j = 0; j < 100; j++) {
					if (!waiting) {
						break;
					}
					waiting = false;
					checkReceived();
					handleFailed();
					if (uncompletedCount == 0 && j >= 5) {
						break;
					}
					getExtras();
					if (inputStream != null) {
						readData();
					}
				}

				boolean flag = false;
				for (OnDemandRequest onDemandData = (OnDemandRequest) requested.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandRequest) requested.reverseGetNext()) {
					if (onDemandData.incomplete) {
						flag = true;
						onDemandData.loopCycle++;
						if (onDemandData.loopCycle > 50) {
							onDemandData.loopCycle = 0;
							closeRequest(onDemandData);
						}
					}
				}

				if (!flag) {
					for (OnDemandRequest onDemandData_1 = (OnDemandRequest) requested.reverseGetFirst(); onDemandData_1 != null; onDemandData_1 = (OnDemandRequest) requested.reverseGetNext()) {
						flag = true;
						onDemandData_1.loopCycle++;
						if (onDemandData_1.loopCycle > 50) {
							onDemandData_1.loopCycle = 0;
							closeRequest(onDemandData_1);
						}
					}

				}
				if (flag) {
					loopCycle++;
					if (loopCycle > 750) {
						try {
							socket.close();
						} catch (Exception _ex) {
						}
						socket = null;
						inputStream = null;
						outputStream = null;
						expectedSize = 0;
					}
				} else {
					loopCycle = 0;
					statusString = "";
				}
				if (clientInstance.loggedIn && socket != null && outputStream != null && (anInt1332 > 0 || clientInstance.decompressors[0] == null)) {
					writeLoopCycle++;
					if (writeLoopCycle > 500) {
						writeLoopCycle = 0;
						ioBuffer[0] = 0;
						ioBuffer[1] = 0;
						ioBuffer[2] = 0;
						ioBuffer[3] = 10;
						try {
							outputStream.write(ioBuffer, 0, 4);
						} catch (IOException _ex) {
							loopCycle = 5000;
						}
					}
				}
			}
		} catch (Exception exception) {
			Signlink.reportError("od_ex " + exception.getMessage());
		}
	}

	public int getModelIndex(int i) {
		return modelIndices[i] & 0xff;
	}

	public void start(Archive streamLoader, Client client1) {
		byte[] abyte2 = null;
		int j1 = 0;
		String as1[] = { "model_crc", "anim_crc", "midi_crc", "map_crc",
		"textures_crc" };
		for (int index = 0; index < 4; index++) {
			byte abyte1[] = streamLoader.get(as1[index]);
			int fileAmount = abyte1.length / 4;
			ByteBuffer stream_1 = new ByteBuffer(abyte1);
			crcs[index] = new int[fileAmount];
			fileStatus[index] = new byte[fileAmount];
			for (int fileId = 0; fileId < fileAmount; fileId++) {
				crcs[index][fileId] = stream_1.getIntLittleEndian();
			}

		}

		abyte2 = streamLoader.get("model_index");
		j1 = crcs[0].length;
		modelIndices = new byte[j1];
		for (int k1 = 0; k1 < j1; k1++) {
			if (k1 < abyte2.length) {
				modelIndices[k1] = abyte2[k1];
			} else {
				modelIndices[k1] = 0;
			}
		}

		abyte2 = streamLoader.get("map_index");
		ByteBuffer stream2 = new ByteBuffer(abyte2);
		int mapCount = stream2.getUnsignedShort();
		mapIndices1 = new int[mapCount];
		mapIndices2 = new int[mapCount];
		mapIndices3 = new int[mapCount];
		mapIndices4 = new int[mapCount];
		int[] dntUse = new int[] {5181, 5182, 5183, 5184, 5180, 5179, 5175, 5176, 4014, 3997, 5314, 5315, 5172};
		for(int i2 = 0; i2 < mapCount; i2++)
		{
			mapIndices1[i2] = stream2.getUnsignedShort();
			mapIndices2[i2] = stream2.getUnsignedShort();
			mapIndices3[i2] = stream2.getUnsignedShort();
			for(int i : dntUse)
			{
				if(mapIndices2[i2] == i)
					mapIndices2[i2] = -1;
				if(mapIndices3[i2] == i)
					mapIndices3[i2] = -1;
			}
		}
		/*j1 = abyte2.length / 6;
		int loopVal = j1;
		mapIndices1 = new int[j1];
		mapIndices2 = new int[j1];
		mapIndices3 = new int[j1];
		mapIndices4 = new int[j1];
		for (int i2 = 0; i2 < loopVal; i2++) {
			mapIndices1[i2] = stream2.getUnsignedShort();
			mapIndices2[i2] = stream2.getUnsignedShort();
			mapIndices3[i2] = stream2.getUnsignedShort();
		}*/

		abyte2 = streamLoader.get("midi_index");
		stream2 = new ByteBuffer(abyte2);
		j1 = abyte2.length;
		anIntArray1348 = new int[j1];
		for (int k2 = 0; k2 < j1; k2++) {
			anIntArray1348[k2] = stream2.getUnsignedByte();
		}

		clientInstance = client1;
		running = true;
		clientInstance.startRunnable(this, 2);
	}

	public boolean method569(int i) {
		return anIntArray1348[i] == 1;
	}

	public final int getAnimCount()
	{
		return 33568;
	}

}