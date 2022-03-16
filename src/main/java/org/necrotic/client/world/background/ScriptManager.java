package org.necrotic.client.world.background;

import org.necrotic.client.Client;

public class ScriptManager {

	private static double curve(double d, double d1) {
		double d2 = d - d1;
		double d3 = 2048.0D - d1 + d;
		double d4 = 2048.0D - d + d1;
		double d5 = Math.abs(d2);
		double d6 = Math.abs(d3);
		double d7 = Math.abs(d4);

		if (d5 < d6 && d5 < d7) {
			return d2;
		}

		if (d6 < d5 && d6 < d7) {
			return d3;
		}

		if (d7 < d5 && d7 < d6) {
			return d4;
		}

		return d2;
	}

	private static double p5(double d) {
		d = Math.abs(d);
		return d * d * d * d * d;
	}

	private static int round(double d) {
		if (d < 0.0D) {
			d -= 0.5D;
		} else {
			d += 0.5D;
		}
		return (int) d;
	}

	private static double sgn(double d, double d1) {
		d %= d1;
		return d < 0.0D ? d + d1 : d;
	}

	private static final int warp(int speed) {
		return ~speed + 2;
	}

	private boolean loop;
	private double xCameraPos;
	private double yCameraPos;
	private double zCameraPos;
	private double xCameraCurve;
	private double yCameraCurve;
	private int cycles;
	private double xCameraPosRate;
	private double yCameraPosRate;
	private double zCameraPosRate;
	private double xCameraCurveRate;
	private double yCameraCurveRate;
	private int pos;
	private final Client instance;
	private int[] cameraIndex;
	public int terrainRegionX;
	public int terrainRegionY;
	public int regionPlane;

	public ScriptManager(Client client) {
		int generateLocation = (int) (java.lang.Math.random() * (8 + 1));
		instance = client;
		int cycleSpeed = 0;

		switch (generateLocation) {
		case 0:// Varrock
			cameraMapping(401, 424, 0, false, new int[] {
					// cameraX, cameraY, cameraZ, curveX, curveY, speed
					6711, 5920, -1901, 2032, 383, cycleSpeed, 6597, 7213, -665,
					2034, 128, cycleSpeed, 6454, 8791, -715, 1983, 133,
					cycleSpeed, 6452, 9108, -1017, 1951, 208, cycleSpeed, 6131,
					10220, -1420, 1794, 288, cycleSpeed, 6135, 11541, -1420,
					1277, 288, cycleSpeed, 7432, 11543, -1420, 772, 288,
					cycleSpeed, 7440, 10224, -1420, 256, 288, cycleSpeed });
			break;
		case 1:// Falador
			cameraMapping(375, 422, 0, false, new int[] {
					// cameraX, cameraY, cameraZ, curveX, curveY, speed
					7963, 6612, -425, 500, 128, cycleSpeed, 6431, 6612, -1073,
					500, 128, cycleSpeed, 5792, 6612, -1145, 500, 128,
					cycleSpeed, 5792, 6612, -1145, 500, 128, cycleSpeed, 4500,
					6612, -950, 500, 128, cycleSpeed, 2750, 6568, -1500, 556,
					128, cycleSpeed, 2750, 6568, -1500, 2900, 150, warp(4) });
			break;

		case 2:// Lumbridge Forrest
			cameraMapping(3164 >> 3, 3221 >> 3, 0, false, new int[] {
				// cameraX, cameraY, cameraZ, curveX, curveY, speed
				10000, 2000, -900, 300, 278, cycleSpeed, 7000, 11600,
				-1125, -300, 278, cycleSpeed, 3000, 7000, -1125, -300, 278,
				cycleSpeed, });
			break;

		case 3:// Shillo Village
			cameraMapping(2839 >> 3, 2967 >> 3, 0, false, new int[] {
				// cameraX, cameraY, cameraZ, curveX, curveY, speed
				10000, 2000, -1200, 300, 278, cycleSpeed, 7000, 11600,
				-1305, -300, 308, cycleSpeed, 3000, 7000, -1305, -300, 308,
				cycleSpeed, });
			break;

		case 4: // West Ardy
			cameraMapping(2530 >> 3, 3290 >> 3, 0, false, new int[] {
					// cameraX, cameraY, cameraZ, curveX, curveY, speed
					10000, 2000, -900, 300, 278, cycleSpeed, 7000, 11600,
					-1125, -300, 278, cycleSpeed, 3000, 7000, -1125, -300, 278,
					cycleSpeed, });
			break;

		case 5:// castle wars
			cameraMapping(2401 >> 3, 3104 >> 3, 0, false, new int[] {
					// cameraX, cameraY, cameraZ, curveX, curveY, speed
					10000, 2000, -1200, 300, 278, cycleSpeed, 7000, 11600,
					-1305, -300, 308, cycleSpeed, 3000, 7000, -1305, -300, 308,
					cycleSpeed, });
			break;
		}
		reset();
	}

