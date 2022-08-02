
public class Student {

	private String name;
	private int student_Id;
	private char gender;
	private String address;
	private int year_of_study;
	private String next_to_kin;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStudent_Id() {
		return student_Id;
	}
	
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getYear_Of_Study() {
		return year_of_study;
	}
	
	public void setYear_Of_Study(int year_of_study) {
		this.year_of_study = year_of_study;
	}
	
	public String getNext_To_Kin() {
		return next_to_kin;
	}
	
	public void setNext_To_Kin(String next_to_kin) {
		this.next_to_kin = next_to_kin;
	}
	
	public Student(String address, int year_of_study, String next_to_kin) {
		this.address = address;
		this.year_of_study = year_of_study;
		this.next_to_kin = next_to_kin;
	}

}
