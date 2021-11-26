import java.awt.Point;

public class Square extends Shape {
	private int edge;

	public Square( int x, int y, int edge) {
		super( x, y);

		this.edge = edge;
		this.calculatePoints();
		this.area = this.calculateArea();
		this.perimeter = this.calculatePerimeter();
	}

	@Override
	public void calculatePoints() {
		Point leftTop = new Point();
		Point rightTop = new Point();
		Point rightBottom = new Point();
		Point leftBottom = new Point();
		
		leftTop.setLocation( this.leftTop);
		rightTop.setLocation( this.leftTop.getX() + this.edge, this.leftTop.getY());
		rightBottom.setLocation( this.leftTop.getX() + this.edge, this.leftTop.getY() + this.edge);
		leftBottom.setLocation( this.leftTop.getX(), this.leftTop.getY() + this.edge);
		
		this.points.add( leftTop);
		this.points.add( rightTop);
		this.points.add( rightBottom);
		this.points.add( leftBottom);		
	}

	@Override
	public double calculateArea() {
		return edge * edge;
	}

	@Override
	public double calculatePerimeter() {
		return edge * 4;
	}

	@Override
	public String toString() {
		return "\nSquare[e=" + edge + "]\n" + "Points[" + "(" + (int)this.points.get(0).getX() + "," 
				+ (int)this.points.get(0).getY() + ")" + "(" + (int)this.points.get(1).getX() + "," 
				+ (int)this.points.get(1).getY() + ")" + "(" + (int)this.points.get(2).getX() + "," 
				+ (int)this.points.get(2).getY() + ")" + "(" + (int)this.points.get(3).getX() + "," 
				+ (int)this.points.get(3).getY() + ")" + "]\nArea=" +  Math.round(this.area * 10) / 10.0 
				+ "\nPerimeter=" +  Math.round(this.perimeter * 10) / 10.0;
		}
}