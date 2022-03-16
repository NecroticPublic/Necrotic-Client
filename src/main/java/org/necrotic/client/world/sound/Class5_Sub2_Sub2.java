package org.necrotic.client.world.sound;

/*
 * Class5_Sub2_Sub2 - Decompiled by JODE Visit http://jode.sourceforge.net/
 */
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public final class Class5_Sub2_Sub2 extends Class5_Sub2 {

	private static Class<?> method504(String string) {
		Class<?> var_class = null;

		try {
			var_class = Class.forName(string);
		} catch (ClassNotFoundException classnotfoundexception) {
			try {
				throw new NoClassDefFoundError().initCause(classnotfoundexception);
			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
		}

		return var_class;
	}

	private final AudioFormat anAudioFormat1846;
	private SourceDataLine aSourceDataLine1847;
	private final byte[] aByteArray1848 = new byte[512];
	private static Class<?> aClass1849;

	public Class5_Sub2_Sub2() throws Exception {
		super(22050);
		anAudioFormat1846 = new AudioFormat(22050.0F, 16, 1, true, false);
	}

	@Override
	final int avail() {
		return aSourceDataLine1847.available() >> 1;
	}

	@Override
	final void close() {
		if (aSourceDataLine1847 != null) {
			aSourceDataLine1847.close();
			aSourceDataLine1847 = null;
		}
	}

	@Override
	final void method494(int i) throws LineUnavailableException {
		try {
			DataLine.Info info = new DataLine.Info(aClass1849 == null ? (aClass1849 = method504("javax.sound.sampled.SourceDataLine")) : aClass1849, anAudioFormat1846, i * 2);
			aSourceDataLine1847 = (SourceDataLine) AudioSystem.getLine(info);
			aSourceDataLine1847.open();
			aSourceDataLine1847.start();
		} catch (LineUnavailableException lineunavailableexception) {
			aSourceDataLine1847 = null;
			throw lineunavailableexception;
		}
	}

	@Override
	final void write() {
		for (int i = 0; i < 256; i++) {
			int i_0_ = anIntArray1317[i];

			if ((i_0_ + 8388608 & ~0xffffff) != 0) {
				i_0_ = 0x7fffff ^ i_0_ >> 31;
			}

			aByteArray1848[i * 2] = (byte) (i_0_ >> 8);
			aByteArray1848[i * 2 + 1] = (byte) (i_0_ >> 16);
		}

		aSourceDataLine1847.write(aByteArray1848, 0, 512);
	}

}