package org.necrotic.client.io;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

import java.math.BigInteger;

import org.necrotic.client.Signlink;
import org.necrotic.client.cache.node.Deque;
import org.necrotic.client.cache.node.NodeSub;

public final class ByteBuffer extends NodeSub {

	private static int anInt1412;
	private static final int[] anIntArray1409 = { 0, 1, 3, 7, 15, 31, 63, 127,
		255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff,
		0x3ffff, 0x7ffff, 0xFFfff, 0x1fffff, 0x3fffff, 0x7fffff, 0xFFffff,
		0x1ffffff, 0x3ffffff, 0x7ffffff, 0xFFfffff, 0x1fffffff, 0x3fffffff,
		0x7fffffff, -1 };
	private static final Deque nodeList = new Deque();

	//REGENERATE RSA
	/*This is the client, so in your PublicKeys.txt
	Copy the ONDEMAND_MODULUS's value to RSA_MODULUS below.
	Copy the ONDEMAND_EXPONENT's value to RSA_EXPONENT below.
	*/
	public static final BigInteger RSA_MODULUS = new BigInteger("92714122021553179775366524500108363230742886412562460353371834211639950528415299652617724152900849886190308772072042859622861358879128131094768196236228636841986869596552685912224862654196445056305117750007439275285163469435632717305809526968825980718429695794961208950600403227465945624833677031718369278551");
	public static final BigInteger RSA_EXPONENT = new BigInteger("65537");


	public static ByteBuffer create() {
		synchronized (nodeList) {
			ByteBuffer stream = null;

			if (anInt1412 > 0) {
				anInt1412--;
				stream = (ByteBuffer) nodeList.popHead();
			}

			if (stream != null) {
				stream.position = 0;
				return stream;
			}
		}

		ByteBuffer stream_1 = new ByteBuffer();
		stream_1.position = 0;
		stream_1.buffer = new byte[5000];
		return stream_1;
	}

	public int bitPosition;
	public byte[] buffer;
	public ISAACCipher cipher;
	public int position = 0;

	private ByteBuffer() {
	}

	public ByteBuffer(byte[] buffer) {
		this.buffer = buffer;
		position = 0;
	}

	public void encryptRSAContent() {
		/* Cache the current position for future use */
		int currentPosition = position;

		/* Reset the position */
		position = 0;

		/* An empty byte array with a capacity of {@code #currentPosition} bytes */
		byte[] decodeBuffer = new byte[currentPosition];

		/*
		 * Gets bytes up to the current position from the buffer and populates
		 * the {@code #decodeBuffer}
		 */
		getBytes(currentPosition, 0, decodeBuffer);

		/*
		 * The decoded big integer which translates the {@code #decodeBuffer}
		 * into a {@link BigInteger}
		 */
		BigInteger decodedBigInteger = new BigInteger(decodeBuffer);

		/*
		 * This is going to be a mouthful... the encoded {@link BigInteger} is
		 * responsible of returning a value which is the value of {@code
		 * #decodedBigInteger}^{@link #RSA_EXPONENT} mod (Modular arithmetic can
		 * be handled mathematically by introducing a congruence relation on the
		 * integers that is compatible with the operations of the ring of
		 * integers: addition, subtraction, and multiplication. For a positive
		 * integer n, two integers a and b are said to be congruent modulo n)
		 * {@link #RSA_MODULES}
		 */
		BigInteger encodedBigInteger = decodedBigInteger.modPow(RSA_EXPONENT, RSA_MODULUS);

		/*
		 * Returns the value of the {@code #encodedBigInteger} translated to a
		 * byte array in big-endian byte-order
		 */
		byte[] encodedBuffer = encodedBigInteger.toByteArray();

		/* Reset the position so we can write fresh to the buffer */
		position = 0;

		/*
		 * We put the length of the {@code #encodedBuffer} to the buffer as a
		 * standard byte. (Ignore the naming, that really writes a byte...)
		 */
		putByte(encodedBuffer.length);

		/* Put the bytes of the {@code #encodedBuffer} into the buffer. */
		putBytes(encodedBuffer, encodedBuffer.length, 0);
	}

	public void finishBitAccess() {
		position = (bitPosition + 7) / 8;
	}

	public int getBits(int bitLength) {
		int k = bitPosition >> 3;
		int l = 8 - (bitPosition & 7);
		int i1 = 0;
		bitPosition += bitLength;

		for (; bitLength > l; l = 8) {
			i1 += (buffer[k++] & anIntArray1409[l]) << bitLength - l;
			bitLength -= l;
		}

		if (bitLength == l) {
			i1 += buffer[k] & anIntArray1409[l];
		} else {
			i1 += buffer[k] >> l - bitLength & anIntArray1409[bitLength];
		}

		return i1;
	}

