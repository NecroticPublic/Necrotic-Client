package org.necrotic.client.cache.node;

public class Node {

	long id;
	public Node prev;
	public Node next;

	public Node() {
	}

	public final void unlink() {
		if (next != null) {
			next.prev = prev;
			prev.next = next;
			prev = null;
			next = null;
		}
	}

}