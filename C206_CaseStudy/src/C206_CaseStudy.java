import java.util.ArrayList;
import java.util.Random;


public class C206_CaseStudy {

	public static void main(String[] args) {
		
		//User Arraylists
		ArrayList<Users> adminList = new ArrayList<>();
		ArrayList<Students> studentsList = new ArrayList<>();
		
		//CCA Arraylists
		ArrayList<CCA> ccaList = new ArrayList<>();
		
//---------------------------------------- Arraylist ----------------------------------------//
		
		//CCA Admin
		//Parameters: String name, String password, String gender, String address
		adminList.add(new Users("admin", "admin", "Male", "Jurong 765432"));
		
		//Students Database
		//Parameters parent Users, int grade, String class_code, String class_teacher,
		//String parentName, String parentEmail, int parentContact
		studentsList.add(new Students("Wunhon", "wunhon", "Male", "King Albert Park 765432", 4, "P4-100", "admin", "Michelle", "mainemailofmarcusneo@gmail.com", 12345678));
		studentsList.add(new Students("Marcus", "marcus", "Male", "Orchard Road 765432", 3, "P3-100", "admin", "Lucious", "mainemailofmarcusneo@gmail.com", 12345678));
		
		//CCAs
		//Parameters String title, String description, int classSize, String dayOfWeek, double timeStart
		//double timeEnd, String venue, String instructor
		ccaList.add(new CCA("Sports", "Football", "Kick ball", 10, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		ccaList.add(new CCA("Sports", "Basketball", "Bounce ball", 10, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		ccaList.add(new CCA("Sports", "Volleyball", "Smack ball", 10, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		
		
//---------------------------------------- 1. Main Program ----------------------------------------//

//---------------------------------------- 1A. Login ----------------------------------------//
		boolean loggedin = false;
		int option = 0;
		String role = "";
			
			while (loggedin == false) {

			//Login Menu	
			C206_CaseStudy.loginmenu();
			option = Helper.readInt("Choose login option > ");
			
			//Admin
			if (option == 1) {
				role = loginAdmin(adminList);
				if (role == "CCA Admin"){						
					C206_CaseStudy.setHeader("Login Successful");
					loggedin = true;
				} 
			}
			
//---------------------------------------- 1B. Task ----------------------------------------//
			
		int optionTask = 0;
			
			if (role.equals("CCA Admin")) {
				while (optionTask != 2) {
					C206_CaseStudy.menu(role);
					System.out.println(ccaList);
					optionTask = Helper.readInt("Choose option > ");
				
					//1. upload cca
					if (optionTask == 1) {
						C206_CaseStudy.addCCA(ccaList);
						
					//2. log out
					} else if (optionTask == 2) { //log out
						loggedin = false; 
					}
				
				}
			}
			
		}
	}
	
	
//---------------------------------------- 2. Methods ----------------------------------------//

	//Header
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//Menu Login
	public static void loginmenu() {
		C206_CaseStudy.setHeader("Login");
		
		System.out.println("1. Admin");
		System.out.println("2. Parent");
		System.out.println("3. Student");
		System.out.println("4. Close");
		Helper.line(80, "-");
		
	}
	
	//User Menu
	public static void menu(String role) {
		C206_CaseStudy.setHeader("Menu");
		//Admin
		if (role.equals("CCA Admin")) {
			System.out.println("1. Upload CCA");
			System.out.println("2. Log out");
			Helper.line(80, "-");
		//Parent
		} else if (role.equals("Parent")) {
			System.out.println("1. Register for CCA");
			System.out.println("2. Log out");
			Helper.line(80, "-");
		//Student
		} else if (role.equals("Student")) {
			System.out.println("1. Register for CCA");
			System.out.println("2. Log out");
			Helper.line(80, "-");
		}
			
		}
	
//---------------------------------------- 2A. Admin ----------------------------------------//

	//login
	public static String loginAdmin(ArrayList<Users> adminAL) {
		String role = "";
		String name = Helper.readString("Enter name > ");
		String password = Helper.readString("Enter password > ");
		
		for (int i = 0; i < adminAL.size(); i++) {
			if (adminAL.get(i).getName().equals(name) && adminAL.get(i).getPassword().equals(password)) {
				role = adminAL.get(i).getRole();
			}
		}
		return role;
	}
	
	//add cca
	public static void addCCA(ArrayList<CCA> ccalist) {
		String category = Helper.readString("Enter category > ");
		String title = Helper.readString("Enter cca title > ");
		String description = Helper.readString("Enter description > ");
		int classSize = Helper.readInt("Enter class size of cca > ");
		String dayOfWeek = Helper.readString("Enter cca day of week > ");
		double timeStart = Helper.readDouble("Enter cca start time > ");
		double timeEnd = Helper.readDouble("Enter cca end time > ");
		String venue = Helper.readString("Enter venue > ");
		String instructor = Helper.readString("Enter instructor in charge > ");
		
		ccalist.add(new CCA(category, title, description, classSize, dayOfWeek, timeStart, timeEnd, venue, instructor));
	}
	
	
//---------------------------------------- 2B. Parent ----------------------------------------//

	//information such as the student ID, name, grade and class, classroom teacher, parent’s name, 
	//parent’s email address, contact No. etc.
	
	//register student/parent
	public static boolean registerStudent(ArrayList<Students> studentlist) {
		boolean registered = false;
		
		String name = Helper.readString("Enter your name > ");
		String email = Helper.readString("Enter your email > ");
		int number = Helper.readInt("Enter your contact number > ");
		
		int studentid = Helper.readInt("Enter your child's student ID > ");
		String studentname = Helper.readString("Enter your child's name > ");
		String grade = Helper.readString("Enter your child's grade > ");
		String classCode = Helper.readString("Enter your child's class > ");
		String classroomteacher = Helper.readString("Enter classroom teacher > ");
		
	    Random random = new Random();
	    int upperBound = 100;
	    int registrationID = random.nextInt(upperBound)+1;   	        
	    
	    for (int i = 0; i < studentlist.size(); i++) {
	    	if studentlist.get(i).get
	    }
	    
		return registered;

		}
	}
	
	//log in
	//view cca, sort, details like vaancy spots
	//register for cca
	//delete cca registration
	
