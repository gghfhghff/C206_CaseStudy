public class Parents extends Users{

	private String role;
	private int id;
	
	private String email;

	public Parents(String username, String password, String gender, String address, String email) {
		
		super(username, password, gender, address);
		
		this.role = "Parent";
		this.id = super.getId();
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

