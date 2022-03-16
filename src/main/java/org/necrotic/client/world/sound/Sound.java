package org.necrotic.client.world.sound;

import org.necrotic.client.io.ByteBuffer;

public final class Sound {

	private int anInt482;
	private int anInt483;
	private final Soundtrack[] aClass22Array484;
	public static Sound[] cache = new Sound[5000];

	public static void unpack(ByteBuffer stream) {
		do {
			int j = stream.getUnsignedShort();
			if (j == 65535) {
				return;
			}
			cache[j] = new Sound(stream);
		} while (true);
	}

	public Sound() {
		aClass22Array484 = new Soundtrack[10];
	}

	private Sound(ByteBuffer class3_sub12) {
		aClass22Array484 = new Soundtrack[10];
		for (int i = 0; i < 10; i++) {
			int i_11_ = class3_sub12.getUnsignedByte();
			if (i_11_ != 0) {
				class3_sub12.position--;
				aClass22Array484[i] = new Soundtrack();
				aClass22Array484[i].method626(class3_sub12);
			}
		}
		anInt483 = class3_sub12.getUnsignedShort();
		anInt482 = class3_sub12.getUnsignedShort();
	}

	/*
	 * static final Sound method653(FileSystem class18, int i, int i_2_) {
	 * byte[] is = class18.getFile(i, i_2_); if (is == null) return null; return
	 * new Sound(new Stream(is)); }
	 */

	public final Class3_Sub9_Sub1 method651() {
		byte[] is = method654();
		return new Class3_Sub9_Sub1(22050, is, anInt483 * 22050 / 1000, anInt482 * 22050 / 1000);
	}

	public final int method652() {
		int i = 9999999;
		for (int i_0_ = 0; i_0_ < 10; i_0_++) {
			if (aClass22Array484[i_0_] != null && aClass22Array484[i_0_].anInt400 / 20 < i) {
				i = aClass22Array484[i_0_].anInt400 / 20;
			}
		}
		if (anInt483 < anInt482 && anInt483 / 20 < i) {
			i = anInt483 / 20;
		}
		if (i == 9999999 || i == 0) {
			return 0;
		}
		for (int i_1_ = 0; i_1_ < 10; i_1_++) {
			if (aClass22Array484[i_1_] != null) {
				aClass22Array484[i_1_].anInt400 -= i * 20;
			}
		}
		if (anInt483 < anInt482) {
			anInt483 -= i * 20;
			anInt482 -= i * 20;
		}
		return i;
	}

	private final byte[] method654() {
		int i = 0;
		for (int i_3_ = 0; i_3_ < 10; i_3_++) {
			if (aClass22Array484[i_3_] != null && aClass22Array484[i_3_].anInt408 + aClass22Array484[i_3_].anInt400 > i) {
				i = aClass22Array484[i_3_].anInt408 + aClass22Array484[i_3_].anInt400;
			}
		}
		if (i == 0) {
			return new byte[0];
		}
		int i_4_ = i * 22050 / 1000;
		byte[] is = new byte[i_4_];
		for (int i_5_ = 0; i_5_ < 10; i_5_++) {
			if (aClass22Array484[i_5_] != null) {
				int i_6_ = aClass22Array484[i_5_].anInt408 * 22050 / 1000;
				int i_7_ = aClass22Array484[i_5_].anInt400 * 22050 / 1000;
				int[] is_8_ = aClass22Array484[i_5_].method628(i_6_, aClass22Array484[i_5_].anInt408);
				for (int i_9_ = 0; i_9_ < i_6_; i_9_++) {
					int i_10_ = is[i_9_ + i_7_] + (is_8_[i_9_] >> 8);
					if ((i_10_ + 128 & ~0xff) != 0) {
						i_10_ = i_10_ >> 31 ^ 0x7f;
					}
					is[i_9_ + i_7_] = (byte) i_10_;
				}
			}
		}
		return is;
	}
}