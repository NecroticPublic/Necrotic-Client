package org.necrotic.client.world.sound;

import org.necrotic.client.Client;

public abstract class Class5_Sub2 extends Class5 implements Runnable {

	static int[] anIntArray1317 = new int[256];
	private boolean aBoolean1315 = false;
	private long aLong1311 = 0L;
	private long aLong1316;
	private long aLong1320;
	private int anInt1312;
	private int anInt1313;
	private int anInt1314;
	private int anInt1318;
	private int anInt1321;
	private int anInt1322;
	private int anInt1323;
	private int anInt1324;
	private final int[] anIntArray1319;

	Class5_Sub2(int i) throws Exception {
		super(i);
		anInt1314 = 0;
		anInt1312 = 0;
		anInt1321 = 0;
		anIntArray1319 = new int[512];
		anInt1313 = 0;
		anInt1323 = 2560;
	}

	abstract int avail() throws Exception;

	abstract void close();

	@Override
	public final synchronized void method489(long l) {
		method499(l);
		if (aLong1320 < l) {
			aLong1320 = l;
		}
	}

	abstract void method494(int i) throws Exception;

	private final void method496(long l) throws Exception {
		method494(anInt1324);
		for (;;) {
			int i = avail();
			if (i < anInt1323) {
				break;
			}
			write();
		}
		anInt1322 = 0;
		anInt1318 = 0;
		aLong1320 = l;
		aLong1316 = l;
	}

	private final void method499(long l) {
		if (aLong1311 != 0L) {
			for (/**/; aLong1320 < l; aLong1320 += 256000 / Client.anInt197) {
				Client.method493(256);
			}
			if (l < aLong1311) {
				return;
			}
			try {
				method496(l);
			} catch (Exception exception) {
				close();
				aLong1311 += 5000L;
				return;
			}
			aLong1311 = 0L;
		}
		while (aLong1320 < l) {
			aLong1320 += 250880 / Client.anInt197;
			int i;
			try {
				i = avail();
			} catch (Exception exception) {
				close();
				aLong1311 = l;
				return;
			}
			method500(i);
			int i_0_ = anInt1314 * 3 / 512 - anInt1312 * 2;
			if (i_0_ < 0) {
				i_0_ = 0;
			} else if (i_0_ > anInt1313) {
				i_0_ = anInt1313;
			}
			anInt1323 = anInt1324 - 256 - i_0_;
			if (anInt1323 < 256) {
				anInt1323 = 256;
			}
			if (anInt1324 < 16384) {
				if (i >= anInt1324) {
					anInt1322 += 5;
					if (anInt1322 >= 100) {
						close();
						anInt1324 += 2048;
						aLong1311 = l;
						return;
					}
				} else if (i != anInt1318 && anInt1322 > 0) {
					anInt1322--;
				}
			}
			anInt1318 = i;
			if (i < anInt1323) {
				break;
			}
			Client.method486(anIntArray1317, 256);
			try {
				write();
			} catch (Exception exception) {
				close();
				aLong1311 = l;
				return;
			}
			aLong1316 = l;
			anInt1318 -= 256;
		}
		if (l >= aLong1316 + 5000L) {
			close();
			aLong1311 = l;
			for (int i = 0; i < 512; i++) {
				anIntArray1319[i] = 0;
			}
			anInt1312 = anInt1313 = anInt1314 = 0;
		}
	}

	private final void method500(int i) {
		int i_1_ = i - anInt1323;
		int i_2_ = anIntArray1319[anInt1321];
		anIntArray1319[anInt1321] = i_1_;
		anInt1314 += i_1_ - i_2_;
		int i_3_ = anInt1321 + 1 & 0x1ff;
		if (i_1_ > anInt1313) {
			anInt1313 = i_1_;
		}
		if (i_1_ < anInt1312) {
			anInt1312 = i_1_;
		}
		if (i_2_ == anInt1313) {
			int i_4_ = i_1_;
			for (int i_5_ = i_3_; i_5_ != anInt1321 && i_4_ < anInt1313; i_5_ = i_5_ + 1 & 0x1ff) {
				int i_6_ = anIntArray1319[i_5_];
				if (i_6_ > i_4_) {
					i_4_ = i_6_;
				}
			}
			anInt1313 = i_4_;
		}
		if (i_2_ == anInt1312) {
			int i_7_ = i_1_;
			for (int i_8_ = i_3_; i_8_ != anInt1321 && i_7_ > anInt1312; i_8_ = i_8_ + 1 & 0x1ff) {
				int i_9_ = anIntArray1319[i_8_];
				if (i_9_ < i_7_) {
					i_7_ = i_9_;
				}
			}
			anInt1312 = i_7_;
		}
		anInt1321 = i_3_;
	}

	public final void method502(int i) throws Exception {
		anInt1324 = i;
		method496(System.currentTimeMillis());
		Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
		thread.setPriority(10);
	}

	@Override
	public final void run() {
		try {
			for (;;) {
				synchronized (this) {
					if (aBoolean1315) {
						if (aLong1311 == 0L) {
							close();
						}
						aBoolean1315 = false;
						break;
					}
					method489(System.currentTimeMillis());
				}
				Client.sleep(5L);
			}
		} catch (Exception exception) {
		}
	}

	@Override
	final void stop() {
		synchronized (this) {
			aBoolean1315 = true;
		}
		for (;;) {
			synchronized (this) {
				if (!aBoolean1315) {
					break;
				}
			}
			Client.sleep(50L);
		}
	}

	abstract void write() throws Exception;

}