package org.necrotic.client.graphics.rsinterface;

import org.necrotic.client.Client;
import org.necrotic.client.RSInterface;
import org.necrotic.client.cache.definition.ItemDefinition;
import org.necrotic.client.graphics.DrawingArea;
import org.necrotic.client.graphics.Sprite;
import org.necrotic.client.graphics.gameframe.GameFrame;
import org.necrotic.client.graphics.gameframe.GameFrame.ScreenMode;

public class GrandExchange {

	public int itemSelected;
	
	/** SEARCH **/
	public boolean searching;
	public int totalItemResults;
	public String itemResultNames[] = new String[100];
	public int itemResultIDs[] = new int[100];
	public int itemResultScrollPos;
	
	/** MAIN INTERFACE **/
	public int Slots[] = new int[7];
	public String slots[] = new String[7];
	public int slotColorPercent[] = new int[7];
	public int slotItems[] = new int[7];
	public boolean slotAborted[] = new boolean[7];
	public int slotSelected;
	
	public void update(String data) {
		int geSlot = Integer.parseInt(data.substring(data.indexOf("<") + 1, data.indexOf(">")));
		int geData = -1;
		if(data.contains("slotaborted")) {
			slotAborted[geSlot] = true;
		}
		if(data.contains("slotselected")) {
			slotSelected = geSlot;
		}
		if(data.contains("resetslot")) {
			slots[geSlot] = "";
			Slots[geSlot] = 0;
			slotColorPercent[geSlot] = 0;
			slotAborted[geSlot] = false;
		}
		if(data.contains("slotsell")) {
			geData = Integer.parseInt(data.substring(data.indexOf("[") + 1, data.indexOf("]")));
			slots[geSlot] = "Sell";
			Slots[geSlot] = geData;
			slotAborted[geSlot] = false;
			slotColorPercent[geSlot] = 0;
		}
		if(data.contains("item")) {
			int itemId = Integer.parseInt(data.substring(data.indexOf("#") + 1, data.lastIndexOf("#")));
			slotItems[geSlot] = itemId;
		}
		if(data.contains("slotbuy")) {
			geData = Integer.parseInt(data.substring(data.indexOf("[") + 1, data.indexOf("]")));
			slots[geSlot] = "Buy";
			Slots[geSlot] = geData;
			slotAborted[geSlot] = false;
			slotColorPercent[geSlot] = 0;
		}
		if(data.contains("slotpercent")) {
			geData = Integer.parseInt(data.substring(data.indexOf("{") + 1, data.indexOf("}")));
			slotColorPercent[geSlot] = geData;
		}
	}
	
	public void drawGrandExchange() {
		if (Client.openInterfaceID != 24500 && Client.openInterfaceID != 54700
				&& Client.openInterfaceID != 53700) {
			return;
		}
		if (Client.openInterfaceID == 24500) {
			for (int i = 1; i < Slots.length; i++) {
				if (Slots[i] == 0) {
					drawUpdate(i, "Regular");
				}
				if (Slots[i] == 1 && slots[i] == "Sell") {
					drawUpdate(i, "Submit Sell");
				}
				if (Slots[i] == 1 && slots[i] == "Buy") {
					drawUpdate(i, "Submit Buy");
				}
				if (Slots[i] == 2 && slots[i] == "Sell") {
					drawUpdate(i, "Sell");
				}
				if (Slots[i] == 2 && slots[i] == "Buy") {
					drawUpdate(i, "Buy");
				}
				if (Slots[i] == 3 && slots[i] == "Sell") {
					drawUpdate(i, "Finished Selling");
				}
				if (Slots[i] == 3 && slots[i] == "Buy") {
					drawUpdate(i, "Finished Buying");
				}
			}
		}
		int x = 0;
		int y = 0;
		x = (GameFrame.getScreenMode() == ScreenMode.FIXED) ? 71 : (71 + (Client.clientWidth / 2 - 256));
		y = (GameFrame.getScreenMode() == ScreenMode.FIXED) ? 303 : (Client.clientHeight / 2 + 136);
		if (Client.openInterfaceID == 54700) {
			per4 = Client.cacheSprite[1158];
			per5 = Client.cacheSprite[1159];
			per6 = Client.cacheSprite[1160];
			abort2 = Client.cacheSprite[1161];
			if (slotColorPercent[slotSelected] == 100 || slotAborted[slotSelected]) {
				RSInterface.interfaceCache[54800].tooltip = "[GE]";
			} else {
				RSInterface.interfaceCache[54800].tooltip = "Abort offer";
			}
			if (slotSelected <= 6) {
				if (!slotAborted[slotSelected]) {
					for (int k9 = 1; k9 < slotColorPercent[slotSelected]; k9++) {
						if (slotColorPercent[slotSelected] > 0) {
							if (k9 == 1) {
								if (per4 != null)
									per4.drawSprite(x, y);
								x += 3;
							} else if (k9 == 99) {
								if (per6 != null)
									per6.drawSprite(x, y);
								x += 4;
							} else {
								if (per5 != null)
									per5.drawSprite(x, y);
								x += 3;
							}
						}
					}
				} else {
					if (abort2 != null)
						abort2.drawSprite(x, y);
				}
			}
		}
		x = (GameFrame.getScreenMode() == ScreenMode.FIXED) ? 71 : (71 + (Client.clientWidth / 2 - 256));
		y = (GameFrame.getScreenMode() == ScreenMode.FIXED) ? 303 : (Client.clientHeight / 2 + 136);
		if (Client.openInterfaceID == 53700) {
			per4 = Client.cacheSprite[1158];
			per5 = Client.cacheSprite[1159];
			per6 = Client.cacheSprite[1160];
			abort2 = Client.cacheSprite[1161];
			if (slotColorPercent[slotSelected] == 100
					|| slotAborted[slotSelected]) {
				RSInterface.interfaceCache[53800].tooltip = "[GE]";
			} else {
				RSInterface.interfaceCache[53800].tooltip = "Abort offer";
			}
			if (slotSelected <= 6) {
				if (!slotAborted[slotSelected]) {
					for (int k9 = 1; k9 < slotColorPercent[slotSelected]; k9++) {
						if (slotColorPercent[slotSelected] > 0) {
							if (k9 == 1) {
								if (per4 != null)
									per4.drawSprite(x, y);
								x += 3;
							} else if (k9 == 99) {
								if (per6 != null)
									per6.drawSprite(x, y);
								x += 4;
							} else {
								if (per5 != null)
									per5.drawSprite(x, y);
								x += 3;
							}
						}
					}
				} else {
					if (abort2 != null)
						abort2.drawSprite(x, y);
				}
			}
		}
	}
	
