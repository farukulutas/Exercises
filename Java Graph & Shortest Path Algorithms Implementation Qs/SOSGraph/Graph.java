import java.io.*; 
import java.util.*;

// Graph class
class Graph {
	// node of adjacency list 
	static class Node {
		char type;
		Node(char type)  {
			this.type = type;
		}
	};
	
	// Initialize attributes
	List<List<Node>> matrix;
	int rows, cols;
  
	// Graph Constructor
	public Graph() {
	//--------------------------------------------------------
	// Summary: This is the default constructor.
	// Postcondition: matrix, rows and cols are initialized.
	//--------------------------------------------------------
		matrix = new ArrayList<>();
		rows = 0;
		cols = 0;
	}
	
	public void addMatrixSize( int rows, int cols) {
	//--------------------------------------------------------
	// Summary: Create matrix with given size.
	// Precondition: row and cols are int
	// Postcondition: matrix is created respect to size.
	//--------------------------------------------------------
		for (int i = 0; i < rows; i++)
			matrix.add(i, new ArrayList<>());
		
		this.rows = rows;
		this.cols = cols;
	}
	
	public void addType( int index, char type) {
	//--------------------------------------------------------
	// Summary: Add type to specified place
	// Precondition: type is char, index is int
	// Postcondition: Given type is added to the matrix
	//--------------------------------------------------------		
		matrix.get(index).add( new Node( type));
	}
	
	public void convertOs() {
	//--------------------------------------------------------
	// Summary: Convert all "O" chars to X surrounded by "S".
	// Postcondition: All "O" chars to X surrounded by "S" are converted.
	//--------------------------------------------------------
		// Initialize the surrounded chars
		char prev, next, up, down;
		
		// The for loops do not check for edges because surrounded cannot be provided here.
		for ( int i = 1; i < rows-1; i++ ) {
			for ( int j = 1; j < cols-1; j++ ) {
				// declare unrelated chars each iteration
				prev = 'A';
				next = 'A';
				up = 'A';
				down = 'A';
				
				// update up
				if ( i - 1 >= 0 ) {
					up = matrix.get(i-1).get(j).type;
				}
				
				// update down
				if ( i + 1 < rows ) {
					down = matrix.get(i+1).get(j).type;
				}
				
				// update prev
				if ( j - 1 >= 0 ) {
					prev = matrix.get(i).get(j-1).type;
				}
				
				// update next
				if ( j + 1 < cols ) {
					next = matrix.get(i).get(j+1).type;
				}
				
				// check if current is surrounded by S
				if ( (prev == 'S' & next == 'S' & matrix.get(i).get(j).type == 'O') || (up == 'S' & down == 'S' & matrix.get(i).get(j).type == 'O') ) {
					// update current as 'O'
					matrix.get(i).get(j).type = 'X';
				}
			}
		}
		
	}

}