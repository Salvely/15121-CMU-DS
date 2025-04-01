package edu.cmu.qatar._15121.hw4;

import java.util.ArrayList;
import java.util.Scanner;

public class AnagramTester {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name of dictionary file: ");
        String fileName = input.nextLine();
        System.out.print("Max word length: ");
        String lengthStr = input.nextLine();
        int maxLength = Integer.parseInt(lengthStr);

        AnagramTree anagrams = new AnagramTree();
        anagrams.loadWords(fileName, maxLength);

        System.out.println("Words in tree: " + anagrams.numWords());
        System.out.println("Nodes in tree: " + anagrams.size());

        if (!anagrams.isEmpty()) {
            System.out.print("\nstring to search [#] to stop: ");
            String searchKey = input.nextLine();
            while (!searchKey.equals("#")) {
                if (searchKey.length() <= maxLength) {
                    ArrayList<String> list = anagrams.findMatches(searchKey);
                    if (list.size() != 0) {
                        System.out.println("  Words that match: " + list);
                    } else {
                        System.out.println("  No words match!");
                    }
                } else {
                    System.out.println("  That word is too long; max length = " + maxLength);
                }

                System.out.print("\nstring to search [#] to stop: ");
                searchKey = input.nextLine();
            }
        }

        input.close();
    }
}