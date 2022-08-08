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
	ArrayList<CCA> ccaList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		
		ccaList = new ArrayList<>();
		
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
//		ccaList.add(new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
//		ccaList.add(new CCA("Sports", "Basketball", "Bounce ball", 10, 2, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
//		ccaList.add(new CCA("Sports", "Volleyball", "Smack ball", 10, 0, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
//		ccaList.add(new CCA("Culinary", "Baking", "Make cake", 20, 5, "Thursday", 15.00, 18.00, "Kitchen", "Mr Amran"));
//		ccaList.add(new CCA("Business", "Investment", "Buy Stocks", 20, 8, "Thursday, Friday", 15.00, 18.00, "W65D", "Mr Amran"));
		
		cca1 = new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Amran Mohamed");
		cca2 = new CCA("Sports", "Basketball", "Bounce ball", 10, 2, "Friday", 15.00, 18.00, "Court", "Amran Mohamed");
		cca3 = new CCA("Sports", "Volleyball", "", 10, 0, "Friday", 15.00, 18.00, "Court", "Mr Amran");
	}
	
	//#1
	@Test
	public void testAddCCA() {
		//List is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", ccaList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addCCA(ccaList, cca1);
		assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
		assertSame("Check that Football CCA is added", cca1, ccaList.get(0));
	
		//Add another item. test The size of the list is 2?
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Check that CCA arraylist size is 2", 2, ccaList.size());
		assertSame("Check that Basketball CCA is added", cca2, ccaList.get(1));
	}
	
	@Test
	public void testdoDeleteCCA() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid CCA arraylist to delete from", ccaList);
		ccaList.add(cca1);
		ccaList.add(cca2);
		System.out.println(ccaList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.doDeleteCCA(ccaList, 4);
		assertEquals("Check that User arraylist size is 1", 1, ccaList.size());
		assertNotSame("Check that Football CCA is deleted", cca1, ccaList.get(0));
		//Add another item. test The size of the list is 2?
		//The item just added is as same as the second item of the list
		C206_CaseStudy.doDeleteCCA(ccaList, 5);
		assertEquals("Check that Student arraylist size is 0", 0, ccaList.size());
//		assertNotSame("Check that Basketball CCA is deleted", cca2, ccaList.get(0));
	}
	
	@Test
	public void testUpdateCCADesc() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid CCA arraylist to update from", ccaList);
		ccaList.add(cca1);
		ccaList.add(cca3);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.doUpdateCCADesc(ccaList, 10, "test");
		assertSame("Check that Football CCA desc is changed to test", "test", ccaList.get(0).getDescription());
		//Add another item. test The size of the list is 2?
		//The item just added is as same as the second item of the list
		C206_CaseStudy.doUpdateCCADesc(ccaList, 12, "Smack Ball");
		assertSame("Check that Volleyball CCA desc is changed to Smack Ball", "Smack Ball", ccaList.get(1).getDescription());
	}
	
	@Test
	public void testGetCCAs() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Check if there is valid CCA arraylist", ccaList);
		
		//test if the list of CCA is empty
		String allCCAs= C206_CaseStudy.getCCAs(ccaList);
		String testOutput = "";
		assertEquals("Check that CCA list is empty", testOutput, allCCAs);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test if CCA list size is 2?", 2, ccaList.size());
		
		//test if expected output is the same
		allCCAs = C206_CaseStudy.getCCAs(ccaList);

		testOutput = String.format("%-4s %-11s %-13s %-15s %-10s %-20s %-12s %-10s %-10s %-15s\n", 1, "Sports", "Football", "Kick ball", 1+"/"+10, "Friday", 15.00, 18.00, "Field", "Amran Mohamed");
		testOutput += String.format("%-4s %-11s %-13s %-15s %-10s %-20s %-12s %-10s %-10s %-15s\n", 2, "Sports", "Basketball", "Bounce ball", 2 +"/"+ 10, "Friday", 15.00, 18.00, "Court", "Amran Mohamed");
		
		assertEquals("Check that expected output is the same as test output", testOutput, allCCAs);
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
