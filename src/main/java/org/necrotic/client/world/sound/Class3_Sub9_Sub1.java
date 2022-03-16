package org.necrotic.client.world.sound;

public final class Class3_Sub9_Sub1 extends Class3_Sub9 {

	byte[] aByteArray1827;
	int anInt1828;
	int anInt1829;
	int anInt1830;

	Class3_Sub9_Sub1(int i, byte[] is, int i_0_, int i_1_) {
		anInt1828 = i;
		aByteArray1827 = is;
		anInt1830 = i_0_;
		anInt1829 = i_1_;
	}

	public final Class3_Sub9_Sub1 method405(Class25 class25) {
		aByteArray1827 = class25.method644(aByteArray1827);
		anInt1828 = class25.method641(anInt1828);

		if (anInt1830 == anInt1829) {
			anInt1830 = anInt1829 = class25.method648(anInt1830);
		} else {
			anInt1830 = class25.method648(anInt1830);
			anInt1829 = class25.method648(anInt1829);

			if (anInt1830 == anInt1829) {
				anInt1830--;
			}
		}

		return this;
	}
}
