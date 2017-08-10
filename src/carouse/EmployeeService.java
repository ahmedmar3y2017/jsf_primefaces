package carouse;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="empservice")
@ApplicationScoped
public class EmployeeService {

	static String colors[];

	static {
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";

	}

	public List<Employee> getAllEmployee() {

		List<Employee> seEmployees = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			seEmployees.add(new Employee(i, "user" + i, "pass" + i, "add" + i, getRandomColor()));

		}

		return seEmployees;

	}

	private String getRandomColor() {
		return colors[(int) (Math.random() * 10)];
	}

}
