package org.necrotic.client.graphics.fonts;

import java.util.Random;

import org.necrotic.client.cache.Archive;
import org.necrotic.client.graphics.DrawingArea;
import org.necrotic.client.io.ByteBuffer;

public final class TextDrawingArea extends DrawingArea {

	public TextDrawingArea(boolean flag, String s, Archive streamLoader) {
		try {
			int length = (s.equals("hit_full") || s.equals("critical_full")) ? 58 : 256;
			aByteArrayArray1491 = new byte[length][];
			anIntArray1492 = new int[length];
			anIntArray1493 = new int[length];
			anIntArray1494 = new int[length];
			anIntArray1495 = new int[length];
			rsb = new int[length];
			aRandom1498 = new Random();
			aBoolean1499 = false;
			ByteBuffer stream = new ByteBuffer(streamLoader.get(s + ".dat"));
			ByteBuffer stream_1 = new ByteBuffer(streamLoader.get("index.dat"));
			stream_1.position = stream.getUnsignedShort() + 4;
			int k = stream_1.getUnsignedByte();
			if (k > 0)
				stream_1.position += 3 * (k - 1);
			for (int l = 0; l < length; l++) {
				anIntArray1494[l] = stream_1.getUnsignedByte();
				anIntArray1495[l] = stream_1.getUnsignedByte();
				int i1 = anIntArray1492[l] = stream_1.getUnsignedShort();
				int j1 = anIntArray1493[l] = stream_1.getUnsignedShort();
				int k1 = stream_1.getUnsignedByte();
				int l1 = i1 * j1;
				aByteArrayArray1491[l] = new byte[l1];
				if (k1 == 0) {
					for (int i2 = 0; i2 < l1; i2++)
						aByteArrayArray1491[l][i2] = stream.getSignedByte();

				} else if (k1 == 1) {
					for (int j2 = 0; j2 < i1; j2++) {
						for (int l2 = 0; l2 < j1; l2++)
							aByteArrayArray1491[l][j2 + l2 * i1] = stream.getSignedByte();
					}
				}
				if (j1 > anInt1497 && l < 128)
					anInt1497 = j1;
				anIntArray1494[l] = 1;
				rsb[l] = i1 + 2;
				int k2 = 0;
				for (int i3 = j1 / 7; i3 < j1; i3++)
					k2 += aByteArrayArray1491[l][i3 * i1];
				if (k2 <= j1 / 7) {
					rsb[l]--;
					anIntArray1494[l] = 0;
				}
				k2 = 0;
				for (int j3 = j1 / 7; j3 < j1; j3++)
					k2 += aByteArrayArray1491[l][(i1 - 1) + j3 * i1];
				if (k2 <= j1 / 7)
					rsb[l]--;
			}
			if (flag) {
				if(rsb.length > 73)
					rsb[32] = rsb[73];
			} else {
				if(rsb.length > 105)
					rsb[32] = rsb[105];
			}
		} catch (Exception _ex) {
			_ex.printStackTrace();
			System.out.println("Error loading font: "+s);
		}
	}

	public void method38(String s, int i, int j, int colour, boolean flag)
	{
		int l = getTextWidth(s) / 2;
		int i1 = method44();
		if(i - l > DrawingArea.bottomY)
			return;
		if(i + l < DrawingArea.topX)
			return;
		if(j - i1 > DrawingArea.bottomX)
			return;
		if(j < 0)
		{
			return;
		} else
		{
			drawText(colour, s, i-l, j);
			return;
		}
	}
	public int method40()
	{
		return rsb[8] - 1;
	}
	public int method44()
	{
		return rsb[6];
	}
	public void method380(String s, int i, int j, int k) {
		method385(j, s, k, i - method384(s));
	}

	public void drawText(int colour, String txt, int x, int y) {
		method385(colour, txt, x, y - method384(txt) / 2);
	}

	public void method591(String s, int i, int j, int k) {
		method385(j, s, k, i);
	}

