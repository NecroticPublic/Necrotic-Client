package org.necrotic.client.world;

import org.necrotic.client.renderable.Animable;

public final class Object3 {

	int anInt811;
	int anInt812;
	int anInt813;
	public Animable aClass30_Sub2_Sub4_814;
	public int uid;
	byte aByte816;
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

	public Object3() {
	}

}