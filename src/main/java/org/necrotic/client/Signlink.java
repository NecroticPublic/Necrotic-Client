package org.necrotic.client;

import java.applet.Applet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;

import org.necrotic.Configuration;

public final class Signlink implements Runnable {

	private static boolean active;
	public static RandomAccessFile cache_dat = null;
	public static final RandomAccessFile[] cache_idx = new RandomAccessFile[Client.CACHE_INDEX_COUNT];
	public static String dns = null;
	private static String dnsreq = null;
	public static Applet mainapp = null;
	public static boolean reporterror = true;
	private static byte[] savebuf = null;
	private static int savelen;
	private static String savereq = null;
	private static InetAddress socketip;
	private static int socketreq;
	public static int storeid = 32;
	public static boolean sunjava;
	private static int threadliveid;
	private static Runnable threadreq = null;
	private static int threadreqpri = 1;
	public static long uid;
	private static String urlreq = null;

	public static synchronized void dnslookup(String s) {
		dns = s;
		dnsreq = s;
	}

	public static void release() {
		try {
			if (cache_dat != null) {
				cache_dat.close();
			}

			for (RandomAccessFile file : cache_idx) {
				if (file != null) {
					file.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getCacheDirectory() {
		String cacheLoc = System.getProperty("user.home") + "/";
		if(Configuration.DROPBOX_MODE) {
			cacheLoc = "./";
		}
		cacheLoc += Configuration.CACHE_DIRECTORY_NAME + "/";
		File cacheDir = new File(cacheLoc);
		if(!cacheDir.exists()) {
			cacheDir.mkdir();
		}
		return cacheLoc;
	}
	
	public static String getSettingsDirectory() {
		String cacheLoc = System.getProperty("user.home") + "/";
		cacheLoc += Configuration.SETTINGS_DIRECTORY_NAME + "/";
		File settingDir = new File(cacheLoc);
		if(!settingDir.exists()) {
			settingDir.mkdir();
		}
		return cacheLoc;
	}

	public static String getIdentifierFile() {
		return (!System.getProperty("os.name").toLowerCase().contains("windows") ? System.getProperty("user.home") : System.getenv("APPDATA")) + "/.fallout/";
	}

	/**
	 * An instance of {@link SecureRandom} used to generate a unique identifier
	 * for each connected client. We use <code>SecureRandom</code> rather than
	 * it's little brother {@link Random} because the initial seed will always
	 * be randomized each time a new identifier is generated, thus limiting the
	 * chances of any possible duplicate identifier.
	 */
	private static final Random KEY_GEN = new SecureRandom();

	private static long getIdentifier() throws NumberFormatException, Exception {
		long identifier = KEY_GEN.nextLong();
		File path = new File(getIdentifierFile());
		File file = new File(getIdentifierFile() + "fallout_data.dat");
		if (!path.exists()) {
			path.mkdir();
			try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
				output.writeLong(identifier);
				output.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
				identifier = input.readLong();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return identifier;
	}

	public static void reportError(String s) {
		System.out.println("Error: " + s);
	}

	public static void startpriv(InetAddress inetaddress) {
		threadliveid = (int) (Math.random() * 99999999D);

		if (active) {
			try {
				Thread.sleep(500L);
			} catch (Exception _ex) {
			}

			active = false;
		}

		socketreq = 0;
		threadreq = null;
		dnsreq = null;
		savereq = null;
		urlreq = null;
		socketip = inetaddress;
		Thread thread = new Thread(new Signlink());
		thread.setDaemon(true);
		thread.start();

		while (!active) {
			try {
				Thread.sleep(50L);
			} catch (Exception _ex) {
			}
		}
	}

	public static synchronized void startthread(Runnable runnable, int i) {
		threadreqpri = i;
		threadreq = runnable;
	}

	private Signlink() {
	}

	@Override
	public void run() {
		active = true;
		File s = new File(getCacheDirectory());
		/*try {
			uid = getIdentifier();
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		try {
			cache_dat = new RandomAccessFile(s + "/main_file_cache.dat", "rw");

			for (int i = 0; i < Client.CACHE_INDEX_COUNT; i++) {
				cache_idx[i] = new RandomAccessFile(s + "/main_file_cache.idx" + i, "rw");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		for (int i = threadliveid; threadliveid == i;) {
			if (socketreq != 0) {
				try {
					new Socket(socketip, socketreq);
				} catch (Exception _ex) {
				}

				socketreq = 0;
			} else if (threadreq != null) {
				Thread thread = new Thread(threadreq);
				thread.setDaemon(true);
				thread.start();
				thread.setPriority(threadreqpri);
				threadreq = null;
			} else if (dnsreq != null) {
				try {
					dns = InetAddress.getByName(dnsreq).getHostName();
				} catch (Exception _ex) {
					dns = "unknown";
				}

				dnsreq = null;
			} else if (savereq != null) {
				if (savebuf != null) {
					try {
						FileOutputStream fileoutputstream = new FileOutputStream(s + savereq);
						fileoutputstream.write(savebuf, 0, savelen);
						fileoutputstream.close();
					} catch (Exception _ex) {
					}
				}

				savereq = null;
			} else if (urlreq != null) {
				try {
					new DataInputStream(new URL(mainapp.getCodeBase(), urlreq).openStream());
				} catch (Exception _ex) {
				}

				urlreq = null;
			}
			try {
				Thread.sleep(50L);
			} catch (Exception _ex) {
			}
		}
	}

	}

