package org.necrotic.client.net;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpDownloadUtility {

	private static final int BUFFER_SIZE = 4096;

	public static boolean downloadFile(String fileURL, String saveDir) {
		try {
			URL url = new URL(fileURL);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.addRequestProperty("User-Agent", "Mozilla/4.76");
			int responseCode = httpConn.getResponseCode();

			// always check HTTP response code first
			if (responseCode == HttpURLConnection.HTTP_OK) {
				String fileName = "";
				String disposition = httpConn.getHeaderField("Content-Disposition");

				if (disposition != null) {
					// extracts file name from header field
					int index = disposition.indexOf("filename=");
					if (index > 0) {
						fileName = disposition.substring(index + 10,
								disposition.length() - 1);
					}
				} else {
					// extracts file name from URL
					fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
							fileURL.length());
				}

				// opens input stream from the HTTP connection
				InputStream inputStream = httpConn.getInputStream();
				String saveFilePath = saveDir + File.separator + fileName;

				// opens an output stream to save into file
				FileOutputStream outputStream = new FileOutputStream(saveFilePath);

				int bytesRead = -1;
				byte[] buffer = new byte[BUFFER_SIZE];
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				outputStream.close();
				inputStream.close();

			} else {
				System.out.println("Necrotic.org replied HTTP code: " + responseCode+" for file: "+fileURL);
				return false;
			}
			httpConn.disconnect();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

