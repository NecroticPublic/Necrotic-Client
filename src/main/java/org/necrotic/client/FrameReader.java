package org.necrotic.client;

import org.necrotic.client.io.ByteBuffer;

public final class FrameReader {

	public static void initialise(int i) {
		animationlist = new FrameReader[5000][0];
	}

	public static void load(int file, byte[] fileData) {
		try {
		//	System.out.println("Loading file: "+file);
			ByteBuffer stream = new ByteBuffer(fileData);
			SkinList skinList = new SkinList(stream);
			int k1 = stream.getUnsignedShort();
			animationlist[file] = new FrameReader[(int) (k1 * 3)];
			int ai[] = new int[500];
			int ai1[] = new int[500];
			int ai2[] = new int[500];
			int ai3[] = new int[500];
			for (int l1 = 0; l1 < k1; l1++) {
				int i2 = stream.getUnsignedShort();
				FrameReader frameReader = animationlist[file][i2] = new FrameReader();
					
				frameReader.skinList = skinList;
				int j2 = stream.getUnsignedByte();
				int l2 = 0;
				int k2 = -1;
				for (int i3 = 0; i3 < j2; i3++) {
					int j3 = stream.getUnsignedByte();
					if (j3 > 0) {
						if (skinList.opcodes[i3] != 0) {
							for (int l3 = i3 - 1; l3 > k2; l3--) {
								if (skinList.opcodes[l3] != 0)
									continue;
								ai[l2] = l3;
								ai1[l2] = 0;
								ai2[l2] = 0;
								ai3[l2] = 0;
								l2++;
								break;
							}

						}
						ai[l2] = i3;
						short c = 0;
						if (skinList.opcodes[i3] == 3)
							c = (short) 128;

						if ((j3 & 1) != 0)
							ai1[l2] = (short) stream.getShort2();
						else
							ai1[l2] = c;
						if ((j3 & 2) != 0)
							ai2[l2] = stream.getShort2();
						else
							ai2[l2] = c;
						if ((j3 & 4) != 0)
							ai3[l2] = stream.getShort2();
						else
							ai3[l2] = c;
						k2 = i3;
						l2++;
					}
				}

				frameReader.stepCount = l2;
				frameReader.opcodeLinkTable = new int[l2];
				frameReader.xOffset = new int[l2];
				frameReader.yOffset = new int[l2];
				frameReader.zOffset = new int[l2];
				for (int k3 = 0; k3 < l2; k3++) {
					frameReader.opcodeLinkTable[k3] = ai[k3];
					frameReader.xOffset[k3] = ai1[k3];
					frameReader.yOffset[k3] = ai2[k3];
					frameReader.zOffset[k3] = ai3[k3];
				}

			}
		} catch (Exception exception) {
			//exception.printStackTrace();
		}
	}

	public static void nullify() {
		animationlist = null;
	}

	public static FrameReader forId(int i) {
		try {
			String s = "";
			int file = 0;
			int k = 0;
			s = Integer.toHexString(i);
			file = Integer.parseInt(s.substring(0, s.length() - 4), 16);
			k = Integer.parseInt(s.substring(s.length() - 4), 16);
			//System.out.println("Animation file: "+file+".gz");
			if (animationlist[file].length == 0) {
				Client.instance.onDemandFetcher.requestFileData(1, file);
				return null;
			}
			return animationlist[file][k];
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static FrameReader getTween(FrameReader f1, FrameReader f2)
	{
		FrameReader newFrame = new FrameReader();
		newFrame.displayLength = f1.displayLength;
		newFrame.stepCount = f1.stepCount;
		newFrame.opcodeLinkTable = f1.opcodeLinkTable;
		newFrame.xOffset = new int[f1.xOffset.length];
		newFrame.skinList = f1.skinList;
		for(int i = 0; i < f1.xOffset.length; i++)
		{
			try {
			int middleXOffset = (f2.xOffset[i]-f1.xOffset[i])/2+ f1.xOffset[i];
			newFrame.xOffset[i] = middleXOffset;
			} catch(Exception e)
			{
				newFrame.xOffset[i] = f1.xOffset[i];
			}
		}
		newFrame.yOffset = new int[f1.yOffset.length];
		for(int i = 0; i < f1.yOffset.length; i++)
		{
			try {
			int middleYOffset = (f2.yOffset[i]-f1.yOffset[i])/2+ f1.yOffset[i];
			newFrame.yOffset[i] = middleYOffset;
		} catch(Exception e)
		{
			newFrame.yOffset[i] = f1.yOffset[i];
		}
			
		}
		newFrame.zOffset = new int[f1.zOffset.length];
		for(int i = 0; i < f1.zOffset.length; i++)
		{
			try {
			int middleZOffset = (f2.zOffset[i]-f1.zOffset[i])/2 + f1.zOffset[i];
			newFrame.zOffset[i] = middleZOffset;

			} catch(Exception e)
			{
				newFrame.zOffset[i] = f1.zOffset[i];
			}
			
		}
		return newFrame;
	}
	
	public static boolean isNullFrame(int frame) {
		return frame == -1;
	}

	private FrameReader() {
	}

	public static FrameReader animationlist[][];
	public int displayLength;
	public SkinList skinList;
	public int stepCount;
	public static byte[][] frameData = null;
	public static byte[][] skinData = null;
	public int opcodeLinkTable[];
	public int xOffset[];
	public int yOffset[];
	public int zOffset[];
}
