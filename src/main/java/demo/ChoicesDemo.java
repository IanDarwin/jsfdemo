package demo;

import java.util.Arrays;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named @RequestScoped
public class ChoicesDemo {

	boolean enableDemo;
	protected String countryCode;
	protected String[] colors;
	protected String faveColor;

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
		// Let's pretend we saved the info to a database
		// In this demo we have nothing to do... but say hello
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Profile saved; " + toString()));
		return "choicesdemo"; // stay put
	}

	public Country[] getCountries() {
		return countries;
	}

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

	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

	public String getFaveColor() {
		return faveColor;
	}

	public void setFaveColor(String faveColor) {
		this.faveColor = faveColor;
	}

	public String toString() {
		return "emails enabled = " + enableDemo + 
			", country = " + countryCode + 
			", colors = " + Arrays.asList(colors) + "; fave " + faveColor;
	}
}
