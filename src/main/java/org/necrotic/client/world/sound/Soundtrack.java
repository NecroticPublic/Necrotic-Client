package org.necrotic.client.world.sound;

import java.util.Random;

import org.necrotic.client.io.ByteBuffer;

final class Soundtrack {

	int anInt400;
	private Class51 aClass51_401;
	private Class51 aClass51_402;
	private Class51 aClass51_403;
	private final int[] anIntArray404;
	private Class51 aClass51_405;
	private int anInt406;
	private final int[] anIntArray407;
	int anInt408 = 500;
	private Class51 aClass51_409;
	private Class37 aClass37_410;
	private Class51 aClass51_411;
	private static int[] sineTable;
	private Class51 aClass51_413;
	private final int[] anIntArray414;
	private Class51 aClass51_415;
	private static int[] noise = new int[32768];
	private Class51 aClass51_417;
	private int anInt418;
	private static int[] sampleBuffer;
	private static int[] anIntArray420;
	private static int[] anIntArray421;
	private static int[] anIntArray422;
	private static int[] anIntArray423;

	private static int[] anIntArray424;

	static {
		Random random = new Random(0L);
		for (int i = 0; i < 32768; i++) {
			noise[i] = (random.nextInt() & 0x2) - 1;
		}
		sineTable = new int[32768];
		for (int i = 0; i < 32768; i++) {
			sineTable[i] = (int) (Math.sin(i / 5215.1903) * 16384.0);
		}
		sampleBuffer = new int[220500];
		anIntArray421 = new int[5];
		anIntArray420 = new int[5];
		anIntArray422 = new int[5];
		anIntArray424 = new int[5];
		anIntArray423 = new int[5];
	}

	public Soundtrack() {
		anInt400 = 0;
		anInt406 = 0;
		anIntArray404 = new int[5];
		anIntArray407 = new int[5];
		anIntArray414 = new int[5];
		anInt418 = 100;
	}

	final void method626(ByteBuffer class3_sub12) {
		aClass51_415 = new Class51();
		aClass51_415.method801(class3_sub12);
		aClass51_409 = new Class51();
		aClass51_409.method801(class3_sub12);
		int i = class3_sub12.getUnsignedByte();
		if (i != 0) {
			class3_sub12.position--;
			aClass51_401 = new Class51();
			aClass51_401.method801(class3_sub12);
			aClass51_402 = new Class51();
			aClass51_402.method801(class3_sub12);
		}
		i = class3_sub12.getUnsignedByte();
		if (i != 0) {
			class3_sub12.position--;
			aClass51_411 = new Class51();
			aClass51_411.method801(class3_sub12);
			aClass51_405 = new Class51();
			aClass51_405.method801(class3_sub12);
		}
		i = class3_sub12.getUnsignedByte();
		if (i != 0) {
			class3_sub12.position--;
			aClass51_413 = new Class51();
			aClass51_413.method801(class3_sub12);
			aClass51_403 = new Class51();
			aClass51_403.method801(class3_sub12);
		}
		for (int i_0_ = 0; i_0_ < 10; i_0_++) {
			int i_1_ = class3_sub12.getSmart();
			if (i_1_ == 0) {
				break;
			}
			anIntArray404[i_0_] = i_1_;
			anIntArray407[i_0_] = class3_sub12.method421();
			anIntArray414[i_0_] = class3_sub12.getSmart();
		}
		anInt406 = class3_sub12.getSmart();
		anInt418 = class3_sub12.getSmart();
		anInt408 = class3_sub12.getUnsignedShort();
		anInt400 = class3_sub12.getUnsignedShort();
		aClass37_410 = new Class37();
		aClass51_417 = new Class51();
		aClass37_410.method717(class3_sub12, aClass51_417);
	}

	private final int method627(int i, int i_2_, int i_3_) {
		if (i_3_ == 1) {
			if ((i & 0x7fff) < 16384) {
				return i_2_;
			}
			return -i_2_;
		}
		if (i_3_ == 2) {
			return sineTable[i & 0x7fff] * i_2_ >> 14;
		}
		if (i_3_ == 3) {
			return ((i & 0x7fff) * i_2_ >> 14) - i_2_;
		}
		if (i_3_ == 4) {
			return noise[i / 2607 & 0x7fff] * i_2_;
		}
		return 0;
	}

