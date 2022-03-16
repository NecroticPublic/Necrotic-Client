package org.necrotic.client.graphics.gameframe.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Iterator;

import org.necrotic.Configuration;
import org.necrotic.client.Client;
import org.necrotic.client.cache.definition.MobDefinition;
import org.necrotic.client.cache.node.Deque;
import org.necrotic.client.entity.player.Player;
import org.necrotic.client.entity.player.PlayerHandler;
import org.necrotic.client.graphics.DrawingArea;
import org.necrotic.client.graphics.Sprite;
import org.necrotic.client.graphics.fonts.TextClass;
import org.necrotic.client.graphics.gameframe.GameFrame;
import org.necrotic.client.renderable.NPC;

public class MapArea extends GameFrame {

	public class Orb {

		private int drawX, drawY;
		private double fillOrb;
		private boolean orbActive;
		private final OrbType type;
		private OrbValue values;

		public Orb(OrbType type) {
			this.type = type;
		}

		public void draw(Client client, int xPos, int yPos, ScreenMode screenMode) {
			drawX = xPos;
			drawY = yPos;
			int currentValue = values.getCurrentValue();
			int maxValue = values.getMaxValue();
			if(type == OrbType.HITPOINTS) {
				if(!Configuration.CONSTITUTION_ENABLED) {
					currentValue = currentValue / 10;
					maxValue = maxValue / 10;
				}
			}
			int level = (int) ((double) currentValue / (double) maxValue * 100D);
			Client.cacheSprite[screenMode == ScreenMode.FIXED ? isHovering(client, xPos, yPos) && type != OrbType.HITPOINTS ? 334 : 16 : isHovering(client, xPos, yPos) && type != OrbType.HITPOINTS ? 366 : 15].drawSprite(xPos, yPos);

			if (level >= 101) {
				client.newSmallFont.drawCenteredString(Integer.toString(currentValue), xPos + (screenMode == ScreenMode.FIXED ? 42 : 15), yPos + 26, 65280, 0);
			} else if (level <= 100 && level >= 75) {
				client.newSmallFont.drawCenteredString(Integer.toString(currentValue), xPos + (screenMode == ScreenMode.FIXED ? 42 : 15), yPos + 26, 65280, 0);
			} else if (level <= 74 && level >= 50) {
				client.newSmallFont.drawCenteredString(Integer.toString(currentValue), xPos + (screenMode == ScreenMode.FIXED ? 42 : 15), yPos + 26, 0xffff00, 0);
			} else if (level <= 49 && level >= 25) {
				client.newSmallFont.drawCenteredString(Integer.toString(currentValue), xPos + (screenMode == ScreenMode.FIXED ? 42 : 15), yPos + 26, 0xfca607, 0);
			} else if (level <= 24 && level >= 0) {
				client.newSmallFont.drawCenteredString(Integer.toString(currentValue), xPos + (screenMode == ScreenMode.FIXED ? 42 : 15), yPos + 26, 0xf50d0d, 0);
			}

			Client.cacheSprite[orbActive ? type.getSpriteIDs()[1] : type.getSpriteIDs()[0]].drawSprite(xPos + (screenMode == ScreenMode.FIXED ? 3 : 27), yPos + 3);
			double percent = level / 100D;
			fillOrb = 27 * percent;
			int depleteFill = 27 - (int) fillOrb;
			Client.cacheSprite[327].myHeight = depleteFill;
			Client.cacheSprite[327].drawSprite(xPos + (screenMode == ScreenMode.FIXED ? 3 : 27), yPos + 3);
			Client.cacheSprite[type.getSpriteIDs()[type == OrbType.RUN ? orbActive ? 3 : 2 : 2]].drawSprite(xPos + (screenMode == ScreenMode.FIXED ? 9 : 33) + type.getOffSets()[0], yPos + 9 + type.getOffSets()[1]);
		}

		public int getDrawX() {
			return drawX;
		}

		public int getDrawY() {
			return drawY;
		}

		public boolean getOrbState() {
			return orbActive;
		}

		public boolean isHovering(Client client, int xPos, int yPos) {
			if (getScreenMode() == ScreenMode.FIXED) {
				return client.inSprite(false, Client.cacheSprite[15], getxPos() + xPos, getyPos() + yPos);
			} else {
				return client.inSprite(false, Client.cacheSprite[15], xPos, yPos);
			}
		}

