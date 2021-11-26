
import java.util.Scanner;
import java.util.ArrayList;

public class Question2Driver {

	public static void main(String [] args) {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		ArrayList<Patient> patientList = new ArrayList<Patient>();
 		
		
		System.out.print("Enter a command: ");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.next();
		
		String[] command = input.split(" ");

		while (!command[0].equalsIgnoreCase("Q")) {

			switch (command[0]) {

			case "CreateDoctor":
                // TODO: CreateDoctor <DoctorName><DoctorID> <Department> : Creates a doctor object
				String name = command[1];
				int id = command[2];
				String department = command[3];
				Doctor d = new Doctor( name, id, department);
				doctorList.add( d);
				break;

			case "CreatePatient":
				// TODO: CreatePatient <PatientName> : Creates a patient object
				String pName = command[1];
				Patient p = new Patient( pName);
				patientList.add( p);
				break;

			case "GetAppointment":
                // TODO: GetAppointment <PatientName><Department><DayOfAppointment> Patient Gets an appointment, find a doctor and get the appointment
				
				break;

			case "PrintPatientAppointments":
                // TODO: PrintPatientAppointments <PatientName>
				for ( int i = 0; i < patientList.size(); i++) {
					if ( patientList(i).name == command[1]) {
						System.out.println( patientList(i).name);
					}
				}
				break;

			case "PrintDoctorAppointments":
				// TODO: PrintDoctorAppointments <DoctorNAme>
				for ( int j = 0; j < doctorList.size(); j++) {
					if ( doctorList(j).name == command[1]) {
						System.out.println( doctorList(j).name);
					}
				}
				break;
			}
			
			System.out.print("Enter a command: ");
			input = keyboard.next();
			command = input.split(" ");
		}

		//System.out.print(ANSI_RESET2);
	}
}
