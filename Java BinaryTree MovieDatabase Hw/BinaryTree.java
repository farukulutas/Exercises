// BinaryTree.java
public class BinaryTree {
	// Root node pointer. Will be null for an empty tree
	private Node root;
	private Node result;
	private castNode castResult;
	
	/*
	 --Node--   
	 The binary tree is built using this nested node class.
	 Each node stores informations about movie, and has left and right
	 sub-tree pointer which may be null.
     */
	private static class Node {    
		Node left, right;
		castNode castRoot;
		int day, month, year;
		String movieTitle, firstName, lastName;
		
		Node(int day, int month, int year, String movieTitle, String firstName, String lastName) {      
			left = null;      
			right = null;      
			this.day = day;   
			this.month = month; 
			this.year = year; 
			this.movieTitle = movieTitle; 
			this.firstName = firstName;
			this.lastName = lastName;
			castRoot = null;
		}
	}
	
	/*
	 --castNode--   
	 The binary tree is built using this nested node class.
	 Each node stores informations about cast, and has left and right
	 sub-tree pointer which may be null.
    */
	private static class castNode {    
		castNode castLeft, castRight;
		String actorMovieTitle, actorFirstName, actorLastName, actorRole;
		
		castNode( String actorMovieTitle, String actorFirstName, String actorLastName, String actorRole ) {
			castLeft = null;
			castRight = null;
			this.actorMovieTitle = actorMovieTitle;
			this.actorFirstName = actorFirstName;
			this.actorLastName = actorLastName;
			this.actorRole = actorRole;
		}
	}
	
	/**   
	 * Creates an empty binary tree -- a null root pointer.  
	 * */  
	public BinaryTree() {    
		root = null;  
	}
	
	/* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }
	
    /* Function to check if cast's tree is empty */
    public boolean isCastEmpty() {
        return root.castRoot == null;
    }
    
	/**   
	 * Returns true if the given target is in the binary tree.   
	 * Uses a recursive helper.  
	 * */  
	public boolean lookup( int year, String movieTitle) {    
		return(lookup(root, year, movieTitle));  
	}
	
	// public function of lookupNode also set's global value to default null, then gets the node by checking movie info
	public Node lookupNode( String actorMovieTitle) {
		result = null;
		lookupNode(root, actorMovieTitle);
		return result;  
	}
	
	// public function of lookupCastNode also set's global value to default null, then gets the node by checking actor info
	public castNode lookupCastNode( String name, String surname) {
		castResult = null;
		lookupCastNode(name, surname);
		return castResult;
	}
	
	/**   Recursive lookup  -- given a node, recur
	 * down searching for the given data.  
	 */  
	private boolean lookup(Node node, int year, String movieTitle) {    
		if (node==null) {      
			return false;    
		}    
		
		if (movieTitle==node.movieTitle) {
			return true;    
		}    
		else if ( year < node.year) {
			return(lookup(node.left, year, movieTitle));
		}    
		else { 
			return(lookup(node.right, year, movieTitle));    
		}  
	}
	
	// traverse tree and check if the movie title exist, if exist assign it to result
	public void lookupNode(Node node, String actorMovieTitle){
	      if (node == null) {
	    	  result = null;
	    	  return;
	      }
	      
	      lookupNode(node.left,actorMovieTitle);
	      
	      if(node.movieTitle.equals(actorMovieTitle)){
	          result = node;
	          return;
	      }
	      
	      lookupNode(node.right,actorMovieTitle);
	 }
	
	// check the node's castNode's for specified actor
	public void lookupCastNode(castNode node, String name, String surname){
	      if (node == null) {
	    	  castResult = null;
	    	  return;
	      }
	      
	      lookupCastNode(node.castLeft, name, surname);
	      
	      if(node.actorFirstName.equals(name) && node.actorLastName.equals( surname)){
	          castResult = node;
	          return;
	      }
	      
	      lookupCastNode(node.castRight, name, surname);
	 }
	
	// get the global result node
	public Node getResultNode() {
		return result;
	}
	
