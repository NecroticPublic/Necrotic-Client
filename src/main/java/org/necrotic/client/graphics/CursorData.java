package org.necrotic.client.graphics;

/**
 * New Cursors
 * @author Gabriel Hannason
 */
public enum CursorData {

	CURSOR_0("DEFAULT_CURSOR", 1032),
	CURSOR_1("Take", 1033),
	CURSOR_2("Use", 1034),
	CURSOR_3("Talk-to", 1035),
	CURSOR_4("Enter", 1036),
	CURSOR_5("Net", 1037),
	CURSOR_6("Chop", 1041),
	CURSOR_7("Bury", 1043),
	CURSOR_8("Mine", 1044),
	CURSOR_9("Eat", 1045),
	CURSOR_10("Drink", 1046),
	CURSOR_11("Wield", 1047),
	CURSOR_12("Attack", 1050),
	CURSOR_13("Logout", 1052),
	CURSOR_14("Climb-up", 1053),
	CURSOR_15("Climb-down", 1054),
	CURSOR_16("Search", 1055),
	CURSOR_17("Steal", 1056),
	CURSOR_18("Smith", 1057),
	CURSOR_19("Clean", 1058),
	CURSOR_20("Back", 1059),
	CURSOR_21("Deposit", 1060),
	CURSOR_22("Settings", 1063),
	CURSOR_23("Accept", 1068),
	CURSOR_24("Decline", 1069),
	CURSOR_25("Cast Ice Barrage", 1070),
	CURSOR_26("Cast Blood Barrage", 1071),
	CURSOR_27("Cast Shadow Barrage", 1072),
	CURSOR_28("Cast Smoke Barrage", 1073),
	CURSOR_29("Cast Ice Blitz", 1074),
	CURSOR_30("Cast Blood Blitz", 1075),
	CURSOR_31("Cast Shadow Blitz", 1076),
	CURSOR_32("Cast Smoke Blitz", 1077),
	CURSOR_33("Cast Ice Burst", 1078),
	CURSOR_34("Cast Blood Burst", 1079),
	CURSOR_35("Cast Shadow Burst", 1080),
	CURSOR_36("Cast Smoke Burst", 1081),
	CURSOR_37("Cast Ice Rush", 1082),
	CURSOR_38("Cast Blood Rush", 1083),
	CURSOR_39("Cast Shadow Rush", 1084),
	CURSOR_40("Cast Smoke Rush", 1085),
	CURSOR_41("Cast High level alchemy", 1094),
	CURSOR_42("Cast Low level alchemy", 1095),
	CURSOR_43("Bait", 1037),
	CURSOR_44("Harpoon", 1037),
	CURSOR_45("Cage", 1037),
	CURSOR_46("Pick-up", 1033),
	CURSOR_47("Pray-at", 1043),
	CURSOR_48("Wear", 1047),
	CURSOR_49("Pickpocket", 1056),
	CURSOR_50("Smelt", 1057),
	CURSOR_51("Adjust", 1063),
	CURSOR_52("Zoom", 1063),
	CURSOR_53("Brightness", 1063),
	CURSOR_54("Cast", 1103),
	CURSOR_55("HAND_CURSOR", 1061);
	
	CursorData(String tooltip, int sprite) {
		this.tooltip = tooltip;
		this.sprite = sprite;
	}
	
	public String tooltip;
	public int sprite;
}