		public void setOrbState(boolean active) {
			orbActive = active;
		}

		public void setOrbValues(OrbValue values) {
			this.values = values;
		}

	}

	enum OrbType {

		HITPOINTS(new int[] { 329, -1, 330 }, new int[] { 1, 2 }), 
		PRAYER(new int[] {331, 332, 333 }, new int[] { -2, -2 }), 
		RUN(new int[] { 337, 338, 335, 336 }, new int[] { 0, -1 }), 
		SUMMONING(new int[] {367, 369, 368 }, new int[] { 0, 0 });

		private final int[] offsets;
		private final int[] spriteIDs;

		OrbType(int[] spriteIDs, int[] offsets) {
			this.spriteIDs = spriteIDs;
			this.offsets = offsets;
		}

		public int[] getOffSets() {
			return offsets;
		}

		public int[] getSpriteIDs() {
			return spriteIDs;
		}

	}

	class OrbValue {

		private final int currentValue, maxValue;

		public OrbValue(int currentValue, int maxValue) {
			this.currentValue = currentValue;
			this.maxValue = maxValue;
		}

		public int getCurrentValue() {
			return currentValue;
		}

		public int getMaxValue() {
			return maxValue;
		}
	}

	public static class XPGain {

		private int alpha = 0;

		/**
		 * The skill which gained the xp
		 */
		private final int skill;
		/**
		 * The XP Gained
		 */
		private final int xp;
		private int y;

		public XPGain(int skill, int xp) {
			this.skill = skill;
			this.xp = xp;
		}

		public void decreaseAlpha() {
			alpha -= alpha > 0 ? 30 : 0;
			alpha = alpha > 256 ? 256 : alpha;
		}

		public int getAlpha() {
			return alpha;
		}

		public int getSkill() {
			return skill;
		}

		public int getXP() {
			return xp;
		}

		public int getY() {
			return y;
		}

		public void increaseAlpha() {
			alpha += alpha < 256 ? 30 : 0;
			alpha = alpha > 256 ? 256 : alpha;
		}

		public void increaseY() {
			y++;
		}

	}

	private static final DecimalFormat df;

	static {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setGroupingSeparator(',');
		df = new DecimalFormat("", dfs);
	}

	public Orb hitpoints = new Orb(OrbType.HITPOINTS);
	public Orb prayer = new Orb(OrbType.PRAYER);
	public Orb run = new Orb(OrbType.RUN);
	public Orb summoning = new Orb(OrbType.SUMMONING);
	private final Orb[] allOrbs = { prayer, hitpoints, run, summoning };
	private final NumberFormat format = NumberFormat.getInstance();

