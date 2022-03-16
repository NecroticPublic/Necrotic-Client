package org.necrotic.client.graphics.rsinterface;


/**
 * Only cause I have no fucking client knowledge whatsoever so let's have fun cheapfuckin
 * @author te12ga8
 *
 */
public class MagicInterfaceData {

	/**
	 * Because cache data is too mainstream
	 * @param childId	Child id for RSInterface
	 * @param type	The data type to fetch
	 *  spellUsableOn = 1: Items on ground
		spellUsableOn = 2: NPCs
		spellUsableOn = 4: Objects
		spellUsableOn = 8: Players
		spellUsableOn = 16: Items, in inventory
		1+2 = items on ground and npcs etc
	 * @return Spelldata
	 */
	public static String getSpellData(int childId, String type) {
		String spellName = "";
		String spellUsableOn = "10";
		String selectedActionName = "Cast on";
		switch(childId) {
		case 1152:
			spellName = "Wind strike";
			break;
		case 1153:
			spellName = "Confuse";
			break;
		case 1154:
			spellName = "Water strike";
			break;
		case 1155:
			spellName = "Enchant Lvl-1 Jewelry";
			spellUsableOn = "16";
			break;
		case 1156:
			spellName = "Earth strike";
			break;
		case 1157:
			spellName = "Weaken";
			break;
		case 1158:
			spellName = "Fire strike";
			break;
			//1159 bones to peaches, clickbutton only
		case 1160:
			spellName = "Wind bolt";
			break;
		case 1161:
			spellName = "Curse";
			break;
		case 1572:
			spellName = "Bind";
			break;
		case 1162:
			spellName = "Low Level Alchemy";
			spellUsableOn = "16";
			break;
		case 1163:
			spellName = "Water bolt";
			break;
		case 1165:
			spellName = "Enchant Lvl-2 Jewelry";
			spellUsableOn = "16";
			break;
		case 1166:
			spellName = "Earth bolt";
			break;
		case 1168:
			spellName = "Telekinetic grab";
			spellUsableOn = "1";
			break;
		case 1169:
			spellName = "Fire bolt";
			break;
		case 1171:
			spellName = "Crumble undead";
			spellUsableOn = "2";
			break;
			//Houseteleport
		case 1172:
			spellName = "Wind blast";
			break;
		case 1173:
			spellName = "Superheat item";
			spellUsableOn = "16";
			break;
		case 1175:
			spellName = "Water blast";
			break;
		case 1176:
			spellName = "Enchant Lvl-3 Jewelry";
			spellUsableOn = "16";
			break;
		case 1539:
			spellName = "Iban blast";
			break;
		case 1582:
			spellName = "Snare";
			break;
		case 12037:
			spellName = "Magic Dart";
			break;
		case 1177:
			spellName = "Earth blast";
			break;
		case 1178:
			spellName = "High Level Alchemy";
			spellUsableOn = "16";
			break;
		case 1179:
			spellName = "Charge Water orb";
			spellUsableOn = "4";
			break;
		case 1180:
			spellName = "Enchant Lvl-4 Jewelry";
			spellUsableOn = "16";
			break;
		case 1181:
			spellName = "Fire blast";
			break;
		case 1182:
			spellName = "Charge Earth orb";
			spellUsableOn = "4";
			break;
		case 1190:
			spellName = "Saradomin strike";
			break;
		case 1191:
			spellName = "Claws of Guthix";
			break;
		case 1192:
			spellName = "Flames of Zamorak";
			break;
		case 1183:
			spellName = "Wind wave";
			break;
		case 1184:
			spellName = "Charge Fire orb";
			spellUsableOn = "4";
			break;
		case 1185:
			spellName = "Water wave";
			break;
		case 1186:
			spellName = "Charge Air orb";
			spellUsableOn = "4";
			break;
		case 1542:
			spellName = "Vulnerability";
			break;
		case 1187:
			spellName = "Enchant Lvl-5 Jewelry";
			spellUsableOn = "16";
			break;
		case 1188:
			spellName = "Earth wave";
			break;
		case 1543:
			spellName = "Enfeeble";
			break;
		case 12425:
			spellName = "Teleother Lumbridge";
			break;
		case 1189:
			spellName = "Fire wave";
			break;
		case 1592:
			spellName = "Entangle";
			break;
		case 1562:
			spellName = "Stun";
			break;
		case 12435:
			spellName = "Teleother Falador";
			break;
		case 12445:
			spellName = "Tele Block";
			break;
		case 6003:
			spellName = "Enchant Lvl-6 Jewelry";
			spellUsableOn = "16";
			break;
		case 12455:
			spellName = "Teleother Camelot";
			break;
			/**
			 * Ancients
			 */
		case 12939:
			spellName = "Smoke Rush";
			break;
		case 12987:
			spellName = "Shadow Rush";
			break;
		case 12901:
			spellName = "Blood Rush";
			break;
		case 12861:
			spellName = "Ice Rush";
			break;
		case 21744:
			spellName = "Miasmic Rush";
			break;
		case 12963:
			spellName = "Smoke Burst";
			break;
		case 13011:
			spellName = "Shadow Burst";
			break;
		case 12919:
			spellName = "Blood Burst";
			break;
		case 12881:
			spellName = "Ice Burst";
			break;
		case 22168:
			spellName = "Miasmic Burst";
			break;
		case 12951:
			spellName = "Smoke Blitz";
			break;
		case 12999:
			spellName = "Shadow Blitz";
			break;
		case 12911:
			spellName = "Blood Blitz";
			break;
		case 12871:
			spellName = "Ice Blitz";
			break;
		case 21745:
			spellName = "Miasmic Blitz";
			break;
		case 12975:
			spellName = "Smoke Barrage";
			break;
		case 13023:
			spellName = "Shadow Barrage";
			break;
		case 12929:
			spellName = "Blood Barrage";
			break;
		case 12891:
			spellName = "Ice Barrage";
			break;
		case 21746:
			spellName = "Miasmic Barrage";
			break;
			/*
			 * Lunar
			 */
		case 30017:
			spellName = "Bake Pie";
			spellUsableOn = "16";
			break;
		case 30032:
			spellName = "Monster Examine";
			spellUsableOn = "2";
			break;
		case 30040:
			spellName = "NPC Contact";
			spellUsableOn = "2";
			break;
		case 30048:
			spellName = "Cure Other";
			spellUsableOn = "8";
			break;
		case 30130:
			spellName = "Stat Spy";
			spellUsableOn = "8";
			break;
		case 30154:
			spellName = "Superglass Make";
			spellUsableOn = "16";
			break;
		case 30282:
			spellUsableOn = "8";
			spellName = "Energy Transfer";
			break;
		case 30290:
			spellUsableOn = "8";
			spellName = "Heal Other";
			break;
		case 30298:
			spellUsableOn = "8";
			spellName = "Vengeance Other";
			break;
		}
		if(type.equalsIgnoreCase("spellname"))
			return spellName;
		else if(type.equalsIgnoreCase("spellusableon"))
			return spellUsableOn;
		else if(type.equalsIgnoreCase("selectedactionname"))
			return selectedActionName;
		return "";
	}
}
