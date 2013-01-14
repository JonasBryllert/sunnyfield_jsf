package beans;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("userPreferences")
@SessionScoped
public class UserPreferencesBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public UserPreferencesBean() {
		System.out.println("UserPreferencesBean constructor");
	}
	
	public String setLanguage(String language) {
		System.out.println("setLanguage - " + language);
		if ("swedish".equalsIgnoreCase(language)) {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("sv"));
		}
		else {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
		}
		return null;
	}
	
}
