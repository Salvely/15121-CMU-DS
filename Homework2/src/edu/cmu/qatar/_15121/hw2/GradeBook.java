/*
 * Full Name:
 * andrew ID:
 * Approximate number of hours spent on this assignment:
 */

package edu.cmu.qatar._15121.hw2;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GradeBook {
	private ArrayList<Student> roster;

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
