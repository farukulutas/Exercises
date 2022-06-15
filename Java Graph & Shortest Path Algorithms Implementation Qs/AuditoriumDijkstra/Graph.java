//Graph class
class Graph {		
	// Initialize attributes
	int adjacencyMatrix[][];
	int auditSize;
	int initalDist;

	// Graph Constructor
	public Graph() {
	//--------------------------------------------------------
	// Summary: This is the default constructor.
	// Postcondition: adjacencyList, student size is initialized.
	//--------------------------------------------------------
		auditSize = 0;
		initalDist = 0;
	}
	
	public void addAuditSize( int rows, int initalDist) {
	//--------------------------------------------------------
	// Summary: Create adjacencyMatrix with given size.
	// Precondition: row is int
	// Postcondition: studentSize is updated, and adjacencyMatrix is created respect to size.
	//--------------------------------------------------------		
		this.auditSize = rows;
		this.initalDist = initalDist;
		this.adjacencyMatrix = new int[rows][rows];
		
		for ( int i = 0; i < rows; i++ ) {
			for ( int j = 0; j < rows; j++ ) {
				this.adjacencyMatrix[i][j] = 0;
			}
		}
	}
	
	public void addConnection( int audit1, int audit2, int distance) {
	//--------------------------------------------------------
	// Summary: Add student relation to specified place
	// Precondition: student1, student2, distance are int
	// Postcondition: Given students' relations is added to the adjacencyMatrix
	//--------------------------------------------------------		
		this.adjacencyMatrix[audit1 - 1][ audit2 - 1] = distance;
	}

	int minimumDistance(int dist[], Boolean shortestPath[]) {
 	//--------------------------------------------------------
 	// Summary: Minimum distance is calculated respect to shortest path set
 	// Precondition: dist (distances) is int array and shortestPath (path numbers) is boolean array
 	// Postcondition: Minimum distance is calculated, updated and its index is returned
 	//--------------------------------------------------------	
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < auditSize; i++) {
			if (shortestPath[i] == false && dist[i] <= min) {
				min = dist[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public int[] dijkstra( int src) {
 	//--------------------------------------------------------
 	// Summary: The minimum distance that can be traveled from the src to the dest is calculated and returned.
 	// Precondition: src and dest are int
 	// Postcondition: dist array is calculated and updated. Minimum dist src to dest is returned.
 	//--------------------------------------------------------	
 	// Initialize variables
		int dist[] = new int[auditSize];
		Boolean shortestPath[] = new Boolean[auditSize];
		int min;

		// Initialize array values
		for (int i = 0; i < auditSize; i++) {
			dist[i] = Integer.MAX_VALUE;
			shortestPath[i] = false;
		}
     
		// set distacne of src as 0
		dist[src] = 0;

		// find shortest path to all destinations from src
		for (int count = 0; count < auditSize - 1; count++) {
			min = minimumDistance(dist, shortestPath);
			shortestPath[min] = true;

			// update distance of selected dest
			for (int v = 0; v < auditSize; v++)
				if (!shortestPath[v] && this.adjacencyMatrix[min][v] != 0 && dist[min] != Integer.MAX_VALUE && dist[min] + this.adjacencyMatrix[min][v] < dist[v]) {
					dist[v] = dist[min] + this.adjacencyMatrix[min][v];
				}
		}	

		return dist;
	}

}