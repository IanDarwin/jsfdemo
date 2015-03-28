package demo;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.sun.faces.util.MessageUtils;

@ManagedBean
public class PersonHome {
	@ManagedProperty(value="#{person}") Person person;
	// @PersistenceContext EntityManager em;

	public String savePerson() {
		System.out.println(
			"Saving person " + person.getFirstName() + ' ' + person.getLastName());

		// In real life there'd be code to save the Person to the database!
		// em.persise(person);
		return "welcome";
	}
	
	/** Used when validating a new user to create */
	public void checkEmailAvailable() {
		System.out.println("PersonHome.checkEmailAvailable(): instance = " + person);
				
		// In real life this would check the database:
		// em.createQuery("from Person p where p.email = ?1").getResultList().size() >0
		boolean inUse = person.getEmail().equals("ian@darwinsys.com");

		if (inUse) {
			System.out.println("PersonHome.checkEmailAvailable(): INUSE");
			// This uses the unsupported MessageUtils class to get the message by key
			FacesMessage message = MessageUtils.getExceptionMessage("email_in_use");
			FacesContext.getCurrentInstance().addMessage("myForm:emailTF",
			    message);
		}
	}
	
	public Person getPerson() {
		return person;
	}
	
	public Person getInstance() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
