public class CCA {
	//The system shall allow school CCA coordinators or various CCA instructors in-charge to upload CCAs before the 
	//registration open such as little league soccer, LEGO expert, dig the ground, bakery, jewellery making etc.
	//Different CCA may belong to different categories.  

	//Each CCA shall capture information such as title, description, class size (ie. 20), 
	//which day of the week (i.e., either Tuesday or Wednesday) time (i.e. 3:00PM- 4:00PM), venue, and 
	//name of the instructor in-charge etc.  
	
	
	private int id;
	public static int nextId = 1;
	
	private String category;
	private String title;
	private String description;
	private int classSize;
	private String dayOfWeek;
	private Double timeStart;
	private Double timeEnd;
	private String venue; 
	private String instructor;
	
	public CCA(String category, String title, String description, int classSize, String dayOfWeek, double timeStart, double timeEnd, String venue, String instructor) {
		id = nextId;
		nextId++;
		
		this.category = category;
		this.title = title;
		this.description = description;
		this.classSize = classSize;
		this.dayOfWeek = dayOfWeek;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.venue = venue;
		this.instructor = instructor;
	}
	
	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String newDescription) {
		description = newDescription;
	}
	
	public int getClassSize() {
		return classSize;
	}
	
	public void setClassSize(int newClassSize) {
		classSize = newClassSize;
	}
	
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	
	public void setDayOfWeek(String newDayOfWeek) {
		dayOfWeek = newDayOfWeek;
	}
	
	public double getTimeStart() {
		return timeStart;
	}
	
	public void setTimeStart(double newTimeStart) {
		timeStart = newTimeStart;
	}
	
	public double getTimeEnd() {
		return timeEnd;
	}
	
	public void setEndTime(double newTimeEnd) {
		timeEnd = newTimeEnd;
	}
	
	public String getVenue() {
		return venue;
	}
	
	public void setVenue(String newVenue) {
		venue = newVenue;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	public void setInstructorName(String newInstructor) {
		instructor = newInstructor;
	}

	@Override
	public String toString() {
		return "CCA [title=" + title + "]";
	}
	
}