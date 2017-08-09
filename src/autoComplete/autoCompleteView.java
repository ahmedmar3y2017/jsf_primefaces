package autoComplete;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.SelectEvent;

@ManagedBean
// @SessionScoped
public class autoCompleteView {

	private String txt1;
	private String txt2;
	private String txt3;
	private String txt4;
	private String txt5;
	private String txt6;
	private String txt7;
	private String txt8;

	private Employee employee;
	private Employee employee1;

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private List<Employee> selectedRmployee;

	public List<String> completeText(String query) {

		List<String> result = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			result.add(query + "  " + i);
		}

		return result;

	}

	public List<Employee> completeTheme(String query) {
		List<Employee> employees = employeeService.getEmployees();
		List<Employee> filteredEmployee = new ArrayList<Employee>();

		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.getUsernmame().toLowerCase().startsWith(query)) {
				filteredEmployee.add(employee);

			}

		}

		return filteredEmployee;

	}

	public Employee getEmployee1() {
		return employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public void onItemSelect(SelectEvent event) {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Item Selected : ", event.getObject().toString()));

	}

	public void onItemSelectPojo(SelectEvent event) {
		Employee employee = (Employee) event.getObject();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Item Selected : ", employee.getUsernmame()));

	}

	public char getThemeGroup(Employee employee) {
		return employee.getUsernmame().charAt(0);
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public List<Employee> getSelectedRmployee() {
		return selectedRmployee;
	}

	public void setSelectedRmployee(List<Employee> selectedRmployee) {
		this.selectedRmployee = selectedRmployee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getTxt8() {
		return txt8;
	}

	public void setTxt8(String txt8) {
		this.txt8 = txt8;
	}

	public String getTxt7() {
		return txt7;
	}

	public void setTxt7(String txt7) {
		this.txt7 = txt7;
	}

	public String getTxt6() {
		return txt6;
	}

	public void setTxt6(String txt6) {
		this.txt6 = txt6;
	}

	public String getTxt5() {
		return txt5;
	}

	public void setTxt5(String txt5) {
		this.txt5 = txt5;
	}

	public String getTxt4() {
		return txt4;
	}

	public void setTxt4(String txt4) {
		this.txt4 = txt4;
	}

	public String getTxt3() {
		return txt3;
	}

	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}

	public String getTxt2() {
		return txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

}
