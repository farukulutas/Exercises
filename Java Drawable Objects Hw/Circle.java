import java.awt.Point;

public class Circle extends Shape {
	private int radius;

	public Circle( int x, int y, int radius) {
		super( x, y);
		this.isCircular = true;
		this.radius = radius;
		this.calculatePoints();
		this.area = this.calculateArea();
		this.perimeter = this.calculatePerimeter();
	}
	
	@Override
	public void calculatePoints() {
		Point leftTop = new Point();
		Point rightBottom = new Point();
		
		leftTop.setLocation( this.leftTop);
		rightBottom.setLocation( this.leftTop.getX() + (2 * radius), this.leftTop.getY() + (2 * radius));
		
		this.points.add( leftTop);
		this.points.add( rightBottom);
	}

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "\nCircle[r=" + radius + "]\n" + "Points[" + "(" + (int)this.points.get(0).getX() + "," 
				+ (int)this.points.get(0).getY() + ")" + "(" + (int)this.points.get(1).getX() + "," 
				+ (int)this.points.get(1).getY() + ")]\nArea=" + Math.round(this.area * 10) / 10.0 
				+ "\nPerimeter=" +  Math.round(this.perimeter * 10) / 10.0;
		}

}
