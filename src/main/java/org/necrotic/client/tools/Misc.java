package org.necrotic.client.tools;

import java.text.NumberFormat;

public class Misc {

    public static String formatNumber(double number) {
        return NumberFormat.getInstance().format(number);
    }
	
	private static String OS = null;

	public static String getOsName() {
		if (OS == null) {
			OS = System.getProperty("os.name");
		}
		return OS;
	}

	public static boolean isWindows() {
		return getOsName().startsWith("Windows");
	}


}