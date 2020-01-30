package prob2;

public class IllegalRectangleException extends RuntimeException {

	private double width = 0.0;
	private double height = 0.0;
	private double area = 0.0;
	
	public IllegalRectangleException(String message, double width, double height) {
		super(message);
		this.width = width;
		this.height = height;
		this.area = width * height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getArea() {
		return area;
	}
}