	public void method592(int i, int j, String s, int l, boolean flag) {
		drawRegularText(flag, j, i, s, l);
	}

	public void setPixelsInfo(int width, int height, int transparancy, int newPixels[], byte oldPixels[], int newOffset, int oldOffset, int place1, int place2, int color) {
		color = ((color & 0xff00ff) * transparancy & 0xff00ff00) + ((color & 0xff00) * transparancy & 0xff0000) >> 8;
		transparancy = 256 - transparancy;
		for (int j2 = -height; j2 < 0; j2++) {
			for (int k2 = -width; k2 < 0; k2++) {
				if (oldPixels[oldOffset++] != 0) {
					int l2 = newPixels[newOffset];
					newPixels[newOffset++] = (((l2 & 0xff00ff) * transparancy & 0xff00ff00) + ((l2 & 0xff00) * transparancy & 0xff0000) >> 8) + color;
				} else {
					newOffset++;
				}
			}
			newOffset += place1;
			oldOffset += place2;
		}
	}

	private void drawChar(byte text[], int x, int y, int width, int height, int color, int opacity) {
		int newOffset = x + y * DrawingArea.width;
		int place1 = DrawingArea.width - width;
		int place2 = 0;
		int oldOffset = 0;
		if (y < DrawingArea.topY) {
			int Height2 = DrawingArea.topY - y;
			height -= Height2;
			y = DrawingArea.topY;
			oldOffset += Height2 * width;
			newOffset += Height2 * DrawingArea.width;
		}
		if (y + height >= DrawingArea.bottomY) {
			height -= ((y + height) - DrawingArea.bottomY);
		}
		if (x < DrawingArea.topX) {
			int toLeft = DrawingArea.topX - x;
			width -= toLeft;
			x = DrawingArea.topX;
			oldOffset += toLeft;
			newOffset += toLeft;
			place2 += toLeft;
			place1 += toLeft;
		}
		if (x + width >= DrawingArea.bottomX) {
			int toRight = ((x + width) - DrawingArea.bottomX);
			width -= toRight;
			place2 += toRight;
			place1 += toRight;
		}
		if ((width <= 0) || (height <= 0)) {
			return;
		}
		setPixelsInfo(width, height, opacity, DrawingArea.pixels, text, newOffset, oldOffset, place1, place2, color);
	}

	public void drawTransparentText(int i, String s, int j, int k, int l, int opacity) {
		if (s == null)
			return;
		j -= anInt1497;
		for (int i1 = 0; i1 < s.length(); i1++) {
			char c = s.charAt(i1);
			if (c != ' ')
				drawChar(aByteArrayArray1491[c], l + anIntArray1494[c], j + anIntArray1495[c], anIntArray1492[c], anIntArray1493[c], i, opacity);
			l += rsb[c];
		}
		k = 50 / k;
	}

	public void drawOpacityText(int color, String text, int yCoord, int xCoord, int alpha) {
		drawTransparentText(color, text, yCoord, 822, xCoord - method384(text) / 2, alpha);
	}

	public void drawCenteredText(int colour, int x, String text, int y, boolean center) {
		drawRegularText(center, x - getTextWidth(text) / 2, colour, text, y);
	}

	public void drawChatInput(int i, int j, String s, int l, boolean flag) {
		drawRegularText(flag, j, i, s, l);
	}

	public int getTextWidth(String s) {
		if (s == null)
			return 0;
		int j = 0;
		for (int k = 0; k < s.length(); k++)
			if (s.charAt(k) == '@' && k + 4 < s.length() && s.charAt(k + 4) == '@')
				k += 4;
			else
				j += rsb[s.charAt(k)];
		return j;
	}

	public int charFor(int i, String s) {
		int j = 0;
		for (int k = 0; k < s.length(); k++) {
			if (s.charAt(k) == '@' && k + 4 < s.length() && s.charAt(k + 4) == '@')
				k += 4;
			else
				j += rsb[s.charAt(k)];
			if (j >= i - 4 && j <= i + 4) {
				return j;
			}
		}
		return j;
	}

