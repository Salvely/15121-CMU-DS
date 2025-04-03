package edu.cmu.qatar._15121.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AnagramTree {
    private KeyValueBinarySearchTree<String, ArrayList<String>> tree;

    public AnagramTree() {
        tree = new KeyValueBinarySearchTree<>();
    }

    private String sortString(String line) {
        char[] charArray = line.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    /**
     * Reads in words of length <= maxLen and stores them in ArrayLists in the tree,
     * indexed by the sorted form of the word.
     * This method does not have an explicit efficiency requirement,
     * but if you are too inefficient then the autograder will timeout.
     * @param filename The file to read words from.
     * @param maxLen The maximum length of a word.
     */
    public void loadWords(String filename, int maxLen) {
        FileReader fr;
        try {
            fr = new FileReader(filename);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        Scanner input = new Scanner(fr);
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(line.length() <= maxLen) {
                String key = sortString(line);
                ArrayList<String> data = tree.find(key);
                if(data == null || data.size() == 0) {
                    data = new ArrayList<>();
                    data.add(line);
                    tree.add(key,data);
                }
                else {
                    tree.find(key).add(line);
                }
            }
        }
    }

    /**
     * Returns whether or not the tree is empty (has no nodes)
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tree.size() == 0;
    }

    /**
     * Determines and returns the size of the tree (number of nodes) storing the anagrams.
     * @return The number of nodes in the tree.
     */
    public int size() {
        return tree.size();
    }

    /**
     * Return the total number of words that have been added to the tree.
     * @return The number of words in the tree.
     */
    public int numWords() {
        ArrayList<ArrayList<String>> lst = tree.asList();
        int count = 0;
        for(ArrayList<String> item: lst) {
            count += item.size();
        }
        return count;
    }

    /**
     * Searches the tree given a word and returns a list of all the words that are anagrams of it.
     * @param word A word
     * @return An ArrayList containing all the words in the tree that are anagrams of word.
     */
    public ArrayList<String> findMatches(String word) {
        word = sortString(word);
        return tree.find(word);
    }
}