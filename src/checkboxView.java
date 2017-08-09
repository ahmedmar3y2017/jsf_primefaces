import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean

public class checkboxView {

	private List<String> cities;

	private List<String> SelectedCities;

	@PostConstruct
	public void init() {
		cities = new ArrayList<>();
		SelectedCities = new ArrayList<>();
		cities.add("cairo");
		cities.add("tanta");
		cities.add("alex");

	}

	public void display() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage("Data Selected : ", SelectedCities.toString()));

	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public List<String> getSelectedCities() {
		return SelectedCities;
	}

	public void setSelectedCities(List<String> selectedCities) {
		SelectedCities = selectedCities;
	}

}
