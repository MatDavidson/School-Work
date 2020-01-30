package prob2;

public class Rectangle extends GeometricObject {
  private double width;
  private double height;

  public Rectangle() {
  }

  public Rectangle(double width, double height) throws IllegalRectangleException {
	  if(width < 1.0 || height < 1.0) {
		  throw new IllegalRectangleException(String.format("Illegal Rectangle: Width=%.2f, Height=%.2f, Area=%.2f", width, height, width * height), width, height);
	  }
	  else {
		  this.width = width;
		  this.height = height;
	  }
  } 

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  @Override /** Return area */
  public double getArea() {
    return width * height;
  }

  @Override /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + height);
  }

  @Override 
  public String toString() {
    // Implement it to return the three sides
    return "Rectangle: width = " + width + ", height = " + height;
  }  
}
