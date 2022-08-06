public class Students extends Users{

	private String role;
	private int id;
	
	private int grade;
	private String class_code;
	private String class_teacher;
	
	private int registrationID;
	
	private String parentName;
	private String parentEmail;
	private int parentContact;	
    
	public Students(String name, String password, String gender, String address, 
			int grade, String class_code, String class_teacher,
			String parentName, String parentEmail, int parentContact) {
		
		super(name, password, gender, address);

		this.role = "Student";
		this.id = super.getId();
		
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
		this.grade = grade;
		this.class_code = class_code;
		this.class_teacher = class_teacher;
		
		registrationID = -1;
	}
	
	public int getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(int registrationID) {
		this.registrationID = registrationID;
	}
	

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}
	
	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public int getParentContact() {
		return parentContact;
	}

	public void setParentContact(int parentContact) {
		this.parentContact = parentContact;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getClass_code() {
		return class_code;
	}

	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}

	public String getClass_teacher() {
		return class_teacher;
	}

	public void setClass_teacher(String class_teacher) {
		this.class_teacher = class_teacher;
	}
	
}

