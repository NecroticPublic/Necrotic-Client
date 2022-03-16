package org.necrotic.client.graphics;

import org.necrotic.client.cache.node.NodeSub;

public class DrawingArea extends NodeSub {

	public static int pixels[];
	public static int width;
	public static int height;
	public static int topY;
	public static int bottomY;
	public static int topX;
	public static int bottomX;
	public static int centerX;
	public static int centerY;
	public static int middleY;
	
	public static void drawLine(int yPos, int color, int widthToDraw, int xPos)
	{
		if(yPos < topY || yPos >= bottomY)
			return;
		if(xPos < topX)
		{
			widthToDraw -= topX - xPos;
			xPos = topX;
		}
		if(xPos + widthToDraw > bottomX)
			widthToDraw = bottomX - xPos;
		int base = xPos + yPos * width;
		for(int ptr = 0; ptr < widthToDraw; ptr++)
			pixels[base + ptr] = color;

	}
	
	public static void setDrawingArea(int yBottom, int xTop, int xBottom, int yTop)
	{
		if(xTop < 0)
			xTop = 0;
		if(yTop < 0)
			yTop = 0;
		if(xBottom > width)
			xBottom = width;
		if(yBottom > height)
			yBottom = height;
		topX = xTop;
		topY = yTop;
		bottomX = xBottom;
		bottomY = yBottom;
		//viewportRX = bottomX - 0;
	//	viewport_centerX = bottomX / 2;
		//viewport_centerY = bottomY / 2;
	}
	
	public static void transparentBox(int i, int j, int k, int l, int i1, int j1, int opac) {
		int j3 = 256 - opac;
		if (k < topX) {
			i1 -= topX - k;
			k = topX;
		}
		if (j < topY) {
			i -= topY - j;
			j = topY;
		}
		if (k + i1 > bottomX) {
			i1 = bottomX - k;
		}
		if (j + i > bottomY) {
			i = bottomY - j;
		}
		int k1 = width - i1;
		int l1 = k + j * width;
		for (int i2 = -i; i2 < 0; i2++) {
			for (int j2 = -i1; j2 < 0; j2++) {
				int i3 = pixels[l1];
				pixels[l1++] = ((l & 0xff00ff) * opac + (i3 & 0xff00ff) * j3 & 0xff00ff00) + ((l & 0xff00) * opac + (i3 & 0xff00) * j3 & 0xff0000) >> 8;
			}
			l1 += k1;
		}

	}

	public static void defaultDrawingAreaSize() {
		topX = 0;
		topY = 0;
		bottomX = width;
		bottomY = height;
		centerX = bottomX - 0;
		centerY = bottomX / 2;
	}

	public static void drawAlphaGradient(int x, int y, int gradientWidth, int gradientHeight, int startColor, int endColor, int alpha) {
		int k1 = 0;
		int l1 = 0x10000 / gradientHeight;
		if (x < topX) {
			gradientWidth -= topX - x;
			x = topX;
		}
		if (y < topY) {
			k1 += (topY - y) * l1;
			gradientHeight -= topY - y;
			y = topY;
		}
		if (x + gradientWidth > bottomX) {
			gradientWidth = bottomX - x;
		}
		if (y + gradientHeight > bottomY) {
			gradientHeight = bottomY - y;
		}
		int i2 = width - gradientWidth;
		int result_alpha = 256 - alpha;
		int total_pixels = x + y * width;
		for (int k2 = -gradientHeight; k2 < 0; k2++) {
			int gradient1 = 0x10000 - k1 >> 8;
		int gradient2 = k1 >> 8;
		int gradient_color = ((startColor & 0xff00ff) * gradient1 + (endColor & 0xff00ff) * gradient2 & 0xff00ff00) + ((startColor & 0xff00) * gradient1 + (endColor & 0xff00) * gradient2 & 0xff0000) >>> 8;
		int color = ((gradient_color & 0xff00ff) * alpha >> 8 & 0xff00ff) + ((gradient_color & 0xff00) * alpha >> 8 & 0xff00);
		for (int k3 = -gradientWidth; k3 < 0; k3++) {
			int pixel_pixels = pixels[total_pixels];
			pixel_pixels = ((pixel_pixels & 0xff00ff) * result_alpha >> 8 & 0xff00ff) + ((pixel_pixels & 0xff00) * result_alpha >> 8 & 0xff00);
			pixels[total_pixels++] = color + pixel_pixels;
		}
		total_pixels += i2;
		k1 += l1;
		}
	}

