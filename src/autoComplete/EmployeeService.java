package autoComplete;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "employeeService", eager = true)
@ApplicationScoped
public class EmployeeService {

	private List<Employee> employees;

	@PostConstruct
	public void init() {

		employees = new ArrayList<>();

		employees.add(new Employee(1, "ahmed", "123"));
		employees.add(new Employee(2, "mohamed", "123"));
		employees.add(new Employee(3, "eslam", "123"));
		employees.add(new Employee(4, "ali", "123"));
		employees.add(new Employee(5, "eeee", "123"));
		employees.add(new Employee(6, "ekkek", "123"));

	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
