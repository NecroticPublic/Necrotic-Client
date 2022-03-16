package org.necrotic.client.world.sound;

import org.necrotic.client.Client;
import org.necrotic.client.cache.node.Deque;
import org.necrotic.client.cache.node.Node;

public final class Class3_Sub7_Sub1 extends Class3_Sub7 {

	private static final int method386(Class3_Sub7 class3_sub7) {
		return class3_sub7.method379() >> 5;
	}

	private final Deque[] aClass60Array1810 = new Deque[8];
	private final Deque aClass60_1811;
	private final int anInt1812 = 16;
	private int anInt1813;
	private int anInt1814;
	private int anInt1815;

	public Class3_Sub7_Sub1() {
		aClass60_1811 = new Deque();
		anInt1813 = -1;
		anInt1814 = 0;
		anInt1815 = 0;
		for (int i = 0; i < 8; i++) {
			aClass60Array1810[i] = new Deque();
		}
	}

	@Override
	public final synchronized int method378(int[] is, int i, int i_3_) {
		int i_4_;
		do {
			if (anInt1813 < 0) {
				return method387(is, i, i_3_);
			}
			if (anInt1814 + i_3_ < anInt1813) {
				anInt1814 += i_3_;
				return method387(is, i, i_3_);
			}
			int i_5_ = anInt1813 - anInt1814;
			i_4_ = method387(is, i, i_5_);
			i += i_5_;
			i_3_ -= i_5_;
			anInt1814 += i_5_;
			method382();
			Class3_Sub5 class3_sub5 = (Class3_Sub5) aClass60_1811.getFirst();
			synchronized (class3_sub5) {
				int i_6_ = class3_sub5.method372(this);
				if (i_6_ < 0) {
					class3_sub5.anInt1206 = 0;
					method385(class3_sub5);
				} else {
					class3_sub5.anInt1206 = i_6_;
					method383(class3_sub5.next, class3_sub5);
				}
			}
		} while (i_3_ != 0);
		return i_4_;
	}

	@Override
	public final synchronized void method380(int i) {
		do {
			if (anInt1813 < 0) {
				method381(i);
				break;
			}
			if (anInt1814 + i < anInt1813) {
				anInt1814 += i;
				method381(i);
				break;
			}
			int i_0_ = anInt1813 - anInt1814;
			method381(i_0_);
			i -= i_0_;
			anInt1814 += i_0_;
			method382();
			Class3_Sub5 class3_sub5 = (Class3_Sub5) aClass60_1811.getFirst();
			synchronized (class3_sub5) {
				int i_1_ = class3_sub5.method372(this);
				if (i_1_ < 0) {
					class3_sub5.anInt1206 = 0;
					method385(class3_sub5);
				} else {
					class3_sub5.anInt1206 = i_1_;
					method383(((Node) class3_sub5).next, class3_sub5);
				}
			}
		} while (i != 0);
	}

	private final void method381(int i) {
		anInt1815 -= i;
		if (anInt1815 < 0) {
			anInt1815 = 0;
		}
		for (int i_2_ = 0; i_2_ < 8; i_2_++) {
			Deque class60 = aClass60Array1810[i_2_];
			for (Class3_Sub7 class3_sub7 = (Class3_Sub7) class60.getFirst(); class3_sub7 != null; class3_sub7 = (Class3_Sub7) class60.getNext()) {
				class3_sub7.method380(i);
			}
		}
	}

	private final void method382() {
		if (anInt1814 > 0) {
			for (Class3_Sub5 class3_sub5 = (Class3_Sub5) aClass60_1811.getFirst(); class3_sub5 != null; class3_sub5 = (Class3_Sub5) aClass60_1811.getNext()) {
				class3_sub5.anInt1206 -= anInt1814;
			}
			anInt1813 -= anInt1814;
			anInt1814 = 0;
		}
	}

