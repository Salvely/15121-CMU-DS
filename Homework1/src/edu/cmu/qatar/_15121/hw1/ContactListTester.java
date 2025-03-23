package edu.cmu.qatar._15121.hw1;

import java.util.Scanner;
import java.io.FileReader;
import java.util.Random;

public class ContactListTester {

	/**
	 * Testcases written by the student.
	 */
	public static void studentTestcases() {

	}

	/*
	 * Helper function provided by the instructor. It just loads contacts from a
	 * file. You don't need to understand what this does. (Yet...)
	 */
	public static boolean loadContacts(ContactList theList, String filename) {
		Scanner myFile;
		try {
			myFile = new Scanner(new FileReader(filename));
		} catch (Exception e) {
			System.out.println("File not found: " + filename);
			return false;
		}

		while (myFile.hasNextLine()) {
			String line = myFile.nextLine();
			String[] items = line.split(",");
			boolean res = theList.addContact(items[2], items[0], items[1], items[3]);
			if (res == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Testcases provided by the instructor. You need to write many more in the
	 * studentTestcases method above.
	 */
	public static void providedTestcases() {
		System.out.print("Testing the constructor and toString of Contact...");
		Contact c = new Contact("trick", "Michael", "Trick", "1-412-268-3697");
		String expectedResult = "Michael,Trick,trick,1-412-268-3697";
		if (c.toString().equals(expectedResult)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print(
				"Creating a contact list, loading contacts from a file, and testing the toString of the contact list...");
		ContactList myList = new ContactList();
		boolean res = loadContacts(myList, "names.txt");
		if (res == false) {
			System.out.println("failed");
			return;
		}
		expectedResult = "There are 19 contacts:\n" + "Chadi,Aoun,caoun,974-4454-8603\n"
				+ "Anis,Charfi,acharfi,974-4454-8206\n" + "Divakaran,Liginlal,liginlal,974-4454-8627\n"
				+ "Selma,Limam Mansar,selmal,974-4454-8650\n" + "Daniel,Phelps,dphelps,974-4454-8624\n"
				+ "Ryan,Riley,rdriley,974-4454-2138\n" + "Faaiz,el Nour,felnour,974-3128-6476\n"
				+ "Maha,AlGhazi,alghazi,974-4819-3813\n" + "Uqbah,Akel,uakel,974-7283-6389\n"
				+ "Sadoon,Houda,shouda,974-3903-4064\n" + "Kabeer,Malek,kmalek2,974-3314-5679\n"
				+ "Baqir,Al Shareef,balshare,974-7895-4775\n" + "Haseena,Al Hariri,halharir,974-7208-8546\n"
				+ "Nader,Al-Kuwari,nkuwari,974-7663-5485\n" + "Naseem,Al Munir,nalmunir,974-4232-4252\n"
				+ "Awaatif,Al-Sala,awaatif,974-6217-1913\n" + "James,Pritchard,jpritch,1-607-953-0510\n"
				+ "Kathryn,Franklin,kfrank,1-425-760-8248\n" + "Jerry,Snow,jrsnow,1-816-914-4660\n";
		if (myList.toString().equals(expectedResult)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.print("Creating a contact list, loading contacts from a file, and then adding one contact...");
		myList = new ContactList();
		res = loadContacts(myList, "names.txt");
		if (res == false) {
			System.out.println("failed");
			return;
		}
		myList.addContact("trick", "Michael", "Trick", "1-412-268-3697");
		expectedResult = "There are 20 contacts:\n" + "Chadi,Aoun,caoun,974-4454-8603\n"
				+ "Anis,Charfi,acharfi,974-4454-8206\n" + "Divakaran,Liginlal,liginlal,974-4454-8627\n"
				+ "Selma,Limam Mansar,selmal,974-4454-8650\n" + "Daniel,Phelps,dphelps,974-4454-8624\n"
				+ "Ryan,Riley,rdriley,974-4454-2138\n" + "Faaiz,el Nour,felnour,974-3128-6476\n"
				+ "Maha,AlGhazi,alghazi,974-4819-3813\n" + "Uqbah,Akel,uakel,974-7283-6389\n"
				+ "Sadoon,Houda,shouda,974-3903-4064\n" + "Kabeer,Malek,kmalek2,974-3314-5679\n"
				+ "Baqir,Al Shareef,balshare,974-7895-4775\n" + "Haseena,Al Hariri,halharir,974-7208-8546\n"
				+ "Nader,Al-Kuwari,nkuwari,974-7663-5485\n" + "Naseem,Al Munir,nalmunir,974-4232-4252\n"
				+ "Awaatif,Al-Sala,awaatif,974-6217-1913\n" + "James,Pritchard,jpritch,1-607-953-0510\n"
				+ "Kathryn,Franklin,kfrank,1-425-760-8248\n" + "Jerry,Snow,jrsnow,1-816-914-4660\n"
				+ "Michael,Trick,trick,1-412-268-3697\n";
		if (myList.toString().equals(expectedResult)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
			return;
		}

		System.out.println(
				"\n*** The instructor provided testcases have passed, but there is still much more testing for you to do. ***\n");

	}

	public static void main(String[] args) {
		providedTestcases();
		studentTestcases();
	}

}
