package demo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ChoicesDemo {

	boolean enableDemo;

	public final class Country {
		public final String name;
		public final String code;
		Country(String name, String code) {
			this.name = name;
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public String getCode() {
			return code;
		}
	}

	final Country[] countries = {
		new Country("Azerbijan", "AJ"),
		new Country("Benin", "BE")
		// Wish I could remember them all
	};

	public String submit() {
		// This method is invoked to DO SOMETHING with the input values.
		// In this demo we have nothing to do... but say hello
		FacesContext.getCurrentInstance().addMessage(null, 
			new FacesMessage("Submit done, country = " + countryCode));
		return "choicesdemo"; // stay put
	}

	public Country[] getCountries() {
		return countries;
	}

	protected String countryCode;

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public boolean isEnableDemo() {
		return enableDemo;
	}
	public void setEnableDemo(boolean enableDemo) {
		this.enableDemo = enableDemo;
	}
}
