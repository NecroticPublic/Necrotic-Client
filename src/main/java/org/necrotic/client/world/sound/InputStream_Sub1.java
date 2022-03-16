package org.necrotic.client.world.sound;

/*
 * InputStream_Sub1 - Decompiled by JODE Visit http://jode.sourceforge.net/
 */
import java.io.InputStream;

import org.necrotic.client.Client;

/*
 * InputStream_Sub1 - Decompiled by JODE Visit http://jode.sourceforge.net/
 */

public final class InputStream_Sub1 extends InputStream {

	private static final void method42(byte[] is, int[] is_8_, byte[] is_9_, int i, int i_10_, int i_11_) {
		for (i = 0; i < i_11_; i++) {
			is_9_[i_10_++] = is[(is_8_[i] >> 8) + 32768];
		}
	}

	public boolean aBoolean31;
	private final byte[] aByteArray33 = new byte[65536];
	private final int[] anIntArray32 = { 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3,
			3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5,
			5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
			5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
			6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
			6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
			6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };

	private final int[] anIntArray34 = new int[256];

	public InputStream_Sub1() {
		for (int i = -32768; i < 32768; i++) {
			aByteArray33[i + 32768] = method41(i);
		}
	}

	private final byte method41(int i) {
		int i_0_ = i >> 8 & 0x80;
		if (i_0_ != 0) {
			i = -i;
		}
		if (i > 32635) {
			i = 32635;
		}
		i += 132;
		int i_1_ = anIntArray32[i >> 7 & 0xff];
		int i_2_ = i >> i_1_ + 3 & 0xf;
		byte i_3_ = (byte) ((i_0_ | i_1_ << 4 | i_2_) ^ 0xffffffff);
		return i_3_;
	}

	@Override
	public final int read() {
		byte[] is = new byte[1];
		read(is, 0, 1);
		return is[0];
	}

	@Override
	public final synchronized int read(byte[] buf, int off, int len) {
		int readLength;

		try {
			if (aBoolean31) {
				return -1;
			}

			if (len > 256) {
				read(buf, off, 256);
				read(buf, off + 256, len - 256);
				return len;
			}

			Client.method486(anIntArray34, len);

			for (int i = 0; i < len; i++) {
				int n = anIntArray34[i];

				if ((n + 8388608 & ~0xffffff) != 0) {
					anIntArray34[i] = 0x7fffff ^ n >> 31;
				}
			}

			method42(aByteArray33, anIntArray34, buf, 0, off, len);
			readLength = len;
		} catch (Exception exception) {
			aBoolean31 = true;
			return -1;
		}

		return readLength;
	}

}