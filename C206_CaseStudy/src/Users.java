//import java.util.Random;

public class Users {

//    Random randomGenerator = new Random();
//    int upperBound = 1000;
//    private int id = randomGenerator.nextInt(upperBound); 
	

	private int id;
	public static int nextId = 1;
	private String role;
	
	private String username;
	private String password;
	private String gender;
	private String address;
		
	public Users(String username, String password, String gender, String address) {
		id = nextId;
		nextId++;
		role  = "CCA Admin";
	
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.address = address;
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
	
}

