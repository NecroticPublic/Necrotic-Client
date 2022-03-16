package org.necrotic.client.graphics.rsinterface;

import java.util.ArrayList;

import org.necrotic.Configuration;
import org.necrotic.client.RSInterface;
import org.necrotic.client.Skills;
import org.necrotic.client.accounts.Account;
import org.necrotic.client.graphics.fonts.TextDrawingArea;

public class CustomInterfaces extends RSInterface {

	private static final int CLOSE_BUTTON = 580, CLOSE_BUTTON_HOVER = 581;
	
	public TextDrawingArea tda[];
	public CustomInterfaces(TextDrawingArea tda[]) {
		this.tda = tda;
	}

	public void loadCustoms() {
	//	Client.getClient().getAccountManager().updateInterface();
		playersOnline();
		editClan();
		dungeonInfo();
		formParty();
		dungParty();
		expRewardInterface();
		slayerBuyInterface();
		barrowsInterface();
		pestControlInterfaces();
		skillTabInterface();
		playerPanel(); 
		killsTracker();
		friendsTabInterface();
		ignoreTabInterface();
		equipmentTab();
		teleportGUI();
		equipmentScreenInterface();
		itemsKeptOnDeathInterface();
		clanChatTabInterface();
		configureLunar();
		redoSpellBooks();
		shopInterface();
		bankInterface();
		playerPanelv3();

		summoningBoBInterface();
		summoningTabInterface();
		priceCheckerInterface();
		achievementsInterface();
		loyaltyShop();
		//teleportWidget(tda);

		emoteTab();
		prayerTabInterface();
		curseTabInterface();
		//	pouchCreation();
		opacityInterface();
		levelUpInterfaces();
		godWars();
		optionTab();
		//settingsInterface();
		bountyInterface();
		sidebarInterfaces();
		pouchCreation();
		settingsInterface2();
		mainGe();
		buyGe();
		collectBuyGe();
		sellGe();
		collectSellGe();
		quickCursesInterface();
		quickPrayersInterface();
		OsDropViewer();
	}
	

	public void OsDropViewer() {
		RSInterface tab = addInterface(33000);
		//String dir = "DropViewer/SPRITE";
		addSprite(33001, 1217); //changeid
		addHoverButton(33002, 1208, 21, 21,"Close", 0, 33003, 1); //changeid
		addHoveredButton(33003, 1209, 21, 21, 33004); //changeid
		addText(33005, "Loot Viewer", tda, 2, 0xFFA500, true, true);
		int x = 7, y = 7;
		tab.totalChildren(7);
		tab.child(0, 33001, 0+x, 0+y);
		tab.child(1, 33002, 472+x, 7+y);
		tab.child(2, 33003, 472+x, 7+y);
		tab.child(3, 33005, 250+x, 11+y);
		tab.child(4, 33006, 8+x, 41+y);
        tab.child(5, 34000, 150+x, 35+y);
		tab.child(6, 33007, 6+x, 58+y);
		
		final RSInterface results = addInterface(33007);
		results.width = 122;
		results.height = 258;
		results.scrollMax = 300;
                
		results.totalChildren(100);
		for (int j = 0; j < 100; j++) {
			addClickableText(33008 + j, "", "View Drops", tda, 0, 0xff0000, false, true, 110);
			results.child(j, 33008 + j, 3, 2 + (j*14));
		}
		
		RSInterface main = addInterface(34000);
		main.totalChildren(720);
		main.width = 328;
		main.height = 281;
		main.scrollMax = 2560;
		addSprite(34001, 1210); //changeid
		addSprite(34002, 1211); //changeid
		for(int i = 0; i < 40; i++) {
			main.child(i, 34001, 0, (i * 64));
			main.child(i + 40, 34002, 0, 32 + (i * 64));
		}
		addText(34003, "Amount:", tda, 0, 0xff9040, true, true);
		addText(34004, "Chance:", tda, 0, 0xff9040, true, true);
		addText(34005, "Value:", tda, 0, 0xff9040, true, true);
		for (int i = 0; i < 80; i++) {
			itemGroup(34010 + i, 1, 1, 1, 1, false, false);
			interfaceCache[34010 + i].inv[0] = 14485;
			interfaceCache[34010 + i].invStackSizes[0] = 1;
			addText(34100 + i, "Name", tda, 1, 0xFFA500, false, true);
			addText(34200 + i, "Amount", tda, 0, 0xffffff, true, true);
			addText(34300 + i, "Chance", tda, 0, 0xffffff, true, true);
			addText(34400 + i, "Value", tda, 0, 0xffffff, true, true);
			int yy = (i * 32);
			main.child(80+i, 34010+i, 1, 0+yy);
			main.child(160+i, 34100+i, 39, 6+yy);
			main.child(240+i, 34003, 175, 2+yy);
			main.child(320+i, 34004, 234, 2+yy);
			main.child(400+i, 34005, 293, 2+yy);
			main.child(480+i, 34200+i, 175, 14+yy);
			main.child(560+i, 34300+i, 234, 14+yy);
			main.child(640+i, 34400+i, 293, 14+yy);
		}
		
		addClickableTextHeight(33006, "@whi@Search for an NPC", "Filter", tda, 0, 0xff0000, true, true, 134, 10);
		
		/*addTextInput(33006, 134, 19, 0, "Search for an NPC", tab, new InterfaceTextInput() {
			@Override
			public void handleInput() {
				int amount = 0;
				results.scrollMax = 0;
				for (int b = 0; b < 100; b++) {
					interfaceCache[33008 + b].message = "";
				}
				if (!interfaceCache[33006].inputText.equals("")) {
					for (int b = 0; b < MobDefinition.maximum; b++) {
						//MobDefinition e = MobDefinition.get(b);
						if (MobDefinition.get(b) != null && MobDefinition.get(b).name != null && MobDefinition.get(b).name.toLowerCase().contains(interfaceCache[33006].inputText.toLowerCase())) {
							interfaceCache[33008 + amount].message = "@yel@"+MobDefinition.get(b).name;
							amount++;
							results.scrollMax += 14;
							if (amount == 100)
								break;
						}
					}
				}
			}
		});*/
	}
	
	

	private void equipmentTab() {
		int[] remove = {
				1672, 1669, 1670, 1671, 1673, 1674, 1675,
				1676, 1677, 1678, 1679, 1680, 1681, 1682,
				1683, 1684, 1685, 1686, 1687, 1668};
		for(int i : remove) {
			removeSomething(i);
		}
		RSInterface newTab = addTabInterface(15000);
		addButtonWSpriteLoader(15001,618, "Show Equipment Stats", 41, 40);
		addButtonWSpriteLoader(15002, 619, "Open Price Checker", 41, 40);
		addButtonWSpriteLoader(15003, 620, "Open Items kept on Death", 41, 40);
		//addButtonWSpriteLoader(15004, 621, "Toggle Experience", 41, 40);
		newTab.totalChildren(5);
		setBounds(15001, 25, 205, 0, newTab);
		setBounds(15002, 75, 205, 1, newTab);
		setBounds(15003, 125, 205, 2, newTab);
		setBounds(15004, 999, 205, 3, newTab);
		setBounds(1644, 0, 0, 4, newTab);
	}

	private void duelingInterface() {
		RSInterface newTab = addTabInterface(6575);
		addConfigButtonWSpriteLoader(37890, 6575, 1, 1, 10, 10, "Head", 286, 1, 286);
	}

	private void skillTabInterface() {
		RSInterface skill = addTabInterface(3917);
		addSpriteLoader(28100, 623);
		skill.totalChildren(1);
		skill.child(0, 28100, 72, 237);
		int[] logoutID = {2450, 2451, 2452};
		int[] logoutID2 = {2458 };
		for (int i: logoutID) {
			RSInterface Logout = interfaceCache[i];
			Logout.textColor = 0xFF981F;
			Logout.contentType = 0;
		}
		for (int i: logoutID2) {
			RSInterface Logout = interfaceCache[i];
			Logout.contentType = 0;
		}
		int[] buttons = { 8654, 8655, 8656, 8657, 8658, 8659, 8660, 8861, 8662, 8663, 8664, 8665, 8666, 8667, 8668, 8669, 8670, 8671, 8672, 12162, 13928, 28177, 28178, 28179, 28180 };
		int[] hovers = { 4040, 4076, 4112, 4046, 4082, 4118, 4052, 4088, 4124, 4058, 4094, 4130, 4064, 4100, 4136, 4070, 4106, 4142, 4160, 2832, 13917, 28173, 28174, 28175, 28176 };
		int[][] text = { { 4004, 4005 }, { 4016, 4017 }, { 4028, 4029 },
				{ 4006, 4007 }, { 4018, 4019 }, { 4030, 4031 }, { 4008, 4009 },
				{ 4020, 4021 }, { 4032, 4033 }, { 4010, 4011 }, { 4022, 4023 },
				{ 4034, 4035 }, { 4012, 4013 }, { 4024, 4025 }, { 4036, 4037 },
				{ 4014, 4015 }, { 4026, 4027 }, { 4038, 4039 }, { 4152, 4153 },
				{ 12166, 12167 }, { 13926, 13927 }, { 28165, 28169 },
				{ 28166, 28170 }, { 28167, 28171 }, { 28168, 28172 } };

		int[] icons = { 3965, 3966, 3967, 3968, 3969, 3970, 3971, 3972, 3973,
				3974, 3975, 3976, 3977, 3978, 3979, 3980, 3981, 3982, 4151,
				12165, 13925, 28181, 28182, 28183, 28184 };

		int[][] buttonCoords = { { 3, 5 }, { 65, 5 }, { 127, 5 }, { 3, 33 },
				{ 65, 33 }, { 127, 33 }, { 3, 61 }, { 65, 61 }, { 127, 61 },
				{ 3, 89 }, { 65, 89 }, { 127, 89 }, { 3, 117 }, { 65, 117 },
				{ 127, 117 }, { 3, 145 }, { 65, 145 }, { 127, 145 },
				{ 3, 173 }, { 65, 173 }, { 127, 173 }, { 3, 201 }, { 65, 201 },
				{ 127, 201 }, { 3, 229 } };
		int[][] iconCoords = { { 5, 7 }, { 68, 8 }, { 130, 7 }, { 8, 35 },
				{ 67, 34 }, { 130, 37 }, { 8, 65 }, { 66, 64 }, { 130, 62 },
				{ 6, 92 }, { 67, 97 }, { 132, 91 }, { 5, 119 }, { 69, 121 },
				{ 129, 119 }, { 5, 148 }, { 68, 147 }, { 131, 147 },
				{ 5, 174 }, { 68, 174 }, { 129, 175 }, { 5, 203 }, { 68, 202 },
				{ 130, 203 }, { 5, 231 } };
		int[][] textCoords = { { 29, 7, 44, 19 }, { 91, 7, 106, 19 },
				{ 153, 7, 168, 19 }, { 29, 35, 44, 47 }, { 91, 35, 106, 47 },
				{ 153, 35, 168, 47 }, { 29, 63, 44, 75 }, { 91, 63, 106, 75 },
				{ 153, 63, 168, 75 }, { 29, 91, 44, 103 },
				{ 91, 91, 106, 103 }, { 153, 91, 168, 103 },
				{ 29, 119, 44, 131 }, { 91, 119, 106, 131 },
				{ 153, 119, 168, 131 }, { 29, 147, 44, 159 },
				{ 91, 147, 106, 159 }, { 153, 147, 168, 159 },
				{ 29, 175, 44, 187 }, { 91, 175, 106, 187 },
				{ 153, 175, 168, 187 }, { 29, 203, 44, 215 },
				{ 91, 203, 106, 215 }, { 153, 203, 168, 215 },
				{ 29, 231, 44, 243 } };
		int[][] newText = { { 28165, 28166, 28167, 28168 },
				{ 28169, 28170, 28171, 28172 } };
		int[] spriteIds = { 625, 636, 639, 645, 624, 644, 629, 635, 633, 641, 647, 627, 640, 628, 632, 638, 634, 648, 642, 643, 631, 626, 637, 646, 630};
		int frame = 0;

		for (int i = 0; i < hovers.length; i++) {
			addSkillButton(buttons[i], Skills.SKILL_NAMES[i]);
			createSkillHover(hovers[i], 205 + i);

			addHoverButtonWSpriteLoader(79924 + i, 622, 60, 27, "Set Level Goal", 1321, -1, 1);
			addHoverButtonWSpriteLoader(79949 + i, 622, 60, 27, "Set Exp Goal", 1322, -1, 1);
			addHoverButtonWSpriteLoader(79974 + i, 622, 60, 27, "Clear Goal", 1323, -1, 1);
			addHoverButtonWSpriteLoader(80000 + i, 622, 60, 27, "Prestige", 5000+i, -1, 1);
			/*
			addHoverButton(79924 + i, getSprite("Interfaces/Skilltab/Button"), 0, 60, 27, "Set Level Goal", 1321, -1, 1);
			addHoverButton(79949 + i, getSprite("Interfaces/Skilltab/Button"), 0, 60, 27, "Set Exp Goal", 1322, -1, 1);
			addHoverButton(79974 + i, getSprite("Interfaces/Skilltab/Button"), 0, 60, 27, "Clear Goal", 1323, -1, 1);
			addHoverButton(80000 + i, getSprite("Interfaces/Skilltab/Button"), 0, 60, 27, "Prestige", 5000+i, -1, 1);


			addSprite(icons[i], getSprite("Interfaces/Skilltab/" + spriteNames[i]));
			 */
			addSpriteLoader(icons[i], spriteIds[i]);
		}

		for (int i = 0; i < 4; i++) {
			addSkillText(newText[0][i], false, i + 21);
			addSkillText(newText[1][i], true, i + 21);
		}
		skill.totalChildren(icons.length + (text.length * 2) + hovers.length + buttons.length * 5 + 1);



		RSInterface totalLevel = addInterface(3984);
		addSpriteLoader(31196, 649);
		createHover(31192, 231, 120);
		addText(31199, "Total Level:", 0xFFEE33, false, true, 52, tda, 0);
		addText(31200, "2475", 0xFFEE33, false, true, 52, tda, 0);

		totalLevel.totalChildren(4);
		totalLevel.child(0, 31196, 65, 229);
		totalLevel.child(1, 31199, 106, 231);
		totalLevel.child(2, 31200, 117, 243);
		totalLevel.child(3, 31192, 38, 230);
		skill.child(frame, 3984, 0, 0); 
		frame++;
		for (int i = 0; i < buttons.length; i++) {
			skill.child(frame++, 80000 + i, buttonCoords[i][0], buttonCoords[i][1]);
			skill.child(frame++, 79974 + i, buttonCoords[i][0], buttonCoords[i][1]);
			skill.child(frame++, 79949 + i, buttonCoords[i][0], buttonCoords[i][1]);
			skill.child(frame++, 79924 + i, buttonCoords[i][0], buttonCoords[i][1]);
			skill.child(frame, buttons[i], buttonCoords[i][0], buttonCoords[i][1]); frame++;
		}
		for (int i = 0; i < icons.length; i++) {
			skill.child(frame, icons[i], iconCoords[i][0], iconCoords[i][1]); frame++;
		}
		for (int i = 0; i < text.length; i++) {
			skill.child(frame, text[i][0], textCoords[i][0], textCoords[i][1]); frame++;
		}
		for (int i = 0; i < text.length; i++) {
			skill.child(frame, text[i][1], textCoords[i][2], textCoords[i][3]); frame++;
		}
		for (int i = 0; i < hovers.length; i++) {
			skill.child(frame, hovers[i], buttonCoords[i][0], buttonCoords[i][1]); frame++;
		}
	}

	/*
	 * Quest tab [PLAYER PANEL]
	 */
	private void playerPanel() {
		RSInterface tab = addTabInterface(639);
		RSInterface scroll = addTabInterface(15016);
		addText(39155, "    - Player Information - ", tda, 2, 16750623, false, true);
		addSpriteLoader(39156, 650);
		addSpriteLoader(39157, 651);
		addSpriteLoader(39158, 650);

		scroll.totalChildren(55);
		scroll.width = 174; scroll.height = 224; scroll.scrollMax = 835;
		tab.totalChildren(5);

		tab.child(0, 39155, 5, 3);
		tab.child(1, 39156, 0, 22);
		tab.child(2, 39157, 0, 25);
		tab.child(3, 39158, 0, 249);
		tab.child(4, 15016, 0, 25);

		int k = 0;
		int y = 0;
		for(int i = 39159; i < 39214; i++) {
			scroll.child(k, i, 6, y);
			y += 16;
			k++;
			/*if(i == 39162) {
				addClickableText(i, "", "View", tda, 1, 0xff0000, 167, 13);
			} else if(i == 39165) {
				addClickableText(i, "", "Check", tda, 1, 0xff0000, 167, 13);
			} else if(i == 39173 || i == 39174) {
				addClickableText(i, "", "Toggle", tda, 1, 0xff0000, 167, 13);
			} else if(i == 39187 || i ==39188 || i >= 39196 && i <= 39202) {
				addClickableText(i, "", "Open", tda, 1, 0xff0000, 167, 13);
			} else {
				addText(i, "", tda, 1, 0xff0000, false, true);
			}*/
			addText(i, "", tda, 1, 0xff0000, false, true);
		}
	}


	private void killsTracker() {
		RSInterface tab = addTabInterface(55000);
		RSInterface scroll = addTabInterface(55010);
		addText(55001, "Kills Tracker", tda, 2, 16750623, false, true);
		addSpriteLoader(55002, 650);
		addSpriteLoader(55003, 651);
		addSpriteLoader(55004, 650);
		addButtonWSpriteLoader(55005, 1024, "Go Back", 26, 26);

		scroll.totalChildren(44);
		scroll.width = 174; scroll.height = 224; scroll.scrollMax = 710;
		tab.totalChildren(6);

		tab.child(0, 55001, 5, 3);
		tab.child(1, 55002, 0, 22);
		tab.child(2, 55003, 0, 25);
		tab.child(3, 55004, 0, 249);
		tab.child(4, 55005, 164, 0);
		tab.child(5, 55010, 0, 25);

		int k = 0;
		int y = 0;
		for(int i = 55020; i < 55064; i++) {
			scroll.child(k, i, 6, y);
			y += 16;
			k++;
			addText(i, "", tda, 1, 0xff0000, false, true);
		}
	}

	private void priceCheckerInterface() {
		RSInterface rsi = addTabInterface(42000);
		final String[] options = {"Remove 1", "Remove 5", "Remove 10", "Remove All", "Remove X"};
		addSpriteLoader(18245, 654);
		addCloseButton(18247, 18535, 18536);
		addItemOnInterface(18246, 4393, options);
		rsi.totalChildren(88);
		rsi.child(0, 18245, 10, 20);//was 10 so + 10
		rsi.child(1, 18246, 100, 50);
		rsi.child(2, 18247, 472, 21);
		addText(18248, "", tda, 0, 0xFFFFFF, true, true);rsi.child(3, 18248, 472, 23);
		addText(18350, "Total value:", tda, 0, 0xFFFFFF, false, true);
		rsi.child(4, 18350, 225, 295); // Open Text
		addText(18351, "0", tda, 0, 0xFFFFFF, true, true);
		rsi.child(5, 18351, 251, 306);
		addText(18352, "", tda, 0, 0xFFFFFF, false, true);
		rsi.child(6, 18352, 120, 150);
		addText(18353, "", tda, 0, 0xFFFFFF, true, true);rsi.child(7, 18353, 120, 85);
		addText(18354, "", tda, 0, 0xFFFFFF, true, true);rsi.child(8, 18354, 120, 95);
		addText(18355, "", tda, 0, 0xFFFFFF, true, true);rsi.child(9, 18355, 120, 105);
		addText(18356, "", tda, 0, 0xFFFFFF, true, true);rsi.child(10, 18356, 190, 85);
		addText(18357, "", tda, 0, 0xFFFFFF, true, true);rsi.child(11, 18357, 190, 95);
		addText(18358, "", tda, 0, 0xFFFFFF, true, true);rsi.child(12, 18358, 190, 105);
		addText(18359, "", tda, 0, 0xFFFFFF, true, true);rsi.child(13, 18359, 260, 85);
		addText(18360, "", tda, 0, 0xFFFFFF, true, true);rsi.child(14, 18360, 260, 95);
		addText(18361, "", tda, 0, 0xFFFFFF, true, true);rsi.child(15, 18361, 260, 105);
		addText(18362, "", tda, 0, 0xFFFFFF, true, true);rsi.child(16, 18362, 330, 85);
		addText(18363, "", tda, 0, 0xFFFFFF, true, true);rsi.child(17, 18363, 330, 95);
		addText(18364, "", tda, 0, 0xFFFFFF, true, true);rsi.child(18, 18364, 330, 105);
		addText(18365, "", tda, 0, 0xFFFFFF, true, true);rsi.child(19, 18365, 400, 85);
		addText(18366, "", tda, 0, 0xFFFFFF, true, true);rsi.child(20, 18366, 400, 95);
		addText(18367, "", tda, 0, 0xFFFFFF, true, true);rsi.child(21, 18367, 400, 105);
		addText(18368, "", tda, 0, 0xFFFFFF, true, true);rsi.child(22, 18368, 120, 145);
		addText(18369, "", tda, 0, 0xFFFFFF, true, true);rsi.child(23, 18369, 120, 155);
		addText(18370, "", tda, 0, 0xFFFFFF, true, true);rsi.child(24, 18370, 120, 165);
		addText(18371, "", tda, 0, 0xFFFFFF, true, true);rsi.child(25, 18371, 190, 145);
		addText(18372, "", tda, 0, 0xFFFFFF, true, true);rsi.child(26, 18372, 190, 155);
		addText(18373, "", tda, 0, 0xFFFFFF, true, true);rsi.child(27, 18373, 190, 165);
		addText(18374, "", tda, 0, 0xFFFFFF, true, true);rsi.child(28, 18374, 260, 145);
		addText(18375, "", tda, 0, 0xFFFFFF, true, true);rsi.child(29, 18375, 260, 155);
		addText(18376, "", tda, 0, 0xFFFFFF, true, true);rsi.child(30, 18376, 260, 165);
		addText(18377, "", tda, 0, 0xFFFFFF, true, true);rsi.child(31, 18377, 330, 145);
		addText(18378, "", tda, 0, 0xFFFFFF, true, true);rsi.child(32, 18378, 330, 155);
		addText(18379, "", tda, 0, 0xFFFFFF, true, true);rsi.child(33, 18379, 330, 165);
		addText(18380, "", tda, 0, 0xFFFFFF, true, true);rsi.child(34, 18380, 400, 145);
		addText(18381, "", tda, 0, 0xFFFFFF, true, true);rsi.child(35, 18381, 400, 155);
		addText(18382, "", tda, 0, 0xFFFFFF, true, true);rsi.child(36, 18382, 400, 165);
		addText(18383, "", tda, 0, 0xFFFFFF, true, true);rsi.child(37, 18383, 120, 205);
		addText(18384, "", tda, 0, 0xFFFFFF, true, true);rsi.child(38, 18384, 120, 215);
		addText(18385, "", tda, 0, 0xFFFFFF, true, true);rsi.child(39, 18385, 120, 225);
		addText(18386, "", tda, 0, 0xFFFFFF, true, true);rsi.child(40, 18386, 190, 205);
		addText(18387, "", tda, 0, 0xFFFFFF, true, true);rsi.child(41, 18387, 190, 215);
		addText(18388, "", tda, 0, 0xFFFFFF, true, true);rsi.child(42, 18388, 190, 225);
		addText(18389, "", tda, 0, 0xFFFFFF, true, true);rsi.child(43, 18389, 260, 205);
		addText(18390, "", tda, 0, 0xFFFFFF, true, true);rsi.child(44, 18390, 260, 215);
		addText(18391, "", tda, 0, 0xFFFFFF, true, true);rsi.child(45, 18391, 260, 225);
		addText(18392, "", tda, 0, 0xFFFFFF, true, true);rsi.child(46, 18392, 330, 205);
		addText(18393, "", tda, 0, 0xFFFFFF, true, true);rsi.child(47, 18393, 330, 215);
		addText(18394, "", tda, 0, 0xFFFFFF, true, true);rsi.child(48, 18394, 330, 225);
		addText(18395, "", tda, 0, 0xFFFFFF, true, true);rsi.child(49, 18395, 400, 205);
		addText(18396, "", tda, 0, 0xFFFFFF, true, true);rsi.child(50, 18396, 400, 215);
		addText(18397, "", tda, 0, 0xFFFFFF, true, true);rsi.child(51, 18397, 400, 225);	
		addText(18398, "", tda, 0, 0xFFFFFF, true, true);rsi.child(52, 18398, 120, 260);
		addText(18399, "", tda, 0, 0xFFFFFF, true, true);rsi.child(53, 18399, 120, 270);
		addText(18400, "", tda, 0, 0xFFFFFF, true, true);rsi.child(54, 18400, 120, 280);
		addText(18401, "", tda, 0, 0xFFFFFF, true, true);rsi.child(55, 18401, 190, 260);
		addText(18402, "", tda, 0, 0xFFFFFF, true, true);rsi.child(56, 18402, 190, 270);
		addText(18403, "", tda, 0, 0xFFFFFF, true, true);rsi.child(57, 18403, 190, 280);
		addText(18404, "", tda, 0, 0xFFFFFF, true, true);rsi.child(58, 18404, 260, 260);
		addText(18405, "", tda, 0, 0xFFFFFF, true, true);rsi.child(59, 18405, 260, 270);
		addText(18406, "", tda, 0, 0xFFFFFF, true, true);rsi.child(60, 18406, 260, 280);
		addText(18407, "", tda, 0, 0xFFFFFF, true, true);rsi.child(61, 18407, 330, 260);
		addText(18408, "", tda, 0, 0xFFFFFF, true, true);rsi.child(62, 18408, 330, 270);
		addText(18409, "", tda, 0, 0xFFFFFF, true, true);rsi.child(63, 18409, 330, 280);
		addText(18410, "", tda, 0, 0xFFFFFF, true, true);rsi.child(64, 18410, 400, 260);
		addText(18411, "", tda, 0, 0xFFFFFF, true, true);rsi.child(65, 18411, 400, 270);
		addText(18412, "", tda, 0, 0xFFFFFF, true, true);rsi.child(66, 18412, 400, 280);
		addText(18413, "", tda, 0, 0xFFFFFF, true, true);rsi.child(67, 18413, 260, 155);
		/**
		 * First row of items
		 */
		int child = 68;
		int x = 170;
		for(int i = 18500; i <= 18503; i++) {
			addItemOnInterface(i, 4393, options);
			rsi.child(child, i, x, 50);
			child++;
			x += 70;
		}
		/**
		 * Second row of items
		 */
		child = 72;
		x = 100;
		for(int i = 0; i <= 4; i++) {
			addItemOnInterface(18504+i, 4393, options);
			rsi.child(child, 18504+i, x, 110);
			child++;
			x += 70;
		}
		/*
		 * Third row of items
		 */
		child = 77;
		x = 100;
		for(int i = 0; i <= 4; i++) {
			addItemOnInterface(18509+i, 4393, options);
			rsi.child(child, 18509+i, x, 170);
			child++;
			x += 70;
		}
		/**
		 * Fourth row of items
		 */
		child = 82;
		x = 100;
		for(int i = 0; i <= 4; i++) {
			addItemOnInterface(18514+i, 4393, options);
			rsi.child(child, 18514+i, x, 230);
			child++;
			x += 70;
		}
		rsi.child(87, 18535, 472, 21);
	}