	public int method384(String s) {
		if (s == null)
			return 0;
		int j = 0;
		for (int k = 0; k < s.length(); k++)
			j += rsb[s.charAt(k)];
		return j;
	}

	public void method385(int i, String text, int j, int l) {
		if (text == null)
			return;
		j -= anInt1497;
		for (int i1 = 0; i1 < text.length(); i1++) {
			char c = text.charAt(i1);
			if (c != ' ')
				method392(aByteArrayArray1491[c], l + anIntArray1494[c], j + anIntArray1495[c], anIntArray1492[c], anIntArray1493[c], i);
			l += rsb[c];
		}
	}

	public void method386(int i, String s, int j, int k, int l) {
		if (s == null)
			return;
		j -= method384(s) / 2;
		l -= anInt1497;
		for (int i1 = 0; i1 < s.length(); i1++) {
			char c = s.charAt(i1);
			if (c != ' ')
				method392(aByteArrayArray1491[c], j + anIntArray1494[c], l + anIntArray1495[c] + (int) (Math.sin((double) i1 / 2D + (double) k / 5D) * 5D), anIntArray1492[c], anIntArray1493[c], i);
			j += rsb[c];
		}
	}

	public void method387(int i, String s, int j, int k, int l) {
		if (s == null)
			return;
		i -= method384(s) / 2;
		k -= anInt1497;
		for (int i1 = 0; i1 < s.length(); i1++) {
			char c = s.charAt(i1);
			if (c != ' ')
				method392(aByteArrayArray1491[c], i + anIntArray1494[c] + (int) (Math.sin((double) i1 / 5D + (double) j / 5D) * 5D), k + anIntArray1495[c] + (int) (Math.sin((double) i1 / 3D + (double) j / 5D) * 5D), anIntArray1492[c], anIntArray1493[c], l);
			i += rsb[c];
		}
	}

	public void method388(int i, String s, int j, int k, int l, int i1) {
		if (s == null)
			return;
		double d = 7D - (double) i / 8D;
		if (d < 0.0D)
			d = 0.0D;
		l -= method384(s) / 2;
		k -= anInt1497;
		for (int k1 = 0; k1 < s.length(); k1++) {
			char c = s.charAt(k1);
			if (c != ' ')
				method392(aByteArrayArray1491[c], l + anIntArray1494[c], k + anIntArray1495[c] + (int) (Math.sin((double) k1 / 1.5D + (double) j) * d), anIntArray1492[c], anIntArray1493[c], i1);
			l += rsb[c];
		}
	}

	public void drawRegularText(boolean flag1, int i, int j, String s, int k) {
		aBoolean1499 = false;
		int l = i;
		if (s == null)
			return;
		k -= anInt1497;
		for (int i1 = 0; i1 < s.length(); i1++)
			if (s.charAt(i1) == '@' && i1 + 4 < s.length() && s.charAt(i1 + 4) == '@') {
				int j1 = getColorByName(s.substring(i1 + 1, i1 + 4));
				if (j1 != -1)
					j = j1;
				i1 += 4;
			} else {
				char c = s.charAt(i1);
				if (c != ' ') {
					if (flag1)
						method392(aByteArrayArray1491[c], i + anIntArray1494[c] + 1, k + anIntArray1495[c] + 1, anIntArray1492[c], anIntArray1493[c], 0);
					method392(aByteArrayArray1491[c], i + anIntArray1494[c], k + anIntArray1495[c], anIntArray1492[c], anIntArray1493[c], j);
				}
				i += rsb[c];
			}
		if (aBoolean1499)
			DrawingArea.drawHorizontalLine(k + (int) ((double) anInt1497 * 0.69999999999999996D), 0x800000, i - l, l);
	}