	// print info about movie which find the node first then get info about it
	public void showMovieInfo( String movieTitle) {
		lookupNode( movieTitle);
		
		if ( result != null ) {
			System.out.println( movieTitle);
			System.out.println( result.day + "/" + result.month + "/" + result.year);
			System.out.println( result.firstName + " " + result.lastName);
			
			printActorsInMovie( result.castRoot);
		}
	}
	
	// print actors in movie by inorder traverse
    public void printActorsInMovie(castNode node) {    	
        if (node == null)
            return;
        
        printActorsInMovie(node.castLeft);
        System.out.println(node.actorFirstName + " " + node.actorLastName + ", " + node.actorRole);
        printActorsInMovie(node.castRight);
    }
    
    // check is there a role for specified actor, if yes return true if not return false
    public boolean checkRole( Node node, String actorFirstName, String actorLastName) {
    	if ( node == null ) {
    		return false;
    	}
    	else {
    		if ( node.castRoot != null ) {
    			if ( node.castRoot.actorFirstName == actorFirstName && node.castRoot.actorLastName == actorLastName ) {
    				return true;
    			}
    			else {
    				lookupCastNode( node.castRoot, actorFirstName, actorLastName);
    				
    				if ( castResult != null ) {
    					return true;
    				}
    			}
    			
    			checkRole( node.left, actorFirstName, actorLastName);
    			checkRole( node.right, actorFirstName, actorLastName);
    		}
    	}
    	
    	return false;
    }
	
	// boolean for cast's actor, return true if find cast
	private boolean lookup(Node node, String actorMovieTitle) {    
		if (node==null) {      
			return false;    
		}    
		
		if (actorMovieTitle==node.movieTitle) {
			return true;    
		}    
		else {
			if ( (lookup(node.left, actorMovieTitle)) == false ) 
				return(lookup(node.right, actorMovieTitle));
			
			return(lookup(node.left, actorMovieTitle));
		}  
	}
	
	/**   
	 * Inserts the given data into the binary tree.   
	 * Uses a recursive helper.  
	 */  
	public void insert(int day, int month, int year, String movieTitle, String firstName, String lastName) {
		root = insert(root, day, month, year, movieTitle, firstName, lastName);  
	}
	
	// insert cast's actor
	public void insert( String actorMovieTitle, String actorFirstName, String actorLastName, String actorRole) {
		castNode castRoot = findMovieCast( actorMovieTitle);
		castRoot = insert(castRoot, actorMovieTitle, actorFirstName, actorLastName, actorRole);  
	}
	
	// this method finds the movie's cast's root by using lookupNode method
	public castNode findMovieCast( String actorMovieTitle) {
		lookupNode( actorMovieTitle);
		
		if ( result != null ) {
			return result.castRoot;
		}
		
		return null;
	}
	
	/**   
	 * Recursive insert -- given a actor's node pointer, recur down and
	 insert the given data into the tree. Returns the new
	 node pointer (the standard way to communicate
	 a changed pointer back to the caller).  
	 */  
	private castNode insert(castNode node, String actorMovieTitle, String actorFirstName, String actorLastName, String actorRole) {
		if (node==null) {
			node = new castNode(actorMovieTitle, actorFirstName, actorLastName, actorRole);
		}    
		else {
			if (isLeft( actorFirstName, actorLastName, node.actorFirstName, node.actorLastName)) {
				node.castLeft = insert(node.castLeft, actorMovieTitle, actorFirstName, actorLastName, actorRole);
			}      
			else {
				node.castRight = insert(node.castRight, actorMovieTitle, actorFirstName, actorLastName, actorRole);      
			}    
		}    
		
		return(node); // in any case, return the new pointer to the caller  }
	}
	
	/**   
	 * Recursive insert -- given a node pointer, recur down and
	 insert the given data into the tree. Returns the new
	 node pointer (the standard way to communicate
	 a changed pointer back to the caller).  
	 */
	private Node insert(Node node, int day, int month, int year, String movieTitle, String firstName, String lastName) {
		if (node==null) {
			node = new Node(day, month, year, movieTitle, firstName, lastName);
		}    
		else {
			if (year < node.year) {
				node.left = insert(node.left, day, month, year, movieTitle, firstName, lastName);
			}      
			else {
				node.right = insert(node.right, day, month, year, movieTitle, firstName, lastName);      
			}    
		}    
		
		return(node); // in any case, return the new pointer to the caller  }
	}
	
