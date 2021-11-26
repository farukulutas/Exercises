import java.util.*;

public class Question1Driver {
	

    public static void main(String[] args) {
	    Regular janeSmith = new Regular("Jane Smith");
	    Hourly tedMurphy = new Hourly("Ted Murphy");
	    Intern johnWhite = new Intern("John Allen White");
	
	    tedMurphy.updateHours(20);
	    johnWhite.updateHours(10);
	    Laboratory lab1 = new Laboratory ("Physics Lab");
	    Laboratory lab2 = new Laboratory ("Chemistry Lab");
	
	    lab1.AddPerson(janeSmith);
	    lab1.AddPerson(tedMurphy);
	    lab2.AddPerson(janeSmith);
	    johnWhite.AddAccess(lab2);

	    System.out.println( janeSmith.ReportAccess() );
	    System.out.println(lab1 + "has" + lab1.calculateHours() + "hours of workforce");
    }
}

