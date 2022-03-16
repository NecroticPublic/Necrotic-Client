package org.necrotic.client.cache.definition;

import org.necrotic.client.cache.Archive;
import org.necrotic.client.io.ByteBuffer;
import org.necrotic.client.world.Model;

public final class IdentityKit {

	private static int length;
	public static IdentityKit[] cache;

	public static void unpackConfig(Archive streamLoader) {
		ByteBuffer stream = new ByteBuffer(streamLoader.get("idk.dat"));
		setLength(stream.getUnsignedShort());

		if (cache == null) {
			cache = new IdentityKit[getLength()];
		}

		for (int j = 0; j < getLength(); j++) {
			if (cache[j] == null) {
				cache[j] = new IdentityKit();
			}

			cache[j].readValues(stream);
		}
	}

	private int anInt657;
	private int[] anIntArray658;
	private final int[] anIntArray659;
	private final int[] anIntArray660;
	private final int[] anIntArray661 = { -1, -1, -1, -1, -1 };
	private boolean aBoolean662;

	public IdentityKit() {
		setAnInt657(-1);
		anIntArray659 = new int[6];
		anIntArray660 = new int[6];
		setaBoolean662(false);
	}

	public boolean method537() {
		if (anIntArray658 == null) {
			return true;
		}

		boolean flag = true;

		for (int j = 0; j < anIntArray658.length; j++) {
			if (!Model.method463(anIntArray658[j])) {
				flag = false;
			}
		}

		return flag;
	}

	public Model method538() {
		if (anIntArray658 == null) {
			return null;
		}

		Model aclass30_sub2_sub4_sub6s[] = new Model[anIntArray658.length];

		for (int i = 0; i < anIntArray658.length; i++) {
			aclass30_sub2_sub4_sub6s[i] = Model.fetchModel(anIntArray658[i]);
		}

		Model model;

		if (aclass30_sub2_sub4_sub6s.length == 1) {
			model = aclass30_sub2_sub4_sub6s[0];
		} else {
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
		}

		for (int j = 0; j < 6; j++) {
			if (anIntArray659[j] == 0) {
				break;
			}
			model.method476(anIntArray659[j], anIntArray660[j]);
		}

		return model;
	}

	public boolean method539() {
		boolean flag1 = true;

		for (int i = 0; i < 5; i++) {
			if (anIntArray661[i] != -1 && !Model.method463(anIntArray661[i])) {
				flag1 = false;
			}
		}

		return flag1;
	}

	public Model method540() {
		Model aclass30_sub2_sub4_sub6s[] = new Model[5];
		int j = 0;

		for (int k = 0; k < 5; k++) {
			if (anIntArray661[k] != -1) {
				aclass30_sub2_sub4_sub6s[j++] = Model.fetchModel(anIntArray661[k]);
			}
		}

		Model model = new Model(j, aclass30_sub2_sub4_sub6s);

		for (int l = 0; l < 6; l++) {
			if (anIntArray659[l] == 0) {
				break;
			}
			model.method476(anIntArray659[l], anIntArray660[l]);
		}

		return model;
	}

	private void readValues(ByteBuffer buffer) {
		do {
			int opcode = buffer.getUnsignedByte();

			if (opcode == 0) {
				return;
			}
			if (opcode == 1) {
				setAnInt657(buffer.getUnsignedByte());
			} else if (opcode == 2) {
				int j = buffer.getUnsignedByte();
				anIntArray658 = new int[j];
				for (int k = 0; k < j; k++) {
					anIntArray658[k] = buffer.getUnsignedShort();
				}

			} else if (opcode == 3) {
				setaBoolean662(true);
			} else if (opcode >= 40 && opcode < 50) {
				anIntArray659[opcode - 40] = buffer.getUnsignedShort();
			} else if (opcode >= 50 && opcode < 60) {
				anIntArray660[opcode - 50] = buffer.getUnsignedShort();
			} else if (opcode >= 60 && opcode < 70) {
				anIntArray661[opcode - 60] = buffer.getUnsignedShort();
			} else {
				System.out.println("Error unrecognised config code: " + opcode);
			}
		} while (true);
	}

	public boolean isaBoolean662() {
		return aBoolean662;
	}

	public void setaBoolean662(boolean aBoolean662) {
		this.aBoolean662 = aBoolean662;
	}

	public static int getLength() {
		return length;
	}

	public static void setLength(int length) {
		IdentityKit.length = length;
	}

	public int getAnInt657() {
		return anInt657;
	}

	public void setAnInt657(int anInt657) {
		this.anInt657 = anInt657;
	}

}