	public byte getByte() {
		return buffer[position++];
	}

	public void getByte(int value) {
		buffer[position++] = (byte) value;
	}

	public byte[] getBytes() {
		int pos = position;

		while (buffer[position++] != 10) {
			;
		}

		byte[] buf = new byte[position - pos - 1];
		System.arraycopy(buffer, pos, buf, pos - pos, position - 1 - pos);
		return buf;
	}

	public void getBytes(int len, int off, byte[] dest) {
		for (int i = off; i < off + len; i++) {
			dest[i] = buffer[position++];
		}
	}

	public int getInt() {
		position += 4;
		return ((buffer[position - 4] & 0xFF) << 24) + ((buffer[position - 3] & 0xFF) << 16) + ((buffer[position - 2] & 0xFF) << 8) + (buffer[position - 1] & 0xFF);
	}

	public int getIntLittleEndian() {
		position += 4;
		return ((buffer[position - 4] & 0xFF) << 24) + ((buffer[position - 3] & 0xFF) << 16) + ((buffer[position - 2] & 0xFF) << 8) + (buffer[position - 1] & 0xFF);
	}

	public long getLong() {
		long msw = getIntLittleEndian() & 0xFFFFFFFFL;
		long lsw = getIntLittleEndian() & 0xFFFFFFFFL;
		return msw << 32 | lsw;
	}

	public int getShort() {
		position += 2;
		return ((buffer[position - 2] & 0xFF) << 8) + (buffer[position - 1] & 0xFF);
	}

	public int getShort2() {
		position += 2;
		int i = ((buffer[position - 2] & 0xFF) << 8) + (buffer[position - 1] & 0xFF);

		if (i > 60000) {
			i = -65535 + i;
		}

		return i;
	}

	public int getShortBigEndian() {
		position += 2;
		return ((buffer[position - 1] & 0xFF) << 8) + (buffer[position - 2] & 0xFF);
	}

	public int getShortBigEndianA() {
		position += 2;
		return ((buffer[position - 1] & 0xFF) << 8) + (buffer[position - 2] - 128 & 0xFF);
	}

	public byte getSignedByte() {
		return buffer[position++];
	}

	public int getSignedShort() {
		position += 2;
		int value = ((buffer[position - 2] & 0xFF) << 8) + (buffer[position - 1] & 0xFF);

		if (value > 32767) {
			value -= 0x10000;
		}

		return value;
	}

