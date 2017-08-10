package carouse;

public class Employee {
	private int id;

	private String username;
	private String password;
	private String address;
	private String color;

	public Employee(int id, String username, String password, String address, String color) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
