public class CCA {
	private int id;
	private String title;
	private String description;
	private int classSize;
	private String dayOfWeek;
	private Double timeStart;
	private Double timeEnd;
	private String venue; 
	private String instructor;
	
	public CCA(int id,String title, String description, int classSize, String dayOfWeek, double timeStart, double timeEnd, String venue, String instructor) {
		this.id=id;
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
}