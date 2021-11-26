import java.awt.Point;
import java.util.ArrayList;

public class ShapeGroup {
	private ArrayList<Shape> shapeList;
	Point leftPoint;
	
	public ShapeGroup() {
		this.shapeList = new ArrayList<Shape>();
		this.leftPoint = new Point();
		this.findLeftTop();
	}
	
	public void addShape( Shape newOne) {
		this.shapeList.add( newOne);
		this.findLeftTop();
	}
	
	public Shape removeShape( int idx) {
		Shape s = this.shapeList.get( idx);
		this.shapeList.remove( idx);
		this.findLeftTop();
		
		return s;
	}
	
	public void moveGroup( int newx, int newy) {
		int x = newx - (int) this.leftPoint.getX();
		int y = newy - (int) this.leftPoint.getY();
		this.leftPoint = new Point( newx, newy);
		
		
		for ( int i = 0; i < this.shapeList.size(); i++ ) {
			this.shapeList.get( i).move( (int) this.shapeList.get( i).leftTop.getX() + x, (int) this.shapeList.get( i).leftTop.getY() + y);
		}
	}
	
	public Shape getShape( int idx) {
		return this.shapeList.get( idx);
	}
	
	public void findLeftTop() {
		if ( this.shapeList.size() > 0 ) {
			int x = (int) this.shapeList.get( 0).leftTop.getX();
			int y = (int) this.shapeList.get( 0).leftTop.getY();
			
			for ( int j = 0; j < this.shapeList.size(); j++ ) {
				if ( (int) this.shapeList.get( j).leftTop.getX() < x ) {
					x = (int) this.shapeList.get( j).leftTop.getX();
				}
				
				if ( (int) this.shapeList.get( j).leftTop.getY() < y ) {
					y = (int) this.shapeList.get( j).leftTop.getY();
				}
			}
			
			this.leftPoint.setLocation( x, y);
		}
	}
	
	public ArrayList<Shape> getGroup() {
		return this.shapeList;
	}
	
	public String toString() {
		String str = "";
		
		for ( int k = 0; k < this.shapeList.size(); k++ ) {
			str = str + "Shape " + (k + 1) + ":" + this.shapeList.get( k).toString();
			
			if ( k != this.shapeList.size() - 1 ) {
				str = str + '\n';
			}
		}
		
		return str;
	}
	
}