	private void cameraMapping(int x, int y, int plane, boolean loop, int[] cameraIndex) {
		terrainRegionX = x;
		terrainRegionY = y;
		regionPlane = plane;
		this.loop = true;
		this.cameraIndex = cameraIndex;
	}

	public void cycle() {
		boolean justReset = false;
		while (cycles < 1) {
			if (cameraIndex == null) {
				return;
			}
			int total = cameraIndex.length / 6;
			if (pos < 0 || pos >= total) {
				if (loop && !justReset) {
					justReset = true;
					pos = 0;
					cycles = 0;
					// instance.resetWorld(0);
					// instance.setNorth();
					if (instance.plane != regionPlane) {
						instance.plane = regionPlane;
					}
					if (instance.terrainRegionX != terrainRegionX || instance.terrainRegionY != terrainRegionY) {
						instance.generateWorld(terrainRegionX, terrainRegionY);
					}
					instance.resetWorld(1);
					;
				}
				return;
			}
			int idx = (pos << 2) + (pos << 1);
			pos++;
			if (cameraIndex[5 + idx] == 0x80000000) {
				// instance.resetWorld(0);;
				instance.setNorth();
				if (instance.plane != cameraIndex[idx + 2]) {
					instance.plane = cameraIndex[idx + 2];
				}
				if (instance.terrainRegionX != cameraIndex[idx] || instance.terrainRegionY != cameraIndex[idx + 1]) {
					instance.generateWorld(cameraIndex[idx], cameraIndex[idx + 1]);
				}
				instance.resetWorld(1);
				;
				break;
			}
			double xPos = cameraIndex[idx] - xCameraPos;
			double yPos = cameraIndex[1 + idx] - yCameraPos;
			double zPos = cameraIndex[2 + idx] - zCameraPos;
			double xCurve = curve(cameraIndex[3 + idx] & 2047, xCameraCurve);
			double yCurve = curve(cameraIndex[4 + idx] & 2047, yCameraCurve);
			cycles = cameraIndex[5 + idx];
			if (cycles < 1) {
				int mult = ~cycles + 2;
				double cyclesD = Math.pow(p5(xPos) + p5(yPos) + p5(zPos) + p5(xCurve) + p5(yCurve), 1.0D / 5.0D);
				cycles = round(cyclesD / 7.5D);
				if (cycles < 1) {
					cycles = 1;
				}
				cycles *= mult;
			}
			xCameraPosRate = xPos / cycles;
			yCameraPosRate = yPos / cycles;
			zCameraPosRate = zPos / cycles;
			xCameraCurveRate = xCurve / cycles;
			yCameraCurveRate = yCurve / cycles;
		}
		if (cycles > 0) {
			xCameraPos += xCameraPosRate;
			yCameraPos += yCameraPosRate;
			zCameraPos += zCameraPosRate;
			xCameraCurve = sgn(xCameraCurve + xCameraCurveRate, 2048.0D);
			yCameraCurve = sgn(yCameraCurve + yCameraCurveRate, 2048.0D);
			update();
			cycles--;
		}
	}

	private void reset() {
		pos = 1;
		cycles = 0;

		if (cameraIndex == null) {
			return;
		}

		if (cameraIndex.length < 6) {
			return;
		}

		xCameraPos = cameraIndex[0];
		yCameraPos = cameraIndex[1];
		zCameraPos = cameraIndex[2];
		xCameraCurve = cameraIndex[3] & 2047;
		yCameraCurve = cameraIndex[4] & 2047;
		update();
	}

	public void update() {
		instance.xCameraPos = round(xCameraPos);
		instance.yCameraPos = round(yCameraPos);
		instance.zCameraPos = round(zCameraPos);
		instance.xCameraCurve = round(xCameraCurve) & 2047;
		instance.yCameraCurve = round(yCameraCurve) & 2047;
	}

}