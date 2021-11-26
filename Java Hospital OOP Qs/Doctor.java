
import java.util.ArrayList;

public class Doctor {
	// Variables
	String name, department;
	int id;
	ArrayList<String> workdays;
	ArrayList<Appointment> appointmentList;
	
	// Constructor
	public Doctor( String name, int id, String department) {
		this.name = name;
		this.id = id;
		this.workdays = new ArrayList<String>();
		this.randomWorkGenerator();
		this.department = department;
		this.appointmentList = new ArrayList<Appointment>();
	}
	
	// This method create random work day schedule for doctor
	public void randomWorkGenerator() {
		int randomDay;
		
		randomDay = (int) (Math.random() * 5) + 1;
		
		if ( randomDay != 1 ) {
			workdays.add( "Monday");
		}
		
		if ( randomDay != 2 ) {
			workdays.add( "Tuesday");
		}
		
		if ( randomDay != 3 ) {
			workdays.add( "Wednesday");
		}
		
		if ( randomDay != 4 ) {
			workdays.add( "Thursday");
		}
		
		if ( randomDay != 5 ) {
			workdays.add( "Friday");
		}
	}
}
