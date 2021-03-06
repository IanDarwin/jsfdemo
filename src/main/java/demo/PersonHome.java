package demo;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named @RequestScoped
public class PersonHome {
	@Inject Person person;
	
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
			FacesMessage message = new FacesMessage("Email in use");
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
