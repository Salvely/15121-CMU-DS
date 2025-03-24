package edu.cmu.qatar._15121.hw2;

/*
The Grade class will represent and store information about a single grade.
A grade has two components: a name (stored as a String, e.g., HW1)
and the actual grade for that assignment (stored as an int).
You will need to write a constructor for this class as well as a few methods,
such as getters and setters.
 */

public class Grade {
    private String name;
    private int grade;

    public Grade(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