	public void drawUpdate(int id, String type) {
		int x = 0;
		int y = 0;
		int x2 = 0;
		int y2 = 0;
		int x3 = 0;
		int y3 = 0;
		boolean fixed = (GameFrame.getScreenMode() == ScreenMode.FIXED);
		switch (id) {
		case 1:
			x = fixed ? 30 : (Client.clientWidth / 2 - 226);
			x2 = fixed ? 80 : (Client.clientWidth / 2 - 226 + 50);
			x3 = fixed ? 40 : (Client.clientWidth / 2 - 226 + 10);
			y = fixed ? 74 : (Client.clientHeight / 2 - 93);
			y2 = fixed ? 136 : (Client.clientHeight / 2 - 93 + 62);
			y3 = fixed ? 115 : (Client.clientHeight / 2 - 93 + 41);
			break;
		case 2:
			x = fixed ? 186 : (Client.clientWidth / 2 - 70);
			x2 = fixed ? 80 + 156 : (Client.clientWidth / 2 - 70 + 50);
			x3 = fixed ? 40 + 156 : (Client.clientWidth / 2 - 70 + 10);
			y = fixed ? 74 : (Client.clientHeight / 2 - 93);
			y2 = fixed ? 136 : (Client.clientHeight / 2 - 93 + 62);
			y3 = fixed ? 115 : (Client.clientHeight / 2 - 93 + 41);
			break;
		case 3:
			x = fixed ? 342 : (Client.clientWidth / 2 + 86);
			x2 = fixed ? 80 + 156 + 156 : (Client.clientWidth / 2 + 86 + 50);
			x3 = fixed ? 40 + 156 + 156 : (Client.clientWidth / 2 + 86 + 10);
			y = fixed ? 74 : (Client.clientHeight / 2 - 93);
			y2 = fixed ? 136 : (Client.clientHeight / 2 - 93 + 62);
			y3 = fixed ? 115 : (Client.clientHeight / 2 - 93 + 41);
			break;
		case 4:
			x = fixed ? 30 : (Client.clientWidth / 2 - 226);
			x2 = fixed ? 80 : (Client.clientWidth / 2 - 226 + 50);
			x3 = fixed ? 40 : (Client.clientWidth / 2 - 226 + 10);
			y = fixed ? 194 : (Client.clientHeight / 2 + 27);
			y2 = fixed ? 256 : (Client.clientHeight / 2 + 27 + 62);
			y3 = fixed ? 235 : (Client.clientHeight / 2 + 27 + 41);
			break;
		case 5:
			x = fixed ? 186 : (Client.clientWidth / 2 - 70);
			x2 = fixed ? 80 + 156 : (Client.clientWidth / 2 - 70 + 50);
			x3 = fixed ? 40 + 156 : (Client.clientWidth / 2 - 70 + 10);
			y = fixed ? 194 : (Client.clientHeight / 2 + 27);
			y2 = fixed ? 256 : (Client.clientHeight / 2 + 27 + 62);
			y3 = fixed ? 235 : (Client.clientHeight / 2 + 27 + 41);
			break;
		case 6:
			x = fixed ? 342 : (Client.clientWidth / 2 + 86);
			x2 = fixed ? 80 + 156 + 156 : (Client.clientWidth / 2 + 86 + 50);
			x3 = fixed ? 40 + 156 + 156 : (Client.clientWidth / 2 + 86 + 10);
			y = fixed ? 194 : (Client.clientHeight / 2 + 27);
			y2 = fixed ? 256 : (Client.clientHeight / 2 + 27 + 62);
			y3 = fixed ? 235 : (Client.clientHeight / 2 + 27 + 41);
			break;
		}
		x -= 2;
		x2 -= 2;
		x3 -= 2;
		int minus = 20;
		if (type == "Sell") {
			if (Client.getClient().mouseX() >= x && Client.getClient().mouseX() <= x + 140 && Client.getClient().mouseY() >= y && Client.getClient().mouseY() <= y + 110 && !Client.getClient().menuOpen) {
				SellHover = Client.cacheSprite[1168];
				if (SellHover != null)
					SellHover.drawSprite(x, y);
			} else {
				Client.cacheSprite[1169].drawSprite(x, y);
			}
			Client.cacheSprite[1170].drawSprite(x + 6, y + 30);
			if(slotItems[id] > 0 && ItemDefinition.getSprite(slotItems[id], 1, 0) != null)
				ItemDefinition.getSprite(slotItems[id], 1, 0).drawSprite(x + 9, y + 32);
			Client.getClient().drawInterface(0, x + 110, RSInterface.interfaceCache[54000], y + 38);
			setGrandExchange(id, false);
			if (slotAborted[id] || slotColorPercent[id] == 100) {
				changeSet(id, true, false);
			} else {
				changeSet(id, true, true);
			}
			drawPercentage(id);
			Client.getClient().smallText.method592(0xCC9900, x2,
					RSInterface.interfaceCache[32000 + id].message, y2 - minus,
					true);
			Client.getClient().smallText.method592(0xBDBB5B, x2,
					RSInterface.interfaceCache[33000 + id].message, y2, true);
			Client.getClient().smallText.method592(0xFFFF00, x3,
					RSInterface.interfaceCache[33100 + id].message, y3, true);
			setHovers(id, false);
			if(Client.cacheSprite[1145] != null) {
				Client.cacheSprite[1145].drawSprite(x + 110, y + 39);
				if(Client.getClient().mouseInRegion(x + 112, y + 38, x + 132, y + 60)) {
					Client.cacheSprite[1146].drawSprite(x + 110, y + 39);
					changeSet(id, false, true);
				}
			}
			String name[] = Client.optimizeText(ItemDefinition.get(slotItems[id]).name).split(" ");
			int index = 0;
			for(String n : name) {
				int xDraw = x + 77;
				int yDraw = y + (name.length > 2 ? 41 : 48) + (index * 15); 
				Client.getClient().smallText.drawCenteredText(0xA05A00, xDraw, n, yDraw, false);
				index++;
			}
		} else if (type == "Buy") {
			if (Client.getClient().mouseX() >= x && Client.getClient().mouseX() <= x + 140
					&& Client.getClient().mouseY() >= y && Client.getClient().mouseY() <= y + 110
					&& !Client.getClient().menuOpen) {
				BuyHover = Client.cacheSprite[1167];
				if (BuyHover != null)
					BuyHover.drawSprite(x, y);
			} else {
				Client.cacheSprite[1171].drawSprite(x, y);
			}
			Client.cacheSprite[1170].drawSprite(x + 6, y + 30);
			if(slotItems[id] > 0 && ItemDefinition.getSprite(slotItems[id], 1, 0) != null)
				ItemDefinition.getSprite(slotItems[id], 1, 0).drawSprite(x + 9, y + 32);
			setGrandExchange(id, false);
			if (slotAborted[id] || slotColorPercent[id] == 100) {
				changeSet(id, true, false);
			} else {
				changeSet(id, true, true);
			}
			drawPercentage(id);
			Client.getClient().smallText.method592(0xCC9900, x2,
					RSInterface.interfaceCache[32000 + id].message, y2 - minus,
					true);
			Client.getClient().smallText.method592(0xBDBB5B, x2,
					RSInterface.interfaceCache[33000 + id].message, y2, true);
			Client.getClient().smallText.method592(0xFFFF00, x3,
					RSInterface.interfaceCache[33100 + id].message, y3, true);
			setHovers(id, false);
			if(Client.cacheSprite[1145] != null) {
				Client.cacheSprite[1145].drawSprite(x + 110, y + 39);
				if(Client.getClient().mouseInRegion(x + 112, y + 38, x + 132, y + 60)) {
					Client.cacheSprite[1146].drawSprite(x + 110, y + 39);
					changeSet(id, false, true);
				}
			}
			String name[] = Client.optimizeText(ItemDefinition.get(slotItems[id]).name).split(" ");
			int index = 0;
			for(String n : name) {
				int xDraw = x + 77;
				int yDraw = y + (name.length > 2 ? 41 : 48) + (index * 15); 
				Client.getClient().smallText.drawCenteredText(0xA05A00, xDraw, n, yDraw, false);
				index++;
			}
		} else if (type == "Submit Buy") {
			if (Client.getClient().mouseX() >= x && Client.getClient().mouseX() <= x + 140
					&& Client.getClient().mouseY() >= y && Client.getClient().mouseY() <= y + 110
					&& !Client.getClient().menuOpen) {
				buySubmitHover = Client.cacheSprite[1172];
				if (buySubmitHover != null)
					buySubmitHover.drawSprite(x, y);
			} else {
				Client.cacheSprite[27].drawSprite(x, y);
			}
			setGrandExchange(id, false);
			changeSet(id, false, false);
			Client.getClient().smallText.method592(0xCC9900, x2,
					RSInterface.interfaceCache[32000 + id].message, y2 - minus,
					true);
			Client.getClient().smallText.method592(0xBDBB5B, x2,
					RSInterface.interfaceCache[33000 + id].message, y2, true);
			Client.getClient().smallText.method592(0xFFFF00, x3,
					RSInterface.interfaceCache[33100 + id].message, y3, true);
			setHovers(id, false);
		} else if (type == "Submit Sell") {
			if (Client.getClient().mouseX() >= x && Client.getClient().mouseX() <= x + 140
					&& Client.getClient().mouseY() >= y && Client.getClient().mouseY() <= y + 110
					&& !Client.getClient().menuOpen) {
				sellSubmitHover = Client.cacheSprite[1173];
				if (sellSubmitHover != null)
					sellSubmitHover.drawSprite(x, y);
			} else {
				Client.cacheSprite[28].drawSprite(x, y);
			}
			setGrandExchange(id, false);
			changeSet(id, false, false);
			Client.getClient().smallText.method592(0xCC9900, x2,
					RSInterface.interfaceCache[32000 + id].message, y2 - minus,
					true);
			Client.getClient().smallText.method592(0xBDBB5B, x2,
					RSInterface.interfaceCache[33000 + id].message, y2, true);
			Client.getClient().smallText.method592(0xFFFF00, x3,
					RSInterface.interfaceCache[33100 + id].message, y3, true);
			setHovers(id, false);
		} else if (type == "Regular") {
			setGrandExchange(id, true);
			setHovers(id, true);

		} else if (type == "Finished Selling") {
			if (Client.getClient().mouseX() >= x && Client.getClient().mouseX() <= x + 140
					&& Client.getClient().mouseY() >= y && Client.getClient().mouseY() <= y + 110
					&& !Client.getClient().menuOpen) {
				SellHover = Client.cacheSprite[1168];
				if (SellHover != null)
					SellHover.drawSprite(x, y);
			} else {
				Client.cacheSprite[1169].drawSprite(x, y);
			}
			Client.cacheSprite[1170].drawSprite(x + 6, y + 30);
			if(slotItems[id] > 0 && ItemDefinition.getSprite(slotItems[id], 1, 0) != null)
				ItemDefinition.getSprite(slotItems[id], 1, 0).drawSprite(x + 9, y + 32);
			Client.getClient().drawInterface(0, x + 110, RSInterface.interfaceCache[54000], y + 38);
			setGrandExchange(id, false);
			changeSet(id, true, false);
			drawPercentage(id);
			Client.getClient().smallText.method592(0xCC9900, x2,
					RSInterface.interfaceCache[32000 + id].message, y2 - minus,
					true);
			Client.getClient().smallText.method592(0xBDBB5B, x2,
					RSInterface.interfaceCache[33000 + id].message, y2, true);
			Client.getClient().smallText.method592(0xFFFF00, x3,
					RSInterface.interfaceCache[33100 + id].message, y3, true);
			setHovers(id, false);
			if(Client.cacheSprite[1145] != null) {
				Client.cacheSprite[1145].drawSprite(x + 110, y + 39);
				if(Client.getClient().mouseInRegion(x + 112, y + 38, x + 132, y + 60)) {
					Client.cacheSprite[1146].drawSprite(x + 110, y + 39);
					changeSet(id, false, true);
				}
			}
			String name[] = Client.optimizeText(ItemDefinition.get(slotItems[id]).name).split(" ");
			int index = 0;
			for(String n : name) {
				int xDraw = x + 77;
				int yDraw = y + (name.length > 2 ? 41 : 48) + (index * 15); 
				Client.getClient().smallText.drawCenteredText(0xA05A00, xDraw, n, yDraw, false);
				index++;
			}
		} else if (type == "Finished Buying") {
			if (Client.getClient().mouseX() >= x && Client.getClient().mouseX() <= x + 140
					&& Client.getClient().mouseY() >= y && Client.getClient().mouseY() <= y + 110
					&& !Client.getClient().menuOpen) {
				BuyHover = Client.cacheSprite[1172];
				if (BuyHover != null)
					BuyHover.drawSprite(x, y);
			} else {
				Client.cacheSprite[1171].drawSprite(x, y);
			}
			Client.cacheSprite[1170].drawSprite(x + 6, y + 30);
			ItemDefinition.getSprite(slotItems[id], 1, 0).drawSprite(x + 9, y + 32);
			Client.getClient().drawInterface(0, x + 110, RSInterface.interfaceCache[54000], y + 38);
			setGrandExchange(id, false);
			changeSet(id, true, false);
			drawPercentage(id);
			Client.getClient().smallText.method592(0xCC9900, x2,
					RSInterface.interfaceCache[32000 + id].message, y2 - minus,
					true);
			Client.getClient().smallText.method592(0xBDBB5B, x2,
					RSInterface.interfaceCache[33000 + id].message, y2, true);
			Client.getClient().smallText.method592(0xFFFF00, x3,
					RSInterface.interfaceCache[33100 + id].message, y3, true);
			setHovers(id, false);
			if(Client.cacheSprite[1145] != null) {
				Client.cacheSprite[1145].drawSprite(x + 110, y + 39);
				if(Client.getClient().mouseInRegion(x + 112, y + 38, x + 132, y + 60)) {
					Client.cacheSprite[1146].drawSprite(x + 110, y + 39);
					changeSet(id, false, true);
				}
			}
			String name[] = Client.optimizeText(ItemDefinition.get(slotItems[id]).name).split(" ");
			int index = 0;
			for(String n : name) {
				int xDraw = x + 77;
				int yDraw = y + (name.length > 2 ? 41 : 48) + (index * 15); 
				Client.getClient().smallText.drawCenteredText(0xA05A00, xDraw, n, yDraw, false);
				index++;
			}
		}
	}

