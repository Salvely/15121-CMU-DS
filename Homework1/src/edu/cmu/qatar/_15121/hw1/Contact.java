package edu.cmu.qatar._15121.hw1;

/**
 * The Contact class. A contact should have an Andrew ID, a first name, a last
 * name, and a phone number.
 * 
 * Everything for the Andrew ID has been provided as an example.
 * 
 * All of the instance variables must be private (so use getters/setters as
 * needed). The arguments to the constructor are provided.
 *
 */
public class Contact {
	private String andrewId;
	private String firstName;
	private String lastName;
	private String phone;

	public Contact(String andrewId, String firstName, String lastName, String phone) {
		this.andrewId = andrewId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public String getAndrewId() {
		return andrewId;
	}

	public void setAndrewId(String andrewId) {
		this.andrewId = andrewId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	/**
	 * A toString.
	 * 
	 * Should produce the following format: Michael,Trick,trick,1-412-268-3697
	 */
	public String toString() {
		return ", ," + andrewId + "," + firstName + "," + lastName + "," + phone;
	}

}
