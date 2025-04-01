package edu.cmu.qatar._15121.hw3;

import java.util.List;
import java.util.NoSuchElementException;

public class SinglyLinkedList<ListType> {
	// The head of the list
	private SingleListNode<ListType> head;
	private int size;

	/*
	 * This getter is needed for the autograder, don't change or remove it.
	 */
	public SingleListNode<ListType> getHead() {
		return this.head;
	}

	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	public String toString() {
		return null;
	}

	/**
	 * Add an item to the head of the list.
	 * @param value The value to add to the list
	 */
	public void addHead(ListType value) {
		SingleListNode<ListType> node = new SingleListNode<>(value);
		if(head == null) {
			head =  node;
		}
		else {
			node.next = head;
			head = node;
		}
		size += 1;
	}

	/**
	 * Add an item to the end of the list.
	 * @param value The value to be added to the list
	 */
	public void add(ListType value) {
		SingleListNode<ListType> new_node = new SingleListNode<>(value);
		new_node.next = null;

		if(head == null) {
			head = new_node;
		}
		else {
			SingleListNode<ListType> p = head;

			while(p.next != null) {
				p = p.next;
			}
			p.next = new_node;
		}
		size ++;
	}

	/**
	 * Determine how many items are in the list
	 * @return The number of items in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Determine whether or not the list is empty.
	 * @return true if the list is empty and false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Determine if a specified value is in the list.
	 * @param value The value to search for
	 * @return true if the item is in the list and false otherwise
	 */
	public boolean contains(ListType value) {
		if(head == null) {
			return false;
		}
		SingleListNode<ListType> p = head;
		while(p.next != null) {
			if(p.getData() == value) {
				return true;
			}
			p = p.next;
		}
		return false;
	}

	/**
	 * Optional Helper Function: Get the node at the position in the list specified by index.
	 * Throws an IndexOutOfBoundsException with an appropriate message if index is out of range.
	 * @param index The index of the item whose node is wanted
	 * @return The node at the provided index
	 */
	private SingleListNode<ListType> nodeAtIndex(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException("nodeAtIndex(): index out of bound");
		}
		SingleListNode<ListType> p = head;
		while(index != 0) {
			p = p.next;
			index --;
		}
		return p;
	}

	/**
	 * Get an item at a specified index from the list.
	 * Throws an IndexOutOfBoundsException with an appropriate message if index is out of range.
	 * @param index The numeric index (starting from 0) of the item to get
	 * @return The item
	 */
	public ListType get(int index) {
		SingleListNode<ListType> p = nodeAtIndex(index);
		return p.getData();
	}

	/**
	 * Adds a node containing value at the specified position in the list,
	 * if such a position can be added to the list.
	 * Throws an IndexOutOfBoundsException with an appropriate message if index is out of range.
	 * @param index  The index to add the new value at
	 * @param value The value to add to the list
	 */
	public void add(int index, ListType value) {
		if(index >= size()) {
			throw new IndexOutOfBoundsException("add(int index, ListType value): index out of bound");
		}
		SingleListNode<ListType> current = head;
		SingleListNode<ListType> previous = null;
		while(index > 0) {
			if(previous == null)
				previous = current;
			else {
				previous = previous.next;
			}
			current = current.next;
			index --;
		}
		SingleListNode<ListType> new_node = new SingleListNode<>(value);
		new_node.next = current;
		if(previous != null)
			previous.next = new_node;
		size ++;
	}

	/**
	 * Remove the specified node from the list.
	 * Throws a NoSuchElementException (with no extra message) if the node is not in the list.
	 * @param node The node to remove from the list
	 * @return The item contained in this node
	 */
	public ListType remove(SingleListNode<ListType> node) {
		if(head == null) {
			throw new NoSuchElementException("remove(SingleListNode<ListType> node): node not in the list");
		}
		else if(head == node) {
			head = head.next;
			size --;
			return node.getData();
		}
		SingleListNode<ListType> current = head.next;
		SingleListNode<ListType> previous = head;
		while(current != null) {
			if(current == node) {
				previous.next = current.next;
				size --;
				return node.getData();
			}
			current = current.next;
			previous = previous.next;
		}
		throw new NoSuchElementException("remove(SingleListNode<ListType> node): node not in the list");
	}

	/**
	 * Remove the first instance of an item with a given value from the list.
	 * Throws a NoSuchElementException (with no extra message) if the node is not in the list.
	 * @param value  The value of the item to remove.
	 */
	public void remove(ListType value) {
		if(head == null) {
			throw new NoSuchElementException("remove(SingleListNode<ListType> node): node not in the list");
		}
		else if(head.getData() == value) {
			head = head.next;
			size --;
			return;
		}
		SingleListNode<ListType> current = head.next;
		SingleListNode<ListType> previous = head;
		while(current != null) {
			if(current.getData() == value) {
				previous.next = current.next;
				size --;
				return;
			}
			current = current.next;
			previous = previous.next;
		}
		throw new NoSuchElementException("remove(SingleListNode<ListType> node): node not in the list");
	}

	/**
	 * Remove the node at the position in the list specified by index,
	 * if such a position is in the list, and returns the data value that was at that location.
	 * Throws an IndexOutOfBoundsException with an appropriate message if index is out of range.
	 * @param index The index of the item to remove
	 * @return The item that was removed
	 */
	public ListType remove(int index) {
		if(index >= size()) {
			throw new IndexOutOfBoundsException("remove(int index): index out of bounds");
		}
		else if(index == 0) {
			ListType val = head.getData();
			head = head.next;
			size --;
			return val;
		}
		SingleListNode<ListType> current = head.next;
		SingleListNode<ListType> previous = head;
		while(index != 0) {
			current = current.next;
			previous = previous.next;
			index --;
		}
		previous.next = current.next;
		size --;
		return current.getData();
	}

	/**
	 * Removes the node containing the last occurrence of a value in the list.
	 * Throws a NoSuchElementException if the node is not in the list.
	 * @param target The item to remove from the list
	 */
	public void removeLast(ListType target) {
		if(head == null) {
			throw new NoSuchElementException("removeLast(ListType target): head is null, no such element");
		}
		SingleListNode<ListType> current, previous, last;
		current = head;
		last = null;
		while(current != null) {
			if(current.getData() == target) {
				last = current;
			}
			current = current.next;
		}
		previous = null;
		current = head;
		while(current != last) {
			previous = current;
			current = current.next;
		}
		if(previous == null) {
			head = head.next;
		}
		else {
			previous.next = current.next;
		}
	}

	/**
	 * This method removes every node in the list that contains a particular value.
	 * Realize that the target can occur multiple times and anywhere in the list!
	 * This method does nothing if the target is not in the list.
	 * This method must run in linear time, O(N), or you will lose points!
	 * @param value The value of the item to remove
	 */
	public void removeAll(ListType value) {
		if(head == null) {
			throw new NoSuchElementException("remove(SingleListNode<ListType> node): node not in the list");
		}
		else if(head.getData() == value) {
			head = head.next;
			size --;
		}
		SingleListNode<ListType> current = head.next;
		SingleListNode<ListType> previous = head;
		while(current != null) {
			if(current.getData() == value) {
				previous.next = current.next;
				current = current.next;
				size --;
			}
			else {
				current = current.next;
				previous = previous.next;
			}
		}
	}
}
