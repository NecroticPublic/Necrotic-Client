package org.necrotic.client.renderable;

import org.necrotic.client.Class33;
import org.necrotic.client.cache.node.NodeSub;
import org.necrotic.client.world.Model;

public class Animable extends NodeSub {

	public void method443(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int uid, int newuid) {
		Model model = getRotatedModel();
		if (model != null) {
			modelHeight = model.modelHeight;
			model.method443(i, j, k, l, i1, j1, k1, l1, uid, newuid);
		}
	}

	public Model getRotatedModel() {
		return null;
	}

	public Animable() {
		modelHeight = 1000;
	}

	public Class33 aClass33Array1425[];
	public int modelHeight;
}
