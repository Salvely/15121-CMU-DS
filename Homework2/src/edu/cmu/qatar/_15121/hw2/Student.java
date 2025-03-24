package edu.cmu.qatar._15121.hw2;

import java.util.ArrayList;

/**
 * java.io.FileNotFoundException;
 * java.io.FileReader
 * java.io.PrintWriter
 * java.util.ArrayList
 * java.util.Arrays
 * java.util.Scanner
 */

public class Student extends Person{
    // andrew ID, a major, and an ArrayList of grades.
    private String andrewID;
    private String major;
    private ArrayList<Grade> gradeList;

    // First Name, Last Name, Age, Major, andrew ID, Grade Pairs
    public Student(String firstName, String lastName, int age, String major, String andrewID, ArrayList<Grade> grades) {
        super(firstName,lastName,age);
        this.major = major;
        this.andrewID = andrewID;
        this.gradeList = grades;
    }

    public void addGrade(String name, int grade) {
        Grade g = new Grade(name, grade);
        gradeList.add(g);
    }

    public void changeGrade(String name, int grade) {
        for(int i = 0; i < gradeList.size(); i++) {
            Grade g = gradeList.get(i);
            if(g.getName().compareTo(name) == 0) {
                gradeList.set(i,new Grade(name,grade));
            }
        }
    }

    public String getAndrewID() {
        return andrewID;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<Grade> getGradeList() {
        return gradeList;
    }

    public int getScore(String assignment) {
        for(Grade g: gradeList) {
            if(g.getName().compareTo(assignment) == 0) {
                return g.getGrade();
            }
        }
        return 0;
    }

    public String toString() {
        String str = firstName+","+lastName+","+Integer.toString(age)+","+major+","+andrewID;
        for(Grade g: gradeList) {
            str += ("," + g.getName()+","+g.getGrade());
        }
        str += "\n";
        return str;
    }
}
