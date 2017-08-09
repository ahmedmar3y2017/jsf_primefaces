package Ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ajaxmenu {

	private String country;
	private String city;
	private Map<String, Map<String, String>> data;

	private Map<String, String> ListCountry;
	private Map<String, String> ListCity;

	@PostConstruct
	public void init() {
		// ListCity = new HashMap<>();
		data = new HashMap<String, Map<String, String>>();
		ListCountry = new HashMap<>();
		ListCountry.put("egypt", "egypt");
		ListCountry.put("usa", "usa");
		ListCountry.put("ksa", "ksa");

		Map<String, String> map = new HashMap<>();
		map.put("cairo", "cairo");
		map.put("tanta", "tanta");
		map.put("alex", "alex");
		data.put("egypt", map);
		map = new HashMap<>();
		map.put("aaa", "aaa");
		map.put("sss", "sss");
		map.put("ddd", "ddd");
		data.put("usa", map);
		map = new HashMap<>();
		map.put("zzz", "zzz");
		map.put("ccc", "ccc");
		map.put("xxx", "xxx");
		data.put("ksa", map);

	}

	public void displayLocation() {
		FacesMessage msg;
		if (city != null && country != null)
			msg = new FacesMessage("Selected", city + " of " + country);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onchange() {

		if (country != null && !country.equals("")) {
			ListCity = data.get(country);
		} else {
			ListCity = new HashMap<>();
		}

	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public void setData(Map<String, Map<String, String>> data) {
		this.data = data;
	}

	public Map<String, String> getListCountry() {
		return ListCountry;
	}

	public void setListCountry(Map<String, String> listCountry) {
		ListCountry = listCountry;
	}

	public Map<String, String> getListCity() {
		return ListCity;
	}

	public void setListCity(Map<String, String> listCity) {
		ListCity = listCity;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
