public class Users {

	protected String id;
	public static int nextId = 1;
	
	private String name;
	private String password;
			
	public Users(String name, String password) {
		id = "A"+nextId;
		nextId++;
		
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