	private void playersOnline() {
		RSInterface tab = addInterface(57000);
		addSpriteLoader(57001, 655);
		addText(57002, "Players Online", 0xff9933, true, true, -1, tda, 2);
		addText(57003, "", 0xff9933, true, true, -1, tda, 1);
		addText(57007, "Necrotic", 0xff9933, true, true, -1, tda, 0);
		addText(57008, "", 0xff9933, true, true, -1, tda, 3);
		addText(57009, "", 0xff9933, false, true, -1, tda, 0);
		addText(57010, "", 0xff9933, false, true, -1, tda, 0);
		addText(57011, "", 0xff9933, false, true, -1, tda, 0);
		addText(57012, "", 0xff9933, false, true, -1, tda, 0);
		addText(57013, "", 0xff9933, false, true, -1, tda, 0);
		addText(57014, "", 0xff9933, false, true, -1, tda, 0);
		addText(57015, "", 0xff9933, false, true, -1, tda, 0);
		addText(57016, "", 0xff9933, false, true, -1, tda, 0);
		addText(57017, "", 0xff9933, false, true, -1, tda, 0);
		addText(57018, "", 0xff9933, false, true, -1, tda, 0);
		addText(57019, "", 0xff9933, false, true, -1, tda, 0);
		addText(57020, "", 0xff9933, false, true, -1, tda, 0);
		addText(57021, "", 0xff9933, false, true, -1, tda, 0);
		addText(57022, "", 0xff9933, false, true, -1, tda, 0);		
		addText(57023, "", 0xff9933, false, true, -1, tda, 0);
		addText(57024, "", 0xff9933, false, true, -1, tda, 0);
		addCloseButton(57004, 57005, 57006);		
		addHoverButtonWSpriteLoader(57025, 656, 73, 35, "Add", -1, 57026, 3);
		addHoveredImageWSpriteLoader(57026, 657, 73, 35, 57027);
		addHoverButtonWSpriteLoader(57028, 656, 73, 35, "Ignore", -1, 57029, 3);
		addHoveredImageWSpriteLoader(57029, 657, 73, 35, 57030);		
		addText(57031, "Add", 0xff9933, true, true, -1, tda, 0);
		addText(57032, "Ignore", 0xff9933, true, true, -1, tda, 0);
		tab.totalChildren(30);
		tab.child(0, 57001, 14, 5);
		tab.child(1, 57040, 176, 90);
		tab.child(2, 57002, 175, 18);
		tab.child(3, 57003, 415, 58);
		tab.child(4, 57004, 470, 16);
		tab.child(5, 57005, 470, 16);
		tab.child(6, 57007, 415, 20);
		tab.child(7, 57008, 175, 65);
		tab.child(8, 57009, 60, 110);
		tab.child(9, 57010, 60, 125);
		tab.child(10, 57011, 60, 140);
		tab.child(11, 57012, 60, 155);
		tab.child(12, 57013, 60, 170);
		tab.child(13, 57014, 60, 185);
		tab.child(14, 57015, 60, 200);
		tab.child(15, 57016, 60, 215);
		tab.child(16, 57017, 187, 110);
		tab.child(17, 57018, 187, 125);
		tab.child(18, 57019, 187, 140);
		tab.child(19, 57020, 187, 155);
		tab.child(20, 57021, 187, 170);
		tab.child(21, 57022, 187, 185);
		tab.child(22, 57023, 187, 200);
		tab.child(23, 57024, 187, 215);		
		tab.child(24, 57025, 80, 262);
		tab.child(25, 57026, 80, 262);	
		tab.child(26, 57028, 202, 262);
		tab.child(27, 57029, 202, 262);
		tab.child(28, 57031, 114, 272);
		tab.child(29, 57032, 238, 272);		
		RSInterface scrollInterface = addTabInterface(57040);
		scrollInterface.width = 300;
		scrollInterface.height = 231;
		scrollInterface.scrollMax = 1330;
		setChildren(100, scrollInterface);
		/**
		 * just need to remove that last line 
		 */


		int y = -4;
		for (int i = 0; i < 100; i++) {
			addHoverText(57041 + i, "", "Select", tda, 3, 0xff9633, false, true, 100, 14);
			setBounds(57041 + i, 178, y, i, scrollInterface);
			y += 15;
		}
	}

	private void godWars() {
		RSInterface rsinterface = addTabInterface(16210);
		addText(16211, " Your killcount", tda, 0, 0xff9040, true, true);
		addText(16212, "Armadyl kills", tda, 0, 0xff9040, true, true);
		addText(16213, "Bandos kills", tda, 0, 0xff9040, true, true);
		addText(16214, "     Saradomin kills", tda, 0, 0xff9040, true, true);
		addText(16215, "  Zamorak kills", tda, 0, 0xff9040, true, true);
		addText(16220, "Zaros kills", tda, 0, 0xff9040, true, true);
		addText(16216, "0", tda, 0, 0x66FFFF, true, true);//armadyl
		addText(16217, "0", tda, 0, 0x66FFFF, true, true);//bandos
		addText(16218, "0", tda, 0, 0x66FFFF, true, true);//saradomin
		addText(16219, "0", tda, 0, 0x66FFFF, true, true);//zamorak
		addText(16221, "0", tda, 0, 0x66FFFF, true, true);//zaros
		rsinterface.scrollMax = 0;
		rsinterface.children = new int[9];
		rsinterface.childX = new int[9];
		rsinterface.childY = new int[9];
		rsinterface.children[0] = 16211;
		rsinterface.childX[0] = -52+375+30;		rsinterface.childY[0] = 12;
		rsinterface.children[1] = 16212;
		rsinterface.childX[1] = -52+375+30;		rsinterface.childY[1] = 30;
		rsinterface.children[2] = 16213;
		rsinterface.childX[2] = -52+375+30;		rsinterface.childY[2] = 44;
		rsinterface.children[3] = 16214;
		rsinterface.childX[3] = -52+375+30;		rsinterface.childY[3] = 58;
		rsinterface.children[4] = 16215;
		rsinterface.childX[4] = -52+375+30;		rsinterface.childY[4] = 73;
		rsinterface.children[5] = 16216;
		rsinterface.childX[5] = -52+460+60;		rsinterface.childY[5] = 31;
		rsinterface.children[6] = 16217;
		rsinterface.childX[6] = -52+460+60;		rsinterface.childY[6] = 45;
		rsinterface.children[7] = 16218;
		rsinterface.childX[7] = -52+460+60;		rsinterface.childY[7] = 59;
		rsinterface.children[8] = 16219;
		rsinterface.childX[8] = -52+460+60;		rsinterface.childY[8] = 74;
	}

	private void editClan() {
		RSInterface tab = addTabInterface(40172);
		addSpriteLoader(47251, 658);
		addHoverSpriteLoaderButton(47252, 659, 150, 35, "Set name", 22222, 47253, 1);
		addHoveredSpriteLoaderButton(47253, 150, 35, 47254, 659);
		addHoverSpriteLoaderButton(47255, 659, 150, 35, "Anyone", -1,
				47256, 1);
		addHoveredSpriteLoaderButton(47256, 150, 35, 47257, 659);

		addHoverButton(48000, "b", 1, 150, 35, "Only me", -1, 47999, 1);
		addHoverButton(48001, "b", 1, 150, 35, "General+", -1, 47999, 1);
		addHoverButton(48002, "b", 1, 150, 35, "Captain+", -1, 47999, 1);
		addHoverButton(48003, "b", 1, 150, 35, "Lieutenant+", -1, 47999, 1);
		addHoverButton(48004, "b", 1, 150, 35, "Sergeant+", -1, 47999, 1);
		addHoverButton(48005, "b", 1, 150, 35, "Corporal+", -1, 47999, 1);
		addHoverButton(48006, "b", 1, 150, 35, "Recruit+", -1, 47999, 1);
		addHoverButton(48007, "b", 1, 150, 35, "Any friends", -1, 47999, 1);

		addHoverSpriteLoaderButton(47258, 660, 150, 35, "Anyone", -1,
				47259, 1);
		addHoveredSpriteLoaderButton(47259, 659, 35, 17260, 727);

		addHoverButton(48010, "b", 1, 150, 35, "Only me", -1, 47999, 1);
		addHoverButton(48011, "b", 1, 150, 35, "General+", -1, 47999, 1);
		addHoverButton(48012, "b", 1, 150, 35, "Captain+", -1, 47999, 1);
		addHoverButton(48013, "b", 1, 150, 35, "Lieutenant+", -1, 47999, 1);
		addHoverButton(48014, "b", 1, 150, 35, "Sergeant+", -1, 47999, 1);
		addHoverButton(48015, "b", 1, 150, 35, "Corporal+", -1, 47999, 1);
		addHoverButton(48016, "b", 1, 150, 35, "Recruit+", -1, 47999, 1);
		addHoverButton(48017, "b", 1, 150, 35, "Any friends", -1, 47999, 1);

		addHoverSpriteLoaderButton(47261, 660, 150, 35, "Only me", -1,
				47262, 1);
		addHoveredSpriteLoaderButton(47262, 150, 35, 47263, 659);

		// addHoverButton(48020, "b", 1, 150, 35, "Only me", -1, 47999, 1);
		addHoverButton(48021, "b", 1, 150, 35, "General+", -1, 47999, 1);
		addHoverButton(48022, "b", 1, 150, 35, "Captain+", -1, 47999, 1);
		addHoverButton(48023, "b", 1, 150, 35, "Lieutenant+", -1, 47999, 1);
		addHoverButton(48024, "b", 1, 150, 35, "Sergeant+", -1, 47999, 1);
		addHoverButton(48025, "b", 1, 150, 35, "Corporal+", -1, 47999, 1);
		addHoverButton(48026, "b", 1, 150, 35, "Recruit+", -1, 47999, 1);

		addHoverSpriteLoaderButton(47267, 661, 16, 16, "Close", -1,
				47268, 1);
		addHoveredSpriteLoaderButton(47268, 16, 16, 47269, 662);

		addText(47800, "Clan name:", tda, 0, 0xff981f, false, true);
		addText(47801, "Who can enter chat?", tda, 0, 0xff981f, false, true);
		addText(47812, "Who can talk in chat?", tda, 0, 0xff981f, false, true);
		addText(47813, "Who can kick from chat?", tda, 0, 0xff981f, false, true);
		addText(47814, "Name", tda, 0, 0xffffff, true, true);
		addText(47815, "Anyone", tda, 0, 0xffffff, true, true);
		addText(47816, "Anyone", tda, 0, 0xffffff, true, true);
		addText(47817, "Only me", tda, 0, 0xffffff, true, true);
		tab.totalChildren(40);
		tab.child(0, 47251, 180, 15);
		tab.child(1, 47252, 190, 47 + 20);
		tab.child(2, 47253, 190, 47 + 20);
		tab.child(3, 47267, 327, 22);
		tab.child(4, 47268, 327, 22);
		tab.child(5, 48000, 190, 87 + 25);
		tab.child(6, 48001, 190, 87 + 25);
		tab.child(7, 48002, 190, 87 + 25);
		tab.child(8, 48003, 190, 87 + 25);
		tab.child(9, 48004, 190, 87 + 25);
		tab.child(10, 48005, 190, 87 + 25);
		tab.child(11, 48006, 190, 87 + 25);
		tab.child(12, 48007, 190, 87 + 25);
		tab.child(13, 47255, 190, 87 + 25);
		tab.child(14, 47256, 190, 87 + 25);
		tab.child(15, 48010, 190, 128 + 30);
		tab.child(16, 48011, 190, 128 + 30);
		tab.child(17, 48012, 190, 128 + 30);
		tab.child(18, 48013, 190, 128 + 30);
		tab.child(19, 48014, 190, 128 + 30);
		tab.child(20, 48015, 190, 128 + 30);
		tab.child(21, 48016, 190, 128 + 30);
		tab.child(22, 48017, 190, 128 + 30);
		tab.child(23, 47258, 190, 128 + 30);
		//tab.child(24, 47259, 190, 128 + 30);
		// tab.child(25, 48020, 25, 168+35);
		tab.child(24, 48021, 190, 168 + 35);
		tab.child(25, 48022, 190, 168 + 35);
		tab.child(26, 48023, 190, 168 + 35);
		tab.child(27, 48024, 190, 168 + 35);
		tab.child(28, 48025, 190, 168 + 35);
		tab.child(29, 48026, 190, 168 + 35);
		tab.child(30, 47261, 190, 168 + 35);
		tab.child(31, 47262, 190, 168 + 35);
		tab.child(32, 47800, 238, 54 + 20);
		tab.child(33, 47801, 215, 95 + 25);
		tab.child(34, 47812, 215, 136 + 30);
		tab.child(35, 47813, 215, 177 + 35);
		tab.child(36, 47814, 265, 54 + 20 + 12);
		tab.child(37, 47815, 265, 95 + 25 + 12);
		tab.child(38, 47816, 265, 136 + 30 + 12);
		tab.child(39, 47817, 265, 177 + 35 + 12);

	}


	private void dungeonInfo() {
		RSInterface tab = addTabInterface(37500);
		addText(37508, "Party deaths: 0", tda, 2, 0x86B404, true, true);
		addText(37509, "Party kills: 0", tda, 2, 0x86B404, true, true);
		tab.totalChildren(2);
		tab.child(0, 37508, 50, 299);
		tab.child(1, 37509, 41, 315);
	}

	private void formParty() {
		RSInterface tab = addTabInterface(27224);
		addHDSprite(27225, 1013, 1013);
		/*addHoverButton(27326, 141, 141, 16, 16, "Exit", 250, 27227, 5);
		addHoveredButton(27227, 142, 142, 16, 16, 27228);*/

		addHoverButton(27229, 1014, 1014, 180, 32, "Form Party", 250, 27230, 5);
		addHoveredButton(27230, 1015, 1015, 180, 32, 27231);

		/*addHoverButton(27132, 146, 146, 52, 25, "Reset", 250, 27133, 5);
		addHoveredButton(27133, 147, 147, 52, 25, 27134);*/

		addText(27235, "", tda, 1, 0xffffff, true, true);
		addText(27236, "", tda, 1, 0xffffff, true, true);
		addText(27237, "", tda, 1, 0xffffff, true, true);
		addText(27238, "", tda, 1, 0xffffff, true, true);
		addText(27239, "", tda, 1, 0xffffff, true, true);
		addText(27240, "", tda, 2, 0xffffff, false, true);
		addText(27241, "", tda, 2, 0xffffff, true, true);
		addText(27242, "-", tda, 1, 0xffffff, false, true);
		addText(27243, "-", tda, 1, 0xffffff, false, true);
		int[][] data = { { 27225, 0, 0 },/* { 27326, 171, 1 }, { 27227, 171, 1 },*/
				{ 27229, 5, 111 }, { 27230, 5, 111 }, /*{ 27132, 132, 230 },
				{ 27133, 132, 230 }, */{ 27235, 91, 29 }, { 27236, 91, 44 },
				{ 27237, 91, 59 }, { 27238, 91, 75 }, { 27239, 91, 90 },
				{ 27240, 99, 156 }, { 27241, 103, 183 }, { 27242, 112, 229 },
				{ 27243, 112, 245 } };
		tab.totalChildren(12); // 14, 16
		for (int i = 0; i < data.length; i++) {
			tab.child(i, data[i][0], data[i][1], data[i][2]);
		}
	}

	private void dungParty() {
		RSInterface tab = addTabInterface(26224);
		addHDSprite(26225, 1013, 1013);
		addHoverButton(26226, 1016, 1016, 16, 16, "Exit", 250, 26227, 5);
		addHoveredButton(26227, 1017, 1017, 16, 16, 26228);
		addHoverButton(26229, 1018, 1018, 90, 32, "Leave Party", 250, 26230, 5);
		addHoveredButton(26230, 1019, 1019, 90, 32, 26231);
		addText(26235, "", tda, 1, 0xffffff, true, true);
		addText(26236, "", tda, 1, 0xffffff, true, true);
		addText(26237, "", tda, 1, 0xffffff, true, true);
		addText(26238, "", tda, 1, 0xffffff, true, true);
		addText(26239, "", tda, 1, 0xffffff, true, true);
		addText(26240, "0", tda, 2, 0xffffff, false, true);
		addText(26241, "-", tda, 2, 0xffffff, true, true);
		addText(26242, "-", tda, 1, 0xffffff, false, true);
		addText(26243, "-", tda, 1, 0xffffff, false, true);
		addHoverButton(26244, 1022, 1022, 61, 20, "Change", 250, 26245, 5);
		addHoveredButton(26245, 1023, 1023, 61, 20, 26246);
		addHoverButton(26247, 1022, 1022, 61, 20, "Change", 250, 26248, 5);
		addHoveredButton(26248, 1023, 1023, 61, 20, 26249);
		addHoverButton(26250, 1020, 1020, 90, 32, "Invite player", 250, 26251, 5);
		addHoveredButton(26251, 1021, 1021, 90, 32, 26252);
		int[][] data = { { 26225, 0, 0 }, { 26226, 171, 1 }, { 26227, 171, 1 },
				{ 26229, 5, 111 }, { 26230, 5, 111 }, /*{ 26232, 132, 230 },
				{ 26233, 132, 230 },*/ { 26235, 91, 29 }, { 26236, 91, 44 },
				{ 26237, 91, 59 }, { 26238, 91, 75 }, { 26239, 91, 90 },
				{ 26240, 99, 156 }, { 26241, 103, 183 },{ 26242, 112, 229 },
				{ 26243, 112, 245 }, { 26244, 121, 152 }, { 26245, 121, 152 },
				{ 26247, 121, 180 }, { 26248, 121, 180 }, { 26250, 95, 111 },
				{ 26251, 95, 111 } };
		tab.totalChildren(20);
		for (int i = 0; i < data.length; i++) {
			tab.child(i, data[i][0], data[i][1], data[i][2]);
		}
	}
    private void teleportGUI() {
		RSInterface rsInterface = addTabInterface(13999);
		addSpriteLoader(49001, 1190);
	
		addHoverButtonWSpriteLoader(49002, 652, 17, 17, "Close Window", 0, 49003, 1);
		addHoveredImageWSpriteLoader(49003, 653, 17, 17, 49004);
		
		//text
		addText(49005, "Necrotic Teleports", tda, 2, 0xFFFFFF);
		addText(49050, "Training", tda, 2, 0xFFFFFF);
		addText(49007, "Skilling", tda, 2, 0xFFFFFF);
		addText(49008, "Dungeons", tda, 2, 0xFFFFFF);
		addText(49009, "Bosses", tda, 2, 0xFFFFFF);
		addText(49010, "Minigames", tda, 2, 0xFFFFFF);
		addText(49011, "Wilderness", tda, 2, 0xFFFFFF);
		//buttons
		addHoverButtonWSpriteLoader(49012, 1191, 112, 23, "Training teleports", 0, 49018, 1);
		addHoveredImageWSpriteLoader(49018, 1192, 112, 23, 36010);
		
		addHoverButtonWSpriteLoader(49013, 1191, 112, 23, "Skilling teleports", 0, 49019, 1);
		addHoveredImageWSpriteLoader(49019, 1192, 112, 23, 36010);
		
		addHoverButtonWSpriteLoader(49014, 1191, 112, 23, "Dungeon teleports", 0, 49020, 1);
		addHoveredImageWSpriteLoader(49020, 1192, 112, 23, 36010);
		
		addHoverButtonWSpriteLoader(49015, 1191, 112, 23, "Boss teleports", 0, 49021, 1);
		addHoveredImageWSpriteLoader(49021, 1192, 112, 23, 36010);
		
		addHoverButtonWSpriteLoader(49016, 1191, 112, 23, "Minigame teleports", 0, 49022, 1);
		addHoveredImageWSpriteLoader(49022, 1192, 112, 23, 36010);
		
		addHoverButtonWSpriteLoader(49017, 1191, 112, 23, "Wilderness teleports", 0, 49023, 1);
		addHoveredImageWSpriteLoader(49023, 1192, 112, 23, 36010);
		
		setChildren(22, rsInterface);
		rsInterface.child(0, 49001, 6, 7); //Background
		rsInterface.child(1, 49002, 460, 18); //Close Button
		rsInterface.child(2, 49003, 460, 18); // Close Button Hover
		rsInterface.child(3, 49012, 13, 47); //training button
		rsInterface.child(4, 49013, 13, 74); //skilling button
		rsInterface.child(5, 49014, 13, 102); //dungeons button
		rsInterface.child(6, 49015, 13, 126); //bosses button
		rsInterface.child(7, 49016, 13, 153); //Minigames button
		rsInterface.child(8, 49017, 13, 178); //wilderness button 
		rsInterface.child(9, 49018, 13, 48); //training button hover
		rsInterface.child(10, 49019, 13, 74); //skilling button hover
		rsInterface.child(11, 49020, 13, 102); //dungeons button hover
		rsInterface.child(12, 49021, 13, 126); //bosses button hover
		rsInterface.child(13, 49022, 13, 153); //Minigames button hover
		rsInterface.child(14, 49023, 13, 178); //wilderness button 	
		rsInterface.child(15, 49005, 225, 22); //title
		rsInterface.child(16, 49050, 48, 53); //training
		rsInterface.child(17, 49007, 48, 80); //skilling
		rsInterface.child(18, 49008, 42, 105); //dungeons
		rsInterface.child(19, 49009, 48, 130); //bosses
		rsInterface.child(20, 49010, 37, 156); //Minigames
		rsInterface.child(21, 49011, 35, 183); //wilderness
    }
	private void slayerBuyInterface() {
		RSInterface rsInterface = addTabInterface(36000);
		addSpriteLoader(36001, 663);

		addHoverButtonWSpriteLoader(36002, 664, 17, 17, "Close Window", 0, 36003, 1);
		addHoveredImageWSpriteLoader(36003, 665, 17, 17, 36004);

		//Tab Buttons

		addHoverButtonWSpriteLoader(36008, 667, 112, 23, "Experience", 0, 36009, 1);
		addHoveredImageWSpriteLoader(36009, 667, 112, 23, 36010);

		addHoverButtonWSpriteLoader(36005, 666, 112, 23, "Items", 0, 36006, 1);
		addHoveredImageWSpriteLoader(36006, 667, 112, 23, 36007);

		addHoverButtonWSpriteLoader(36014, 668, 72, 19, "Buy", 0, 36015, 1);
		addHoveredImageWSpriteLoader(36015, 669, 72, 19, 36016);

		addHoverButtonWSpriteLoader(36017, 668, 72, 19, "Buy", 0, 36018, 1);
		addHoveredImageWSpriteLoader(36018, 669, 72, 19, 36019);

		//Text
		addText(36029, "Slayer Shop", tda, 2, 0xFFFFFF);
		addText(36030, "Current Points:   0", tda, 2, 0xD8D8D8);
		addText(36031, "Slayer XP: 10,000 (Stacks with votes & double exp)", tda, 1, 0xFFFFFF);
		addText(36032, "10 Points", tda, 1, 0xD8D8D8);
		addText(36020, "Experience", tda, 0, 0xffffff, false, true);
		addText(36021, "Items", tda, 0, 0xffffff, false, true);
		addText(36033, "Permanent: Double Slayer XP", tda, 1, 0xFFFFFF);
		addText(36034, "300 Points", tda, 1, 0xD8D8D8);
		/*addText(36037, "Broad Bolts: 250", fonts, 1, 0xFFFFFF);
		addText(36038, "65 Points", fonts, 1, 0xD8D8D8);
		addText(36039, "Broad Arrows: 250", fonts, 1, 0xFFFFFF);
		addText(36040, "35 Points", fonts, 1, 0xD8D8D8);


		addText(36041, "Slayer Helmet", fonts, 1, 0xFFFFFF);
		addText(36042, "375 Points", fonts, 1, 0xD8D8D8);*/
		setChildren(19, rsInterface);
		rsInterface.child(0, 36001, 6, 7); //Background
		rsInterface.child(1, 36002, 483,10); //Close Button
		rsInterface.child(2, 36003, 483, 10); // Close Button Hover
		rsInterface.child(3, 36005, 138, 41); // Learn Tab
		rsInterface.child(4, 36006, 138, 41); // Learn Tab Hover
		rsInterface.child(5, 36008, 20, 41); // Learn Tab
		rsInterface.child(6, 36009, 20, 41); // Learn Tab Hover
		//	rsInterface.child(5, 36008, 263, 41); // Assignment Tab
		//	rsInterface.child(6, 36009, 263, 41); // Assignment Tab Hover
		//	rsInterface.child(7, 36011, 384, 41); // Co-op Tab
		//	rsInterface.child(8, 36012, 384, 41); // Co-op Tab Hover
		rsInterface.child(7, 36014, 174, 107); // Slayer Buy
		rsInterface.child(8, 36015, 174, 107); // Slayer Buy Hover
		rsInterface.child(9, 36017, 174, 177); // Ring Buy
		rsInterface.child(10, 36018, 174, 177); // Ring Hover
		rsInterface.child(11, 36029, 215, 15); // Title
		rsInterface.child(12, 36030, 22, 283); // Points
		rsInterface.child(13, 36031, 74, 87); // Slayer XP
		rsInterface.child(14, 36032, 74, 102); // 400 Points
		rsInterface.child(15, 36033, 74, 157); //Slay Ring
		rsInterface.child(16, 36034, 74, 172); // 75 Points
		rsInterface.child(17, 36020, 48, 48);
		rsInterface.child(18, 36021, 180, 48);
	}

	private void expRewardInterface() {
		RSInterface Interface = addTabInterface(38000);
		setChildren(37, Interface);
		addSpriteLoader(38001, 670);

		addHoverButtonWSpriteLoader(38002, 672, 21, 21, "Exit", 0, 38003, 1);
		addHoveredImageWSpriteLoader(38003, 673, 21, 21, 38004);

		addSpriteLoader(38005, 671);
		addText(38006, "Choose XP Type...", tda, 1, 0xE3CCCF, true, true);
		addText(38090, "What sort of XP would you like?", tda, 1, 0xE3CCCF, true, true);
		//Line 1

		addButtonWSpriteLoader(38007, 675, "Choose Attack", 46, 44);
		addButtonWSpriteLoader(38010, 675, "Choose Magic", 46, 44);
		addButtonWSpriteLoader(38013, 675, "Choose Mining", 46, 44);
		addButtonWSpriteLoader(38016, 675, "Choose Woodcutting", 46, 44);
		addButtonWSpriteLoader(38019, 675, "Choose Agility", 46, 44);
		addButtonWSpriteLoader(38022, 675, "Choose Fletching", 46, 44);
		addButtonWSpriteLoader(38025, 675, "Choose Thieving", 46, 44);
		addButtonWSpriteLoader(38028, 675, "Choose Strength", 46, 44);
		addButtonWSpriteLoader(38031, 675, "Choose Ranged", 46, 44);
		addButtonWSpriteLoader(38034, 675, "Choose Smithing", 46, 44);
		addButtonWSpriteLoader(38037, 675, "Choose Firemaking", 46, 44);
		addButtonWSpriteLoader(38040, 675, "Choose Herblore", 46, 44);
		addButtonWSpriteLoader(38043, 675, "Choose Slayer", 46, 44);
		addButtonWSpriteLoader(38046, 675, "Choose Construction", 46, 44);
		addButtonWSpriteLoader(38049, 675, "Choose Defence", 46, 44);
		addButtonWSpriteLoader(38052, 675, "Choose Prayer", 46, 44);
		addButtonWSpriteLoader(38043, 675, "Choose Slayer", 46, 44);
		addButtonWSpriteLoader(38055, 675, "Choose Fishing", 46, 44);
		addButtonWSpriteLoader(38058, 675, "Choose Crafting", 46, 44);
		addButtonWSpriteLoader(38061, 675, "Choose Farming", 46, 44);
		addButtonWSpriteLoader(38064, 675, "Choose Hunter", 46, 44);
		addButtonWSpriteLoader(38067, 675, "Choose Summoning", 46, 44);
		addButtonWSpriteLoader(38070, 675, "Choose Constitution", 46, 44);
		addButtonWSpriteLoader(38073, 675, "Choose Dungeoneering", 46, 44);
		addButtonWSpriteLoader(38076, 675, "Choose Cooking", 46, 44);
		addButtonWSpriteLoader(38079, 675, "Choose Runecrafting", 46, 44);

		//Other Stuff

		addHoverButtonWSpriteLoader(38082, 676, 127, 21, "Cancel", -1, 38083, 1);
		addHoveredImageWSpriteLoader(38083, 677, 127, 21, 38084);

		addHoverButtonWSpriteLoader(38085, 678, 127, 21, "Confirm", -1, 38086, 1);
		addHoveredImageWSpriteLoader(38086, 679, 127, 21, 38087);

		addText(38088, "Confirm", tda, 1, 0xE3CCCF, false, true);
		addText(38089, "Not right now", tda, 1, 0xE3CCCF, false, true);

		setBounds(38001, 10, 14, 0, Interface);//background
		setBounds(38002, 470, 20, 1, Interface);//Close Button
		setBounds(38003, 470, 20, 2, Interface);//Close Button
		setBounds(38005, 181, 48, 3, Interface);
		setBounds(38006, 255, 52, 4, Interface);
		//Line 1
		setBounds(38007, 37, 80, 5, Interface);

		setBounds(38010, 102, 80, 6, Interface);
		setBounds(38013, 167, 80, 7, Interface);
		setBounds(38016, 232, 80, 8, Interface);
		setBounds(38019, 297, 80, 9, Interface);
		setBounds(38022, 362, 80, 10, Interface);
		setBounds(38025, 427, 80, 11, Interface);
		//Line 2
		setBounds(38028, 37, 138, 12, Interface);
		setBounds(38031, 102, 138, 13, Interface);
		setBounds(38034, 167, 138, 14, Interface);
		setBounds(38037, 232, 138, 15, Interface);
		setBounds(38040, 297, 138, 16, Interface);
		setBounds(38043, 362, 138, 17, Interface);
		setBounds(38046, 427, 138, 18, Interface);
		//Line 3
		setBounds(38049, 37, 196, 19, Interface);
		setBounds(38052, 102, 196, 20, Interface);
		setBounds(38055, 167, 196, 21, Interface);
		setBounds(38058, 232, 196, 22, Interface);
		setBounds(38061, 297, 196, 23, Interface);
		setBounds(38064, 362, 196, 24, Interface);
		setBounds(38067, 427, 196, 25, Interface);
		//Line 4
		setBounds(38070, 37, 254, 26, Interface);
		setBounds(38073, 102, 254, 27, Interface);
		setBounds(38076, 167, 254, 28, Interface);
		setBounds(38079, 232, 254, 29, Interface);
		//Other Stuff
		setBounds(38082, 322, 280, 30, Interface);
		setBounds(38083, 322, 280, 31, Interface);
		setBounds(38085, 322, 250, 32, Interface);
		setBounds(38086, 322, 250, 33, Interface);
		setBounds(38088, 360, 253, 34, Interface);
		setBounds(38089, 350, 283, 35, Interface);
		setBounds(38090, 256, 24, 36, Interface);
	}

