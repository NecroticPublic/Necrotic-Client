package org.necrotic.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.necrotic.Configuration;

/**
 * Handles cache downloading
 */
public class CacheDownloader {

	private static final String CACHE_FILE_NAME = "NecroticCache.zip"; //The name of the actual .zip file
	private static final String CACHE_URL = "http://necrotic.org/downloads/cache/"+CACHE_FILE_NAME; //The url to the .zip file
	private static final String NEWEST_VERSION_FILE_URL = "http://necrotic.org/downloads/cache/cache_version.txt"; //The url to the current cache_versiont txt file
	private static final String CURRENT_VERSION_FILE = "cache_version.txt"; //The location of the local cache_version txt file
	
	public static final String URL_TO_LOADING_IMAGES = "http://necrotic.org/downloads/images/";
	public static final String MIRROR_URL_TO_LOADING_IMAGES = "http://necrotic.org/downloads/images/"; //If first link is broken, it will attempt to download from here
	
	public static boolean UPDATING = true;
	
	public static boolean updatedCache() {
		try {
			
			double newest = getNewestVersion();
			double current = getCurrentVersion();
			if (cacheDownloadRequired(newest, current) || forceUpdateCache()) {
				if (Configuration.STOP_CACHE_UPDATES) {
					System.out.println("Stopped a cache update from occuring due to current configuration.");
				} else {
					if (forceUpdateCache() == true) {
						System.out.println("We are localhost, and being forced to update cache.");					
					} else {
						System.out.println("Naturally found cache update. No manual overrides detected, proceeding as normal. Current: "+current+", Newest: "+newest);
					}
					downloadCache();
					unzipCache();
					setLatestCacheVersion(newest);
				}
			}
			
			UPDATING = false;
			
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		UPDATING = false;
		return false;
	}
	
	@SuppressWarnings("unused")
	public static boolean forceUpdateCache() {
		if (Configuration.SERVER_HOST().equalsIgnoreCase("localhost") && Configuration.FORCE_CACHE_UPDATE) {
			return true;
		}
		return false;
	}
	
	public static boolean cacheDownloadRequired(double newest, double current) {
		return newest > current;
	}
	
	public static void downloadCache() throws IOException {
		URL url = new URL(CACHE_URL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.addRequestProperty("User-Agent", "Mozilla/4.76");
		int responseCode = httpConn.getResponseCode();

		// always check HTTP response code first
		if (responseCode == HttpURLConnection.HTTP_OK) {
			String fileName = CACHE_FILE_NAME;
			// opens input stream from the HTTP connection
			InputStream inputStream = httpConn.getInputStream();
			String saveFilePath = Signlink.getCacheDirectory() + File.separator + fileName;

			// opens an output stream to save into file
			FileOutputStream outputStream = new FileOutputStream(saveFilePath);

			int bytesRead = -1;
			byte[] buffer = new byte[4096];
			//long startTime = System.currentTimeMillis();
			//int downloaded = 0;
			long numWritten = 0;
			int length = httpConn.getContentLength();
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
				numWritten += bytesRead;
				//downloaded += bytesRead;
				int percentage = (int)(((double)numWritten / (double)length) * 100D);
				Client.getClient().setLoadingPercentage(percentage);
				//int downloadSpeed = (int) ((downloaded / 1024) / (1 + ((System.currentTimeMillis() - startTime) / 1000)));
				//Client.getClient().drawSmoothLoading(percentage, (new StringBuilder()).append("Downloading "+percentage+"% ").append("@ "+downloadSpeed+"Kb/s").toString());
				//System.out.println((new StringBuilder()).append("Downloading "+percentage+"% ").append("@ "+downloadSpeed+"Kb/s").toString());
				//drawLoadingText(percentage, (new StringBuilder()).append("Downloading "+downloadingText+""+s+": "+percentage+"% ").append("@ "+downloadSpeed+"Kb/s").toString());
			}

			outputStream.close();
			inputStream.close();

		} else {
			System.out.println("Cache host replied HTTP code: " + responseCode);
		}
		httpConn.disconnect();
	}

	private static void unzipCache() {
		try {
			final File file = new File(Signlink.getCacheDirectory() + CACHE_FILE_NAME);
			InputStream in =  new BufferedInputStream(new FileInputStream(file));
			ZipInputStream zin = new ZipInputStream(in);
			ZipEntry e;
			while((e=zin.getNextEntry()) != null) {
				if(e.isDirectory()) {
					(new File(Signlink.getCacheDirectory() + e.getName())).mkdir();
				} else {
					if (e.getName().equals(file.getName())) {
						unzipPartlyArchive(zin, file.getName());
						break;
					}
					unzipPartlyArchive(zin, Signlink.getCacheDirectory() + e.getName());
				}
			}
			zin.close();
			file.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Unzips a partly archive
	 * @param zin	The zip inputstream
	 * @param s		The location of the zip file
	 * @throws IOException	The method can throw an IOException.
	 */
	private static void unzipPartlyArchive(ZipInputStream zin, String s) throws Exception {
		FileOutputStream out = new FileOutputStream(s);
		//drawLoadingText(100, "Unpacking data..");
		byte [] b = new byte[1024];
		int len = 0;

		while ((len = zin.read(b)) != -1) {
			out.write(b,0,len);
		}
		out.close();
	}
	
	public static double getCurrentVersion()
	{
		try
		{
			File file = new File(Signlink.getCacheDirectory() + CURRENT_VERSION_FILE);
			if(!file.exists()) {
				return 0.0;
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			double version = Double.parseDouble(br.readLine());
			br.close();
			return version;
		}
		catch (Exception e) {}
		return 0.1D;
	}

	public static double getNewestVersion()
	{
		try
		{
			URL url = new URL(NEWEST_VERSION_FILE_URL);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/4.76");
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			double version = Double.parseDouble(br.readLine());
			br.close();
			return version;
		}
		catch (Exception e) {}
		return 0.1D;
	}
	
	public static void setLatestCacheVersion(double newest) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(Signlink.getCacheDirectory() + CURRENT_VERSION_FILE));
		bw.write(""+newest+"");
		bw.close();
	}
}
