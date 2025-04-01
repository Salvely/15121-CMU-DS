package edu.cmu.qatar._15121.hw3;

public class DoubleListNode<NodeDataType> {
	private NodeDataType data; // This field must stay private.
	public DoubleListNode<NodeDataType> next;
	public DoubleListNode<NodeDataType> prev;

	public DoubleListNode(NodeDataType data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public String toString() {
		return data.toString();
	}

	public NodeDataType getData() {
		return data;
	}
}
