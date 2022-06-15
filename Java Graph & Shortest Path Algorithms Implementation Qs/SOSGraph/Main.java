import java.io.*; 
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
		// Read line by line into bufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] types;
		String line;
		
		// get rows and cols
		line = br.readLine();
		int rows = Integer.parseInt(line);
		line = br.readLine();
		int cols = Integer.parseInt(line);
				
		// create new matrix graph and initialize matrix size	
		Graph graph = new Graph();
		graph.addMatrixSize( rows, cols);      
		
		// add types to matrix graph
		for ( int j = 0; j < rows; j++ ) {
			// get types from line
			line = br.readLine();
			types = new char[line.length()];
			
			// Copy character by character into array
	        for (int i = 0; i < line.length(); i++) {
	        	types[i] = line.charAt(i);
	        }
	        
	        // add types to the graph
			for ( char type : types ) {
				if ( type != ' ') {
					graph.addType( j, type);
				}
			}
		}
		
		// convert SOS to SXS
		graph.convertOs();
		
		// new lines to distinguish input, output matrices
		System.out.println();
		System.out.println();
		
		// print the resultant matrix with desired format
		for ( int k = 0; k < rows; k++ ) {
			for ( int l = 0; l < cols; l++ ) {
				if ( l == cols - 1)
					System.out.print( graph.matrix.get(k).get(l).type);
				else
					System.out.print( graph.matrix.get(k).get(l).type + " " );
			}
			
			System.out.println();
		}
	}
  
}