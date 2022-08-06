public class Users {

	

	private int id;
	public static int nextId = 1;
	private String role;
	
	private String name;
	private String password;
	private String gender;
	private String address;
	
	private String email;
		
	public Users(String name, String password, String gender, String address) {
		id = nextId;
		nextId++;
		role  = "CCA Admin";
	
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.address = address;
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", role=" + role + ", username=" + name + ", password=" + password + ", gender="
				+ gender + ", address=" + address + ", email=" + email + "]";
	}
	
	
	
}

