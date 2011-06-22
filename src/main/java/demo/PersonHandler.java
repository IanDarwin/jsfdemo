package demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class PersonHandler {
	@ManagedProperty(value="#{person}") Person person;

	public String savePerson() {
		System.out.println("Saving person " + person.getFirstName() + ' ' + person.getLastName());
		return "saved";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
