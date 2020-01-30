//**************************************************************************
//Purpose: To create and manipulate polygon objects and print their data.
//Author: Mathieu Davidson and Bobby Duke
//Date: 11/26/2017
//**************************************************************************
public class MyRegularPolygon11{
   //Declare data fields
   private int n; //number of sides
   private double l; //length of sides
   private double x, y; //X,Y coordinates of the center of the polygon
   
   //No argument constructor that creates a polygon with default values
   public MyRegularPolygon11(){
      n = 3;
      l = 1;
      x = 0;
      y = 0;
   }//End No Arg Constructor 
   
   //Polygon constructor that accepts values for number of sides and lengths 
   // of sides but sets the coordinates of the center to 0,0
   public MyRegularPolygon11(int newN, double newL){
      n = newN;
      l = newL;
      x = 0;
      y = 0;
   }//End n, l Constructor
   
   //Polygon constructor that accepts values for all data fields
    public MyRegularPolygon11(int newN, double newL, double newX, double newY){
      n = newN;
      l = newL;
      x = newX;
      y = newY;
   }//End Overloaded Constructor
   
   //The following 4 methods are accessor methods that return the vaules of
   // the specified data field
   public int getN(){
      return n;
   }   
   
   public double getL(){
      return l;
   }
   
   public double getX(){
      return x;
   }
   
   public double getY(){
      return y;
   }  
   
   //The following 4 methods are mutator methods that accept a value and assign
   // it to the specified data field
   public void setN(int newN){
      n = newN;
   }   
   
   public void setL(double newL){
      l = newL;
   }
   
   public void setX(double newX){
      x = newX;
   }
   
   public void setY(double newY){
      y = newY;
   }
   
   //Method that returns the perimiter of the polygon
   public double getPerimeter(){
      return n*l;
   }
   
   //Method that returns the area of the polygon
   public double getArea(){
      return (n*l*l)/(4*Math.tan(Math.PI/n));
   }
   
   //Method that sums all data for the polygon into a String
   public String toString(){
      String data = "\n\tThe polygon has " + n + " sides." +
                    "\n\tThe sides are " + l + " units in length." +
                    "\n\tThe center is located at (" + x + ", " + y + ")." +              
                    "\n\tThe area of the polygon is " + getArea() + " square units." + 
                    "\n\tThe perimeter of the polygon is " + getPerimeter() + " units.";
      return data;
   }                             
}//End class      