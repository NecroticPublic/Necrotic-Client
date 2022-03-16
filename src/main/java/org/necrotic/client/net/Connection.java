package org.necrotic.client.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.necrotic.client.GameRenderer;

public final class Connection implements Runnable {

	private final GameRenderer applet;
	private byte[] buffer;
	private int buffIndex;
	private boolean closed;
	private boolean error;
	private final InputStream in;
	private final OutputStream out;
	private final Socket socket;
	private int writeIndex;
	private boolean writing;

	public Connection(GameRenderer applet, Socket socket) throws IOException {
		this.applet = applet;
		this.socket = socket;
		error = false;
		writing = false;
		socket.setSoTimeout(30000);
		socket.setTcpNoDelay(true);
		in = socket.getInputStream();
		out = socket.getOutputStream();
	}

	public int available() throws IOException {
		if (closed) {
			return 0;
		} else {
			return in.available();
		}
	}

	public void close() {
		closed = true;

		try {
			if (in != null) {
				in.close();
			}

			if (out != null) {
				out.close();
			}

			if (socket != null) {
				socket.close();
			}
		} catch (IOException _ex) {
			System.out.println("Error closing stream");
		}

		writing = false;

		synchronized (this) {
			notify();
		}

		buffer = null;
	}

	public void flushInputStream(byte[] buffer, int length) throws IOException {
		int totalRead = 0;

		if (closed) {
			return;
		}

		for (int readLength; length > 0; length -= readLength) {
			readLength = in.read(buffer, totalRead, length);

			if (readLength <= 0) {
				throw new IOException("EOF");
			}

			totalRead += readLength;
		}
	}

	public void queueBytes(int i, byte[] abyte0) throws IOException {
		if (closed) {
			return;
		}

		if (error) {
			error = false;
			throw new IOException("Error in writer thread");
		}

		if (buffer == null) {
			buffer = new byte[5000];
		}

		synchronized (this) {
			for (int l = 0; l < i; l++) {
				buffer[buffIndex] = abyte0[l];
				buffIndex = (buffIndex + 1) % 5000;

				if (buffIndex == (writeIndex + 4900) % 5000) {
					throw new IOException("buffer overflow");
				}
			}

			if (!writing) {
				writing = true;
				applet.startRunnable(this, 3);
			}

			notify();
		}
	}

	public int read() throws IOException {
		if (closed) {
			return 0;
		} else {
			return in.read();
		}
	}

	@Override
	public void run() {
		while (writing) {
			int i;
			int j;

			synchronized (this) {
				if (buffIndex == writeIndex) {
					try {
						wait();
					} catch (InterruptedException _ex) {
					}
				}

				if (!writing) {
					return;
				}

				j = writeIndex;

				if (buffIndex >= writeIndex) {
					i = buffIndex - writeIndex;
				} else {
					i = 5000 - writeIndex;
				}
			}

			if (i > 0) {
				try {
					out.write(buffer, j, i);
				} catch (IOException _ex) {
					error = true;
				}

				writeIndex = (writeIndex + i) % 5000;

				try {
					if (buffIndex == writeIndex) {
						out.flush();
					}
				} catch (IOException _ex) {
					error = true;
				}
			}
		}
	}

}