package org.necrotic.client.world.sound;

import org.necrotic.client.Client;

public final class Class25 {

	private int[][] anIntArrayArray467;
	private final int anInt468;
	private final int anInt472;

	public Class25(int i, int i_31_) {
		int i_32_ = Client.method670(i_31_, i);
		i_31_ /= i_32_;
		i /= i_32_;
		anInt468 = i;
		anInt472 = i_31_;
		if (i_31_ != i) {
			anIntArrayArray467 = new int[i][14];
			for (int i_33_ = 0; i > i_33_; i_33_++) {
				int[] is = anIntArrayArray467[i_33_];
				double d = (double) i_33_ / (double) i + 6.0;
				int i_34_ = (int) Math.floor(d + -7.0 + 1.0);
				if (i_34_ < 0) {
					i_34_ = 0;
				}
				double d_35_ = (double) i_31_ / (double) i;
				int i_36_ = (int) Math.ceil(d + 7.0);
				if (i_36_ > 14) {
					i_36_ = 14;
				}
				for (/**/; i_36_ > i_34_; i_34_++) {
					double d_37_ = (-d + i_34_) * 3.141592653589793;
					double d_38_ = d_35_;
					if (d_37_ < -1.0E-4 || d_37_ > 1.0E-4) {
						d_38_ *= Math.sin(d_37_) / d_37_;
					}
					d_38_ *= Math.cos((-d + i_34_) * 0.2243994752564138) * 0.46 + 0.54;
					is[i_34_] = (int) Math.floor(d_38_ * 65536.0 + 0.5);
				}
			}
		}
	}

	final int method641(int i) {
		if (anIntArrayArray467 != null) {
			i = i * anInt472 / anInt468;
		}
		return i;
	}

	final byte[] method644(byte[] is) {
		if (anIntArrayArray467 != null) {
			int i_1_ = is.length * anInt472 / anInt468 + 14;
			int i_2_ = 0;
			int[] is_3_ = new int[i_1_];
			int i_4_ = 0;
			for (byte i_6_ : is) {
				int[] is_7_ = anIntArrayArray467[i_4_];
				for (int i_8_ = 0; i_8_ < 14; i_8_++) {
					is_3_[i_8_ + i_2_] += i_6_ * is_7_[i_8_];
				}
				i_4_ += anInt472;
				int i_9_ = i_4_ / anInt468;
				i_4_ -= i_9_ * anInt468;
				i_2_ += i_9_;
			}
			is = new byte[i_1_];
			for (int i_10_ = 0; i_1_ > i_10_; i_10_++) {
				int i_11_ = is_3_[i_10_] + 32768 >> 16;
				if (i_11_ >= -128) {
					if (i_11_ <= 127) {
						is[i_10_] = (byte) i_11_;
					} else {
						is[i_10_] = (byte) 127;
					}
				} else {
					is[i_10_] = (byte) -128;
				}
			}
		}
		return is;
	}

	final int method648(int i) {
		if (anIntArrayArray467 != null) {
			i = 7 + anInt472 * i / anInt468;
		}
		return i;
	}

}