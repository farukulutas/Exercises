import java.awt.Point;
import java.util.ArrayList;

public abstract class Shape implements Movable {
  
  // Variables
  Point leftTop;
  boolean isCircular;
  ArrayList<Point> points;
  double area, perimeter;
  
  // Constructors
  public Shape( int x, int y) {
	  this.leftTop = new Point( x, y);
	  this.isCircular = false;
	  this.points = new ArrayList<Point>();
	  this.area = 0;
	  this.perimeter = 0;
  }
  
  // Methods
  public void move(int newx, int newy) {
	  this.leftTop = new Point( newx, newy);
	  this.points.clear();
	  this.calculatePoints();
  }
  
  // Abstract Methods
  public abstract void calculatePoints();
  public abstract double calculateArea();
  public abstract double calculatePerimeter();
  public abstract String toString();
  
}