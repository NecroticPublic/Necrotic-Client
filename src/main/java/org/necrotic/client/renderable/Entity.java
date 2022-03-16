package org.necrotic.client.renderable;

import org.necrotic.client.cache.definition.Animation;

public class Entity extends Animable {

	public boolean aBoolean1541;
	public final boolean[] aBooleanArray1553;
	public int anim;
	public int anInt1503;
	public int anInt1504;
	public int anInt1511;
	public int anInt1512;
	public int anInt1513;
	public int anInt1517;
	public int currentForcedAnimFrame;
	public int frameDelay;
	public int gfxId;
	// public int currentAnim;
	public int animCycle;
	public int graphicDelay;
	public int graphicHeight;
	public int currentAnimFrame;
	public int anInt1528;
	public int animationDelay;
	public int anInt1530;
	public int anInt1531;
	public int anInt1537;
	public int anInt1538;
	public int anInt1539;
	public int anInt1540;
	public int anInt1542;
	public int anInt1543;
	public int anInt1544;
	public int anInt1545;
	public int anInt1546;
	public int anInt1547;
	public int anInt1548;
	public int anInt1549;
	public int anInt1552;
	public int anInt1554;
	public int anInt1555;
	public int anInt1556;
	public int anInt1557;
	public int currentHealth;
	public int height;
	public final int[] hitArray;
	public final int[] hitMarkTypes;
	public final int[] hitsLoopCycle;
	public int interactingEntity;
	public int loopCycleStatus;
	public int maxHealth;
	public int runAnimation;
	public final int[] smallX;
	public int smallXYIndex;
	public final int[] smallY;
	public int textCycle;
	public String textSpoken;
	public int turnDirection;
	public int x;
	public int y;
	public int nextIdleAnimationFrame;
	public int currentAnim;
	public int nextGraphicsAnimationFrame;
	public int nextAnimationFrame;
	
	public Entity() {
		smallX = new int[10];
		smallY = new int[10];
		interactingEntity = -1;
		anInt1504 = 32;
		runAnimation = -1;
		height = 200;
		anInt1511 = -1;
		anInt1512 = -1;
		hitArray = new int[4];
		hitMarkTypes = new int[4];
		hitsLoopCycle = new int[4];
		anInt1517 = -1;
		gfxId = -1;
		anim = -1;
		loopCycleStatus = -1000;
		textCycle = 100;
		anInt1540 = 1;
		aBoolean1541 = false;
		aBooleanArray1553 = new boolean[10];
		anInt1554 = -1;
		anInt1555 = -1;
		anInt1556 = -1;
		anInt1557 = -1;
	}

	public boolean isVisible() {
		return false;
	}

	public final void method446() {
		smallXYIndex = 0;
		anInt1542 = 0;
	}

	public final void moveInDir(boolean flag, int i) {
		int j = smallX[0];
		int k = smallY[0];
		if (i == 0) {
			j--;
			k++;
		}
		if (i == 1) {
			k++;
		}
		if (i == 2) {
			j++;
			k++;
		}
		if (i == 3) {
			j--;
		}
		if (i == 4) {
			j++;
		}
		if (i == 5) {
			j--;
			k--;
		}
		if (i == 6) {
			k--;
		}
		if (i == 7) {
			j++;
			k--;
		}
		if (anim != -1 && Animation.cache[anim].priority == 1) {
			anim = -1;
		}
		if (smallXYIndex < 9) {
			smallXYIndex++;
		}
		for (int l = smallXYIndex; l > 0; l--) {
			smallX[l] = smallX[l - 1];
			smallY[l] = smallY[l - 1];
			aBooleanArray1553[l] = aBooleanArray1553[l - 1];
		}
		smallX[0] = j;
		smallY[0] = k;
		aBooleanArray1553[0] = flag;
	}

	public final void setPos(int i, int j, boolean flag) {
		if (anim != -1 && Animation.cache[anim].priority == 1) {
			anim = -1;
		}

		if (!flag) {
			int k = i - smallX[0];
			int l = j - smallY[0];

			if (k >= -8 && k <= 8 && l >= -8 && l <= 8) {
				if (smallXYIndex < 9) {
					smallXYIndex++;
				}
				for (int i1 = smallXYIndex; i1 > 0; i1--) {
					smallX[i1] = smallX[i1 - 1];
					smallY[i1] = smallY[i1 - 1];
					aBooleanArray1553[i1] = aBooleanArray1553[i1 - 1];
				}

				smallX[0] = i;
				smallY[0] = j;
				aBooleanArray1553[0] = false;
				return;
			}
		}

		smallXYIndex = 0;
		anInt1542 = 0;
		anInt1503 = 0;
		smallX[0] = i;
		smallY[0] = j;
		x = smallX[0] * 128 + anInt1540 * 64;
		y = smallY[0] * 128 + anInt1540 * 64;
	}

	public int[] hitmarkMove = new int[4];
	public int[] moveTimer = new int[4];
	public int[] hitmarkTrans = new int[4];
	public int[] hitIcon = new int[4];
	public int[] soakDamage = new int[4];
	public int[] hitMarkPos = new int[4];

	public final void updateHitData(int markType, int damage, int l, int icon, int soak) {
		for (int i1 = 0; i1 < 4; i1++)
			if (hitsLoopCycle[i1] <= l) {
				hitIcon[i1] = icon;
				hitmarkMove[i1] = 5;
				moveTimer[i1] = 2;
				hitmarkTrans[i1] = 255;
				soakDamage[i1] = soak;
				hitArray[i1] = damage;
				hitMarkTypes[i1] = markType;
				hitsLoopCycle[i1] = l + 70;
				hitMarkPos[i1] = 0;
				return;
			}
	}

}