//****************************************************************************
//Purpose:	Using static methods, read user input about daily driving habits 
//             and display their daily drving cost
//Input:		Reading name, miles per day, miles per gallon, cost of gas, tolls,
//             and parking fees
//Output:	Displays daily driving cost for the driver or if split
//Author:	Mathieu Davidson
//Class:		CS1301A
//Date:		8/22/2017
//Program:	CarpoolCalculator.java
//****************************************************************************


// Use an import statement to import the scanner class
import java.util.Scanner;

//Begin Class
public class CarpoolCalculator {

   //Declarations: I want variables for miles driven per day, fuel economy of the vehicle, cost 
   //              of gasoline per gallon, parking fees and daily tolls. I also need variables 
   //              for the calculations of total cost and if that cost were divided by number of 
   //              possible passengers
   private static double totalMiles, milesPerGallon, gasPrice, parkingFees, tolls, dailyCost1, dailyCost2, dailyCost3, dailyCost4;
   
   //Open the main method to invoke the other methods I intend to use in the program
   public static void main (String [] args) {
      
      userInput();
      calculations();
      printReport();
   }//End of main
      
   //Open the method userInput to obtain information from the user
   public static void userInput(){
      
      //Create a scanner object
      Scanner input = new Scanner(System.in);      

      //Obtain information from the user 
      System.out.print ("Enter the total miles traveled per day as an integer:\t");
      totalMiles = input.nextDouble();
      System.out.print ("Enter your vehicle's miles per gallon as an integer: \t");
      milesPerGallon = input.nextDouble();  
      System.out.print ("Enter the price per gallon of gas:                    \t");
      gasPrice = input.nextDouble();  
      System.out.print ("Enter parking fees. If none enter 0:                 \t");
      parkingFees = input.nextDouble();
      System.out.print ("Enter any daily tolls. If none enter 0:              \t");
      tolls = input.nextDouble();
   }//End of userInput method
   
   //Open the calculations method to generate the daily costs
   public static void calculations(){
   
      //Enter the expression to find the value for dailyCost1
      dailyCost1 = (totalMiles / milesPerGallon) * gasPrice + parkingFees + tolls;
      
      //Find the values for dailyCost2, dailyCost3 and dailyCost4
      dailyCost2 = dailyCost1 / 2;
      dailyCost3 = dailyCost1 / 3;
      dailyCost4 = dailyCost1 / 4;
   }//End of calculations
   
   //Open the printHeader method to determine the information that it will display
   public static void printHeader(){
      
      System.out.println ("\n\t*********Carpool Report*************");
		System.out.printf ("\n\t%-20s%-20s", "Name:", "Mathieu Davidson");
      System.out.printf ("\n\t%-29s%-29s", "Class:", "CS1301A");
      System.out.printf ("\n\t%-26s%-26s", "Date:", "08/22/2017");
     	System.out.println ("\n\t************************************");
   }//End of printHeader
   
   //Open the printFooter method to determine what the footer will display
   public static void printFooter(){
     
      System.out.println ("\n\n\t******** Save Some Money ***********");
      System.out.println ("\t******** Save The  World ***********");
   }//End of printFooter

   
   //Open the method printReport to display the desired information
   public static void printReport(){
      
      //Invoke printHeader
      printHeader();
      
            
      //Display the Information
      System.out.printf ("\n\t%-30s%6.2f","Total Miles:", totalMiles);
      System.out.printf ("\n\t%-30s%6.2f","Miles Per Gallon:", milesPerGallon);
      System.out.printf ("\n\t%-30s%6.2f","Price per Gallon:", gasPrice);
      System.out.printf ("\n\t%-30s%6.2f","Parking Fees:", parkingFees);
      System.out.printf ("\n\t%-30s%6.2f","Tolls:",tolls);
      System.out.printf ("\n\n\t%-30s%6.2f","Your Daily Cost:", dailyCost1);
      System.out.printf ("\n\t%-30s%6.2f","Cost split with 1 passenger :",  dailyCost2);
      System.out.printf ("\n\t%-30s%6.2f","Cost split with 2 passengers:", dailyCost3);
      System.out.printf ("\n\t%-30s%6.2f","Cost split with 3 passengers:", dailyCost4);
      
      //Invoke printFooter
      printFooter();

      //Sample Output
      //*********Carpool Report*************
	   //Name:               Mathieu Davidson    
      //Class:                       CS1301A                      
  	   //Date:                     08/22/2017                
      //************************************
     
      //Total Miles:                    4.00
      //Miles Per Gallon:              30.00
      //Price per Gallon:               2.15
      //Parking Fees:                   0.00
      //Tolls:                          0.00
   
      //Your Daily Cost:                0.29
      //Cost split with 1 passenger :   0.14
      //Cost split with 2 passengers:   0.10
      //Cost split with 3 passengers:   0.07
   
      //******** Save Some Money ***********
      //******** Save The  World ***********



   }//end of printReport

}//end of class

      
      
      
      
    