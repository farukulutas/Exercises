import java.util.ArrayList;
import java.util.Scanner;

//Draws simple shapes
public class Lab6DriverTemplate {
	
	public static void main(String[] args) {
		ArrayList<ShapeGroup> shapeGroups = new ArrayList<ShapeGroup>();
		ShapeGroup universalShapes = new ShapeGroup();
		shapeGroups.add(universalShapes);
		//GRAPHICS: The next line will be removed or commented out before submission to Moodle
		//DrawingTool window = new DrawingTool(shapeGroups);
		
		Scanner scan = new Scanner(System.in);
		String userCommand = "";
		Movable m = new Rectangle(100,100,50,50);	
		while (! userCommand.equalsIgnoreCase("exit")) {
			System.out.print("Enter the command: ");
			userCommand = scan.nextLine();

			String [] parameters = userCommand.split(" ");
			String command = parameters[0];
			
			if (command.equals("addR")) {
				//TODO: Read parameters and create a Rectangle object
				int x = Integer.parseInt( parameters[1]);
				int y = Integer.parseInt( parameters[2]);
				int height = Integer.parseInt( parameters[3]);
				int width = Integer.parseInt( parameters[4]);
				Rectangle R = new Rectangle( x, y, height, width);
				
				//TODO: Add the object to the shapes list
				universalShapes.addShape(R);
				
				//TODO: Print the object
				System.out.println( R);		
			}
			else if (command.equals("addS")) {
				//TODO: Read parameters and create a Rectangle object
				int x = Integer.parseInt( parameters[1]);
				int y = Integer.parseInt( parameters[2]);
				int edge = Integer.parseInt( parameters[3]);
				Square S = new Square( x, y, edge);
				
				//TODO: Add the object to the shapes list
				universalShapes.addShape( S);
				
				//TODO: Print the object
				System.out.println(S);			
			}
			else if (command.equals("addC")) {
				//TODO: Read parameters and create a Rectangle object
				int x = Integer.parseInt( parameters[1]);
				int y = Integer.parseInt( parameters[2]);
				int radius = Integer.parseInt( parameters[3]);
				Circle C = new Circle( x, y, radius);
				
				//TODO: Add the object to the shapes list
				universalShapes.addShape( C);
				
				//TODO: Print the object
				System.out.println(C);		
			}
			else if (command.equals("move")) {
				//Read parameters
				int shapeNo = Integer.parseInt(parameters[1]);
				int x = Integer.parseInt(parameters[2]);
				int y = Integer.parseInt(parameters[3]);
				
				//TODO: Implement your own Movable interface according to the Lab4 example
				Movable sm = universalShapes.getShape(shapeNo-1);
				
				//TODO: Move the object by calling the move method				
				sm.move( x, y);
				universalShapes.getGroup().set( shapeNo-1, (Shape) sm);
				
				//TODO: Print the object
				System.out.println( universalShapes.getShape(shapeNo-1));
			}
			else if (command.equals("createEmptyGroup")) {
				ShapeGroup emptyGroup = new ShapeGroup();
				shapeGroups.add( emptyGroup);
				System.out.println( "\nNew Group Added.");
			}
			else if(command.equals("addToGroup")) {
				int groupNo = Integer.parseInt(parameters[1]);
				int shapeNo = Integer.parseInt(parameters[2]);
				
				shapeGroups.get( groupNo).addShape( shapeGroups.get( 0).getShape( shapeNo-1));
				shapeGroups.get( 0).removeShape( shapeNo-1);
				
				System.out.println( "\nLeft Top Point: x: " + (int) shapeGroups.get( groupNo).leftPoint.getX() 
						+ ", y: " + (int) shapeGroups.get( groupNo).leftPoint.getY());
				
				System.out.println( shapeGroups.get( groupNo).toString());
			}
			else if(command.equals("moveGroup")) {
				int groupNo = Integer.parseInt(parameters[1]);
				int x = Integer.parseInt(parameters[2]);
				int y = Integer.parseInt(parameters[3]);
				
				shapeGroups.get( groupNo).moveGroup( x, y);
				
				System.out.println( "\nLeft Top Point: x: " + (int) shapeGroups.get( groupNo).leftPoint.getX() 
						+ ", y: " + (int) shapeGroups.get( groupNo).leftPoint.getY());
				
				System.out.println( shapeGroups.get( groupNo).toString());
			}
			else if(command.equals("switchGroup")) {
				int prevGroupNo = Integer.parseInt(parameters[1]);
				int newGroupNo = Integer.parseInt(parameters[2]);
				int shapeNo = Integer.parseInt(parameters[3]);
				
				Shape s = shapeGroups.get( prevGroupNo).removeShape( shapeNo-1);
				shapeGroups.get( newGroupNo).addShape( s);
				
				System.out.println( "\nLeft Top Point: x: " + (int) shapeGroups.get( newGroupNo).leftPoint.getX() 
						+ ", y: " + (int) shapeGroups.get( newGroupNo).leftPoint.getY());
				
				System.out.print( shapeGroups.get( newGroupNo).toString());
				
				System.out.println( "\nLeft Top Point: x: " + (int) shapeGroups.get( prevGroupNo).leftPoint.getX() 
						+ ", y: " + (int) shapeGroups.get( prevGroupNo).leftPoint.getY());
				
				System.out.println( shapeGroups.get( prevGroupNo).toString());
			}
			else if(command.equals("mergeGroups")) {
				int groupNo1 = Integer.parseInt(parameters[1]);
				int groupNo2 = Integer.parseInt(parameters[2]);
				
				if ( groupNo2 >= groupNo1 ) {
					for ( int i = 0; i < shapeGroups.get( groupNo2).getGroup().size(); i++ ) {
						shapeGroups.get( groupNo1).addShape( shapeGroups.get( groupNo2).getGroup().get( i));
					}
					
					shapeGroups.remove( groupNo2);
					
					System.out.println( "\nLeft Top Point: x: " + (int) shapeGroups.get( groupNo1).leftPoint.getX() 
							+ ", y: " + (int) shapeGroups.get( groupNo1).leftPoint.getY());
					
					System.out.println( shapeGroups.get( groupNo1).toString());
				}
				else {
					for ( int j = 0; j < shapeGroups.get( groupNo1).getGroup().size(); j++ ) {
						shapeGroups.get( groupNo2).addShape( shapeGroups.get( groupNo1).getGroup().get( j));
					}
					
					shapeGroups.remove( groupNo1);
					
					System.out.println( "\nLeft Top Point: x: " + (int) shapeGroups.get( groupNo2).leftPoint.getX() 
							+ ", y: " + (int) shapeGroups.get( groupNo2).leftPoint.getY());
					
					System.out.println( shapeGroups.get( groupNo2).toString());
				}
			}
			
			//GRAPHICS: The next line will be removed or commented out before submission to Moodle
			//window.repaint();
			
		}		
		scan.close();
		System.exit(0);
	}

}