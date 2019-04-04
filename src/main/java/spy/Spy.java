package spy;

import java.beans.Transient;
import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 * Represents one secret agent or "spy".
 * @author Ian Darwin
 */
@Named
@ConversationScoped
public class Spy implements Serializable {

	private static final long serialVersionUID = 7069366419729306461L;
	long id;
	String firstName, lastName;
	String agency;
	String comment;
	String email;
	
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

	public Spy() {
		// Most APIs need this empty constructor
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

