//****************************************************************************
//Purpose:	Using if/else statements to determine a value
//Input:		Read in a monthly sales amount for the user
//Output:	Displays a report that shows the commission and commission rate 
//              for the month along with the chart that shows what amount
//              gives what commission rate.     
//Author:	Mathieu Davidson
//Class:		CS1301A
//Date:		8/28/2017
//Program:	MyCommission3.java
//****************************************************************************


//Import the Scanner class to read in values form the user 
import java.util.Scanner;

//Open the class and name it MyCommission3
public class MyCommission3{

   //Declare variables
   public static double commission, commissionRate, sales;
   public static int percentage;

   //Open the main method
   public static void main (String[]args){
      userInput();
      calculations();
      printReport();
   }//End of main method
   
   //Open the user input method
   public static void userInput(){   
      //Create a scanner object to get user input
      Scanner input = new Scanner(System.in);
                  
      //Prompt the user to enter monthly sales value and assign the value to sales
      System.out.print ("Enter your total sales for the month:\t");
      sales = input.nextDouble();
   }//End of user input method
      
   //Open the calculations method
   public static void calculations(){   
      //Use if/else statments to determine the commission rate
      if (sales >= 22000.0){
         commissionRate = 0.16;
         }
      else if (sales >= 18000.0){
         commissionRate = 0.14;
         }
      else if (sales >= 15000.0){
         commissionRate = 0.12;
         }
      else if (sales >= 10000.0){
         commissionRate = 0.1;
         }
      else {
         commissionRate = 0.05;
         }
         
      //Calculate the commission using the rate determined with the if/else statements
      commission = sales * commissionRate;
      percentage = (int)(commissionRate * 100);  
   }//End of calculations method
   
   //Open the print report method
   public static void printReport(){   
      //Display the header
      printHeader();
      
      //Display the commission information and result
      System.out.printf ("\n\t%-32s%4s", "Sales", "Rate");
      System.out.print ("\n\t************************************");
      System.out.printf ("\n\t%-33s%3s", "Less than $10,000", "5%");
      System.out.printf ("\n\t%-33s%3s", "$10,000 - $14,999", "10%");
      System.out.printf ("\n\t%-33s%3s", "$15,000 - $17,999", "12%");
      System.out.printf ("\n\t%-33s%3s", "$18,000 - $21,999", "14%");
      System.out.printf ("\n\t%-33s%3s", "$22,000 or more", "16%");
      System.out.print ("\n\t************************************");
      System.out.printf ("\n\t%-28s%-28.2f", "Your Sales:", sales);
      System.out.printf ("\n\t%-33s%-28s", "Commission Rate:", percentage + "%");
      System.out.printf ("\n\t%-29s%-29.2f", "Your Commission: ", commission);
                            
                
   
   
   }//End of print report
   
   //Open the printHeader method to enter the information that it will display
   public static void printHeader(){
      
      System.out.println ("\n\t*********Commission Report**********");
		System.out.printf ("\n\t%-20s%-20s", "Name:", "Mathieu Davidson");
      System.out.printf ("\n\t%-29s%-29s", "Class:", "CS1301A");
      System.out.printf ("\n\t%-26s%-26s", "Date:", "08/28/2017");
     	System.out.println ("\n\t************************************");
   }//End of printHeader
   

}//End of class      