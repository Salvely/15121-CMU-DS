/*
 * Full Name:
 * andrew ID:
 * Approximate number of hours spent on this assignment:
 */

/**
 * java.io.FileNotFoundException;
 * java.io.FileReader
 * java.io.PrintWriter
 * java.util.ArrayList
 * java.util.Arrays
 * java.util.Scanner
 */

package edu.cmu.qatar._15121.hw2;

import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class GradeBook {
	private ArrayList<Student> roster;

	// file format: First Name, Last Name, Age, Major, andrew ID, Grade Pairs, ...
	public GradeBook(String filename) {
		roster = new ArrayList<>();

		// read in the file
		FileReader fr;
		try {
			fr = new FileReader(filename);
		} catch(FileNotFoundException e) {
			System.out.println("Could not open the file!");
			return;
		}
		Scanner inp = new Scanner(fr);

		// Read and print out all lines
		while (inp.hasNextLine()) {
			String theLine = inp.nextLine();
			// use split() to parse the file, initialize each student, add it to the roaster list
			String studentInfo[] = theLine.split(",");
			// iterate each info in the list
			String firstName = studentInfo[0];
			String lastName = studentInfo[1];
			int age = Integer.parseInt(studentInfo[2]);
			String major = studentInfo[3];
			String andrewId = studentInfo[4];
			ArrayList<Grade> grades = new ArrayList<Grade>();
			for(int i = 5; i < studentInfo.length; i += 2) {
				Grade g = new Grade(studentInfo[i],Integer.parseInt(studentInfo[i+1]));
				grades.add(g);
			}
			Student stu = new Student(firstName,lastName,age,major,andrewId,grades);
			roster.add(stu);
		}
		inp.close();
	}

	//  It returns the Student corresponding to the andrew ID provided.
	//  If there is no student with that andrew ID, it returns null.
	private Student findStudent(String id) {
		for(Student stu:roster) {
			String andrewId = stu.getAndrewID();
			if(andrewId.compareTo(id) == 0) {
				return stu;
			}
		}
		return null;
	}

	// Produce an array of the andrew IDs of all students in the gradebook.
	// Returns: A array of andrew IDs of all students in the gradebook.
	public String[] getIds() {
		String[] ids = new String[roster.size()];
		int i = 0;
		for(Student stu:roster) {
			ids[i] = stu.getAndrewID();
			i++;
		}
		return ids;
	}

	/**
	 * Searches the gradebook for all students having a specified major.
	 * @param major  The major to search for
	 * @return An array of the andrew IDs of all students with major in the gradebook.
	 */
	public String[] getIds(String major) {
		ArrayList<String> ids = new ArrayList<>();
		for(Student stu: roster) {
			if(stu.getMajor().compareTo(major) == 0) {
				ids.add(stu.getAndrewID());
			}
		}
		String[] arr = new String[ids.size()];
		int i = 0;
		for(String s: ids) {
			arr[i] = s;
			i++;
		}
		return arr;
	}

	/**
	 * Drops the student with the given andrew ID from the gradebook.
	 * @param id The andrew ID of the student to drop
	 * @return true if successful and false otherwise.
	 */
	public boolean dropStudent(String id) {
		for(Student stu: roster) {
			if(stu.getAndrewID().compareTo(id) == 0) {
				roster.remove(stu);
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the grade of the assignment for the student with the given andrew ID.
	 * @param id The andrew ID of a student
	 * @param assignment An assignment name
	 * @return The grade of student id on assignment.
	 * If the student or assignment could not be found, it returns -1.
	 */
	public int getGrade(String id, String assignment) {
		Student stu = findStudent(id);
		if(stu == null) {
			return -1;
		}
		ArrayList<Grade> grades = stu.getGradeList();
		for(Grade g: grades) {
			if(g.getName().compareTo(assignment) == 0) {
				return g.getGrade();
			}
		}
		return -1;
	}

	/**
	 * Add a grade to the student with the given andrew ID.
	 * @param id The andrew ID of the student to add the grade to.
	 * @param assignment The assignment name.
	 * @param grade The student’s grade on the assignment.
	 * @return true if successful and false otherwise.
	 */
	public boolean addGrade(String id, String assignment, int grade) {
		Student stu = findStudent(id);
		if(stu == null) {
			return false;
		}
		stu.addGrade(assignment,grade);
		return true;
	}

	/**
	 * Change a grade of the student with the given andrew ID.
	 * @param id The andrew ID of the student to change the grade of.
	 * @param assignment  The assignment name.
	 * @param newGrade  The new grade for the student on the assignment.
	 * @return true if successful and false otherwise.
	 */
	public boolean changeGrade(String id, String assignment, int newGrade) {
		int i;
		for(i = 0; i < roster.size(); i++) {
			if(roster.get(i).getAndrewID().compareTo(id) == 0) {
				break;
			}
		}
		Student stu = roster.get(i);
		stu.changeGrade(assignment,newGrade);
		roster.set(i,stu);
		return true;
	}

	/**
	 * Retrieve all the student scores for a given assignment.
	 * @param assignment The assignment to get the scores for.
	 * @return An ArrayList containing all of the student scores for the assignment.
	 * If there are no scores (or the assignment does not exist),
	 * then return an ArrayList containing no values.
	 */
	public ArrayList<Integer> getAssignmentScores(String assignment) {
		ArrayList<Integer> lst = new ArrayList<>();
		for(Student stu: roster) {
			int score = stu.getScore(assignment);
			lst.add(score);
		}
		return lst;
	}

	/**
	 * Calculate the current course average for the specified student.
	 * See the homework handout section entitled “Calculating the Course Average”
	 * for more details about how to compute this value.
	 * @param id The andrew ID of the student.
	 * @return The student’s current course average, or -1 if the student could not be found or had no grades
	 */
	public double getAverage(String id) {
		/**
		 * 40% Homework
		 * 		 * 15% Quizzes
		 * 		 * 20% Midterm Exam
		 * 		 * 25% Final Exam
		 * 		 * if some of the item not here, don't add it to the calculation
		 */
		Student stu = findStudent(id);
		if(stu == null) {
			return -1;
		}
		if(stu.getGradeList().size() == 0) {
			return -1;
		}
		int Q = 0;
		int M = 0;
		int F = 0;
		ArrayList<Grade> grades = stu.getGradeList();
		for(Grade g: grades) {
			if(g.getName().contains("Q")) {
				Q += g.getGrade();
			}
			else if(g.getName().contains("M")) {
				M += g.getGrade();
			}
			else if(g.getName().contains("F")) {
				F += g.getGrade();
			}
		}
		int total = 0;
		int denum = 0;
		if(Q != 0) {
			total += (Q * 15);
			denum += 15;
		}
		if(M != 0) {
			total += (M * 20);
			denum += 20;
		}
		if(F != 0) {
			total += (F * 25);
			denum += 25;
		}
		return 1.0 * total / denum;
	}

	/**
	 * Calculate the current course average for the specified student, but as a letter grade.
	 * (A, B, C, D, R). Apply the standard 90 and above is A, 80 to 90 is B, etc.
	 * @param id The andrew ID of the student.
	 * @return The student’s letter grade or null if the student could not be found or had no grades.
	 */
	public String getAverageLetter(String id) {
		double grade = getAverage(id);
		if(grade == -1 || grade == 0) {
			return null;
		}
		if(grade >= 90) {
			return "A";
		}
		else if(grade >= 80 && grade < 90) {
			return "B";
		}
		else if(grade >= 70 && grade < 80) {
			return "C";
		}
		else if(grade >= 60 && grade < 70) {
			return "D";
		}
		else {
			return "R";
		}
	}

	/**
	 * Needs to correctly return a properly formatted String that represents the contents
	 * (the roster) of the gradebook.
	 * Properly formatted, in this case, means following the same format convention as the input file.
	 * The method here is provided and you shouldn’t change it,
	 * but it relies on a functional toString in Student, which is not provided.
	 * @return
	 */
	public String toString() {
		String str = "";
		for(Student stu: roster) {
			str += stu.toString();
		}
		return str;
	}

	/*
	 * A simple method to check if two doubles are equal up to an epsilon. We need
	 * this to test because you should never do if (a == b) for doubles.
	 */
	public static boolean doubleEquals(double a, double b) {
		if (Math.abs(a - b) < 0.0001) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		System.out.print("Testing the constructor... ");
		GradeBook gb = new GradeBook("easy.txt");
		String expectedResult = "Kavon,Abernathy,18,Biology,kabernat,Q1,54,HW1,61,Q2,63\n"
				+ "Betty,Murphy,24,InfoSys,bmurphy,Q1,99,HW1,73,Q2,63\n"
				+ "Cielo,Collier,23,CompSci,ccollier,Q1,61,HW1,99,Q2,52\n"
				+ "Darrel,Haley,23,Biology,dhaley,Q1,100,HW1,95,Q2,85\n"
				+ "Maida,Weber,18,Business,mweber,Q1,85,HW1,74,Q2,51\n";
		if (gb.toString().equals(expectedResult)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Testing getIds()... ");
		String[] ids = gb.getIds();
		expectedResult = "[kabernat, bmurphy, ccollier, dhaley, mweber]";
		if (Arrays.toString(ids).equals(expectedResult)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Testing getIds(String major)... ");
		ids = gb.getIds("Biology");
		expectedResult = "[kabernat, dhaley]";
		if (Arrays.toString(ids).equals(expectedResult)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Testing dropStudent(String id)... ");
		boolean resp = gb.dropStudent("dhaley");
		expectedResult = "Kavon,Abernathy,18,Biology,kabernat,Q1,54,HW1,61,Q2,63\n"
				+ "Betty,Murphy,24,InfoSys,bmurphy,Q1,99,HW1,73,Q2,63\n"
				+ "Cielo,Collier,23,CompSci,ccollier,Q1,61,HW1,99,Q2,52\n"
				+ "Maida,Weber,18,Business,mweber,Q1,85,HW1,74,Q2,51\n";
		if (gb.toString().equals(expectedResult) && resp == true) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Testing getGrade(String id, String assignment)... ");
		int grade = gb.getGrade("bmurphy", "HW1");
		if (grade == 73) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Testing addGrade(String id, String assignment, int grade)... ");
		gb.addGrade("ccollier", "Q3", 74);
		expectedResult = "Kavon,Abernathy,18,Biology,kabernat,Q1,54,HW1,61,Q2,63\n"
				+ "Betty,Murphy,24,InfoSys,bmurphy,Q1,99,HW1,73,Q2,63\n"
				+ "Cielo,Collier,23,CompSci,ccollier,Q1,61,HW1,99,Q2,52,Q3,74\n"
				+ "Maida,Weber,18,Business,mweber,Q1,85,HW1,74,Q2,51\n";
		if (gb.toString().equals(expectedResult)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Testing changeGrade(String id, String assignment, int newGrade)... ");
		gb.changeGrade("mweber", "Q1", 7);
		expectedResult = "Kavon,Abernathy,18,Biology,kabernat,Q1,54,HW1,61,Q2,63\n"
				+ "Betty,Murphy,24,InfoSys,bmurphy,Q1,99,HW1,73,Q2,63\n"
				+ "Cielo,Collier,23,CompSci,ccollier,Q1,61,HW1,99,Q2,52,Q3,74\n"
				+ "Maida,Weber,18,Business,mweber,Q1,7,HW1,74,Q2,51\n";
		if (gb.toString().equals(expectedResult)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Testing getAssignmentScores(String assignment)... ");
		ArrayList<Integer> scores = gb.getAssignmentScores("Q2");
		if (scores.toString().equals("[63, 63, 52, 51]")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

		System.out.print("Testing getAverage(String id)... ");
		double average = gb.getAverage("kabernat");
		if (doubleEquals(average, 60.3181818181818)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Testing getAverageLetter(String id)... ");
		String letter = gb.getAverageLetter("kabernat");
		if (letter.equals("D")) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.println("\nGreat job! You passed the basic testcases.");
		System.out.println("Please note that these tests only cover the simplest cases in easy.txt");
		System.out.println("Now write your own testcases for harder situations...");
		// Your additional tests go here...
	}

}