	final int[] method628(int i, int i_4_) {
		for (int i_5_ = 0; i_5_ < i; i_5_++) {
			sampleBuffer[i_5_] = 0;
		}
		if (i_4_ < 10) {
			return sampleBuffer;
		}
		double d = i / (i_4_ + 0.0);
		aClass51_415.resetValues();
		aClass51_409.resetValues();
		int i_6_ = 0;
		int i_7_ = 0;
		int i_8_ = 0;
		if (aClass51_401 != null) {
			aClass51_401.resetValues();
			aClass51_402.resetValues();
			i_6_ = (int) ((aClass51_401.anInt856 - aClass51_401.anInt858) * 32.768 / d);
			i_7_ = (int) (aClass51_401.anInt858 * 32.768 / d);
		}
		int i_9_ = 0;
		int i_10_ = 0;
		int i_11_ = 0;
		if (aClass51_411 != null) {
			aClass51_411.resetValues();
			aClass51_405.resetValues();
			i_9_ = (int) ((aClass51_411.anInt856 - aClass51_411.anInt858) * 32.768 / d);
			i_10_ = (int) (aClass51_411.anInt858 * 32.768 / d);
		}
		for (int i_12_ = 0; i_12_ < 5; i_12_++) {
			if (anIntArray404[i_12_] != 0) {
				anIntArray422[i_12_] = 0;
				anIntArray423[i_12_] = (int) (anIntArray414[i_12_] * d);
				anIntArray421[i_12_] = (anIntArray404[i_12_] << 14) / 100;
				anIntArray420[i_12_] = (int) ((aClass51_415.anInt856 - aClass51_415.anInt858) * 32.768 * Math.pow(1.0057929410678534, anIntArray407[i_12_]) / d);
				anIntArray424[i_12_] = (int) (aClass51_415.anInt858 * 32.768 / d);
			}
		}
		for (int i_13_ = 0; i_13_ < i; i_13_++) {
			int i_14_ = aClass51_415.method798(i);
			int i_15_ = aClass51_409.method798(i);
			if (aClass51_401 != null) {
				int i_16_ = aClass51_401.method798(i);
				int i_17_ = aClass51_402.method798(i);
				i_14_ += method627(i_8_, i_17_, aClass51_401.anInt855) >> 1;
		i_8_ += (i_16_ * i_6_ >> 16) + i_7_;
			}
			if (aClass51_411 != null) {
				int i_18_ = aClass51_411.method798(i);
				int i_19_ = aClass51_405.method798(i);
				i_15_ = i_15_ * ((method627(i_11_, i_19_, aClass51_411.anInt855) >> 1) + 32768) >> 15;
				i_11_ += (i_18_ * i_9_ >> 16) + i_10_;
			}
			for (int i_20_ = 0; i_20_ < 5; i_20_++) {
				if (anIntArray404[i_20_] != 0) {
					int i_21_ = i_13_ + anIntArray423[i_20_];
					if (i_21_ < i) {
						sampleBuffer[i_21_] += method627(anIntArray422[i_20_], i_15_ * anIntArray421[i_20_] >> 15, aClass51_415.anInt855);
						anIntArray422[i_20_] += (i_14_ * anIntArray420[i_20_] >> 16) + anIntArray424[i_20_];
					}
				}
			}
		}
		if (aClass51_413 != null) {
			aClass51_413.resetValues();
			aClass51_403.resetValues();
			int i_22_ = 0;
			boolean bool_23_ = true;
			for (int i_24_ = 0; i_24_ < i; i_24_++) {
				int i_25_ = aClass51_413.method798(i);
				int i_26_ = aClass51_403.method798(i);
				int i_27_;
				if (bool_23_) {
					i_27_ = aClass51_413.anInt858 + ((aClass51_413.anInt856 - aClass51_413.anInt858) * i_25_ >> 8);
				} else {
					i_27_ = aClass51_413.anInt858 + ((aClass51_413.anInt856 - aClass51_413.anInt858) * i_26_ >> 8);
				}
				i_22_ += 256;
				if (i_22_ >= i_27_) {
					i_22_ = 0;
					bool_23_ = !bool_23_;
				}
				if (bool_23_) {
					sampleBuffer[i_24_] = 0;
				}
			}
		}
		if (anInt406 > 0 && anInt418 > 0) {
			int i_28_ = (int) (anInt406 * d);
			for (int i_29_ = i_28_; i_29_ < i; i_29_++) {
				sampleBuffer[i_29_] += sampleBuffer[i_29_ - i_28_] * anInt418 / 100;
			}
		}
		if (aClass37_410.anIntArray646[0] > 0 || aClass37_410.anIntArray646[1] > 0) {
			aClass51_417.resetValues();
			int i_30_ = aClass51_417.method798(i + 1);
			int i_31_ = aClass37_410.method720(0, i_30_ / 65536.0F);
			int i_32_ = aClass37_410.method720(1, i_30_ / 65536.0F);
			if (i >= i_31_ + i_32_) {
				int i_33_ = 0;
				int i_34_ = i_32_;
				if (i_34_ > i - i_31_) {
					i_34_ = i - i_31_;
				}
				for (/**/; i_33_ < i_34_; i_33_++) {
					int i_35_ = (int) ((long) sampleBuffer[i_33_ + i_31_] * (long) Class37.anInt650 >> 16);
					for (int i_36_ = 0; i_36_ < i_31_; i_36_++) {
						i_35_ += (int) ((long) sampleBuffer[i_33_ + i_31_ - 1 - i_36_] * (long) Class37.anIntArrayArray648[0][i_36_] >> 16);
					}
					for (int i_37_ = 0; i_37_ < i_33_; i_37_++) {
						i_35_ -= (int) ((long) sampleBuffer[i_33_ - 1 - i_37_] * (long) Class37.anIntArrayArray648[1][i_37_] >> 16);
					}
					sampleBuffer[i_33_] = i_35_;
					i_30_ = aClass51_417.method798(i + 1);
				}
				i_34_ = 128;
				for (;;) {
					if (i_34_ > i - i_31_) {
						i_34_ = i - i_31_;
					}
					for (/**/; i_33_ < i_34_; i_33_++) {
						int i_38_ = (int) ((long) sampleBuffer[i_33_ + i_31_] * (long) Class37.anInt650 >> 16);
						for (int i_39_ = 0; i_39_ < i_31_; i_39_++) {
							i_38_ += (int) ((long) sampleBuffer[i_33_ + i_31_ - 1 - i_39_] * (long) Class37.anIntArrayArray648[0][i_39_] >> 16);
						}
						for (int i_40_ = 0; i_40_ < i_32_; i_40_++) {
							i_38_ -= (int) ((long) sampleBuffer[i_33_ - 1 - i_40_] * (long) Class37.anIntArrayArray648[1][i_40_] >> 16);
						}
						sampleBuffer[i_33_] = i_38_;
						i_30_ = aClass51_417.method798(i + 1);
					}
					if (i_33_ >= i - i_31_) {
						break;
					}
					i_31_ = aClass37_410.method720(0, i_30_ / 65536.0F);
					i_32_ = aClass37_410.method720(1, i_30_ / 65536.0F);
					i_34_ += 128;
				}
				for (/**/; i_33_ < i; i_33_++) {
					int i_41_ = 0;
					for (int i_42_ = i_33_ + i_31_ - i; i_42_ < i_31_; i_42_++) {
						i_41_ += (int) ((long) sampleBuffer[i_33_ + i_31_ - 1 - i_42_] * (long) Class37.anIntArrayArray648[0][i_42_] >> 16);
					}
					for (int i_43_ = 0; i_43_ < i_32_; i_43_++) {
						i_41_ -= (int) ((long) sampleBuffer[i_33_ - 1 - i_43_] * (long) Class37.anIntArrayArray648[1][i_43_] >> 16);
					}
					sampleBuffer[i_33_] = i_41_;
					i_30_ = aClass51_417.method798(i + 1);
				}
			}
		}

		for (int i_44_ = 0; i_44_ < i; i_44_++) {
			if (sampleBuffer[i_44_] < -32768) {
				sampleBuffer[i_44_] = -32768;
			}
			if (sampleBuffer[i_44_] > 32767) {
				sampleBuffer[i_44_] = 32767;
			}
		}
		return sampleBuffer;
	}

}