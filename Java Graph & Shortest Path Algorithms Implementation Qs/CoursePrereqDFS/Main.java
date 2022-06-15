import java.io.*; 
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
		// Read line by line into bufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line = line.replaceAll("\\s+","");
		int size = Integer.parseInt(line);
		
		// create new graph and initialize courses size		
		Graph graph = new Graph();
		graph.addCourseSize( size);
		
		// get courses from line convert to int array
		line = br.readLine();
		line = line.replaceAll("\\s+","");
		int[] numbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
		
		// add courses to graph
		for ( int course : numbers ) {
			graph.addCourse( course);
		}
		
		// get # of prerequisite information
		line = br.readLine();
		line = line.replaceAll("\\s+","");
		size = Integer.parseInt(line);
		
		// add prerequisites to adjacency course list
		for ( int i = 0; i < size; i++ ) {
			line = br.readLine();
			numbers = Arrays.stream(line.split("-")).mapToInt(Integer::parseInt).toArray();
			graph.addCoursePrereq( numbers[0], numbers[1]);
		}
		
		for ( int k = 0; k < graph.courseList.size(); k++ ) {
			for ( int l = 0; l < graph.courseList.get(k).size(); l++ ) {
				System.out.print( graph.courseList.get(k).get(l).course + " ");
			}
			
			System.out.println();
		}
		
		
		// get two courses to check and print prerequisite condition
		line = br.readLine();
		line = line.replaceAll("\\s+","");
		numbers = Arrays.stream(line.split("-")).mapToInt(Integer::parseInt).toArray();
		
		// print True if prereq condition is satisfied, else print False
		if ( graph.checkPrereq( numbers[0], numbers[1])) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
  
}