package org.necrotic.client.cache.definition;

import org.necrotic.client.List;
import org.necrotic.client.cache.Archive;
import org.necrotic.client.io.ByteBuffer;
import org.necrotic.client.world.Model;

public final class SpotAnimDefinition {

	public static List list = new List(30);
	public static SpotAnimDefinition[] cache;

	public static void load(Archive archive) {
		ByteBuffer stream = new ByteBuffer(archive.get("spotanim.dat"));
		int length = stream.getUnsignedShort();
		if (cache == null)
			cache = new SpotAnimDefinition[length];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null)
				cache[j] = new SpotAnimDefinition();
			cache[j].id = j;
			cache[j].readValues(stream);
			switch (j) {
			case 2959:
				cache[2959].modelId = cache[2114].modelId;
				cache[2959].animationId = cache[2114].animationId;
				cache[2959].animation = cache[2114].animation;
				cache[2959].originalColours = new int[] {127, 49874, -1, -1, -1, -1};
				cache[2959].destColours = new int[] {0, 100, -1, -1, -1, -1};
				//cache[2959].modelId = cache[2114].modelId;
				break;
			}
		}
		custom();
	}

	private static void custom() {
		cache[2274].modelId = cache[2281].modelId;
		cache[2274].animationId = cache[2281].animationId;
		cache[2274].rotation = 90;
		cache[2274].animation = cache[2281].animation;
	}
	/*
	public static void load(Archive archive) {
		ByteBuffer buffer = new ByteBuffer(archive.get("spotanim.dat"));
		int length = buffer.getUnsignedShort();

		if (cache == null) {
			cache = new SpotAnimDefinition[length];
		}

		for (int i = 0; i < length; i++) {
			if (cache[i] == null) {
				cache[i] = new SpotAnimDefinition();
			}

			cache[i].id = i;
			cache[i].readValues(buffer);
			switch (i) {
			case 1247:
				cache[i].modelId = 60776;
				cache[i].animationId = 4001;
				cache[i].animation = Animation.cache[4001];
				break;
			case 1248:
				cache[i].modelId = 60776;
				cache[i].animationId = 4002;
				cache[i].animation = Animation.cache[4002];
				break;
			}
		}
	}*/

	public Animation animation;
	private int id;
	public int modelId;
	private int animationId;
	public int sizeXY;
	public int sizeZ;
	public int rotation;
	public int shadow;
	public int lightness;
	private int[] originalColours;
	private  int[] destColours;

	private SpotAnimDefinition() {
		animationId = -1;
		originalColours = new int[6];
		destColours = new int[6];
		sizeXY = 128;
		sizeZ = 128;
	}

	public Model getModel() {
		Model model = (Model) list.insertFromCache(id);

		if (model != null) {
			return model;
		}

		model = Model.fetchModel(modelId);

		if (model == null) {
			return null;
		}

		for (int i = 0; i < 6; i++) {
			if (originalColours[0] != 0) {
				model.method476(originalColours[i], destColours[i]);
			}
		}

		list.removeFromCache(model, id);
		return model;
	}

	private void readValues(ByteBuffer stream) {
        do {
            int i = stream.getUnsignedByte();
            if (i == 0)
                return;
            if (i == 1) {
                modelId = stream.getUnsignedShort();
            }
            else if (i == 2) {
                animationId = stream.getUnsignedShort();
                if (Animation.cache != null)
                	animation = Animation.cache[animationId];
            } else if (i == 4)
                sizeXY = stream.getUnsignedShort();
            else if (i == 5)
                sizeZ = stream.getUnsignedShort();
            else if (i == 6)
                rotation = stream.getUnsignedShort();
            else if (i == 7)
                shadow = stream.getUnsignedByte();
            else if (i == 8)
                lightness = stream.getUnsignedByte();
            else if (i == 40) {
                int j = stream.getUnsignedByte();
                for (int k = 0; k < j; k++) {
                    originalColours[k] = stream.getUnsignedShort();
                    destColours[k] = stream.getUnsignedShort();
                }
            } else
                System.out.println("Error unrecognised spotanim config code: "
                        + i);
        } while (true);
    }
}