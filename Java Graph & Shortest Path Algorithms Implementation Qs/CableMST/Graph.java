// Graph class
class Graph {		
	// Initialize attributes
	int adjacencyMatrix[][];
	int studentSize;
  
	// Graph Constructor
	public Graph() {
	//--------------------------------------------------------
	// Summary: This is the default constructor.
	// Postcondition: adjacencyList, student size is initialized.
	//--------------------------------------------------------
		studentSize = 0;
	}
	
	public void addStudentSize( int rows) {
	//--------------------------------------------------------
	// Summary: Create adjacencyMatrix with given size.
	// Precondition: row is int
	// Postcondition: studentSize is updated, and adjacencyMatrix is created respect to size.
	//--------------------------------------------------------		
		this.studentSize = rows;
		this.adjacencyMatrix = new int[rows][rows];
		
		for ( int i = 0; i < rows; i++ ) {
			for ( int j = 0; j < rows; j++ ) {
				this.adjacencyMatrix[i][j] = 0;
			}
		}
	}
	
	public void addCable( int student1, int student2, int distance) {
	//--------------------------------------------------------
	// Summary: Add student relation to specified place
	// Precondition: student1, student2, distance are int
	// Postcondition: Given students' relations is added to the adjacencyMatrix
	//--------------------------------------------------------		
		this.adjacencyMatrix[student1 - 1][ student2 - 1] = distance;
		this.adjacencyMatrix[student2 - 1][ student1 - 1] = distance;
	}
	
	public int getIndexOfLowest( int[] array ) {
	    //--------------------------------------------------------
	    // Summary: Find index of lowest element from given array
	    // Precondition: array is integer array
	    // Postcondition: return lowestIndex as lowest element's index
	    //--------------------------------------------------------	
		int lowestIndex = 0;
	  
		for ( int j = 0; j < array.length; j++ ) {
			if ( array[j] != 0 ) {
				lowestIndex = j;
				break;
			}
		}
		
		for ( int i = 1; i < array.length; i++ ) {
			if ( array[i] < array[lowestIndex] && array[i] != 0 ) {
				lowestIndex = i;
			}
		}
	  
		return lowestIndex;
	}
	
	public void createMST() {
	    //--------------------------------------------------------
	    // Summary: Update the matrix so that the minimum distances 
		// 	to the source remain and create the minimum spanning tree.
	    // Precondition: -
	    // Postcondition: adjacency matrix is converted to MST
	    //--------------------------------------------------------	
		int minIndex = 0;
		
		// Create directed MST
		for ( int[] i : this.adjacencyMatrix ) {
			minIndex = getIndexOfLowest(i);
			
			for ( int k = 0; k < i.length; k++ ) {
				if ( k != minIndex ) {
					i[k] = 0;
				}
			}
		}
		
		// Convert directed graph to undirected graph
		for ( int l = 0; l < this.studentSize; l++ ) {
			for ( int m = 0; m < this.studentSize; m++ ) {
				if ( this.adjacencyMatrix[l][m] != 0 ) {
					this.adjacencyMatrix[m][l] = this.adjacencyMatrix[l][m];
				}
			}
		}
	}

	int minimumDistance(int dist[], Boolean shortestPath[]) {
    //--------------------------------------------------------
    // Summary: Minimum distance is calculated respect to shortest path set
    // Precondition: dist (distances) is int array and shortestPath (path numbers) is boolean array
    // Postcondition: Minimum distance is calculated, updated and its index is returned
    //--------------------------------------------------------	
       	int min = Integer.MAX_VALUE;
       	int minIndex = -1;
       	for (int i = 0; i < studentSize; i++) {
       		if (shortestPath[i] == false && dist[i] <= min) {
              	min = dist[i];
                minIndex = i;
            }
       	}
 
        return minIndex;
    }

    public int dijkstra( int src, int dest) {
   	//--------------------------------------------------------
   	// Summary: The minimum distance that can be traveled from the src to the dest is calculated and returned.
   	// Precondition: src and dest are int
   	// Postcondition: dist array is calculated and updated. Minimum dist src to dest is returned.
    //--------------------------------------------------------	
   	// Initialize variables
       	int dist[] = new int[studentSize];
       	Boolean shortestPath[] = new Boolean[studentSize];
     	int min;
 
        // Initialize array values
       	for (int i = 0; i < studentSize; i++) {
          	dist[i] = Integer.MAX_VALUE;
           	shortestPath[i] = false;
        }
        
        // set distacne of src as 0
        dist[src] = 0;

        // find shortest path to all destinations from src
        for (int count = 0; count < studentSize - 1; count++) {
            min = minimumDistance(dist, shortestPath);
            shortestPath[min] = true;

            // update distance of selected dest
            for (int v = 0; v < studentSize; v++)
                if (!shortestPath[v] && this.adjacencyMatrix[min][v] != 0 && dist[min] != Integer.MAX_VALUE && dist[min] + this.adjacencyMatrix[min][v] < dist[v]) {
                    dist[v] = dist[min] + this.adjacencyMatrix[min][v];
                }
        }
        
        return dist[dest];
    }

}