    /* Functions to delete data 
     * if it returns 0 -> tree empty
     * if it returns -1 -> movie not found
     * if it returns 1 -> movie deleted
     */
    public int delete( int year, String movieTitle) {
        if (isEmpty())
            return 0;
        else if (lookup(year, movieTitle) == false)
            return -1;
        else {
            root = delete(root, year, movieTitle);
            return 1;
        }
    }
    
    /* Functions to delete actor's data 
     * if it returns 0 -> tree empty
     * if it returns -1 -> movie not found
     * if it returns 1 -> movie deleted
     */
    public int delete( String actorMovieTitle, String actorFirstName, String actorLastName) {
        if (isEmpty())
            return 0;
        else if (lookup( root, actorMovieTitle) == false)
            return -1;
        else {
            castNode root = findMovieCast( actorMovieTitle);
            deleteNode(root, actorMovieTitle, actorFirstName, actorLastName);
            return 1;
        }
    }
    
    /* Functions to delete data for actors */
    private castNode deleteNode(castNode root, String actorMovieTitle, String actorFirstName, String actorLastName) {
    	castNode p, p2, n;
    	
        if (actorMovieTitle==root.actorMovieTitle) {
        	castNode lt, rt;
            lt = root.castLeft;
            rt = root.castRight;
            
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                p = rt;
                return p;
            }
            else if (rt == null) {
                p = lt;
                return p;
            }
            else {
                p2 = rt;
                p = rt;

                while (p.castLeft != null)
                    p = p.castLeft;

                p.castLeft = lt;
                return p2;
            }
        }

        if ( isLeft( actorFirstName, actorLastName, root.actorFirstName, root.actorLastName)) {
            n = deleteNode(root.castLeft, actorMovieTitle, actorFirstName, actorLastName);
            root.castLeft = n;
        }
        else {
            n = deleteNode(root.castRight, actorMovieTitle, actorFirstName, actorLastName);
            root.castRight = n;             
        }