	private void barrowsInterface() {
		RSInterface tab = addTabInterface(37200);
		addText(37201, "Barrow Brothers:", tda, 2, 0xff981f, true, true);
		addText(37202, "Dharoks", tda, 1, 0x86B404, true, true);
		addText(37203, "Veracs", tda, 1, 0x86B404, true, true);
		addText(37204, "Ahrims", tda, 1, 0x86B404, true, true);
		addText(37205, "Torags", tda, 1, 0x86B404, true, true);
		addText(37206, "Guthans", tda, 1, 0x86B404, true, true);
		addText(37207, "Karils", tda, 1, 0x86B404, true, true);
		addText(37208, "Killcount: 2", tda, 2, 0xff981f, true, true);
		tab.totalChildren(8);
		tab.child(0, 37201, 447, 206);
		tab.child(1, 37202, 450, 221);
		tab.child(2, 37203, 450, 236);
		tab.child(3, 37204, 450, 251);
		tab.child(4, 37205, 450, 266);
		tab.child(5, 37206, 450, 281);
		tab.child(6, 37207, 450, 296);
		tab.child(7, 37208, 435, 315);
	}


	private void pestControlInterfaces() {
		RSInterface rsinterface = addTabInterface(21100);
		addSpriteLoader(21101, 680);
		addSpriteLoader(21102, 681);
		addSpriteLoader(21103, 682);
		addSpriteLoader(21104, 683);
		addSpriteLoader(21105, 684);
		addSpriteLoader(21106, 685);
		addText(21107, "W", 0xcc00cc, false, true, 52, tda, 1);
		addText(21108, "E", 0x0000FF, false, true, 52, tda, 1);
		addText(21109, "SE", 0xffff44, false, true, 52, tda, 1);
		addText(21110, "SW", 0xcc0000, false, true, 52, tda, 1);
		addText(21111, "250", 0x99ff33, false, true, 52, tda, 1);
		addText(21112, "250", 0x99ff33, false, true, 52, tda, 1);
		addText(21113, "250", 0x99ff33, false, true, 52, tda, 1);
		addText(21114, "250", 0x99ff33, false, true, 52, tda, 1);
		addText(21115, "***", 0x99ff33, false, true, 52, tda, 1);
		addText(21116, "***", 0x99ff33, false, true, 52, tda, 1);
		addText(21117, "Time Remaining:", 0xffffff, false, true, 52, tda, 0);
		addText(21118, "", 0xffffff, false, true, 52, tda, 0);
		byte byte0 = 18;
		rsinterface.children = new int[byte0];
		rsinterface.childX = new int[byte0];
		rsinterface.childY = new int[byte0];
		setBounds(21101, 361, 26, 0, rsinterface);
		setBounds(21102, 396, 26, 1, rsinterface);
		setBounds(21103, 436, 26, 2, rsinterface);
		setBounds(21104, 474, 26, 3, rsinterface);
		setBounds(21105, 3, 21, 4, rsinterface);
		setBounds(21106, 3, 50, 5, rsinterface);
		setBounds(21107, 371, 60, 6, rsinterface);
		setBounds(21108, 409, 60, 7, rsinterface);
		setBounds(21109, 443, 60, 8, rsinterface);
		setBounds(21110, 479, 60, 9, rsinterface);
		setBounds(21111, 362, 10, 10, rsinterface);
		setBounds(21112, 398, 10, 11, rsinterface);
		setBounds(21113, 436, 10, 12, rsinterface);
		setBounds(21114, 475, 10, 13, rsinterface);
		setBounds(21115, 32, 32, 14, rsinterface);
		setBounds(21116, 32, 62, 15, rsinterface);
		setBounds(21117, 8, 88, 16, rsinterface);
		setBounds(21118, 87, 88, 17, rsinterface);
		RSInterface rsinterface2 = addTabInterface(21005);
		addText(21006, "Next Departure:", 0xCCCBCB, false, true, 52, tda, 1);
		addText(21007, "Players Ready:", 0x5BD230, false, true, 52, tda, 1);
		addText(21008, "(Need 5 to 25 players)", 0xDED36A, false, true, 52, tda, 1);
		addText(21009, "Commendations:", 0x99FFFF, false, true, 52, tda, 1);
		byte0 = 4;
		rsinterface2.children = new int[byte0];
		rsinterface2.childX = new int[byte0];
		rsinterface2.childY = new int[byte0];
		setBounds(21006, 15, 13, 0, rsinterface2);
		setBounds(21007, 15, 33, 1, rsinterface2);
		setBounds(21008, 15, 51, 2, rsinterface2);
		setBounds(21009, 15, 69, 3, rsinterface2);

		RSInterface tab1 = addTabInterface(18730);
		addSpriteLoader(18732, 686);

		addButtonWSpriteLoader(18733, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18734, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18735, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18737, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18740, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18741, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18742, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18745, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18743, 688, "Enchant");

		addButtonWSpriteLoader(18728, 689, "Close Window", 16, 16);

		addText(18729, "", tda, 0, 0xFFA500, false, true);

		// addButton(18776, 0, "PestControl/X", 102, 22, "extra", 1);
		tab1.totalChildren(13);
		tab1.child(0, 18731, 4, 16);
		tab1.child(1, 18732, 4, 16);
		tab1.child(2, 18733, 30, 127);
		tab1.child(3, 18734, 30, 201);
		tab1.child(4, 18735, 184, 127);
		tab1.child(5, 18737, 184, 201);

		tab1.child(6, 18740, 184, 274);
		tab1.child(7, 18741, 338, 127);
		tab1.child(8, 18742, 338, 201);
		tab1.child(9, 18743, 56, 231);
		tab1.child(10, 18728, 480, 20);
		tab1.child(11, 18729, 370, 47);
		tab1.child(12, 18745, 338, 274);

		//tab1.child(17, 18776, 334, 46);
		/* Equipment Tab Void */
		RSInterface tab2 = addTabInterface(18746);

		addSpriteLoader(18747, 690);
		addButtonWSpriteLoader(18748, 691, "Back");

		addButtonWSpriteLoader(18749, 687, "Purchase", 142, 14);
		addButtonWSpriteLoader(18750, 687, "Purchase", 142, 14);

		addButtonWSpriteLoader(18728, 689, "Close Window", 16, 16);
		// addButton(18776, 0, "PestControl/X", 102, 22, "extra", 1);
		tab2.totalChildren(6);
		tab2.child(0, 18747, 4, 16);
		tab2.child(1, 18748, 56, 231);
		tab2.child(2, 18749, 30, 127);
		tab2.child(3, 18750, 184, 127);
		tab2.child(4, 18728, 480, 20);
		tab2.child(5, 18729, 370, 47);

	}

	private void friendsTabInterface() {
		RSInterface tab = addTabInterface(5065);
		RSInterface list = interfaceCache[5066];
		addText(5067, "Friends List", tda, 1, 0xff9933, true, true);
		addText(5070, "Add Friend", tda, 0, 0xff9933, false, true);
		addText(5071, "Delete Friend", tda, 0, 0xff9933, false, true);
		addSpriteLoader(16126, 692);
		addSpriteLoader(16127, 693);
		addHoverButtonWSpriteLoader(5068, 694, 72, 32, "Add Friend", 201, 5072, 1);
		addHoveredImageWSpriteLoader(5072, 695, 72, 32, 5073);
		addHoverButtonWSpriteLoader(5069, 694, 72, 32, "Delete Friend", 202, 5074, 1);
		addHoveredImageWSpriteLoader(5074, 695, 72, 32, 5075);				
		tab.totalChildren(11);
		tab.child(0, 5067, 95, 4);
		tab.child(1, 16127, 0, 25);
		tab.child(2, 16126, 0, 221);
		tab.child(3, 5066, 0, 24);
		tab.child(4, 16126, 0, 22);
		tab.child(5, 5068, 15, 226);
		tab.child(6, 5072, 15, 226);
		tab.child(7, 5069, 103, 226);
		tab.child(8, 5074, 103, 226);
		tab.child(9, 5070, 25, 237);
		tab.child(10, 5071, 106, 237);
		list.height = 196;
		list.width = 174;
		int id = 5092;
		for (int i = 0; id <= 5191 && i <= 99; i++) {
			list.children[i] = id;
			list.childX[i] = 3;
			list.childY[i] = list.childY[i] - 7;
			id++;
		}

		id = 5192;
		for (int i = 100; id <= 5291 && i <= 199; i++) {
			list.children[i] = id;
			list.childX[i] = 131;
			list.childY[i] = list.childY[i] - 7;
			id++;
		}
	}

	private void ignoreTabInterface() {
		RSInterface tab = addTabInterface(5715);
		RSInterface list = interfaceCache[5716];
		addText(5717, "Ignore List", tda, 1, 0xff9933, true, true);
		addText(5720, "Add Name", tda, 0, 0xff9933, false, true);
		addText(5721, "Delete Name", tda, 0, 0xff9933, false, true);
		addHoverButtonWSpriteLoader(5718, 694, 72, 32, "Add Name", 501, 5722, 1);
		addHoveredImageWSpriteLoader(5722, 695, 72, 32, 5723);
		addHoverButtonWSpriteLoader(5719, 694, 72, 32, "Delete Name", 502, 5724, 1);
		addHoveredImageWSpriteLoader(5724, 695, 72, 32, 5725);
		tab.totalChildren(11);
		tab.child(0, 5717, 95, 4);
		tab.child(1, 16127, 0, 25);
		tab.child(2, 16126, 0, 221);
		tab.child(3, 5716, 0, 24);
		tab.child(4, 16126, 0, 22);
		tab.child(5, 5718, 15, 226);
		tab.child(6, 5722, 15, 226);
		tab.child(7, 5719, 103, 226);
		tab.child(8, 5724, 103, 226);
		tab.child(9, 5720, 27, 237);
		tab.child(10, 5721, 108, 237);
		list.height = 196;
		list.width = 174;
		int id = 5742;
		for (int i = 0; id <= 5841 && i <= 99; i++) {
			list.children[i] = id;
			list.childX[i] = 3;
			list.childY[i] = list.childY[i] - 7;
			id++;
		}
	}

	private void equipmentScreenInterface() {
		RSInterface tab = addTabInterface(21172);
		addSpriteLoader(21173, 696);
		addCloseButton(15210, 15215, 15216);
		addText(15111, "", tda, 2, 0xe4a146, false, true);
		int rofl = 3;
		addText(15112, "Attack bonuses", tda, 2, 0xFF8900, false, true);
		addText(15113, "Defence bonuses", tda, 2, 0xFF8900, false, true);
		addText(15114, "Other bonuses", tda, 2, 0xFF8900, false, true);
		addText(66100, "Summoning: +0", tda, 1, 0xFF8900, false, true);// 19148
		addText(66101, "Absorb Melee: +0%", tda, 1, 0xFF9200, false, true);// 19149
		addText(66102, "Absorb Magic: +0%", tda, 1, 0xFF9200, false, true);// 19150
		addText(66103, "Absorb Ranged: +0%", tda, 1, 0xFF9200, false, true);// 19151
		addText(66104, "Ranged Strength: +0", tda, 1, 0xFF9200, false, true);// 19152
		addText(66105, "Magic Damage: +0%", tda, 1, 0xFF9200, false, true);// 19153
		for (int i = 1675; i <= 1684; i++) {
			addText(i, "", tda, 1, 0xFF9200, false, true);
		}
		textSize(1686, tda, 1);
		textSize(1687, tda, 1);
		addChar(15125);
		tab.totalChildren(51);
		tab.child(0, 21173, 15, 5);
		tab.child(1, 15210, 476, 6);
		tab.child(2, 15111, 14, 30);
		tab.child(3, 15111, 14, 30);
		int Child = 4;
		int Y = 45;
		tab.child(16, 15112, 24, 30 - rofl);
		for (int i = 1675; i <= 1679; i++) {
			tab.child(Child, i, 29, Y - rofl);
			Child++;
			Y += 14;
		}
		int edit = 7 + rofl;
		tab.child(18, 15113, 24, 122 - edit);
		tab.child(9, 1680, 29, 137 - edit - 2);
		tab.child(10, 1681, 29, 153 - edit - 3);
		tab.child(11, 1682, 29, 168 - edit - 3);
		tab.child(12, 1683, 29, 183 - edit - 3);
		tab.child(13, 1684, 29, 197 - edit - 3);
		tab.child(44, 66100, 29, 211 - edit - 3);
		tab.child(45, 66101, 29, 225 - edit - 3);
		tab.child(46, 66102, 29, 239 - edit - 3);
		tab.child(47, 66103, 29, 253 - edit - 3);
		/* bottom */
		int edit2 = 33 - rofl, edit3 = 2;
		tab.child(19, 15114, 24, 223 + edit2);
		tab.child(14, 1686, 29, 262 - 24 + edit2 - edit3);
		tab.child(17, 66104, 29, 276 - 24 + edit2 - edit3);
		tab.child(48, 1687, 29, 290 - 24 + edit2 - edit3);
		tab.child(49, 66105, 29, 304 - 24 + edit2 - edit3);
		tab.child(15, 15125, 170, 200);
		tab.child(20, 1645, 104 + 295, 149 - 52);
		tab.child(21, 1646, 399, 163);
		tab.child(22, 1647, 399, 163);
		tab.child(23, 1648, 399, 58 + 146);
		tab.child(24, 1649, 26 + 22 + 297 - 2, 110 - 44 + 118 - 13 + 5);
		tab.child(25, 1650, 321 + 22, 58 + 154);
		tab.child(26, 1651, 321 + 134, 58 + 118);
		tab.child(27, 1652, 321 + 134, 58 + 154);
		tab.child(28, 1653, 321 + 48, 58 + 81);
		tab.child(29, 1654, 321 + 107, 58 + 81);
		tab.child(30, 1655, 321 + 58, 58 + 42);
		tab.child(31, 1656, 321 + 112, 58 + 41);
		tab.child(32, 1657, 321 + 78, 58 + 4);
		tab.child(33, 1658, 321 + 37, 58 + 43);
		tab.child(34, 1659, 321 + 78, 58 + 43);
		tab.child(35, 1660, 321 + 119, 58 + 43);
		tab.child(36, 1661, 321 + 22, 58 + 82);
		tab.child(37, 1662, 321 + 78, 58 + 82);
		tab.child(38, 1663, 321 + 134, 58 + 82);
		tab.child(39, 1664, 321 + 78, 58 + 122);
		tab.child(40, 1665, 321 + 78, 58 + 162);
		tab.child(41, 1666, 321 + 22, 58 + 162);
		tab.child(42, 1667, 321 + 134, 58 + 162);
		tab.child(43, 1688, 50 + 297 - 2, 110 - 13 + 5);
		for (int i = 1675; i <= 1684; i++) {
			RSInterface rsi = interfaceCache[i];
			addText(i, "", tda, 1, 0xFF9200, false, true);
			rsi.textColor = 0xFF9200;
			rsi.centerText = false;
		}
		for (int i = 1686; i <= 1687; i++) {
			RSInterface rsi = interfaceCache[i];
			addText(i, "", tda, 1, 0xFF9200, false, true);
			rsi.textColor = 0xFF9200;
			rsi.centerText = false;
		}
		tab.child(50, 15215, 476, 6);
	}

	private void itemsKeptOnDeathInterface() {
		RSInterface rsinterface = addTabInterface(17100);
		RSInterface scroll = addTabInterface(17149);
		scroll.width = 300; scroll.height = 183; scroll.scrollMax = 220;
		addSpriteLoader(17101, 697);
		addCloseButton(16999, 17000, 17001);
		addText(17103, "Items Kept on Death", tda, 2, 0xff981f, false, false);
		addText(17104, "Items you will keep on death:", tda, 1, 0xff981f, false, false);
		addText(17105, "Items you will lose on death:", tda, 1, 0xff981f, false, false);
		addText(17106, "Info", tda, 1, 0xff981f, false, false);
		addText(17107, "", tda, 1, 16711680, false, false);
		String[] options = {null};
		/*
		 * Items on interface
		 */

		//Top Row
		for(int top = 17108; top <= 17111; top++) {
			addItemOnInterface(top, top, options);
		}
		//1st row
		for(int top = 17112; top <= 17119; top++) {
			addItemOnInterface(top, top, options);
		}
		//2nd row
		for(int top = 17120; top <= 17127; top++) {
			addItemOnInterface(top, top, options);
		}
		//3rd row
		for(int top = 17128; top <= 17135; top++) {
			addItemOnInterface(top, top, options);
		}
		//4th row
		for (int top = 17135; top <= 17142; top++) {
			addItemOnInterface(top, top, options);
		}
		//5th row
		for (int top = 17150; top <= 17156; top++) {
			addItemOnInterface(top, top, options);
		}

		//6th row (4 items)
		for(int top = 17157; top <= 17160; top++) {
			addItemOnInterface(top, top, options);
		}

		for(int info = 17143; info <= 17148; info ++) {
			addText(info, "" + info, tda, 1, 16776960, false, false);
		}

		setChildren(19, rsinterface);
		setBounds(17101, 7,8, 0, rsinterface);
		setBounds(16999, 478, 14, 1, rsinterface);
		setBounds(17103, 185, 18, 2, rsinterface);
		setBounds(17104, 22, 50, 3, rsinterface);
		setBounds(17105, 22, 110, 4, rsinterface);
		setBounds(17106, 347, 50, 5, rsinterface);
		setBounds(17107, 22, 84, 6, rsinterface);
		setBounds(17149, 23, 132, 7, rsinterface);
		int count = 0;
		for(int info = 17143; info <= 17148; info ++) {
			setBounds(info, 350, 74 + (count * 22), 8 + count, rsinterface);
			count ++;
		}


		//Positions for  item on interface (items kept on death)
		count = 0;
		for(int topPos = 26; topPos <= 158; topPos += 44) {
			setBounds(17108 + count, topPos, 72, 14+count, rsinterface);
			count++;
		}
		setChildren(39, scroll);
		count = 0;
		//Positions for item on interface (1st row)
		for(int topPos = 0; topPos <= 264; topPos += 44) {
			setBounds(17112 + count, topPos, 0, 0+count, scroll);
			count++;
		}
		count = 0;
		//Positions for item on interface (2nd row)
		for(int topPos = 0; topPos <= 264; topPos += 44) {
			setBounds(17120 + count, topPos, 35, 7 + count, scroll);
			count++;
		}
		count = 0;
		//Positions for item on interface (3rd row)
		for(int topPos = 0; topPos <= 264; topPos += 44) {
			setBounds(17128 + count, topPos, 70, 14 + count, scroll);
			count++;
		}
		count = 0;
		//Positions for item on interface (4th row)
		for(int topPos = 0; topPos <= 264; topPos += 44) {
			setBounds(17135 + count, topPos, 105, 21 + count, scroll);
			count++;
		}
		count = 0;
		// Positions for item on interface (5th row)
		for (int topPos = 0; topPos <= 264; topPos += 44) {
			setBounds(17150 + count, topPos, 140, 28 + count, scroll);
			count++;
		}
		count = 0;
		// Positions for item on interface (6th row)
		for (int topPos = 0; topPos <= 132; topPos += 44) {
			setBounds(17157 + count, topPos, 175, 35 + count, scroll);
			count++;
		}
		setBounds(17000, 478, 14, 18, rsinterface);
	}

	private void clanChatTabInterface() {
		RSInterface tab = addInterface(29328);
		addHoverButtonWSpriteLoader(29329, 698, 18, 18, "Join Clan", -1, 29330, 1);
		addHoveredImageWSpriteLoader(29330, 699, 18, 18, 29331);
		addHoverButtonWSpriteLoader(29332, 700, 18, 18, "Leave Clan", -1, 29333, 1);
		addHoveredImageWSpriteLoader(29333, 701, 18, 18, 29334);
		addHoverButtonWSpriteLoader(29335, 702, 18, 18, "Settings", -1, 29336, 1);
		addHoveredImageWSpriteLoader(29336, 703, 18, 18, 29337);
		addButtonWSpriteLoader(29455, 704, "Toggle Lootshare");
		addButtonWSpriteLoader(29456, 203, "Teleport to Guild home.");
		addText(29338, "Clan Chat", 0xff9b00, true, true, tda[1]);
		addText(29340, "Talking in: @whi@Not in chat", 0xff9b00, false, true, tda[0]);
		addText(29454, "Lootshare: @gre@On", 0xff9b00, false, true, 52, tda, 0);
		addText(29450, "Owner: None", 0xff9b00, false, true, tda[0]);
		addSpriteLoader(29339, 705);
		tab.totalChildren(16);
		tab.child(0, 16126, 0, 236);
		tab.child(1, 16126, 0, 62);
		tab.child(2, 29339, 0, 62);
		tab.child(3, 29343, 0, 62);
		tab.child(4, 29329, 8, 239);
		tab.child(5, 29330, 8, 239);
		tab.child(6, 29332, 25, 239);
		tab.child(7, 29333, 25, 239);
		tab.child(8, 29335, 42, 239);
		tab.child(9, 29336, 42, 239);
		tab.child(10, 29338, 95, 1);
		tab.child(11, 29340, 10, 15);
		tab.child(12, 29450, 10, 41);
		tab.child(13, 29454, 10, 28);
		tab.child(14, 29455, 150, 23);
		tab.child(15, 29456, 120, 30);
		rebuildClanChatList(false, "", false);
	}

	public void rebuildClanChatList(boolean clickable, String ignore, boolean owner) {
		/* Text area */
		for (int i = 29344; i <= 29444; i++) {
			if(clickable && RSInterface.interfaceCache[i].message.length() > 0) {
				addClanChatListTextWithOptions(i, RSInterface.interfaceCache[i].message, ignore, owner, tda, 0, 0xffffff, 200, 11);
			} else {
				addText(i, RSInterface.interfaceCache[i] == null ? ""+i+"" : RSInterface.interfaceCache[i].message, tda, 0, 0xffffff, false, true);
			}
		}
		RSInterface list = addInterface(29343);
		list.totalChildren(100);
		for (int id = 29344, i = 0; id <= 29443 && i <= 99; id++, i++) {
			list.child(id - 29344, id, 5, -1);
			for (int id2 = 29344, i2 = 1; id2 <= 29443 && i2 <= 99; id2++, i2++) {
				list.childY[0] = 2;
				list.childY[i2] = list.childY[i2 - 1] + 14;
			}
		}
		list.height = 174;
		list.width = 174;
		list.scrollMax = 1405;
	}

	private void shopInterface() {
		RSInterface rsinterface = addTabInterface(3824);
		setChildren(6, rsinterface);
		addSpriteLoader(3825, 736);
		addCloseButton(3902, 19689, 19690);
		setBounds(3825, 6, 8, 0, rsinterface);
		setBounds(3902, 478, 9, 1, rsinterface);
		setBounds(3902, 478, 9, 2, rsinterface);
		setBounds(3900, 26, 44, 3, rsinterface);
		setBounds(3901, 240, 11, 4, rsinterface);
		setBounds(19689, 478, 9, 5, rsinterface);
		rsinterface = interfaceCache[3900];
		rsinterface.inv = new int[50];
		rsinterface.invStackSizes = new int[50];
		rsinterface.drawInfinity = true;
		rsinterface.invSpritePadX = 15;
		rsinterface.width = 10;
		rsinterface.height = 4;
		rsinterface.invSpritePadY = 25;

	}

