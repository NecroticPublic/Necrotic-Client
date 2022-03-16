package org.necrotic.client;

public enum ModIcon {
	
	SUPPORT(837, 10),
	MODERATOR(828, 1),
	ADMINISTRATOR(829, 2),
	OWNER(830, 3),
	DEVELOPER(831, 4),
	CONTRIBUTOR(833, 6),
	MEMBER(834, 7),
	YOUTUBER(1218, 8)
	;
	
	private final int icon, rights;
	
	private ModIcon(int icon, int rights) {
		this.icon = icon;
		this.rights = rights;
	}
	
	public int getIcon() {
		return icon;
	}
	
	public int getRights() {
		return rights;
	}
	
	/**
	 * @author Crimson 
	 * @since Jul 27, 2017
	 * @param spriteId
	 * @return ModIcon that holds same value as spriteId
	 */
	public static ModIcon forSprite(int spriteId) {
		for (ModIcon mi : ModIcon.values()) {
			if (mi.getIcon() == spriteId) {
				return mi;
			}
		}
		return null;
	}
	
	/**
	 * @author Crimson 
	 * @since Jul 27, 2017
	 * @param rights
	 * @return ModIcon that holds same value as rights
	 */
	public static ModIcon forRights(int rights) {
		for (ModIcon mi : ModIcon.values()) {
			if (mi.getRights() == rights) {
				return mi;
			}
		}
		return null;
	}
	
	/**
	 * @author Crimson 
	 * @since Jul 27, 2017
	 * @return the highest value of rights
	 */
	public static final int getMaxRights() {
		int maxValue = 0;
		for (ModIcon m : ModIcon.values()) {
			if (m.getRights() > maxValue) {
				maxValue = m.getRights();
			}
		}
		maxValue += 1;
		return maxValue;
	}

}
