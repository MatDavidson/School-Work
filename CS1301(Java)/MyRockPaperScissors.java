//****************************************************************************
//Purpose:	Challenge the user to a game of Rock-Paper-Scissors.
//Input:		Prompt the use to enter number (0,1 or 2)
//Output:	Displays a report that shows the users decision and the computer's
//             random choice as well as who won.      
//Author:	Mathieu Davidson
//Class:		CS1301A
//Date:		9/3/2017
//Program:	MyRockPaperScissors.java
//****************************************************************************

//Import the Scanner class
import java.util.Scanner;

//Open the class
public class MyRockPaperScissors{

   //Declare variables
   static int playerChoice, compChoice;
      
   //Open the main method
   public static void main (String[]args){
   
      //Create a Scanner object
      Scanner input = new Scanner(System.in);

      //Give the rules of the game
      System.out.printf("\tLet's play Rock, Paper, Scissors!");
      System.out.printf("\n\t\tEnter '0' for Rock");
      System.out.printf("\n\t\tEnter '1' for Paper");
      System.out.printf("\n\t\tEnter '2' for Scissors");
      
      //Prompt the user for their choice
      System.out.printf("\n\tRock! Paper! Scissors! Shoot!\t");
      playerChoice = input.nextInt();
      
      //Terminate the program if the player enters an ivalid result
      if (playerChoice > 2){
         System.out.print("\n\tInvalid Input");
         System.exit(1);
      }
      
      //Display the report header
      System.out.print("\n\t******Rock Paper Scissors*****");
      System.out.printf("\n\t%-15s%15s", "Name:", "Mat Davidson");
      System.out.printf("\n\t%-15s%15s", "Course:", "CS1301A");
      System.out.printf("\n\t%-15s%15s", "Date:", "09/03/2017");
      System.out.print("\n\t******************************");
      
      //Display the user's choice 
      if (playerChoice == 0){
         System.out.printf("\n\t%-15s%15s", "Your Choice:", "Rock");
      }
      else if (playerChoice == 1){
         System.out.printf("\n\t%-15s%15s", "Your Choice:", "Paper");
      }    
      else{
         System.out.printf("\n\t%-15s%15s", "Your Choice:", "Scissors");
      }
                  
      //Determine the computer's choice
      compChoice = (int)(Math.random() * 3);
       
      //Display the computer's choice 
      if (compChoice == 0){
         System.out.printf("\n\t%-15s%15s", "Computer Chose:", "Rock");
      }
      else if (compChoice == 1){
         System.out.printf("\n\t%-15s%15s", "Computer Chose:", "Paper");
      }    
      else{ 
         System.out.printf("\n\t%-15s%15s", "Computer Chose:", "Scissors");   
      }

      //Determine the result of the game with a switch statement
      switch(playerChoice){
         case 0:
            if (compChoice == 0){
               System.out.printf("\n\t%-15s%15s", "Game Result:", "Draw");
            }
            else if (compChoice == 1){
               System.out.printf("\n\t%-15s%15s", "Game Result:", "You Lose");
            }
            else{
               System.out.printf("\n\t%-15s%15s", "Game Result:", "You Win!");
            }  
            break; 
         case 1:
            if (compChoice == 0){
               System.out.printf("\n\t%-15s%15s", "Game Result:", "You Win!");
            }
            else if (compChoice == 1){
               System.out.printf("\n\t%-15s%15s", "Game Result:", "Draw");
            }
            else{
               System.out.printf("\n\t%-15s%15s", "Game Result:", "You Lose");
            }
            break;
         case 2:
            if (compChoice == 0){
               System.out.printf("\n\t%-15s%15s", "Game Result:", "You Lose");
            }
            else if (compChoice == 1){
               System.out.printf("\n\t%-15s%15s", "Game Result:", "You Win!");
            }
            else{
               System.out.printf("\n\t%-15s%15s", "Game Result:", "Draw");
            }
            break;
      }//End of switch statement
   
   }//End of main method  
   
}//End of Class   