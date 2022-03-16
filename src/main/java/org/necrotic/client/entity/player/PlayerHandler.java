package org.necrotic.client.entity.player;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;

import org.necrotic.Configuration;
import org.necrotic.client.Client;
import org.necrotic.client.RSInterface;
import org.necrotic.client.Settings.Save;
import org.necrotic.client.graphics.gameframe.impl.MapArea.XPGain;

public class PlayerHandler {

	public static NumberFormat format;
	public static LinkedList<XPGain> gains = new LinkedList<>();
	public static boolean showXP, showBonus, canGainXP;
	public static int quedBalloonX, quedBalloonY;
	public static long totalXP = 0;
	
	public static void addXP(int id, int exp) {
		if (exp > 0 && canGainXP) {
			totalXP += exp;
			gains.add(new XPGain(id, exp));
		}
	}

	public static int getLevelForXP(int exp) {
		int points = 0;
		int output = 0;

		if (exp > 13034430) {
			return 99;
		}

		for (int lvl = 1; lvl <= 99; lvl++) {
			points += Math.floor(lvl + 300.0 * Math.pow(2.0, lvl / 7.0));
			output = (int) Math.floor(points / 4);

			if (output >= exp) {
				return lvl;
			}
		}

		return 0;
	}
	
	public static int getXPForLevel(int level) {
		int points = 0;
		int output = 0;
		for (int lvl = 1; lvl <= level; lvl++) {
			points += Math.floor(lvl + 300.0 * Math.pow(2.0, lvl / 7.0));
			if (lvl >= level) {
				return output;
			}
			output = (int)Math.floor(points / 4);
		}
		return 0;
	}

	public static int getTotalLevel(Client client) {
		int totalLevel = 0;

		for (int element : client.currentExp) {
			totalLevel += getLevelForXP(element);
		}

		return totalLevel;
	}

	public static void load(Client client) {
		for (int i = 18144; i < 18244; i++) {
			client.setInterfaceText("", i);
		}

		for (int i = 38144; i <= 38244; i++) {
			RSInterface icons = RSInterface.interfaceCache[i];

			if (icons != null) {
				icons.sprite1 = icons.sprite2 = Client.cacheSprite[93];
			}
		}

		if (Configuration.SAVE_ACCOUNTS) {
			Save.settings(Client.getClient());
		}
		canGainXP = true;
		totalXP = 0;
		format = NumberFormat.getInstance(Locale.US);
		quedBalloonX = -1;
		quedBalloonY = -1;
		client.setInputTaken(false);
		client.inputString = "";
	}

}