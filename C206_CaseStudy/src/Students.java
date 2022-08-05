public class Students extends Users{

	private String role;
	private int id;
	
	private int grade;
	private int class_code;
	private String class_teacher;
	private String next_to_kin;
	
	
	public Students(String username, String password, String gender, String address, 
			int grade, int class_code, String class_teacher, String next_to_kin) {
		
		super(username, password, gender, address);

		this.role = "Student";
		this.id = super.getId();
		
		this.grade = grade;
		this.class_code = class_code;
		this.class_teacher = class_teacher;
		this.next_to_kin = next_to_kin;
	}
	

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getClass_code() {
		return class_code;
	}


	public void setClass_code(int class_code) {
		this.class_code = class_code;
	}


	public String getClass_teacher() {
		return class_teacher;
	}


	public void setClass_teacher(String class_teacher) {
		this.class_teacher = class_teacher;
	}


	public String getNext_to_kin() {
		return next_to_kin;
	}


	public void setNext_to_kin(String next_to_kin) {
		this.next_to_kin = next_to_kin;
	}


	@Override
	public String toString() {
		return "Students [role=" + role + ", student_id=" + id + ", grade=" + grade + ", class_code="
				+ class_code + ", class_teacher=" + class_teacher + ", next_to_kin=" + next_to_kin + "]";
	}

	
}

