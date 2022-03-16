package org.necrotic.client.bzip;

public final class BZIPDecompressor {

	private static final BZIPContext context = new BZIPContext();

	public static int decompress(byte[] tmp, int decompressed, byte[] data, int compressed, int k) {
		synchronized (context) {
			context.aByteArray563 = data;
			context.anInt564 = k;
			context.aByteArray568 = tmp;
			context.anInt569 = 0;
			context.anInt565 = compressed;
			context.anInt570 = decompressed;
			context.anInt577 = 0;
			context.anInt576 = 0;
			context.anInt566 = 0;
			context.anInt567 = 0;
			context.anInt571 = 0;
			context.anInt572 = 0;
			context.anInt579 = 0;
			decompress(context);
			decompressed -= context.anInt570;
			return decompressed;
		}
	}

	private static void method226(BZIPContext context) {
		byte byte4 = context.aByte573;
		int i = context.anInt574;
		int j = context.anInt584;
		int k = context.anInt582;
		int[] ai = BZIPContext.anIntArray587;
		int l = context.anInt581;
		byte[] abyte0 = context.aByteArray568;
		int i1 = context.anInt569;
		int j1 = context.anInt570;
		int k1 = j1;
		int l1 = context.anInt601 + 1;

		label0: do {
			if (i > 0) {
				do {
					if (j1 == 0) {
						break label0;
					}

					if (i == 1) {
						break;
					}

					abyte0[i1] = byte4;
					i--;
					i1++;
					j1--;
				} while (true);

				if (j1 == 0) {
					i = 1;
					break;
				}

				abyte0[i1] = byte4;
				i1++;
				j1--;
			}

			boolean flag = true;

			while (flag) {
				flag = false;

				if (j == l1) {
					i = 0;
					break label0;
				}

				byte4 = (byte) k;
				l = ai[l];
				byte byte0 = (byte) (l & 0xff);
				l >>= 8;
				j++;

				if (byte0 != k) {
					k = byte0;

					if (j1 == 0) {
						i = 1;
					} else {
						abyte0[i1] = byte4;
						i1++;
						j1--;
						flag = true;
						continue;
					}

					break label0;
				}

				if (j != l1) {
					continue;
				}

				if (j1 == 0) {
					i = 1;
					break label0;
				}

				abyte0[i1] = byte4;
				i1++;
				j1--;
				flag = true;
			}

			i = 2;
			l = ai[l];
			byte byte1 = (byte) (l & 0xff);
			l >>= 8;

			if (++j != l1) {
				if (byte1 != k) {
					k = byte1;
				} else {
					i = 3;
					l = ai[l];
					byte byte2 = (byte) (l & 0xff);
					l >>= 8;

					if (++j != l1) {
						if (byte2 != k) {
							k = byte2;
						} else {
							l = ai[l];
							byte byte3 = (byte) (l & 0xff);
							l >>= 8;
							j++;
							i = (byte3 & 0xff) + 4;
							l = ai[l];
							k = (byte) (l & 0xff);
							l >>= 8;
							j++;
						}
					}
				}
			}
		} while (true);

		int i2 = context.anInt571;
		context.anInt571 += k1 - j1;

		if (context.anInt571 < i2) {
			context.anInt572++;
		}

		context.aByte573 = byte4;
		context.anInt574 = i;
		context.anInt584 = j;
		context.anInt582 = k;
		BZIPContext.anIntArray587 = ai;
		context.anInt581 = l;
		context.aByteArray568 = abyte0;
		context.anInt569 = i1;
		context.anInt570 = j1;
	}

