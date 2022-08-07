import java.util.ArrayList;

public class RegistrationAccount {
	
	private int registrationId;
	private String studentId;
	
	private ArrayList<String> registeredCCAs;
	private ArrayList<String> status;

	public RegistrationAccount (int registrationId, String studentId) {
		
		
//	    Random random = new Random();
//	    int upperBound = 100;
//	    int randomId = random.nextInt(upperBound)+1;

		this.registrationId = registrationId;
		this.studentId = studentId;
		registeredCCAs = new ArrayList<String>();
		status = new ArrayList<String>();
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public String getStudentId() {
		return studentId;
	}

	
	public ArrayList<String> getRegisteredCCAs() {
		return registeredCCAs;
	}

	public void setRegisteredCCAs(ArrayList<String> registeredCCAs) {
		this.registeredCCAs = registeredCCAs;
	}

	public ArrayList<String> getStatus() {
		return status;
	}

	public void setStatus(ArrayList<String> status) {
		this.status = status;
	}
	
	public String viewRegisteredCCAsAndStatus() {
		String msg = "";

		for (int i = 0; i < registeredCCAs.size(); i++) {
			msg += registeredCCAs.get(i) + " [" + status.get(i) + "] \n";
		}
		return msg;
	}

	@Override
	public String toString() {
		return "" + registrationId;
	}

	
	
}