	public MapArea(int posX, int posY, int width, int height) {
		super(posX, posY, width, height);
	}
/**
	public void displayMoneyPouch(Client client) {
		final boolean fixed = GameFrame.getScreenMode() == ScreenMode.FIXED;
		int x = fixed ? 446 : Client.clientWidth - 146;
		int y = fixed ? 0 : 118;
		int color = 0xffffff;
		long amount = 0;
		String value = RSInterface.interfaceCache[8135].message;
		amount = Long.parseLong(value == null ? "0" : value);
		if (amount > Integer.MAX_VALUE) {
			amount = Integer.MAX_VALUE;
		}
		value = "" + client.methodR((int) amount);
		if (amount <= 999999) {
			color = 0xffffff;
		} else {
			color = 65280;
		}
		if (client.inSprite(false, Client.cacheSprite[559], x, fixed ? 82 : 48 + y) || client.inSprite(false, Client.cacheSprite[566], getxPos() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 90 : -2), GameFrame.getScreenMode() != ScreenMode.FIXED ? 160 : 82)) {
			Client.cacheSprite[559].drawSprite(x, fixed ? 85 : 48 + y);
		} else {
			Client.cacheSprite[561].drawSprite(x, fixed ? 85 : 48 + y);
		}
		client.smallText.drawRegularText(true, x + 55 - (value != null ? value.length() * 6 : 0), color, value, (fixed ? 100 : 64) + y);
	}
**/
	public void displayXPCounter(Client client) {
		final boolean fixed = GameFrame.getScreenMode() == ScreenMode.FIXED;
		int x = fixed ? 404 : Client.clientWidth - 318;
		int y = fixed ? 0 : -36;
		int currentIndex = 0;
		int offsetY = 0;
		int stop = 70;
		Client.cacheSprite[346].drawSprite(x, fixed ? 50 : 48 + y);
		client.normalText.drawRegularText(true, x + 3, 0xffffff, "XP:", (fixed ? 63 : 61) + y);
		String str = df.format(PlayerHandler.totalXP);
		int width = client.normalText.getTextWidth(str);
		if (PlayerHandler.totalXP >= 0 && PlayerHandler.totalXP < 1000000000) {
			client.normalText.drawRegularText(true, x + 99 - width, 0xffffff, str, (fixed ? 63 : 61) + y);
		} else {
			client.normalText.drawRegularText(true, x + 99 - client.normalText.getTextWidth("Lots!"), 0xFF0000, "Lots!", (fixed ? 63 : 61) + y);
		}

		if (!PlayerHandler.gains.isEmpty()) {
			Iterator<XPGain> it = PlayerHandler.gains.iterator();

			while (it.hasNext()) {
				XPGain gain = it.next();

				if (gain.getY() < stop) {
					if (gain.getY() <= 10) {
						gain.increaseAlpha();
					}

					if (gain.getY() >= stop - 10) {
						gain.decreaseAlpha();
					}

					gain.increaseY();
				} else if (gain.getY() == stop) {
					it.remove();
				}

				int spriteId = gain.getSkill() + 498;
				
				if(gain.getSkill() == 23) {
					spriteId = 393;
				} else if(gain.getSkill() == 24) {
					spriteId = 521;
				}
				
				Sprite sprite = Client.cacheSprite[spriteId];

				if (PlayerHandler.gains.size() > 1) {
					offsetY = (fixed ? 0 : -20) + currentIndex * 28;
				}

				if (gain.getY() < stop) {
					sprite.drawSprite(x + 15 - sprite.myWidth / 2, gain.getY() + offsetY + 66 - sprite.myHeight / 2, gain.getAlpha());
					client.newSmallFont.drawBasicString("<trans=" + gain.getAlpha() + ">+" + format.format(gain.getXP()) + "xp", x + 30, gain.getY() + offsetY + 70, 0xCC6600, 0, false);
				}

				currentIndex++;
			}
		}
	}

	@Override
	public boolean isHovering(Client client, ScreenMode screenMode) {
		if (!isVisible()) {
			return false;
		}

		for (Orb orb : allOrbs) {
			if (orb.isHovering(client, orb.getDrawX(), orb.getDrawY())) {
				return true;
			}
		}

		if (client.inSprite(false, client.compass, getOffSetX() + (screenMode == ScreenMode.FIXED ? 6 : 5), getOffSetY() + (screenMode == ScreenMode.FIXED ? 8 : 5))) {
			return true;
		}

		if (client.mouseInCircle(getOffSetX() + Client.cacheSprite[13].myWidth / 2, getOffSetY() + Client.cacheSprite[13].myHeight / 2, Client.cacheSprite[13].myWidth / 2)) {
			return true;
		}

		return false;
	}

