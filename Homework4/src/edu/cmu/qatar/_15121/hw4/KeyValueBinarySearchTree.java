package edu.cmu.qatar._15121.hw4;

import javax.xml.crypto.Data;
import java.security.Key;
import java.sql.Array;
import java.util.ArrayList;

public class KeyValueBinarySearchTree<KeyType extends Comparable<KeyType>, DataType> {
	private TreeNode root;
	private int size;

	/**
	 * The TreeNode class is a private inner class used (only) by this class
	 */
	private class TreeNode {
		private KeyType key;
		private DataType data;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(KeyType key, DataType data, TreeNode left, TreeNode right) {
			this.key = key;
			this.left = left;
			this.right = right;
			this.data = data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public TreeNode getRight() {
			return right;
		}

		public DataType getData() {
			return data;
		}

		public KeyType getKey() {
			return key;
		}

		public void setLeft(TreeNode node) {
			left = node;
		}

		public void setRight(TreeNode node) {
			right = node;
		}
	}

	public KeyValueBinarySearchTree() {
		root = null;
		size = 0;
	}

	/**
	 * Add an item to the tree.
	 * You should determine the appropriate node to put the item based on the key,
	 * and at the node store both the key and the data.
	 * @param key The key used for searching/finding the appropriate location for the item.
	 * @param data The data to be stored at the location.
	 * @exception IllegalStateException — if attempting to add a key that is already in the tree.
	 */
	public void add(KeyType key, DataType data) {
		TreeNode node = new TreeNode(key,data,null,null);
		if(root == null) {
			root = node;
		}
		else {
			TreeNode p = root;
			while(p.getLeft() != null || p.getRight() != null) {
				if(key == p.getKey()) {
					throw new IllegalStateException("add(KeyType key, DataType data): data already in the tree");
				}
				else if(key.compareTo(p.getKey()) < 0) {
					if(p.getLeft() == null) {
						break;
					}
					p = p.getLeft();
				}
				else if(key.compareTo(p.getKey()) > 0) {
					if(p.getRight() == null) {
						break;
					}
					p = p.getRight();
				}
			}
			if(key.compareTo(p.getKey()) < 0) {
				p.setLeft(node);
			}
			else {
				p.setRight(node);
			}
		}
		size ++;
	}

	/**
	 * Determines and returns the size of the tree (total number of nodes).
	 * @return The number of nodes in the tree.
	 */
	public int size() {
		return size;
	}

	/**
	 * Determine whether or not the tree is empty.
	 * @return true if the tree is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	public int heightCountHelper(TreeNode p) {
		if(p.getLeft() == null && p.getRight() == null) {
			return 0;
		}
		int leftHeight = heightCountHelper(p.getLeft());
		int rightHeight = heightCountHelper(p.getRight());
		return 1 + Math.max(leftHeight,rightHeight);
	}
	/**
	 * Finds and returns the length of the longest path (number of edges) from the root to a leaf.
	 * Recall that the height of a 1-node tree (just the root) is 0 (as is the height of an empty tree)
	 * and the height of a node is the length of the longest path from that node to a leaf.
	 * @return The height of the tree.
	 */
	public int height() {
		return heightCountHelper(root);
	}

	/**
	 * Returns true if this tree is balanced,
	 * meaning that the height of the left subtree and the height of the right subtree of each node
	 * (not just the root) differ by no more than 1; returns false otherwise.
	 * An empty tree is (trivially) balanced.
	 * @return true if the tree is balanced and false otherwise.
	 */
	public boolean isBalanced() {
		int leftHeight = heightCountHelper(root.getLeft());
		int rightHeight = heightCountHelper(root.getRight());
		return Math.abs(leftHeight - rightHeight) <= 1;
	}

	/**
	 * Searches the tree for the node represented by key and returns the data stored at the node.
	 * @param key The key to search for in the tree
	 * @return The data at the node represented by key, or null if the key is not found in the tree.
	 */
	public DataType find(KeyType key) {
		TreeNode p = root;
		if(root == null) {
			return null;
		}
		Boolean find = false;
		while(p != null) {
			if(key.compareTo(p.getKey()) < 0) {
				if(p.getLeft() == null)
					break;
				p = p.getLeft();
			}
			else if(key.compareTo(p.getKey()) > 0){
				if(p.getRight() == null)
					break;
				p = p.getRight();
			}
			else {
				find = true;
				break;
			}
		}
		if(!find)
			return null;
		else
			return p.getData();
	}

	private void inOrderTraverse(TreeNode root, ArrayList<TreeNode> lst) {
		if(root == null) {
			return;
		}
		inOrderTraverse(root.getLeft(),lst);
		lst.add(root);
		inOrderTraverse(root.getRight(),lst);
	}

	/**
	 * Returns a new BST that is a shallow clone of the original,
	 * i.e., contains nodes with the same keys and data in exactly the same locations.
	 * The original tree should not be modified.
	 * @return A clone of the tree.
	 */
	public KeyValueBinarySearchTree<KeyType, DataType> clone() {
		ArrayList<TreeNode> lst = new ArrayList<>();
		inOrderTraverse(root,lst);

		KeyValueBinarySearchTree<KeyType, DataType> new_tree = new KeyValueBinarySearchTree<>();
		for(TreeNode item: lst) {
			new_tree.add(item.getKey(),item.getData());
		}
		return new_tree;
	}

	/**
	 * Returns an ArrayList containing all of the data elements of the tree, sorted according to their keys.
	 * @return An ArrayList of all of the data elements of the tree.
	 */
	public ArrayList<DataType> asList() {
		ArrayList<DataType> lst = new ArrayList<>();
		ArrayList<TreeNode> node_lst = new ArrayList<>();
		inOrderTraverse(root,node_lst);
		for(TreeNode node: node_lst) {
			lst.add(node.getData());
		}
		return lst;
	}


    /**
     * returns a String that prints tree top to bottom, right to left in a 90-degree
     * rotated level view. Do not remove these toString methods, the autograder
     * will make use of them.
     */
    public String toString() {
            StringBuilder result = new StringBuilder();
            return toString(result, -1, root).toString();
    }

    private StringBuilder toString(StringBuilder res, int height, TreeNode rt) {
            if (rt != null) {
                    height++;
                    res = toString(res, height, rt.right);
                    for (int i = 0; i < height; i++) {
                            res.append("\t");
                    }
                    res.append(rt.key + "\n");
                    res = toString(res, height, rt.left);
            }
            return res;
    }
	
	/*
	 * A method to return the root of the tree. This is for the autograder, so don't
	 * rename or remove this.
	 * 
	 * @return The root of the tree.
	 */
	public TreeNode getRoot() {
		return this.root;
	}

	public static void main(String[] args) {
		// Your testcases go here.
		/**
		 * test method:
		 * 1. constructor
		 * 2. add
		 * 3. size
		 * 4. isEmpty()
		 * 5. height()
		 * 6. isBalanced()
		 * 7. find
		 * 8. clone()
		 * 9. asList()
		 * 10. toString()
		 */
	}

}