	private static void decompress(BZIPContext context) {
		int k8 = 0;
		int ai[] = null;
		int ai1[] = null;
		int ai2[] = null;
		context.anInt578 = 1;

		if (BZIPContext.anIntArray587 == null) {
			BZIPContext.anIntArray587 = new int[context.anInt578 * 0x186a0];
		}

		boolean flag19 = true;

		while (flag19) {
			byte byte0 = method228(context);

			if (byte0 == 23) {
				return;
			}

			byte0 = method228(context);
			byte0 = method228(context);
			byte0 = method228(context);
			byte0 = method228(context);
			byte0 = method228(context);
			context.anInt579++;
			byte0 = method228(context);
			byte0 = method228(context);
			byte0 = method228(context);
			byte0 = method228(context);
			byte0 = method229(context);
			context.anInt580 = 0;
			byte0 = method228(context);
			context.anInt580 = context.anInt580 << 8 | byte0 & 0xff;
			byte0 = method228(context);
			context.anInt580 = context.anInt580 << 8 | byte0 & 0xff;
			byte0 = method228(context);
			context.anInt580 = context.anInt580 << 8 | byte0 & 0xff;

			for (int j = 0; j < 16; j++) {
				byte byte1 = method229(context);
				context.aBooleanArray590[j] = byte1 == 1;
			}

			for (int k = 0; k < 256; k++) {
				context.aBooleanArray589[k] = false;
			}

			for (int l = 0; l < 16; l++) {
				if (context.aBooleanArray590[l]) {
					for (int i3 = 0; i3 < 16; i3++) {
						byte byte2 = method229(context);

						if (byte2 == 1) {
							context.aBooleanArray589[l * 16 + i3] = true;
						}
					}
				}
			}

			method231(context);
			int i4 = context.anInt588 + 2;
			int j4 = method230(3, context);
			int k4 = method230(15, context);

			for (int i1 = 0; i1 < k4; i1++) {
				int j3 = 0;

				do {
					byte byte3 = method229(context);

					if (byte3 == 0) {
						break;
					}

					j3++;
				} while (true);

				context.aByteArray595[i1] = (byte) j3;
			}

			byte abyte0[] = new byte[6];

			for (byte byte16 = 0; byte16 < j4; byte16++) {
				abyte0[byte16] = byte16;
			}

			for (int j1 = 0; j1 < k4; j1++) {
				byte byte17 = context.aByteArray595[j1];
				byte byte15 = abyte0[byte17];

				for (; byte17 > 0; byte17--) {
					abyte0[byte17] = abyte0[byte17 - 1];
				}

				abyte0[0] = byte15;
				context.aByteArray594[j1] = byte15;
			}

			for (int k3 = 0; k3 < j4; k3++) {
				int l6 = method230(5, context);

				for (int k1 = 0; k1 < i4; k1++) {
					do {
						byte byte4 = method229(context);

						if (byte4 == 0) {
							break;
						}

						byte4 = method229(context);

						if (byte4 == 0) {
							l6++;
						} else {
							l6--;
						}
					} while (true);

					context.aByteArrayArray596[k3][k1] = (byte) l6;
				}
			}

			for (int l3 = 0; l3 < j4; l3++) {
				byte byte8 = 32;
				int i = 0;

				for (int l1 = 0; l1 < i4; l1++) {
					if (context.aByteArrayArray596[l3][l1] > i) {
						i = context.aByteArrayArray596[l3][l1];
					}

					if (context.aByteArrayArray596[l3][l1] < byte8) {
						byte8 = context.aByteArrayArray596[l3][l1];
					}
				}

				method232(context.anIntArrayArray597[l3], context.anIntArrayArray598[l3], context.anIntArrayArray599[l3], context.aByteArrayArray596[l3], byte8, i, i4);
				context.anIntArray600[l3] = byte8;
			}

			int l4 = context.anInt588 + 1;
			int i5 = -1;
			int j5 = 0;

			for (int i2 = 0; i2 <= 255; i2++) {
				context.anIntArray583[i2] = 0;
			}

			int j9 = 4095;

			for (int l8 = 15; l8 >= 0; l8--) {
				for (int i9 = 15; i9 >= 0; i9--) {
					context.aByteArray592[j9] = (byte) (l8 * 16 + i9);
					j9--;
				}

				context.anIntArray593[l8] = j9 + 1;
			}

			int i6 = 0;

			if (j5 == 0) {
				i5++;
				j5 = 50;
				byte byte12 = context.aByteArray594[i5];
				k8 = context.anIntArray600[byte12];
				ai = context.anIntArrayArray597[byte12];
				ai2 = context.anIntArrayArray599[byte12];
				ai1 = context.anIntArrayArray598[byte12];
			}

			j5--;
			int i7 = k8;
			int l7;
			byte byte9;

			for (l7 = method230(i7, context); l7 > ai[i7]; l7 = l7 << 1 | byte9) {
				i7++;
				byte9 = method229(context);
			}

			for (int k5 = ai2[l7 - ai1[i7]]; k5 != l4;) {
				if (k5 == 0 || k5 == 1) {
					int j6 = -1;
					int k6 = 1;

					do {
						if (k5 == 0) {
							j6 += k6;
						} else if (k5 == 1) {
							j6 += 2 * k6;
						}

						k6 *= 2;

						if (j5 == 0) {
							i5++;
							j5 = 50;
							byte byte13 = context.aByteArray594[i5];
							k8 = context.anIntArray600[byte13];
							ai = context.anIntArrayArray597[byte13];
							ai2 = context.anIntArrayArray599[byte13];
							ai1 = context.anIntArrayArray598[byte13];
						}

						j5--;
						int j7 = k8;
						int i8;
						byte byte10;

						for (i8 = method230(j7, context); i8 > ai[j7]; i8 = i8 << 1 | byte10) {
							j7++;
							byte10 = method229(context);
						}

						k5 = ai2[i8 - ai1[j7]];
					} while (k5 == 0 || k5 == 1);

					j6++;
					byte byte5 = context.aByteArray591[context.aByteArray592[context.anIntArray593[0]] & 0xff];
					context.anIntArray583[byte5 & 0xff] += j6;

					for (; j6 > 0; j6--) {
						BZIPContext.anIntArray587[i6] = byte5 & 0xff;
						i6++;
					}
				} else {
					int j11 = k5 - 1;
					byte byte6;

					if (j11 < 16) {
						int j10 = context.anIntArray593[0];
						byte6 = context.aByteArray592[j10 + j11];

						for (; j11 > 3; j11 -= 4) {
							int k11 = j10 + j11;
							context.aByteArray592[k11] = context.aByteArray592[k11 - 1];
							context.aByteArray592[k11 - 1] = context.aByteArray592[k11 - 2];
							context.aByteArray592[k11 - 2] = context.aByteArray592[k11 - 3];
							context.aByteArray592[k11 - 3] = context.aByteArray592[k11 - 4];
						}

						for (; j11 > 0; j11--) {
							context.aByteArray592[j10 + j11] = context.aByteArray592[j10 + j11 - 1];
						}

						context.aByteArray592[j10] = byte6;
					} else {
						int l10 = j11 / 16;
						int i11 = j11 % 16;
						int k10 = context.anIntArray593[l10] + i11;
						byte6 = context.aByteArray592[k10];

						for (; k10 > context.anIntArray593[l10]; k10--) {
							context.aByteArray592[k10] = context.aByteArray592[k10 - 1];
						}

						context.anIntArray593[l10]++;

						for (; l10 > 0; l10--) {
							context.anIntArray593[l10]--;
							context.aByteArray592[context.anIntArray593[l10]] = context.aByteArray592[context.anIntArray593[l10 - 1] + 16 - 1];
						}

						context.anIntArray593[0]--;
						context.aByteArray592[context.anIntArray593[0]] = byte6;

						if (context.anIntArray593[0] == 0) {
							int i10 = 4095;

							for (int k9 = 15; k9 >= 0; k9--) {
								for (int l9 = 15; l9 >= 0; l9--) {
									context.aByteArray592[i10] = context.aByteArray592[context.anIntArray593[k9] + l9];
									i10--;
								}

								context.anIntArray593[k9] = i10 + 1;
							}
						}
					}

					context.anIntArray583[context.aByteArray591[byte6 & 0xff] & 0xff]++;
					BZIPContext.anIntArray587[i6] = context.aByteArray591[byte6 & 0xff] & 0xff;
					i6++;

					if (j5 == 0) {
						i5++;
						j5 = 50;
						byte byte14 = context.aByteArray594[i5];
						k8 = context.anIntArray600[byte14];
						ai = context.anIntArrayArray597[byte14];
						ai2 = context.anIntArrayArray599[byte14];
						ai1 = context.anIntArrayArray598[byte14];
					}

					j5--;
					int k7 = k8;
					int j8;
					byte byte11;

					for (j8 = method230(k7, context); j8 > ai[k7]; j8 = j8 << 1 | byte11) {
						k7++;
						byte11 = method229(context);
					}

					k5 = ai2[j8 - ai1[k7]];
				}
			}

			context.anInt574 = 0;
			context.aByte573 = 0;
			context.anIntArray585[0] = 0;

			for (int j2 = 1; j2 <= 256; j2++) {
				context.anIntArray585[j2] = context.anIntArray583[j2 - 1];
			}

			for (int k2 = 1; k2 <= 256; k2++) {
				context.anIntArray585[k2] += context.anIntArray585[k2 - 1];
			}

			for (int l2 = 0; l2 < i6; l2++) {
				byte byte7 = (byte) (BZIPContext.anIntArray587[l2] & 0xff);
				BZIPContext.anIntArray587[context.anIntArray585[byte7 & 0xff]] |= l2 << 8;
				context.anIntArray585[byte7 & 0xff]++;
			}

			context.anInt581 = BZIPContext.anIntArray587[context.anInt580] >> 8;
				context.anInt584 = 0;
				context.anInt581 = BZIPContext.anIntArray587[context.anInt581];
				context.anInt582 = (byte) (context.anInt581 & 0xff);
				context.anInt581 >>= 8;
			context.anInt584++;
			context.anInt601 = i6;
			method226(context);
			flag19 = context.anInt584 == context.anInt601 + 1 && context.anInt574 == 0;
		}
	}

