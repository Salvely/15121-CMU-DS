package edu.cmu.qatar._15121.hw3;

public class SingleListNode<NodeDataType> {
		private NodeDataType data; // This field must stay private.
		public SingleListNode<NodeDataType> next;

	public SingleListNode(NodeDataType data) {
		this.data = data;
		this.next = null;
	}

	public String toString() {
		return data.toString();
	}

	public NodeDataType getData() { return data; }
}
