public class Schedule {
	// declare variables
	String task;
	int duration;
	int deadline;
	
	// deafult constructor
	Schedule() {
		task = "";
		duration = 0;
		deadline = 0;
	}
	
	// constructor which makes the initilizations
	Schedule (String task, int duration, int deadline ) {
		this.task = task;
		this.duration = duration;
		this.deadline = deadline;
	}
}