	private void redoSpellBooks() {
		RSInterface newInterface = addTabInterface(11000);
		RSInterface spellButtons = interfaceCache[1151];
		newInterface.totalChildren(15);
		/**
		 * Modern spellbook
		 */
		spellButtons.scrollMax = 0;
		spellButtons.height = 260;
		spellButtons.width = 190;
		newInterface.child(0, 1151, 5, 34);
		interfaceCache[1164] = interfaceCache[1165];
		interfaceCache[1165] = interfaceCache[1166];
		interfaceCache[1166] = interfaceCache[1168];
		interfaceCache[1167] = interfaceCache[1169];
		interfaceCache[1168] = interfaceCache[1171];
		interfaceCache[1169] = interfaceCache[1172];
		interfaceCache[1170] = interfaceCache[1173];
		interfaceCache[1171] = interfaceCache[1175];
		interfaceCache[1172] = interfaceCache[1176];
		interfaceCache[1173] = interfaceCache[1539];
		interfaceCache[1174] = interfaceCache[1582];
		interfaceCache[1175] = interfaceCache[12037];
		interfaceCache[1176] = interfaceCache[1177];
		interfaceCache[1539] = interfaceCache[1178];
		interfaceCache[1582] = interfaceCache[1179];
		interfaceCache[12037] = interfaceCache[1180];
		interfaceCache[1540] = interfaceCache[1181];
		interfaceCache[1177] = interfaceCache[1182];
		interfaceCache[1178] = interfaceCache[15877];
		interfaceCache[1179] = interfaceCache[1190];
		interfaceCache[1180] = interfaceCache[1191];
		interfaceCache[1541] = interfaceCache[1192];
		interfaceCache[1181] = interfaceCache[1183];
		interfaceCache[1182] = interfaceCache[1184];
		interfaceCache[15877] = interfaceCache[1185];
		interfaceCache[1190] = interfaceCache[1186];
		interfaceCache[1191] = interfaceCache[1542];
		interfaceCache[1192] = interfaceCache[1187];
		interfaceCache[7455] = interfaceCache[1188];
		interfaceCache[1183] = interfaceCache[1543];
		interfaceCache[1184] = interfaceCache[12425];
		interfaceCache[18470] = interfaceCache[1189];
		interfaceCache[1185] = interfaceCache[1592];
		interfaceCache[1186] = interfaceCache[1562];
		interfaceCache[1542] = interfaceCache[1193];
		interfaceCache[1187] = interfaceCache[12435];
		interfaceCache[1188] = interfaceCache[12445];
		interfaceCache[1543] = interfaceCache[6003];
		interfaceCache[12425] = interfaceCache[12455];
		removeSomething(1189); removeSomething(1592); removeSomething(1562); removeSomething(1193);
		removeSomething(12435); removeSomething(12445); removeSomething(6003); removeSomething(12455);
		addHoverButtonWSpriteLoader(11001, 706, 18, 18, "Select", -1, 11002, 1);
		addTooltip(11002, "Home Teleport\nTeleport to set home location.");
		newInterface.child(1, 11001, 8, 8);
		newInterface.child(2, 11002, 10, 39);
		addHoverButtonWSpriteLoader(11004, 707, 18, 18, "Select", -1, 11005, 1);
		addTooltip(11005, "Skills Teleport\nOpen options of different \nskilling teleports.");
		newInterface.child(3, 11004, 34, 8);
		newInterface.child(4, 11005, 30, 39);
		addHoverButtonWSpriteLoader(11008, 708, 18, 18, "Select", -1, 11009, 1);
		addTooltip(11009, "Training Teleport\nOpen options of different \ntraining teleports.");
		newInterface.child(5, 11008, 60, 8);
		newInterface.child(6, 11009, 40, 39);
		addHoverButtonWSpriteLoader(11011, 709, 18, 18, "Select", -1, 11012, 1);
		addTooltip(11012, "Dungeon Teleport\nOpen options of different\ndungeon teleports.");
		newInterface.child(7, 11011, 86, 8);
		newInterface.child(8, 11012, 23, 39);
		addHoverButtonWSpriteLoader(11014, 710, 18, 18, "Select", -1, 11015, 1);
		addTooltip(11015, "Boss Teleport\nOpen options of different\nboss teleports.");
		newInterface.child(9, 11014, 112, 8);
		newInterface.child(10, 11015, 23, 39);
		addHoverButtonWSpriteLoader(11017, 711, 18, 18, "Select", -1, 11018, 1);
		addTooltip(11018, "Minigame Teleport\nOpen options of different\nminigame teleports.");
		newInterface.child(11, 11017, 138, 8);
		newInterface.child(12, 11018, 34, 39);
		addHoverButtonWSpriteLoader(11020, 712, 18, 18, "Select", -1, 11021, 1);
		addTooltip(11021, "Wilderness Teleport\nOpen options of different\nwilderness teleports.");
		newInterface.child(13, 11020, 164, 8);
		newInterface.child(14, 11021, 40, 39);
		/**
		 * Ancient spellbook
		 */
		newInterface = addTabInterface(11500);
		spellButtons = interfaceCache[12855];
		newInterface.totalChildren(15);
		spellButtons.scrollMax = 0;
		spellButtons.height = 260;
		spellButtons.width = 190;
		newInterface.child(0, 12855, 0, 40);
		interfaceCache[13035] = interfaceCache[12901];
		interfaceCache[12901] = interfaceCache[12861];
		interfaceCache[12861] = interfaceCache[12963];
		interfaceCache[13045] = interfaceCache[13011];
		interfaceCache[12963] = interfaceCache[12919];
		interfaceCache[13011] = interfaceCache[12881];
		interfaceCache[13053] = interfaceCache[12951];
		interfaceCache[12919] = interfaceCache[12999];
		interfaceCache[12881] = interfaceCache[12911];
		interfaceCache[13061] = interfaceCache[12871];
		interfaceCache[12951] = interfaceCache[12975];
		interfaceCache[12999] = interfaceCache[13023];
		interfaceCache[13069] = interfaceCache[12929];
		interfaceCache[12911] = interfaceCache[12891];
		removeSomething(interfaceCache[12871]);
		removeSomething(interfaceCache[13079]);
		removeSomething(interfaceCache[12975]);
		removeSomething(interfaceCache[13023]);
		removeSomething(interfaceCache[13087]);
		removeSomething(interfaceCache[12929]);
		removeSomething(interfaceCache[12891]);
		removeSomething(interfaceCache[13095]);
		/**
		 * Add teleports
		 */
		addHoverButtonWSpriteLoader(11001, 706, 18, 18, "Select", -1, 11002, 1);
		addTooltip(11002, "Home Teleport\nTeleport to set home location.");
		newInterface.child(1, 11001, 8, 16);
		newInterface.child(2, 11002, 10, 39);
		addHoverButtonWSpriteLoader(11004, 707, 18, 18, "Select", -1, 11005, 1);
		addTooltip(11005, "Skills Teleport\nOpen options of different \nskilling teleports.");
		newInterface.child(3, 11004, 34, 16);
		newInterface.child(4, 11005, 30, 39);
		addHoverButtonWSpriteLoader(11008, 708, 18, 18, "Select", -1, 11009, 1);
		addTooltip(11009, "Training Teleport\nOpen options of different \ntraining teleports.");
		newInterface.child(5, 11008, 60, 16);
		newInterface.child(6, 11009, 40, 39);
		addHoverButtonWSpriteLoader(11011, 709, 18, 18, "Select", -1, 11012, 1);
		addTooltip(11012, "Dungeon Teleport\nOpen options of different\ndungeon teleports.");
		newInterface.child(7, 11011, 86, 16);
		newInterface.child(8, 11012, 23, 39);
		addHoverButtonWSpriteLoader(11014, 710, 18, 18, "Select", -1, 11015, 1);
		addTooltip(11015, "Boss Teleport\nOpen options of different\nboss teleports.");
		newInterface.child(9, 11014, 112, 16);
		newInterface.child(10, 11015, 23, 39);
		addHoverButtonWSpriteLoader(11017, 711, 18, 18, "Select", -1, 11018, 1);
		addTooltip(11018, "Minigame Teleport\nOpen options of different\nminigame teleports.");
		newInterface.child(11, 11017, 138, 16);
		newInterface.child(12, 11018, 34, 39);
		addHoverButtonWSpriteLoader(11020, 712, 18, 18, "Select", -1, 11021, 1);
		addTooltip(11021, "Wilderness Teleport\nOpen options of different\nWilderness teleports.");
		newInterface.child(13, 11020, 164, 16);
		newInterface.child(14, 11021, 40, 39);

		/**
		 * Lunar
		 */
		newInterface = addInterface(11800);
		spellButtons = interfaceCache[29999];
		newInterface.totalChildren(15);
		/**
		 * Change spellbook
		 */
		spellButtons.scrollMax = 0;
		spellButtons.height = 260;
		spellButtons.width = 190;
		newInterface.child(0, 29999, 0, 45);
		/**
		 * Add teleports
		 */
		addHoverButtonWSpriteLoader(11001, 706, 18, 18, "Select", -1, 11002, 1);
		addTooltip(11002, "Home Teleport\nTeleport to set home location.");
		newInterface.child(1, 11001, 8, 16);
		newInterface.child(2, 11002, 10, 39);
		addHoverButtonWSpriteLoader(11004, 707, 18, 18, "Select", -1, 11005, 1);
		addTooltip(11005, "Skills Teleport\nOpen options of different \nskilling teleports.");
		newInterface.child(3, 11004, 34, 16);
		newInterface.child(4, 11005, 30, 39);
		addHoverButtonWSpriteLoader(11008, 708, 18, 18, "Select", -1, 11009, 1);
		addTooltip(11009, "Training Teleport\nOpen options of different \ntraining teleports.");
		newInterface.child(5, 11008, 60, 16);
		newInterface.child(6, 11009, 40, 39);
		addHoverButtonWSpriteLoader(11011, 709, 18, 18, "Select", -1, 11012, 1);
		addTooltip(11012, "Dungeon Teleport\nOpen options of different\ndungeon teleports.");
		newInterface.child(7, 11011, 86, 16);
		newInterface.child(8, 11012, 23, 39);
		addHoverButtonWSpriteLoader(11014, 710, 18, 18, "Select", -1, 11015, 1);
		addTooltip(11015, "Boss Teleport\nOpen options of different\nboss teleports.");
		newInterface.child(9, 11014, 112, 16);
		newInterface.child(10, 11015, 23, 39);
		addHoverButtonWSpriteLoader(11017, 711, 18, 18, "Select", -1, 11018, 1);
		addTooltip(11018, "Minigame Teleport\nOpen options of different\nminigame teleports.");
		newInterface.child(11, 11017, 138, 16);
		newInterface.child(12, 11018, 34, 39);
		addHoverButtonWSpriteLoader(11020, 712, 18, 18, "Select", -1, 11021, 1);
		addTooltip(11021, "Wilderness Teleport\nOpen options of different\nWilderness teleports.");
		newInterface.child(13, 11020, 164, 16);
		newInterface.child(14, 11021, 40, 39);
	}

	private void bankInterface() {
		interfaceCache[5383].message = "     The Bank Of "+Configuration.CLIENT_NAME+"";
		RSInterface rsinterface = addTabInterface(5292);
		setChildren(38, rsinterface);
		setBounds(5383, 170, 15, 1, rsinterface);
		interfaceCache[5385].height = 206;
		interfaceCache[5385].width = 474;
		interfaceCache[5382].width = 10;
		interfaceCache[5382].invSpritePadX = 12;
		interfaceCache[5382].height = 35;
		setBounds(5385, 0, 74, 2, rsinterface);
		addSpriteLoader(5293, 713);
		setBounds(5293, 13, 13, 0, rsinterface);

		addHoverButtonWSpriteLoader(5384, 714, 17, 17, "Close Window", 0, 5380, 1);
		addHoveredImageWSpriteLoader(5380, 715, 17, 17, 5379);

		setBounds(5384, 476, 16, 3, rsinterface);
		setBounds(5380, 476, 16, 4, rsinterface);
		//addButton(5294, 3, "Interfaces/BANK/BANK", "Click here to handle Bank PIN");
		addHoverButtonWSpriteLoader(5294, 716, 114, 25, "Manage Bank PIN", -1, 22045, 1);
		addHoveredImageWSpriteLoader(22045, 717, 114, 25, 22046);

		setBounds(5294, 110, 285, 5, rsinterface);
		setBounds(22045, 110, 285, 37, rsinterface);
		//(27651, "CUSTOM", "Equipment", 1, 40, 40, "Show Equipment Screen", 0, 27652, 1);
		//addHoverButton(22000, "Interfaces/BANK/BANK", 5, 35, 25, "Deposit Money-Pouch", 0, 22001, 4);
		//addHoveredButton(22001, "Interfaces/BANK/BANK", 8 ,35, 25, 22002);
		addHoverButtonWSpriteLoader(27009, 718, 35, 25, "Deposit Money-Pouch", -1, 27010, 1);
		addHoveredImageWSpriteLoader(27010, 719, 35, 25, 27011);

		//addBankHover(22000, 4, 22001, 5, 8, "Interfaces/BANK/BANK", 35, 25, 304, 1, "Deposit Money-Pouch", 22002, 7, 6, "Interfaces/BANK/BANK", 22003, "Switch to insert items \nmode", "Switch to swap items \nmode.", 12, 20);
		setBounds(27009, 25, 285, 6, rsinterface);
		setBounds(27010, 25, 285, 7, rsinterface);
		addBankHover(22004, 4, 22005, 13, 15, "Interfaces/BANK/BANK", 35, 25, 117, 1, "Search", 22006, 14, 16, "Interfaces/BANK/BANK", 22007, "Click here to search your \nbank", "Click here to search your \nbank", 12, 20, 720, 721);

		setBounds(22004, 65, 285, 8, rsinterface);
		setBounds(22005, 50, 225, 9, rsinterface);
		addBankHover(22008, 4, 22009, 9, 11, "Interfaces/BANK/BANK", 35, 25, 115, 1, "Withdraw as Note", 22010, 10, 12, "Interfaces/BANK/BANK", 22011, "Switch to note withdrawal \nmode", "Switch to item withdrawal \nmode", 12, 20, 722, 723);
		setBounds(22008, 285, 285, 10, rsinterface);
		setBounds(22009, 225, 225, 11, rsinterface);
		//addBankHover1(22012, 5, 22013, 17, "Interfaces/BANK/BANK", 35, 25, "Deposit carried tems", 22014, 18, "Interfaces/BANK/BANK", 22015, "Empty your backpack into\nyour bank", 0, 20);

		addHoverButtonWSpriteLoader(22012, 724, 35, 25, "Deposit carried items", -1, 22013, 1);
		addHoveredImageWSpriteLoader(22013, 725, 35, 25, 22014);

		setBounds(22012, 375, 285, 12, rsinterface);
		setBounds(22013, 375, 285, 13, rsinterface);
		//addBankHover1(22016, 5, 22017, 19, "Interfaces/BANK/BANK", 35, 25, "Deposit worn items", 22018, 20, "Interfaces/BANK/BANK", 22019, "Empty the items your are\nwearing into your bank", 0, 20);

		addHoverButtonWSpriteLoader(27005, 726, 35, 25, "Deposit worn items", -1, 27006, 1);
		addHoveredImageWSpriteLoader(27006, 727, 35, 25, 27007);

		setBounds(27005, 415, 285, 14, rsinterface);
		setBounds(27006, 415, 285, 15, rsinterface);
		//addBankHover1(22020, 5, 22021, 21, "Interfaces/BANK/BANK", 35, 25, "Deposit Beast of Burden's inventory.", 22022, 22, "Interfaces/BANK/BANK", 22023, "Empty your BoB's inventory\ninto your bank", 0, 20);

		addHoverButtonWSpriteLoader(27023, 728, 35, 25, "Deposit Beast of Burden's inventory", -1, 27024, 1);
		addHoveredImageWSpriteLoader(27024, 729, 35, 25, 27025);

		setBounds(27023, 455, 285, 16, rsinterface);
		setBounds(27024, 455, 285, 17, rsinterface);

		addButtonWSpriteLoader(27014, 730, "Click here to view the full contents of your bank");
		setBounds(27014, 22, 36, 18, rsinterface);
		addButtonWSpriteLoader(27015, 731, "Drag an item here to create a new tab");
		setBounds(27015, 70, 36, 19, rsinterface);
		addButtonWSpriteLoader(27016, 731, "Drag an item here to create a new tab");
		setBounds(27016, 118, 36, 20, rsinterface);
		addButtonWSpriteLoader(27017, 731, "Drag an item here to create a new tab");
		setBounds(27017, 166, 36, 21, rsinterface);
		addButtonWSpriteLoader(27018, 731, "Drag an item here to create a new tab");
		setBounds(27018, 214, 36, 22, rsinterface);
		addButtonWSpriteLoader(27019, 731, "Drag an item here to create a new tab");
		setBounds(27019, 262, 36, 23, rsinterface);
		addButtonWSpriteLoader(27020, 731, "Drag an item here to create a new tab");
		setBounds(27020, 310, 36, 24, rsinterface);
		addButtonWSpriteLoader(27021, 731, "Drag an item here to create a new tab");
		setBounds(27021, 358, 36, 25, rsinterface);
		addButtonWSpriteLoader(27022, 731, "Drag an item here to create a new tab");

		setBounds(27022, 406, 36, 26, rsinterface);
		addText(22033, "134", tda, 0, 0xb4965a, true, false);
		setBounds(22033, 473, 42, 27, rsinterface);
		addText(22034, "496", tda, 0, 0xb4965a, true, false);
		setBounds(22034, 473, 57, 28, rsinterface);
		addBankItem(22035, Boolean.valueOf(false));
		setBounds(22035, 77, 39, 29, rsinterface);
		addBankItem(22036, Boolean.valueOf(false));
		setBounds(22036, 125, 39, 30, rsinterface);
		addBankItem(22037, Boolean.valueOf(false));
		setBounds(22037, 173, 39, 31, rsinterface);
		addBankItem(22038, Boolean.valueOf(false));
		setBounds(22038, 221, 39, 32, rsinterface);
		addBankItem(22039, Boolean.valueOf(false));
		setBounds(22039, 269, 39, 33, rsinterface);
		addBankItem(22040, Boolean.valueOf(false));
		setBounds(22040, 317, 39, 34, rsinterface);
		addBankItem(22041, Boolean.valueOf(false));
		setBounds(22041, 365, 39, 35, rsinterface);
		addBankItem(22042, Boolean.valueOf(false));
		setBounds(22042, 413, 39, 36, rsinterface);
		addBankHover(21000, 4, 21001, 431, 432, 35, 25, 304, 1, "Swap Withdraw Mode", 21002, 174, 173, 21003, "Switch to insert items \nmode", "Switch to swap items \nmode.", 12, 20);
		setBounds(21000, 240, 285, 37, rsinterface);
		addText(27000, "0", 0xff981f, false, true, 52, tda, 1);
		addText(27001, "0", 0xff981f, false, true, 52, tda, 1);
		addText(27002, "0", 0xff981f, false, true, 52, tda, 1);
	}

	private void playerPanelv3() { //Keith interface
		//final int PAGE_AMOUNT = 12;
		final int[] PLAYERS_PER_PAGE = {14, 12, 8, 19, 7, 7};//, 6, 6, 6, 6, 6, 6};

		RSInterface tab = addInterface(44000);
		addInterface(44006);
		addSprite(44001, 1198);
		addHoverButton(44002, 1199, 16, 16,"Close", 0, 44003, 1);
		addHoveredButton(44003, 1200, 16, 16, 44004);
		addText(44005, "", tda, 2, 0xFFA500, true, true);
		int x = 10, y = 10;
		tab.totalChildren(8);
		tab.child(0, 44001, x, y);
		tab.child(1, 44002, 463+x, 4+y);
		tab.child(2, 44003, 463+x, 4+y);
		tab.child(3, 44005, 243+x, 5+y);
		tab.child(4, 44006, 15+x, 29+y);
		tab.child(5, 44085, 152+x, 220+y);
		tab.child(6, 44100, 152+x, 29+y);
		tab.child(7, 44007, 15+x, 29+y);

		RSInterface pageList = addInterface(44007);
		pageList.totalChildren(PLAYERS_PER_PAGE.length * 3);
		for (int i = 0; i < PLAYERS_PER_PAGE.length; i++) {
			addHoverButton(44008 + i, 1201, 123, 25, "Filter", 0, 44028 + i, 1);
			addHoveredButton(44028 + i, 1202, 123, 25, 44084);
			addText(44048 + i, "", tda, 3, 0xff7000, false, true);
			pageList.child(i, 44008 + i, 0, i * 26);
			pageList.child(i + (PLAYERS_PER_PAGE.length), 44028 + i, 0, i * 26);
			pageList.child(i + (PLAYERS_PER_PAGE.length * 2), 44048 + i, 4, 7 + i * 26);
		}
		pageList.width = 107;
		pageList.height = 260;
		pageList.scrollMax = (PLAYERS_PER_PAGE.length * 26) <= 260 ? 270 : (PLAYERS_PER_PAGE.length * 26);

		for (int i = 0; i < PLAYERS_PER_PAGE.length; i++) {
			int b = (i * 200);
			RSInterface page = addInterface(44100 + b);

			page.totalChildren(3 * PLAYERS_PER_PAGE[i]);
			page.child(0, 44101 + b, 158, 17);
			int yy = 0;
			for (int j = 0; j < PLAYERS_PER_PAGE[i]; j++) {
				addHoverButton(44102 + j + b, 1205, 316, 25, "Select", 0, 44152 + j + b, 1);
				addHoveredButton(44152 + j + b, 1206, 316, 25, 44099);
				addText(44202 + j + b, "", tda, 1, 0xff9040, false, true);
				page.child(j, 44102 + j + b, 0, yy);
				page.child(j + (PLAYERS_PER_PAGE[i]), 44152 + j + b, 0, yy);
				page.child(j + (PLAYERS_PER_PAGE[i] * 2), 44202 + j + b, 5, 5 + yy);
				yy += 26;
			}
			page.width = 300;
			page.height = 180;
			page.scrollMax = yy > 200 ? yy : 200;
		}

		RSInterface info = addInterface(44085);
		addText(44086, "", tda, 2, 0xff7000, true, true);
		addText(44087, "", tda, 0, 0xff9040, true, true);
		addText(44088, "", tda, 0, 0xff9040, true, true);
		addClickableText(44090, "", "Select", tda, 0, 0xffff00, false, true, 80);
		addClickableText(44091, "", "Select", tda, 0, 0xffff00, false, true, 80);
		addClickableText(44092, "", "Select", tda, 0, 0xffff00, false, true, 80);
		addClickableText(44098, "", "Select", tda, 0, 0xffff00, false, true, 80);
		addText(44089, "", tda, 2, 0xff7000, true, true);
		addHoverButton(44093, 1203, 127, 24, "", 0, 44094, 1);
		addHoveredButton(44094, 1204, 127, 24, 44095);
		addText(44096, "", tda, 1, 65280, true, true);
		info.totalChildren(11);
		info.child(0, 44086, 112, 3);
		info.child(1, 44087, 112, 19);
		info.child(2, 44088, 112, 31);
		info.child(3, 44090, 230, 19);
		info.child(4, 44091, 230, 31);
		info.child(5, 44092, 230, 43);
		info.child(6, 44098, 230, 55);
		info.child(7, 44089, 271, 3);
		info.child(8, 44093, 50, 45);
		info.child(9, 44094, 50, 45);
		info.child(10, 44096, 113, 49);
	}

	private void summoningBoBInterface() {
		RSInterface rsi = addTabInterface(2700);
		addSpriteLoader(2701, 737);
		addButtonWSpriteLoader(2735, 738, "Withdraw all items");
		addCloseButton(2734, 2736, 2737);
		rsi.totalChildren(36);
		/**
		 * Bob storage, starting with first row.
		 */
		for (int i = 2702; i < 2710; i++)
			addBobStorage(i);
		/**
		 * Second row
		 */
		for (int i = 2710; i < 2716; i++)
			addBobStorage(i);
		/**
		 * Third row
		 */
		for (int i = 2716; i < 2722; i++)
			addBobStorage(i);

		/**
		 * Fourth row
		 */
		for (int i = 2722; i < 2728; i++)
			addBobStorage(i);

		/**
		 * Fifth row
		 */
		for (int i = 2728; i < 2734; i++)
			addBobStorage(i);

		rsi.child(0, 2701, 90, 14);
		rsi.child(1, 2735, 424, 290);
		rsi.child(2, 2703, 431, 23);
		rsi.child(3, 2704, 427, 285);
		/**
		 * Bob storage first row
		 */
		rsi.child(4, 2702, 105, 56);
		rsi.child(5, 2705, 160, 56);
		rsi.child(6, 2706, 215, 56);
		rsi.child(7, 2707, 270, 56);
		rsi.child(8, 2708, 320, 56);
		rsi.child(9, 2709, 375, 56);

		/**
		 * Bob storage second row
		 */
		rsi.child(10, 2710, 105, 110);
		rsi.child(11, 2711, 160, 110);
		rsi.child(12, 2712, 215, 110);
		rsi.child(13, 2713, 270, 110);
		rsi.child(14, 2714, 320, 110);
		rsi.child(15, 2715, 375, 110);

		/**
		 * Bob storage third row
		 */
		rsi.child(16, 2716, 105, 163);
		rsi.child(17, 2717, 160, 163);
		rsi.child(18, 2718, 215, 163);
		rsi.child(19, 2719, 270, 163);
		rsi.child(20, 2720, 320, 163);
		rsi.child(21, 2721, 375, 163);

		/**
		 * Bob storage fourth row
		 */
		rsi.child(22, 2722, 105, 216);
		rsi.child(23, 2723, 160, 216);
		rsi.child(24, 2724, 215, 216);
		rsi.child(25, 2725, 270, 216);
		rsi.child(26, 2726, 320, 216);
		rsi.child(27, 2727, 375, 216);

		/**
		 * Bob storage fifth row
		 */
		rsi.child(28, 2728, 105, 269);
		rsi.child(29, 2729, 160, 269);
		rsi.child(30, 2730, 215, 269);
		rsi.child(31, 2731, 270, 269);
		rsi.child(32, 2732, 320, 269);
		rsi.child(33, 2733, 375, 269);

		//Close
		rsi.child(34, 2734, 429, 22);
		rsi.child(35, 2736, 429, 22);
	}
	/*private static void teleportWidget(TextDrawingArea[] tda) {
        RSInterface widget = addInterface(29322);

        addSprite(49113, 1197);

        addHoverButtonWSpriteLoader(49114, 1198, 16, 16, "Close", -1, 49115, 1);
        addHoveredImageWSpriteLoader(49115, 1199, 16, 16, 49116);

        addHoverButtonWSpriteLoader(49117, 1206, 90, 25, "Teleport", -1, 49118, 1);
        addHoveredImageWSpriteLoader(49118, 1207, 90, 25, 49119);

        addSpriteLoader(49120, 1200);
        addText(49121, "1,000,000 Coins", tda, 3, 0xFF981F, true, true);

        addSpriteLoader(49122, 1201);
        addText(49123, "Dangerous", tda, 3, 0xFF981F, true, true);

        addSpriteLoader(49124, 1202);
        addText(49125, "Inside Wilderness", tda, 3, 0xFF981F, true, true);

        addText(49126, "King Black Dragon", tda, 2, 0xFF981F, true, true);

        addText(49127, "Teleport", tda, 3, 0xFF981F, true, true);

        //addNpcToWidget(43006);
        widget.totalChildren(14);
        widget.child(0, 49113, 56, 5);
        widget.child(1, 49114, 443, 9);
        widget.child(2, 49115, 443, 9);
        widget.child(3, 49117, 125, 280);
        widget.child(4, 49118, 125, 280);
        widget.child(5, 49120, 80, 65);
        widget.child(6, 49121, 170, 65);
        widget.child(7, 49122, 85, 90);
        widget.child(8, 49123, 152, 90);
        widget.child(9, 49124, 83, 115);
        widget.child(10, 49125, 175, 115);
        widget.child(11, 49126, 140, 35);
        widget.child(12, 49127, 170, 283);
        widget.child(13, 49128, 185, 77);
        
        
        RSInterface scrollTab = addTabInterface(49128);
        scrollTab.width = 244;
        scrollTab.height = 230;
        scrollTab.scrollMax = 550;
        
        scrollTab.totalChildren(50);
        
        for (int i = 0; i < 50; i += 2) {
            addButtonWSpriteLoader(49129 + i, 1204, "Select", 140, 22);
            scrollTab.child(i, 49129 + i, 105, i / 2 * 22);
            addText(49129 + i + 1, "King Black Dragon", tda, 1, 0xFF981F, true, true);
            scrollTab.child(i + 1, 49129 + i + 1, 175, 3 + (i / 2 * 22));
        }

    }*/
	private void summoningTabInterface() {
		RSInterface rsi = addTabInterface(54017);
		addText(54019, "Summoning Familiar", tda, 2, 16750623, true, true);
		addSpriteLoader(54020, 739);

		addFamiliarHead(54021, 75, 50, 875);
	//	addPet(54021);
		addSpriteLoader(54027, 740);
		addText(54028, "", tda, 2, 0xFF981F, true, false);

		addHoverButtonWSpriteLoader(54029, 741, 38, 38, "Withdraw BoB", -1, 54030, 1);
		addHoveredImageWSpriteLoader(54030, 742, 38, 38, 54031);

		addHoverButtonWSpriteLoader(54032, 743, 38, 38, "Renew familiar", -1, 54033, 1);
		addHoveredImageWSpriteLoader(54033, 744, 38, 38, 54034);

		addHoverButtonWSpriteLoader(54035, 745, 38, 38, "Call familiar", -1, 54036, 1);
		addHoveredImageWSpriteLoader(54036, 746, 38, 38, 54037);

		addHoverButtonWSpriteLoader(54038, 747, 38, 38, "Dismiss familiar", -1, 54039, 1);
		addHoveredImageWSpriteLoader(54039, 748, 38, 38, 54040);

		addSpriteLoader(54041, 749);
		addSpriteLoader(54042, 750);

		addText(54043, "", tda, 0, 0xB9B855, false, true);
		addSpriteLoader(54044, 751);
		addText(54045, "", tda, 0, 0xB9B855, false, true);
		setChildren(18, rsi);
		setBounds(54020, 10, 32, 0, rsi);
		setBounds(54021, 63, 60, 1, rsi);
		setBounds(54027, 12, 144, 2, rsi);
		setBounds(54028, 93, 146, 3, rsi);
		setBounds(54029, 23, 168, 4, rsi);
		setBounds(54030, 23, 168, 5, rsi);
		setBounds(54032, 75, 168, 6, rsi);
		setBounds(54033, 75, 168, 7, rsi);
		setBounds(54035, 23, 213, 8, rsi);
		setBounds(54036, 23, 213, 9, rsi);
		setBounds(54038, 75, 213, 10, rsi);
		setBounds(54039, 75, 213, 11, rsi);
		setBounds(54041, 130, 168, 12, rsi);
		setBounds(54042, 153, 170, 13, rsi);
		setBounds(54043, 148, 198, 14, rsi);
		setBounds(54044, 149, 213, 15, rsi);
		setBounds(54045, 145, 241, 16, rsi);
		setBounds(54019, 91, 9, 17, rsi);
	}

