package demo;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 * Simple validation of a method in a "home"-type object
 * that can validate based on related state
 * @author Ian Darwin
 */
@ManagedBean 
@SessionScoped
public class GameHomeValidationDemo {
	private boolean gameInPlay;
	private int boardSize = 7;
	
	public void validateNumberRange(FacesContext jsfContext,
            UIComponent toValidate, 
            Object userInputValue) {
		
		if (!gameInPlay) {
			jsfContext.addMessage(
					toValidate.getClientId(jsfContext), 
					new FacesMessage("Game not started"));
	        ((UIInput) toValidate).setValid(false);
	        return;
		}
		int guess = (Integer)userInputValue;
		if (guess < 0 || guess >= boardSize) {
			jsfContext.addMessage(
					toValidate.getClientId(jsfContext), 
					new FacesMessage("Number not in range"));
	        ((UIInput) toValidate).setValid(false);
	        return;
		}
	}

	public void startGame() {
		gameInPlay = true;
	}
	public void endGame() {
		gameInPlay = false;
	}
}
