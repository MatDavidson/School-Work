//**************************************************************************
//Purpose: To create and manipulate polygon objects by passing values to the
//         constructors in the MyRegularPolygon11 class
//Author: Mathieu Davidson and Bobby Duke
//Date: 11/26/2017
//**************************************************************************

//Import the scanner
import java.util.Scanner;

//Open the class
public class MyRegularPolygon11Tester{

   //Open the main method
   public static void main (String[] args){
   
      //Create a scanner object
      Scanner scan = new Scanner(System.in);
   
      //Create variables to parse command line arguments
      int newN;
      double newL, newX, newY;

      //Use the no argumnet constructor to create a basic polygon object
      MyRegularPolygon11 p1 = new MyRegularPolygon11();
      
      //Display the information about the polygon
      System.ouut.print("\n\t**Polygon P1**" + p1.toString() + "\n");
      
      //Set values to pass to the constructor
      newN = Integer.parseInt(args[0]);
      newL = Double.parseDouble(args[1]);
      
      //Create a polygon object with N sides of L length
      MyRegularPolygon11 p2 = new MyRegularPolygon11(newN, newL);
      
      //Display the information about the polygon
      System.out.print("\n\t**Polygon P2**" + p2.toString() + "\n");
      
      //Set values to pass to the next constructor
      newN = Integer.parseInt(args[2]);
      newL = Double.parseDouble(args[3]);
      newX = Double.parseDouble(args[4]);
      newY = Double.parseDouble(args[5]);
      
       //Create a polygon object with N sides of L length
      MyRegularPolygon11 p3 = new MyRegularPolygon11(newN, newL, newX, newY);
      
      //Display the information about the polygon
      System.out.print("\n\t**Polygon P3**" + p3.toString() + "\n"); 
      
      //Prompt the user to enter new values for polygon p3 and pas them 
      // to p3's mutator methods
      System.out.print("\n\tEnter a new number of sides for P3:\t");
      p3.setN(scan.nextInt());
      
      System.out.print("\n\tEnter a new length of sides for P3:\t");
      p3.setL(scan.nextDouble());
      
      System.out.print("\n\tEnter a new  X  coordinate  for P3:\t");
      p3.setX(scan.nextDouble());
      
      System.out.print("\n\tEnter a new  Y  coordinate  for P3:\t");
      p3.setY(scan.nextDouble());
      
      //Display the new P3 data
      System.out.print("\n\n\tLet's see how P3 has changed.");
      System.out.print("\n\t**Polygon P3**" + p3.toString() + "\n");


   }//End main
}//End class