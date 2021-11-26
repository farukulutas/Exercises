public class MovieDatabase {
	BinaryTree movies;
	
	// default constructor
	MovieDatabase() {
		movies = new BinaryTree();
	}
	
	// this method first checks this movie added before, if yes, then overwrite it, else it adds the new movie
	void addMovie( String movieTitle, String directorFirstName, String directorLastName, int releaseDay, int releaseMonth, int releaseYear ) {
		if ( movies.lookup(releaseYear, movieTitle) ) {
			System.out.println( "INFO: Movie " + movieTitle + " overwritten");
		}
		else {
			movies.insert(releaseDay, releaseMonth, releaseYear, movieTitle, directorFirstName, directorLastName);
			System.out.println( "INFO: Movie " + movieTitle + " has been added");
		}
	}
	
	// this method gives error if movie not exist, else delete movie
	void removeMovie( String movieTitle ) {
		movies.lookupNode(movies.getRoot(), movieTitle);
		if ( movies.getResultNode() == null ) {
			System.out.println("The movie specified with this name could not be found, it cannot be deleted!\n");
		}
		else {
			int year = movies.getYear( movies.getResultNode());
			movies.delete(year, movieTitle);
			System.out.println("INFO: Movie " + movieTitle + " has been removed\n");
		}
	}
	
	// this method checks the movie, if exist; then check the actor if exist overwrite it, if not inserts
	// new actor to the cast
	void addActor( String movieTitle, String actorFirstName, String actorLastName, String actorRole ) {
		if ( movies.lookupNode( movieTitle) == null) {
			System.out.println("INFO: " + movieTitle + " does not exist");
		}
		else {
			if ( movies.findMovieCast( movieTitle) != null ) {
				movies.delete(movieTitle, actorFirstName, actorLastName);
			}
				
			movies.insert(movieTitle, actorFirstName, actorLastName, actorRole);
			System.out.println("INFO: " + actorFirstName + " " + actorLastName + " has been added to the movie " + movieTitle);
		}
	}
	
	// this method checks movie and actor if exist both remove the actor, if not gives warning
	void removeActor( String movieTitle, String actorFirstName, String actorLastName ) {
		if ( movies.lookupNode( movieTitle) == null) {
			System.out.println("INFO: " + actorFirstName + " " + actorLastName + " has been removed from the movie " + movieTitle + "\n");
		}
		else {
			if ( movies.findMovieCast( movieTitle) != null ) {
				movies.delete(movieTitle, actorFirstName, actorLastName);
				System.out.println("INFO: " + actorFirstName + " " + actorLastName + " has been removed from the movie " + movieTitle + "\n");
			}
			else {
				System.out.println("The actor specified with this name could not be found, it cannot be removed!\n");
			}
		}
	}
	
	// this method traverse tree inorder and print the movies, if tree empty print ---none---
	void showAllMovies() {
		if ( movies.countNodes() == 0 ) {
			System.out.println( "---none---\n");
		}
		else {
			movies.printInorderAscending( movies.getRoot());
			System.out.println();
		}
	}
	
	// this method show detailed information about a specified movie
	void showMovie( String movieTitle ) {
		movies.showMovieInfo( movieTitle);
		System.out.println();
	}
	
	// if actor played in a movie print info about movie descending order if not print none
	void showActorRoles( String actorFirstName, String actorLastName ) {
		if ( !movies.checkRole( movies.getRoot(), actorFirstName, actorLastName) ) {
			System.out.println("---none---");
		}
		else {
			System.out.println( actorFirstName + " " + actorLastName);
			movies.printInorderRole(movies.getRoot(), actorFirstName, actorLastName );
			System.out.println();
		}
	}
	
	// print movies descending for the director
	void showDirectorMovies( String directorFirstName, String directorLastName ) {
		System.out.println( directorFirstName + " " + directorLastName);
		movies.printInorderDirector(movies.getRoot(), directorFirstName, directorLastName, false);
		System.out.println();
	}
	
	// this method check the movies released in releaseYear if exist, then print their info
	void showMovies( int releaseYear ) {
		if ( !movies.checkYear( movies.getRoot(), releaseYear)) {
			System.out.println("---none---");
		}
		else {
			System.out.println(releaseYear);
			movies.printInorderYear(movies.getRoot(), releaseYear);
			System.out.println();
		}
	}
	
	// show movie info's between startYear-endYear, if there is no movie btw these years print none
	void showMovies( int startYear, int endYear ) {
		if ( !movies.checkBetweenYear( movies.getRoot(), startYear, endYear)) {
			System.out.println("---none---");
		}
		else {
			System.out.println(startYear + " - " + endYear);
			movies.printInorderBetweenYear(movies.getRoot(), startYear, endYear);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// create movie database
		MovieDatabase md = new MovieDatabase();
		
		// show all movies which is none
		md.showAllMovies();
		
		// add some movies which print the info what we add
		md.addMovie("Eyes Wide Shut", "Stanley", "Kubrick", 22, 10, 1999);
		md.addMovie("Family Plot", "Alfred", "Hitchock", 9, 4, 1972);
		md.addMovie("Psycho", "Alfred", "Hitchock", 20, 5, 1960);
		md.addMovie("Sweet and Lowdown", "Woody", "Allen", 26, 1, 1999);
		md.addMovie("Midnight in Paris", "Woody", "Allen", 30, 9, 2011);
		md.addMovie("Barton Fink", "Coen", "Brothers", 21, 8, 1991);
		md.addMovie("The Interpreter", "Sydney", "Pollack", 22, 4, 2005);
		md.addMovie("Psycho", "Alfred", "Hitchock", 20, 5, 1960);
		System.out.println();
		
		// show all movies to see added movies
		md.showAllMovies();
		
		// remove a movie
		md.removeMovie("Midnight in Paris");
		
		// show all movies to not see removed movie
		md.showAllMovies();
		
		// show movie to see detailed info about movie
		md.showMovie("Eyes Wide Shut");
		
		// add actors and see their info if movie exist
		md.addActor("Barton Fink", "John", "Turturro", "Barton Fink");
		md.addActor("Barton Fink", "John", "Goodman", "Charlie Meadows");
		md.addActor("Barton Fink", "Judy", "Davis", "Audrey Taylor");
		md.addActor("Barton Fink", "Michael", "Lerner", "Jack Lipnick");
		md.addActor("Eyes Wide Shut", "Tom", "Cruise", " Bill Harford");
		md.addActor("Eyes Wide Shut", "Nicole", "Kidman", "Alice Harford");
		md.addActor("Eyes Wide Shut", "Madison", "Eginton", "Helena Harford");
		md.addActor("Eyes Wide Shut", "Jackie", "Sawaris", "Roz");
		md.addActor("Eyes Wide Shut", "Sydney", "Pollack", "Victor Ziegler");
		md.addActor("Midnight in Paris", "Woody", "Allen", "Woody Allen");
		md.addActor("The Interpreter", "Nicole", "Kidman", "Silvia Broom");
		md.addActor("The Interpreter", "Sean", "Penn", "Tobin Keller");
		md.addActor("The Interpreter", "Earl", "Cameron", "Zuwanie");
		
		// show movies detailed info
		md.showMovie("Barton Fink");
		md.showMovie("Eyes Wide Shut");
		
		// remove actor
		md.removeActor("Eyes Wide Shut", "Jackie", "Sawaris");
		
		// show movies detailed info to check actor is removed
		md.showMovie("Eyes Wide Shut");
		
		// check actor roles
		md.showActorRoles("Nicole", "Kidman");
		md.showActorRoles("Judy", "Davis");
		
		// check director movies
		md.showDirectorMovies("Alfred", "Hitchock");
		md.showDirectorMovies("Stanley", "Kubrick");
		
		// check movies released at 1999
		md.showMovies(1999);
		
		// check movies btw two year
		md.showMovies(1972, 2005);
	}

}