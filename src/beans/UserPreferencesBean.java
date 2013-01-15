package beans;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="userPreferences")
@SessionScoped
public class UserPreferencesBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String language;

	public UserPreferencesBean() {
		System.out.println("UserPreferencesBean constructor");
	}
	
	public String changeLanguage(String language) {
		System.out.println("changeLanguage - " + language);
		this.language = language;
		if ("swedish".equalsIgnoreCase(language)) {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("sv"));
		}
		else {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
		}
		return null;
	}
	
	public String getLanguage() {
		return language;
	}
	
}
