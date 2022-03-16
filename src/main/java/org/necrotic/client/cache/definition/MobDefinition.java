package org.necrotic.client.cache.definition;

import org.necrotic.Configuration;
import org.necrotic.client.Client;
import org.necrotic.client.FrameReader;
import org.necrotic.client.List;
import org.necrotic.client.cache.Archive;
import org.necrotic.client.io.ByteBuffer;
import org.necrotic.client.world.Model;

public final class MobDefinition {

	private static MobDefinition[] cache;
	private static int cacheIndex;
	public static Client clientInstance;
	public static List mruNodes = new List(30);
	private static ByteBuffer buffer;
	private static int[] streamIndices;
	
	public static int maximum = 6325;

	public static MobDefinition get(int id) {
		for (int i = 0; i < 20; i++) {
			if (cache[i].id == id) {
				return cache[i];
			}
		}

		cacheIndex = (cacheIndex + 1) % 20;
		MobDefinition definition = cache[cacheIndex] = new MobDefinition();
		buffer.position = streamIndices[id];
		definition.id = id;
		definition.readValues(buffer);
		switch (id) {
		case 1830:
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.standAnimation = 12248;
			definition.walkAnimation = 12246;
			//definition.walkingBackwardsAnimation = 4;
			//definition.walkLeftAnimation = 4;
			//definition.walkRightAnimation = 4;
		break;

		case 5382:
			definition.name = "Ultimate Ironman Dungeoneer";
			definition.description = "He's discovered a way for UIM to do Dungeoneering.".getBytes();
			definition.actions = new String[] {"Talk-to", null, "Quick-store", "Quick-retrieve", null, null, null};
			definition.combatLevel = 0;
			break;
		case 220:
			definition.name = "Guild Expert";
			definition.actions = new String[] {"Talk-to", null, "Options2", "Options3", "Options4", null, null};
			break;
		case 2577:
			definition.name = "Xxsk1ll3zxx";
			definition.description = "I hope that's the last time I ever type your name.".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 2643:
			definition.name = "Kids Ranq";
			definition.description = "Stupid noob uses a magic shortbow? Lol l2pk scrub.".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			definition.combatLevel = 103;
			break;
		case 5210:
			definition.name = "La'Roy-Jahnkins";
			definition.description = "At least he's got turkey.".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 2589:
			definition.name = "An0nymous26";
			definition.description = "Browses 4chan.".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 2576:
			definition.name = "Snakeskin Guy";
			definition.description = "He was born at a very young age.".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 5604:
			definition.name = "Ashley";
			definition.description = "SHELDON'S GROUNDED!".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 736:
			definition.name = "Emily0_o";
			definition.description = "A `professional` grill gamer.".getBytes();
			definition.actions = new String[5];
			definition.actions[0] = "Ban";
			definition.actions[2] = "Follow on Twitch";
			definition.actions[3] = "Subscribe ($4.99/mo)";
			break;
		case 2578:
			definition.name = "Ima GuYiRL";
			definition.description = "Will get married for 1m lolzzzz.".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 2575:
			definition.name = "OrcRogueIRL";
			definition.description = "You can't see him, he's stealthed! ;)".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 433:
			definition.name = "iTry2tribryd";
			definition.description = "I bet was tri-bridding before it was cool.".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 432:
			definition.name = "Hendrix";
			definition.description = "Hendrix! OPEN THE DAMN DOOR!".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 5861:
			definition.name = "The Riftsplitter";
			break;
		case 19:
			definition.walkAnimation = 7046;
			break;
		case 434:
			definition.name = "Elvemage";
			definition.description = "Farcasting n3rd? Rofl get a lyfe. 1v1".getBytes();
			definition.actions = new String[6];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Follow";
			definition.actions[3] = "Trade";
			break;
		case 6247:
			definition.npcModels = new int[]{28057, 28071, 28078, 28056};
			break;
		case 6873:
		case 5529:
			definition.walkAnimation = 5781;
			definition.standAnimation = 5785;
			definition.npcSizeInSquares = 2;
			if(id == 6873) { //Yak summon
				definition.actions = new String[] {"Store", null, null, null, null};
			}
			break;
		case 13465:
			definition.combatLevel = 91;
			break;
		case 13469:
			definition.combatLevel = 128;
			break;
		case 13474:
			definition.combatLevel = 173;
			break;
		case 13478:
			definition.combatLevel = 224;
			break;
		case 13479:
			definition.combatLevel = 301;
			break;
		case 519:
			definition.actions = new String[] {"Talk-to", null, null, null, null, null, null};
			break;
		case 3777:
			definition.name = "Member Wizard";
			definition.actions = new String[] {"Talk-to", null, "View Shop 1", "View Shop 2", "View Shop 3", null, null};
			break;
		case 1837:
			definition.name = "Ancient Mage";
			definition.description = "Creepy... yet helpful. Trade your Trio Tokens to him.".getBytes();
			definition.combatLevel = 0;
			definition.actions = new String[] {"Talk-to", null, "Quick-tele to Trio", null, null, null, null};
			definition.npcModels = new int[5];
			definition.npcModels[0] = 62737;
			definition.npcModels[1] = 62745; 
			definition.npcModels[2] = 62740; 
			definition.npcModels[3] = 62735;
			definition.npcModels[4] = 62734; 
			definition.standAnimation = 808; 
			definition.walkAnimation = 819; 
			break;
		case 3580:
			definition.combatLevel = 80;
			break;
        case 286:
            definition.npcModels = new int[] {23905};
            definition.name = "Mutant KFC";
            definition.actions = new String[5];
            definition.actions = new String[] {null, "Attack", null, null, null};
            definition.combatLevel = 666;
            definition.standAnimation = 5386;
            definition.walkAnimation = 5385;
            definition.adjustVertextPointsXOrY = 600;
            definition.adjustVertextPointZ = 600;
            definition.npcSizeInSquares = 3;
            break;
        case 285:
            definition.npcModels = new int[] {23905};
            definition.name = "Chicken Nugget";
            definition.actions = new String[5];
            definition.actions = new String[] {null, "Attack", null, null, null};
            definition.combatLevel = 80;
            definition.standAnimation = 5386;
            definition.walkAnimation = 5385;
            definition.npcSizeInSquares = 1;
            break;
		case 2891:
			definition.name = "Whirpool";
			definition.description = "You do not want to fall in there!".getBytes();
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 26699;
			definition.adjustVertextPointZ = 100;
			definition.adjustVertextPointsXOrY = 100;
			definition.npcSizeInSquares = 5;
			ObjectDefinition whirpool2 = ObjectDefinition.forID(25275);
			definition.walkAnimation = whirpool2.animationID;
			definition.standAnimation = whirpool2.animationID;
			definition.combatLevel = 0;
			break;
		case 2895:
			definition.name = "Whirpool";
			definition.description = "You do not want to fall in there!".getBytes();
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 26699;
			definition.adjustVertextPointZ = 50;
			definition.adjustVertextPointsXOrY = 50;
			definition.npcSizeInSquares = 4;
			ObjectDefinition whirpool = ObjectDefinition.forID(25275);
			definition.walkAnimation = whirpool.animationID;
			definition.standAnimation = whirpool.animationID;
			definition.combatLevel = 0;
			break;
		case 2900:
			definition.name = "Whirpool";
			definition.description = "You do not want to fall in there!".getBytes();
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 26699;
			definition.adjustVertextPointZ = 50;
			definition.adjustVertextPointsXOrY = 50;
			definition.npcSizeInSquares = 4;
			ObjectDefinition whirpool1 = ObjectDefinition.forID(25275);
			definition.walkAnimation = whirpool1.animationID;
			definition.standAnimation = whirpool1.animationID;
			definition.combatLevel = 0;
			break;
		case 2902:
			definition.name = "Whirpool";
			definition.description = "You do not want to fall in there!".getBytes();
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 26699;
			definition.adjustVertextPointZ = 50;
			definition.adjustVertextPointsXOrY = 50;
			definition.npcSizeInSquares = 4;
			ObjectDefinition whirpool11 = ObjectDefinition.forID(25275);
			definition.walkAnimation = whirpool11.animationID;
			definition.standAnimation = whirpool11.animationID;
			definition.combatLevel = 0;
			break;
		case 2903:
			definition.name = "Whirpool";
			definition.description = "You do not want to fall in there!".getBytes();
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 26699;
			definition.adjustVertextPointZ = 50;
			definition.adjustVertextPointsXOrY = 50;
			definition.npcSizeInSquares = 4;
			ObjectDefinition whirpool111 = ObjectDefinition.forID(25275);
			definition.walkAnimation = whirpool111.animationID;
			definition.standAnimation = whirpool111.animationID;
			definition.combatLevel = 0;
			break;
		case 2127:
			definition.name = "Snakeling";
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14407;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.combatLevel = 1;
			definition.adjustVertextPointZ = 30;
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 2128:
			definition.name = "Snakeling";
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14408;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.combatLevel = 725;
			definition.adjustVertextPointZ = 30;
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 2129:
			definition.name = "Snakeling";
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14409;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.combatLevel = 725;
			definition.adjustVertextPointZ = 30;
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 2042://regular
			definition.name = "Zulrah";
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14408;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.combatLevel = 725;
			definition.adjustVertextPointZ = 100;
			definition.adjustVertextPointsXOrY = 100;
			break;
		case 2043://melee
			definition.name = "Zulrah";
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14409;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.combatLevel = 725;
			definition.adjustVertextPointZ = 100;
			definition.adjustVertextPointsXOrY = 100;
			break;
		case 2044://mage
			definition.name = "Zulrah";
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14407;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.combatLevel = 725;
			definition.adjustVertextPointZ = 100;
			definition.adjustVertextPointsXOrY = 100;
			break;
		case 2000:
			definition.npcModels = new int[2];
			definition.npcModels[0] = 28294;
			definition.npcModels[1] = 28295;
			definition.name = "Venenatis";
			definition.actions = new String[] {null, "Attack", null, null, null};
			definition.adjustVertextPointZ = 200;
			definition.adjustVertextPointsXOrY = 200;
			MobDefinition ven = get(2035);
			definition.standAnimation = ven.standAnimation;
			definition.walkAnimation = ven.walkAnimation;
			definition.combatLevel = 464;
			definition.npcSizeInSquares = 5;
			break;
		case 2001:
			definition.npcModels = new int[1];
			definition.npcModels[0] = 28293;
			definition.name = "Scorpia";
			definition.actions = new String[] {null, "Attack", null, null, null};
			MobDefinition scor = get(107);
			definition.standAnimation = scor.standAnimation;
			definition.walkAnimation = scor.walkAnimation;
			definition.combatLevel = 464;
			definition.npcSizeInSquares = 3;
			break;
		case 109:
			definition.name = "Baby Scorpion";
			definition.combatLevel = 80;
			break;
		case 2006:
			definition.npcModels = new int[1];
			definition.npcModels[0] = 28299;
			definition.name = "Vet'ion";
			definition.actions = new String[] {null, "Attack", null, null, null};
			MobDefinition vet = get(90);
			definition.standAnimation = vet.standAnimation;
			definition.walkAnimation = vet.walkAnimation;
			definition.combatLevel = 464;
			break;
		case 2007:
			definition.name = "Kraken";
			definition.actions = new String[] {null, "Attack", null, null, null};
			MobDefinition eld = get(3847);
			definition.npcModels = new int[1];
			definition.npcModels[0] = 28231;
			definition.combatLevel = 291;
			definition.standAnimation = 3989;
			definition.walkAnimation = eld.walkAnimation;
			definition.adjustVertextPointZ = definition.adjustVertextPointsXOrY = 140;
			definition.npcSizeInSquares = 5;
			break;
		case 2008:
			definition.npcModels = new int[1];
			definition.npcModels[0] = 28231;
			definition.name = "Cave kraken";
			definition.actions = new String[] {null, "Attack", null, null, null};
			MobDefinition cave = get(3847);
			definition.npcModels = new int[1];
			definition.npcModels[0] = 28233;
			definition.combatLevel = 127;
			definition.standAnimation = 3989;
			definition.walkAnimation = cave.walkAnimation;
			definition.adjustVertextPointZ = definition.adjustVertextPointsXOrY = 42;
			break;
		case 2009:
			definition.name = "Callisto";
			definition.npcModels = new int[] { 28298 };
			definition.actions = new String[] { null, "Attack", null, null, null};
			definition.combatLevel = 470;
			MobDefinition callisto = get(105);
			definition.standAnimation = callisto.standAnimation;
			definition.walkAnimation = callisto.walkAnimation;
			definition.actions = callisto.actions;
			definition.adjustVertextPointZ = 110;
			definition.adjustVertextPointsXOrY = 100;
			definition.npcSizeInSquares = 4;
			break;
		case 2010:
			definition.name = "Bellator";
			definition.description = "Still dedicated to Adam".getBytes();
			definition.combatLevel = 440;
			definition.actions = new String[] { null, "Attack", null, null, null};
			definition.npcModels = new int[7];
			definition.npcModels[0] = 62738; //torvahelm
			definition.npcModels[1] = 62746; //torvaplate
			definition.npcModels[2] = 62743; //torvalegs
			definition.npcModels[3] = 65300; //maxcape
			definition.npcModels[4] = 13319; //bgloves
			definition.npcModels[5] = 27738; //dboots
			definition.npcModels[6] = 13999; //memeclaws
			definition.standAnimation = 808; 
			definition.walkAnimation = 819; 
			//definition.npcHeadnpcModels = MobDefinition.get(517).npcHeadnpcModels;
			break;
		case 199:
			definition.name = "Sagittariis";
			definition.description = "Still dedicated to Twinky".getBytes();
			definition.combatLevel = 440;
			definition.actions = new String[] { null, "Attack", null, null, null};
			definition.npcModels = new int[7];
			definition.npcModels[0] = 62739; //pern mask
			definition.npcModels[1] = 62744; //pern body
			definition.npcModels[2] = 62741; //pern legs
			definition.npcModels[3] = 65300; //max
			definition.npcModels[4] = 13319; //bgloves
			definition.npcModels[5] = 53309; //glaivens
			definition.npcModels[6] = 62750; //bow
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			//definition.npcHeadnpcModels = MobDefinition.get(517).npcHeadnpcModels;
			break;
			
			
		case 200:
			definition.name = "Venefica";
			definition.description = "Thanks for the memories.".getBytes();
			definition.combatLevel = 439;
			definition.actions = new String[] { null, "Attack", null, null, null};
			definition.npcModels = new int[7];
			definition.npcModels[0] = 62736;
			definition.npcModels[1] = 62748;
			definition.npcModels[2] = 62742;
			definition.npcModels[3] = 65300;
			definition.npcModels[4] = 13319;
			definition.npcModels[5] = 53330;
			definition.npcModels[6] = 53577;
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			//definition.npcHeadnpcModels = MobDefinition.get(517).npcHeadnpcModels;
			break;
		case 457:
			definition.name = "Ghost Town Citizen";
			definition.actions = new String[]{"Talk-to", null, "Teleport", null, null};
			break;
		case 5417:
			definition.combatLevel = 210;
			break;
		case 5418:
			definition.combatLevel = 90;
			break;
		case 6715:
			definition.combatLevel = 91;
			break;
		case 6716:
			definition.combatLevel = 128;
			break;
		case 6701:
			definition.combatLevel = 173;
			break;
		case 6725:
			definition.combatLevel = 224;
			break;
		case 6691:
			definition.npcSizeInSquares = 2;
			definition.combatLevel = 301;
			break;
		case 8710:
		case 8707:
		case 8706:
		case 8705:
			definition.name = "Musician";
			definition.actions = new String[]{"Listen-to", null, null, null, null};
			break;
		case 947:
			definition.name = "Grand Exchange clerk";
			break;
		case 9939:
			definition.combatLevel = 607;
			break;
		case 688:
			definition.name = "Archer";
			break;
		case 4540:
			definition.combatLevel = 299;
			break;
		case 3101:
			definition.adjustVertextPointsXOrY = definition.adjustVertextPointZ = 80;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[]{"Talk-to", null, "Start", "Rewards", null};
			break;
		case 6222:
			definition.name = "Kree'arra";
			definition.npcSizeInSquares = 5;
			definition.standAnimation = 6972;
			definition.walkAnimation = 6973;
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.adjustVertextPointsXOrY = definition.adjustVertextPointZ = 110;
			break;
		case 6203:
			definition.npcModels = new int[] {27768, 27773, 27764, 27765, 27770};
			definition.name = "K'ril Tsutsaroth";
			definition.npcSizeInSquares = 5;
			definition.standAnimation = 6943;
			definition.walkAnimation = 6942;
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.adjustVertextPointsXOrY = definition.adjustVertextPointZ = 110;
			break;
		case 1610:
		case 491:
		case 10216:
			definition.actions = new String[]{null, "Attack", null, null, null};
			break;
		case 7969:
			definition.actions = new String[]{"Talk-to", null, "Trade", null, null};
			break;
		case 8275:
			definition.name = "Duradel (Medium)";
			definition.actions = new String[] {"Talk-to", null, "Get-task", "Trade", "Rewards"};
			break;
			case 9085:
				definition.name = "Kuradal (Hard)";
				break;
			case 7780:
				definition.name = "Sumona (Elite)";
				break;
		case 1382:
			definition.name = "Glacor";
			definition.npcModels = new int[]{58940};
			definition.npcSizeInSquares = 3;
			//	definition.anInt86 = 475;
			definition.adjustVertextPointZ = definition.adjustVertextPointsXOrY = 180;
			definition.standAnimation = 10869;
			definition.walkAnimation = 10867;
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.combatLevel = 123;
			definition.drawYellowDotOnMap = true;
			definition.combatLevel = 188;
			break;
			/*case 1383:
			definition.name = "Unstable glacyte";
			definition.npcModels = new int[]{58942};
			definition.standAnimation = 10867;
			definition.walkAnimation = 10901;
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.combatLevel = 101;
			definition.drawYellowDotOnMap = false;
			break;
		case 1384:
			definition.name = "Sapping glacyte";
			definition.npcModels = new int[]{58939};
			definition.standAnimation = 10867;
			definition.walkAnimation = 10901;
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.combatLevel = 101;
			definition.drawYellowDotOnMap = true;
			break;
		case 1385:
			definition.name = "Enduring glacyte";
			definition.npcModels = new int[]{58937};
			definition.standAnimation = 10867;
			definition.walkAnimation = 10901;
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.combatLevel = 101;
			definition.drawYellowDotOnMap = true;
			break;*/
		case 4249:
			definition.name = "Gambler";
			break;
		case 6970:
			definition.actions = new String[] {"Trade", null, "Exchange Shards", null, null};
			break;
		case 4657:
			definition.actions = new String[] {"Talk-to", null, "Claim Items", "Check Total", "Teleport"};
			break;
		case 605:
			definition.actions = new String[] {"Talk-to", null, "Vote Shop", "Coming soon", "Loyalty Titles"};
			break;
		case 8591:
			definition.actions = new String[] {"Talk-to", null, "Trade", null, null};
			break;
		case 316:
			definition.name = "River fishing spot";
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 315:
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 309:
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 310:
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 314:
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 312:
			definition.name = "Sea fishing spot";
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 313:
			definition.name = "Ocean fishing spot";
			definition.adjustVertextPointsXOrY = 30;
			break;
		case 318:
			definition.name = "Monk fishing spot";
			definition.adjustVertextPointsXOrY = 30;
			definition.actions = new String[] {"Net", null, "Lure", null, null};
			break;
		case 805:
			definition.actions = new String[] {"Trade", null, "Tan hide", null, null};
			break;
		case 461:
		case 844:
		case 650:
		case 5112:
		case 3789:
		case 802:
		case 520:
		case 521:
		case 11226:
			definition.actions = new String[] {"Trade", null, null, null, null};
			break;
		case 970:
			definition.actions = new String[] {"Event Shop", null, null, null, null};
			break;
		case 8022:
		case 8028:
			String color = id == 8022 ? "Yellow" : "Green";
			definition.name = ""+color+" energy source";
			definition.actions = new String[] {"Siphon", null, null, null, null};
			break;
		case 8444:
			definition.actions = new String[5];
			definition.actions[0] = "Trade";
			break;
			
			
		case 2579:
			definition.name = "Maxwell";
			definition.description = "One of Necrotic's skillful citizens.".getBytes();
			definition.combatLevel = 138;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Trade";
			definition.npcModels = new int[7];
			definition.npcModels[0] = 55761;
			definition.npcModels[1] = 62746;
			definition.npcModels[2] = 62743;
			definition.npcModels[3] = 65297;
			definition.npcModels[4] = 13319;
			definition.npcModels[5] = 27738;
			definition.npcModels[6] = 20147;
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			//definition.npcHeadnpcModels = MobDefinition.get(517).npcHeadnpcModels;
			break;
			
		case 273:
			definition.name = "Slayer Instructor";
			definition.description = "Creepy guy, but 200m Slayer XP will do that to you.".getBytes();
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			break;
			
		case 1685:
			definition.name = "Pure";
			definition.actions = new String[] {"Trade", null, null, null, null};
			break;
			
		case 3030:
			definition.name = "King black dragon";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {17414, 17415, 17429, 17422};
			definition.combatLevel = 276;
			definition.standAnimation = 90;
			definition.walkAnimation = 4635;
			definition.adjustVertextPointsXOrY = 63;
			definition.adjustVertextPointZ = 63;
			definition.npcSizeInSquares = 3;
			break;

		case 3031:
			definition.name = "General graardor";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {27785, 27789};
			definition.combatLevel = 624;
			definition.standAnimation = 7059;
			definition.walkAnimation = 7058;
			definition.adjustVertextPointsXOrY = 40;
			definition.adjustVertextPointZ = 40;
			break;	

		case 3032:
			definition.name = "TzTok-Jad";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {34131};
			definition.combatLevel = 702;
			definition.standAnimation = 9274;
			definition.walkAnimation = 9273;
			definition.adjustVertextPointsXOrY = 45;
			definition.adjustVertextPointZ = 45;
			definition.npcSizeInSquares = 2;
			break;

		case 3033:
			definition.name = "Chaos elemental";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {11216};
			definition.combatLevel = 305;
			definition.standAnimation = 3144;
			definition.walkAnimation = 3145;
			definition.adjustVertextPointsXOrY = 62;
			definition.adjustVertextPointZ = 62;
			break;
		case 3034:
			definition.name = "Corporeal beast";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {40955};
			definition.combatLevel = 785;
			definition.standAnimation = 10056;
			definition.walkAnimation = 10055;
			definition.adjustVertextPointsXOrY = 45;
			definition.adjustVertextPointZ = 45;
			definition.npcSizeInSquares = 2;
			break;

		case 3035:
			definition.name = "Kree'arra";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {28003, 28004};
			definition.combatLevel = 580;
			definition.standAnimation = 6972;
			definition.walkAnimation = 6973;
			definition.adjustVertextPointsXOrY = 43;
			definition.adjustVertextPointZ = 43;
			definition.npcSizeInSquares = 2;
			break;

		case 3036:
			definition.name = "K'ril tsutsaroth";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {27768, 27773, 27764, 27765, 27770};
			definition.combatLevel = 650;
			definition.standAnimation = 6943;
			definition.walkAnimation = 6942;
			definition.adjustVertextPointsXOrY = 43;
			definition.adjustVertextPointZ = 43;
			definition.npcSizeInSquares = 2;
			break;
		case 3037:
			definition.name = "Commander zilyana";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {28057, 28071, 28078, 28056};
			definition.combatLevel = 596;
			definition.standAnimation = 6963;
			definition.walkAnimation = 6962;
			definition.adjustVertextPointsXOrY = 103;
			definition.adjustVertextPointZ = 103;
			definition.npcSizeInSquares = 2;
			break;
		case 3038:
			definition.name = "Dagannoth supreme";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {9941, 9943};
			definition.combatLevel = 303;
			definition.standAnimation = 2850;
			definition.walkAnimation = 2849;
			definition.adjustVertextPointsXOrY = 105;
			definition.adjustVertextPointZ = 105;
			definition.npcSizeInSquares = 2;
			break;

		case 3039:
			definition.name = "Dagannoth prime"; //9940, 9943, 9942
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {9940, 9943, 9942};
			definition.originalModelColours = new int[]{11930, 27144, 16536, 16540};
			definition.changedModelColours = new int[]{5931, 1688, 21530, 21534};
			definition.combatLevel = 303;
			definition.standAnimation = 2850;
			definition.walkAnimation = 2849;
			definition.adjustVertextPointsXOrY = 105;
			definition.adjustVertextPointZ = 105;
			definition.npcSizeInSquares = 2;
			break;

		case 3040:
			definition.name = "Dagannoth rex";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.npcModels = new int[] {9941};
			definition.originalModelColours = new int[]{16536, 16540, 27144, 2477};
			definition.changedModelColours = new int[]{7322, 7326, 10403, 2595};
			definition.combatLevel = 303;
			definition.standAnimation = 2850;
			definition.walkAnimation = 2849;
			definition.adjustVertextPointsXOrY = 105;
			definition.adjustVertextPointZ = 105;
			definition.npcSizeInSquares = 2;
			break;
		case 3047:
			definition.name = "Frost dragon";
			definition.combatLevel = 166;
			definition.standAnimation = 13156;
			definition.walkAnimation = 13157;
			definition.walkingBackwardsAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.walkLeftAnimation = -1;
			//definition.type = 51;
			definition.degreesToTurn = 32 ;
			definition.npcModels = new int[] {56767, 55294};
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.adjustVertextPointsXOrY = 72;
			definition.adjustVertextPointZ = 72;
			definition.npcSizeInSquares = 2;
			break;

		case 3048:
			definition.npcModels = new int[]{44733};
			definition.name = "Tormented demon";
			definition.combatLevel = 450;
			definition.standAnimation = 10921;
			definition.walkAnimation = 10920;
			definition.walkingBackwardsAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.walkLeftAnimation = -1;
			//	definition.type = 8349;
			definition.degreesToTurn = 32;
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.adjustVertextPointsXOrY = 60;
			definition.adjustVertextPointZ = 60;
			definition.npcSizeInSquares = 2;
			break;
		case 3050:
			definition.npcModels = new int[] {24602, 24605, 24606};
			definition.name = "Kalphite queen";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 333;
			definition.standAnimation = 6236;
			definition.walkAnimation = 6236;
			definition.adjustVertextPointsXOrY = 70;
			definition.adjustVertextPointZ = 70;
			definition.npcSizeInSquares = 2;
			break;
		case 3051:
			definition.npcModels = new int[] {46141};
			definition.name = "Slash bash";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 111;
			definition.standAnimation = 11460;
			definition.walkAnimation = 11461;
			definition.adjustVertextPointsXOrY = 65;
			definition.adjustVertextPointZ = 65;
			definition.npcSizeInSquares = 2;
			break;
		case 3052:
			definition.npcModels = new int[] {45412};
			definition.name = "Phoenix";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 235;
			definition.standAnimation = 11074;
			definition.walkAnimation = 11075;
			definition.adjustVertextPointsXOrY = 70;
			definition.adjustVertextPointZ = 70;
			definition.npcSizeInSquares = 2;
			break;
		case 3053:
			definition.npcModels = new int[] {46058, 46057};
			definition.name = "Bandos avatar";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 299;
			definition.standAnimation = 11242;
			definition.walkAnimation = 11255;
			definition.adjustVertextPointsXOrY = 70;
			definition.adjustVertextPointZ = 70;
			definition.npcSizeInSquares = 2;
			break;
		case 3054:
			definition.npcModels = new int[] {62717};
			definition.name = "Nex";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 565;
			definition.standAnimation = 6320;
			definition.walkAnimation = 6319;
			definition.adjustVertextPointsXOrY = 95;
			definition.adjustVertextPointZ = 95;
			definition.npcSizeInSquares = 1;
			break;
		case 3055:
			definition.npcModels = new int[] {51852, 51853};
			definition.name = "Jungle strykewyrm";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 110;
			definition.standAnimation = 12790;
			definition.walkAnimation = 12790;
			definition.adjustVertextPointsXOrY = 60;
			definition.adjustVertextPointZ = 60;
			definition.npcSizeInSquares = 1;
			break;
		case 3056:
			definition.npcModels = new int[] {51848, 51850};
			definition.name = "Desert strykewyrm";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 130;
			definition.standAnimation = 12790;
			definition.walkAnimation = 12790;
			definition.adjustVertextPointsXOrY = 60;
			definition.adjustVertextPointZ = 60;
			definition.npcSizeInSquares = 1;
			break;
		case 3057:
			definition.npcModels = new int[] {51847, 51849};
			definition.name = "Ice strykewyrm";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 210;
			definition.standAnimation = 12790;
			definition.walkAnimation = 12790;
			definition.adjustVertextPointsXOrY = 65;
			definition.adjustVertextPointZ = 65;
			definition.npcSizeInSquares = 1;
			break;
		case 3058:
			definition.npcModels = new int[] {49142, 49144};
			definition.name = "Green dragon";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 79;
			definition.standAnimation = 12248;
			definition.walkAnimation = 12246;
			definition.adjustVertextPointsXOrY = 70;
			definition.adjustVertextPointZ = 70;
			definition.npcSizeInSquares = 2;
			break;
		case 3059:
			definition.npcModels = new int[] {57937};
			definition.name = "Baby blue dragon";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 48;
			definition.standAnimation = 14267;
			definition.walkAnimation = 14268;
			definition.adjustVertextPointsXOrY = 85;
			definition.adjustVertextPointZ = 85;
			definition.npcSizeInSquares = 1;
			break;
		case 3060:
			definition.npcModels = new int[] {49137, 49144};
			definition.name = "Blue dragon";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 111;
			definition.standAnimation = 12248;
			definition.walkAnimation = 12246;
			definition.adjustVertextPointsXOrY = 70;
			definition.adjustVertextPointZ = 70;
			definition.npcSizeInSquares = 2;
			break;
		case 3061:
			definition.npcModels = new int[] {14294, 49144};
			definition.name = "Black dragon";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 227;
			definition.standAnimation = 12248;
			definition.walkAnimation = 12246;
			definition.adjustVertextPointsXOrY = 70;
			definition.adjustVertextPointZ = 70;
			definition.npcSizeInSquares = 2;
			break;
		case 3062:
			definition.npcModels = new int[] {63604, 63606};
			definition.name = "WildyWyrm Jr";
			definition.actions = new String[5];
			definition.actions[0] = "Pick-up";
			definition.combatLevel = 382;
			definition.standAnimation = 12790;
			definition.walkAnimation = 12790;
			definition.adjustVertextPointsXOrY = 70;
			definition.adjustVertextPointZ = 70;
			definition.npcSizeInSquares = 2;
			break;
            // boss pets
        case 6302:
            definition.npcModels = new int[] {26262};
            definition.name = "Skeleton hellhound";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 97;
            definition.standAnimation = 6580;
            definition.walkAnimation = 6577;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Prayer skill.".getBytes();
            break;
        case 6303:
            definition.npcModels = new int[] {10633, 10640, 10637, 10638, 10632};
            definition.name = "Maze Guardian";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 0;
            definition.standAnimation = 3033;
            definition.walkAnimation = 3034;
            definition.adjustVertextPointsXOrY = 50;
            definition.adjustVertextPointZ = 50;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Runecrafting skill.".getBytes();
            break;
        case 6304:
            definition.npcModels = new int[] {26631, 26636, 26641, 23932, 26624, 11788};
            definition.name = "Skeleton Warlord";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 97;
            definition.standAnimation = 2065;
            definition.walkAnimation = 2064;
            definition.adjustVertextPointsXOrY = 85;
            definition.adjustVertextPointZ = 85;
            definition.npcSizeInSquares = 1;
            break;
        case 6305:
            definition.npcModels = new int[] {21547};
            definition.name = "Penguin";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 2;
            definition.standAnimation = 5668;
            definition.walkAnimation = 5666;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Agility skill.".getBytes();
            break;
        case 6306:
            definition.npcModels = new int[] {217, 181, 250, 292, 170, 176, 260};
            definition.name = "Druid";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 0;
            definition.standAnimation = 808;
            definition.walkAnimation = 819;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.originalModelColours = new int [3];
            definition.originalModelColours[0] = 25238;
            definition.originalModelColours[1] = 8741;
            definition.originalModelColours[2] = 6798;
            definition.changedModelColours = new int [3];
            definition.changedModelColours[0] = 127;
            definition.changedModelColours[1] = 127;
            definition.changedModelColours[2] = 127;
            definition.description = "A skilling pet from the Herblore skill.".getBytes();
            break;
        case 6307:
            definition.npcModels = new int[] {4821, 4828, 4833};
            definition.name = "Monkey guard";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 149;
            definition.standAnimation = 1386;
            definition.walkAnimation = 1380;
            definition.adjustVertextPointsXOrY = 125;
            definition.adjustVertextPointZ = 125;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Thieving skill.".getBytes();
            break;
        case 6308:
            definition.npcModels = new int[] {14104, 14103};
            definition.name = "Clockwork cat";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 0;
            definition.standAnimation = 317;
            definition.walkAnimation = 314;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Crafting skill.".getBytes();
            break;
        case 6309:
            definition.npcModels = new int[] {26863};
            definition.name = "Jubbly bird";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 9;
            definition.standAnimation = 6803;
            definition.walkAnimation = 6804;
            definition.adjustVertextPointsXOrY = 50;
            definition.adjustVertextPointZ = 50;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Fletching skill.".getBytes();
            break;
        case 6310:
            definition.npcModels = new int[] {5076, 5077};
            definition.name = "Dust devil";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 122;
            definition.standAnimation = 1556;
            definition.walkAnimation = 1554;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Slayer skill.".getBytes();
            break;
        case 6312:
            definition.npcModels = new int[] {19371};
            definition.name = "Chinchompa";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 2;
            definition.standAnimation = 5182;
            definition.walkAnimation = 5181;
            definition.adjustVertextPointsXOrY = 125;
            definition.adjustVertextPointZ = 125;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Hunter skill.".getBytes();
            break;
        case 6313:
            definition.npcModels = new int[] {6146, 6148, 6150};
            definition.name = "Clay Golem";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 0;
            definition.standAnimation = 1913;
            definition.walkAnimation = 1912;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Mining skill.".getBytes();
            break;
        case 6314:
            definition.npcModels = new int[] {2970, 2982, 2977, 2983, 2985, 2989, 2993, 2991};
            definition.name = "Chaos Dwarf";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 97;
            definition.standAnimation = 101;
            definition.walkAnimation = 98;
            definition.adjustVertextPointsXOrY = 90;
            definition.adjustVertextPointZ = 90;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Smithing skill.".getBytes();
            break;
        case 6315:
            definition.npcModels = new int[] {2848};
            definition.name = "Shark";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 0;
            definition.standAnimation = 10;
            definition.walkAnimation = 10;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Fishing skill.".getBytes();
            break;
        case 6316:
            definition.npcModels = new int[] {24461, 24490, 24439, 24480, 24446, 24452, 24503};
            definition.name = "Goblin cook";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 0;
            definition.standAnimation = 6181;
            definition.walkAnimation = 6180;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Cooking skill.".getBytes();
            break;
        case 6317:
            definition.npcModels = new int[] {335};
            definition.name = "Fire elemental";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 35;
            definition.standAnimation = 1027;
            definition.walkAnimation = 1028;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Firemaking skill.".getBytes();
            break;
        case 6318:
            definition.npcModels = new int[] {21150};
            definition.name = "Tree spirit";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 101;
            definition.standAnimation = 5530;
            definition.walkAnimation = 5531;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Woodcutting skill.".getBytes();
            break;
        case 6319:
            definition.npcModels = new int[] {10220};
            definition.name = "Leprechaun";//3021
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 0;
            definition.standAnimation = 2904;
            definition.walkAnimation = 189;
            definition.adjustVertextPointsXOrY = 75;
            definition.adjustVertextPointZ = 75;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Farming skill.".getBytes();
            break;
        case 6320:
            definition.npcModels = new int[] {7728};
            definition.name = "Evil Chicken";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 159;
            definition.standAnimation = 2298;
            definition.walkAnimation = 2297;
            definition.adjustVertextPointsXOrY = 45;
            definition.adjustVertextPointZ = 45;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Adam Sucks skill.".getBytes();
            break;
        case 6311:
            definition.npcModels = new int[] {5062};
            definition.name = "Abyssal demon";
            definition.actions = new String[5];
            definition.actions[0] = "Pick-up";
            definition.combatLevel = 124;
            definition.standAnimation = 1536;
            definition.walkAnimation = 1534;
            definition.adjustVertextPointsXOrY = 50;
            definition.adjustVertextPointZ = 50;
            definition.npcSizeInSquares = 1;
            definition.description = "A skilling pet from the Slayer skill.".getBytes();
            break;
        case 6322:
        	definition.name = "Serpentine Spawn";
        	definition.actions = new String[] {"Pick-up", null, null, null, null};
			definition.npcModels = new int[1];
            definition.combatLevel = 53;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.adjustVertextPointZ = 25;
			definition.adjustVertextPointsXOrY = 25;
            definition.npcSizeInSquares = 2;
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14408;
			break;
        case 6323:
        	definition.name = "Tanzanite Spawn";
        	definition.actions = new String[] {"Pick-up", null, null, null, null};
			definition.npcModels = new int[1];
            definition.combatLevel = 52;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.adjustVertextPointZ = 25;
			definition.adjustVertextPointsXOrY = 25;
            definition.npcSizeInSquares = 2;
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14407;
        	break;
        case 6324:
        	definition.name = "Magma Spawn";
        	definition.actions = new String[] {"Pick-up", null, null, null, null};
			definition.npcModels = new int[1];
            definition.combatLevel = 52;
			definition.standAnimation = 5070;
			definition.walkAnimation = 5070;
			definition.adjustVertextPointZ = 25;
			definition.adjustVertextPointsXOrY = 25;
            definition.npcSizeInSquares = 2;
			definition.npcModels = new int[1];
			definition.npcModels[0] = 14409;
        	break;
		case 6830:
		case 6841:
		case 6796:
		case 7331:
		case 6831:
		case 7361:
		case 6847:
		case 6872:
		case 7353:
		case 6835:
		case 6845:
		case 6808:
		case 7370:
		case 7333:
		case 7351:
		case 7367:
		case 6853:
		case 6855:
		case 6857:
		case 6859:
		case 6861:
		case 6863:
		case 9481:
		case 6827:
		case 6889:
		case 6813:
		case 6817:
		case 7372:
		case 6839:
		case 8575:
		case 7345:
		case 6799:
		case 7335:
		case 7347:
		case 6800:
		case 9488:
		case 6804:
		case 6822:
		case 6849:
		case 7355:
		case 7357:
		case 7359:
		case 7341:
		case 7329:
		case 7339:
		case 7349:
		case 7375:
		case 7343:
		case 6820:
		case 6865:
		case 6809:
		case 7363:
		case 7337:
		case 7365:
		case 6991:
		case 6992:
		case 6869:
		case 6818:
		case 6843:
		case 6823:
		case 7377:
		case 6887:
		case 6885:
		case 6883:
		case 6881:
		case 6879:
		case 6877:
		case 6875:
		case 6833:
		case 6851:
		case 5079:
		case 5080:
		case 6824:
			definition.actions = new String[] {null, null, null, null, null};
			break;
		case 6806: // thorny snail
		case 6807:
		case 6994: // spirit kalphite
		case 6995:
		case 6867: // bull ant
		case 6868:
		case 6794: // spirit terrorbird
		case 6795:
		case 6815: // war tortoise
		case 6816:
		case 6874:// pack yak
		case 3594: // yak
		case 3590: // war tortoise
		case 3596: // terrorbird
			definition.actions = new String[] {"Store", null, null, null, null};
			break;
		case 548:
			definition.actions = new String[] {"Trade", null, null, null, null};
			break;
		case 3299:
		case 437:
			definition.actions = new String[] {"Trade", null, null, null, null};
			break;
		case 1265:
		case 1267:
			definition.drawYellowDotOnMap = true;
			break;
		case 8459:
			definition.drawYellowDotOnMap = true;
			definition.actions = new String[] {"Shop", null, "Decant", null, null};
			break;
		case 961:
			definition.actions = new String[] {null, null, "Buy Consumables", "Restore Stats", null};
			definition.name = "Healer";
			break;
		case 705:
			definition.actions = new String[] {null, null, "Buy Armour", "Buy Weapons", "Buy Jewelries"};
			definition.name = "Warrior";
			break;
		case 1861:
			definition.actions = new String[] {null, null, "Buy Equipment", "Buy Ammunition", null};
			definition.name = "Archer";
			break;
		case 946:
			definition.actions = new String[] {null, null, "Buy Equipment", "Buy Runes", "Buy Teleports"};
			definition.name = "Mage";
			break;
		case 2253:
			definition.actions = new String[] {null, null, "Buy Skillcapes", "Buy Skillcapes (t)", "Buy Hoods"};
			break;
		case 2292:
			definition.actions = new String[] {"Trade", null, null, null, null};
			definition.name = "Merchant";
			break;
		case 2676:
			definition.actions = new String[] {"Makeover", null, null, null, null};
			break;
		case 494:
		case 1360:
			definition.actions = new String[] {"Talk-to", null, null, null, null};
			break;
			//LOL
		case 3390:
			definition.name = "Prince Black Dragon";
			definition.adjustVertextPointZ = 30;
			definition.adjustVertextPointsXOrY = 30;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[4];
			definition.npcModels[0] = 17414;
			definition.npcModels[1] = 17415;
			definition.npcModels[2] = 17429;
			definition.npcModels[3] = 17422;
			definition.standAnimation = 90;
			definition.walkAnimation = 4635;
			definition.combatLevel = 0;
			definition.description = "A miniature King Black Dragon!".getBytes();
			definition.varBitChild = -1;
			break;
		case 3391:// stop before 5902
			definition.varBitChild = -1;
			definition.name = "Chaos Elemental Jr.";
			definition.adjustVertextPointZ = 30;
			definition.adjustVertextPointsXOrY = 30;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[1];
			definition.npcModels[0] = 11216;
			definition.standAnimation = 3144;
			definition.walkAnimation = 3145;
			definition.combatLevel = 0;
			definition.description = "A miniature Chaos Elemental!".getBytes();
			break;
		case 3392:// stop before 5902
			definition.varBitChild = -1;
			definition.name = "Baby Mole";
			definition.adjustVertextPointZ = 30;
			definition.adjustVertextPointsXOrY = 30;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[4];
			definition.npcModels[0] = 12076;
			definition.npcModels[1] = 12075;
			definition.npcModels[2] = 12074;
			definition.npcModels[3] = 12077;
			definition.standAnimation = 3309;
			definition.walkAnimation = 3313;
			definition.combatLevel = 0;
			definition.description = "A miniature Giant Mole!".getBytes();
			break;
		case 3393:// stop before 5902
			definition.varBitChild = -1;
			definition.name = "Baby Dagannoth Supreme";
			definition.adjustVertextPointZ = 40;
			definition.adjustVertextPointsXOrY = 40;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[2];
			definition.npcModels[0] = 9941;
			definition.npcModels[1] = 9943;
			definition.standAnimation = 2850;
			definition.walkAnimation = 2849;
			definition.combatLevel = 0;
			definition.description = "A miniature Dagannoth Supreme!".getBytes();
			break;

		case 3394:// stop before 5902
			definition.varBitChild = -1;
			definition.name = "Dagannoth Prime Jr.";
			definition.adjustVertextPointZ = 40;
			definition.adjustVertextPointsXOrY = 40;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[3];
			definition.npcModels[0] = 9940;
			definition.npcModels[1] = 9943;
			definition.npcModels[2] = 9942;
			definition.standAnimation = 2850;
			definition.walkAnimation = 2849;
			definition.combatLevel = 0;
			definition.description = "A miniature Dagannoth Prime!".getBytes();
			break;
		case 3395:// stop before 5902
			definition.varBitChild = -1;
			definition.name = "Baby Dagannoth Rex";
			definition.adjustVertextPointZ = 40;
			definition.adjustVertextPointsXOrY = 40;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[1];
			definition.npcModels[0] = 9941;
			definition.standAnimation = 2850;
			definition.walkAnimation = 2849;
			definition.combatLevel = 0;
			definition.description = "A miniature Dagannoth Rex!".getBytes();
			break;
		case 3396:
			definition.varBitChild = -1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[2];
			definition.npcModels[0] = 28003;
			definition.npcModels[1] = 28004;
			definition.adjustVertextPointZ = 25;
			definition.adjustVertextPointsXOrY = 25;
			definition.standAnimation = 6972;
			definition.walkAnimation = 6973;
			definition.name = "Kree'arra Jr.";
			definition.combatLevel = 0;
			definition.description = "A mini Kree'arra!".getBytes();
			definition.npcSizeInSquares = 1;
			break;
		case 3397:// stop before 5902
			definition.varBitChild = -1;
			definition.name = "General Graardor Jr.";
			definition.adjustVertextPointZ = 30;
			definition.adjustVertextPointsXOrY = 30;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[2];
			definition.npcModels[0] = 27785;
			definition.npcModels[1] = 27789;
			definition.standAnimation = 7059;
			definition.walkAnimation = 7058;
			definition.combatLevel = 0;
			definition.description = "A miniature General Graardor!".getBytes();
			break;
		case 3688:
			definition.name = "Brandon Jr.";
			break;
		case 3398:// stop before 5902
			definition.varBitChild = -1;
			definition.name = "Penance Pet";
			definition.adjustVertextPointZ = 30;
			definition.adjustVertextPointsXOrY = 30;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[8];
			definition.npcModels[0] = 20717;
			definition.npcModels[1] = 20715;
			definition.npcModels[2] = 20714;
			definition.npcModels[3] = 20709;
			definition.npcModels[4] = 20713;
			definition.npcModels[5] = 20712;
			definition.npcModels[6] = 20711;
			definition.npcModels[7] = 20710;
			definition.standAnimation = 5410;
			definition.walkAnimation = 5409;
			definition.combatLevel = 0;
			definition.description = "A miniature Penance Queen!".getBytes();
			break;
		case 3400:// stop before 5902
			definition.varBitChild = -1;
			definition.name = "Zilyana Jr.";
			definition.adjustVertextPointZ = 40;
			definition.adjustVertextPointsXOrY = 40;
			definition.npcSizeInSquares = 1;
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			definition.actions[2] = "Pick-up";
			definition.npcModels = new int[4];
			definition.npcModels[0] = 28057;
			definition.npcModels[1] = 28071;
			definition.npcModels[2] = 28078;
			definition.npcModels[3] = 28056;
			definition.standAnimation = 6963;
			definition.walkAnimation = 6962;
			definition.combatLevel = 0;
			definition.description = "A miniature Commander Zilyana!".getBytes();
			break;
			//custom pets go here
		case 659:
			definition.actions = new String[] {"Talk-to", null, null, null, null };
			break;
		case 6750:
			definition.name = "Pet Insurance Agent";
			definition.actions = new String[5];
			definition.actions[0] = "Talk-to";
			break;
		case 6325:
			definition.name = "Superior Abyssal Demon";
			definition.actions = new String[] {null, "Attack", null, null, null};
            definition.npcModels = new int[] {5062, 51602};
            definition.originalModelColours = new int[] {22439, /*4015*/};
            definition.changedModelColours = new int[] {947, /*528*/};
            definition.combatLevel = 124;
            definition.standAnimation = 1536;
            definition.walkAnimation = 1534;
            definition.adjustVertextPointsXOrY = 100;
            definition.adjustVertextPointZ = 100;
            definition.npcSizeInSquares = 1;
            definition.description = "A denizen of the Abyss!".getBytes();
            break;
		case 6335:
			definition.name = "Zamorakian Mage";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 84;
			definition.npcModels = new int[]{9981, 250, 25676, 23916, 176, 23934, 181,};
			definition.originalModelColours = new int[]{24, 16, 8, 920, 28, 12};
			definition.changedModelColours = new int[]{801, 65428, 788, 906, 119, 65428};
			definition.actions = new String[]{null, "attack", null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 1;
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 0;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = true;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		case 6334:
			definition.name = "Abyssal Titan";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 0;
			definition.npcModels = new int[]{30484};
			definition.actions = new String[]{null, null, null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 2;
			definition.standAnimation = 7690;
			definition.walkAnimation = 7687;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 25;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = false;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		case 7000:
			definition.name = "Moss Titan";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 0;
			definition.npcModels = new int[]{30742};
			definition.actions = new String[]{null, null, null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 2;
			definition.standAnimation = 7841;
			definition.walkAnimation = 7838;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 25;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = false;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
			case 1597:
				definition.name = "Vannaka (Easy)";
				break;
		case 6332:
			definition.name = "Lava Titan";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 0;
			definition.npcModels = new int[]{30481};
			definition.actions = new String[]{null, null, null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 2;
			definition.standAnimation = 7978;
			definition.walkAnimation = 7977;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 30;
			definition.modelShadowing = 150;
			definition.drawYellowDotOnMap = false;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		case 6331:
			definition.name = "Ice Titan";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 0;
			definition.npcModels = new int[]{30470};
			definition.actions = new String[]{null, null, null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 2;
			definition.standAnimation = 8186;
			definition.walkAnimation = 7847;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 35;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = false;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		case 6330:
			definition.name = "Giant Skeleton";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 303;
			definition.npcModels = new int[]{21168, 21179, 21160, 21157, 21182, 21188, 21202};
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 1;
			definition.standAnimation = 5483;
			definition.walkAnimation = 5479;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 0;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = true;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		case 6329:
			definition.name = "Skeleton Brute";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 132;
			definition.npcModels = new int[]{26628, 26637, 26642, 23932, 26623};
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 1;
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 0;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = true;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		case 1471:
			definition.name = "Monkey Skeleton";
			break;
		case 6328:
			definition.name = "Skeleton Mage";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 64;
			definition.npcModels = new int[]{21196};
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 1;
			definition.standAnimation = 5483;
			definition.walkAnimation = 5476;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 0;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = true;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		case 6327:
			definition.name = "Skeleton fremennik";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 60;
			definition.npcModels = new int[]{24181, 24189, 24185, 24053};
			definition.originalModelColours = new int[]{8404, 12694, 12574, 8400, 10531};
			definition.changedModelColours = new int[]{10299, 8472, 7452, 10299, 7335};
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 1;
			definition.standAnimation = 6113;
			definition.walkAnimation = 6112;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 0;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = true;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		case 6326:
			definition.name = "Skeleton fremennik";
			definition.description = "stuff".getBytes();
			definition.combatLevel = 40;
			definition.npcModels = new int[]{24180, 24187, 24184, 24054};
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.degreesToTurn = 32;
			definition.headIcon = -1;
			definition.npcSizeInSquares = 1;
			definition.standAnimation = 6113;
			definition.walkAnimation = 6112;
			definition.walkingBackwardsAnimation = -1;
			definition.walkLeftAnimation = -1;
			definition.walkRightAnimation = -1;
			definition.configChild = -1;
			definition.varBitChild = -1;
			definition.modelLightning = 0;
			definition.modelShadowing = 0;
			definition.drawYellowDotOnMap = true;
			definition.disableRightClick = true;
			definition.visibilityOrRendering = false;
			break;
		}

		return definition;
	}

	public void copy(int id) {
		MobDefinition other = get(id);
		changedModelColours = other.changedModelColours.clone();
		childrenIDs = other.childrenIDs.clone();
		combatLevel = other.combatLevel;
		configChild = other.configChild;
		degreesToTurn = other.degreesToTurn;
		description = other.description;
		dialogueModels = other.dialogueModels;
		disableRightClick = false;
		drawYellowDotOnMap = other.drawYellowDotOnMap;
		headIcon = other.headIcon;
		modelLightning = other.modelLightning;
		modelShadowing = other.modelShadowing;
		npcModels = other.npcModels.clone();
		originalModelColours = other.originalModelColours.clone();
		standAnimation = other.standAnimation;
		varBitChild = other.varBitChild;
		visibilityOrRendering = other.visibilityOrRendering;
		walkAnimation = other.walkAnimation;
		walkingBackwardsAnimation = other.walkingBackwardsAnimation;
		walkLeftAnimation = other.walkLeftAnimation;
		walkRightAnimation = other.walkRightAnimation;
	}

	public static void nullify() {
		mruNodes = null;
		streamIndices = null;
		cache = null;
		buffer = null;
	}

	public static void load(Archive archive) {
		buffer = new ByteBuffer(archive.get("npc.dat"));
		ByteBuffer stream2 = new ByteBuffer(archive.get("npc.idx"));
		int totalNPCs = stream2.getUnsignedShort();
		streamIndices = new int[totalNPCs];
		int position = 2;

		for (int i = 0; i < totalNPCs; i++) {
			streamIndices[i] = position;
			position += stream2.getUnsignedShort();
		}

		cache = new MobDefinition[20];

		for (int i = 0; i < 20; i++) {
			cache[i] = new MobDefinition();
		}
	}

	public String[] actions;
	private int adjustVertextPointsXOrY;
	private int adjustVertextPointZ;
	private int[] changedModelColours;
	public int[] childrenIDs;
	public int combatLevel;
	private int configChild;
	public int degreesToTurn;
	public byte[] description;
	private int[] dialogueModels;
	public boolean disableRightClick;
	public boolean drawYellowDotOnMap;
	public int headIcon;
	private int modelLightning;
	private int modelShadowing;
	public String name;
	public int[] npcModels;
	public byte npcSizeInSquares;
	private int[] originalModelColours;
	public int standAnimation;
	public int id;
	private int varBitChild;
	public boolean visibilityOrRendering;
	public int walkAnimation;
	public int walkingBackwardsAnimation;
	public int walkLeftAnimation;
	public int walkRightAnimation;

	private MobDefinition() {
		walkRightAnimation = -1;
		varBitChild = -1;
		walkingBackwardsAnimation = -1;
		configChild = -1;
		combatLevel = -1;
		walkAnimation = -1;
		npcSizeInSquares = 1;
		headIcon = -1;
		standAnimation = -1;
		id = -1;
		degreesToTurn = 32;
		walkLeftAnimation = -1;
		disableRightClick = true;
		adjustVertextPointZ = 128;
		drawYellowDotOnMap = true;
		adjustVertextPointsXOrY = 128;
		visibilityOrRendering = false;
	}

	public Model method160() {
		if (childrenIDs != null) {
			MobDefinition definition = method161();

			if (definition == null) {
				return null;
			} else {
				return definition.method160();
			}
		}

		if (dialogueModels == null) {
			return null;
		}

		boolean flag1 = false;

		for (int i = 0; i < dialogueModels.length; i++) {
			if (!Model.method463(dialogueModels[i])) {
				flag1 = true;
			}
		}

		if (flag1) {
			return null;
		}

		Model aclass30_sub2_sub4_sub6s[] = new Model[dialogueModels.length];

		for (int j = 0; j < dialogueModels.length; j++) {
			aclass30_sub2_sub4_sub6s[j] = Model.fetchModel(dialogueModels[j]);
		}

		Model model;

		if (aclass30_sub2_sub4_sub6s.length == 1) {
			model = aclass30_sub2_sub4_sub6s[0];
		} else {
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
		}

		if (originalModelColours != null) {
			for (int k = 0; k < originalModelColours.length; k++) {
				model.method476(originalModelColours[k], changedModelColours[k]);
			}
		}

		return model;
	}

	public MobDefinition method161() {
		int j = -1;

		try {
			if (varBitChild != -1) {
				VarBit varBit = VarBit.cache[varBitChild];
				int k = varBit.configId;
				int l = varBit.configValue;
				int i1 = varBit.anInt650;
				int j1 = Client.anIntArray1232[i1 - l];
				// System.out.println("k: " + k + " l: " + l);
				j = clientInstance.variousSettings[k] >> l & j1;
			} else if (configChild != -1) {
				j = clientInstance.variousSettings[configChild];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1) {
			return null;
		} else {
			return get(childrenIDs[j]);
		}
	}

	public Model method164(int j, int frame, int ai[], int nextFrame, int cycle1, int cycle2) {
		if (childrenIDs != null) {
			MobDefinition entityDef = method161();

			if (entityDef == null) {
				return null;
			} else {
				return entityDef.method164(j, frame, ai, nextFrame, cycle1, cycle2);
			}
		}

		Model model = (Model) mruNodes.insertFromCache(id);

		if (model == null) {
			boolean flag = false;

			for (int i1 = 0; i1 < npcModels.length; i1++) {
				if (!Model.method463(npcModels[i1])) {
					flag = true;
				}
			}

			if (flag) {
				return null;
			}

			Model aclass30_sub2_sub4_sub6s[] = new Model[npcModels.length];

			for (int j1 = 0; j1 < npcModels.length; j1++) {
				aclass30_sub2_sub4_sub6s[j1] = Model.fetchModel(npcModels[j1]);
			}

			if (aclass30_sub2_sub4_sub6s.length == 1) {
				model = aclass30_sub2_sub4_sub6s[0];
			} else {
				model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
			}

			if (originalModelColours != null) {
				for (int k1 = 0; k1 < originalModelColours.length; k1++) {
					model.method476(originalModelColours[k1], changedModelColours[k1]);
				}
			}

			model.createBones();
			model.light(84 + modelLightning, 1000 + modelShadowing, -90, -580, -90, true);
			mruNodes.removeFromCache(model, id);
		}

		Model model_1 = Model.aModel_1621;
		model_1.method464(model, FrameReader.isNullFrame(frame) & FrameReader.isNullFrame(j));
/*
		if (frame != -1 && j != -1) {
			model_1.method471(ai, j, frame);
		} else if (frame != -1 && !Configuration.TWEENING_ENABLED) {
			model_1.applyTransform(frame);
		} else if (frame != -1 && nextFrame != -1 && Configuration.TWEENING_ENABLED) {
			model_1.interpolateFrames(frame, nextFrame, cycle1, cycle2);
		}*/
		
		if (frame != -1 && j != -1)
			model_1.method471(ai, j, frame);
		else if (frame != -1 && nextFrame != -1 && Configuration.TWEENING_ENABLED)
			model_1.interpolateFrames(frame, nextFrame, cycle1, cycle2);
		else if (frame != -1)
			model_1.applyTransform(frame);
		
		if (adjustVertextPointsXOrY != 128 || adjustVertextPointZ != 128) {
			model_1.scaleT(adjustVertextPointsXOrY, adjustVertextPointsXOrY, adjustVertextPointZ);
		}

		model_1.method466();
		model_1.triangleSkin = null;
		model_1.vertexSkin = null;

		if (npcSizeInSquares == 1) {
			model_1.aBoolean1659 = true;
		}

		return model_1;
	}

	private void readValues(ByteBuffer buffer) {
		do {
			final int opcode = buffer.getUnsignedByte();

			if (opcode == 0) {
				return;
			}

			if (opcode == 1) {
				int j = buffer.getUnsignedByte();
				npcModels = new int[j];

				for (int j1 = 0; j1 < j; j1++) {
					npcModels[j1] = buffer.getUnsignedShort();
				}
			} else if (opcode == 2) {
				name = buffer.getString();
			} else if (opcode == 3) {
				description = buffer.getBytes();
			} else if (opcode == 12) {
				npcSizeInSquares = buffer.getSignedByte();
			} else if (opcode == 13) {
				standAnimation = buffer.getUnsignedShort();
			} else if (opcode == 14) {
				walkAnimation = buffer.getUnsignedShort();
			} else if (opcode == 17) {
				walkAnimation = buffer.getUnsignedShort();
				walkingBackwardsAnimation = buffer.getUnsignedShort();
				walkLeftAnimation = buffer.getUnsignedShort();
				walkRightAnimation = buffer.getUnsignedShort();

				if (walkAnimation == 65535) {
					walkAnimation = -1;
				}

				if (walkingBackwardsAnimation == 65535) {
					walkingBackwardsAnimation = -1;
				}

				if (walkLeftAnimation == 65535) {
					walkLeftAnimation = -1;
				}

				if (walkRightAnimation == 65535) {
					walkRightAnimation = -1;
				}
			} else if (opcode >= 30 && opcode < 40) {
				if (actions == null) {
					actions = new String[5];
				}

				actions[opcode - 30] = buffer.getString();

				if (actions[opcode - 30].equalsIgnoreCase("hidden")) {
					actions[opcode - 30] = null;
				}
			} else if (opcode == 40) {
				int length = buffer.getUnsignedByte();
				changedModelColours = new int[length];
				originalModelColours = new int[length];

				for (int i = 0; i < length; i++) {
					originalModelColours[i] = buffer.getUnsignedShort();
					changedModelColours[i] = buffer.getUnsignedShort();
				}
			} else if (opcode == 60) {
				int length = buffer.getUnsignedByte();
				dialogueModels = new int[length];

				for (int i = 0; i < length; i++) {
					dialogueModels[i] = buffer.getUnsignedShort();
				}
			} else if (opcode == 90) {
				buffer.getUnsignedShort();
			} else if (opcode == 91) {
				buffer.getUnsignedShort();
			} else if (opcode == 92) {
				buffer.getUnsignedShort();
			} else if (opcode == 93) {
				drawYellowDotOnMap = false;
			} else if (opcode == 95) {
				combatLevel = buffer.getUnsignedShort();
			} else if (opcode == 97) {
				adjustVertextPointsXOrY = buffer.getUnsignedShort();
			} else if (opcode == 98) {
				adjustVertextPointZ = buffer.getUnsignedShort();
			} else if (opcode == 99) {
				visibilityOrRendering = true;
			} else if (opcode == 100) {
				modelLightning = buffer.getSignedByte();
			} else if (opcode == 101) {
				modelShadowing = buffer.getSignedByte() * 5;
			} else if (opcode == 102) {
				headIcon = buffer.getUnsignedShort();
			} else if (opcode == 103) {
				degreesToTurn = buffer.getUnsignedShort();
			} else if (opcode == 106) {
				varBitChild = buffer.getUnsignedShort();

				if (varBitChild == 65535) {
					varBitChild = -1;
				}

				configChild = buffer.getUnsignedShort();

				if (configChild == 65535) {
					configChild = -1;
				}

				int length = buffer.getUnsignedByte();
				childrenIDs = new int[length + 1];

				for (int i = 0; i <= length; i++) {
					childrenIDs[i] = buffer.getUnsignedShort();

					if (childrenIDs[i] == 65535) {
						childrenIDs[i] = -1;
					}
				}
			} else if (opcode == 107) {
				disableRightClick = false;
			}
		} while (true);
	}
	
	public static void printDefinitionsForId(int mobId) {
		/*Print out Grain*/
		MobDefinition dump = MobDefinition.get(mobId);
		if (dump.name != null) {
			System.out.println("Dumping: "+dump.name);
		} else {
			System.out.println("MobDefinition.get("+mobId+").name == null");
		}
		System.out.println("combatlevel: "+dump.combatLevel);
		System.out.println("id: "+dump.id);
		if (dump.npcModels != null) {
			for (int i = 0; i < dump.npcModels.length; i++) {
				System.out.println("npcModels[" + i + "]: " + dump.npcModels[i]);
			}
		}
		if (dump.actions != null) {
			for (int i = 0; i < dump.actions.length; i++) {
				System.out.println("Action[" + i + "]: " + dump.actions[i]);
			}
		}
		System.out.println("degreesToTurn: "+dump.degreesToTurn);
		System.out.println("headIcon: "+dump.headIcon);
		System.out.println("npcSizeInSquares: "+dump.npcSizeInSquares);
		System.out.println("standAnimation: "+dump.standAnimation);
		System.out.println("walkAnimation: "+dump.walkAnimation);
		System.out.println("walkingBackwardsAnimation: "+dump.walkingBackwardsAnimation);
		System.out.println("walkLeftAnimation: "+dump.walkLeftAnimation);
		System.out.println("walkRightAnimation: "+dump.walkRightAnimation);
		if (dump.originalModelColours != null) {
			for (int i = 0; i < dump.originalModelColours.length; i++) {
				System.out.println("originalModelColours[" + i + "]: " + dump.originalModelColours[i]);
			}
		}
		if (dump.changedModelColours != null) {
			for (int i = 0; i < dump.changedModelColours.length; i++) {
				System.out.println("changedModelColours[" + i + "]: " + dump.changedModelColours[i]);
			}
		}
		if (dump.childrenIDs != null) {
			for (int i = 0; i < dump.childrenIDs.length; i++) {
				System.out.println("childrenIDs[" + i + "]: " + dump.changedModelColours[i]);
			}
		}
		System.out.println("configChild: "+dump.configChild);
		System.out.println("varBitChild: "+dump.varBitChild);
		System.out.println("modelLightning: "+dump.modelLightning);
		System.out.println("modelShadowing: "+dump.modelShadowing);
		System.out.println("drawYellowDotOnMap: "+dump.drawYellowDotOnMap);
		System.out.println("disableRightClick: "+dump.disableRightClick);
		System.out.println("visibilityOrRendering: "+dump.visibilityOrRendering);
		
		
	}

}