package org.necrotic.client.cache.node;

public final class Deque {

	public final Node head;
	private Node current;

	public Deque() {
		head = new Node();
		head.prev = head;
		head.next = head;
	}

	public Node getFirst() {
		Node node = head.next;

		if (node == head) {
			current = null;
			return null;
		} else {
			current = node.next;
			return node;
		}
	}

	public Node getNext() {
		Node node = current;

		if (node == head) {
			current = null;
			return null;
		}

		current = node.next;
		return node;
	}

	public void insertHead(Node node) {
		if (node.next != null) {
			node.unlink();
		}

		node.next = head.next;
		node.prev = head;
		node.next.prev = node;
		node.prev.next = node;
	}

	public void insertTail(Node node) {
		if (node.next != null) {
			node.unlink();
		}

		node.next = head;
		node.prev = head.prev;
		node.next.prev = node;
		node.prev.next = node;
	}

	public final void method894(Node class3, Node class3_27_) {
		if (class3.prev != null) {
			class3.unlink();
		}

		class3.next = class3_27_;
		class3.prev = class3_27_.prev;
		class3.prev.next = class3;
		class3.next.prev = class3;
	}

	public Node popHead() {
		Node node = head.prev;

		if (node == head) {
			return null;
		} else {
			node.unlink();
			return node;
		}
	}

	public void removeAll() {
		if (head.prev == head) {
			return;
		}
		do {
			Node node = head.prev;

			if (node == head) {
				return;
			}

			node.unlink();
		} while (true);
	}

	public Node reverseGetFirst() {
		Node node = head.prev;

		if (node == head) {
			current = null;
			return null;
		} else {
			current = node.prev;
			return node;
		}
	}

	public Node reverseGetNext() {
		Node node = current;

		if (node == head) {
			current = null;
			return null;
		} else {
			current = node.prev;
			return node;
		}
	}

}