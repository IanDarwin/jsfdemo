package demo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PersonDao {
	public String savePerson(Person p) {
		System.out.println("Saving person " + p.getFirstName() + ' ' + p.getLastName());
		return "saved";
	}
}