	public void loadOrbs(Client client, ScreenMode screenMode) {
		try {

			prayer.setOrbValues(new OrbValue(client.currentStats[5], client.maxStats[5]));
			prayer.draw(client, GameFrame.getScreenMode() != ScreenMode.FIXED ? Client.clientWidth - 215 : 186, GameFrame.getScreenMode() != ScreenMode.FIXED ? 73 : 54, screenMode);
			hitpoints.setOrbValues(new OrbValue(client.currentStats[3], client.maxStats[3]));
			hitpoints.draw(client, GameFrame.getScreenMode() != ScreenMode.FIXED ? Client.clientWidth - 212 : 172, GameFrame.getScreenMode() != ScreenMode.FIXED ? 39 : 15, screenMode);
			run.setOrbValues(new OrbValue(client.energy, 100));
			run.draw(client, GameFrame.getScreenMode() != ScreenMode.FIXED ? Client.clientWidth - 203 : 184, GameFrame.getScreenMode() != ScreenMode.FIXED ? 107 : 93, screenMode);
			summoning.setOrbValues(new OrbValue(client.currentStats[23], client.maxStats[23]));
			summoning.draw(client, GameFrame.getScreenMode() != ScreenMode.FIXED ? Client.clientWidth - 179 : 167, GameFrame.getScreenMode() != ScreenMode.FIXED ? 136 : 129, screenMode);
			if (client.inSprite(false, Client.cacheSprite[345], getxPos() - (GameFrame.getScreenMode() == ScreenMode.FIXED ? 2 : 40), getyPos() + (GameFrame.getScreenMode() == ScreenMode.FIXED ? 46 : 2))) {
				Client.cacheSprite[344].drawSprite(getOffSetX() - (GameFrame.getScreenMode() == ScreenMode.FIXED ? 2 : 40), getOffSetY() + (GameFrame.getScreenMode() == ScreenMode.FIXED ? 46 : 2));
			} else {
				Client.cacheSprite[345].drawSprite(getOffSetX() - (GameFrame.getScreenMode() == ScreenMode.FIXED ? 2 : 40), getOffSetY() + (GameFrame.getScreenMode() == ScreenMode.FIXED ? 46 : 2));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void processMinimapActions(Client client) {
		if (run.isHovering(client, run.getDrawX(), run.getDrawY())) {
			client.menuActionName[1] = "Rest";
			client.menuActionID[1] = 1036;
			client.menuActionName[2] = !run.getOrbState() ? "Turn run mode on" : "Turn run mode off";
			client.menuActionID[2] = 1050;
			client.menuActionRow = 3;
		}
		if (prayer.isHovering(client, prayer.getDrawX(), prayer.getDrawY())) {
			String prayerType = (client.prayerInterfaceType == 5608) ? "prayers" : "curses";
			boolean inProcess = (Client.tabInterfaceIDs[5] == 17200 || Client.tabInterfaceIDs[5] == 17234);
			client.menuActionName[client.menuActionRow] = (inProcess ? "Finish" : "Select") + " " + "quick " + prayerType + (inProcess ? " selection" : "");
			client.menuActionID[client.menuActionRow] = 1046;
			client.menuActionRow++;
			client.menuActionName[client.menuActionRow] = "Turn quick " + prayerType + " " + (prayer.getOrbState() ? "off" : "on");
			client.menuActionID[client.menuActionRow] = 1045;
			client.menuActionRow++;
		}
		if (summoning.isHovering(client, summoning.getDrawX(), summoning.getDrawY())) {
			client.menuActionName[1] = "BoB interface";
			client.menuActionID[1] = 1041;
			client.menuActionName[2] = "Quick empty BoB";
			client.menuActionID[2] = 1040;
			client.menuActionName[3] = "Dismiss familiar";
			client.menuActionID[3] = 1039;
			client.menuActionName[4] = "Renew familiar";
			client.menuActionID[4] = 1038;
			client.menuActionName[5] = "Call familiar";
			client.menuActionID[5] = 1037;
			client.menuActionRow = 6;
		}
				
		if (client.getClickMode2() == 1 && client.mouseX >= Client.clientWidth - Client.cacheSprite[342].myWidth && client.mouseX < Client.clientWidth && client.mouseY >= 0 && client.mouseY <= Client.cacheSprite[342].myHeight) {
			if (client.tabArea.componentHidden()) {
				client.tabArea.setHideComponent(false);
			}
			Client.setTab(14);
		}
/*//MONEY POUCH
		if (client.inSprite(false, Client.cacheSprite[566], getxPos() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 90 : -2), GameFrame.getScreenMode() != ScreenMode.FIXED ? 160 : 82)) {
			client.menuActionName[3] = "Toggle money pouch";
			client.menuActionID[3] = 712;
			client.menuActionName[2] = "Withdraw money pouch";
			client.menuActionID[2] = 713;
			client.menuActionName[1] = "Examine money pouch";
			client.menuActionID[1] = 715;
			client.menuActionRow = 4;
		}
*/
		if (client.inSprite(false, Client.cacheSprite[345], getxPos() - (GameFrame.getScreenMode() == ScreenMode.FIXED ? 2 : 40), getyPos() + (GameFrame.getScreenMode() == ScreenMode.FIXED ? 46 : 2))) {
			client.menuActionName[1] = "Toggle Exp Lock";
			client.menuActionID[1] = 1095;
			client.menuActionName[2] = "Reset counter";
			client.menuActionID[2] = 1013;
			client.menuActionName[3] = PlayerHandler.showXP ? "Hide counter" : "Show counter";
			client.menuActionID[3] = 1006;
			client.menuActionRow = 4;
		}
		
		if (client.inSprite(false, Client.cacheSprite[457], getxPos() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 130 : 6), getyPos() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 132 : 124))) { //handleglobe
			client.menuActionName[1] = "Teleportation";
			client.menuActionID[1] = 1042;
			client.menuActionRow = 2;
		}

		if (client.mouseX >= Client.clientWidth - (getScreenMode() == ScreenMode.FIXED ? 242 : 164) && client.mouseX <= Client.clientWidth - (getScreenMode() == ScreenMode.FIXED ? 203 : 129) && client.mouseY > (getScreenMode() == ScreenMode.FIXED ? 6 : 0) && client.mouseY < (getScreenMode() == ScreenMode.FIXED ? 42 : 37)) {
			client.menuActionName[1] = "Face North";
			client.menuActionID[1] = 1014;
			client.menuActionRow = 2;
		}
	}

	/*
	 * public void updateMinimapImage() { if(GameFrame.getScreenMode() ==
	 * ScreenMode.FIXED) return; Client.cacheSprite[449].drawSprite(getxPos(),
	 * getyPos()); //Client.cacheSprite[449].blend(); }
	 */

	@Override
	protected void render(Client client, ScreenMode screenMode) {
		if (isVisible()) {
			client.rotateCam(); //rotate cam
			if (screenMode == ScreenMode.FIXED) {
				client.mapAreaIP.initDrawingArea();
			}

			if (client.anInt1021 == 2) {
				loadOrbs(client, screenMode);
				client.compass.rotate(33, client.viewRotation, client.compassArray2, 256, client.compassArray1, 25, getOffSetY() + (screenMode == ScreenMode.FIXED ? 8 : 4), getOffSetX() + (screenMode == ScreenMode.FIXED ? 7 : 5), 33, 25);
				client.gameScreenIP.initDrawingArea();
				return;
			}

			int i = client.viewRotation + client.minimapRotation & 0x7ff;
			int playerPosX = 48 + Client.myPlayer.x / 32;
			int playerPosY = 464 - Client.myPlayer.y / 32;
			/*
			 * for (int j1 = 0; j1 < client.anIntArray1229.length; j1++) {
			 * client.anIntArray1229[j1] = 172; client.anIntArray1052[j1] = -22;
			 * }
			 */
			client.miniMapRegions.rotate(152, i, client.mapImagePixelCutRight, 256 + client.minimapZoom, client.mapImagePixelCutLeft, playerPosY, getOffSetY() + (screenMode == ScreenMode.FIXED ? 10 : 5), getOffSetX() + (screenMode == ScreenMode.FIXED ? 31 : 11), 152, playerPosX);
			client.compass.rotate(33, client.viewRotation, client.compassArray2, 256, client.compassArray1, 25, getOffSetY() + (screenMode == ScreenMode.FIXED ? 8 : 5), getOffSetX() + (screenMode == ScreenMode.FIXED ? 7 : 5), 33, 25);

			for (int j5 = 0; j5 < client.anInt1071; j5++) {
				try {
					int mapX = client.anIntArray1072[j5] * 4 + 2 - Client.myPlayer.x / 32;
					int mapY = client.anIntArray1073[j5] * 4 + 2 - Client.myPlayer.y / 32;
					client.markMinimap(client.aClass30_Sub2_Sub1_Sub1Array1140[j5], mapX, mapY);
					for (int iconI = 0; iconI < client.customMinimapIcons.size(); iconI++) {
						client.markMinimap(client.customMinimapIcons.get(iconI).getSprite(), ((client.customMinimapIcons.get(iconI).getX() - client.baseX) * 4 + 2) - client.myPlayer.x / 32, ((client.customMinimapIcons.get(iconI).getY() - client.baseY) * 4 + 2) - client.myPlayer.y / 32);
					}
				} catch (Exception exception) {
				}
			}

			for (int k5 = 0; k5 < 104; k5++) {
				for (int l5 = 0; l5 < 104; l5++) {
					Deque class19 = client.groundArray[client.plane][k5][l5];
					if (class19 != null) {

						int l = k5 * 4 + 2 - Client.myPlayer.x / 32;
						int j3 = l5 * 4 + 2 - Client.myPlayer.y / 32;
						client.markMinimap(client.mapDotItem, l, j3);
					}
				}

			}

			for (int i6 = 0; i6 < client.npcCount; i6++) {
				NPC npc = client.npcArray[client.npcIndices[i6]];
				if (npc != null && npc.isVisible()) {
					MobDefinition entityDef = npc.definitionOverride;
					if (entityDef.childrenIDs != null) {
						entityDef = entityDef.method161();
					}
					if (entityDef != null && entityDef.drawYellowDotOnMap && entityDef.disableRightClick) {
						int i1 = npc.x / 32 - Client.myPlayer.x / 32;
						int k3 = npc.y / 32 - Client.myPlayer.y / 32;
						client.markMinimap(client.mapDotNPC, i1, k3);
					}
				}
			}

			for (int j6 = 0; j6 < client.playerCount; j6++) {
				Player player = client.playerArray[client.playerIndices[j6]];
				if (player != null && player.isVisible()) {
					int x = player.x / 32 - Client.myPlayer.x / 32;
					int y = player.y / 32 - Client.myPlayer.y / 32;
					boolean isInFriends = false;
					boolean isInClan = false;
					for (int j3 = 0; j3 < client.clanMembers.length; j3++) {
						if (client.clanMembers[j3] == null) {
							continue;
						}
						if (!client.clanMembers[j3].equalsIgnoreCase(player.name)) {
							continue;
						}
						isInClan = true;
						break;
					}
					/*
					 * for (int k6 = 0; k6 < PlayerHandler.friends.size(); k6++)
					 * { if
					 * (!PlayerHandler.friends.get(k6).getName().equals(player
					 * .name) || PlayerHandler.friends.get(k6).getState() == 0)
					 * { continue; } flag1 = true; break; }
					 */
					long l6 = TextClass.longForName(player.name);
					for (int k6 = 0; k6 < client.friendCount; k6++) {
						if (l6 != client.friendsListAsLongs[k6] || client.friendsNodeIDs[k6] == 0) {
							continue;
						}
						isInFriends = true;
						break;
					}
					boolean isInTeam = false;
					if (Client.myPlayer.team != 0 && player.team != 0 && Client.myPlayer.team == player.team) {
						isInTeam = true;
					}
					if (isInFriends) {
						client.markMinimap(client.mapDotFriend, x, y);
					} else if (isInClan) {
						client.markMinimap(client.mapDotClan, x, y);
					} else if (isInTeam) {
						client.markMinimap(client.mapDotTeam, x, y);
					} else {
						client.markMinimap(client.mapDotPlayer, x, y);
					}
				}
			}

			if (client.anInt855 != 0 && Client.loopCycle % 20 < 10) {
				if (client.anInt855 == 1 && client.anInt1222 >= 0 && client.anInt1222 < client.npcArray.length) {
					NPC class30_sub2_sub4_sub1_sub1_1 = client.npcArray[client.anInt1222];
					if (class30_sub2_sub4_sub1_sub1_1 != null) {
						int k1 = class30_sub2_sub4_sub1_sub1_1.x / 32 - Client.myPlayer.x / 32;
						int i4 = class30_sub2_sub4_sub1_sub1_1.y / 32 - Client.myPlayer.y / 32;
						client.drawMinimapFlag(client.mapMarker, i4, k1);
					}
				}

				if (client.anInt855 == 2 || client.anInt855 == 5) {
					int l1 = (client.anInt934 - client.baseX) * 4 + 2 - Client.myPlayer.x / 32;
					int j4 = (client.anInt935 - client.baseY) * 4 + 2 - Client.myPlayer.y / 32;
					client.drawMinimapFlag(client.mapMarker, j4, l1);
				}

				if (client.anInt855 == 10 && client.anInt933 >= 0 && client.anInt933 < client.playerArray.length) {
					Player class30_sub2_sub4_sub1_sub2_1 = client.playerArray[client.anInt933];
					if (class30_sub2_sub4_sub1_sub2_1 != null) {
						int i2 = class30_sub2_sub4_sub1_sub2_1.x / 32 - Client.myPlayer.x / 32;
						int k4 = class30_sub2_sub4_sub1_sub2_1.y / 32 - Client.myPlayer.y / 32;
						client.drawMinimapFlag(client.mapMarker, k4, i2);
					}
				}
			}

			if (client.destX != 0) {
				int j2 = client.destX * 4 + 2 - Client.myPlayer.x / 32;
				int l4 = client.destY * 4 + 2 - Client.myPlayer.y / 32;
				client.markMinimap(client.mapFlag, j2, l4);
			}

			client.compass.rotate(33, client.viewRotation, client.compassArray2, 256, client.compassArray1, 25, getOffSetY() + (screenMode == ScreenMode.FIXED ? 8 : 4), getOffSetX() + (screenMode == ScreenMode.FIXED ? 7 : 5), 33, 25);
			Client.cacheSprite[screenMode == ScreenMode.FIXED ? 14 : 13].drawSprite(getOffSetX() - (screenMode == ScreenMode.FIXED ? 1 : 0), getOffSetY() - (screenMode == ScreenMode.FIXED ? 0 : 1));

			/*
			 * Globe
			 */
			if (screenMode != ScreenMode.FIXED) {
				Client.cacheSprite[461].drawSprite(getOffSetX() + 125, getOffSetY() + 128);
			}
			if (client.inSprite(false, Client.cacheSprite[456], getxPos() + (screenMode != ScreenMode.FIXED ? 130 : 6), getyPos() + (screenMode != ScreenMode.FIXED ? 132 : 124))) { //handleglobe
				Client.cacheSprite[457].drawSprite(getOffSetX() + (screenMode != ScreenMode.FIXED ? 130 : 6), getOffSetY() + (screenMode != ScreenMode.FIXED ? 132 : 124));
			} else {
				Client.cacheSprite[456].drawSprite(getOffSetX() + (screenMode != ScreenMode.FIXED ? 130 : 6), getOffSetY() + (screenMode != ScreenMode.FIXED ? 132 : 124));
			}

			/*
			 * Orbs
			 */
			loadOrbs(client, screenMode);

			/*
			 * Logout button
			 */
			if (client.mouseX >= Client.clientWidth - Client.cacheSprite[342].myWidth && client.mouseX < Client.clientWidth && client.mouseY >= 0 && client.mouseY <= Client.cacheSprite[342].myHeight) {
				Client.cacheSprite[342].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 149 : 225), 0);
			} else {
				Client.cacheSprite[341].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 149 : 225), 0);
			}

			if (client.inSprite(false, Client.cacheSprite[342], getxPos() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 149 : 225), 0)) {
				Client.cacheSprite[342].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 149 : 225), 0);
			} else {
				Client.cacheSprite[341].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 149 : 225), 0);
			}

			
			
			if (Configuration.MONEY_POUCH_ENABLED) {

				final boolean fixed = GameFrame.getScreenMode() == ScreenMode.FIXED;
				int x = fixed ? 446 : Client.clientWidth - 146;
				int y = fixed ? 0 : 118;
				if (client.inSprite(false, Client.cacheSprite[559], x, fixed ? 82 : 48 + y) || client.inSprite(false, Client.cacheSprite[565], getxPos() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 90 : -2), GameFrame.getScreenMode() != ScreenMode.FIXED ? 160 : 82)) {
					Client.cacheSprite[564].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 90 : -2), GameFrame.getScreenMode() != ScreenMode.FIXED ? 160 : 82);
				} else {
					//Client.cacheSprite[566].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 90 : -2), GameFrame.getScreenMode() != ScreenMode.FIXED ? 160 : 82);
				}
			/*} else {
				if (client.inSprite(false, Client.cacheSprite[566], getxPos() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 90 : -2), GameFrame.getScreenMode() != ScreenMode.FIXED ? 160 : 82)) {
					Client.cacheSprite[564].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 90 : -2), GameFrame.getScreenMode() != ScreenMode.FIXED ? 160 : 82);
				} else {
					Client.cacheSprite[566].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 90 : -2), GameFrame.getScreenMode() != ScreenMode.FIXED ? 160 : 82);
				}*/
			}

			if (Client.tabID == 14) {
				Client.cacheSprite[343].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 149 : 225), 0);
			}

			if (client.inSprite(false, Client.cacheSprite[458], getxPos() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 128 : 204), 0)) {
				Client.cacheSprite[459].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 128 : 204), 0);
			} else {
				Client.cacheSprite[458].drawSprite(getOffSetX() + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 128 : 204), 0);
			}

			DrawingArea.drawPixels(3, 76 + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 4 : 8) + getOffSetY(), 76 + (GameFrame.getScreenMode() != ScreenMode.FIXED ? 9 : 29) + getOffSetX(), 0xffffff, 3);

			if (client.menuOpen && client.menuScreenArea == 3) {
				client.drawMenu();
			}

		}
		client.gameScreenIP.initDrawingArea();

	}

}
			