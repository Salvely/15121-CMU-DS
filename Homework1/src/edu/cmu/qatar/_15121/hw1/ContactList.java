package edu.cmu.qatar._15121.hw1;

import java.util.Random;

public class ContactList {
	// A reference to the array used to store items
	private Contact[] contactArray;
	// the actual # of valid array elements (The array might have more space than
	// this in it.)
	private int numContacts;
	// capacity of the contactArray
	private int capacity;

	/**
	 * Constructs a `ContactList` object that can initially hold up to one contact.
	 * The array will later be made larger if needed.
	 */
	public ContactList() {
		this.contactArray = new Contact[1];
		this.numContacts = 0;
		this.capacity = 1;
	}

	/**
	 * Determines if the `ContactList` object is empty or not
	 * 
	 * @return `true` if there are no contacts in the array, and `false` otherwise
	 */
	public boolean isEmpty() {
		return numContacts == 0;
	}

	/**
	 * Determines if the `ContactList` object is full or not
	 * 
	 * @return `true` if array is full and `false` otherwise
	 */
	public boolean isFull() {
		return numContacts == capacity;
	}

	/**
	 * Optional: A helper function you should consider writing. If the ContactList
	 * is currently full, then resize it to be double its current size. To do this,
	 * you'll need to create a new, larger array, and copy the existing items into
	 * it.
	 */
	private void enlarge() {
		Contact new_arr[] = (Contact[]) new Object[capacity * 2];
		for(int i = 0; i < numContacts; i++) {
			new_arr[i] = contactArray[i];
		}
		contactArray = new_arr;
		capacity *= 2;
	}

	/**
	 * Optional: A helper function you should consider writing. Having it might help
	 * you with some of the below methods. You can probably figure out what it
	 * should do...
	 */
	private int findContact(String id) {
		for(int i = 0; i < numContacts; i++) {
			if(!compareTo(id,contactArray[i])) {
				return i;
			}
		}
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
		if(findContact(andrewId) != -1) {
			return false;
		}
		Contact newPeople(andrewId,firstName,lastName,phone);
		if(isFull()) {
			enlarge();
		}
		contactArray[numContacts] = newPeople;
		numContacts += 1;
		return true;
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
		// check if exists the same id, if exists, don't add
		if(findContact(andrewId) == -1) {
			return false;
		}
		// check if loc is reasonable
		if(loc < 0 || loc > numContacts) {
			return false;
		}
		// if full before inserting, then resize the array
		if(isFull()) {
			enlarge();
		}
		// insert the element
		Contact people(andrewId,firstName,lastName,phone);
		for(int i = numContacts; i > loc; i--) {
			contactArray[i] = contactArray[i-1];
		}
		contactArray[loc] = people;
		// update the instance variable
		numContacts ++;
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
		int i = findContact(id);
		if(i == -1) {
			return;
		}
		for(int j = i; j < numContacts - 1; j++) {
			contactArray[j] = contactArray[j + 1];
		}
		numContacts -= 1;
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
		int index = findContact(id);
		if(index == -1) {
			return false;
		}
		contactArray[index].phone = newNumber;
		return true;
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
		for(int i = 0; i <= numContacts - 2; i++) {
			int min = i;
			int max = n - 1;
			int j = random.nextInt(max - min + 1) + min;
			Contact tmp = ContactList[j];
			ContactList[j] = ContactList[i];
			ContactList[i] = tmp;
		}
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
		Contact first = ContactList[0];
		for(int i = 0; i < numContacts - 1; i++) {
			ContactList[i] = ContactList[i+1];
		}
		ContactList[numContacts - 1] = first;
	}

	/**
	 * Reverses the elements stored in the array
	 * 
	 * For example: if the array before the call to reverse is [nkuwari, awaatif,
	 * jpritch, kfrank] it is [kfrank, jpritch, awaatif, nkuwari] after the call
	 */
	public void reverse() {
		for(int i = 0; i < numContacts / 2; i++) {
			Contact tmp = ContactList[i];
			ContactList[i] = ContactList[numContacts - 1 - i];
			ContactList[numContacts - 1 - i] = tmp;
		}
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
		String str = "";
		for(int i = 0; i < numContacts; i++) {
			Contact People = ContactList[i];
			str += People.toString();
			str += "\n";
		}
		return str;
	}
}