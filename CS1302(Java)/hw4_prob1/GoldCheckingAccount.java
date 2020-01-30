package prob1;

public class GoldCheckingAccount extends CheckingAccount{
	
	public GoldCheckingAccount() {
		super(000, 0.0);
	}
	
	public GoldCheckingAccount(int id, double balance) {
		super(id, balance);
	}
	
	public boolean isLowBalance() {
		if(isLowBalance || balance < 1000.0) {
			isLowBalance = true;
			return true;
			
		}	
		else {
			isLowBalance = false;
			return false;
		}
	}
	
	public void withdrawal(double amt) {
		balance -= amt;
		
		if( balance < 0.0) {
			balance -= 20.0;
		}
		isLowBalance();
		numWithdrawals++;
	}
	
	public void endOfMonth() {
		numWithdrawals = 0;
		
		if(isLowBalance) {
			balance -= 25.0;
			if(balance < 0.0) {
				balance -= 20.0;
			}
		}
		else {
			balance += balance * .01;
		}
		
		isLowBalance = false;
		isLowBalance();
	}
	
	public String toString() {
		String result = String.format("GCA : id=%d, balance=$%,.2f, isLowBalance=%b, num withdrawals=%d", id, balance, isLowBalance, numWithdrawals);		
		return result;
	}
}
