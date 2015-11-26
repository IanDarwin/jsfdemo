package demo;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.*;
import javax.faces.bean.*;
import javax.faces.event.*;

@ManagedBean("localeSetter")
@SessionScoped
public class LocaleSetter implements Serializable {

	String language;
	String region;

	public String getHidden(String field) {
		return FacesContext.getCurrentInstance().
			getExternalContext().getRequestParameterMap().get(field);
	}

	public void update(ActionEvent e) {
		language = getHidden("language");
		region = getHidden("region");
		if (region == null || region.length() == 0) {
			setLocale(language);
		} else {
			setLocale(language, region);
		}
	}

	public String go() {
		return ".";
	}

	public void setLocale(String lang, String region) {
		setLocale(new Locale(lang, region));
	}
	public void setLocale(String lang) {
		setLocale(new Locale(lang));
	}
	public void setLocale(Locale locale) {
		System.out.println("Setting locale to " + locale);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
}
