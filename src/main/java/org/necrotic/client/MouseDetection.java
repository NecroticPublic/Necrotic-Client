package org.necrotic.client;

public final class MouseDetection implements Runnable {

	private final Client clientInstance;
	public int coordsIndex;
	private final int[] coordsX;
	private final int[] coordsY;
	public boolean running;
	public final Object locker;

	public MouseDetection(Client client1) {
		locker = new Object();
		coordsY = new int[500];
		running = true;
		coordsX = new int[500];
		clientInstance = client1;
	}

	@Override
	public void run() {
		while (running) {
			synchronized (locker) {
				if (coordsIndex < 500) {
					coordsX[coordsIndex] = clientInstance.mouseX;
					coordsY[coordsIndex] = clientInstance.mouseY;
					coordsIndex++;
				}
			}

			try {
				Thread.sleep(50L);
			} catch (Exception _ex) {
			}
		}
	}

}