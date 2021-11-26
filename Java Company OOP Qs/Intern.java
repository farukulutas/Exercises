
public class Intern extends Employee {
	// Variables
	int hours;
	String name;
	
	// Constructor
	public Intern( String name) {
		hours = 0;
		this.name = name;
	}
	
	// This method update the hours (set method)
	public void updateHours( int hours) {
		this.hours = hours;
	}
}
