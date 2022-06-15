import java.io.*;
import java.util.*;

class SortedPath {
	int distance;
	int emptyPlace;
	
	SortedPath( int distance, int emptyPlace ) {
		this.distance = distance;
		this.emptyPlace = emptyPlace;
	}
}

class Main {    
	public static void main (String[] args) throws IOException {
		// Read line by line into bufferedReader
		ArrayList<SortedPath> spt = new ArrayList<>();
		int dist[];
		String[] splited, splitedEmpty;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String emptyPlaces = br.readLine();

		splited = line.split("\\s+");
		splitedEmpty = emptyPlaces.split("\\s+");
		
		// # of auditoriums
		int N = Integer.parseInt( splited[0] );
		// # of connections
		int M = Integer.parseInt( splited[1] );
		// inital distance
		int F = Integer.parseInt( splited[2] );
		
		// create new graph and initialize students size
		Graph graph = new Graph();
		graph.addAuditSize( N, F);
		
		// add connections to graph
		for ( int i = 0; i < M; i++ ) {
			line = br.readLine();
			splited = line.split("\\s+");
			graph.addConnection( Integer.parseInt( splited[0] ), Integer.parseInt( splited[1]), Integer.parseInt( splited[2] ));
		}
		
		// get dijkstra's distances
		dist = graph.dijkstra(0);
		line = br.readLine();
		int participants = Integer.parseInt(line);
		int count = 0;
		
		// create new arraylist with distances and emptyPlaces as SortedPath object
		for ( int k = 0; k < N; k++ ) {
			spt.add( new SortedPath( dist[k], Integer.parseInt(splitedEmpty[k]) ));
		}

		// sort merged spt arraylist
		spt.sort( Comparator.comparing(path -> path.distance));
		
		// print each participant by using sorted spt array
		while ( participants != 0 ) {
			if ( count < spt.size() && spt.get(count).emptyPlace > 0 ) {
				System.out.print( spt.get(count).distance + graph.initalDist);
				spt.get(count).emptyPlace--;
				
				if ( participants != 1 ) {
					System.out.print(" ");
				}
			}
			else if ( count >= spt.size() ) {
			    System.out.print( "-1");
			    
			    if ( participants != 1 ) {
					System.out.print(" ");
				}
			}
			else {
				count++;
				participants++;
			}
			
			participants--;
		}
	}

}