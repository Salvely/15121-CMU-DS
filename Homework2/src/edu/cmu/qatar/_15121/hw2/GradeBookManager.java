package edu.cmu.qatar._15121.hw2;

import java.util.Scanner;

public class GradeBookManager {
	private GradeBook gb;
	private Scanner inp;

	private int inputInt(String msg) {
		int ret = -1;
		try {
			System.out.print(msg);
			String s = inp.nextLine();
			ret = Integer.parseInt(s);
		} catch (Exception e) {
			ret = -1;
		}
		return ret;
	}

	private void printRoster() {
		String ret = gb.toString();
		System.out.print(ret);
	}

	private void printSingleStudentAverage() {
		System.out.print("Which andrewId? ");
		String id = inp.nextLine();

		double avg = gb.getAverage(id);
		String letter = gb.getAverageLetter(id);

		if (avg != -1 && letter != null) {
			System.out.println(id + ": " + avg + "(" + letter + ")");
		} else {
			System.out.println("Student not found");
		}
	}

	private void printMajorStudentAverage() {
		System.out.print("Which major? ");
		String major = inp.nextLine();

		String[] ids = gb.getIds(major);
		for (String id : ids) {
			double avg = gb.getAverage(id);
			String letter = gb.getAverageLetter(id);

			System.out.println(id + ": " + avg + "(" + letter + ")");
		}
	}

	private void printChangeGrade() {
		String id = null;
		String assignment = null;

		int curGrade = -1;
		while (curGrade == -1) {
			System.out.print("Which student? ");
			id = inp.nextLine();

			System.out.print("Which assignment? ");
			assignment = inp.nextLine();

			curGrade = gb.getGrade(id, assignment);
		}

		System.out.println("Current grade is " + curGrade);
		int newGrade = inputInt("New grade? ");

		gb.changeGrade(id, assignment, newGrade);
	}

	private void printAddGradeForAll() {
		System.out.print("Assignment to add students? ");
		String assignment = inp.nextLine();

		String[] ids = gb.getIds();

		for (String id : ids) {
			int newGrade = inputInt("Score for " + id + ": ");
			gb.addGrade(id, assignment, newGrade);
		}
	}

	private void printDropStudent() {
		System.out.print("Student to drop? ");
		String student = inp.nextLine();

		gb.dropStudent(student);
	}

	public GradeBookManager(String filename) {
		inp = new Scanner(System.in);
		gb = new GradeBook(filename);

		while (true) {
			System.out.println("");
			System.out.println("Welcome to the 15-121 grade book!");
			System.out.println("---------------------------------");
			System.out.println("1) Print roster");
			System.out.println("2) Print course average for one student");
			System.out.println("3) Print course average for all students in a major");
			System.out.println("4) Change a grade");
			System.out.println("5) Add a grade for all students");
			System.out.println("6) Drop a student from the course");
			String choice = inp.nextLine();

			switch (choice) {
			case "1":
				printRoster();
				break;
			case "2":
				printSingleStudentAverage();
				break;
			case "3":
				printMajorStudentAverage();
				break;
			case "4":
				printChangeGrade();
				break;
			case "5":
				printAddGradeForAll();
				break;
			case "6":
				printDropStudent();
				break;
			default:
				System.out.println("Invalid input, please try again.");
			}

		}
	}

	public static void main(String[] args) {
		new GradeBookManager("easy.txt");
	}
}