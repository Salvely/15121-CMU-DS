package edu.cmu.qatar._15121.hw4;

public class KeyValueBinarySearchTree<KeyType extends Comparable<KeyType>, DataType> {
	private TreeNode root;

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
	}

}