        return root;
    }
    
    /* Functions to delete data */
    private Node delete(Node root, int year, String movieTitle) {
    	Node p, p2, n;
    	
        if (year==root.year && movieTitle==root.movieTitle) {
        	Node lt, rt;
            lt = root.left;
            rt = root.right;
            
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                p = rt;
                return p;
            }
            else if (rt == null) {
                p = lt;
                return p;
            }
            else {
                p2 = rt;
                p = rt;

                while (p.left != null)
                    p = p.left;

                p.left = lt;
                return p2;
            }
        }

        if (year < root.year) {
            n = delete(root.left, year, movieTitle);
            root.left = n;
        }
        else {
            n = delete(root.right, year, movieTitle);
            root.right = n;             
        }

        return root;
    }
    
    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }
    
    /* Function to count number of nodes recursively */
    private int countNodes(Node r) {
    	if (r == null)
            return 0;
        else {
            int l = 1;
            l = l + countNodes(r.left);
            l = l + countNodes(r.right);
            return l;
        }
    }
    
    // This method checks names by compareTo method and decides node should go left or right for lookup method
	private boolean isLeft( String firstName, String lastName, String dataFirstName, String dataLastName) {
		if ( firstName == dataFirstName && lastName.compareTo(dataLastName) < 0 ) {
			return true;
		}
		else if ( firstName.compareTo(dataFirstName) < 0 ) {
			return true;
		}
		
		return false;
	}
	
	// print inorder, means ascending by year for movie db class
    public void printInorderAscending(Node node) {
        if (node == null)
            return;

        printInorderAscending(node.left);
        System.out.println(node.movieTitle + ", " + node.year + ", " + node.firstName + " " + node.lastName);
        printInorderAscending(node.right);
    }
    
	// print inorder, means ascending by year for movie class showMovie method
    public void printInorderDetailedMovie(castNode node, boolean isMoviePrinted) {
    	if (node == null)
            return;
    	
    	if ( isMoviePrinted == false ) {
        	lookupNode( node.actorMovieTitle);
        	System.out.println( result.movieTitle);
    		System.out.println( result.day + "/" + result.month + "/" + result.year);
    		System.out.println( result.firstName + " " + result.lastName);
        }

        printInorderDetailedMovie(node.castLeft, true);
        System.out.println(node.actorFirstName + ", " + node.actorLastName + ", " + node.actorRole);
        printInorderDetailedMovie(node.castRight, true);
    }
    
    // print movies descending for the director
    public void printInorderDirector(Node node, String name, String surname, boolean isPrinted) {
        if (node == null)
            return;
        
        printInorderDirector(node.right, name, surname, true);
        if ( node.firstName == name && node.lastName == surname) {
        	System.out.println(node.movieTitle + ", " + node.day + "/" + node.month + "/" + node.year );
        }
        printInorderDirector(node.left, name, surname, true);
    }
    
    // print the specified year movie's info
    public void printInorderYear(Node node, int year) {    	
        if (node == null)
            return;
        
        printInorderYear(node.right, year);
        if ( node.year == year) {
        	System.out.println(node.movieTitle + ", " + node.firstName + " " + node.lastName + ", " + node.day + "/" + node.month);
        }
        printInorderYear(node.left, year);
    }
    
    // print info about movies btw years which traverse the tree and check if year value is btw
    public void printInorderBetweenYear(Node node, int startYear, int endYear) {    	
        if (node == null)
            return;
        
        printInorderBetweenYear(node.right, startYear, endYear);
        if ( startYear <= node.year && endYear >= node.year) {
        	System.out.println(node.movieTitle + ", " + node.firstName + " " + node.lastName + ", " + node.year);
        }
        printInorderBetweenYear(node.left, startYear, endYear);
    }
    
    // print the role of actors by traversing tree
    public void printInorderRole(Node node, String actorFirstName, String actorLastName ) {    	
        if (node == null)
            return;
        
        printInorderRole(node.right, actorFirstName, actorLastName);
        printInorderRole(node.left, actorFirstName, actorLastName);
    }
    
    // Print cast actor info about a movie
    public void printInorderCastNode(castNode node, String actorFirstName, String actorLastName ) {    	
        if (node == null)
            return;
        
        printInorderCastNode(node.castLeft, actorFirstName, actorLastName);
        if ( actorFirstName == node.actorFirstName && actorLastName == node.actorLastName) {
        	System.out.println(node.actorRole + ", " + node.actorMovieTitle);
        }
        printInorderCastNode(node.castRight, actorFirstName, actorLastName);
    }
    
    // check movie's releaseYear exist in tree
	public boolean checkYear(Node node, int year) {    
		if (node==null) {      
			return false;    
		}    
		
		if (year==node.year) {
			return true;    
		}    
		else if ( year < node.year) {
			return(checkYear(node.left, year));
		}    
		else { 
			return(checkYear(node.right, year));    
		}  
	}
	
	// check between years is there at least a movie
	public boolean checkBetweenYear(Node node, int startYear, int endYear) {    
		if (node==null) {      
			return false;    
		}    
		
		if ( startYear <= node.year && endYear >= node.year) {
			return true;    
		}    
		else if ( startYear < node.year) {
			return(checkBetweenYear(node.left, startYear, endYear));
		}    
		else { 
			return(checkBetweenYear(node.right, startYear, endYear));    
		}  
	}
    
    // get root of tree
    public Node getRoot() {
    	return root;
    }
    
    // gets day of specified node
    public int getDay( Node node) {
    	return node.day;
    }
    
    // gets month of specified node
    public int getMonth( Node node) {
    	return node.month;
    }
    
    // gets year of specified node
    public int getYear( Node node) {
    	return node.year;
    }
    
    // gets first name of specified node's director
    public String getFirstName( Node node) {
    	return node.firstName;
    }
    
    // gets last name of specified node's director
    public String getLastName( Node node) {
    	return node.lastName;
    }
    
}