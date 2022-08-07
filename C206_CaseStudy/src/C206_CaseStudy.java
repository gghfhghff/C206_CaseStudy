import java.util.ArrayList;
import java.util.Random;


public class C206_CaseStudy {

	public static void main(String[] args) {
		
//---------------------------------------- Initialise Arraylist ----------------------------------------//
		//User Arraylists
		ArrayList<Users> adminList = new ArrayList<>();
		ArrayList<RegistrationAccount> studentAccList = new ArrayList<>();

		//Student Database
		ArrayList<Students> studentsList = new ArrayList<>();
		
		//CCA Arraylists
		ArrayList<CCA> ccaList = new ArrayList<>();
		
//---------------------------------------- Populate Arraylist ----------------------------------------//
		
		//CCA Admin
		//Parameters: String name, String password
		adminList.add(new Users("admin", "admin"));
		
		//Student Acc
		//Parameters: int registrationId, String studentId
		studentAccList.add(new RegistrationAccount(1, "S100"));
		studentAccList.add(new RegistrationAccount(2, "S100"));
		studentAccList.add(new RegistrationAccount(3, "S100"));
		studentAccList.add(new RegistrationAccount(4, "S100"));

		
		//Students Database
		//String studentname, String address, String grade, String class_code, String class_teacher,
		//String parentName, String parentEmail, int parentContact
		studentsList.add(new Students("S1", "Wunhon", "King Albert Park 765432", "P4", "P4-100", "Amran Mohamed", "Michelle", "21040247@myrp.edu.sg", 12345678));
		studentsList.add(new Students("S2", "Marcus", "Orchard Road 765432", "P3", "P3-100", "Amran Mohamed", "Lucious", "21040247@myrp.edu.sg", 12345678));

		//CCAs
		//String category, String title, String description, int vacancyOpen, int vacancyTaken, 
		//String dayOfWeek, double timeStart, double timeEnd, String venue, String instructor)
		ccaList.add(new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		ccaList.add(new CCA("Sports", "Basketball", "Bounce ball", 10, 2, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		ccaList.add(new CCA("Sports", "Volleyball", "Smack ball", 10, 0, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		ccaList.add(new CCA("Culinary", "Baking", "Make cake", 20, 5, "Thursday", 15.00, 18.00, "Kitchen", "Mr Amran"));
		ccaList.add(new CCA("Business", "Investment", "Buy Stocks", 20, 8, "Thursday, Friday", 15.00, 18.00, "W65D", "Mr Amran"));

//---------------------------------------- 1. Main Program ----------------------------------------//

		
		boolean loggedin = false;
		int option = 0;
		int optionTask = 0;
		RegistrationAccount accountDetails = null;

		while (option != 4 && loggedin == false) {

			//login admin
			C206_CaseStudy.loginregistermenu();
			option = Helper.readInt("Choose option > ");
			
			//Admin
			if (option == 1) {
				if (loginAdmin(adminList) == true){						
					loggedin = true;
					
					while (optionTask != 5) {
						C206_CaseStudy.menu("CCA Admin");
						optionTask = Helper.readInt("Choose option > ");
					
						//1. upload cca
						if (optionTask == 1) {
							C206_CaseStudy.addCCA(ccaList);
						//2. delete cca	
						} else if (optionTask == 2) {
							C206_CaseStudy.deleteCCA(ccaList);
						//3. update cca
						//4. view cca
						} else if (optionTask == 4) {
							C206_CaseStudy.viewCCAs(ccaList);	
						//5. log out
						} else if (optionTask == 5) {
							loggedin = false; 
						}
					
					}
				}		
			}
			
			//login student
			else if (option == 2) {
				if (loginStudent(studentAccList) == null) {
					accountDetails = loginStudent(studentAccList);
					loggedin = true;

					
					while (optionTask != 4) {
						C206_CaseStudy.menu("Student");
						optionTask = Helper.readInt("Choose option > ");


					if (optionTask == 1) {
						
						C206_CaseStudy.registerCCA(studentAccList, ccaList, accountDetails);
						System.out.println(studentAccList);
					//2. delete cca	
					}
					}
				}
			}
			
			
			//register student
			else if (option == 3) {
				registerStudent(studentsList, studentAccList);
				System.out.println(studentAccList);
			}
			
			//exit
			else if (option == 4) {
				System.out.println("Bye!");
			} 
			
			else {
				System.out.println("Invalid option");
			}
			
		}
//---------------------------------------- 1B. Task ----------------------------------------//			
	}
			
	
//---------------------------------------- 2. Methods ----------------------------------------//

	//Header
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//Menu Login
	public static void loginregistermenu() {
		C206_CaseStudy.setHeader("Login/Register");
		
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Student");
		System.out.println("3. Register");
		System.out.println("4. Close");
		Helper.line(80, "-");
	}
	
	//User Menu
	public static void menu(String role) {
		C206_CaseStudy.setHeader("Menu");
		//Admin
		if (role.equals("CCA Admin")) {
			System.out.println("1. Add CCA");
			System.out.println("2. Delete CCA");
			System.out.println("3. Update CCA");
			System.out.println("4. View CCAs");
			System.out.println("5. Log out");
			Helper.line(80, "-");
		//Parent
		} else if (role.equals("Student")) {
			System.out.println("1. Register for CCA");
			System.out.println("2. Delete registration for CCA");
			System.out.println("3. View registered CCA");
			System.out.println("4. View CCAs");
			System.out.println("5. Log out");
			Helper.line(80, "-");
		} 	
	}
	
//---------------------------------------- 2A. Admin ----------------------------------------//

	//---------------------------------------- Login ----------------------------------------//
	public static boolean loginAdmin(ArrayList<Users> adminAL) {
		boolean loggedin = false;
		String msg = "Login unsuccessful";

		
		String name = Helper.readString("Enter name > ");
		String password = Helper.readString("Enter password > ");
		
		for (int i = 0; i < adminAL.size(); i++) {
			if (adminAL.get(i).getName().equals(name) && adminAL.get(i).getPassword().equals(password)) {
				loggedin = true;
				msg = "Login successful";
				break;
			} 
		}
		C206_CaseStudy.setHeader(msg);
		return loggedin;
	}
	
	//---------------------------------------- Add ----------------------------------------//
	public static void addCCA(ArrayList<CCA> ccalist) {
		String category = Helper.readString("Enter category > ");
		String title = Helper.readString("Enter cca title > ");
		String description = Helper.readString("Enter description > ");
		int vacancy = Helper.readInt("Enter no. of vacancy for cca > ");
		int vacancyTaken = Helper.readInt("Enter no. of taken vacancy for cca > ");
		String dayOfWeek = Helper.readString("Enter cca day(s) of week > ");
		double timeStart = Helper.readDouble("Enter cca start time > ");
		double timeEnd = Helper.readDouble("Enter cca end time > ");
		String venue = Helper.readString("Enter venue > ");
		String instructor = Helper.readString("Enter instructor in charge > ");
		
		if (ccalist.add(new CCA(category, title, description, vacancy, vacancyTaken, dayOfWeek, timeStart, timeEnd, venue, instructor))) {
			C206_CaseStudy.setHeader("Add CCA successful");
		} else {
			C206_CaseStudy.setHeader("Add CCA unsuccessful");
		}
	}
	
	//---------------------------------------- Delete ----------------------------------------//
	public static void deleteCCA(ArrayList<CCA> ccalist) {
		int ccaid = Helper.readInt("Enter CCA id > ");
		
		for (int i = 0; i < ccalist.size(); i++) {
			
			CCA current = ccalist.get(i);
			
			if (ccalist.get(i).getId() == ccaid) {
				if (ccalist.remove(i) == current) {
					C206_CaseStudy.setHeader("Delete CCA Successful");
				} else {
					C206_CaseStudy.setHeader("Delete CCA unsuccessful");
				}
			}
		}
	}
	
	//---------------------------------------- View ----------------------------------------//
	public static void viewCCAs(ArrayList<CCA> ccalist) {	
		String output = "";
		for (int i = 0; i < ccalist.size(); i++) {
			output += ccalist.get(i).toString();
		}
		
		C206_CaseStudy.setHeader("CCA List");
		String headers = String.format("%-4s %-11s %-13s %-15s %-10s %-20s %-12s %-10s %-10s %-15s\n", 
				"ID", "Category", "Name", "Description","Vacancy", "Days", "Time Start", "Time End", "Venue", "Teacher-in-charge");
		System.out.println(headers+output);
	}
	
	
//---------------------------------------- 2B. Student ----------------------------------------//
	
	//---------------------------------------- Register ----------------------------------------//
	public static boolean registerStudent(ArrayList<Students> studentlist, ArrayList<RegistrationAccount> registerAcclist) {
		boolean success = false;
		String msg = "Register unsuccessful";
		
//		String parentname = Helper.readString("Enter your name > ");
//		String email = Helper.readString("Enter your email > ");
//		int contact = Helper.readInt("Enter your contact number > ");
//		String address = Helper.readString("Enter your address > ");
//		
//		String studentID = Helper.readString("Enter your child's student ID > ");
//		String studentName = Helper.readString("Enter your child's name > ");
//		String grade = Helper.readString("Enter your child's grade > ");
//		String classCode = Helper.readString("Enter your child's class > ");
//		String classTeacher = Helper.readString("Enter classroom teacher > ");
//		
//		ArrayList<Students> validationList = new ArrayList<>();
//		validationList.add(new Students(studentID, studentName, address, grade, classCode, classTeacher, parentname, email, contact));

//		for (int i = 0; i < studentlist.size(); i++) {
//				if (studentlist.contains(validationList.get(0))) {
				    int registrationID = C206_CaseStudy.randomUIDGenerator(registerAcclist);
				    registerAcclist.add(new RegistrationAccount(registrationID, ""));
				    msg = "Register successful";
				    success = true;
//				    break;
//				} 
//			}
		C206_CaseStudy.setHeader(msg);
		return success;	
	}
	
	public static int randomUIDGenerator(ArrayList<RegistrationAccount> registerAcclist) {
		
	    Random random = new Random();
	    int upperBound = 6;
	    boolean unique = false;
	    int uniqueID = -1;
		
//	    if (unique != true) {
		    int randomID = random.nextInt(upperBound+1);
	    	for (int i = 0; i < registerAcclist.size(); i++) {
	    		if (registerAcclist.get(i).getRegistrationId() != randomID) {
	    			unique = true;
	    		} else {
	    			randomID = -1;
	    		}
			}
//    	} 
		return randomID;
	}
	
	//---------------------------------------- Login ----------------------------------------//
	public static RegistrationAccount loginStudent(ArrayList<RegistrationAccount> registerAccList) {
		RegistrationAccount obj = null;
		String msg = "Login unsuccessful";
		
		String studentId = Helper.readString("Enter student id > ");
		int registerId = Helper.readInt("Enter registration id > ");
		
		for (int i = 0; i < registerAccList.size(); i++) {
			if (registerAccList.get(i).getStudentId().equals(studentId) && registerId == registerAccList.get(i).getRegistrationId()) {
				obj = new RegistrationAccount(registerId, studentId);	
				msg = "Login successful";
				break;
			}
		}
		C206_CaseStudy.setHeader(msg);
		return obj;
	}
  	        

	public static void registerCCA(ArrayList<RegistrationAccount> registerAcclist, ArrayList<CCA> ccaList, RegistrationAccount details) {
		ArrayList<String> status = new ArrayList<>();
		ArrayList<String> cca = new ArrayList<>();
		
//		C206_CaseStudy.viewCCAs(ccaList);
//		int id = Helper.readInt("Enter CCA ID to register > ");
//
//		//traverse cca list
//		for (int i = 0; i < ccaList.size(); i++) {
//			//match user input cca id and cca id in list
//			if (ccaList.get(i).getId() == id) {
//				String title = ccaList.get(i).getTitle();
//				//check for vacancy
////				if (ccaList.get(i).getVacancyOpen() != ccaList.get(i).getVacancyTaken()) {

					for (int a = 0; a < registerAcclist.size(); a++) {
						if (registerAcclist.get(a).getStudentId() == details.getStudentId()) {
							
							System.out.println(registerAcclist.get(a).getStudentId());
							System.out.println(details.getStudentId());

							cca = registerAcclist.get(a).getRegisteredCCAs();
							cca.add("okay");
							
							System.out.println(cca);

							status = registerAcclist.get(a).getStatus();
							status.add("Pending");
							
							System.out.println(status);

							registerAcclist.get(a).setRegisteredCCAs(cca);
							registerAcclist.get(a).setStatus(status);
							
							System.out.println(registerAcclist);

							
			
//							test.add("okay");
					
//	addRegisteredCCAs(ccaList.get(i).getTitle());
//						}
						}
						}
//						}
//						}
		
						}
	
}
	

	
