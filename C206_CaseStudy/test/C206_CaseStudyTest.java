import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Students st1;
	private Users us2;
	private CCA cca3;
	private RegistrationAccount ra4;
		
	private ArrayList<Users> adminList;
	private ArrayList<RegistrationAccount> studentAccList;
	private ArrayList<Students> studentsList;
	private ArrayList<CCA> ccaList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		st1 = new Students("S1", "Wunhon", "King Albert Park 765432", "P4", "P4-100", "Amran Mohamed", "Michelle", "21040247@myrp.edu.sg", 12345678);
		us2 = new Users("admin", "admin");
		cca3 = new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Mr Amran");
		ra4 = new RegistrationAccount(1, "S100");
		
		//User Arraylists
		ArrayList<Users> adminList = new ArrayList<>();
		ArrayList<RegistrationAccount> studentAccList = new ArrayList<>();

		//Student Database
		ArrayList<Students> studentsList = new ArrayList<>();
		
		//CCA Arraylists
		ArrayList<CCA> ccaList = new ArrayList<>();
	}
	
	@Test
	public void testAddUsers() {
		// Item list is not null, so that can add a new item - boundary
				assertNotNull("Check if there is valid User arraylist to add to", adminList);
				//Given an empty list, after adding 1 item, the size of the list is 1 - normal
				//The item just added is as same as the first item of the list
				C206_CaseStudy.addUsers(adminList, us2);
				assertEquals("Check that User arraylist size is 1", 1, adminList.size());
				assertSame("Check that User is added", us2, adminList.get(0));
				
				//Add another item. test The size of the list is 2? -normal
				//The item just added is as same as the second item of the list
				C206_CaseStudy.addUsers(adminList, us2);
				assertEquals("Check that User arraylist size is 2", 2, adminList.size());
				assertSame("Check that User is added", us2, adminList.get(1));
			}
	
	@Test
	public void testAddStudents() {
		// Item list is not null, so that can add a new item - boundary
				assertNotNull("Check if there is valid User arraylist to add to", studentsList);
				//Given an empty list, after adding 1 item, the size of the list is 1 - normal
				//The item just added is as same as the first item of the list
				C206_CaseStudy.addStudents(studentsList, st1);
				assertEquals("Check that User arraylist size is 1", 1, studentsList.size());
				assertSame("Check that User is added", st1, studentsList.get(0));
				
				//Add another item. test The size of the list is 2? -normal
				//The item just added is as same as the second item of the list
				C206_CaseStudy.addStudents(studentsList, st1);
				assertEquals("Check that Student arraylist size is 2", 2, studentsList.size());
				assertSame("Check that Student is added", st1, studentsList.get(1));
			}
	
	@Test
	public void testAddCCA() {
		// Item list is not null, so that can add a new item - boundary
				assertNotNull("Check if there is valid User arraylist to add to", ccaList);
				//Given an empty list, after adding 1 item, the size of the list is 1 - normal
				//The item just added is as same as the first item of the list
				C206_CaseStudy.addCCA(ccaList, cca3);
				assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
				assertSame("Check that CCA is added", cca3, ccaList.get(0));
				
				//Add another item. test The size of the list is 2? -normal
				//The item just added is as same as the second item of the list
				C206_CaseStudy.addCCA(ccaList, cca3);
				assertEquals("Check that CCA arraylist size is 2", 2, ccaList.size());
				assertSame("Check that CCA is added", cca3, ccaList.get(1));
			}
	
	@Test
	public void testAddRegisterationAccount() {
		// Item list is not null, so that can add a new item - boundary
				assertNotNull("Check if there is valid User arraylist to add to", studentAccList);
				//Given an empty list, after adding 1 item, the size of the list is 1 - normal
				//The item just added is as same as the first item of the list
				C206_CaseStudy.addRegisterationAccount(studentAccList, ra4);
				assertEquals("Check that Registeration Account arraylist size is 1", 1, studentAccList.size());
				assertSame("Check that Registeration Account is added", ra4, studentAccList.get(0));
				
				//Add another item. test The size of the list is 2? -normal
				//The item just added is as same as the second item of the list
				C206_CaseStudy.addRegisterationAccount(studentAccList, ra4);
				assertEquals("Check that Registeration Account arraylist size is 2", 2, studentAccList.size());
				assertSame("Check that Registeration Account is added", ra4, studentAccList.get(1));
			}
			
	@After
	public void tearDown() throws Exception {
		st1 = null;
		us2 = null;
		cca3 = null;
		ra4 = null;
		
		adminList = null;
		studentAccList = null;
		studentsList = null;
		ccaList= null;
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
