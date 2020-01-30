//********************************************************************
//  MyAccount.java       
//
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//********************************************************************

import java.text.DecimalFormat;
import java.util.Date;

public class MyAccount{

   //Declare variable to be used by the various methods in the classes implemented by the driver
   private String name = null;
   private long accountNumber = 0;
   private double originalBalance = 0;
   private double currentBalance = 0;
   private double totalDeposits = 0;
   private double totalWithdrawals = 0;
   private Date dateCreated = null;
   
   //-----------------------------------------------------------------
   //  1.   Sets up the account by defining default values for the 
   //  account.
   //-----------------------------------------------------------------
   //Create a no-argument constructor that defines a generic bank account and defines
   // the basic information for an account and shows the default values for each field
   public MyAccount(){
      name = "Unknown";
      accountNumber = 99999;
      originalBalance = 0;
      currentBalance = 0;
      dateCreated = new Date();      
   }//End MyAccount

   //-----------------------------------------------------------------
   //  2.   Sets up the account by defining its owner, account number,
   //  and initial balance.
   //-----------------------------------------------------------------
   //Create a constructor that accepts arguments to be implemented into the infromation
   // fields in the account and apply them to the indicated account
   public MyAccount(String owner, long account, double balance){
      name = owner;
      accountNumber = account;
      originalBalance = balance;
      currentBalance = balance;
      dateCreated = new Date();   
   }//End overloaded MyAccount

   //-----------------------------------------------------------------
   //  3.   getName:   returns name.
   //-----------------------------------------------------------------
   //Create a method that the driver can use to retrieve the name of the account owner of
   // the indicated account    
   public String getName(){        
      return name;
   }//End getName
   
   //-----------------------------------------------------------------
   //  4.   getAccountNumber:   returns account number.
   //-----------------------------------------------------------------
   //Create a method that the driver can use to retrieve the number assigned to an indicated
   // account 
   public long getAccountNumber(){ 
      return accountNumber;
   }//End getAccountNumber

   //-----------------------------------------------------------------
   //  5.   Returns the current balance of the account.
   //-----------------------------------------------------------------
   //Create a method that the driver can use to retrieve the balance of an indicated account
   public double getBalance(){   
      return currentBalance;
   }//end getBalance

   //-----------------------------------------------------------------
   //  6.   Updates name
   //-----------------------------------------------------------------
   //Create a method that will accept a string from the driver and apply it to the name field
   // of the indicated account
   public void setName(String newName){
      name = newName;    
   }//end setName

   //-----------------------------------------------------------------
   //  7.   Updates account number
   //-----------------------------------------------------------------
   //Create a method that will accept a long type number from the driver and apply it to  
   // the account number field of the indicated account
   public void setAccountNumber(long newAccountNumber){
      accountNumber = newAccountNumber;  
   }//End setAccountNumber

   //-----------------------------------------------------------------
   //  8.   Deposits the specified amount into the account. Returns the
   //  new balance.
   //-----------------------------------------------------------------
   //Create a method that will update the currentBalnce of an account by adding the amount of
   // the deposit and also by keeping track of the total amount of all deposits. Returns the
   // current balance after the deposit
   public double deposit(double amount){
      currentBalance += amount;
      totalDeposits += amount;
      return currentBalance;        
   }//End deposit

   //-----------------------------------------------------------------
   //  9.   Withdraws the specified amount from the account and return the new balance.
   //-----------------------------------------------------------------
   //Create a method that will update the currentBalnce of an account by subtracting the amount 
   // of the withdrawal and also by keeping track of the total amount of all withdrawals. Returns
   // the current balance after the withdrawal
   public double withdraw(double amount){
      currentBalance -= amount;
      totalWithdrawals += amount;
      return currentBalance;  
   }//End withdrawal

   
   //-----------------------------------------------------------------
   //  10.  Returns a one-line description of the account as a string.
   //-----------------------------------------------------------------
   //Create a method that will display all information about an account by creating a string. 
   // Apply the format to all monetary values in the account and include the date the report 
   // was created. Return the string 
   public String toString(){
      DecimalFormat fmt = new DecimalFormat("$###,##0.00");
      String info =   "\n\tName:                \t" + name +
                      "\n\tAccount Number:      \t" + accountNumber +
                      "\n\tOriginal Balance:    \t" + fmt.format(originalBalance) + 
                      "\n\tTotal Deposits:      \t" + fmt.format(totalDeposits) +
                      "\n\tTotal Withdrawals:   \t" + fmt.format(totalWithdrawals) + 
                      "\n\tCurrent Balance:     \t" + fmt.format(currentBalance) + 
                      "\n\tDate Created:        \t" + dateCreated;                      
      return info; 
   }//End toString
   
}//End class
