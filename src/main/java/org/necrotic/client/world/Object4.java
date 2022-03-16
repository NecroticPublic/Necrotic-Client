package org.necrotic.client.world;

import org.necrotic.client.renderable.Animable;

final class Object4 {

	int anInt45;
	int anInt46;
	int anInt47;
	Animable aClass30_Sub2_Sub4_48;
	Animable aClass30_Sub2_Sub4_49;
	Animable aClass30_Sub2_Sub4_50;
	int uid;
	int anInt52;
	private int newuid;

	/**
	 * Mutator method for the newuid variable
	 *
	 * @param newUIDReplacement the value assigned towards the newuid variable
	 * @return newuid new universal identification
	 */

	public int setNewUID(int newUIDReplacement) {
		return newuid = newUIDReplacement;
	}

	/**
	 * Gets the new uid
	 *
	 * @return newuid the new universal identifier
	 */
	public int getNewUID() {
		return newuid;
	}

	Object4() {
	}

}