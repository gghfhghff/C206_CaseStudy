import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<Students> studentList = new ArrayList<Students>();
		
		studentList.add(new Students("testuser", "test", "boy", "test", 1, 2, "test", "test"));
		studentList.add(new Students("testuser", "test", "boy", "test", 1, 2, "test", "test"));

		System.out.println(studentList);
		
	}
}

/*
static ArrayList<Category> categoryList = new ArrayList<Category>();

String a = viewCategories(categoryList);
System.out.println(a);


int id = categoryList.size() + 1;
String name = Helper.readString("Enter Category name: ");
String details = Helper.readString("Enter Category details: ");

Category category = new Category(id, name, details, cca);
addCategories(categoryList, category);


int id = Helper.readInt("Enter ID: ");
deleteCategories(categoryList, id);



public static String viewCategories(ArrayList<Category> categoryList) {
	String output = String.format("%-5s %-20s %-20s\n", "ID", "NAME", "DETAILS");

	for (int i = 0; i < categoryList.size(); i++) {
		if (!categoryList.get(i).getName().isEmpty()) {
			output += String.format("%-5d %-20s %-20s\n", categoryList.get(i).getId(),
					categoryList.get(i).getName(), categoryList.get(i).getDetails());
		}
	}
	return output;

}



public static void addCategories(ArrayList<Category> categoryList, Category category) {
	if (category.getName().isEmpty() || category.getDetails().isEmpty()) {
		System.out.println("Please enter a valid input!");
	} else {
		categoryList.add(category);
		System.out.println("Successfully added category!");
	}
}



public static void deleteCategories(ArrayList<Category> categoryList, int id) {
	boolean valid = false;
	for (int i = 0; i < categoryList.size(); i++) {
		if (categoryList.get(i).getId() == id) {
			categoryList.remove((i));
			valid = true;
			System.out.println("Successfully deleted category!");
			break;
		}
	}
	
	if (valid == false) {
		System.out.println("Invalid ID!");
	}
}
*/