	public void method390(int i, int j, String s, int k, int i1) {
		if (s == null)
			return;
		aRandom1498.setSeed(k);
		int j1 = 192 + (aRandom1498.nextInt() & 0x1f);
		i1 -= anInt1497;
		for (int k1 = 0; k1 < s.length(); k1++)
			if (s.charAt(k1) == '@' && k1 + 4 < s.length() && s.charAt(k1 + 4) == '@') {
				int l1 = getColorByName(s.substring(k1 + 1, k1 + 4));
				if (l1 != -1)
					j = l1;
				k1 += 4;
			} else {
				char c = s.charAt(k1);
				if (c != ' ') {
					method394(192, i + anIntArray1494[c] + 1, aByteArrayArray1491[c], anIntArray1492[c], i1 + anIntArray1495[c] + 1, anIntArray1493[c], 0);
					method394(j1, i + anIntArray1494[c], aByteArrayArray1491[c], anIntArray1492[c], i1 + anIntArray1495[c], anIntArray1493[c], j);
				}
				i += rsb[c];
				if ((aRandom1498.nextInt() & 3) == 0)
					i++;
			}
	}

	private int getColorByName(String s) {
		if (s.equals("369"))// color code, use as @###@
			return 0x336699;// hex code
		if (s.equals("mon"))
			return 0x00ff80;
		if (s.equals("red"))
			return 0xff0000;
		if (s.equals("gre"))
			return 65280;
		if (s.equals("blu"))
			return 255;
		if (s.equals("yel"))
			return 0xffff00;
		if (s.equals("cya"))
			return 65535;
		if (s.equals("mag"))
			return 0xff00ff;
		if (s.equals("whi"))
			return 0xffffff;
		if (s.equals("bla"))
			return 0;
		if (s.equals("lre"))
			return 0xff9040;
		if (s.equals("dre"))
			return 0x800000;
		if (s.equals("dbl"))
			return 128;
		if (s.equals("or1"))
			return 0xffb000;
		if (s.equals("or2"))
			return 0xff7000;
		if (s.equals("or3"))
			return 0xff3000;
		if (s.equals("gr1"))
			return 0xc0ff00;
		if (s.equals("gr2"))
			return 0x80ff00;
		if (s.equals("gr3"))
			return 0x40ff00;
		if (s.equals("str"))
			aBoolean1499 = true;
		if (s.equals("end"))
			aBoolean1499 = false;
		return -1;
	}

	private void method392(byte abyte0[], int i, int j, int k, int l, int i1) {
		int j1 = i + j * DrawingArea.width;
		int k1 = DrawingArea.width - k;
		int l1 = 0;
		int i2 = 0;
		if (j < DrawingArea.topY) {
			int j2 = DrawingArea.topY - j;
			l -= j2;
			j = DrawingArea.topY;
			i2 += j2 * k;
			j1 += j2 * DrawingArea.width;
		}
		if (j + l >= DrawingArea.bottomY)
			l -= ((j + l) - DrawingArea.bottomY) + 1;
		if (i < DrawingArea.topX) {
			int k2 = DrawingArea.topX - i;
			k -= k2;
			i = DrawingArea.topX;
			i2 += k2;
			j1 += k2;
			l1 += k2;
			k1 += k2;
		}
		if (i + k >= DrawingArea.bottomX) {
			int l2 = ((i + k) - DrawingArea.bottomX) + 1;
			k -= l2;
			l1 += l2;
			k1 += l2;
		}
		if (!(k <= 0 || l <= 0)) {
			method393(DrawingArea.pixels, abyte0, i1, i2, j1, k, l, k1, l1);
		}
	}

	private void method393(int ai[], byte abyte0[], int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1 = -(l >> 2);
		l = -(l & 3);
		for (int i2 = -i1; i2 < 0; i2++) {
			for (int j2 = l1; j2 < 0; j2++) {
				if (abyte0[j++] != 0)
					ai[k++] = i;
				else
					k++;
				if (abyte0[j++] != 0)
					ai[k++] = i;
				else
					k++;
				if (abyte0[j++] != 0)
					ai[k++] = i;
				else
					k++;
				if (abyte0[j++] != 0)
					ai[k++] = i;
				else
					k++;
			}
			for (int k2 = l; k2 < 0; k2++)
				if (abyte0[j++] != 0)
					ai[k++] = i;
				else
					k++;

			k += j1;
			j += k1;
		}
	}

