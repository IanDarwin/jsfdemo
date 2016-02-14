package demo;

import java.time.LocalDateTime;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class SimpleDemo {

	public String getGreeting() {
		return "Hello, World, at " + LocalDateTime.now();
	}

	public void process(String from) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hello from a " + from));
	}
}
