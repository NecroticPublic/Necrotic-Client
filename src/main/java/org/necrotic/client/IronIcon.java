package org.necrotic.client;

public enum IronIcon {
	
	ULTIMATE(839, 1),
	NORMAL(840, 2)
	;
	
	private final int icon, rights;
	
	private IronIcon(int icon, int rights) {
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
	 * @return IronIcon that holds same value as spriteId
	 */
	public static IronIcon forSprite(int spriteId) {
		for (IronIcon mi : IronIcon.values()) {
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
	 * @return IronIcon that holds same value as rights
	 */
	public static IronIcon forRights(int rights) {
		for (IronIcon mi : IronIcon.values()) {
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
		for (IronIcon m : IronIcon.values()) {
			if (m.getRights() > maxValue) {
				maxValue = m.getRights();
			}
		}
		maxValue += 1;
		return maxValue;
	}

}
