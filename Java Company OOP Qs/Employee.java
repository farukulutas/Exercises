import java.util.ArrayList;

public class Employee implements Laboratory {
	// Variables
	ArrayList<Laboratory> entranceList;
	String name;
	private int hours;
	
	// This method report accessors the lab
	public String ReportAccess() {
		String str = "";
		str = str + this.name + ":" + '\n' + "Total Working Hours: " + this.hours + '/n';
		
		// for loop to check acceses to the labs
		for ( int i < 0; i < entranceList.size(); i++ ) {
			if ( entranceList.get(i).name == this.name ) {
				str = str + "Access to " + entranceList.get(i);
			}
		}
		
		return str;
	}
	
	// This method add person access to the lab
	public void AddAccess( Laboratory lab) {
		// for loop to find matching lab
		for ( int j = 0; j < entranceList.size(); j++ ) {
			if ( entranceList.get( j) == lab ) {
				// if statements to find the class of the employee and add to the array list
				if ( this instanceof Hourly) {
					hourlies.add( this);
				}
				else if ( this instanceof Regular) {
					regulars.add( this);
				}
				else {
					interns.add( this);
				}
			}
		}
	}
	
	// This method get hours
	public int getHours() {
		return this.hours;
	}
}
