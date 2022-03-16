package org.necrotic.client.cache.node;

public class NodeSub extends Node {

	NodeSub nextNodeSub;
	NodeSub prevNodeSub;

	public NodeSub() {
	}

	public final void unlinkSub() {
		if (nextNodeSub != null) {
			nextNodeSub.prevNodeSub = prevNodeSub;
			prevNodeSub.nextNodeSub = nextNodeSub;
			prevNodeSub = null;
			nextNodeSub = null;
		}
	}

}