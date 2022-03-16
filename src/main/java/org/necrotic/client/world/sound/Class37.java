package org.necrotic.client.world.sound;

import org.necrotic.client.io.ByteBuffer;

final class Class37 {

	private static float aFloat645;
	private static float[][] aFloatArrayArray649 = new float[2][8];
	static int anInt650;
	static int[][] anIntArrayArray648 = new int[2][8];

	private static final float method718(float f) {
		float f_5_ = (float) Math.pow(2.0, f) * 32.703197F;
		return f_5_ * 3.1415927F / 11025.0F;
	}

	private final int[] anIntArray643 = new int[2];
	int[] anIntArray646 = new int[2];
	private final int[][][] anIntArrayArrayArray644;
	private final int[][][] anIntArrayArrayArray647 = new int[2][2][4];

	public Class37() {
		anIntArrayArrayArray644 = new int[2][2][4];
	}

	final void method717(ByteBuffer class3_sub12, Class51 class51) {
		int i = class3_sub12.getUnsignedByte();
		anIntArray646[0] = i >> 4;
		anIntArray646[1] = i & 0xf;
		if (i != 0) {
			anIntArray643[0] = class3_sub12.getUnsignedShort();
			anIntArray643[1] = class3_sub12.getUnsignedShort();
			int i_0_ = class3_sub12.getUnsignedByte();
			for (int i_1_ = 0; i_1_ < 2; i_1_++) {
				for (int i_2_ = 0; i_2_ < anIntArray646[i_1_]; i_2_++) {
					anIntArrayArrayArray644[i_1_][0][i_2_] = class3_sub12.getUnsignedShort();
					anIntArrayArrayArray647[i_1_][0][i_2_] = class3_sub12.getUnsignedShort();
				}
			}
			for (int i_3_ = 0; i_3_ < 2; i_3_++) {
				for (int i_4_ = 0; i_4_ < anIntArray646[i_3_]; i_4_++) {
					if ((i_0_ & 1 << i_3_ * 4 << i_4_) != 0) {
						anIntArrayArrayArray644[i_3_][1][i_4_] = class3_sub12.getUnsignedShort();
						anIntArrayArrayArray647[i_3_][1][i_4_] = class3_sub12.getUnsignedShort();
					} else {
						anIntArrayArrayArray644[i_3_][1][i_4_] = anIntArrayArrayArray644[i_3_][0][i_4_];
						anIntArrayArrayArray647[i_3_][1][i_4_] = anIntArrayArrayArray647[i_3_][0][i_4_];
					}
				}
			}
			if (i_0_ != 0 || anIntArray643[1] != anIntArray643[0]) {
				class51.method800(class3_sub12);
			}
		} else {
			anIntArray643[0] = anIntArray643[1] = 0;
		}
	}

	final int method720(int i, float f) {
		if (i == 0) {
			float f_6_ = anIntArray643[0] + (anIntArray643[1] - anIntArray643[0]) * f;
			f_6_ *= 0.0030517578F;
			aFloat645 = (float) Math.pow(0.1, f_6_ / 20.0F);
			anInt650 = (int) (aFloat645 * 65536.0F);
		}
		if (anIntArray646[i] == 0) {
			return 0;
		}
		float f_7_ = method721(i, 0, f);
		aFloatArrayArray649[i][0] = f_7_ * -2.0F * (float) Math.cos(method722(i, 0, f));
		aFloatArrayArray649[i][1] = f_7_ * f_7_;
		for (int i_8_ = 1; i_8_ < anIntArray646[i]; i_8_++) {
			f_7_ = method721(i, i_8_, f);
			float f_9_ = f_7_ * -2.0F * (float) Math.cos(method722(i, i_8_, f));
			float f_10_ = f_7_ * f_7_;
			aFloatArrayArray649[i][i_8_ * 2 + 1] = aFloatArrayArray649[i][i_8_ * 2 - 1] * f_10_;
			aFloatArrayArray649[i][i_8_ * 2] = aFloatArrayArray649[i][i_8_ * 2 - 1] * f_9_ + aFloatArrayArray649[i][i_8_ * 2 - 2] * f_10_;
			for (int i_11_ = i_8_ * 2 - 1; i_11_ >= 2; i_11_--) {
				aFloatArrayArray649[i][i_11_] += aFloatArrayArray649[i][i_11_ - 1] * f_9_ + aFloatArrayArray649[i][i_11_ - 2] * f_10_;
			}
			aFloatArrayArray649[i][1] += aFloatArrayArray649[i][0] * f_9_ + f_10_;
			aFloatArrayArray649[i][0] += f_9_;
		}
		if (i == 0) {
			for (int i_12_ = 0; i_12_ < anIntArray646[0] * 2; i_12_++) {
				aFloatArrayArray649[0][i_12_] *= aFloat645;
			}
		}
		for (int i_13_ = 0; i_13_ < anIntArray646[i] * 2; i_13_++) {
			anIntArrayArray648[i][i_13_] = (int) (aFloatArrayArray649[i][i_13_] * 65536.0F);
		}
		return anIntArray646[i] * 2;
	}

	private final float method721(int i, int i_14_, float f) {
		float f_15_ = anIntArrayArrayArray647[i][0][i_14_] + f * (anIntArrayArrayArray647[i][1][i_14_] - anIntArrayArrayArray647[i][0][i_14_]);
		f_15_ *= 0.0015258789F;
		return 1.0F - (float) Math.pow(10.0, -f_15_ / 20.0F);
	}

	private final float method722(int i, int i_16_, float f) {
		float f_17_ = anIntArrayArrayArray644[i][0][i_16_] + f * (anIntArrayArrayArray644[i][1][i_16_] - anIntArrayArrayArray644[i][0][i_16_]);
		f_17_ *= 1.2207031E-4F;
		return method718(f_17_);
	}

}