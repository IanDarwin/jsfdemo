package demo;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/** Provide some fake data so that this project can run without needing to set up JPA */
@Named("searchResults") @SessionScoped
public class MockTableData {

	static final List<Person> resultData = new ArrayList<Person>();

	static final String[][] data = {
		{ "Ian", "Darwin", "Toronto", "CA" },
		{ "Robin", "Smithe", "Memphis", "US" },
		{ "Jerri", "McGomeranz", "Edinborough", "UK" },
	};
	
	static {
		for (String[] data : MockTableData.data) {
			Person p = new Person();
			p.setFirstName(data[0]);
			p.setLastName(data[1]);
			p.setCity(data[2]);
			p.setCountry(data[3]);
			resultData.add(p);
		}
		resultData.get(0).setAddress("123 Main St");
	}

	public List<Person> getResults() {
		return resultData;
	}
}
