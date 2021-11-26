

import java.util.ArrayList;

public class Patient {
	// Variables
	String name;
	ArrayList<Appointment> appointmentList;
	
	// Constructor
	public Patient( String name) {
		this.name = name;
		this.appointmentList = new ArrayList<Appointment>();
	}
}
