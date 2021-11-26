import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingTool extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<ShapeGroup> items = new ArrayList<ShapeGroup>();

	private Color lineColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	
	public DrawingTool (ArrayList<ShapeGroup> allShapes) {
		//set frame's title
	    super();
	    JFrame board = new JFrame("Drawing some shapes");
	    board.setSize(415, 440);//set frame size
	    board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set close button to exit
	    board.setVisible(true);
	    board.add(this);
	    this.items = allShapes;
		
	    this.setSize(400, 400);
	    
	    //make this frame visible
	    this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(fillColor);
		g.fillRect(0, 0, 400, 400);
		for (ShapeGroup shapeGroup : items) {
			for(Shape s: shapeGroup.getGroup()){
				this.draw(g,s);
			}
		}
		
	}
	
	public void draw(Graphics g, Movable item) {
		g.setColor(lineColor);
		Shape obj = (Shape) item;
		if (obj.leftTop != null) {
			if (!obj.isCircular) {
				Point startPoint  = obj.points.get(0);
				Point prevPoint   = obj.points.get(0);
				Point currentPoint= obj.points.get(0);
				for (int i=1; i<obj.points.size(); i++ ){
					currentPoint = obj.points.get(i);
					g.drawLine(prevPoint.x, prevPoint.y, currentPoint.x ,currentPoint.y);
					prevPoint = currentPoint;
				}
				g.drawLine(currentPoint.x, currentPoint.y, startPoint.x ,startPoint.y);
			}
			else {
				g.drawOval(obj.points.get(0).x, obj.points.get(0).y, (obj.points.get(1).x-obj.points.get(0).x), (obj.points.get(1).x-obj.points.get(0).x));
			}
			
		}
	}
	
}