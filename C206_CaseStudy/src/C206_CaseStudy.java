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
		studentAccList.add(new RegistrationAccount(2, "S200"));
		studentAccList.add(new RegistrationAccount(3, "S300"));
		studentAccList.add(new RegistrationAccount(4, "S400"));

		
		//Students Database
		//String studentname, String address, String grade, String class_code, String class_teacher,
		//String parentName, String parentEmail, int parentContact
		studentsList.add(new Students("S1", "Wunhon", "King Albert Park 765432", "P4", "P4-100", "Amran Mohamed", "Michelle", "21040247@myrp.edu.sg", 12345678));
		studentsList.add(new Students("S2", "Marcus", "Orchard Road 765432", "P3", "P3-100", "Amran Mohamed", "Michelle", "21040247@myrp.edu.sg", 12345678));

		//CCAs
		//String category, String title, String description, int vacancyOpen, int vacancTaken, 
		//String dayOfWeek, double timeStart, double timeEnd, String venue, String instructor)
		ccaList.add(new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Amran Mohamed"));
		ccaList.add(new CCA("Sports", "Basketball", "Bounce ball", 10, 2, "Friday", 15.00, 18.00, "Field", "Amran Mohamed"));
		ccaList.add(new CCA("Sports", "Volleyball", "Smack ball", 10, 0, "Friday", 15.00, 18.00, "Field", "Amran Mohamed"));
		ccaList.add(new CCA("Culinary", "Baking", "Make cake", 20, 5, "Thursday", 15.00, 18.00, "Kitchen", "Amran Mohamed"));
		ccaList.add(new CCA("Business", "Investment", "Buy Stocks", 20, 8, "Thursday, Friday", 15.00, 18.00, "W65D", "Amran Mohamed"));

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
							CCA cca = C206_CaseStudy.inputCCA();
							C206_CaseStudy.addCCA(ccaList, cca);
						//2. delete cca	
						} else if (optionTask == 2) {
							C206_CaseStudy.deleteCCA(ccaList);
						//3. update cca
						} else if (optionTask == 3) {
							updateCCADesc(ccaList);
						//4. view ccas
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
				accountDetails = loginRegistrationAcc(studentAccList);
				if (accountDetails != null) {
					loggedin = true;
					
					while (optionTask != 5) {
							C206_CaseStudy.menu("Student");
							optionTask = Helper.readInt("Choose option > ");
						//1. register cca	
						if (optionTask == 1) {
							C206_CaseStudy.registerCCA(studentAccList, ccaList, accountDetails);
						//2. delete cca	
						} 	
						else if (optionTask == 2) {
							C206_CaseStudy.dropRegistration(studentAccList);
						}
						//3. view cca registration status			
						else if (optionTask == 3) {
							C206_CaseStudy.viewRegistrationStatus(studentAccList);
						} 	else if (optionTask == 4) {
							C206_CaseStudy.viewCCAs(ccaList);
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
			System.out.println("3. Add/Update CCA Description");
			System.out.println("4. View CCAs");
			System.out.println("5. Log out");
			Helper.line(80, "-");
		//Parent
		} else if (role.equals("Student")) {
			System.out.println("1. Register for CCA");
			System.out.println("2. Delete registration for CCA");
			System.out.println("3. View CCA registration status");
			System.out.println("4. View CCAs");
			System.out.println("5. Log out");
			Helper.line(80, "-");
		} 	
	}
	
//-------------------------------------------------- 2A. Admin --------------------------------------------------//
	
	//---------------------------------------- Login ----------------------------------------//
	public static boolean loginAdmin(ArrayList<Users> adminAL) {
		boolean success = false;
		String msg = "Login unsuccessful";
		
		String name = Helper.readString("Enter name > ");
		String password = Helper.readString("Enter password > ");
		
		for (int i = 0; i < adminAL.size(); i++) {
			if (adminAL.get(i).getName().equals(name) && adminAL.get(i).getPassword().equals(password)) {
				success = true;
				msg = "Login successful";
				break;
			} 
		}
		C206_CaseStudy.setHeader(msg);
		return success;
	}
	
	//---------------------------------------- 1. Add CCA ----------------------------------------//
	public static CCA inputCCA() {	
		String category = Helper.readString("Enter category > ");
		String title = Helper.readString("Enter cca title > ");
		String description = Helper.readString("Enter description > ");
		Integer vacancy = Helper.readInt("Enter no. of vacancy for cca > ");
		Integer vacancyTaken = Helper.readInt("Enter no. of taken vacancy for cca > ");
		String dayOfWeek = Helper.readString("Enter cca day(s) of week > ");
		Double timeStart = Helper.readDouble("Enter cca start time > ");
		Double timeEnd = Helper.readDouble("Enter cca end time > ");
		String venue = Helper.readString("Enter venue > ");
		String instructor = Helper.readString("Enter instructor in charge > ");

		CCA cca = new CCA(category, title, description, vacancy, vacancyTaken, dayOfWeek, timeStart, timeEnd, venue, instructor);
		return cca;
	}
	
	public static boolean addCCA(ArrayList<CCA> ccalist, CCA cca) {
		String msg = "Add CCA unsuccessful";
		Boolean success = false;
		
		if (ccalist.add(cca)) {
			msg = "Add CCA successful";
			success = true;
		}
		C206_CaseStudy.setHeader(msg);
		return success;
	}
		
//---------------------------------------- 2. Delete CCA ----------------------------------------//
	public static void deleteCCA(ArrayList<CCA> ccalist) {
		int ccaid = Helper.readInt("Enter a CCA id > ");
		doDeleteCCA(ccalist, ccaid);
	}
	
	public static boolean doDeleteCCA(ArrayList<CCA> ccalist, int ccaid) {
		String msg = "Delete CCA unsuccessful";
		Boolean success = false;
		
		for (int i = 0; i < ccalist.size(); i++) {
			if (ccalist.get(i).getId() == ccaid) {
				ccalist.remove(i);
				msg = "Delete CCA successful";
				success = true;
			}
		}	
		C206_CaseStudy.setHeader(msg);
		return success;
	}
		
//---------------------------------------- 3. Update CCA Description ----------------------------------------//
	public static void updateCCADesc(ArrayList<CCA> ccalist) {
		Integer ccaid = Helper.readInt("Enter a CCA id > ");
		String newDesc = Helper.readString("Enter a description > ");
		doUpdateCCADesc(ccalist, ccaid, newDesc);
	}
	
	public static boolean doUpdateCCADesc(ArrayList<CCA> ccalist, int ccaid, String desc) {
		String msg = "Update CCA description unsuccessful";
		Boolean success = false;
		
		for (int i = 0; i < ccalist.size(); i++) {
			if (ccalist.get(i).getId() == ccaid) {
				ccalist.get(i).setDescription(desc);			
				msg = "Update CCA description successful";
				success = true;
			}
		}	
		C206_CaseStudy.setHeader(msg);
		return success;
	}
		
//---------------------------------------- 4. View CCAs ----------------------------------------//
	public static String getCCAs(ArrayList<CCA> ccalist) {
		String output = "";
		
		for (int i = 0; i < ccalist.size(); i++) {
			output += ccalist.get(i).toString();
		}
		return output;
	}
	
	public static void viewCCAs(ArrayList<CCA> ccalist) {
		C206_CaseStudy.setHeader("CCA LIST");
		String output = String.format(
				"%-4s %-11s %-13s %-15s %-10s %-20s %-12s %-10s %-10s %-15s\n", 
				"ID", "Category", "Name", "Description","Vacancy", "Days", "Time Start", "Time End", "Venue", "Teacher-in-charge"
				);
		output += getCCAs(ccalist);	
		System.out.println(output);
	}
	
	//-------------------------------------------------- 2B. Student --------------------------------------------------//
	
//---------------------------------------- 5. Register/Login For Student/Parent Account ----------------------------------------//
	
	//register acc
	public static boolean registerStudent(ArrayList<Students> studentlist, ArrayList<RegistrationAccount> registerAcclist) {
		boolean success = false;
		String msg = "Register unsuccessful";
		
		String parentname = Helper.readString("Enter your name > ");
		String email = Helper.readString("Enter your email > ");
		int contact = Helper.readInt("Enter your contact number > ");
		String address = Helper.readString("Enter your address > ");
	
		String studentID = Helper.readString("Enter your child's student ID > ");
		String studentName = Helper.readString("Enter your child's name > ");
		String grade = Helper.readString("Enter your child's grade > ");
		String classCode = Helper.readString("Enter your child's class > ");
		String classTeacher = Helper.readString("Enter classroom teacher > ");
		
		ArrayList<Students> validationList = new ArrayList<>();
		validationList.add(new Students(studentID, studentName, address, grade, classCode, classTeacher, parentname, email, contact));

		for (int i = 0; i < studentlist.size(); i++) {
				if (studentlist.contains(validationList.get(0))) {
				    int registrationID = C206_CaseStudy.randomUIDGenerator(registerAcclist);
				    registerAcclist.add(new RegistrationAccount(registrationID, ""));
				    msg = "Register successful";
				    success = true;
				    break;
				} 
			}
		C206_CaseStudy.setHeader(msg);
		return success;	
	}
	
	//random id generator
	public static int randomUIDGenerator(ArrayList<RegistrationAccount> registerAcclist) {
		
	    Random random = new Random();
	    int upperBound = 1000;
	    boolean unique = false;
	    int uniqueID = -1;
		
	    if (unique != true) {
	    	uniqueID = random.nextInt(upperBound+1);
	    	for (int i = 0; i < registerAcclist.size(); i++) {
	    		if (registerAcclist.get(i).getRegistrationId() != uniqueID) {
	    			unique = true;
	    		} else {
	    			uniqueID = -1;
	    		}
			}
    	}
		return uniqueID;
	}
	
	//login
	public static RegistrationAccount loginRegistrationAcc(ArrayList<RegistrationAccount> registerAccList) {
		String studentId = Helper.readString("Enter student id > ");
		Integer registerId = Helper.readInt("Enter registration id > ");
		
		//refactor
		RegistrationAccount studentIdentifier = dologinRegistrationAcc(registerAccList, studentId, registerId);
		return studentIdentifier;
	}
	
	public static RegistrationAccount dologinRegistrationAcc(ArrayList<RegistrationAccount> registerAccList, String studentid, int registerid) {
		String msg = "Login unsuccessful";
		RegistrationAccount studentIdentifier = null;

		for (int i = 0; i < registerAccList.size(); i++) {
			if (registerAccList.get(i).getStudentId().equals(studentid) && registerAccList.get(i).getRegistrationId().equals(registerid)) {
				studentIdentifier = new RegistrationAccount(registerid, studentid);	
				msg = "Login successful";
			}
		}
		C206_CaseStudy.setHeader(msg);
		return studentIdentifier;
	}
	
  	        
//---------------------------------------- 6. Register For CCA ----------------------------------------//
	public static void registerCCA(ArrayList<RegistrationAccount> registerAcclist, ArrayList<CCA> ccaList, RegistrationAccount details) {
		C206_CaseStudy.viewCCAs(ccaList);
		int id = Helper.readInt("Enter CCA ID to register > ");
		doRegisterCCA(registerAcclist, ccaList, id, details);
	}
	
	public static boolean doRegisterCCA(ArrayList<RegistrationAccount> registerAcclist, ArrayList<CCA> ccaList, Integer ccaid, RegistrationAccount details) {
		ArrayList<String> status = new ArrayList<>();
		ArrayList<String> cca = new ArrayList<>();
		String ccatitle ="";
		String msg = "Register unsuccessful";
		boolean success = false;
		
		//traverse cca list
		for (int i = 0; i < ccaList.size(); i++) {
			//get title for selected cca
			if (ccaList.get(i).getId().equals(ccaid)) {
				ccatitle = ccaList.get(i).getTitle();
				//check for vacancy
				if (ccaList.get(i).getVacancyOpen() != ccaList.get(i).getVacancyTaken()) {
					//traverse Registration Account list to get Student account to add cca to
					for (int a = 0; a < registerAcclist.size(); a++) {
						if (registerAcclist.get(a).getStudentId().equals(details.getStudentId())) {
							cca = registerAcclist.get(a).getRegisteredCCAs();
							cca.add(ccatitle);
							status = registerAcclist.get(a).getStatus();
							status.add("pending");
							registerAcclist.get(a).setRegisteredCCAs(cca);
							registerAcclist.get(a).setStatus(status);
							msg = "Register successful";
							success = true;
						} 
					}
				} else {
					msg = "No more vacancy";
					}	 
				} 
			}
			C206_CaseStudy.setHeader(msg);
			return success;
	}

	
//---------------------------------------- 7. View CCA Registration Status ----------------------------------------//
	public static void viewRegistrationStatus(ArrayList<RegistrationAccount> registerAcclist) {
		String msg = "";
		
		for (int i = 0; i < registerAcclist.size(); i++) {
			msg+= registerAcclist.get(i).viewRegisteredCCAsAndStatus();
		}
		System.out.println(msg);
	}
	
//---------------------------------------- 8. Delete CCA Registration ----------------------------------------//	
	public static void dropRegistration(ArrayList<RegistrationAccount> registerAcclist) {
		String msg = "Drop unsuccessful";
		ArrayList<String> cca = new ArrayList<>();
		ArrayList<String> status = new ArrayList<>();
		
		String ccaName = Helper.readString("Enter CCA Name to drop > ");
		
		for (int i = 0; i < registerAcclist.size(); i++) {
			if (registerAcclist.get(i).getRegisteredCCAs().equals(ccaName)) {
				registerAcclist.get(i).getRegisteredCCAs().remove(ccaName);
				registerAcclist.get(i).getStatus().remove(i);
				msg = "Drop successful";
			}
		}
		C206_CaseStudy.setHeader(msg);
	}
	
//	public boolean void verifyGrade(ArrayList<Students>, ArrayList<RegistrationAccount> registerAcclist) {
//		boolean check = false;
//		
//		return
//	}
	
}
	

	
