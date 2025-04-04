package edu.cmu.qatar._15121.musicmanager;

import java.util.Arrays;

/*
 * Important note: There are some lines in this file that are too long.  (Lines 56, 57, 62, 63, etc.)
 * The autograder style checker has been setup to allow those lines, and ones like them, without
 * penalty. If you find an error in how the style checker is configured, please contact the instructor
 * about it instead of wasting submissions trying to fix line length issues in this file.
 */

public class MusicLibraryTester {

	/*
	 * Convert an array of songs to an array of strings. This calls toString on each
	 * item in the array. That means toString needs to work properly for Song.
	 */
	private static String[] songToString(Song[] arr) {
		String[] ret = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ret[i] = arr[i].toString();
		}
		return ret;
	}

	/*
	 * Compare two arrays, arr1 and arr2, and make sure they are identical, but
	 * ignore the order. So, ["a","b","c"] is the same as ["b","a","c"].
	 * 
	 * This method is destructive.
	 * 
	 * This is useful for our testcases below.
	 */
	private static boolean compareArraysIgnoreOrder(String[] arr1, String[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}

	/**
	 * Testcases written by the student.
	 */
	public static void studentTestcases() {

	}

	/**
	 * Testcases provided by the instructor. You need to write many more in the
	 * studentTestcases method above.
	 */
	public static void providedTestcases() throws Exception {
		System.out.print("Testing addSong...");
		// Create a new music library
		MusicLibrary test1MusicLibrary = new MusicLibrary();
		// add two songs
		test1MusicLibrary.addSong("Johnny Cash", "I Walk the Line", "The Broadcast Archive (Live)", "Blues");
		test1MusicLibrary.addSong("Rick Astley", "Never Gonna Give You Up", "Whenever You Need Somebody", "Pop");
		// Get back the list of songs
		Song[] test1Results = test1MusicLibrary.getAllSongs();
		// What do I expect as the result?
		String[] test1ExpectedRet = new String[] {
				"Song [artist=Johnny Cash, title=I Walk the Line, album=The Broadcast Archive (Live), genre=Blues]",
				"Song [artist=Rick Astley, title=Never Gonna Give You Up, album=Whenever You Need Somebody, genre=Pop]" };
		// Let's compare
		if (compareArraysIgnoreOrder(test1ExpectedRet, songToString(test1Results))) {
			System.out.println("passed.");
		} else {
			System.out.println("failed.");
			// System.out.println(test1ExpectedRet);
			// System.out.println(Arrays.toString(test1Results));
			return;
		}

		System.out.println(
				"\n*** The instructor provided testcase hs passed, but there is still much more testing for you to do. ***\n");
	}

	public static void main(String[] args) throws Exception {
		providedTestcases();
		studentTestcases();
	}
}