	public int getSmart() {
		try {
			// checks current without modifying position
			if (position >= buffer.length) {
				return buffer[buffer.length - 1] & 0xFF;
			}
			int value = buffer[position] & 0xFF;

			if (value < 128) {
				return getUnsignedByte();
			} else {
				return getUnsignedShort() - 32768;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return getUnsignedShort() - 32768;
		}
	}

	public String getString() {
		int i = position;

		while (buffer[position++] != 10) {
		}

		return new String(buffer, i, position - i - 1);
	}

	public int getTribyte() {
		position += 3;
		return ((buffer[position - 3] & 0xFF) << 16) + ((buffer[position - 2] & 0xFF) << 8) + (buffer[position - 1] & 0xFF);
	}

	public final int getTribyte(int value) {
		position += 3;
		return (0xFF & buffer[position - 3] << 16) + (0xFF & buffer[position - 2] << 8) + (0xFF & buffer[position - 1]);
	}

	public int getUnsignedByte() {
		if (position + 1 > buffer.length) {
			position = buffer.length - 2;
		}
		return buffer[position++] & 0xFF;
	}

	public int getUnsignedShort() {
		if (position + 2 > buffer.length) {
			return buffer[buffer.length - 1];
		}
		position += 2;
		return ((buffer[position - 2] & 0xFF) << 8) + (buffer[position - 1] & 0xFF);
	}

	public int getUSmart2() {
		int baseVal = 0;
		int lastVal = 0;

		while ((lastVal = getSmart()) == 32767) {
			baseVal += 32767;
		}

		return baseVal + lastVal;
	}

	public void initBitAccess() {
		bitPosition = position << 3;
	}

	void method400(int value) {
		buffer[position++] = (byte) value;
		buffer[position++] = (byte) (value >> 8);
	}

	void method403(int value) {
		buffer[position++] = (byte) value;
		buffer[position++] = (byte) (value >> 8);
		buffer[position++] = (byte) (value >> 16);
		buffer[position++] = (byte) (value >> 24);
	}

	public int method421() {
		int i = buffer[position] & 0xFF;

		if (i < 128) {
			return getUnsignedByte() - 64;
		} else {
			return getUnsignedShort() - 49152;
		}
	}

	public void method424(int i) {
		buffer[position++] = (byte) -i;
	}

	public void method425(int j) {
		buffer[position++] = (byte) (128 - j);
	}

	public int method426() {
		return buffer[position++] - 128 & 0xFF;
	}

	public int method427() {
		return -buffer[position++] & 0xFF;
	}
	
	public int getByteA() {
		position += 2;
		return ((buffer[position - 2] & 0xff) << 8)
				+ (buffer[position - 1] - 128 & 0xff);
	}

	public int method428() {
		return 128 - buffer[position++] & 0xFF;
	}

	public byte method429() {
		return (byte) -buffer[position++];
	}

	public byte method430() {
		return (byte) (128 - buffer[position++]);
	}

	public void writeUnsignedWordBigEndian(int i) {
		buffer[position++] = (byte) i;
		buffer[position++] = (byte) (i >> 8);
	}

	public void writeUnsignedWordA(int j) {
		buffer[position++] = (byte) (j >> 8);
		buffer[position++] = (byte) (j + 128);
	}

	public void writeSignedBigEndian(int j) {
		buffer[position++] = (byte) (j + 128);
		buffer[position++] = (byte) (j >> 8);
	}

	public int method435() {
		position += 2;
		return ((buffer[position - 2] & 0xFF) << 8) + (buffer[position - 1] - 128 & 0xFF);
	}

	public int method437() {
		position += 2;
		int j = ((buffer[position - 1] & 0xFF) << 8) + (buffer[position - 2] & 0xFF);
		if (j > 32767) {
			j -= 0x10000;
		}
		return j;
	}

	public int method438() {
		position += 2;
		int j = ((buffer[position - 1] & 0xFF) << 8) + (buffer[position - 2] - 128 & 0xFF);
		if (j > 32767) {
			j -= 0x10000;
		}
		return j;
	}

	public int method439() {
		position += 4;
		return ((buffer[position - 2] & 0xFF) << 24) + ((buffer[position - 1] & 0xFF) << 16) + ((buffer[position - 4] & 0xFF) << 8) + (buffer[position - 3] & 0xFF);
	}

	public int method440() {
		position += 4;
		return ((buffer[position - 3] & 0xFF) << 24) + ((buffer[position - 4] & 0xFF) << 16) + ((buffer[position - 1] & 0xFF) << 8) + (buffer[position - 2] & 0xFF);
	}

	public void method441(int i, byte abyte0[], int j) {
		for (int k = i + j - 1; k >= i; k--) {
			buffer[position++] = (byte) (abyte0[k] + 128);
		}
	}

	public void method442(int i, int j, byte abyte0[]) {
		for (int k = j + i - 1; k >= j; k--) {
			abyte0[k] = buffer[position++];
		}

	}

	public void putBytes(byte[] tmp, int len, int off) {
		for (int i = off; i < off + len; i++) {
			buffer[position++] = tmp[i];
		}
	}

	public void putDWordBigEndian(int value) {
		buffer[position++] = (byte) (value >> 16);
		buffer[position++] = (byte) (value >> 8);
		buffer[position++] = (byte) value;
	}

	public void putInt(int i) {
		buffer[position++] = (byte) (i >> 24);
		buffer[position++] = (byte) (i >> 16);
		buffer[position++] = (byte) (i >> 8);
		buffer[position++] = (byte) i;
	}

	public void putLong(long value) {
		try {
			buffer[position++] = (byte) (value >> 56);
			buffer[position++] = (byte) (value >> 48);
			buffer[position++] = (byte) (value >> 40);
			buffer[position++] = (byte) (value >> 32);
			buffer[position++] = (byte) (value >> 24);
			buffer[position++] = (byte) (value >> 16);
			buffer[position++] = (byte) (value >> 8);
			buffer[position++] = (byte) value;
		} catch (RuntimeException runtimeexception) {
			Signlink.reportError("14395, " + 5 + ", " + value + ", " + runtimeexception.toString());
			throw new RuntimeException();
		}
	}

	public void putOpcode(int i) {
		buffer[position++] = (byte) (i + cipher.next());
	}

	public void putShort(int value) {
		buffer[position++] = (byte) (value >> 8);
		buffer[position++] = (byte) value;
	}

	public void putString(String s) {
		// s.getBytes(0, s.length(), buffer, currentOffset); //deprecated
		System.arraycopy(s.getBytes(), 0, buffer, position, s.length());
		position += s.length();
		buffer[position++] = 10;
	}

	public void putVariableSizeByte(int size) {
		buffer[position - size - 1] = (byte) size;
	}

	public void putByte(int i) {
		buffer[position++] = (byte) i;
	}

}