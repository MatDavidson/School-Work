package prob1;

public class CheckingAccount {

	protected double balance = 0.0;
	protected int id = 0;
	protected boolean isLowBalance = false;
	protected int numWithdrawals = 0;
	
	public CheckingAccount() {
		this(000, 0.0);
		isLowBalance();
	}

	public CheckingAccount(int id, double balance) {
		this.id = id;
		this.balance = balance;
		isLowBalance();
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isLowBalance() {
		if(isLowBalance || balance < 100.0) {
			isLowBalance = true;
			return true;
		}	
		else {
			isLowBalance = false;
			return false;
		}
	}
	
	public int getNumWithdrawals() {
		return numWithdrawals;
	}
	
	public void deposit(double amt) {
		if(amt < 0) 
			return;
		else
			balance += amt;
	}
	
	public void withdrawal(double amt) {
		balance -= amt;
		numWithdrawals++;
		
		if( numWithdrawals > 3) {
			balance -= 2.0;
		}
		if( balance < 0.0) {
			balance -= 20.0;
		}
		
		isLowBalance();
		
	}
	
	public void endOfMonth() {
		numWithdrawals = 0;
		
		if(isLowBalance) {
			balance -= 10.0;
			if(balance < 0.0) {
				balance -= 20.0;
			}
		}
		isLowBalance = false;
		isLowBalance();
	}
	
	public String toString() {
		String result = String.format("CA : id=%d, balance=$%,.2f, isLowBalance=%b, num withdrawals=%d", id, balance, isLowBalance, numWithdrawals);		
		return result;
	}
}