	private void achievementsInterface() {
		RSInterface tab = addTabInterface(37000);
		RSInterface scroll = addTabInterface(36999);
		addText(37001, "Achievements", tda, 2, 16750623, false, true);
		addSpriteLoader(37002, 650);
		addSpriteLoader(37003, 651);
		addSpriteLoader(37004, 650);
		tab.totalChildren(5);
		tab.child(0, 37001, 5, 3);
		tab.child(1, 37002, 0, 22);
		tab.child(2, 37003, 0, 25);
		tab.child(3, 37004, 0, 249);
		tab.child(4, 36999, 0, 25); 

		scroll.totalChildren(112);
		scroll.width = 174; scroll.height = 224; scroll.scrollMax = 1790;


		/** TEXT **/
		int k = 0;
		int y = 25;
		for(int i = 37005; i < 37116; i++) {
			scroll.child(k, i, 6, y);
			y += 16;
			k++;
			if(i == 37035 || i == 37068 || i == 37102 || i >= 37112) {
				addText(i, "", tda, 1, 0xFF8900, false, true);
			} else {
				addClickableText(i, "", "Select", tda, 1, 0xFF8900, 130, 13);
			}
		}
		addText(30777, "Easy Tasks", tda, 2, 0xFF9900, false, true);
		scroll.child(k, 30777, 7, 6);
		addText(37036, "Medium Tasks", tda, 2, 0xFF9900, false, true);
		addText(37069, "Hard Tasks", tda, 2, 0xFF9900, false, true);
		addText(37103, "Elite Tasks", tda, 2, 0xFF9900, false, true);
	}

	private void loyaltyShop() {
		RSInterface rsi = addTabInterface(43000);
		rsi.totalChildren(74);
		addSpriteLoader(43001, 752);
		addText(43002, "Loyalty Titles", tda, 2, 16750623, false, true);
		addCloseButton(43003, 43121, 43122);
		rsi.child(0, 43001, 10, 20);
		rsi.child(1, 43002, 210, 22);
		rsi.child(2, 43003, 466, 19);

		/** BUY BUTTONS **/
		int id = 43004, child = 3;
		for(int i = 0; i < 12; i++) {
			int y = i == 1 ? 62 : i == 2 ? 83 : i == 3 ? 105 : i == 4 ? 127 : i == 5 ? 149 : i == 6 ? 171 : i == 7 ? 193 : i == 8 ? 215 : i == 9 ? 237 : i == 10 ? 259 : i == 11 ? 281 : -1;

			if(id != 43004) {
				addHoverButtonWSpriteLoader(id, 754, 32, 17, "Buy", -1, id+1, 1);
				addHoveredImageWSpriteLoader(id+1, 753, 32, 17, id+2);
			} else {
				removeSomething(id);
				removeSomething(id+1);
			}

			addText(id+3, "", tda, 0, 0xB9B855, false, true);

			rsi.child(child, id, 213, y);
			rsi.child(child+1, id+1, 213, y);
			rsi.child(child+2, id+3, 158, y+5);
			child += 3;
			id += 4;
		}
		for(int i = 1; i < 12; i++) {
			int y = i == 1 ? 62 : i == 2 ? 83 : i == 3 ? 105 : i == 4 ? 127 : i == 5 ? 149 : i == 6 ? 171 : i == 7 ? 193 : i == 8 ? 215 : i == 9 ? 237 : i == 10 ? 259 : i == 11 ? 281 : -1;


			addHoverButtonWSpriteLoader(id, 754, 32, 17, "Buy", -1, id+1, 1);
			addHoveredImageWSpriteLoader(id+1, 753, 32, 17, id+2);

			addText(id+3, "", tda, 0, 0xB9B855, false, true);

			rsi.child(child, id, 428, y);
			rsi.child(child+1, id+1, 428, y);
			rsi.child(child+2, id+3, 373, y+5);

			child += 3;
			id += 4;
		}
		addText(43120, "Your Loyalty Points: 0", tda, 0, 0xB9B855, false, true);
		rsi.child(72, 43120, 195, 43);
		rsi.child(73, 43121, 466, 19);
	}

	private void emoteTab() {
		RSInterface tab = addTabInterface(147);
		RSInterface scroll = addTabInterface(148);
		tab.totalChildren(1);
		tab.child(0, 148, 0, 1);
		addButton(168, 968, "Yes", 41, 47);
		addButton(169, 969, "No", 41, 47);
		addButton(164, 970, "Bow", 41, 47);
		addButton(165, 971, "Angry", 41, 47);
		addButton(162, 972, "Think", 41, 47);
		addButton(163, 973, "Wave", 41, 47);
		addButton(13370, 974, "Shrug", 41, 47);
		addButton(171, 975, "Cheer", 41, 47);
		addButton(167, 976, "Beckon", 41, 47);
		addButton(170, 977, "Laugh", 41, 47);
		addButton(13366, 978, "Jump for Joy", 41, 47);
		addButton(13368, 1000, "Yawn", 41, 47);
		addButton(166, 979, "Dance", 41, 47);
		addButton(13363, 980, "Jig", 41, 47);
		addButton(13364, 981, "Spin", 41, 47);
		addButton(13365, 982, "Headbang", 41, 47);
		addButton(161, 983, "Cry", 41, 47);
		addButton(11100, 984, "Blow kiss", 41, 47);
		addButton(13362, 985, "Panic", 41, 47);
		addButton(13367, 986, "Raspberry", 41, 47);
		addButton(172, 987, "Clap", 41, 47);
		addButton(13369, 988, "Salute", 41, 47);
		addButton(13383, 989, "Goblin Bow", 41, 47);
		addButton(13384, 990, "Goblin Salute", 41, 47);
		addButton(667, 991, "Glass Box", 41, 47);
		addButton(6503, 992, "Climb Rope", 41, 47);
		addButton(6506, 993, "Lean On Air", 41, 47);
		addButton(666, 994, "Glass Wall", 41, 47);
		addButton(18464, 995, "Zombie Walk", 41, 47);
		addButton(18465, 996, "Zombie Dance", 41, 47);
		addButton(15166, 997, "Scared", 41, 47);
		addButton(18686, 998, "Rabbit Hop", 41, 47);
		addButton(154, 999, "Skillcape Emote", 41, 47);
		scroll.totalChildren(33);
		scroll.child(0, 168, 10, 7);
		scroll.child(1, 169, 54, 7);
		scroll.child(2, 164, 98, 14);
		scroll.child(3, 165, 137, 7);
		scroll.child(4, 162, 9, 56);
		scroll.child(5, 163, 48, 56);
		scroll.child(6, 13370, 95, 56);
		scroll.child(7, 171, 137, 56);
		scroll.child(8, 167, 7, 105);
		scroll.child(9, 170, 51, 105);
		scroll.child(10, 13366, 95, 104);
		scroll.child(11, 13368, 139, 105);
		scroll.child(12, 166, 6, 154);
		scroll.child(13, 13363, 50, 154);
		scroll.child(14, 13364, 90, 154);
		scroll.child(15, 13365, 135, 154);
		scroll.child(16, 161, 8, 204);
		scroll.child(17, 11100, 51, 203);
		scroll.child(18, 13362, 99, 204);
		scroll.child(19, 13367, 137, 203);
		scroll.child(20, 172, 10, 253);
		scroll.child(21, 13369, 53, 253);
		scroll.child(22, 13383, 88, 258);
		scroll.child(23, 13384, 138, 252);
		scroll.child(24, 667, 2, 303);
		scroll.child(25, 6503, 49, 302);
		scroll.child(26, 6506, 93, 302);
		scroll.child(27, 666, 137, 302);
		scroll.child(28, 18464, 9, 352);
		scroll.child(29, 18465, 50, 352);
		scroll.child(30, 15166, 94, 354);
		scroll.child(31, 18686, 141, 353);
		scroll.child(32, 154, 5, 401);
		scroll.width = 173;
		scroll.height = 258;
		scroll.scrollMax = 460;
	}

	private void opacityInterface() {
		RSInterface rsi = addTabInterface(35555);
		setChildren(1, rsi);
		addRectangle(35556, 128, 0x000000, true, 30, 34);
		setBounds(35556, 0, 0, 0, rsi);
	}

	private void levelUpInterfaces() {
		RSInterface attack = interfaceCache[6247];
		RSInterface defence = interfaceCache[6253];
		RSInterface str = interfaceCache[6206];
		RSInterface hits = interfaceCache[6216];
		RSInterface rng = interfaceCache[4443];
		RSInterface pray = interfaceCache[6242];
		RSInterface mage = interfaceCache[6211];
		RSInterface cook = interfaceCache[6226];
		RSInterface wood = interfaceCache[4272];
		RSInterface flet = interfaceCache[6231];
		RSInterface fish = interfaceCache[6258];
		RSInterface fire = interfaceCache[4282];
		RSInterface craf = interfaceCache[6263];
		RSInterface smit = interfaceCache[6221];
		RSInterface mine = interfaceCache[4416];
		RSInterface herb = interfaceCache[6237];
		RSInterface agil = interfaceCache[4277];
		RSInterface thie = interfaceCache[4261];
		RSInterface slay = interfaceCache[12122];
		RSInterface farm = addTabInterface(5267);
		RSInterface rune = interfaceCache[4267];
		RSInterface cons = interfaceCache[7267];
		RSInterface hunt = addTabInterface(8267);
		RSInterface summ = addTabInterface(9267);
		RSInterface dung = addTabInterface(10267);
		addSkillChatSprite(29578, 0);
		addSkillChatSprite(29579, 1);
		addSkillChatSprite(29580, 2);
		addSkillChatSprite(29581, 3);
		addSkillChatSprite(29582, 4);
		addSkillChatSprite(29583, 5);
		addSkillChatSprite(29584, 6);
		addSkillChatSprite(29585, 7);
		addSkillChatSprite(29586, 8);
		addSkillChatSprite(29587, 9);
		addSkillChatSprite(29588, 10);
		addSkillChatSprite(29589, 11);
		addSkillChatSprite(29590, 12);
		addSkillChatSprite(29591, 13);
		addSkillChatSprite(29592, 14);
		addSkillChatSprite(29593, 15);
		addSkillChatSprite(29594, 16);
		addSkillChatSprite(29595, 17);
		addSkillChatSprite(29596, 18);
		addSkillChatSprite(11897, 19);
		addSkillChatSprite(29598, 20);
		addSkillChatSprite(29599, 21);
		addSkillChatSprite(29600, 22);
		addSkillChatSprite(29601, 23);
		addSkillChatSprite(29602, 24);
		setChildren(4, attack);
		setBounds(29578, 20, 30, 0, attack);
		setBounds(4268, 80, 15, 1, attack);
		setBounds(4269, 80, 45, 2, attack);
		setBounds(358, 95, 75, 3, attack);
		setChildren(4, defence);
		setBounds(29579, 20, 30, 0, defence);
		setBounds(4268, 80, 15, 1, defence);
		setBounds(4269, 80, 45, 2, defence);
		setBounds(358, 95, 75, 3, defence);
		setChildren(4, str);
		setBounds(29580, 20, 30, 0, str);
		setBounds(4268, 80, 15, 1, str);
		setBounds(4269, 80, 45, 2, str);
		setBounds(358, 95, 75, 3, str);
		setChildren(4, hits);
		setBounds(29581, 20, 30, 0, hits);
		setBounds(4268, 80, 15, 1, hits);
		setBounds(4269, 80, 45, 2, hits);
		setBounds(358, 95, 75, 3, hits);
		setChildren(4, rng);
		setBounds(29582, 20, 30, 0, rng);
		setBounds(4268, 80, 15, 1, rng);
		setBounds(4269, 80, 45, 2, rng);
		setBounds(358, 95, 75, 3, rng);
		setChildren(4, pray);
		setBounds(29583, 20, 30, 0, pray);
		setBounds(4268, 80, 15, 1, pray);
		setBounds(4269, 80, 45, 2, pray);
		setBounds(358, 95, 75, 3, pray);
		setChildren(4, mage);
		setBounds(29584, 20, 30, 0, mage);
		setBounds(4268, 80, 15, 1, mage);
		setBounds(4269, 80, 45, 2, mage);
		setBounds(358, 95, 75, 3, mage);
		setChildren(4, cook);
		setBounds(29585, 20, 30, 0, cook);
		setBounds(4268, 80, 15, 1, cook);
		setBounds(4269, 80, 45, 2, cook);
		setBounds(358, 95, 75, 3, cook);
		setChildren(4, wood);
		setBounds(29586, 20, 30, 0, wood);
		setBounds(4268, 80, 15, 1, wood);
		setBounds(4269, 80, 45, 2, wood);
		setBounds(358, 95, 75, 3, wood);
		setChildren(4, flet);
		setBounds(29587, 20, 30, 0, flet);
		setBounds(4268, 80, 15, 1, flet);
		setBounds(4269, 80, 45, 2, flet);
		setBounds(358, 95, 75, 3, flet);
		setChildren(4, fish);
		setBounds(29588, 20, 30, 0, fish);
		setBounds(4268, 80, 15, 1, fish);
		setBounds(4269, 80, 45, 2, fish);
		setBounds(358, 95, 75, 3, fish);
		setChildren(4, fire);
		setBounds(29589, 20, 30, 0, fire);
		setBounds(4268, 80, 15, 1, fire);
		setBounds(4269, 80, 45, 2, fire);
		setBounds(358, 95, 75, 3, fire);
		setChildren(4, craf);
		setBounds(29590, 20, 30, 0, craf);
		setBounds(4268, 80, 15, 1, craf);
		setBounds(4269, 80, 45, 2, craf);
		setBounds(358, 95, 75, 3, craf);
		setChildren(4, smit);
		setBounds(29591, 20, 30, 0, smit);
		setBounds(4268, 80, 15, 1, smit);
		setBounds(4269, 80, 45, 2, smit);
		setBounds(358, 95, 75, 3, smit);
		setChildren(4, mine);
		setBounds(29592, 20, 30, 0, mine);
		setBounds(4268, 80, 15, 1, mine);
		setBounds(4269, 80, 45, 2, mine);
		setBounds(358, 95, 75, 3, mine);
		setChildren(4, herb);
		setBounds(29593, 20, 30, 0, herb);
		setBounds(4268, 80, 15, 1, herb);
		setBounds(4269, 80, 45, 2, herb);
		setBounds(358, 95, 75, 3, herb);
		setChildren(4, agil);
		setBounds(29594, 20, 30, 0, agil);
		setBounds(4268, 80, 15, 1, agil);
		setBounds(4269, 80, 45, 2, agil);
		setBounds(358, 95, 75, 3, agil);
		setChildren(4, thie);
		setBounds(29595, 20, 30, 0, thie);
		setBounds(4268, 80, 15, 1, thie);
		setBounds(4269, 80, 45, 2, thie);
		setBounds(358, 95, 75, 3, thie);
		setChildren(4, slay);
		setBounds(29596, 20, 30, 0, slay);
		setBounds(4268, 80, 15, 1, slay);
		setBounds(4269, 80, 45, 2, slay);
		setBounds(358, 95, 75, 3, slay);
		setChildren(4, farm);
		setBounds(11897, 20, 30, 0, farm);
		setBounds(4268, 80, 15, 1, farm);
		setBounds(4269, 80, 45, 2, farm);
		setBounds(358, 95, 75, 3, farm);
		setChildren(4, rune);
		setBounds(29598, 20, 30, 0, rune);
		setBounds(4268, 80, 15, 1, rune);
		setBounds(4269, 80, 45, 2, rune);
		setBounds(358, 95, 75, 3, rune);
		setChildren(3, cons);
		setBounds(4268, 80, 15, 0, cons);
		setBounds(4269, 80, 45, 1, cons);
		setBounds(358, 95, 75, 2, cons);
		setChildren(4, hunt);
		setBounds(29600, 20, 30, 0, hunt);
		setBounds(4268, 80, 15, 1, hunt);
		setBounds(4269, 80, 45, 2, hunt);
		setBounds(358, 95, 75, 3, hunt);
		setChildren(4, summ);
		setBounds(29601, 20, 30, 0, summ);
		setBounds(4268, 80, 15, 1, summ);
		setBounds(4269, 80, 45, 2, summ);
		setBounds(358, 95, 75, 3, summ);
		setChildren(4, dung);
		setBounds(29602, 20, 30, 0, dung);
		setBounds(4268, 80, 15, 1, dung);
		setBounds(4269, 80, 45, 2, dung);
		setBounds(358, 95, 75, 3, dung);
	}

	private void optionTab() {
		RSInterface tab = addTabInterface(904);
		RSInterface energy = interfaceCache[149];
		energy.textColor = 0xff9933;
		addSprite(905, 300);
		addSprite(907, 301);
		addSprite(909, 302);
		addSprite(951, 303);
		addSprite(953, 304);
		addSprite(955, 305);
		addSprite(947, 335);
		addSprite(949, 306);
		addSprite(950, 496);
		// run button here
		addConfigButton(152, 904, 307, 308, 40, 40, "Toggle-run", 1, 5, 173);

		addConfigButton(25841, 904, 307, 308, 40, 40, "Settings", 1, 5, 175);

		addConfigButton(906, 904, 309, 313, 32, 16, "Brightness - Dark", 1, 5, 166);
		addConfigButton(908, 904, 310, 314, 32, 16, "Brightness - Normal", 2, 5, 166);
		addConfigButton(910, 904, 311, 315, 32, 16, "Brightness - Bright", 3, 5, 166);
		addConfigButton(912, 904, 312, 316, 32, 16, "Brightness - Very Bright", 4, 5, 166);

		addConfigButton(930, 904, 317, 322, 26, 16, "Music Off", 4, 5, 168);
		addConfigButton(931, 904, 318, 323, 26, 16, "Music Level-1", 3, 5, 168);
		addConfigButton(932, 904, 319, 324, 26, 16, "Music Level-2", 2, 5, 168);
		addConfigButton(933, 904, 320, 325, 26, 16, "Music Level-3", 1, 5, 168);
		addConfigButton(934, 904, 321, 326, 24, 16, "Music Level-4", 0, 5, 168);

		addConfigButton(941, 904, 317, 322, 26, 16, "Sound Effects Off", 4, 5, 169);
		addConfigButton(942, 904, 318, 323, 26, 16, "Sound Effects Level-1", 3, 5, 169);
		addConfigButton(943, 904, 319, 324, 26, 16, "Sound Effects Level-2", 2, 5, 169);
		addConfigButton(944, 904, 320, 325, 26, 16, "Sound Effects Level-3", 1, 5, 169);
		addConfigButton(945, 904, 321, 326, 24, 16, "Sound Effects Level-4", 0, 5, 169);
		addTooltip(25843, "More client options,\\nincluding fullscreen");

		addConfigButton(913, 904, 307, 308, 40, 40, "Toggle-Mouse Buttons", 0, 5, 170);
		addConfigButton(915, 904, 307, 308, 40, 40, "Toggle-Chat Effects", 0, 5, 171);
		addConfigButton(957, 904, 307, 308, 40, 40, "Toggle-Split Private Chat", 1, 5, 287);
		addConfigButton(12464, 904, 307, 308, 40, 40, "Toggle-Accept Aid", 0, 5, 427);
		tab.totalChildren(30);
		int x = 0;
		int y = 2;
		tab.child(0, 905, 13 + x, 10 + y);
		tab.child(1, 906, 48 + x, 18 + y);
		tab.child(2, 908, 80 + x, 18 + y);
		tab.child(3, 910, 112 + x, 18 + y);
		tab.child(4, 912, 144 + x, 18 + y);
		tab.child(5, 907, 14 + x, 55 + y);
		tab.child(6, 930, 49 + x, 61 + y);
		tab.child(7, 931, 75 + x, 61 + y);
		tab.child(8, 932, 101 + x, 61 + y);
		tab.child(9, 933, 127 + x, 61 + y);
		tab.child(10, 934, 151 + x, 61 + y);
		tab.child(11, 909, 13 + x, 99 + y);
		tab.child(12, 941, 49 + x, 104 + y);
		tab.child(13, 942, 75 + x, 104 + y);
		tab.child(14, 943, 101 + x, 104 + y);
		tab.child(15, 944, 127 + x, 104 + y);
		tab.child(16, 945, 151 + x, 104 + y);
		tab.child(17, 913, 15, 153);
		tab.child(18, 955, 19, 159);
		tab.child(19, 915, 75, 153);
		tab.child(20, 953, 79, 160);
		tab.child(21, 957, 135, 153);
		tab.child(22, 951, 139, 159);
		tab.child(23, 12464, 15, 208);
		tab.child(24, 949, 20, 213);
		tab.child(25, 152, 75, 208);
		tab.child(26, 947, 87, 212);
		tab.child(27, 149, 80, 231);
		tab.child(28, 25841, 135, 208);
		tab.child(29, 950, 140, 213);
	}

	private void settingsInterface() {
		RSInterface tab = addTabInterface(24000);
		addSprite(24001, 571, 571, -1, -1);
		addText(24002, "Graphics Settings", tda, 2, 0xeb981f, true, true);

		addText(24027, "If the game runs slowly on your computer, try reducing these settings.", tda, 1, 0xeb981f, true, true);
		addText(24028, "Low Detail", tda, 0, 0xeb981f, false, true);
		addText(24029, "High Detail", tda, 0, 0xeb981f, false, true);
		addText(24031, "Fixed", tda, 0, 0xeb981f, false, true);
		addText(24032, "Resizable", tda, 0, 0xeb981f, false, true);
		addText(24033, "Fullscreen", tda, 0, 0xeb981f, false, true);
		addText(24030, "Adjust additional settings below.", tda, 1, 0xeb981f, true, true);

		String[] text = { "New GameFrame", "Names Above Head", "HP Above Head",
				"New Hitpoints", "New Hitmarks", "New Function Keys",
				"x10 Damage", "Fog", "Tweening", "Roofs Off", "Toggle FOV",
				"Push notifications", "Unused", "Unused", "Unused", };
		for (int i = 0; i < text.length; i++) {
			addText(24003 + i, text[i], tda, 0, 0xeb981f, true, true);
		}
		addHoverButton(24034, 580, 16, 16, "Close", -1, 24035, 3);
		addHoveredButton(24035, 581, 16, 16, 24036);

		addHoverButton(24018, 486, 50, 39, "Set to Fixed Mode", -1, 24019, 1);
		addHoveredButton(24019, 487, 50, 39, 24020);
		addHoverButton(24021, 488, 50, 39, "Set to Resizable Mode", -1, 24022, 1);
		addHoveredButton(24022, 489, 50, 39, 24023);
		addHoverButton(24024, 490, 50, 39, "Set to Fullscreen Mode", -1, 24025, 1);
		addHoveredButton(24025, 491, 50, 39, 24026);

		addCheckmarkHover(24159, 4, 24160, 576, 577, 57, 35, SETTING_CONFIGS[15], 1, "Low Detail", 24161, 577, 577, 24162, "", "", 12, 20);
		addCheckmarkHover(24163, 4, 24164, 578, 579, 57, 35, SETTING_CONFIGS[16], 1, "High Detail", 24165, 579, 579, 24166, "", "", 12, 20);

		addCheckmarkHover(24099, 4, 24100, 572, 573, 104, 26, SETTING_CONFIGS[0], 1, "Change Gameframe", 24101, 574, 575, 24102, "", "", 12, 20);
		addCheckmarkHover(24103, 4, 24104, 572, 573, 104, 26, SETTING_CONFIGS[1], 1, "Names above Head", 24105, 574, 575, 24106, "", "", 12, 20);
		addCheckmarkHover(24107, 4, 24108, 572, 573, 104, 26, SETTING_CONFIGS[2], 1, "Hitpoints above Head", 24109, 574, 575, 24110, "", "", 12, 20);
		addCheckmarkHover(24111, 4, 24112, 572, 573, 104, 26, SETTING_CONFIGS[3], 1, "New Hitpoints", 24113, 574, 575, 24114, "", "", 12, 20);
		addCheckmarkHover(24115, 4, 24116, 572, 573, 104, 26, SETTING_CONFIGS[4], 1, "New Hitmarks", 24117, 574, 575, 24118, "", "", 12, 20);
		addCheckmarkHover(24119, 4, 24120, 572, 573, 104, 26, SETTING_CONFIGS[5], 1, "New Function Keys", 24121, 574, 575, 24122, "", "", 12, 20);
		addCheckmarkHover(24123, 4, 24124, 572, 573, 104, 26, SETTING_CONFIGS[6], 1, "x10 Hitpoints", 24125, 574, 575, 24126, "", "", 12, 20);
		addCheckmarkHover(24127, 4, 24128, 572, 573, 104, 26, SETTING_CONFIGS[7], 1, "Fog", 24129, 574, 575, 24130, "", "", 12, 20);
		addCheckmarkHover(24131, 4, 24132, 572, 573, 104, 26, SETTING_CONFIGS[8], 1, "Tweening", 24133, 574, 575, 24134, "", "", 12, 20);
		addCheckmarkHover(24135, 4, 24136, 572, 573, 104, 26, SETTING_CONFIGS[9], 1, "Toggle Roofs", 24137, 574, 575, 24138, "", "", 12, 20);
		addCheckmarkHover(24139, 4, 24140, 572, 573, 104, 26, SETTING_CONFIGS[10], 1, "Toggle FOV", 24141, 574, 575, 24142, "", "", 12, 20);
		addCheckmarkHover(24143, 4, 24144, 572, 573, 104, 26, SETTING_CONFIGS[11], 1, "Push notifications", 24145, 574, 575, 24146, "", "", 12, 20);
		addCheckmarkHover(24147, 4, 24148, 572, 573, 104, 26, SETTING_CONFIGS[12], 1, "Option 2", 24149, 574, 575, 24150, "", "", 12, 20);
		addCheckmarkHover(24151, 4, 24152, 572, 573, 104, 26, SETTING_CONFIGS[13], 1, "Option 3", 24153, 574, 575, 24154, "", "", 12, 20);
		addCheckmarkHover(24155, 4, 24156, 572, 573, 104, 26, SETTING_CONFIGS[14], 1, "Option 4", 24157, 574, 575, 24158, "", "", 12, 20);

		int x = 97;
		int y = 143;
		int configX = 45;
		int configY = 135;
		int seperationX = 160;
		int seperationY = 40;
		tab.totalChildren(66);
		tab.child(0, 24001, 0, 0); // background sprite
		tab.child(1, 24099, configX, configY); // gameframe
		tab.child(2, 24100, configX, configY); // gameframe
		tab.child(3, 24103, configX + seperationX, configY); // name above head
		tab.child(4, 24104, configX + seperationX, configY); // name above head
		tab.child(5, 24107, configX + seperationX * 2, configY); // hitpoints
		// above
		// head
		tab.child(6, 24108, configX + seperationX * 2, configY); // hitpoints
		// above
		// head
		tab.child(7, 24111, configX, configY + seperationY); // new hitpoints
		tab.child(8, 24112, configX, configY + seperationY); // new hitpoints
		tab.child(9, 24115, configX + seperationX, configY + seperationY); // new
		// hitmarks
		tab.child(10, 24116, configX + seperationX, configY + seperationY); // new
		// hitmarks
		tab.child(11, 24119, configX + seperationX * 2, configY + seperationY); // new
		// function
		// keys
		tab.child(12, 24120, configX + seperationX * 2, configY + seperationY); // new
		// function
		// keys
		tab.child(13, 24123, configX, configY + seperationY * 2); // x10
		// hitpoints
		tab.child(14, 24124, configX, configY + seperationY * 2); // x10
		// hitpoints
		tab.child(15, 24127, configX + seperationX, configY + seperationY * 2); // fog
		tab.child(16, 24128, configX + seperationX, configY + seperationY * 2); // fog
		tab.child(17, 24131, configX + seperationX * 2, configY + seperationY * 2); // tweening
		tab.child(18, 24132, configX + seperationX * 2, configY + seperationY * 2); // tweening
		tab.child(19, 24135, configX, configY + seperationY * 3); // toggle
		// roofs
		tab.child(20, 24136, configX, configY + seperationY * 3); // toggle
		// roofs
		tab.child(21, 24139, configX + seperationX, configY + seperationY * 3); // toggle
		// fov
		tab.child(22, 24140, configX + seperationX, configY + seperationY * 3); // toggle
		// fov
		tab.child(23, 24143, configX + seperationX * 2, configY + seperationY * 3); // option
		// 1
		tab.child(24, 24144, configX + seperationX * 2, configY + seperationY * 3); // option
		// 1
		tab.child(25, 24147, configX, configY + seperationY * 4); // option 2
		tab.child(26, 24148, configX, configY + seperationY * 4); // option 2
		tab.child(27, 24151, configX + seperationX, configY + seperationY * 4); // option
		// 3
		tab.child(28, 24152, configX + seperationX, configY + seperationY * 4); // option
		// 3
		tab.child(29, 24155, configX + seperationX * 2, configY + seperationY * 4); // option
		// 4
		tab.child(30, 24156, configX + seperationX * 2, configY + seperationY * 4); // option
		// 4
		tab.child(31, 24018, 76, 62);
		tab.child(32, 24019, 76, 62);
		tab.child(33, 24021, 166, 62);
		tab.child(34, 24022, 166, 62);
		tab.child(35, 24024, 261, 62);
		tab.child(36, 24025, 261, 62);
		tab.child(37, 24159, 340, 64); // low detail
		tab.child(38, 24160, 340, 64); // low detail
		tab.child(39, 24163, 410, 64); // high detail
		tab.child(40, 24164, 410, 64); // high detail
		tab.child(41, 24002, 258, 4); // title
		tab.child(42, 24030, 258, 118); // title2
		tab.child(43, 24028, 341, 102); // Low detail text
		tab.child(44, 24029, 411, 102); // High detail text
		tab.child(45, 24031, 87, 102); // Fixed text
		tab.child(46, 24032, 167, 102); // Resizable text
		tab.child(47, 24033, 262, 102); // Fullscreen text
		tab.child(48, 24027, 258, 24); // text below title
		tab.child(49, 24034, 492, 3); // Close button
		tab.child(50, 24035, 492, 3); // Close hover

		for (int i = 0; i < text.length; i++) {
			tab.child(i + 51, i + 24003, x + i % 3 * seperationX, y + i / 3 * seperationY);
		}
	}

