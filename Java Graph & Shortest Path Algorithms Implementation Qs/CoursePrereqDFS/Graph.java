import java.io.*; 
import java.util.*;

//Graph class
class Graph {
	// node of adjacency list 
	static class Node {
		int course;
		Node(int course)  {
			this.course = course;
		}
	};
	
	// Initialize attributes
	List<List<Node>> courseList;
	int index;
  
	// Graph Constructor
	public Graph() {
	//--------------------------------------------------------
	// Summary: This is the default constructor.
	// Postcondition: courseList and index is initialized.
	//--------------------------------------------------------
		courseList = new ArrayList<>();
		index = 0;
	}
	
	// create size of adjacency list
	public void addCourseSize( int size) {
	//--------------------------------------------------------
	// Summary: Get size. Initialize course list respect to size.
	// Precondition: size is int courseList row size.
	// Postcondition: courseList rows are initialized.
	//--------------------------------------------------------
		for (int i = 0; i < size; i++)
			courseList.add(i, new ArrayList<>());
	}
	
	public void addCourse( int course) {
	//--------------------------------------------------------
	// Summary: Add first course which is prereq to first empty index
	// Precondition: course is int
	// Postcondition: prereq course is added to courseList
	//--------------------------------------------------------
		// if size is full
		if ( index == courseList.size() )
			return;
		
		// add prereq and increase index
		courseList.get(index).add( new Node( course));
		index++;
	}
	
	public void addCoursePrereq( int prereq, int course) {
	//--------------------------------------------------------
	// Summary: Add course to prereq by finding course
	// Precondition: prereq and course are int
	// Postcondition: Course is added as new node to prereq's next column
	//--------------------------------------------------------
		for ( int i = 0; i < courseList.size(); i++ ) {
			if ( courseList.get(i).get(0).course == prereq ) {
				courseList.get(i).add( new Node( course));
				break;
			}
		}
	}
	
	public boolean checkPrereq( int prereq, int course) {
	//--------------------------------------------------------
	// Summary: Recursively check prereq-course relation (DFS Approach)
	// Precondition: prereq and course are int
	// Postcondition: If there is relation return true else false
	//--------------------------------------------------------
		// iterate each prereq
		for ( int i = 0; i < courseList.size(); i++ ) {
			// if prereq found
			if ( courseList.get(i).get(0).course == prereq ) {
				// check if the course we're looking for is valid
				for ( int j = 1; j <= courseList.get(i).size() - 1; j++ ) {
					if ( courseList.get(i).get(j).course == course) {
						return true;
					}
				}
				
				// check each course's prereq list, recursively
				for ( int k = 1; k <= courseList.get(i).size() - 1; k++ ) {
					if ( checkPrereq( courseList.get(i).get(k).course, course) ) {
						return true;
					}
				}
				
				break;
			}
		}
		
		return false;
	}

}