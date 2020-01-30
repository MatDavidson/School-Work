//*********************************
//Purpose:	Skeleton for a menu-driven program
//Input:		User's selection
//Output:	Messages
//Author;	Fares (and Davidson 10/11/17)
//Program:	
//Date:		9/28/2015
//**********************************

import java.util.Scanner; 
public class ProcessMyAccount7{

	// Declarations
    Scanner scan = new Scanner(System.in);
	 String outputString, outMessage;
	 Account7 checking = null;
    Account7 savings  = null;
	 int option;
	 //int lines;
	
	 public ProcessMyAccount7(){
 	 
	 outputString =  "\n\t1  Create a Checking Account" +
	 					  "\n\t2  Deposit into Checking Account" +
      				  "\n\t3  Withdraw from Checking Account" +
                    "\n\t4  Display Checking Account Information" +
                    "\n\n\t5  Create a Savings Account" +
	 					  "\n\t6  Deposit into Savings Account" +
      				  "\n\t7  Withdraw from Savings Account" +
                    "\n\t8  Display Savings Account Information" +
						  "\n\n\t9  Display Summary for both accounts" +
						  "\n\n\t10  Display Menu" +		
						  "\n\n\n\t0  Quit\n\n\n";
		displayMenu();
		}

  	public void displayMenu() {
         String owner = "Unknown";
         String number = "999999";
         double initial = 0;
         double balance = 0;
         double withdrawalFees = 0;
         double amount = 0;
         
		  	System.out.println(outputString);
			System.out.print("\tEnter your selection:   ");
			option = scan.nextInt();
			//Account7 checking = new Account7();
         //Account7 savings = new Account7();
				  	
			// Keep reading data until the user enters 0
		   while (option != 0) {
					    			
					switch (option) {
			
						case 1:  // Create a checking account
                           //prompt user to enter account's information
                           //such as name, number, original balance, and withdrawal's fees
                           //Create a checking account object
                           
                           System.out.print("\n\tEnter Owner:\t");
                           scan.nextLine(); // had to add this because for some reason, the program was skipping the input for owner                           
                           owner = scan.nextLine();
                           System.out.print("\n\tEnter Account Number:\t");
                           number = scan.nextLine();
                           System.out.print("\n\tEnter Initial Balance:\t");
                           initial = scan.nextDouble();
                           System.out.print("\n\tEnter Withdrawal Fees:\t");
                           withdrawalFees = scan.nextDouble();
                           
                           checking = new Account7(owner, number, initial, withdrawalFees);// creates a checking account object and passes the values of the variables to the method
                           break;
							
						case 2: 	//Read an amount to deposit into checking account
                           System.out.print("\tEnter Deposit Amount:\t");
                           amount = scan.nextDouble();
                           checking.deposit(amount);//tells the checking object to call on the deposit method and passes the value of the variable amount
									break;
					
						case 3:	//Read an amount to withdraw from checking account
                           System.out.print("\tEnter Withdrawal Amount:\t");
                           amount = scan.nextDouble();
                           checking.withdraw(amount);//tells the checking object to call on the withdraw method and passes the value of the variable amount
									break;
				               
						case 4: 	//Display Summary of Checking Account
                           
                           System.out.println (checking.toString());//tells the checking object to call on the toString method
									break;
                           
                  case 5:  // Create a savings account. Smilar to checking
                           System.out.print("\n\tEnter Owner:\t");
                           scan.nextLine();                          
                           owner = scan.nextLine();
                           System.out.print("\n\tEnter Account Number:\t");
                           number = scan.nextLine();
                           System.out.print("\n\tEnter Initial Balance:\t");
                           initial = scan.nextDouble();
                           System.out.print("\n\tEnter Withdrawal Fees:\t");
                           withdrawalFees = scan.nextDouble();
                           
                           savings = new Account7(owner, number, initial, withdrawalFees);// creates a savings account object and passes the values of the variables to the method
                           break;
							
						case 6: 	//Read an amount to deposit into savings account
                           System.out.print("\tEnter Deposit Amount:\t");
                           amount = scan.nextDouble();
                           savings.deposit(amount);//tells the savings object to call on the deposit method and passes the value of the variable amount
									break;
					
						case 7:	//Read an amount to withdraw from savings account
                           System.out.print("\tEnter Withdrawal Amount:\t");
                           amount = scan.nextDouble();
                           savings.withdraw(amount);//tells the savings object to call on the withdraw method and passes the value of the variable amount
									break;
				
   					case 8: 	//Display Summary of Savings Account
                           System.out.println (savings.toString());//tells the savings object to call on the toString method
									break;

                  case 9: //invoke displaySummeryOfAllAccounts
                           Account7.displaySummaryOfAllAccounts();//tells the class Account7 to call on the method displaySummaryOfAllAccounts
                           break;
                           
					   case 10: displayMenu();
                           break;
                           					
						default: outMessage= "\nInvalid Selection\n";
			  						System.out.println(outMessage);
			  						break;
              }// end of switch
               
  				System.out.println(outputString);
				System.out.print("\tEnter your selection:   ");
				option = scan.nextInt();	
			 
		    }// end of while loop	    
		  }// end of main method
}// end of class