	private void lootingBag() {
		RSInterface rsi = addInterface(16545);
		RSInterface.addText(16546, "Add to bag", 0xff9b00, true, true, -1, tda, 2);
		RSInterface.addSprite(16547, 612, 612, -1, -1);
		addHoverButton(5384, 55, 17, 17, "Close Window", 250, 5380, 3);
		addHoveredButton(5380, 90, 17, 17, 5379);

		rsi.totalChildren(5);

		setBounds(16546, 88, 5, 0, rsi);
		setBounds(16547, 7, 25, 1, rsi);
		setBounds(5384, 155, 5, 2, rsi);
		setBounds(5380, 155, 5, 3, rsi);
		setBounds(3213, 0, 22, 4, rsi);
	}

	private void bountyInterface() {
		RSInterface rsi = addInterface(42020);
		RSInterface.addTransparentSprite(42021, 611, 611, 125);
		RSInterface.addText(42022, "None", 0xD40000, true, true, -1, tda, 0);
		RSInterface.addText(42023, "5", 0xD40000, false, true, -1, tda, 0);
		RSInterface.addText(42024, "100%", 0xD40000, false, true, -1, tda, 0);
		RSInterface.addText(42025, "Target:", Integer.MAX_VALUE, true, true, -1, tda, 0);
		RSInterface.addText(42026, "Wilderness Level:", Integer.MAX_VALUE, false, true, -1, tda, 0);
		RSInterface.addText(42027, "Target Percentage:", Integer.MAX_VALUE, false, true, -1, tda, 0);
		rsi.totalChildren(7);
		setBounds(42021, 310, 5, 0, rsi);
		setBounds(42022, 430, 9, 1, rsi);
		setBounds(42023, 430, 25, 2, rsi);
		setBounds(42024, 430, 40, 3, rsi);
		setBounds(42025, 334, 10, 4, rsi);
		setBounds(42026, 316, 25, 5, rsi);
		setBounds(42027, 316, 39, 6, rsi);
	}

