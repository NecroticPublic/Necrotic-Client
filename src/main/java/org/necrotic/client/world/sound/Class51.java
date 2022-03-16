package org.necrotic.client.world.sound;

import org.necrotic.client.io.ByteBuffer;

final class Class51 {

	private int[] anIntArray853;
	private int[] anIntArray854;
	int anInt855;
	int anInt856;
	private int anInt857 = 2;
	int anInt858;
	private int anInt859;
	private int anInt860;
	private int anInt861;
	private int anInt862;
	private int anInt863;

	public Class51() {
		anIntArray854 = new int[2];
		anIntArray853 = new int[2];
		anIntArray854[0] = 0;
		anIntArray854[1] = 65535;
		anIntArray853[0] = 0;
		anIntArray853[1] = 65535;
	}

	final int method798(int i) {
		if (anInt863 >= anInt859) {
			anInt862 = anIntArray853[anInt860++] << 15;
			if (anInt860 >= anInt857) {
				anInt860 = anInt857 - 1;
			}
			anInt859 = (int) (anIntArray854[anInt860] / 65536.0 * i);
			if (anInt859 > anInt863) {
				anInt861 = ((anIntArray853[anInt860] << 15) - anInt862) / (anInt859 - anInt863);
			}
		}
		anInt862 += anInt861;
		anInt863++;
		return anInt862 - anInt861 >> 15;
	}

	final void method800(ByteBuffer class3_sub12) {
		anInt857 = class3_sub12.getUnsignedByte();
		anIntArray854 = new int[anInt857];
		anIntArray853 = new int[anInt857];
		for (int i = 0; i < anInt857; i++) {
			anIntArray854[i] = class3_sub12.getUnsignedShort();
			anIntArray853[i] = class3_sub12.getUnsignedShort();
		}
	}

	final void method801(ByteBuffer class3_sub12) {
		anInt855 = class3_sub12.getUnsignedByte();
		anInt858 = class3_sub12.getInt();
		anInt856 = class3_sub12.getInt();
		method800(class3_sub12);
	}

	final void resetValues() {
		anInt859 = 0;
		anInt860 = 0;
		anInt861 = 0;
		anInt862 = 0;
		anInt863 = 0;
	}

}