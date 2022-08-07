import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Students st1;
	private Students st2;
	private Students st3;

	private Users us1;
	
	private CCA cca1;
	private CCA cca2;
	private CCA cca3;
	private CCA cca4;

	private RegistrationAccount ra1;
		
	ArrayList<Users> adminList = new ArrayList<>();
	ArrayList<RegistrationAccount> studentAccList = new ArrayList<>();

	//Student Database
	ArrayList<Students> studentsList = new ArrayList<>();
	
	//CCA Arraylists
	ArrayList<CCA> ccaList = new ArrayList<>();
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		
		studentAccList.add(new RegistrationAccount(1, "S100"));
		studentAccList.add(new RegistrationAccount(2, "S200"));
		studentAccList.add(new RegistrationAccount(3, "S300"));
		studentAccList.add(new RegistrationAccount(4, "S400"));
		
		//Students Database
		//String studentname, String address, String grade, String class_code, String class_teacher,
		//String parentName, String parentEmail, int parentContact
		studentsList.add(new Students("S1", "Wunhon", "King Albert Park 765432", "P4", "P4-100", "Amran Mohamed", "Michelle", "21040247@myrp.edu.sg", 12345678));
		studentsList.add(new Students("S2", "Marcus", "Orchard Road 765432", "P3", "P3-100", "Amran Mohamed", "Lucious", "21040247@myrp.edu.sg", 12345678));

		//CCAs
		//String category, String title, String description, int vacancyOpen, int vacancyTaken, 
		//String dayOfWeek, double timeStart, double timeEnd, String venue, String instructor)
		ccaList.add(new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
//		ccaList.add(new CCA("Sports", "Basketball", "Bounce ball", 10, 2, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
//		ccaList.add(new CCA("Sports", "Volleyball", "Smack ball", 10, 0, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
//		ccaList.add(new CCA("Culinary", "Baking", "Make cake", 20, 5, "Thursday", 15.00, 18.00, "Kitchen", "Mr Amran"));
//		ccaList.add(new CCA("Business", "Investment", "Buy Stocks", 20, 8, "Thursday, Friday", 15.00, 18.00, "W65D", "Mr Amran"));
		
		cca1 = new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Mr Amran");
	}
	
	@Test
	public void testAddCCA() {
		// Item list is not null, so that can add a new item - boundary
				assertNotNull("Check if there is valid User arraylist to add to", ccaList);
				//Given an empty list, after adding 1 item, the size of the list is 1 - normal
				//The item just added is as same as the first item of the list
				C206_CaseStudy.addCCA(ccaList);
				assertEquals("Check that User arraylist size is 1", 1, ccaList.size());
				assertSame("Check that User is added", cca1, adminList.get(0));
				
				//Add another item. test The size of the list is 2? -normal
				//The item just added is as same as the second item of the list
				C206_CaseStudy.addCCA(ccaList);
				assertEquals("Check that User arraylist size is 2", 2, ccaList.size());
				assertSame("Check that User is added", cca1, adminList.get(1));
	}
	
	@Test
	public void testDeleteCCA() {
		// Item list is not null, so that can add a new item - boundary
				assertNotNull("Check if there is valid User arraylist to add to", ccaList);
				//Given an empty list, after adding 1 item, the size of the list is 1 - normal
				//The item just added is as same as the first item of the list
				C206_CaseStudy.deleteCCA(ccaList);
				assertEquals("Check that User arraylist size is 1", 1, ccaList.size());
				assertSame("Check that CCA is deleted", cca1, studentsList.get(0));
				
				//Add another item. test The size of the list is 2? -normal
				//The item just added is as same as the second item of the list
				C206_CaseStudy.deleteCCA(ccaList);
				assertEquals("Check that Student arraylist size is 2", 2, ccaList.size());
				assertSame("Check that CCA is deleted", cca2, ccaList.get(1));
			}
	
	@Test
	public void testViewCCAs() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", ccaList);
		
		//test if the list of chromebook retrieved from the SourceCentre is empty
		String allCCAs= C206_CaseStudy.viewCCAs(ccaList);
		String testOutput = "";
		assertEquals("Check that viewCCAs", testOutput, allCCAs);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addCCA(ccaList);
		C206_CaseStudy.addCCA(ccaList);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, ccaList.size());
		
		//test if the expected output string same as the list of chromebook retrieved from the SourceCentre
		allCCAs= C206_CaseStudy.viewCCAs(ccaList);

		 testOutput = String.format("%-4s %-11s %-13s %-15s %-10s %-20s %-12s %-10s %-10s %-15s\n", 
				"ID", "Category", "Name", "Description","Vacancy", "Days", "Time Start", "Time End", "Venue", "Teacher-in-charge");		
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCCAs);	
		}

			
	@After
	public void tearDown() throws Exception {
		
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