	private final void method383(Node class3, Class3_Sub5 class3_sub5) {
		for (/**/; class3 != aClass60_1811.head && ((Class3_Sub5) class3).anInt1206 <= class3_sub5.anInt1206; class3 = class3.next) {
			/* empty */
		}
		aClass60_1811.method894(class3_sub5, class3);
		anInt1813 = ((Class3_Sub5) aClass60_1811.head.next).anInt1206;
	}

	public final synchronized void method384(Class3_Sub7 class3_sub7) {
		Deque class60 = aClass60Array1810[method386(class3_sub7)];
		class60.insertHead(class3_sub7);
	}

	private final void method385(Class3_Sub5 class3_sub5) {
		class3_sub5.unlink();
		class3_sub5.method371();
		Node class3 = aClass60_1811.head.next;
		if (class3 == aClass60_1811.head) {
			anInt1813 = -1;
		} else {
			anInt1813 = ((Class3_Sub5) class3).anInt1206;
		}
	}

	private final int method387(int[] is, int i, int i_7_) {
		anInt1815 -= i_7_;
		if (anInt1815 <= 0) {
			anInt1815 += Client.anInt197 >> 4;
		for (int i_8_ = 0; i_8_ < 8; i_8_++) {
			Deque class60 = aClass60Array1810[i_8_];
			for (Class3_Sub7 class3_sub7 = (Class3_Sub7) class60.getFirst(); class3_sub7 != null; class3_sub7 = (Class3_Sub7) class60.getNext()) {
				int i_9_ = method386(class3_sub7);
				if (i_9_ != i_8_) {
					aClass60Array1810[i_9_].insertHead(class3_sub7);
				}
			}
		}
		}
		for (int i_10_ = 0; i_10_ < 8; i_10_++) {
			Deque class60 = aClass60Array1810[i_10_];
			for (Class3_Sub7 class3_sub7 = (Class3_Sub7) class60.getFirst(); class3_sub7 != null; class3_sub7 = (Class3_Sub7) class60.getNext()) {
				class3_sub7.aBoolean1221 = false;
				if (class3_sub7.aClass3_Sub9_1220 != null) {
					class3_sub7.aClass3_Sub9_1220.anInt1240 = 0;
				}
			}
		}
		int i_11_ = 0;
		int i_12_ = 255;
		int i_13_ = 7;
		while (i_12_ != 0) {
			int i_14_;
			int i_15_;
			if (i_13_ < 0) {
				i_14_ = i_13_ & 0x3;
				i_15_ = -(i_13_ >> 2);
			} else {
				i_14_ = i_13_;
				i_15_ = 0;
			}
			for (int i_16_ = i_12_ >>> i_14_ & 0x11111111; i_16_ != 0; i_16_ >>>= 4) {
				if ((i_16_ & 0x1) != 0) {
					i_12_ &= 1 << i_14_ ^ 0xffffffff;
					Deque class60 = aClass60Array1810[i_14_];
					for (Class3_Sub7 class3_sub7 = (Class3_Sub7) class60.getFirst(); class3_sub7 != null; class3_sub7 = (Class3_Sub7) class60.getNext()) {
						if (!class3_sub7.aBoolean1221) {
							Class3_Sub9 class3_sub9 = class3_sub7.aClass3_Sub9_1220;
							if (class3_sub9 != null && class3_sub9.anInt1240 > i_15_) {
								i_12_ |= 1 << i_14_;
							} else {
								if (i_11_ < anInt1812) {
									int i_17_ = class3_sub7.method378(is, i, i_7_);
									i_11_ += i_17_;
									if (class3_sub9 != null) {
										class3_sub9.anInt1240 += i_17_;
									}
								} else {
									class3_sub7.method380(i_7_);
								}
								class3_sub7.aBoolean1221 = true;
							}
						}
					}
				}
				i_14_ += 4;
				i_15_++;
			}
			i_13_--;
		}
		return i_11_;
	}
}
