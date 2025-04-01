package edu.cmu.qatar._15121.hw3;

public class DoublyLinkedList<ListType> {
	// The head of the list
	private DoubleListNode<ListType> head;
	int size; // the size of the list

	/*
	 * This getter is needed for the autograder, don't change or remove it.
	 */
	public DoubleListNode<ListType> getHead() {
		return this.head;
	}

	/**
	 * A basic constructor.
	 */
	public DoublyLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * A basic toString(), both forward and reverse.
	 * @return a string with two lines: The list both forward and backward. For example:
	 * List Content Forwards: A –> B –> C
	 * List Content Backwards: C –> B –> A
	 */
	public String toString() {}

	/**
	 * Adds a node containing value after the specified position in the list.
	 * (The new node should be after prevNode in the list)
	 * This method must run in constant time, O(1), or you will lose points!
	 * @param prevNode The node that the new item should be added after. If null, then that means you are adding to an empty list.
	 * @param value The value to add to the list
	 */
	private void addAfter(DoubleListNode<ListType> prevNode, ListType value) {

	}

	/**
	 * Adds a node containing value before the specified position in the list.
	 * (The new node should be before postNode in the list)
	 * This method must run in constant time, O(1), or you will lose points!
	 * @param postNode The node that the new item should be added before. If null,
	 *                 then that means you are adding to an empty list.
	 * @param value The value to add to the list
	 */
	private void addBefore(DoubleListNode<ListType> postNode, ListType value) {

	}

	/**
	 * Add an item to the head of the list.
	 * This method must run in constant time, O(1), or you will lose points!
	 * @param value The value to add to the list
	 */
	public void addHead(ListType value) {

	}

	/**
	 * Add an item to the end of the list
	 * This method must run in constant time, O(1), or you will lose points!
	 * @param value The value to be added to the list
	 */
	public void add(ListType value) {

	}

	/**
	 * Determine how many items are in the list
	 * @return The number of items in the list
	 */
	public int size() {

	}

	/**
	 * Determine whether or not the list is empty.
	 * @return true if the list is empty and false otherwise
	 */
	public boolean isEmpty() {

	}

	/**
	 * Helper Function: Get the node of the first instance of a particular value in the list.
	 * Throws a NoSuchElementException (with no extra message) if the node is not in the list.
	 * @param value The value to search for
	 * @return The node of the first instance of value in the list
	 */
	private DoubleListNode<ListType> nodeContaining(ListType value) {

	}

	/**
	 * Determine if a specified value is in the list.
	 * @param value The value to search for
	 * @return true if the item is in the list and false otherwise
	 */
	public boolean contains(ListType value) {

	}

	/**
	 * Helper Function: Get the node at the position in the list specified by index.
	 * Throws an IndexOutOfBoundsException with an appropriate message if index is out of range.
	 * @param index The index of the item whose node is wanted
	 * @return The node at the provided index
	 */
	private DoubleListNode<ListType> nodeAtIndex(int index) {

	}

	/**
	 * Get an item at a specified index from the list.
	 * Throws an IndexOutOfBoundsException with an appropriate message if index is out of range.
	 * @param index The numeric index (starting from 0) of the item to get
	 * @return The item
	 */
	public ListType get(int index) {

	}

	/**
	 * Adds a node containing value at the specified position in the list,
	 * if such a position can be added to the list.
	 * Throws an IndexOutOfBoundsException with an appropriate message if index is out of range.
	 * @param index The index to add the new value at
	 * @param value The value to add to the list
	 */
	public void add(int index, ListType value) {

	}

	/**
	 * Remove the specified node from the list. You may assume the node is in the list.
	 * This method must run in constant time, O(1), or you will lose points!
	 * @param node  The node to remove from the list
	 * @return The item contained in this node
	 */
	public ListType remove(DoubleListNode<ListType> node) {

	}

	/**
	 * Remove the first instance of an item with a given value from the list.
	 * Throws a NoSuchElementException (with no extra message) if the node is not in the list.
	 * @param value The value of the item to remove.
	 */
	public void remove(ListType value) {

	}

	/**
	 * Remove the node at the position in the list specified by index,
	 * if such a position is in the list, and returns the data value that was at that location.
	 * Throws an IndexOutOfBoundsException with an appropriate message if index is out of range.
	 * @param index The index of the item to remove
	 * @return The item that was removed
	 */
	public ListType remove(int index) {

	}

	/**
	 * Removes the node containing the last occurrence of a value in the list.
	 * Throws a NoSuchElementException (with no extra message) if the node is not in the list.
	 * Note: You need to be intelligent here while searching. If you don’t search correctly,
	 * then you might not pass the autograder, even if your method works.
	 * @param target The item to remove from the list
	 */
	public void removeLast(ListType target) {

	}

	/**
	 * Return a copy of this list transformed into a singly-linked list.
	 * This method must run in linear time, O(N), or you will lose points.
	 * @return A singly linked list that contains the same elements as this list.
	 */
	public SinglyLinkedList<ListType> asSinglyLinkedList() {

	}
}
