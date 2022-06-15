import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
		// Read line by line into bufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] dijkstraArr;
		String[] lines;
		
		// # of students as S
		int S = Integer.parseInt( line.substring(0, 1));
		// # of connections as C
		int C = Integer.parseInt( line.substring(2, 3));
		// # of queries as M
		int M = Integer.parseInt( line.substring(4, 5));
		
		// create new graph and initialize students size		
		Graph graph = new Graph();
		graph.addStudentSize( S);
		dijkstraArr = new int[S];
		lines = new String[M];
		
		// add relations to graph
		for ( int i = 0; i < C; i++ ) {
			line = br.readLine();
			String[] splited = line.split("\\s+");
			graph.addCable( Integer.parseInt( splited[0] ), Integer.parseInt( splited[1]), Integer.parseInt( splited[2] ));
		}
		
		
		// find and log minimum distances btw relations by using dijkstra
		for ( int j = 0; j < M; j++ ) {
			line = br.readLine();
			lines[j] = line;
			dijkstraArr[j] = graph.dijkstra( Integer.parseInt( line.substring(0, 1)) - 1, Integer.parseInt(line.substring(2, 3)) - 1);
		}
		
		graph.createMST();
		
		// print minimum distances btw relations by using MST
		for ( int j = 0; j < M; j++ ) {
			line = lines[j];
			
			if ( graph.dijkstra( Integer.parseInt( line.substring(0, 1)) - 1, Integer.parseInt(line.substring(2, 3)) - 1) != Integer.MAX_VALUE ) {
				System.out.println( graph.dijkstra( Integer.parseInt( line.substring(0, 1)) - 1, Integer.parseInt(line.substring(2, 3)) - 1) );
			}
			else {
				System.out.println( dijkstraArr[j] );
			}
			
		}
	}

}