	private void sidebarInterfaces() {
		Sidebar0a(1698, 1701, 7499, "Chop", "Hack", "Smash", "Block", 42, 75, 127, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(2276, 2279, 7574, "Stab", "Lunge", "Slash", "Block", 43, 75, 124, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(2423, 2426, 7599, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(3796, 3799, 7624, "Pound", "Pummel", "Spike", "Block", 39, 75, 121, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(4679, 4682, 7674, "Lunge", "Swipe", "Pound", "Block", 40, 75, 124, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(4705, 4708, 7699, "Chop", "Slash", "Smash", "Block", 42, 75, 125, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(5570, 5573, 7724, "Spike", "Impale", "Smash", "Block", 41, 75, 123, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(7762, 7765, 7800, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0b(776, 779, "Reap", "Chop", "Jab", "Block", 42, 75, 126, 75, 46, 128, 125, 128, 122, 103, 122, 50, 40, 103, 40, 50, tda);
		Sidebar0c(425, 428, 7474, "Pound", "Pummel", "Block", 39, 75, 121, 75, 42, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(1749, 1752, 7524, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(1764, 1767, 7549, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(4446, 4449, 7649, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(5855, 5857, 7749, "Punch", "Kick", "Block", 40, 75, 129, 75, 42, 128, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0c(6103, 6132, 6117, "Bash", "Pound", "Block", 43, 75, 124, 75, 42, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(8460, 8463, 8493, "Jab", "Swipe", "Fend", 46, 75, 124, 75, 43, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(12290, 12293, 12323, "Flick", "Lash", "Deflect", 44, 75, 127, 75, 36, 128, 40, 50, 40, 103, 122, 50, tda);
		Sidebar0d(328, 331, "Bash", "Pound", "Focus", 42, 66, 39, 101, 41, 136, 40, 120, 40, 50, 40, 85, tda);

		RSInterface rsi = addInterface(19300);
		/* textSize(ID, wid, Size); */
		textSize(3983, tda, 0);
		/* addToggleButton(id, sprite, config, width, height, wid); */
		addToggleButton(150, 64, 172, 150, 44, "Auto Retaliate");

		rsi.totalChildren(2, 2, 2);
		rsi.child(0, 3983, 52, 25); // combat level
		rsi.child(1, 150, 21, 153); // auto retaliate

		rsi = interfaceCache[3983];
		rsi.centerText = true;
		rsi.textColor = 0xff981f;
	}
	
	private void prayerTabInterface() {
		RSInterface prayerMenu = addTabInterface(5608);
		int index = 0;
		int prayIndex = 0;
		int firstRowXPos = 10;
		int firstRowYPos = 50;
		int secondRowXPos = 10;
		int secondRowYPos = 86;
		int thirdRowXPos = 10;
		int thirdRowYPos = 122;
		int fourthRowXPos = 10;
		int fourthRowYPos = 159;
		int fifthRowXPos = 10;
		int fifthRowYPos = 86;
		int sixthRowXPos = 1;
		int sixthRowYPos = 52;
		addText(687, "", 0xff981f, false, true, -1, tda, 1);
		addSpriteLoader(25112, 870);
		addPrayerWithTooltip(25000, 0, 83, 0, prayIndex, 25052,
				"Activate @lre@Thick Skin");
		prayIndex++;
		addPrayerWithTooltip(25002, 0, 84, 3, prayIndex, 25054,
				"Activate @lre@Burst of Strength");
		prayIndex++;
		addPrayerWithTooltip(25004, 0, 85, 6, prayIndex, 25056,
				"Activate @lre@Clarity of Thought");
		prayIndex++;
		addPrayerWithTooltip(25006, 0, 601, 7, prayIndex, 25058,
				"Activate @lre@Sharp Eye");
		prayIndex++;
		addPrayerWithTooltip(25008, 0, 602, 8, prayIndex, 25060,
				"Activate @lre@Mystic Will");
		prayIndex++;
		addPrayerWithTooltip(25010, 0, 86, 9, prayIndex, 25062,
				"Activate @lre@Rock Skin");
		prayIndex++;
		addPrayerWithTooltip(25012, 0, 87, 12, prayIndex, 25064,
				"Activate @lre@Superhuman Strength");
		prayIndex++;
		addPrayerWithTooltip(25014, 0, 88, 15, prayIndex, 25066,
				"Activate @lre@Improved Reflexes");
		prayIndex++;
		addPrayerWithTooltip(25016, 0, 89, 18, prayIndex, 25068,
				"Activate @lre@Rapid Restore");
		prayIndex++;
		addPrayerWithTooltip(25018, 0, 90, 21, prayIndex, 25070,
				"Activate @lre@Rapid Heal");
		prayIndex++;
		addPrayerWithTooltip(25020, 0, 91, 24, prayIndex, 25072,
				"Activate @lre@Protect Item");
		prayIndex++;
		addPrayerWithTooltip(25022, 0, 603, 25, prayIndex, 25074,
				"Activate @lre@Hawk Eye");
		prayIndex++;
		addPrayerWithTooltip(25024, 0, 604, 26, prayIndex, 25076,
				"Activate @lre@Mystic Lore");
		prayIndex++;
		addPrayerWithTooltip(25026, 0, 92, 27, prayIndex, 25078,
				"Activate @lre@Steel Skin");
		prayIndex++;
		addPrayerWithTooltip(25028, 0, 93, 30, prayIndex, 25080,
				"Activate @lre@Ultimate Strength");
		prayIndex++;
		addPrayerWithTooltip(25030, 0, 94, 33, prayIndex, 25082,
				"Activate @lre@Incredible Reflexes");
		prayIndex++;
		addPrayerWithTooltip(25032, 0, 95, 36, prayIndex, 25084,
				"Activate @lre@Protect from Magic");
		prayIndex++;
		addPrayerWithTooltip(25034, 0, 96, 39, prayIndex, 25086,
				"Activate @lre@Protect from Missles");
		prayIndex++;
		addPrayerWithTooltip(25036, 0, 97, 42, prayIndex, 25088,
				"Activate @lre@Protect from Melee");
		prayIndex++;
		addPrayerWithTooltip(25038, 0, 605, 43, prayIndex, 25090,
				"Activate @lre@Eagle Eye");
		prayIndex++;
		addPrayerWithTooltip(25040, 0, 606, 44, prayIndex, 25092,
				"Activate @lre@Mystic Might");
		prayIndex++;
		addPrayerWithTooltip(25042, 0, 98, 45, prayIndex, 25094,
				"Activate @lre@Retribution");
		prayIndex++;
		addPrayerWithTooltip(25044, 0, 99, 48, prayIndex, 25096,
				"Activate @lre@Redemption");
		prayIndex++;
		addPrayerWithTooltip(25046, 0, 100, 51, prayIndex, 25098,
				"Activate @lre@Smite");
		prayIndex++;
		addPrayerWithTooltip(25048, 0, 607, 59, prayIndex, 25100,
				"Activate @lre@Chivalry");
		prayIndex++;
		addPrayerWithTooltip(25050, 0, 608, 69, prayIndex, 25102,
				"Activate @lre@Piety");
		prayIndex++;
		addPrayerWithTooltip(25104, 0, 609, 79, prayIndex, 25106, "Activate @lre@Rigour");
		prayIndex++;
		addPrayerWithTooltip(25108, 0, 610, 89, prayIndex, 25110, "Activate @lre@Augury");
		prayIndex++;
		addTooltip(25052, "Level 01\nThick Skin\nIncreases your Defence by 5%");
		addTooltip(25054,
				"Level 04\nBurst of Strength\nIncreases your Strength by 5%");
		addTooltip(25056,
				"Level 07\nClarity of Thought\nIncreases your Attack by 5%");
		addTooltip(25058, "Level 08\nSharp Eye\nIncreases your Ranged by 5%");
		addTooltip(25060, "Level 09\nMystic Will\nIncreases your Magic by 5%");
		addTooltip(25062, "Level 10\nRock Skin\nIncreases your Defence by 10%");
		addTooltip(25064,
				"Level 13\nSuperhuman Strength\nIncreases your Strength by 10%");
		addTooltip(25066,
				"Level 16\nImproved Reflexes\nIncreases your Attack by 10%");
		addTooltip(
				25068,
				"Level 19\nRapid Restore\n2x restore rate for all stats\nexcept Hitpoints, Summoning\nand Prayer");
		addTooltip(25070,
				"Level 22\nRapid Heal\n2x restore rate for the\nHitpoints stat");
		addTooltip(25072,
				"Level 25\nProtect Item\nKeep 1 extra item if you die");
		addTooltip(25074, "Level 26\nHawk Eye\nIncreases your Ranged by 10%");
		addTooltip(25076, "Level 27\nMystic Lore\nIncreases your Magic by 10%");
		addTooltip(25078, "Level 28\nSteel Skin\nIncreases your Defence by 15%");
		addTooltip(25080,
				"Level 31\nUltimate Strength\nIncreases your Strength by 15%");
		addTooltip(25082,
				"Level 34\nIncredible Reflexes\nIncreases your Attack by 15%");
		addTooltip(25084,
				"Level 37\nProtect from Magic\nProtection from magical attacks");
		addTooltip(25086,
				"Level 40\nProtect from Missles\nProtection from ranged attacks");
		addTooltip(25088,
				"Level 43\nProtect from Melee\nProtection from melee attacks");
		addTooltip(25090, "Level 44\nEagle Eye\nIncreases your Ranged by 15%");
		addTooltip(25092, "Level 45\nMystic Might\nIncreases your Magic by 15%");
		addTooltip(25094,
				"Level 46\nRetribution\nInflicts damage to nearby\ntargets if you die");
		addTooltip(25096,
				"Level 49\nRedemption\nHeals you when damaged\nand Hitpoints falls\nbelow 10%");
		addTooltip(25098,
				"Level 52\nSmite\n1/4 of damage dealt is\nalso removed from\nopponent's Prayer");
		addTooltip(
				25100,
				"Level 60\nChivalry\nIncreases your Defence by 20%,\nStrength by 18%, and Attack by\n15%");
		addTooltip(
				25102,
				"Level 70\nPiety\nIncreases your Defence by 25%,\nStrength by 23%, and Attack by\n20%");
		addTooltip(
				25106,
				"Level 80\nRigour\nIncreases your Ranging by 22%\nand Defence by 25%");
		addTooltip(
				25110,
				"Level 80\nAugury\nIncreases your Magic by 22%\nand Defence by 25%");
		setChildren(86, prayerMenu);
		setBounds(687, 85, 241, index, prayerMenu);
		index++;
		setBounds(25112, 65, 241, index, prayerMenu);
		index++;
		setBounds(25000, 2, 5, index, prayerMenu);
		index++;
		setBounds(25001, 5, 8, index, prayerMenu);
		index++;
		setBounds(25002, 40, 5, index, prayerMenu);
		index++;
		setBounds(25003, 44, 8, index, prayerMenu);
		index++;
		setBounds(25004, 76, 5, index, prayerMenu);
		index++;
		setBounds(25005, 79, 11, index, prayerMenu);
		index++;
		setBounds(25006, 113, 5, index, prayerMenu);
		index++;
		setBounds(25007, 116, 10, index, prayerMenu);
		index++;
		setBounds(25008, 150, 5, index, prayerMenu);
		index++;
		setBounds(25009, 153, 9, index, prayerMenu);
		index++;
		setBounds(25010, 2, 45, index, prayerMenu);
		index++;
		setBounds(25011, 5, 48, index, prayerMenu);
		index++;
		setBounds(25012, 39, 45, index, prayerMenu);
		index++;
		setBounds(25013, 44, 47, index, prayerMenu);
		index++;
		setBounds(25014, 76, 45, index, prayerMenu);
		index++;
		setBounds(25015, 79, 49, index, prayerMenu);
		index++;
		setBounds(25016, 113, 45, index, prayerMenu);
		index++;
		setBounds(25017, 116, 50, index, prayerMenu);
		index++;
		setBounds(25018, 151, 45, index, prayerMenu);
		index++;
		setBounds(25019, 154, 50, index, prayerMenu);
		index++;
		setBounds(25020, 2, 82, index, prayerMenu);
		index++;
		setBounds(25021, 4, 84, index, prayerMenu);
		index++;
		setBounds(25022, 40, 82, index, prayerMenu);
		index++;
		setBounds(25023, 44, 87, index, prayerMenu);
		index++;
		setBounds(25024, 77, 82, index, prayerMenu);
		index++;
		setBounds(25025, 81, 85, index, prayerMenu);
		index++;
		setBounds(25026, 114, 83, index, prayerMenu);
		index++;
		setBounds(25027, 117, 85, index, prayerMenu);
		index++;
		setBounds(25028, 153, 83, index, prayerMenu);
		index++;
		setBounds(25029, 156, 87, index, prayerMenu);
		index++;
		setBounds(25030, 2, 120, index, prayerMenu);
		index++;
		setBounds(25031, 5, 125, index, prayerMenu);
		index++;
		setBounds(25032, 40, 120, index, prayerMenu);
		index++;
		setBounds(25033, 43, 124, index, prayerMenu);
		index++;
		setBounds(25034, 78, 120, index, prayerMenu);
		index++;
		setBounds(25035, 83, 124, index, prayerMenu);
		index++;
		setBounds(25036, 114, 120, index, prayerMenu);
		index++;
		setBounds(25037, 115, 121, index, prayerMenu);
		index++;
		setBounds(25038, 151, 120, index, prayerMenu);
		index++;
		setBounds(25039, 154, 124, index, prayerMenu);
		index++;
		setBounds(25040, 2, 158, index, prayerMenu);
		index++;
		setBounds(25041, 5, 160, index, prayerMenu);
		index++;
		setBounds(25042, 39, 158, index, prayerMenu);
		index++;
		setBounds(25043, 41, 158, index, prayerMenu);
		index++;
		setBounds(25044, 76, 158, index, prayerMenu);
		index++;
		setBounds(25045, 79, 163, index, prayerMenu);
		index++;
		setBounds(25046, 114, 158, index, prayerMenu);
		index++;
		setBounds(25047, 116, 158, index, prayerMenu);
		index++;
		setBounds(25048, 153, 158, index, prayerMenu);
		index++;
		setBounds(25049, 161, 160, index, prayerMenu);
		index++;
		setBounds(25050, 2, 196, index, prayerMenu);
		index++;
		setBounds(25104, 40, 196, index, prayerMenu);
		index++;
		setBounds(25105, 43, 201, index, prayerMenu);
		index++;
		setBounds(25108, 77, 197, index, prayerMenu);
		index++;
		setBounds(25109, 80, 201, index, prayerMenu);
		index++;
		setBounds(25051, 4, 207, index, prayerMenu);
		setBoundry(++index, 25052, firstRowXPos - 2, firstRowYPos, prayerMenu);
		setBoundry(++index, 25054, firstRowXPos - 5, firstRowYPos, prayerMenu);
		setBoundry(++index, 25056, firstRowXPos, firstRowYPos, prayerMenu);
		setBoundry(++index, 25058, firstRowXPos, firstRowYPos, prayerMenu);
		setBoundry(++index, 25060, firstRowXPos, firstRowYPos, prayerMenu);
		setBoundry(++index, 25062, secondRowXPos - 9, secondRowYPos, prayerMenu);
		setBoundry(++index, 25064, secondRowXPos - 11, secondRowYPos,
				prayerMenu);
		setBoundry(++index, 25066, secondRowXPos, secondRowYPos, prayerMenu);
		setBoundry(++index, 25068, secondRowXPos, secondRowYPos, prayerMenu);
		setBoundry(++index, 25070, secondRowXPos + 25, secondRowYPos,
				prayerMenu);
		setBoundry(++index, 25072, thirdRowXPos, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25074, thirdRowXPos - 2, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25076, thirdRowXPos, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25078, thirdRowXPos - 7, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25080, thirdRowXPos - 10, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25082, fourthRowXPos, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25084, fourthRowXPos - 8, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25086, fourthRowXPos - 7, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25088, fourthRowXPos - 2, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25090, fourthRowXPos - 2, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25092, fifthRowXPos, fifthRowYPos, prayerMenu);
		setBoundry(++index, 25094, fifthRowXPos, fifthRowYPos - 20, prayerMenu);
		setBoundry(++index, 25096, fifthRowXPos, fifthRowYPos - 25, prayerMenu);
		setBoundry(++index, 25098, fifthRowXPos + 15, fifthRowYPos - 25,
				prayerMenu);
		setBoundry(++index, 25100, fifthRowXPos - 12, fifthRowYPos - 20,
				prayerMenu);
		setBoundry(++index, 25102, sixthRowXPos - 2, sixthRowYPos + 50, prayerMenu);
		setBoundry(++index, 25106, sixthRowXPos - 2, sixthRowYPos + 50, prayerMenu);
		setBoundry(++index, 25110, sixthRowXPos - 2, sixthRowYPos + 50, prayerMenu);
		index++;
	}
	
	private void curseTabInterface() {
		RSInterface Interface = addTabInterface(32500);
		int index = 0;
		addSpriteLoader(688, 871);
		//addTooltip(19021, "This is the effect that prayers\nand curses have during combat.\nIt includes curses that have\nbeen used against you. The\nadjustment has no effect\noutside of combat. The\npercentage shown is relative to\n your skill level, and may vary\ndepending on the enemy you are\nfighting, and the prayers or\n curses used. Partial\npercentages are not shown.");
		addSpriteLoader(689, 872);
		addText(19025, "  Stat Adjustments", 0xFFCC00, false, true, 52, tda, 0);
		addText(690, "690", 0xFF981F, false, false, -1, tda, 0);
		addText(691, "691", 0xFF981F, false, false, -1, tda, 0);
		addText(692, "692", 0xFF981F, false, false, -1, tda, 0);
		addText(693, "693", 0xFF981F, false, false, -1, tda, 0);
		addText(694, "694", 0xFF981F, false, false, -1, tda, 0);
		addText(687, "99/99", 0xFF981F, false, false, -1, tda, 1);
		addSpriteLoader(32502, 870);
		addCurseWithTooltip(32503, 0, 610, 49, 7, "Protect Item", 32582);
		addCurseWithTooltip(32505, 0, 611, 49, 4, "Sap Warrior", 32544);
		addCurseWithTooltip(32507, 0, 612, 51, 5, "Sap Ranger", 32546);
		addCurseWithTooltip(32509, 0, 613, 53, 3, "Sap Mage", 32548);
		addCurseWithTooltip(32511, 0, 614, 55, 2, "Sap Spirit", 32550);
		addCurseWithTooltip(32513, 0, 615, 58, 18, "Berserker", 32552);
		addCurseWithTooltip(32515, 0, 616, 61, 15, "Deflect Summoning", 32554);
		addCurseWithTooltip(32517, 0, 617, 64, 17, "Deflect Magic", 32556);
		addCurseWithTooltip(32519, 0, 618, 67, 16, "Deflect Missiles", 32558);
		addCurseWithTooltip(32521, 0, 619, 70, 6, "Deflect Melee", 32560);
		addCurseWithTooltip(32523, 0, 620, 73, 9, "Leech Attack", 32562);
		addCurseWithTooltip(32525, 0, 621, 75, 10, "Leech Ranged", 32564);
		addCurseWithTooltip(32527, 0, 622, 77, 11, "Leech Magic", 32566);
		addCurseWithTooltip(32529, 0, 623, 79, 12, "Leech Defence", 32568);
		addCurseWithTooltip(32531, 0, 624, 81, 13, "Leech Strength", 32570);
		addCurseWithTooltip(32533, 0, 625, 83, 14, "Leech Energy", 32572);
		addCurseWithTooltip(32535, 0, 626, 85, 19, "Leech Special Attack", 32574);
		addCurseWithTooltip(32537, 0, 627, 88, 1, "Wrath", 32576);
		addCurseWithTooltip(32539, 0, 628, 91, 8, "Soul Split", 32578);
		addCurseWithTooltip(32541, 0, 629, 94, 20, "Turmoil", 32580);
		addTooltip(32582, "Level 50\nProtect Item\nKeep 1 extra item if you die");
		addTooltip(32544, "Level 50\nSap Warrior\nDrains 10% of enemy Attack,\nStrength and Defence,\nincreasing to 20% over time");
		addTooltip(32546, "Level 52\nSap Ranger\nDrains 10% of enemy Ranged\nand Defence, increasing to 20%\nover time");
		addTooltip(32548, "Level 54\nSap Mage\nDrains 10% of enemy Magic\nand Defence, increasing to 20%\nover time");
		addTooltip(32550, "Level 56\nSap Spirit\nDrains enenmy special attack\nenergy");
		addTooltip(32552, "Level 59\nBerserker\nBoosted stats last 15% longer");
		addTooltip(32554, "Level 62\nDeflect Summoning\nReduces damage dealt from\nSummoning scrolls, prevents the\nuse of a familiar's special\nattack, and can deflect some of\ndamage back to the attacker");
		addTooltip(32556, "Level 65\nDeflect Magic\nProtects against magical attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(32558, "Level 68\nDeflect Missiles\nProtects against ranged attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(32560, "Level 71\nDeflect Melee\nProtects against melee attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(32562, "Level 74\nLeech Attack\nBoosts Attack by 5%, increasing\nto 10% over time, while draining\nenemy Attack by 10%, increasing\nto 25% over time");
		addTooltip(32564, "Level 76\nLeech Ranged\nBoosts Ranged by 5%, increasing\nto 10% over time, while draining\nenemy Ranged by 10%,\nincreasing to 25% over\ntime");
		addTooltip(32566, "Level 78\nLeech Magic\nBoosts Magic by 5%, increasing\nto 10% over time, while draining\nenemy Magic by 10%, increasing\nto 25% over time");
		addTooltip(32568, "Level 80\nLeech Defence\nBoosts Defence by 5%, increasing\nto 10% over time, while draining\n enemy Defence by10%,\nincreasing to 25% over\ntime");
		addTooltip(32570, "Level 82\nLeech Strength\nBoosts Strength by 5%, increasing\nto 10% over time, while draining\nenemy Strength by 10%, increasing\n to 25% over time");
		addTooltip(32572, "Level 84\nLeech Energy\nDrains enemy run energy, while\nincreasing your own");
		addTooltip(32574, "Level 86\nLeech Special Attack\nDrains enemy special attack\nenergy, while increasing your\nown");
		addTooltip(32576, "Level 89\nWrath\nInflicts damage to nearby\ntargets if you die");
		addTooltip(32578, "Level 92\nSoul Split\n1/4 of damage dealt is also removed\nfrom opponent's Prayer and\nadded to your Hitpoints");
		addTooltip(32580, "Level 95\nTurmoil\nIncreases Attack and Defence\nby 15%, plus 15% of enemy's\nlevel, and Strength by 23% plus\n10% of enemy's level");
		setChildren(70, Interface);
		/*curse start*/
		setBounds(689, 0, 217, index, Interface);index++;
		//setBounds(701, 0, 217, index, Interface);index++;
		setBounds(687, 85, 241, index, Interface);index++;
		setBounds(688, 0, 170, index, Interface);index++;
		setBounds(690, 2, 200, index, Interface);index++;
		setBounds(691, 41, 200, index, Interface);index++;
		setBounds(692, 79, 200, index, Interface);index++;
		setBounds(693, 117, 200, index, Interface);index++;
		setBounds(694, 160, 200, index, Interface);index++;
		setBounds(19025, 47, 218, index, Interface);index++;
		//setBounds(19030, 47, 219, index, Interface);index++;
		setBounds(32502, 65, 241, index, Interface);index++;
		setBounds(32503, 2, 5, index, Interface);index++;
		setBounds(32504, 8, 8, index, Interface);index++;
		setBounds(32505, 40, 5, index, Interface);index++;
		setBounds(32506, 47, 12, index, Interface);index++;
		setBounds(32507, 76, 5, index, Interface);index++;
		setBounds(32508, 82, 11, index, Interface);index++;
		setBounds(32509, 113, 5, index, Interface);index++;
		setBounds(32510, 116, 8, index, Interface);index++;
		setBounds(32511, 150, 5, index, Interface);index++;
		setBounds(32512, 155, 10, index, Interface);index++;
		setBounds(32513, 2, 45, index, Interface);index++;
		setBounds(32514, 9, 48, index, Interface);index++;
		setBounds(32515, 39, 45, index, Interface);index++;
		setBounds(32516, 42, 47, index, Interface);index++;
		setBounds(32517, 76, 45, index, Interface);index++;
		setBounds(32518, 79, 48, index, Interface);index++;
		setBounds(32519, 113, 45, index, Interface);index++;
		setBounds(32520, 116, 48, index, Interface);index++;
		setBounds(32521, 151, 45, index, Interface);index++;
		setBounds(32522, 154, 48, index, Interface);index++;
		setBounds(32523, 2, 82, index, Interface);index++;
		setBounds(32524, 6, 86, index, Interface);index++;
		setBounds(32525, 40, 82, index, Interface);index++;
		setBounds(32526, 42, 86, index, Interface);index++;
		setBounds(32527, 77, 82, index, Interface);index++;
		setBounds(32528, 79, 86, index, Interface);index++;
		setBounds(32529, 114, 83, index, Interface);index++;
		setBounds(32530, 119, 87, index, Interface);index++;
		setBounds(32531, 153, 83, index, Interface);index++;
		setBounds(32532, 156, 86, index, Interface);index++;
		setBounds(32533, 2, 120, index, Interface);index++;
		setBounds(32534, 7, 125, index, Interface);index++;
		setBounds(32535, 40, 120, index, Interface);index++;
		setBounds(32536, 45, 124, index, Interface);index++;
		setBounds(32537, 78, 120, index, Interface);index++;
		setBounds(32538, 86, 124, index, Interface);index++;
		setBounds(32539, 114, 120, index, Interface);index++;
		setBounds(32540, 120, 125, index, Interface);index++;
		setBounds(32541, 151, 120, index, Interface);index++;
		setBounds(32542, 153, 127, index, Interface);index++;
		setBounds(32582, 10, 40, index, Interface);index++;
		setBounds(32544, 20, 40, index, Interface);index++;
		setBounds(32546, 20, 40, index, Interface);index++;
		setBounds(32548, 20, 40, index, Interface);index++;
		setBounds(32550, 20, 40, index, Interface);index++;
		setBounds(32552, 10, 80, index, Interface);index++;
		setBounds(32554, 10, 80, index, Interface);index++;
		setBounds(32556, 10, 80, index, Interface);index++;
		setBounds(32558, 10, 80, index, Interface);index++;
		setBounds(32560, 10, 80, index, Interface);index++;
		setBounds(32562, 10, 120, index, Interface);index++;
		setBounds(32564, 10, 120, index, Interface);index++;
		setBounds(32566, 10, 120, index, Interface);index++;
		setBounds(32568, 5, 120, index, Interface);index++;
		setBounds(32570, 5, 120, index, Interface);index++;
		setBounds(32572, 10, 160, index, Interface);index++;
		setBounds(32574, 10, 160, index, Interface);index++;
		setBounds(32576, 10, 160, index, Interface);index++;
		setBounds(32578, 10, 160, index, Interface);index++;
		setBounds(32580, 10, 160, index, Interface);index++;
	}
	
	private void configureLunar() {
		constructLunar();
		drawRune(30003, 208);
		drawRune(30004, 209);
		drawRune(30005, 210);
		drawRune(30006, 211);
		drawRune(30007, 212);
		drawRune(30008, 213);
		drawRune(30009, 214);
		drawRune(30010, 215);
		drawRune(30011, 216);
		drawRune(30012, 217);
		drawRune(30013, 218);
		drawRune(30014, 219);
		drawRune(30015, 220);
		drawRune(30016, 221);
		addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004, 64, "Bake Pie", "Bake pies without a stove", tda, 222, 16, 2);
		addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant", "Cure disease on farming patch", tda, 223, 4, 2);
		addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65, "Monster Examine", "Detect the combat statistics of a\\nmonster", tda, 224, 2, 2);
		addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005, 66, "NPC Contact", "Speak with varied NPCs", tda, 225, 0, 2);
		addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006, 67, "Cure Other", "Cure poisoned players", tda, 226, 8, 2);
		addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003, 67, "Humidify", "fills certain vessels with water", tda, 227, 0, 5);
		addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006, 68, "Training Teleport", "Teleport to training areas", tda, 228, 0, 5);
		addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69, "Bosses Teleport", "Teleports to various bosses", tda, 229, 0, 5);
		addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006, 70, "Skills Teleport", "Teleports to skilling areas", tda, 230, 0, 5);
		addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012, 70, "Cure Me", "Cures Poison", tda, 231, 0, 5);
		addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit", "Get a kit of hunting gear", tda, 232, 0, 5);
		addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004, 71, "Mini-Games Teleport", "Teleport to fun Mini-Games", tda, 233, 0, 5);
		addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72, "Pking Teleport", "Teleports to pking areas", tda, 234, 0, 5);
		addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012, 73, "Cure Group", "Cures Poison on players", tda, 235, 0, 5);
		addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74, "Stat Spy", "Cast on another player to see their\\nskill levels", tda, 236, 8, 2);
		addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74, "Skill teleport", "", tda, 237, 0, 5);
		addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75, "Tele Group Barbarian", "Teleports players to the Barbarian\\noutpost", tda, 238, 0, 5);
		addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005, 76, "Superglass Make", "Make glass without a furnace", tda, 239, 16, 2);
		addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004, 77, "City teleport", "", tda, 240, 0, 5);
		addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004, 78, "Tele Group Khazard", "Teleports players to Port khazard", tda, 241, 0, 5);
		addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78, "Dream", "Take a rest and restore hitpoints 3\\n times faster", tda, 242, 0, 5);
		addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004, 79, "String Jewellery", "String amulets without wool", tda, 243, 0, 5);
		addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004, 80, "Stat Restore Pot\\nShare", "Share a potion with up to 4 nearby\\nplayers", tda, 244, 0, 5);
		addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004, 81, "Magic Imbue", "Combine runes without a talisman", tda, 245, 0, 5);
		addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82, "Fertile Soil", "Fertilise a farming patch with super\\ncompost", tda, 246, 4, 2);
		addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83, "Boost Potion Share", "Shares a potion with up to 4 nearby\\nplayers", tda, 247, 0, 5);
		addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004, 84, "Fishing Guild Teleport", "Teleports you to the fishing guild", tda, 248, 0, 5);
		addLunar3RunesLargeBox(30234, 9075, 563, 555, 1, 2, 13, 30012, 30004, 85, "Tele Group Fishing\\nGuild", "Teleports players to the Fishing\\nGuild", tda, 249, 0, 5);
		addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010, 85, "Plank Make", "Turn Logs into planks", tda, 250, 16, 5);
		/******** Cut Off Limit **********/
		addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004, 86, "Catherby Teleport", "Teleports you to Catherby", tda, 251, 0, 5);
		addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004, 87, "Tele Group Catherby", "Teleports players to Catherby", tda, 252, 0, 5);
		addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004, 88, "Ice Plateau Teleport", "Teleports you to Ice Plateau", tda, 253, 0, 5);
		addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89, "Tele Group Ice Plateau", "Teleports players to Ice Plateau", tda, 254, 0, 5);
		addLunar3RunesBigBox(30282, 9075, 563, 561, 2, 1, 0, 30012, 30010, 90, "Energy Transfer", "Spend HP and SA energy to\\n give another SA and run energy", tda, 255, 8, 2);
		addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91, "Heal Other", "Transfer up to 75% of hitpoints\\n to another player", tda, 256, 8, 2);
		addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92, "Vengeance Other", "Allows another player to rebound\\ndamage to an opponent", tda, 257, 8, 2);
		addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006, 93, "Vengeance", "Rebound damage to an opponent", tda, 258, 0, 5);
		addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94, "Heal Group", "Transfer up to 75% of hitpoints to a group", tda, 259, 0, 5);
		addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95, "Spellbook Swap", "Change to another spellbook for 1\\nspell cast", tda, 260, 0, 5);
	}
	
	private void pouchCreation() {
		int totalScrolls = SummoningInterfaceData.pouchItems.length;
		int xPadding = 53;
		int yPadding = 57;
		int xPos = 13;
		int yPos = 20;
		RSInterface rsinterface = addTabInterface(63471);
		setChildren(8, rsinterface);
		addCloseButton(63450, 63451, 63452);
		addButtonWSpriteLoader(63475, 1005, "Transform Scrolls");
		addSpriteLoader(63474, 1002);
		addSpriteLoader(63476, 1003);
		addSpriteLoader(63473, 1004);
		addSpriteLoader(63472, 1001);
		RSInterface scroll = addTabInterface(63478);
		setChildren(4 * totalScrolls, scroll);
		scroll.interfaceShown = false;
		int req[] = { 1, 2, 3 };
		for (int i = 0; i < totalScrolls; i++) {
			addInAreaHoverSpriteLoader(63479 + i * 8, 1006, 48, 52, "nothing", -1, 0);
			addPouch(63480 + i * 8, req, 1, SummoningInterfaceData.pouchItems[i], SummoningInterfaceData.summoningLevelRequirements[i], SummoningInterfaceData.pouchNames[i], tda, i, 5);
			setBounds(63479 + i * 8, 36 + (i % 8) * xPadding, 0 + (i / 8) * yPadding, i, scroll);
			setBounds(63480 + i * 8, 43 + (i % 8) * xPadding, 1 + (i / 8) * yPadding, 156 + i, scroll);
		}
		for (int i = 0; i < SummoningInterfaceData.shards.length; i++) {
			addSummoningText(72001 + i, ""+SummoningInterfaceData.shards[i][0], 0xCCCBCB, false, true, 52, tda, 0);
			setBounds(72001 + i, SummoningInterfaceData.shards[i][1], SummoningInterfaceData.shards[i][2], 78 + i, scroll);
		}
		for (int i = 0; i < totalScrolls; i++) {
			int drawX = 5 + (i % 8) * xPadding;
			if (drawX > 292)
				drawX -= 90;
			int drawY = 55 + (i / 8) * yPadding;
			if (drawY > 160)
				drawY -= 80;
			setBounds(63481 + i * 8, drawX, drawY, 234+i, scroll);
		}
		scroll.parentID = 63478;
		scroll.id = 63478;
		scroll.atActionType = 0;
		scroll.contentType = 0;
		scroll.width = 474;
		scroll.height = 257;
		scroll.scrollMax = 570;
		setBounds(63472, xPos, yPos, 0, rsinterface);
		setBounds(63473, xPos + 9, yPos + 9, 1, rsinterface);
		setBounds(63474, xPos + 29, yPos + 10, 2, rsinterface);
		setBounds(63475, xPos + 79, yPos + 9, 3, rsinterface);
		setBounds(63476, xPos + 106, yPos + 10, 4, rsinterface);
		setBounds(63450, xPos + 460, yPos + 8, 5, rsinterface);
		setBounds(63451, xPos + 460, yPos + 8, 6, rsinterface);
		setBounds(63478, 0, yPos + 39, 7, rsinterface);
	}
	
	private void settingsInterface2() {
		RSInterface rsinterface = addInterface(26000);
		int x = 30;
		int y = 49;
		addSpriteLoader(26001, 1104);
		addText(26002, "Settings", 0xe4a146, true, true, 52, 2);
		// addInAreaHover(26003, 427, 428, 16, 16, "Close", 250, 3);
		addButton(26003, 4, -1, 427, 427, 15, 15, "Close", 427, 1);
		addText(26004, "Use New Function Keys.", 0xe4a146, false, true, 52, 0);
		addSprite(26005, 494);
		addSprite(26011, 495);
		addText(26006, "Display New Health Bars.", 0xe4a146, false, true, 52, 0);
		addText(26009, "Enable New Cursors.", 0xe4a146, false, true, 52, 0);
		addText(26015, "Display New Hitmarks.", 0xe4a146, false, true, 52, 0);
		addText(26028, "Display Hitpoints Above \\nHead.", 0xe4a146, false, true, 52, 0);
		addText(26025, "Display Usernames Above \\nHead.", 0xe4a146, false, true, 52, 0);
		addText(26030, "Enable Constitution.\\n(x10 damage)", 0xe4a146, false, true, 52, 0);
		addText(26032, "New Gameframe.", 0xe4a146, false, true, 52, 0);
		addText(26034, "Enable highlighting \\nyour username\\nwhen mentioned-\\nin chat.", 0xe4a146, false, true, 52, 0);
		addButton(26007, 4, -1, 484, 485, 15, 15, "Toggle function keys", 650, 1);
		addButton(26008, 4, -1, 484, 485, 15, 15, "Toggle health bars", 651, 1);
		addButton(26010, 4, -1, 484, 485, 15, 15, "Toggle cursors", 652, 1);
		addButton(26014, 4, -1, 484, 485, 15, 15, "Toggle hitmarks", 654, 1);
		addButton(26026, 4, -1, 484, 485, 15, 15, "Toggle hitpoints above head", 655, 1);
		addButton(26027, 4, -1, 484, 485, 15, 15, "Toggle usernames above head", 656, 1);
		addButton(26029, 4, -1, 484, 485, 15, 15, "Toggle constitution", 657, 1);
		addButton(26031, 4, -1, 484, 485, 15, 15, "Toggle gameframe", 658, 1);
		addButton(26033, 4, -1, 484, 485, 15, 15, "Toggle push-notifications", 659, 1);

		addCheckmarkHover(26054, 4, 26055, 576, 577, 57, 35, SETTING_CONFIGS[15], 1, "Low Detail", 26056, 577, 577, 26057, "", "", 12, 20);
		addCheckmarkHover(26058, 4, 26059, 578, 579, 57, 35, SETTING_CONFIGS[16], 1, "High Detail", 26060, 579, 579, 26061, "", "", 12, 20);
		
		addText(26050, "If the game runs slowly on your computer, try reducing these settings.", tda, 1, 0xeb981f, true, true);
		addText(26051, "@yel@Resizable", tda, 0, 0xeb981f, false, true);
		addText(26052, "@yel@Fullscreen", tda, 0, 0xeb981f, false, true);
		addText(26053, "@yel@Fixed", tda, 0, 0xeb981f, false, true);
		
		addText(26062, "@yel@Low Detail", tda, 0, 0xeb981f, false, true);
		addText(26063, "@yel@High Detail", tda, 0, 0xeb981f, false, true);
		
		/**
		 * Fixed buttons
		 */
		addHoverButton(26016, 486, 50, 39, "Fixed Mode", -1, 26017, 1);
		addHoveredButton(26017, 487, 50, 39, 26018);
		/**
		 * Resizable buttons
		 */
		addHoverButton(26019, 488, 50, 39, "Resizable Mode", -1, 26020, 1);
		addHoveredButton(26020, 489, 50, 39, 26021);
		/**
		 * Fullscreen buttons
		 */
		addHoverButton(26022, 490, 50, 39, "Fullscreen Mode", -1, 26023, 1);
		addHoveredButton(26023, 491, 50, 39, 26024);

		setChildren(55, rsinterface);
		int i = 0;
		// background
		setBounds(26001, x + 0, y + 0, i, rsinterface);
		i++;
		// more options text
		setBounds(26002, x + 230, y + 3, i, rsinterface);
		i++;
		// close button
		setBounds(26003, x + 427, y + 3, i, rsinterface);
		i++;
		// use new function key text
		setBounds(26004, x + 9, y + 107, i, rsinterface);
		i++;
		// new health bars text
		setBounds(26006, x + 9, y + 127, i, rsinterface);
		i++;
		// toggle function keys
		setBounds(26007, x + 154, y + 104, i, rsinterface);
		i++;
		// display fog toggle
		setBounds(26014, x + 154, y + 148, i, rsinterface);
		i++;
		// toggle health bars
		setBounds(26008, x + 154, y + 124, i, rsinterface);
		i++;
		// display damage text
		setBounds(26009, x + 175, y + 110, i, rsinterface);
		i++;
		// enable tweening text
		setBounds(26030, x + 9, y + 171, i, rsinterface);
		i++;
		setBounds(26032, x + 339, y + 110, i, rsinterface);
		i++;
		setBounds(26034, x + 339, y + 135, i, rsinterface);
		i++;
		// gameframe button
		setBounds(26031, x + 425, y + 110, i, rsinterface);
		i++;
		// hitmarks
		setBounds(26033, x + 425, y + 159, i, rsinterface);
		i++;
		// display health above heads
		setBounds(26028, x + 175, y + 135, i, rsinterface);
		i++;
		// display titles above heads
		setBounds(26025, x + 175, y + 167, i, rsinterface);
		i++;
		// toggle health above heads
		setBounds(26026, x + 315, y + 138, i, rsinterface);
		i++;
		// toggle title above heads
		setBounds(26027, x + 315, y + 170, i, rsinterface);
		i++;
		// display fog text
		setBounds(26015, x + 9, y + 152, i, rsinterface);
		i++;
		// toggle damage
		setBounds(26010, x + 315, y + 110, i, rsinterface);
		i++;
		// toggle tweening
		setBounds(26029, x + 154, y + 172, i, rsinterface);
		i++;
		// first row horizontal line
		setBounds(26005, x + 7, y + 120, i, rsinterface);
		i++;
		setBounds(26005, x + 7, y + 144, i, rsinterface);
		i++;
		setBounds(26005, x + 7, y + 168, i, rsinterface);
		i++;
		// second row horizontal line
		setBounds(26005, x + 170, y + 161, i, rsinterface);
		i++;
		setBounds(26005, x + 170, y + 130, i, rsinterface);
		i++;
		// first row vertical line
		setBounds(26011, x + 151, y + 105, i, rsinterface);
		i++;
		setBounds(26011, x + 151, y + 134, i, rsinterface);
		i++;
		setBounds(26011, x + 151, y + 161, i, rsinterface);
		i++;
		// second row vertical line
		setBounds(26011, x + 170, y + 161, i, rsinterface);
		i++;
		setBounds(26011, x + 170, y + 134, i, rsinterface);
		i++;
		setBounds(26011, x + 170, y + 105, i, rsinterface);
		i++;
		// third row vertical line
		setBounds(26011, x + 312, y + 105, i, rsinterface);
		i++;
		setBounds(26011, x + 312, y + 134, i, rsinterface);
		i++;
		setBounds(26011, x + 312, y + 161, i, rsinterface);
		i++;
		// fourth row vertical line
		setBounds(26011, x + 331, y + 105, i, rsinterface);
		i++;
		setBounds(26011, x + 331, y + 134, i, rsinterface);
		i++;
		setBounds(26011, x + 331, y + 161, i, rsinterface);
		i++;
		/**
		 * Fixed
		 */
		setBounds(26016, x + 30, y + 38, i, rsinterface);
		i++;
		setBounds(26017, x + 30, y + 38, i, rsinterface);
		i++;
		/**
		 * Resizable
		 */
		setBounds(26019, x + 110, y + 38, i, rsinterface);
		i++;
		setBounds(26020, x + 110, y + 38, i, rsinterface);
		i++;
		/**
		 * Fullscreen
		 */
		setBounds(26022, x + 190, y + 38, i, rsinterface);
		i++;
		setBounds(26023, x + 190, y + 38, i, rsinterface);
		i++;
		setBounds(26005, x + 280, y + 130, i, rsinterface);
		i++;
		setBounds(26050, 250, 133, i, rsinterface);
		i++;
		setBounds(26051, 142, 74, i, rsinterface);
		i++;
		setBounds(26052, 220, 74, i, rsinterface);
		i++;
		setBounds(26053, 70, 74, i, rsinterface);
		i++;
		setBounds(26054, 314, 88, i, rsinterface);
		i++;
		setBounds(26055, 314, 88, i, rsinterface);
		i++;
		setBounds(26058, 384, 88, i, rsinterface);
		i++;
		setBounds(26059, 384, 88, i, rsinterface);
		i++;
		setBounds(26062, 316, 75, i, rsinterface);
		i++;
		setBounds(26063, 385, 75, i, rsinterface);
	}
	
	private void mainGe() {
		RSInterface Interface = addTabInterface(24500);
		setChildren(51, Interface);
		addHoverButton(24541, "", 3, 138, 108, "Abort offer", 0, 24542, 1);
		addHoverButton(24543, "", 3, 138, 108, "View offer", 0, 24544, 1);
		addHoverButton(24545, "", 3, 138, 108, "Abort offer", 0, 24546, 1);
		addHoverButton(24547, "", 3, 138, 108, "View offer", 0, 24548, 1);
		addHoverButton(24549, "", 3, 138, 108, "Abort offer", 0, 24550, 1);
		addHoverButton(24551, "", 3, 138, 108, "View offer", 0, 24552, 1);
		addHoverButton(24553, "", 3, 138, 108, "Abort offer", 0, 24554, 1);
		addHoverButton(24555, "", 3, 138, 108, "View offer", 0, 24556, 1);
		addHoverButton(24557, "", 3, 138, 108, "Abort offer", 0, 24558, 1);
		addHoverButton(24559, "", 3, 138, 108, "View offer", 0, 24560, 1);
		addHoverButton(24561, "", 3, 138, 108, "Abort offer", 0, 24562, 1);
		addHoverButton(24563, "", 3, 138, 108, "View offer", 0, 24564, 1);
		
		addSprite(1, 24579, -1, "", false);
		addSprite(1, 24580, -1, "", false);
		addSprite(1, 24581, -1, "", false);
		addSprite(1, 24582, -1, "", false);
		addSprite(1, 24583, -1, "", false);
		addSprite(1, 24584, -1, "", false);
		
		addHDSprite(24501, 1107, 1107);
		addHoverButton(24502, CLOSE_BUTTON, CLOSE_BUTTON, 21, 21, "Close", 250,
				24503, 3);
		addHoveredButton(24503, CLOSE_BUTTON_HOVER, CLOSE_BUTTON_HOVER, 21, 21,
				24504);
		addHoverButton(24505, 1108, 1108, 50, 50, "Buy", 0, 24506, 1);
		addHoveredButton(24506, 1110, 1110, 50, 50, 24507);
		addHoverButton(24508, 1108, 1108, 50, 50, "Buy", 0, 24509, 1);
		addHoveredButton(24509, 1110, 1110, 50, 50, 24510);
		addHoverButton(24514, 1108, 1108, 50, 50, "Buy", 0, 24515, 1);
		addHoveredButton(24515, 1110, 1110, 50, 50, 24516);
		addHoverButton(24517, 1108, 1108, 50, 50, "Buy", 0, 24518, 1);
		addHoveredButton(24518, 1110, 1110, 50, 50, 24519);
		addHoverButton(24520, 1108, 1108, 50, 50, "Buy", 0, 24521, 1);
		addHoveredButton(24521, 1110, 1110, 50, 50, 24522);
		addHoverButton(24523, 1108, 1108, 50, 50, "Buy", 0, 24524, 1);
		addHoveredButton(24524, 1110, 1110, 50, 50, 24525);
		addHoverButton(24511, 1109, 1109, 50, 50, "Sell", 0, 24512, 1);
		addHoveredButton(24512, 1111, 1111, 50, 50, 24513);
		addHoverButton(24526, 1109, 1109, 50, 50, "Sell", 0, 24527, 1);
		addHoveredButton(24527, 1111, 1111, 50, 50, 24528);
		addHoverButton(24529, 1109, 1109, 50, 50, "Sell", 0, 24530, 1);
		addHoveredButton(24530, 1111, 1111, 50, 50, 24531);
		addHoverButton(24532, 1109, 1109, 50, 50, "Sell", 0, 24533, 1);
		addHoveredButton(24533, 1111, 1111, 50, 50, 24534);
		addHoverButton(24535, 1109, 1109, 50, 50, "Sell", 0, 24536, 1);
		addHoveredButton(24536, 1111, 1111, 50, 50, 24537);
		addHoverButton(24538, 1109, 1109, 50, 50, "Sell", 0, 24539, 1);
		addHoveredButton(24539, 1111, 1111, 50, 50, 24540);

		RSInterface add = addInterface(24567);
		addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
		add = addInterface(24569);
		addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
		add = addInterface(24571);
		addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
		add = addInterface(24573);
		addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
		add = addInterface(24575);
		addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
		add = addInterface(24577);
		addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");

		setBounds(24541, 30, 74, 0, Interface);
		setBounds(24543, 30, 74, 1, Interface);
		setBounds(24545, 186, 74, 2, Interface);
		setBounds(24547, 186, 74, 3, Interface);
		setBounds(24549, 342, 74, 4, Interface);
		setBounds(24551, 342, 74, 5, Interface);
		setBounds(24553, 30, 194, 6, Interface);
		setBounds(24555, 30, 194, 7, Interface);
		setBounds(24557, 186, 194, 8, Interface);
		setBounds(24559, 186, 194, 9, Interface);
		setBounds(24561, 339, 194, 10, Interface);
		setBounds(24563, 339, 194, 11, Interface);
		setBounds(24501, 4, 23, 12, Interface);
		setBounds(24579, 30 + 6, 74 + 30, 13, Interface);
		setBounds(24580, 186 + 6, 74 + 30, 14, Interface);
		setBounds(24581, 342 + 6, 74 + 30, 15, Interface);
		setBounds(24582, 30 + 6, 194 + 30, 16, Interface);
		setBounds(24583, 186 + 6, 194 + 30, 17, Interface);
		setBounds(24584, 342 + 6, 194 + 30, 18, Interface);
		setBounds(24502, 480, 32, 19, Interface);
		setBounds(24503, 480, 32, 20, Interface);
		setBounds(24505, 45, 115, 21, Interface);
		setBounds(24506, 45, 106, 22, Interface);
		setBounds(24508, 45, 234, 23, Interface);
		setBounds(24509, 45, 225, 24, Interface);
		setBounds(24511, 105, 115, 25, Interface);
		setBounds(24512, 105, 106, 26, Interface);
		setBounds(24514, 358, 115, 27, Interface);
		setBounds(24515, 358, 106, 28, Interface);
		setBounds(24517, 202, 234, 29, Interface);
		setBounds(24518, 202, 225, 30, Interface);
		setBounds(24520, 358, 234, 31, Interface);
		setBounds(24521, 358, 225, 32, Interface);
		setBounds(24523, 202, 115, 33, Interface);
		setBounds(24524, 202, 106, 34, Interface);
		setBounds(24526, 261, 115, 35, Interface);
		setBounds(24527, 261, 106, 36, Interface);
		setBounds(24529, 417, 115, 37, Interface);
		setBounds(24530, 417, 106, 38, Interface);
		setBounds(24532, 105, 234, 39, Interface);
		setBounds(24533, 105, 225, 40, Interface);
		setBounds(24535, 261, 234, 41, Interface);
		setBounds(24536, 261, 225, 42, Interface);
		setBounds(24538, 417, 234, 43, Interface);
		setBounds(24539, 417, 225, 44, Interface);

		setBounds(24567, 39, 106, 45, Interface);
		setBounds(24569, 46 + 156 - 7, 114 - 7, 46, Interface);
		setBounds(24571, 46 + 156 + 156 - 7, 114 - 7, 47, Interface);
		setBounds(24573, 39, 234 - 7, 48, Interface);
		setBounds(24575, 46 + 156 - 7, 234 - 7, 49, Interface);
		setBounds(24577, 46 + 156 + 156 - 7, 234 - 7, 50, Interface);
		for(int i = 0; i < 7; i++) {
			addInterface(32000+i);
			interfaceCache[32000+i].message = "";
			addInterface(33000+i);
			interfaceCache[33000+i].message = "";
			addInterface(33100+i);
			interfaceCache[33100+i].message = "";
		}
	}
	
	private void buyGe() {
		RSInterface rsinterface = addTabInterface(24600);
		int x = 9;
		addHDSprite(24601, 1112, 1112);
		addHoverButton(24602, CLOSE_BUTTON, CLOSE_BUTTON, 16, 16, "Close", 0,
				24603, 1);
		addHoveredButton(24603, CLOSE_BUTTON_HOVER, CLOSE_BUTTON_HOVER, 16, 16,
				24604);
		addHoverButton(24606, 1113, 1113, 13, 13, "Decrease Quantity", 0, 24607,
				1);
		addHoveredButton(24607, 1114, 1114, 13, 13, 24608);
		addHoverButton(24610, 1115, 1115, 13, 13, "Increase Quantity", 0, 24611,
				1);
		addHoveredButton(24611, 1116, 1116, 13, 13, 24612);
		addHoverButton(24614, 1117, 1117, 35, 25, "Add 1", 0, 24615, 1);
		addHoveredButton(24615, 1118, 1118, 35, 25, 24616);
		addHoverButton(24618, 1119, 1119, 35, 25, "Add 10", 0, 24619, 1);
		addHoveredButton(24619, 1120, 1120, 35, 25, 24620);
		addHoverButton(24622, 1121, 1121, 35, 25, "Add 100", 0, 24623, 1);
		addHoveredButton(24623, 1122, 1122, 35, 25, 24624);
		addHoverButton(24626, 1125, 1125, 35, 25, "Add 1000", 0, 24627, 1);
		addHoveredButton(24627, 1126, 1126, 35, 25, 24628);
		addHoverButton(24630, 1127, 1127, 35, 25, "Edit Quantity", -1, 24631, 1);
		addHoveredButton(24631, 1128, 1128, 35, 25, 24632);
		addHoverButton(24634, 1129, 1129, 35, 25, "Decrease Price", 0, 24635, 1);
		addHoveredButton(24635, 1130, 1130, 35, 25, 24636);
		addHoverButton(24638, 1131, 1131, 35, 25, "Offer Guild Price", 0, 24639,
				1);
		addHoveredButton(24639, 1132, 1132, 35, 25, 24640);
		addHoverButton(24642, 1127, 1127, 35, 25, "Edit Price", -1, 24643, 1);
		addHoveredButton(24643, 1128, 1128, 35, 25, 24644);
		addHoverButton(24646, 1133, 1133, 35, 25, "Increase Price", 0, 24647, 1);
		addHoveredButton(24647, 1134, 1134, 35, 25, 24648);
		addHoverButton(24650, 1135, 1135, 120, 43, "Confirm Offer", 0, 24651, 1);
		addHoveredButton(24651, 1136, 1136, 120, 43, 24652);

		addHoverButton(24654, 1137, 1137, 40, 36, "Search", 0, 24655, 1);
		addHoveredButton(24655, 1138, 1138, 40, 36, 24656);

		addHoverButton(24658, 1139, 1139, 29, 23, "Back", 0, 24659, 1);
		addHoveredButton(24659, 1140, 1140, 29, 23, 24660);
		addHoverButton(24662, 1113, 1113, 13, 13, "Decrease Price", 0, 24663, 1);
		addHoveredButton(24663, 1114, 1114, 13, 13, 24664);
		addHoverButton(24665, 1115, 1115, 13, 13, "Increase Price", 0, 24666, 1);
		addHoveredButton(24666, 1116, 1116, 13, 13, 24667);
		addText(24669, "Choose an item to exchange", tda, 0, 0x96731A, false,
				true);
		addText(24670, "Click the icon to the left to search for items.", tda,
				0, 0x958E60, false, true);
		addText(24671, "0", tda, 0, 0xB58338, true, true);
		addText(24672, "1 gp", tda, 0, 0xB58338, true, true);
		addText(24673, "0 gp", tda, 0, 0xB58338, true, true);
		//RSInterface add = addInterface(24680);

		addItemOnInterface(24680, 3323, new String[]{null});
		//addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");


		addText(24682, "N/A", tda, 0, 0xB58338, false, true);
		rsinterface.totalChildren(42);
		rsinterface.child(0, 24601, 4 + x, 23);
		rsinterface.child(1, 24602, 464 + x, 33);
		rsinterface.child(2, 24603, 464 + x, 33);
		rsinterface.child(3, 24606, 46 + x, 184);
		rsinterface.child(4, 24607, 46 + x, 184);
		rsinterface.child(5, 24610, 226 + x, 184);
		rsinterface.child(6, 24611, 226 + x, 184);
		rsinterface.child(7, 24614, 43 + x, 208);
		rsinterface.child(8, 24615, 43 + x, 208);
		rsinterface.child(9, 24618, 84 + x, 208);
		rsinterface.child(10, 24619, 84 + x, 208);
		rsinterface.child(11, 24622, 125 + x, 208);
		rsinterface.child(12, 24623, 125 + x, 208);
		rsinterface.child(13, 24626, 166 + x, 208);
		rsinterface.child(14, 24627, 166 + x, 208);
		rsinterface.child(15, 24630, 207 + x, 208);
		rsinterface.child(16, 24631, 207 + x, 208);
		rsinterface.child(17, 24634, 260 + x, 208);
		rsinterface.child(18, 24635, 260 + x, 208);
		rsinterface.child(19, 24638, 316 + x, 208);
		rsinterface.child(20, 24639, 316 + x, 208);
		rsinterface.child(21, 24642, 357 + x, 208);
		rsinterface.child(22, 24643, 357 + x, 208);
		rsinterface.child(23, 24646, 413 + x, 208);
		rsinterface.child(24, 24647, 413 + x, 208);
		rsinterface.child(25, 24650, 191 + x, 273);
		rsinterface.child(26, 24651, 191 + x, 273);
		rsinterface.child(27, 24654, 93 + x, 95);
		rsinterface.child(28, 24655, 93 + x, 95);
		rsinterface.child(29, 24658, 19 + x, 284);
		rsinterface.child(30, 24659, 19 + x, 284);
		rsinterface.child(31, 24662, 260 + x, 184);
		rsinterface.child(32, 24663, 260 + x, 184);
		rsinterface.child(33, 24665, 435 + x, 184);
		rsinterface.child(34, 24666, 435 + x, 184);
		rsinterface.child(35, 24669, 202 + x, 71);
		rsinterface.child(36, 24670, 202 + x, 98);
		rsinterface.child(37, 24671, 142 + x, 185);
		rsinterface.child(38, 24672, 354 + x, 185);
		rsinterface.child(39, 24673, 252 + x, 246);
		rsinterface.child(40, 24680, 97 + x, 97);
		rsinterface.child(41, 24682, 121, 136);
	}
	
	private void sellGe() {
		RSInterface rsinterface = addTabInterface(24700);
		int x = 9;
		addHDSprite(24701, 1141, 1141);
		addHoverButton(24702, CLOSE_BUTTON, CLOSE_BUTTON_HOVER, 16, 16,
				"Close", 0, 24703, 1);
		addHoveredButton(24703, CLOSE_BUTTON_HOVER, CLOSE_BUTTON_HOVER, 16, 16,
				24704);
		addHoverButton(24706, 1113, 1113, 13, 13, "Decrease Quantity", 0, 24707,
				1);
		addHoveredButton(24707, 1114, 1114, 13, 13, 24708);
		addHoverButton(24710, 1115, 1115, 13, 13, "Increase Quantity", 0, 24711,
				1);
		addHoveredButton(24711, 1116, 1116, 13, 13, 24712);
		addHoverButton(24714, 1117, 1117, 35, 25, "Sell 1", 0, 24715, 1);
		addHoveredButton(24715, 1118, 1118, 35, 25, 24716);
		addHoverButton(24718, 1119, 1119, 35, 25, "Sell 10", 0, 24719, 1);
		addHoveredButton(24719, 1120, 1120, 35, 25, 24720);
		addHoverButton(24722, 1121, 1121, 35, 25, "Sell 100", 0, 24723, 1);
		addHoveredButton(24723, 1122, 1122, 35, 25, 24724);
		addHoverButton(24726, 1123, 1123, 35, 25, "Sell All", 0, 24727, 1);
		addHoveredButton(24727, 1124, 1124, 35, 25, 24728);
		addHoverButton(24730, 1127, 1127, 35, 25, "Edit Quantity", -1, 24731, 1);
		addHoveredButton(24731, 1128, 1128, 35, 25, 24732);
		addHoverButton(24734, 1129, 1129, 35, 25, "Decrease Price", 0, 24735, 1);
		addHoveredButton(24735, 1130, 1130, 35, 25, 24736);
		addHoverButton(24738, 1131, 1131, 35, 25, "Offer Guild Price", 0, 24739,
				1);
		addHoveredButton(24739, 1132, 1132, 35, 25, 24740);
		addHoverButton(24742, 1127, 1127, 35, 25, "Edit Price", -1, 24743, 1);
		addHoveredButton(24743, 1128, 1128, 35, 25, 24744);
		addHoverButton(24746, 1133, 1133, 35, 25, "Increase Price", 0, 24747, 1);
		addHoveredButton(24747, 1134, 1134, 35, 25, 24748);
		addHoverButton(24750, 1135, 1135, 120, 43, "Confirm Offer", 0, 24751, 1);
		addHoveredButton(24751, 1136, 1136, 120, 43, 24752);
		addHoverButton(24758, 1139, 1139, 29, 23, "Back", 0, 24759, 1);
		addHoveredButton(24759, 1140, 1140, 29, 23, 24760);
		addHoverButton(24762, 1113, 1113, 13, 13, "Decrease Price", 0, 24763, 1);
		addHoveredButton(24763, 1114, 1114, 13, 13, 24764);
		addHoverButton(24765, 1115, 1115, 13, 13, "Increase Price", 0, 24766, 1);
		addHoveredButton(24766, 1116, 1116, 13, 13, 24767);
		addText(24769, "Choose an item to exchange", tda, 0, 0x96731A, false,
				true);
		addText(24770, "Select an item from your inventory to sell.", tda, 0,
				0x958E60, false, true);
		addText(24771, "0", tda, 0, 0xB58338, true, true);
		addText(24772, "1 gp", tda, 0, 0xB58338, true, true);
		addText(24773, "0 gp", tda, 0, 0xB58338, true, true);
		addItemOnInterface(24780, 3323, new String[]{null});
		addText(24782, "N/A", tda, 0, 0xB58338, false, true);
		rsinterface.totalChildren(40);
		rsinterface.child(0, 24701, 4 + x, 23);
		rsinterface.child(1, 24702, 464 + x, 33);
		rsinterface.child(2, 24703, 464 + x, 33);
		rsinterface.child(3, 24706, 46 + x, 184);
		rsinterface.child(4, 24707, 46 + x, 184);
		rsinterface.child(5, 24710, 226 + x, 184);
		rsinterface.child(6, 24711, 226 + x, 184);
		rsinterface.child(7, 24714, 43 + x, 208);
		rsinterface.child(8, 24715, 43 + x, 208);
		rsinterface.child(9, 24718, 84 + x, 208);
		rsinterface.child(10, 24719, 84 + x, 208);
		rsinterface.child(11, 24722, 125 + x, 208);
		rsinterface.child(12, 24723, 125 + x, 208);
		rsinterface.child(13, 24726, 166 + x, 208);
		rsinterface.child(14, 24727, 166 + x, 208);
		rsinterface.child(15, 24730, 207 + x, 208);
		rsinterface.child(16, 24731, 207 + x, 208);
		rsinterface.child(17, 24734, 260 + x, 208);
		rsinterface.child(18, 24735, 260 + x, 208);
		rsinterface.child(19, 24738, 316 + x, 208);
		rsinterface.child(20, 24739, 316 + x, 208);
		rsinterface.child(21, 24742, 357 + x, 208);
		rsinterface.child(22, 24743, 357 + x, 208);
		rsinterface.child(23, 24746, 413 + x, 208);
		rsinterface.child(24, 24747, 413 + x, 208);
		rsinterface.child(25, 24750, 191 + x, 273);
		rsinterface.child(26, 24751, 191 + x, 273);
		rsinterface.child(27, 24758, 19 + x, 284);
		rsinterface.child(28, 24759, 19 + x, 284);
		rsinterface.child(29, 24762, 260 + x, 184);
		rsinterface.child(30, 24763, 260 + x, 184);
		rsinterface.child(31, 24765, 435 + x, 184);
		rsinterface.child(32, 24766, 435 + x, 184);
		rsinterface.child(33, 24769, 202 + x, 71);
		rsinterface.child(34, 24770, 202 + x, 98);
		rsinterface.child(35, 24771, 142 + x, 185);
		rsinterface.child(36, 24772, 354 + x, 185);
		rsinterface.child(37, 24773, 252 + x, 246);
		rsinterface.child(38, 24780, 97 + x, 97);
		rsinterface.child(39, 24782, 121, 136);
	}
	
	private void collectSellGe() {
		RSInterface rsinterface = addTabInterface(54700);
		int x = 9;
		addHDSprite(54701, 1142, 1142);

		addHoverButton(54702, CLOSE_BUTTON, CLOSE_BUTTON, 16, 16, "Close", 0,
				54703, 1);
		addHoveredButton(54703, CLOSE_BUTTON_HOVER, CLOSE_BUTTON_HOVER, 16, 16,
				54704);
		addHoverButton(54758, 1139, 1139, 29, 23, "Back", 0, 54759, 1);
		addHoveredButton(54759, 1140, 1140, 29, 23, 54760);
		addText(54769, "Choose an item to exchange", tda, 0, 0x96731A, false,
				true);
		addText(54770, "Select an item from your invertory to sell.", tda, 0,
				0x958E60, false, true);
		addText(54771, "0", tda, 0, 0xB58338, true, true);
		addText(54772, "1 gp", tda, 0, 0xB58338, true, true);
		addText(54773, "0 gp", tda, 0, 0xB58338, true, true);
		addHoverButton(54793, 1144, 1144, 40, 36, "[GE]", 0, 54794, 1);
		addHoveredButton(54794, 1143, 1143, 40, 36, 54795);
		addHoverButton(54796, 1144, 1144, 40, 36, "[GE]", 0, 54797, 1);
		addHoveredButton(54797, 1143, 1143, 40, 36, 54798);
		addItemOnInterface(54780, 2903, new String[]{null});
		addItemOnInterface(54781, 2903, new String[]{"Collect"});
		addItemOnInterface(54782, 2904, new String[]{"Collect"});
		addText(54784, "", tda, 0, 0xFFFF00, false, true);
		addText(54785, "", tda, 0, 0xFFFF00, false, true);
		addText(54787, "N/A", tda, 0, 0xB58338, false, true);
		addText(54788, "", tda, 0, 0xFFFF00, true, true);
		addText(54789, "", tda, 0, 0xFFFF00, true, true);
		addHoverButton(54800, 1145, 1145, 20, 20, "Abort offer", 0, 54801, 1);
		addHoveredButton(54801, 1146, 1146, 20, 20, 54802);
		rsinterface.totalChildren(24);
		rsinterface.child(0, 54701, 4 + x, 23);// 385, 260
		rsinterface.child(1, 54702, 464 + x, 33);// 435, 260
		rsinterface.child(2, 54703, 464 + x, 33);
		rsinterface.child(3, 54758, 19 + x, 284);
		rsinterface.child(4, 54759, 19 + x, 284);
		rsinterface.child(5, 54769, 202 + x, 71);
		rsinterface.child(6, 54770, 202 + x, 98);
		rsinterface.child(7, 54771, 142 + x, 185);
		rsinterface.child(8, 54772, 354 + x, 185);
		rsinterface.child(9, 54773, 252 + x, 246);
		rsinterface.child(10, 54793, 386 + x, 256 + 23);
		rsinterface.child(11, 54794, 386 + x, 256 + 23);
		rsinterface.child(12, 54796, 435 + x, 256 + 23);
		rsinterface.child(13, 54797, 435 + x, 256 + 23);
		rsinterface.child(14, 54780, 97 + x, 97);
		rsinterface.child(15, 54781, 385 + 4 + x, 260 + 23);
		rsinterface.child(16, 54782, 435 + 4 + x, 260 + 23);
		rsinterface.child(17, 54784, 385 + 4 + x, 260 + 23);
		rsinterface.child(18, 54785, 435 + 4 + x, 260 + 23);
		rsinterface.child(19, 54787, 108, 136);
		rsinterface.child(20, 54788, 214 + x, 249 + 23);
		rsinterface.child(21, 54789, 214 + x, 263 + 23);
		rsinterface.child(22, 54800, 345 + x, 250 + 23);
		rsinterface.child(23, 54801, 345 + x, 250 + 23);
	}

	private void collectBuyGe() {
		RSInterface rsinterface = addTabInterface(53700);
		int x = 9;
		addHDSprite(53701, 1147, 1147);
		addHoverButton(53702, CLOSE_BUTTON, CLOSE_BUTTON, 16, 16, "Close", 0,
				53703, 1);
		addHoveredButton(53703, CLOSE_BUTTON_HOVER, CLOSE_BUTTON_HOVER, 16, 16,
				53704);
		addHoverButton(53758, 1139, 1139, 29, 23, "Back", 0, 53759, 1);
		addHoveredButton(53759, 1140, 1140, 29, 23, 53760);
		addText(53769, "Choose an item to exchange", tda, 0, 0x96731A, false,
				true);
		addText(53770, "Select an item from your invertory to sell.", tda, 0,
				0x958E60, false, true);
		addText(53771, "0", tda, 0, 0xB58338, true, true);
		addText(53772, "1 gp", tda, 0, 0xB58338, true, true);
		addText(53773, "0 gp", tda, 0, 0xB58338, true, true);
		addHoverButton(53793, 1144, 1144, 40, 36, "[GE]", 0, 53794, 1);
		addHoveredButton(53794, 1143, 1143, 40, 36, 53795);
		addHoverButton(53796, 1144, 1144, 40, 36, "[GE]", 0, 53797, 1);
		addHoveredButton(53797, 1143, 1143, 40, 36, 53798);
		addItemOnInterface(53780, 2901, new String[]{null});
		addItemOnInterface(53781, 2901, new String[]{"Collect"});
		addItemOnInterface(53782, 2902, new String[]{"Collect"});
		addText(53784, "", tda, 0, 0xFFFF00, false, true);
		addText(53785, "", tda, 0, 0xFFFF00, false, true);
		addText(53787, "N/A", tda, 0, 0xB58338, false, true);
		addText(53788, "", tda, 0, 0xFFFF00, true, true);
		addText(53789, "", tda, 0, 0xFFFF00, true, true);
		addHoverButton(53800, 1145, 1145, 20, 20, "Abort offer", 0, 53801, 1);
		addHoveredButton(53801, 1146, 1146, 20, 20, 53802);
		rsinterface.totalChildren(24);
		rsinterface.child(0, 53701, 4 + x, 23);// 385, 260
		rsinterface.child(1, 53702, 464 + x, 33);// 435, 260
		rsinterface.child(2, 53703, 464 + x, 33);
		rsinterface.child(3, 53758, 19 + x, 284);
		rsinterface.child(4, 53759, 19 + x, 284);
		rsinterface.child(5, 53769, 202 + x, 71);
		rsinterface.child(6, 53770, 202 + x, 98);
		rsinterface.child(7, 53771, 142 + x, 185);
		rsinterface.child(8, 53772, 354 + x, 185);
		rsinterface.child(9, 53773, 252 + x, 246);
		rsinterface.child(10, 53793, 386 + x, 256 + 23);
		rsinterface.child(11, 53794, 386 + x, 256 + 23);
		rsinterface.child(12, 53796, 435 + x, 256 + 23);
		rsinterface.child(13, 53797, 435 + x, 256 + 23);
		rsinterface.child(14, 53780, 97 + x, 97);
		rsinterface.child(15, 53781, 385 + 4 + x, 260 + 23);
		rsinterface.child(16, 53782, 435 + 4 + x, 260 + 23);
		rsinterface.child(17, 53784, 385 + 4 + x, 260 + 23);
		rsinterface.child(18, 53785, 435 + 4 + x, 260 + 23);
		rsinterface.child(19, 53787, 108, 136);
		rsinterface.child(20, 53788, 214 + x, 249 + 23);
		rsinterface.child(21, 53789, 214 + x, 263 + 23);
		rsinterface.child(22, 53800, 345 + x, 250 + 23);
		rsinterface.child(23, 53801, 345 + x, 250 + 23);
	}
	
	public void buildPlayerMenu(ArrayList<Account> accountList) {
		RSInterface rsi = addTabInterface(31000);
		setChildren(accountList.size(), rsi);
		int interId = 31001;
		int frame = 0;
		int x = 157, y = 306;
		for (Account a_ : accountList) {
			addAPlayerHead(interId, a_);
			setBounds(interId, x - 20, y - 10, frame, rsi);
			frame++;
			interId++;
			
			x += 50;//Configuration.CHARACTERS_SEPARATOR_WIDTH;
		}
	}
	
	private void quickPrayersInterface() {
		int frame = 0;
		RSInterface tab = addTabInterface(17200);
		addSpriteLoader(17201, 1188);
		addText(17230, "Select your quick prayers:", tda, 0, 0xff981f, false, true);
		addTransparentSpriteWSpriteLoader(17229, 1189, 50);
		int i = 17202;
		for (int j = 630; j <= 659; j++) {
			addConfigButtonWSpriteLoader(i, 17200, 1185, 1184, 14, 15, "Select", 0, 1, j);
			i += i == 17229 ? 50 : 1;
		}

		addHoverButtonWSpriteLoader(17231, 1186, 190, 24, "Confirm Selection", -1, 17232, 1);
		addHoveredImageWSpriteLoader(17232, 1187, 190, 24, 17233);

		setChildren(62, tab);
		setBounds(25001, 5, 28, frame++, tab);
		setBounds(25003, 44, 28, frame++, tab);
		setBounds(25005, 79, 31, frame++, tab);
		setBounds(25007, 116, 30, frame++, tab);
		setBounds(25009, 153, 29, frame++, tab);
		setBounds(25011, 5, 68, frame++, tab);
		setBounds(25013, 44, 67, frame++, tab);
		setBounds(25015, 79, 69, frame++, tab);
		setBounds(25017, 116, 70, frame++, tab);
		setBounds(25019, 154, 70, frame++, tab);
		setBounds(25021, 4, 104, frame++, tab);
		setBounds(25023, 44, 107, frame++, tab);
		setBounds(25025, 81, 105, frame++, tab);
		setBounds(25027, 117, 105, frame++, tab);
		setBounds(25029, 156, 107, frame++, tab);
		setBounds(25031, 5, 145, frame++, tab);
		setBounds(25033, 43, 144, frame++, tab);
		setBounds(25035, 83, 144, frame++, tab);
		setBounds(25037, 115, 141, frame++, tab);
		setBounds(25039, 154, 144, frame++, tab);
		setBounds(25041, 5, 180, frame++, tab);
		setBounds(25043, 41, 178, frame++, tab);
		setBounds(25045, 79, 183, frame++, tab);
		setBounds(25047, 116, 178, frame++, tab);
		setBounds(25049, 161, 180, frame++, tab);
		setBounds(25051, 4, 219, frame++, tab);
		setBounds(25105, 44, 214, frame++, tab);
		setBounds(25109, 80, 214, frame++, tab);
		setBounds(17229, 0, 25, frame++, tab);
		setBounds(17201, 0, 22, frame++, tab);
		setBounds(17201, 0, 237, frame++, tab);
		setBounds(17202, 2, 25, frame++, tab);
		setBounds(17203, 41, 25, frame++, tab);
		setBounds(17204, 76, 25, frame++, tab);
		setBounds(17205, 113, 25, frame++, tab);
		setBounds(17206, 150, 25, frame++, tab);
		setBounds(17207, 2, 65, frame++, tab);
		setBounds(17208, 41, 65, frame++, tab);
		setBounds(17209, 76, 65, frame++, tab);
		setBounds(17210, 113, 65, frame++, tab);
		setBounds(17211, 150, 65, frame++, tab);
		setBounds(17212, 2, 102, frame++, tab);
		setBounds(17213, 41, 102, frame++, tab);
		setBounds(17214, 76, 102, frame++, tab);
		setBounds(17215, 113, 102, frame++, tab);
		setBounds(17216, 150, 102, frame++, tab);
		setBounds(17217, 2, 141, frame++, tab);
		setBounds(17218, 41, 141, frame++, tab);
		setBounds(17219, 76, 141, frame++, tab);
		setBounds(17220, 113, 141, frame++, tab);
		setBounds(17221, 150, 141, frame++, tab);
		setBounds(17222, 2, 177, frame++, tab);
		setBounds(17223, 41, 177, frame++, tab);
		setBounds(17224, 76, 177, frame++, tab);
		setBounds(17225, 113, 177, frame++, tab);
		setBounds(17226, 150, 177, frame++, tab);
		setBounds(17227, 1, 211, frame++, tab);
		setBounds(17230, 5, 5, frame++, tab);
		setBounds(17231, 0, 237, frame++, tab);
		setBounds(17232, 0, 237, frame++, tab);
		setBounds(17279, 41, 211, frame++, tab);
		setBounds(17280, 76, 211, frame++, tab);
	}
	
	private void quickCursesInterface() {
		int frame = 0;
		RSInterface tab = addTabInterface(17234);
		addText(17235, "Select your quick curses:", tda, 0, 0xff981f, false,
				true);
		int i = 17202;
		for (int j = 630; i <= 17222 || j <= 656; j++) {
			addConfigButtonWSpriteLoader(i, 17200,1185, 1184, 14, 15, "Select", 0, 1, j);
			i++;
		}

		addHoverButtonWSpriteLoader(17231, 1186, 190, 24, "Confirm Selection", -1, 17232, 1);
		addHoveredImageWSpriteLoader(17232, 1187, 190, 24, 17233);


		setChildren(46, tab);
		setBounds(32504, 5, 8+17, frame++, tab);
		setBounds(32506, 44, 8+20, frame++, tab);
		setBounds(32508, 79, 11+19, frame++, tab);
		setBounds(32510, 116, 10+18, frame++, tab);
		setBounds(32512, 153, 9+20, frame++, tab);
		setBounds(32514, 5, 48+18, frame++, tab);
		setBounds(32516, 44, 47+21, frame++, tab);
		setBounds(32518, 79, 49+20, frame++, tab);	
		setBounds(32520, 116, 50+19, frame++, tab);
		setBounds(32522, 154, 50+20, frame++, tab);		
		setBounds(32524, 4, 84+21, frame++, tab);		
		setBounds(32526, 44, 87+19, frame++, tab);		
		setBounds(32528, 81, 85+20, frame++, tab);	
		setBounds(32530, 117, 85+20, frame++, tab);					
		setBounds(32532, 156, 87+18, frame++, tab);			
		setBounds(32534, 5, 125+19, frame++, tab);			
		setBounds(32536, 43, 124+19, frame++, tab);		
		setBounds(32538, 83, 124+20, frame++, tab);										
		setBounds(32540, 115, 125+21, frame++, tab);
		setBounds(32542, 154, 126+22, frame++, tab);
		setBounds(17229, 0, 25, frame++, tab);
		setBounds(17201, 0, 22, frame++, tab);
		setBounds(17201, 0, 237, frame++, tab);
		setBounds(17202, 2, 25, frame++, tab);
		setBounds(17203, 41, 25, frame++, tab);
		setBounds(17204, 76, 25, frame++, tab);
		setBounds(17205, 113, 25, frame++, tab);
		setBounds(17206, 150, 25, frame++, tab);
		setBounds(17207, 2, 65, frame++, tab);
		setBounds(17208, 41, 65, frame++, tab);
		setBounds(17209, 76, 65, frame++, tab);
		setBounds(17210, 113, 65, frame++, tab);
		setBounds(17211, 150, 65, frame++, tab);
		setBounds(17212, 2, 102, frame++, tab);
		setBounds(17213, 41, 102, frame++, tab);
		setBounds(17214, 76, 102, frame++, tab);
		setBounds(17215, 113, 102, frame++, tab);
		setBounds(17216, 150, 102, frame++, tab);
		setBounds(17217, 2, 141, frame++, tab);
		setBounds(17218, 41, 141, frame++, tab);
		setBounds(17219, 76, 141, frame++, tab);
		setBounds(17220, 113, 141, frame++, tab);
		setBounds(17221, 150, 141, frame++, tab);
		setBounds(17235, 5, 5, frame++, tab);
		setBounds(17231, 0, 237, frame++, tab);
		setBounds(17232, 0, 237, frame++, tab);
	}
}