	public Sprite per0;
	public Sprite per1;
	public Sprite per2;
	public Sprite per3;
	public Sprite per4;
	public Sprite per5;
	public Sprite per6;
	public Sprite abort1;
	public Sprite abort2;
	public Sprite SellHover;
	public Sprite BuyHover;
	public Sprite sellSubmitHover;
	public Sprite buySubmitHover;

	public void drawPercentage(int id) {
		per0 = Client.cacheSprite[1162];
		per1 = Client.cacheSprite[1163];
		per2 = Client.cacheSprite[1164];
		per3 = Client.cacheSprite[1165];
		abort1 = Client.cacheSprite[1166];
		int x = 0;
		int y = 0;
		boolean fixed = (GameFrame.getScreenMode() == ScreenMode.FIXED);
		switch (id) {
		case 1:
			x = fixed ? 30 + 8 : (Client.clientWidth / 2 - 226 + 8);
			y = fixed ? 74 + 81 : (Client.clientHeight / 2 - 93 + 81);
			break;
		case 2:
			x = fixed ? 186 + 8 : (Client.clientWidth / 2 - 70 + 8);
			y = fixed ? 74 + 81 : (Client.clientHeight / 2 - 93 + 81);
			break;
		case 3:
			x = fixed ? 342 + 8 : (Client.clientWidth / 2 + 86 + 8);
			y = fixed ? 74 + 81 : (Client.clientHeight / 2 - 93 + 81);
			break;
		case 4:
			x = fixed ? 30 + 8 : (Client.clientWidth / 2 - 226 + 8);
			y = fixed ? 194 + 81 : (Client.clientHeight / 2 + 27 + 81);
			break;
		case 5:
			x = fixed ? 186 + 8 : (Client.clientWidth / 2 - 70 + 8);
			y = fixed ? 194 + 81 : (Client.clientHeight / 2 + 27 + 81);
			break;
		case 6:
			x = fixed ? 342 + 8 : (Client.clientWidth / 2 + 86 + 8);
			y = fixed ? 194 + 81 : (Client.clientHeight / 2 + 27 + 81);
			break;
		}
		x -= 2;
		if (slotColorPercent[id] > 100) {
			slotColorPercent[id] = 100;
		}
		int s = 0;
		if (!slotAborted[id]) {
			for (int k9 = 1; k9 < slotColorPercent[id]; k9++) {
				if (slotColorPercent[id] > 0) {
					if (k9 == 1) {
						if (per0 != null)
							per0.drawSprite(x, y);
						x += 2;
					} else if (k9 == 2) {
						if (per1 != null)
							per1.drawSprite(x, y);
						x += 2;
					} else if (k9 >= 6 && k9 <= 14) {
						if (per3 != null)
							per3.drawSprite(x, y);
						x += 1;
					} else if (k9 >= 56 && k9 <= 65) {
						if (per3 != null)
							per3.drawSprite(x, y);
						x += 1;
					} else if (k9 >= 76 && k9 <= 82) {
						if (per3 != null)
							per3.drawSprite(x, y);
						x += 1;
					} else {
						if (s == 0) {
							if (per2 != null)
								per2.drawSprite(x, y);
							x += 2;
							s += 1;
						} else if (s == 1) {
							if (per3 != null)
								per3.drawSprite(x, y);
							x += 1;
							s += 1;
						} else if (s == 2) {
							if (per3 != null)
								per3.drawSprite(x, y);
							x += 1;
							s = 0;
						} else if (s == 4) {
							if (per3 != null)
								per3.drawSprite(x, y);
							x += 1;
							s = 0;
						}
					}
				}
			}
		} else {
			if (abort1 != null)
				abort1.drawSprite(x, y);
		}
	}

