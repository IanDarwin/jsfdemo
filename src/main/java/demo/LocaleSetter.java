package demo;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named("localeSetter")
@SessionScoped
public class LocaleSetter implements Serializable {

	private static final long serialVersionUID = 6658827577205106791L;
	
	String language;
	String region;

	public String getHidden(String field) {
		return FacesContext.getCurrentInstance().
			getExternalContext().getRequestParameterMap().get(field);
	}

	public void update(ActionEvent e) {
		language = getHidden("language");
		if (language == null) {
			throw new IllegalStateException("'language' didn't make it");
		}
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
