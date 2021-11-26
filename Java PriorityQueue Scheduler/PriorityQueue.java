// imports for getting input from text file
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PriorityQueue {
	// declare the variables
	Schedule[] array;
	int size;
	int limit;

	// default constructor
	PriorityQueue() {
		limit = 5;
		array = new Schedule[limit];
		size = -1;
	}
	
	// Checks, the priorityQueue is empty or not; return boolean result
	public boolean isEmpty() {
		return size == -1;
	}

	// This function returns parent schedule of a given index, if index is invalid it returns null
	public Schedule parent(int i) {
		if ( (i - 1) / 2 < 0 ) {
			return null;
		}
		
		return array[(i - 1) / 2];
	}
	 
	// This function returns left child schedule of a given index, if index is invalid it returns null
	public Schedule leftChild(int i) {
		if ( (2 * i) + 1 > limit - 1 ) {
			return null;
		}
		
		return array[(2 * i) + 1];
	}
	 
	// This function returns right child schedule of a given index, if index is invalid it returns null
	public Schedule rightChild(int i) {
		if ( (2 * i) + 2 > limit - 1 ) {
			return null;
		}
		
		return array[(2 * i) + 2];
	}
	 
	// To keep the heap priority feature, it shifts up until it finds the right location
	public void shiftUp( int i) {
	  while (i > 0 && parent(i).deadline > array[i].deadline ) {
	    // Swap parent and current one
	    swap(parent(i), array[i]);
	 
	    // Update index with the parent one
	    i = (i - 1) / 2;
	  }
	}
	 
	// To keep the heap priority feature, it shifts down until it finds the right location
	public void shiftDown(int i) {
	  int maxIndex = i;
	 
	  // check left Child
	  Schedule l = leftChild(i);
	 
	  if (((2 * i) + 1) <= size && l.deadline < array[maxIndex].deadline ) {
		  maxIndex = (2 * i) + 1;
	  }
	 
	  // check right Child
	  Schedule r = rightChild(i);
	  
	  if (((2 * i) + 2) <= size && r.deadline < array[maxIndex].deadline ) {
		  maxIndex = (2 * i) + 2;
	  }
	 
	  // If i not same as maxIndex, check maxIndex
	  if (i != maxIndex) {
		  swap(array[i], array[maxIndex]);
		  shiftDown(maxIndex);
	  }
	}
	 
	// If there is enough space make insertion and find correct place
	// if not, first extend it then make insertion and find correct place
	public void insert(Schedule s) {
		if ( size + 2 > limit ) {
			extension();
		}
		
		size++;
		array[size] = s;
  
		// shift up for heap priority
		shiftUp(size);
	}
	
	// extend the priority array by creating new doubled one and copying the values
	public void extension() {
		Schedule[] newArray = new Schedule[size * 2 + 2];
		
		for ( int i = 0; i < size + 1; i++ ) {
			newArray[i] = array[i];
		}
		
		array = newArray;
	}
	
	// return and delete the max value from the array
	public Schedule extractMax() {
		Schedule result = array[0];
	 
		// Replace the value at the root with the last leaf
		array[0] = array[size];
		size = size - 1;
	 
		// Shift down the replaced element to maintain the heap property
		shiftDown(0);
		return result;
	}
	 
	// get the top max value in the array
	public Schedule getMax() {
		return array[0];
	}
	 
	// remove the element in the given index
	public void remove(int i) {
		array[i].deadline = getMax().deadline + 1;
	 
		// shift up and make it top one
		shiftUp(i);
		 
		// delete top
		extractMax();
	}
	
	// swap the parent and child element given in the parameter
	public void swap(Schedule parent, Schedule child) {
		Schedule temp = new Schedule();
	  
		temp.deadline = parent.deadline;
		temp.duration = parent.duration;
		temp.task = parent.task;
		  
		parent.deadline = child.deadline;
		parent.duration = child.duration;
	  	parent.task = child.task;
		  
	  	child.deadline = temp.deadline;
	  	child.duration = temp.duration;
	  	child.task = temp.task;
	}
    
	// main class
    public static void main(String[] args) throws FileNotFoundException {
    	// declare and initilaze the variables
        PriorityQueue deadlines = new PriorityQueue();
        String print = "";
    	String next = "";
        int time = 0;
    	int nextInt = 0;
    	int credit = 0;
        
    	// In sampleinput1, it schedules and run the elements, 
    	// ( the total work and run time is equal case)
        Scanner reader = new Scanner(new FileInputStream("sampleinput1.txt"));
        
        // In sampleinput2, it schedules and run the elements, and run the elements 
        // without scheduling again ( the total work less than run time case)
        //Scanner reader = new Scanner(new FileInputStream("sampleinput2.txt"));
        
        // In sampleinput3, it schedules, runs (case1); schedules runs (case2)
        // continue to schedule and run run this time. It excess the array size
        // and enforce the extension ( previous both cases plus array extension case)
        //Scanner reader = new Scanner(new FileInputStream("sampleinput3.txt"));
        
        while (reader.hasNextLine()) {      // while there is next line
            Scanner line = new Scanner( reader.nextLine());   // gets the next line
            
            while (line.hasNext()) { // while there is words in the line
                String cmd = line.next(); // gets the word
                
                if ( cmd.equals("schedule")) { // schedule command
                	print = time + ": adding ";
                	Schedule s = new Schedule();	
                	
                	next = line.next();
                	s.task = next;
                	print += next + " with deadline "; 
                	
                	nextInt = line.nextInt();
                	s.deadline = nextInt;
                	print += nextInt + " and duration ";
                	
                	nextInt = line.nextInt();
                	s.duration = nextInt;
                	print += nextInt;
                	
                	deadlines.insert( s); // insert the new Schedule
                	System.out.println( print); // print the schedule process
                }
                else if ( cmd.equals( "run")) { // run command
                	credit += line.nextInt(); // update the run time as credit
                	
                	while ( !deadlines.isEmpty() && credit > 0 ) { // while priorityQueue is not empty and credit is higher than zero
                		if ( credit - deadlines.getMax().duration >= 0 ) { // if you have credit to complete assignment, make processes, delete top
                			System.out.println( time + ": busy with " + deadlines.getMax().task + " with deadline " + deadlines.getMax().deadline + " and duration " + deadlines.getMax().duration);
                			time = time + deadlines.getMax().duration;
                			System.out.println( time + ": done with " + deadlines.getMax().task );
                			credit = credit - deadlines.getMax().duration;
                			deadlines.extractMax(); // delete top
                		}
                		else { // else not enough credit, use credits, update the assignments
                			System.out.println( time + ": busy with " + deadlines.getMax().task + " with deadline " + deadlines.getMax().deadline + " and duration " + deadlines.getMax().duration);
                			time = time + credit;
                			System.out.println( time + ": adding " + deadlines.getMax().task + " with deadline " + deadlines.getMax().deadline + " and duration " + (deadlines.getMax().duration - credit));
                			deadlines.getMax().duration = deadlines.getMax().duration - credit;
                			credit = 0;
                		}
                	}
                }   
            }
        }
    }
    
} // end of PriorityQueue Class