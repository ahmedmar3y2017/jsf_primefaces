package autoComplete;

public class Employee {

	private int id;
	private String usernmame;
	private String password;

	public Employee() {
		super();
	}

	public Employee(int id, String usernmame, String password) {
		super();
		this.id = id;
		this.usernmame = usernmame;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsernmame() {
		return usernmame;
	}

	public void setUsernmame(String usernmame) {
		this.usernmame = usernmame;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