	private static byte method228(BZIPContext class32) {
		return (byte) method230(8, class32);
	}

	private static byte method229(BZIPContext class32) {
		return (byte) method230(1, class32);
	}

	private static int method230(int i, BZIPContext class32) {
		int j;

		do {
			if (class32.anInt577 >= i) {
				int k = class32.anInt576 >> class32.anInt577 - i & (1 << i) - 1;
					class32.anInt577 -= i;
					j = k;
					break;
			}

			class32.anInt576 = class32.anInt576 << 8 | class32.aByteArray563[class32.anInt564] & 0xff;
			class32.anInt577 += 8;
			class32.anInt564++;
			class32.anInt565--;
			class32.anInt566++;

			if (class32.anInt566 == 0) {
				class32.anInt567++;
			}
		} while (true);

		return j;
	}

	private static void method231(BZIPContext class32) {
		class32.anInt588 = 0;

		for (int i = 0; i < 256; i++) {
			if (class32.aBooleanArray589[i]) {
				class32.aByteArray591[class32.anInt588] = (byte) i;
				class32.anInt588++;
			}
		}
	}

	private static void method232(int ai[], int ai1[], int ai2[], byte abyte0[], int i, int j, int k) {
		int l = 0;

		for (int i1 = i; i1 <= j; i1++) {
			for (int l2 = 0; l2 < k; l2++) {
				if (abyte0[l2] == i1) {
					ai2[l] = l2;
					l++;
				}
			}
		}

		for (int j1 = 0; j1 < 23; j1++) {
			ai1[j1] = 0;
		}

		for (int k1 = 0; k1 < k; k1++) {
			ai1[abyte0[k1] + 1]++;
		}

		for (int l1 = 1; l1 < 23; l1++) {
			ai1[l1] += ai1[l1 - 1];
		}

		for (int i2 = 0; i2 < 23; i2++) {
			ai[i2] = 0;
		}

		int i3 = 0;

		for (int j2 = i; j2 <= j; j2++) {
			i3 += ai1[j2 + 1] - ai1[j2];
			ai[j2] = i3 - 1;
			i3 <<= 1;
		}

		for (int k2 = i + 1; k2 <= j; k2++) {
			ai1[k2] = (ai[k2 - 1] + 1 << 1) - ai1[k2];
		}
	}

}