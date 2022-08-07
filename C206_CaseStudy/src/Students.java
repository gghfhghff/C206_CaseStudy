public class Students {
	
	private String id;
	
	private String studentname;
	private String address;
	private String grade;
	private String class_code;
	private String class_teacher;
			
	private String parentName;
	private String parentEmail;
	private int parentContact;	
    
	public Students(String id, String studentname, String address, 
			String grade, String class_code, String class_teacher,
			String parentName, String parentEmail, int parentContact) {

		this.id = id;
		this.studentname = studentname;
		this.address = address;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
		this.grade = grade;
		this.class_code = class_code;
		this.class_teacher = class_teacher;
	}

	public String getId() {
		return id;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
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

	@Override
	public String toString() {
		return "Students [id=" + id + ", studentname=" + studentname + ", address=" + address + ", grade=" + grade
				+ ", class_code=" + class_code + ", class_teacher=" + class_teacher + ", parentName=" + parentName
				+ ", parentEmail=" + parentEmail + ", parentContact=" + parentContact + "]";
	}
	
	@Override
	public boolean equals(Object obj) {

	if (obj == this) {
	    return true;
	}

	if (!(obj instanceof Students)) {
	    return false;
	}

	Students other = (Students) obj;

	return id.equals(other.id) && studentname.equals(other.studentname) && address.equals(other.address)
			&& grade.equals(other.grade) && class_code.equals(other.class_code) && class_teacher.equals(other.class_teacher)
			&& parentName.equals(other.parentName) && parentEmail.equals(other.parentEmail) && parentContact == other.parentContact;
	}
	
	
}

