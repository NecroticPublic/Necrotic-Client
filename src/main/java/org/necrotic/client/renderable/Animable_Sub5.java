package org.necrotic.client.renderable;

import org.necrotic.client.Client;
import org.necrotic.client.cache.definition.Animation;
import org.necrotic.client.cache.definition.ObjectDefinition;
import org.necrotic.client.cache.definition.VarBit;
import org.necrotic.client.world.Model;

public final class Animable_Sub5 extends Animable {

	private int anInt1599;
	private final int[] anIntArray1600;
	private final int anInt1601;
	private final int anInt1602;
	private final int anInt1603;
	private final int anInt1604;
	private final int anInt1605;
	private final int anInt1606;
	private Animation aAnimation_1607;
	private int anInt1608;
	public static Client clientInstance;
	private final int anInt1610;
	private final int anInt1611;
	private final int anInt1612;

	public Animable_Sub5(int i, int j, int k, int l, int i1, int j1, int k1, int l1, boolean flag) {
		anInt1610 = i;
		anInt1611 = k;
		anInt1612 = j;
		anInt1603 = j1;
		anInt1604 = l;
		anInt1605 = i1;
		anInt1606 = k1;

		if (l1 != -1) {
			aAnimation_1607 = Animation.cache[l1];
			anInt1599 = 0;
			anInt1608 = Client.loopCycle;

			if (flag && aAnimation_1607.loopDelay != -1) {
				anInt1599 = (int) (Math.random() * aAnimation_1607.frameCount);
				anInt1608 -= (int) (Math.random() * aAnimation_1607.getFrameLength(anInt1599));
			}
		}

		ObjectDefinition class46 = ObjectDefinition.forID(anInt1610);
		anInt1601 = class46.varbitIndex;
		anInt1602 = class46.configID;
		anIntArray1600 = class46.configObjectIDs;
	}

	@Override
	public Model getRotatedModel() {
		int j = -1;

		if (aAnimation_1607 != null) {
			int k = Client.loopCycle - anInt1608;

			if (k > 100 && aAnimation_1607.loopDelay > 0) {
				k = 100;
			}

			while (k > aAnimation_1607.getFrameLength(anInt1599)) {
				k -= aAnimation_1607.getFrameLength(anInt1599);
				anInt1599++;

				if (anInt1599 < aAnimation_1607.frameCount) {
					continue;
				}

				anInt1599 -= aAnimation_1607.loopDelay;

				if (anInt1599 >= 0 && anInt1599 < aAnimation_1607.frameCount) {
					continue;
				}

				aAnimation_1607 = null;
				break;
			}

			anInt1608 = Client.loopCycle - k;

			if (aAnimation_1607 != null) {
				j = aAnimation_1607.frameIDs[anInt1599];
			}
		}

		ObjectDefinition class46;

		if (anIntArray1600 != null) {
			class46 = method457();
		} else {
			class46 = ObjectDefinition.forID(anInt1610);
		}

		if (class46 == null) {
			return null;
		} else {
			return class46.renderObject(anInt1611, anInt1612, anInt1603, anInt1604, anInt1605, anInt1606, j);
		}
	}

	private ObjectDefinition method457() {
		int i = -1;
		if (anInt1601 != -1 && anInt1601 < VarBit.cache.length) {
			VarBit varBit = VarBit.cache[anInt1601];
			int k = varBit.configId;
			int l = varBit.configValue;
			int i1 = varBit.anInt650;
			int j1 = Client.anIntArray1232[i1 - l];
			i = clientInstance.variousSettings[k] >> l & j1;
		} else if (anInt1602 != -1 && anInt1602 < clientInstance.variousSettings.length) {
			i = clientInstance.variousSettings[anInt1602];
		}
		if (i < 0 || i >= anIntArray1600.length || anIntArray1600[i] == -1) {
			return null;
		} else {
			return ObjectDefinition.forID(anIntArray1600[i]);
		}
	}

}