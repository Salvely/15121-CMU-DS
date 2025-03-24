package edu.cmu.qatar._15121.hw3;

public class MyLinkedListTester {

    public static void main(String[] args) {

        System.out.print("Testing the constructor and isEmpty... ");
        SinglyLinkedList<String> theList = new SinglyLinkedList<String>();
        if (theList.isEmpty() != true) {
            System.out.println("failed");
            return;
        }
        System.out.println("passed");

        System.out.print("Testing add... ");
        theList.add("Hi");
        if (theList.isEmpty() == true) {
            System.out.println("failed");
            return;
        }
        System.out.println("passed");

        System.out.print("Testing addHead... ");
        theList.addHead("Bob");
        if (!theList.toString().equals("List Content: Bob --> Hi --> <null>")) {
            System.out.println("failed");
            return;
        }
        System.out.println("passed");

        System.out.print("Testing size... ");
        theList.add("Ahmed");
        if (theList.size() != 3) {
            System.out.println("failed");
            return;
        }
        System.out.println("passed");

        System.out.print("Testing contains... ");
        if (!theList.contains("Bob")) {
            System.out.println("failed");
            return;
        }

        if (theList.contains("Fred")) {
            System.out.println("failed");
            return;
        }
        System.out.println("passed");

        System.out.print("Testing get... ");
        if (!theList.get(1).equals("Hi")) {
            System.out.println("failed");
            return;
        }
        System.out.println("passed");

        System.out.print("Testing toString... ");
        theList.add("Hi");
        if (!theList.toString().equals("List Content: Bob --> Hi --> Ahmed --> Hi --> <null>")) {
            System.out.println("failed");
            return;
        }
        System.out.println("passed");

        System.out.print("Testing remove... ");
        theList.remove("Hi");
        if (!theList.toString().equals("List Content: Bob --> Ahmed --> Hi --> <null>")) {
            System.out.println("failed");
            return;
        }
        if (theList.size() != 3) {
            System.out.println("failed");
            return;
        }
        System.out.println("passed");

        System.out.println("\nNote: The above testcases only test a few things for singly linked lists.");
        System.out.println("You will need to write your own testcases for everything else");

        /*
         * Put your testcases below here. Be sure to read the instructions in the
         * homework handout for details regarding how many testcases you need to write
         * and how to format them.
         */

    }
}
