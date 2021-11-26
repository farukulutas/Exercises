import java.util.ArrayList;

public class Laboratory {
	// Variables
	ArrayList<Regular> regulars;
	ArrayList<Hourly> hourlies;
	ArrayList<Intern> interns;
	String labName;
	
	// Constructor
	public Laboratory( String labName) {
		this.labName = labName;
		regulars = new ArrayList<Regular>();
		hourlies = new ArrayList<Hourly>();
		interns = new ArrayList<Intern>();
	}
	
	// This method calculate total work hours in a lab.
	public int calculateHours() {
		int totalWork = 0;
		
		// for loops to check each employees and add their work hours to total work.
		for ( int i = 0; i < regulars.size(); i++ ) {
			totalWork = totalWork + this.regulars.get(i).getHours();
		}
		
		for ( int i = 0; i < hourlies.size(); i++ ) {
			totalWork = totalWork + this.hourlies.get(i).getHours();
		}
		
		for ( int i = 0; i < interns.size(); i++ ) {
			totalWork = totalWork + this.interns.get(i).getHours();
		}
		
		return totalWork;
	}
	
	// This method add a regular to array list
	public void AddRegular( Regular regular) {
		regulars.add( regular);
	}
	
	// This method add a intern to array list
	public void AddIntern( Intern intern) {
		interns.add( intern);
	}

	// This method add a hourly to array list
	public void AddHourly( Hourly hourly) {
		hourlies.add( hourly);
	}
	
}
