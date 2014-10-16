package demo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="searchResults")
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
