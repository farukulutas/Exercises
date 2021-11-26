import java.awt.Point;

public class Rectangle extends Shape {
	private int height, width;

	public Rectangle( int x, int y, int height, int width) {
		super( x, y);
		
		this.height = height;
		this.width = width;
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
		rightTop.setLocation( this.leftTop.getX() + this.width, this.leftTop.getY());
		rightBottom.setLocation( this.leftTop.getX() + this.width, this.leftTop.getY() + this.height);
		leftBottom.setLocation( this.leftTop.getX(), this.leftTop.getY() + this.height);
		
		this.points.add( leftTop);
		this.points.add( rightTop);
		this.points.add( rightBottom);
		this.points.add( leftBottom);
	}

	@Override
	public double calculateArea() {
		return height * width;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * (height + width);
	}

	@Override
	public String toString() {
		return "\nRectangle[h=" + height + ",w=" + width + "]\n" + "Points[" + "(" + (int)this.points.get(0).getX() 
				+ "," + (int)this.points.get(0).getY() + ")" + "(" + (int)this.points.get(1).getX() + "," 
				+ (int)this.points.get(1).getY() + ")" + "(" + (int)this.points.get(2).getX() + "," 
				+ (int)this.points.get(2).getY() + ")" + "(" + (int)this.points.get(3).getX() + "," 
				+ (int)this.points.get(3).getY() + ")" + "]\nArea=" + Math.round(this.area * 10) / 10.0 
				+ "\nPerimeter=" +  Math.round(this.perimeter * 10) / 10.0;
	}

}