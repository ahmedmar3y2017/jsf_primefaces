package carouse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
// @ViewScoped
public class EmployeeView implements Serializable {

	private List<Employee> employees;
	@ManagedProperty("#{empservice}")
	private EmployeeService employeeService;

	private Employee SelectEmployee;

	private List<String> filters;
	private List<String> filtersAddress;

	private List<Employee> filterEmployee;

	@PostConstruct
	public void init() {

		employees = employeeService.getAllEmployee();
		filters = new ArrayList<>();
		filters.add("user0");
		filters.add("user1");
		filtersAddress = new ArrayList<>();
		filtersAddress.add("add0");
		filtersAddress.add("add1");

	}

	public List<String> getFiltersAddress() {
		return filtersAddress;
	}

	public void setFiltersAddress(List<String> filtersAddress) {
		this.filtersAddress = filtersAddress;
	}

	public List<String> getFilters() {
		return filters;
	}

	public void setFilters(List<String> filters) {
		this.filters = filters;
	}

	public List<Employee> getFilterEmployee() {
		return filterEmployee;
	}

	public void setFilterEmployee(List<Employee> filterEmployee) {
		this.filterEmployee = filterEmployee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getSelectEmployee() {
		return SelectEmployee;
	}

	public void setSelectEmployee(Employee selectEmployee) {
		SelectEmployee = selectEmployee;
	}

	public void display(Employee employee) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Object  Selected : ", employee.getUsername()));
	}

}
