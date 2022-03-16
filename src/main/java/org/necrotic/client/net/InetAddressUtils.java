package org.necrotic.client.net;

public final class InetAddressUtils {

	public static String toString(long hash) {
		StringBuilder bldr = new StringBuilder();
		for (int i = 3; i >= 0; i--) {
			bldr.append((hash & 0xff << i * 8) >> i * 8);
			if (i > 0) {
				bldr.append(".");
			}
		}
		return bldr.toString();
	}

	private InetAddressUtils() {

	}

}