	public void setGrandExchange(int id, boolean on) {
		switch (id) {
		case 1:
			if (on) {
				RSInterface.interfaceCache[24505].tooltip = "Buy";
				RSInterface.interfaceCache[24511].tooltip = "Sell";
				changeSet(id, false, false);
			} else {
				RSInterface.interfaceCache[24505].tooltip = "[GE]";
				RSInterface.interfaceCache[24511].tooltip = "[GE]";
			}
			break;
		case 2:
			if (on) {
				RSInterface.interfaceCache[24523].tooltip = "Buy";
				RSInterface.interfaceCache[24526].tooltip = "Sell";
				changeSet(id, false, false);
			} else {
				RSInterface.interfaceCache[24523].tooltip = "[GE]";
				RSInterface.interfaceCache[24526].tooltip = "[GE]";
			}
			break;
		case 3:
			if (on) {
				RSInterface.interfaceCache[24514].tooltip = "Buy";
				RSInterface.interfaceCache[24529].tooltip = "Sell";
				changeSet(id, false, false);
			} else {
				RSInterface.interfaceCache[24514].tooltip = "[GE]";
				RSInterface.interfaceCache[24529].tooltip = "[GE]";
			}
			break;
		case 4:
			if (on) {
				RSInterface.interfaceCache[24508].tooltip = "Buy";
				RSInterface.interfaceCache[24532].tooltip = "Sell";
				changeSet(id, false, false);
			} else {
				RSInterface.interfaceCache[24508].tooltip = "[GE]";
				RSInterface.interfaceCache[24532].tooltip = "[GE]";
			}
			break;
		case 5:
			if (on) {
				RSInterface.interfaceCache[24517].tooltip = "Buy";
				RSInterface.interfaceCache[24535].tooltip = "Sell";
				changeSet(id, false, false);
			} else {
				RSInterface.interfaceCache[24517].tooltip = "[GE]";
				RSInterface.interfaceCache[24535].tooltip = "[GE]";
			}
			break;
		case 6:
			if (on) {
				RSInterface.interfaceCache[24520].tooltip = "Buy";
				RSInterface.interfaceCache[24538].tooltip = "Sell";
				changeSet(id, false, false);
			} else {
				RSInterface.interfaceCache[24520].tooltip = "[GE]";
				RSInterface.interfaceCache[24538].tooltip = "[GE]";
			}
			break;
		}
	}