	public static void drawFilledPixels(int x, int y, int pixelWidth, int pixelHeight, int color) {// method578
		if (x < topX) {
			pixelWidth -= topX - x;
			x = topX;
		}
		if (y < topY) {
			pixelHeight -= topY - y;
			y = topY;
		}
		if (x + pixelWidth > bottomX) {
			pixelWidth = bottomX - x;
		}
		if (y + pixelHeight > bottomY) {
			pixelHeight = bottomY - y;
		}
		int j1 = width - pixelWidth;
		int k1 = x + y * width;
		for (int l1 = -pixelHeight; l1 < 0; l1++) {
			for (int i2 = -pixelWidth; i2 < 0; i2++) {
				pixels[k1++] = color;
			}
			k1 += j1;
		}
	}

	public static void drawHorizontalLine(int i, int j, int k, int l) {
		if (i < topY || i >= bottomY) {
			return;
		}
		if (l < topX) {
			k -= topX - l;
			l = topX;
		}
		if (l + k > bottomX) {
			k = bottomX - l;
		}
		int i1 = l + i * width;
		for (int j1 = 0; j1 < k; j1++) {
			pixels[i1 + j1] = j;
		}

	}

	public static void drawPixels(int height, int posY, int posX, int color, int width) {
		if (posX < topX) {
			width -= topX - posX;
			posX = topX;
		}
		if (posY < topY) {
			height -= topY - posY;
			posY = topY;
		}
		if (posX + width > bottomX) {
			width = bottomX - posX;
		}
		if (posY + height > bottomY) {
			height = bottomY - posY;
		}
		int k1 = DrawingArea.width - width;
		int l1 = posX + posY * DrawingArea.width;
		for (int i2 = -height; i2 < 0; i2++) {
			for (int j2 = -width; j2 < 0; j2++) {
				pixels[l1++] = color;
			}

			l1 += k1;
		}

	}

	public static void fillPixels(int offSetX, int width, int height, int l, int offSetY) {
		drawHorizontalLine(offSetY, l, width, offSetX);
		drawHorizontalLine(offSetY + height - 1, l, width, offSetX);
		method341(offSetY, l, height, offSetX);
		method341(offSetY, l, height, offSetX + width - 1);
	}

	public static void fillRect(int xPos, int yPos, int areaWidth, int areaHeight, int color, int transparency) {
		if (xPos < topX) {
			areaWidth -= topX - xPos;
			xPos = topX;
		}
		if (yPos < topY) {
			areaHeight -= topY - yPos;
			yPos = topY;
		}
		if (xPos + areaWidth > bottomX) {
			areaWidth = bottomX - xPos;
		}
		if (yPos + areaHeight > bottomY) {
			areaHeight = bottomY - yPos;
		}
		int opacity = 256 - transparency;
		int red = (color >> 16 & 0xff) * transparency;
		int green = (color >> 8 & 0xff) * transparency;
		int blue = (color & 0xff) * transparency;
		int xOffset = width - areaWidth;
		int pixel = xPos + yPos * width;
		for (int y = 0; y < areaHeight; y++) {
			for (int x = -areaWidth; x < 0; x++) {
				int originRed = (pixels[pixel] >> 16 & 0xff) * opacity;
				int originGreen = (pixels[pixel] >> 8 & 0xff) * opacity;
				int oritinBlue = (pixels[pixel] & 0xff) * opacity;
				int blindedColor = (red + originRed >> 8 << 16) + (green + originGreen >> 8 << 8) + (blue + oritinBlue >> 8);
				pixels[pixel++] = blindedColor;
			}

			pixel += xOffset;
		}
	}

	public static void initDrawingArea(int h, int w, int ai[]) {
		pixels = ai;
		width = w;
		height = h;
		setBounds(0, 0, w, h);
	}