	private void method394(int i, int j, byte abyte0[], int k, int l, int i1, int j1) {
		int k1 = j + l * DrawingArea.width;
		int l1 = DrawingArea.width - k;
		int i2 = 0;
		int j2 = 0;
		if (l < DrawingArea.topY) {
			int k2 = DrawingArea.topY - l;
			i1 -= k2;
			l = DrawingArea.topY;
			j2 += k2 * k;
			k1 += k2 * DrawingArea.width;
		}
		if (l + i1 >= DrawingArea.bottomY)
			i1 -= ((l + i1) - DrawingArea.bottomY) + 1;
		if (j < DrawingArea.topX) {
			int l2 = DrawingArea.topX - j;
			k -= l2;
			j = DrawingArea.topX;
			j2 += l2;
			k1 += l2;
			i2 += l2;
			l1 += l2;
		}
		if (j + k >= DrawingArea.bottomX) {
			int i3 = ((j + k) - DrawingArea.bottomX) + 1;
			k -= i3;
			i2 += i3;
			l1 += i3;
		}
		if (k <= 0 || i1 <= 0)
			return;
		method395(abyte0, i1, k1, DrawingArea.pixels, j2, k, i2, l1, j1, i);
	}

	private void method395(byte abyte0[], int i, int j, int ai[], int l, int i1, int j1, int k1, int l1, int i2) {
		l1 = ((l1 & 0xff00ff) * i2 & 0xff00ff00) + ((l1 & 0xff00) * i2 & 0xff0000) >> 8;
		i2 = 256 - i2;
		for (int j2 = -i; j2 < 0; j2++) {
			for (int k2 = -i1; k2 < 0; k2++)
				if (abyte0[l++] != 0) {
					int l2 = ai[j];
					ai[j++] = (((l2 & 0xff00ff) * i2 & 0xff00ff00) + ((l2 & 0xff00) * i2 & 0xff0000) >> 8) + l1;
				} else {
					j++;
				}
			j += k1;
			l += j1;
		}
	}

	public byte[][] aByteArrayArray1491;
	public int[] anIntArray1492;
	public int[] anIntArray1493;
	public int[] anIntArray1494;
	public int[] anIntArray1495;
	public int[] rsb;
	public int anInt1497;
	public Random aRandom1498;
	public boolean aBoolean1499;
	public static void drawAlphaFilledPixels(int xPos, int yPos,
			int pixelWidth, int pixelHeight, int color, int alpha) {// method586
		if (xPos < topX) {
			pixelWidth -= topX - xPos;
			xPos = topX;
		}
		if (yPos < topY) {
			pixelHeight -= topY - yPos;
			yPos = topY;
		}
		if (xPos + pixelWidth > bottomX)
			pixelWidth = bottomX - xPos;
		if (yPos + pixelHeight > bottomY)
			pixelHeight = bottomY - yPos;
		color = ((color & 0xff00ff) * alpha >> 8 & 0xff00ff)
				+ ((color & 0xff00) * alpha >> 8 & 0xff00);
		int k1 = 256 - alpha;
		int l1 = width - pixelWidth;
		int i2 = xPos + yPos * width;
		for (int j2 = 0; j2 < pixelHeight; j2++) {
			for (int k2 = -pixelWidth; k2 < 0; k2++) {
				int l2 = pixels[i2];
				l2 = ((l2 & 0xff00ff) * k1 >> 8 & 0xff00ff)
						+ ((l2 & 0xff00) * k1 >> 8 & 0xff00);
				pixels[i2++] = color + l2;
			}
			i2 += l1;
		}
	}
}