	public void changeSet(int id, boolean view, boolean abort) {
		switch (id) {
		case 1:
			if (view) {
				RSInterface.interfaceCache[24543].tooltip = "View offer";
			} else {
				RSInterface.interfaceCache[24543].tooltip = "[GE]";
			}
			if (abort) {
				RSInterface.interfaceCache[24541].tooltip = "Abort offer";
			} else {
				RSInterface.interfaceCache[24541].tooltip = "[GE]";
			}
			break;
		case 2:
			if (view) {
				RSInterface.interfaceCache[24547].tooltip = "View offer";
			} else {
				RSInterface.interfaceCache[24547].tooltip = "[GE]";
			}
			if (abort) {
				RSInterface.interfaceCache[24545].tooltip = "Abort offer";
			} else {
				RSInterface.interfaceCache[24545].tooltip = "[GE]";
			}
			break;
		case 3:
			if (view) {
				RSInterface.interfaceCache[24551].tooltip = "View offer";
			} else {
				RSInterface.interfaceCache[24551].tooltip = "[GE]";
			}
			if (abort) {
				RSInterface.interfaceCache[24549].tooltip = "Abort offer";
			} else {
				RSInterface.interfaceCache[24549].tooltip = "[GE]";
			}
			break;
		case 4:
			if (view) {
				RSInterface.interfaceCache[24555].tooltip = "View offer";
			} else {
				RSInterface.interfaceCache[24555].tooltip = "[GE]";
			}
			if (abort) {
				RSInterface.interfaceCache[24553].tooltip = "Abort offer";
			} else {
				RSInterface.interfaceCache[24553].tooltip = "[GE]";
			}
			break;
		case 5:
			if (view) {
				RSInterface.interfaceCache[24559].tooltip = "View offer";
			} else {
				RSInterface.interfaceCache[24559].tooltip = "[GE]";
			}
			if (abort) {
				RSInterface.interfaceCache[24557].tooltip = "Abort offer";
			} else {
				RSInterface.interfaceCache[24557].tooltip = "[GE]";
			}
			break;
		case 6:
			if (view) {
				RSInterface.interfaceCache[24563].tooltip = "View offer";
			} else {
				RSInterface.interfaceCache[24563].tooltip = "[GE]";
			}
			if (abort) {
				RSInterface.interfaceCache[24561].tooltip = "Abort offer";
			} else {
				RSInterface.interfaceCache[24561].tooltip = "[GE]";
			}
			break;
		}
	}
	
