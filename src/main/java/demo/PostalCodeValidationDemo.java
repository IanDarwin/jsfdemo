package demo;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Simple validation of a method in a "home"-type object
 * that can validate based on related state
 * @author Ian Darwin
 */
@Named @SessionScoped
public class PostalCodeValidationDemo {

	private Country country;
	
	public void validatePostCode(FacesContext jsfContext,
            UIComponent toValidate, 
            Object userInputValue) {
		
		boolean valid = true;
		String postCode = (String) userInputValue, message = "??";
		switch(country) {
		case CANADA:
			valid = postCode.matches("\\w\\d\\w \\d\\w\\d");
			message = "PostCode must match ANA NAN pattern";
			break;
		case USA:
			valid = postCode.matches("\\d{5}(-\\d{4})?");
			message = "Zip Code must be 5 digits, optional -4 digits";
		case OTHER:
			break;
		default:
			throw new IllegalStateException("Unknown country");
		}
		if (!valid) {
			jsfContext.addMessage(
					toValidate.getClientId(jsfContext), 
					new FacesMessage(message));
	        ((UIInput) toValidate).setValid(false);
	        return;
		}
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
