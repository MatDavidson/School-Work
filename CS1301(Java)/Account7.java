//********************************************************************
// Purpose: Represents a bank account with basic services such as deposit
// and withdraw
// Author: Mathieu Davidson   
// Course: CS1301A
// Date:   10/11/17
//
//  
//********************************************************************

import java.text.DecimalFormat;
import java.util.Date;
public class Account7
{
   //Declare account variables to hold owner, number,
   //balance, fees, and date created
   private String name;
   private String number;
   private double originalBalance;
   private double balance;
   private double fees;
   private Date dateCreated;
     
   //Declare and initialize to 0 the static variables to hold totals for all accounts
   static double totalDeposits = 0;
   static double totalWithdrawals =0;
   static double totalFees = 0;
   static double totalBalance = 0;
   static double totalOriginals = 0; 
   
     
   //-----------------------------------------------------------------
   //  no-argument constructor for account. 
   //  Assign the default values to the attributes (fields above):
   //  "Unknown" to owner
   //  "99999" to number
   //  0 to balance,
   //  0 to originalBalance
   //  3 to fees
   //  current date to date created
   //-----------------------------------------------------------------
   public Account7()
   {
       name = "Unknown";
       number = "99999";
       originalBalance = 0;
       balance = 0;
       fees = 3;
       dateCreated = new Date();

   }// end no-argument constructor

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner, account number,
   //  and initial balance, and withdrawal fees. You may 
   //  update total original balance and total current balance
   //  Also, assign current date to date created 
   //-----------------------------------------------------------------
   public Account7(String owner, String account, double initial, double withdrawalFees)
   {
       name = owner;
       number = account;
       originalBalance = initial;
       balance = initial;
       fees = withdrawalFees;
       dateCreated = new Date();
       totalOriginals += initial;
       totalBalance += initial;//these two lines update the varibles for totals
   }//end overloaded constructor

   //-----------------------------------------------------------------
   //  Deposits the specified amount into the account. Returns the
   //  new balance. You may 
   //  update total current balance and total deposits
   //-----------------------------------------------------------------
   public double deposit(double amount)
   {
      balance += amount;
      totalDeposits += amount;
      totalBalance += amount;//these two lines update totals variables
      return balance;
   }//end deposit

   //-----------------------------------------------------------------
   //  Withdraws the specified amount from the account
   //  Returns the new balance.You may 
   //  update total current balance, total withdrawals, and total fees
   //-----------------------------------------------------------------
   public double withdraw(double amount)
   {
      balance -= amount + fees;
      totalWithdrawals += amount;
      totalFees += fees;          //these two lines update the variables for the totals
      totalBalance -= amount; //this line subtracts the amount from the totalBalance variable
      return balance;
   }//end withdraw

   //-----------------------------------------------------------------
   //  Returns the current balance of the account.
   //-----------------------------------------------------------------
   public double getBalance()
   {   
      return balance;

   }//end getBalance

   //-----------------------------------------------------------------
   //  Returns all account information.
   //-----------------------------------------------------------------
   public String toString()
   {
      DecimalFormat fmt = new DecimalFormat("$###,##0.00");
      String info =   "\n\tName:                \t" + name +
                      "\n\tAccount Number:      \t" + number +
                      "\n\tOriginal Balance:    \t" + fmt.format(originalBalance) +                        
                      "\n\tCurrent Balance:     \t" + fmt.format(balance) +
                      "\n\tWithdrawal Fee:      \t" + fmt.format(fees) + 
                      "\n\tDate Created:        \t" + dateCreated;                      
      return info;
   }//enf toString
   
   //-----------------------------------------------------------------
   //  Display summary of all accounts: i.e., 
   //    total original balance for all accounts
   //    total current balances for all accounts
   //    total deposits for all accounts
   //    total widthraws for all accounts
   //    total fees paid for all accounts
   // -----------------------------------------------------------------
   public static void displaySummaryOfAllAccounts(){
        System.out.printf ("\n\t%-30s%10.2f", "Total Deposits:", totalDeposits);
        System.out.printf ("\n\t%-30s%10.2f", "Total Withdrawals:", totalWithdrawals);
        System.out.printf ("\n\t%-30s%10.2f", "Total Fees:", totalFees);
        System.out.printf ("\n\t%-30s%10.2f", "Total Original Balances:", totalOriginals);
        System.out.printf ("\n\t%-30s%10.2f", "Total Balance:", totalBalance);
        System.out.println();
   }//end displaySumaryOfAllAccounts
   
}//end class