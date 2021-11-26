
public class Hourly extends Employee {
	// Variables
	int hours;
	String name;
	
	// Constructor
	public Hourly( String name) {
		hours = 0;
		this.name = name;
	}
	
	// This method update the given hours (set method)
	public void updateHours( int hours) {
		this.hours = hours;
	}
}
