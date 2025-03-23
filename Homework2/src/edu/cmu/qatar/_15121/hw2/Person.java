/*
 * Important: Don't change anything inside this file.
 * The autograder relies on this not being changed.
 */

package edu.cmu.qatar._15121.hw2;

public class Person {
    protected String firstName;
    protected String lastName;
    protected int age;

    /**
     * Default constructor.  This isn't very interesting.
     */
    public Person() {
        firstName = "";
        lastName = "";
        age = 0;
    }

    /**
     * Constructor that makes a person based on real data.
     * 
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param age The age of the person
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * A basic toString() method
     */
    public String toString() {
        return firstName + "," + lastName + "," + age;
    }

}
