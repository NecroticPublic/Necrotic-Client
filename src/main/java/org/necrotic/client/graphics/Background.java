package org.necrotic.client.graphics;

import org.necrotic.client.cache.Archive;
import org.necrotic.client.io.ByteBuffer;

public final class Background extends DrawingArea {

	public byte imgPixels[];
	public final int[] palette;
	public int imgWidth;
	public int imgHeight;
	private int xOffset;
	private int yOffset;
	public int maxWidth;
	private int maxHeight;

	public Background(Archive streamLoader, String s, int i) {
		ByteBuffer stream = new ByteBuffer(streamLoader.get(s + ".dat"));
		ByteBuffer stream_1 = new ByteBuffer(streamLoader.get("index.dat"));
		stream_1.position = stream.getUnsignedShort();
		maxWidth = stream_1.getUnsignedShort();
		maxHeight = stream_1.getUnsignedShort();
		int j = stream_1.getUnsignedByte();
		palette = new int[j];
		for (int k = 0; k < j - 1; k++) {
			palette[k + 1] = stream_1.getTribyte();
		}

		for (int l = 0; l < i; l++) {
			stream_1.position += 2;
			stream.position += stream_1.getUnsignedShort() * stream_1.getUnsignedShort();
			stream_1.position++;
		}

		xOffset = stream_1.getUnsignedByte();
		yOffset = stream_1.getUnsignedByte();
		imgWidth = stream_1.getUnsignedShort();
		imgHeight = stream_1.getUnsignedShort();
		int i1 = stream_1.getUnsignedByte();
		int j1 = imgWidth * imgHeight;
		imgPixels = new byte[j1];
		if (i1 == 0) {
			for (int k1 = 0; k1 < j1; k1++) {
				imgPixels[k1] = stream.getSignedByte();
			}

			return;
		}
		if (i1 == 1) {
			for (int l1 = 0; l1 < imgWidth; l1++) {
				for (int i2 = 0; i2 < imgHeight; i2++) {
					imgPixels[l1 + i2 * imgWidth] = stream.getSignedByte();
				}

			}

		}
	}

	public void method356() {
		maxWidth /= 2;
		maxHeight /= 2;
		byte abyte0[] = new byte[maxWidth * maxHeight];
		int i = 0;

		for (int j = 0; j < imgHeight; j++) {
			for (int k = 0; k < imgWidth; k++) {
				abyte0[(k + xOffset >> 1) + (j + yOffset >> 1) * maxWidth] = imgPixels[i++];
			}
		}

		imgPixels = abyte0;
		imgWidth = maxWidth;
		imgHeight = maxHeight;
		xOffset = 0;
		yOffset = 0;
	}

	public void method357() {
		if (imgWidth == maxWidth && imgHeight == maxHeight) {
			return;
		}
		byte abyte0[] = new byte[maxWidth * maxHeight];
		int i = 0;
		for (int j = 0; j < imgHeight; j++) {
			for (int k = 0; k < imgWidth; k++) {
				abyte0[k + xOffset + (j + yOffset) * maxWidth] = imgPixels[i++];
			}

		}

		imgPixels = abyte0;
		imgWidth = maxWidth;
		imgHeight = maxHeight;
		xOffset = 0;
		yOffset = 0;
	}

	public void method360(int i, int j, int k) {
		for (int i1 = 0; i1 < palette.length; i1++) {
			int j1 = palette[i1] >> 16 & 0xff;
		j1 += i;
		if (j1 < 0) {
			j1 = 0;
		} else if (j1 > 255) {
			j1 = 255;
		}
		int k1 = palette[i1] >> 8 & 0xff;
		k1 += j;
		if (k1 < 0) {
			k1 = 0;
		} else if (k1 > 255) {
			k1 = 255;
		}
		int l1 = palette[i1] & 0xff;
		l1 += k;
		if (l1 < 0) {
			l1 = 0;
		} else if (l1 > 255) {
			l1 = 255;
		}
		palette[i1] = (j1 << 16) + (k1 << 8) + l1;
		}
	}

	public void method361(int i, int k) {
		i += xOffset;
		k += yOffset;
		int l = i + k * DrawingArea.width;
		int i1 = 0;
		int j1 = imgHeight;
		int k1 = imgWidth;
		int l1 = DrawingArea.width - k1;
		int i2 = 0;
		if (k < DrawingArea.topY) {
			int j2 = DrawingArea.topY - k;
			j1 -= j2;
			k = DrawingArea.topY;
			i1 += j2 * k1;
			l += j2 * DrawingArea.width;
		}
		if (k + j1 > DrawingArea.bottomY) {
			j1 -= k + j1 - DrawingArea.bottomY;
		}
		if (i < DrawingArea.topX) {
			int k2 = DrawingArea.topX - i;
			k1 -= k2;
			i = DrawingArea.topX;
			i1 += k2;
			l += k2;
			i2 += k2;
			l1 += k2;
		}
		if (i + k1 > DrawingArea.bottomX) {
			int l2 = i + k1 - DrawingArea.bottomX;
			k1 -= l2;
			i2 += l2;
			l1 += l2;
		}
		if (!(k1 <= 0 || j1 <= 0)) {
			method362(j1, DrawingArea.pixels, imgPixels, l1, l, k1, i1, palette, i2);
		}
	}

	private void method362(int i, int ai[], byte abyte0[], int j, int k, int l, int i1, int ai1[], int j1) {
		int k1 = -(l >> 2);
		l = -(l & 3);
		for (int l1 = -i; l1 < 0; l1++) {
			for (int i2 = k1; i2 < 0; i2++) {
				byte byte1 = abyte0[i1++];
				if (byte1 != 0) {
					ai[k++] = ai1[byte1 & 0xff];
				} else {
					k++;
				}
				byte1 = abyte0[i1++];
				if (byte1 != 0) {
					ai[k++] = ai1[byte1 & 0xff];
				} else {
					k++;
				}
				byte1 = abyte0[i1++];
				if (byte1 != 0) {
					ai[k++] = ai1[byte1 & 0xff];
				} else {
					k++;
				}
				byte1 = abyte0[i1++];
				if (byte1 != 0) {
					ai[k++] = ai1[byte1 & 0xff];
				} else {
					k++;
				}
			}

			for (int j2 = l; j2 < 0; j2++) {
				byte byte2 = abyte0[i1++];
				if (byte2 != 0) {
					ai[k++] = ai1[byte2 & 0xff];
				} else {
					k++;
				}
			}

			k += j;
			i1 += j1;
		}
	}

}