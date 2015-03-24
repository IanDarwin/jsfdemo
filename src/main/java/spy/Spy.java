package spy;

import java.beans.Transient;

/**
 * Represents one secret agent or "spy".
 * @author Ian Darwin
 */
public class Spy {
	
	long id;
	String firstName, lastName;
	String agency;
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param agency
	 */
	public Spy(long id, String firstName, String lastName, String agency) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.agency = agency;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	@Transient
	public String getName() {
		return getFirstName() + ' ' + getLastName();
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}
}