	public static void method335(int i, int j, int k, int l, int i1, int k1) {
		if (k1 < topX) {
			k -= topX - k1;
			k1 = topX;
		}
		if (j < topY) {
			l -= topY - j;
			j = topY;
		}
		if (k1 + k > bottomX) {
			k = bottomX - k1;
		}
		if (j + l > bottomY) {
			l = bottomY - j;
		}
		int l1 = 256 - i1;
		int i2 = (i >> 16 & 0xff) * i1;
		int j2 = (i >> 8 & 0xff) * i1;
		int k2 = (i & 0xff) * i1;
		int k3 = width - k;
		int l3 = k1 + j * width;
		for (int i4 = 0; i4 < l; i4++) {
			for (int j4 = -k; j4 < 0; j4++) {
				int l2 = (pixels[l3] >> 16 & 0xff) * l1;
				int i3 = (pixels[l3] >> 8 & 0xff) * l1;
				int j3 = (pixels[l3] & 0xff) * l1;
				int k4 = (i2 + l2 >> 8 << 16) + (j2 + i3 >> 8 << 8) + (k2 + j3 >> 8);
				pixels[l3++] = k4;
			}

			l3 += k3;
		}
	}

	public static void method338(int i, int j, int k, int l, int i1, int j1) {
		method340(l, i1, i, k, j1);
		method340(l, i1, i + j - 1, k, j1);

		if (j >= 3) {
			method342(l, j1, k, i + 1, j - 2);
			method342(l, j1 + i1 - 1, k, i + 1, j - 2);
		}
	}

	private static void method340(int i, int j, int k, int l, int i1) {
		if (k < topY || k >= bottomY) {
			return;
		}
		if (i1 < topX) {
			j -= topX - i1;
			i1 = topX;
		}
		if (i1 + j > bottomX) {
			j = bottomX - i1;
		}
		int j1 = 256 - l;
		int k1 = (i >> 16 & 0xff) * l;
		int l1 = (i >> 8 & 0xff) * l;
		int i2 = (i & 0xff) * l;
		int i3 = i1 + k * width;
		for (int j3 = 0; j3 < j; j3++) {
			int j2 = (pixels[i3] >> 16 & 0xff) * j1;
			int k2 = (pixels[i3] >> 8 & 0xff) * j1;
			int l2 = (pixels[i3] & 0xff) * j1;
			int k3 = (k1 + j2 >> 8 << 16) + (l1 + k2 >> 8 << 8) + (i2 + l2 >> 8);
			pixels[i3++] = k3;
		}

	}

	private static void method341(int i, int j, int k, int l) {
		if (l < topX || l >= bottomX) {
			return;
		}
		if (i < topY) {
			k -= topY - i;
			i = topY;
		}
		if (i + k > bottomY) {
			k = bottomY - i;
		}
		int j1 = l + i * width;
		for (int k1 = 0; k1 < k; k1++) {
			pixels[j1 + k1 * width] = j;
		}

	}

	private static void method342(int i, int j, int k, int l, int i1) {
		if (j < topX || j >= bottomX) {
			return;
		}
		if (l < topY) {
			i1 -= topY - l;
			l = topY;
		}
		if (l + i1 > bottomY) {
			i1 = bottomY - l;
		}
		int j1 = 256 - k;
		int k1 = (i >> 16 & 0xff) * k;
		int l1 = (i >> 8 & 0xff) * k;
		int i2 = (i & 0xff) * k;
		int i3 = j + l * width;
		for (int j3 = 0; j3 < i1; j3++) {
			int j2 = (pixels[i3] >> 16 & 0xff) * j1;
			int k2 = (pixels[i3] >> 8 & 0xff) * j1;
			int l2 = (pixels[i3] & 0xff) * j1;
			int k3 = (k1 + j2 >> 8 << 16) + (l1 + k2 >> 8 << 8) + (i2 + l2 >> 8);
			pixels[i3] = k3;
			i3 += width;
		}

	}

	public static void setAllPixelsToZero() {
		int i = width * height;
		for (int j = 0; j < i; j++) {
			pixels[j] = 0;
		}

	}

	public static void setBounds(int posX, int posY, int width, int height) {
		if (posX < 0) {
			posX = 0;
		}

		if (posY < 0) {
			posY = 0;
		}

		if (width > DrawingArea.width) {
			width = DrawingArea.width;
		}

		if (height > DrawingArea.height) {
			height = DrawingArea.height;
		}

		DrawingArea.topX = posX;
		DrawingArea.topY = posY;
		DrawingArea.bottomX = width;
		DrawingArea.bottomY = height;
		DrawingArea.centerX = bottomX - 0;
		DrawingArea.centerY = bottomX / 2;
		middleY = bottomY / 2;
	}

	public DrawingArea() {
	}

}