	public void displayItemSearch() {
		int yPosOffset = (GameFrame.getScreenMode() != ScreenMode.FIXED) ? Client.clientHeight - 165 : 0;
		int xPosOffset = 0;
		try {
			if (searching && Client.getClient().inputDialogState == 3) {
				if(Client.getClient().amountOrNameInput != "") {
					itemSearch(Client.getClient().amountOrNameInput);
				}
				Client.cacheSprite[1149].drawSprite(0 + xPosOffset, 0 + yPosOffset);
				DrawingArea.setDrawingArea(121 + yPosOffset, 8, 512, 7);
				Client.cacheSprite[1170].drawSprite(18, 18 + yPosOffset);
				for (int j = 0; j < totalItemResults; j++) {
					int x = Client.getClient().mouseX();
					int y = Client.getClient().mouseY();
					final int yPos = 21 + j * 14 - itemResultScrollPos;
					if (yPos > 0 && yPos < 210) {
						String n = itemResultNames[j];
						for (int i = 0; i <= 20; i++)
							if (n.contains("<img=" + i + ">"))
								n = n.replaceAll("<img=" + i + ">", "");
						Client.getClient().chatTextDrawingArea.method591(Client.capitalizeFirstChar(n), 78,
								0xA05A00, yPos + yPosOffset
								+ (totalItemResults < 8 ? 6 : 0));
						if (x > 74
								&& x < 495
								&& y > ((GameFrame.getScreenMode() == ScreenMode.FIXED) ? 338
										: Client.clientHeight - 165)
										+ yPos
										- 13
										+ (totalItemResults < 8 ? 6 : 0)
										&& y < ((GameFrame.getScreenMode() == ScreenMode.FIXED) ? 338
												: Client.clientHeight - 165)
												+ yPos
												+ 2
												+ (totalItemResults < 8 ? 6 : 0)) {
							DrawingArea.fillRect(0x807660, yPos - 12
									+ yPosOffset + (totalItemResults < 8 ? 6 : 0),
									424, 15, 60, 75);
							Sprite itemImg = ItemDefinition.getSprite(itemResultIDs[j], 1,
									0);
							if (itemImg != null)
								itemImg.drawSprite(22, 20 + yPosOffset);
							itemSelected = itemResultIDs[j];
						}
					}
				}
				DrawingArea.drawPixels(113, 8 + yPosOffset, 74, 0x807660, 2);
				DrawingArea.defaultDrawingAreaSize();
				if (totalItemResults > 8) {
					Client.getClient().drawScrollbar(114, itemResultScrollPos, 8 + yPosOffset,
							496 + xPosOffset, totalItemResults * 14, false, false);
					// drawScrollbar(112, itemResultScrollPos, 8, 496,
					// totalItemResults * 14 + 12, 0);
				}
				boolean showMatches = true;
				showMatches = true;
				if (Client.getClient().amountOrNameInput.length() == 0) {
					Client.getClient().chatTextDrawingArea.drawCenteredText(0xA05A00, 259,
							"Grand Exchange Item Search", 30 + yPosOffset, false);
					Client.getClient().smallText.drawCenteredText(0xA05A00, 259, "To search for an item, start by typing part of it's name.", 80 + yPosOffset, false);
					Client.getClient().smallText
					.drawCenteredText(
							0xA05A00,
							259,
							"Then, simply select the item you want from the results on the display.",
							80 + 15 + yPosOffset, false);
					// chatTextDrawingArea.drawText(0xffffff, amountOrNameInput +
					// "*", 32, 133);
					showMatches = false;
				}
				if (totalItemResults == 0 && showMatches) {
					Client.getClient().smallText.drawCenteredText(0xA05A00, 259,
							"No matching items found", 80 + yPosOffset, false);
				}
				DrawingArea.fillRect(0x807660, 121 + yPosOffset, 506, 15, 120,
						7);// box
				// chatTextDrawingArea.drawText(0, "<img=8>", 133, 12);
				Client.getClient().chatTextDrawingArea.method591(Client.getClient().amountOrNameInput + "*",
						28 + xPosOffset, 0xffffff, 133 + yPosOffset);
				// chatTextDrawingArea.drawText(0xffffff, amountOrNameInput + "*",
				// 133, 122);
				DrawingArea.drawLine(121 + yPosOffset, 0x807660, 506, 7);// line
				// drawClose(496, 122, 496, 345 + 112, 496 + 19, 361 + 112);
				// drawClose(496, 122, 496, 345 + 112, 496 + 19, 361 + 112);
				// drawClose(496, 122, 496, 345 + 112, 496 + 19, 361 + 112);
			}
			Client.cacheSprite[1148].drawSprite(11, 122 + yPosOffset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void itemSearch(String n) {
		if (n == null || n.length() == 0) {
			totalItemResults = 0;
			return;
		}
		String searchName = n;
		String searchParts[] = new String[100];
		int totalResults = 0;
		do {
			int k = searchName.indexOf(" ");
			if (k == -1)
				break;
			String part = searchName.substring(0, k).trim();
			if (part.length() > 0)
				searchParts[totalResults++] = part.toLowerCase();
			searchName = searchName.substring(k + 1);
		} while (true);
		searchName = searchName.trim();
		if (searchName.length() > 0)
			searchParts[totalResults++] = searchName.toLowerCase();
		totalItemResults = 0;
		label0: for (int id = 0; id < ItemDefinition.totalItems; id++) {
			ItemDefinition item = ItemDefinition.get(id);
			if(item == null)
				continue;
			if (item.certTemplateID != -1 || item.name == null || item.name == "Picture"
					|| item.certID == 18786 || item.name == "Null" || item.name.toLowerCase().contains("coins") || item.value <= 0 || item.id == 4178 || item.id == 14661/*|| item.untradeable*/)
				continue;
			String result = item.name.toLowerCase();
			for (int idx = 0; idx < totalResults; idx++)
				if (result.indexOf(searchParts[idx]) == -1)
					continue label0;

			itemResultNames[totalItemResults] = result;
			itemResultIDs[totalItemResults] = id;
			totalItemResults++;

			if (totalItemResults >= itemResultNames.length)
				return;
		}
	}
	
	public void buildItemSearch(int mouseY) {
		int y = 0;
		for (int idx = 0; idx < 100; idx++) {
			if (Client.getClient().amountOrNameInput.length() == 0)
				return;
			else if (totalItemResults == 0)
				return;
			if (Client.getClient().amountOrNameInput == "")
				return;
			String name = Client.capitalizeFirstChar(itemResultNames[idx]);
			for (int i = 0; i <= 20; i++)
				if (name.contains(" <img=" + i + ">"))
					name = name.replaceAll(" <img=" + i + ">", "");
			int textY = (21 + y * 14) - itemResultScrollPos;
			if (mouseY > textY - 14 && mouseY <= textY && Client.getClient().mouseX() > 74
					&& Client.getClient().mouseX < 495) {
				Client.getClient().menuActionName[Client.getClient().menuActionRow] = "" + name;
				Client.getClient().menuActionID[Client.getClient().menuActionRow] = 1251;
				Client.getClient().menuActionRow++;
			}
			y++;
		}
	}

	public void setHovers(int id, boolean on) {
		switch (id) {
		case 1:
			if (!on) {
			} else {
			}
			break;
		case 2:
			if (!on) {
			} else {
			}
			break;
		case 3:
			if (!on) {
			} else {
			}
			break;
		case 4:
			if (!on) {
			} else {
			}
			break;
		case 5:
			if (!on) {
			} else {
			}
			break;
		case 6:
			if (!on) {
			} else {
			}
			break;
		}
	}
}
