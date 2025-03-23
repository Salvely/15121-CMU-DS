package edu.cmu.qatar._15121.hw1;

import java.util.Random;

public class ContactList {
	// A reference to the array used to store items
	private Contact[] contactArray;
	// the actual # of valid array elements (The array might have more space than
	// this in it.)
	private int numContacts;

	/**
	 * Constructs a `ContactList` object that can initially hold up to one contact.
	 * The array will later be made larger if needed.
	 */
	public ContactList() {
		this.contactArray = new Contact[1];
		this.numContacts = 0;
	}

	/**
	 * Determines if the `ContactList` object is empty or not
	 * 
	 * @return `true` if there are no contacts in the array, and `false` otherwise
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Determines if the `ContactList` object is full or not
	 * 
	 * @return `true` if array is full and `false` otherwise
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * Optional: A helper function you should consider writing. If the ContactList
	 * is currently full, then resize it to be double its current size. To do this,
	 * you'll need to create a new, larger array, and copy the existing items into
	 * it.
	 */
	private void enlarge() {
		return;
	}

	/**
	 * Optional: A helper function you should consider writing. Having it might help
	 * you with some of the below methods. You can probably figure out what it
	 * should do...
	 */
	private int findContact(String id) {
		return -1;
	}

	/**
	 * Add a contact to the contact list. Verify that the new Contact has a unique
	 * andrew ID and, if so, add the contact after the current last element,
	 * updating `numContacts` appropriately.
	 * 
	 * @param andrewId  The andrewId of the contact
	 * @param firstName The firstname of the contact
	 * @param lastName  The lastname of the contact
	 * @param phone     The phone number of the contact
	 * @return True if the contact was successfully added and false otherwise
	 */
	public boolean addContact(String andrewId, String firstName, String lastName, String phone) {
		return false;
	}

	/**
	 * Adds a new contact to the contact list, making sure it is at location `loc`
	 * of the array. This does not replace an entry in the contact list, instead it
	 * inserts the new contact into that location, shifting other contacts as
	 * needed.
	 * 
	 * Only insert the new contact if there are no existing contacts with the same
	 * andrew ID already in the contact list and the `loc` argument is reasonable.
	 * (You can't, for example, insert at a negative index or insert at an index
	 * that would leave gaps in the array.)
	 * 
	 * e.g., If the array contained [nkuwari, awaatif, jpritch] and this method was
	 * called to insert kfrank, then the array would contain [kfrank, nkuwari,
	 * awaatif, jpritch].
	 * 
	 * If the array is full before inserting, you should resize it first to be
	 * double its current size.
	 * 
	 * Don't forget to update the instance variable that tracks how many items are
	 * stored in the array.
	 * 
	 * @param loc       The index where the new contact should be in the array
	 * @param andrewId  The andrewId of the contact
	 * @param firstName The firstname of the contact
	 * @param lastName  The lastname of the contact
	 * @param phone     The phone number of the contact
	 * @return True if the contact was successfully added and false otherwise
	 */
	public boolean insertContactAtLocation(int loc, String andrewId, String firstName, String lastName, String phone) {
		return false;
	}

	/**
	 * Remove a contact from the contact list. If there is no contact with the
	 * requested andrewId then this method should do nothing. When removing the
	 * contact, other contacts in the array will need to be shifted to ensure there
	 * are no "gaps" in the array.
	 * 
	 * @param id The andrewId of the contact to remove
	 */
	public void removeContact(String id) {
		return;
	}

	/**
	 * Change the phone number of a contact.
	 * 
	 * @param id        The andrewId of the contact whose phone number should be
	 *                  changed
	 * @param newNumber The new phone number
	 * @return True if the number was successfully changed and false otherwise
	 */
	public boolean changePhone(String id, String newNumber) {
		return false;
	}

	// @formatter:off
	/**
	 * Randomize the order of the contacts in the contact list.
	 * 
	 * Use the following algorithm:
	 * for i from 0 to n-2 do
	 *   j = random integer such that i <= j < n
	 *   exchange a[i] and a[j]
	 */
	// @formatter:on
	public void randomize() {
		return;
	}

	/**
	 * Rotates all the elements in the contact list one position to the left,
	 * placing the first element into the last position.
	 * 
	 * For example: if the contact list before the call to rotateLeft is [kfrank,
	 * nkuwari, awaatif, jpritch] it is [nkuwari, awaatif, jpritch, kfrank] after
	 * the call
	 */
	public void rotateLeft() {
		return;
	}

	/**
	 * Reverses the elements stored in the array
	 * 
	 * For example: if the array before the call to reverse is [nkuwari, awaatif,
	 * jpritch, kfrank] it is [kfrank, jpritch, awaatif, nkuwari] after the call
	 */
	public void reverse() {
		return;
	}

	// @formatter:off
	/**
	 * Returns a string representing the contact list.
	 * 
	 * This should generate something in the following format:
	 * 
	 * There are # contacts:
	 * toString from first contact
	 * toString from second contact
	 * ...
	 * 
	 * @return String representing the contact list
	 */
	// @formatter:on
	public String toString() {
		return "";
	}
}