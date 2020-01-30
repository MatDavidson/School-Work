package prob1;

public class Employee {

	private double[] hours = new double[7];
	private String name = "";
	private double payRate = 0.0;
	
	public Employee(String name, double payRate){
		this.name = name;
		this.payRate = payRate;
	}
	
	public double getHours(int i){
		return hours[i];
	}
	
	public String getName(){
		return name;
	}
	
	public int getNumDaysWorked(){
		int days = 0;
		
		for(int i = 0; i < hours.length; i++){
			if (hours[i] != 0)
				days++;
		}
		return days;
	}
	
	public double getPay(){
		double pay = 0.0;

		if( getWeekdayHours() > 40.0)
			pay = (payRate * 40.0) + (payRate * 1.5 * (getWeekdayHours()-40.0));
		
		else
			pay = (payRate * getWeekdayHours());
		
			pay  += (payRate * 2.0 * getWeekendHours());
			
		if ( getNumDaysWorked() == 7)
			pay += 50.0;
		return pay;
	}
	
    public double getPayRate(){
    	return payRate;
    }
    
    public double getTotalHours(){
    	double totalHours = 0;
    	
    	for(int i = 0; i < hours.length; i++){
    		totalHours += hours[i];
    	}
    	return totalHours;
    }
    
    public double getWeekendHours(){
    	double weekendHours = 0;
    	
    	for(int i = 5; i <= 6; i++){
    		weekendHours += hours[i];
    	}
    	return weekendHours;
    }
    
    public double getWeekdayHours(){
    	double weekdayHours = 0;
    	
    	for(int i = 0; i <= 4; i++){
    		weekdayHours += hours[i];
    	}
    	return weekdayHours;
    }
    
    public void mergeEmployee(Employee e2){
    	for(int i = 0; i < hours.length; i++)
   			this.hours[i] += e2.hours[i];    		    	
    }
    
    public void newWeek(){
    	for(int i = 0; i < hours.length; i++){
    		hours[i] = 0;
    	}	
    }
    
    public void setHours(int i, double num){
    	hours[i] = num;
    	
    }
    
    public String toString(){
    	String result = "";
    	
    	result += "Pay Stub";
    	result += "\n--------";
    	result += String.format("\n%s%s, %s $%.2f", "Name:", getName(), "Pay Rate", getPayRate()); 
    	result += String.format("\n%s%.2f %s%.2f %s%.2f %s%.2f %s%.2f %s%.2f %s%.2f", "Hours:Mon:", hours[0], "Tue:", hours[1], "Wed:", hours[2], "Thu:", hours[3], "Fri:", hours[4], "Sat:", hours[5], "Sun:", hours[6]);
    	result += String.format("\n%s%d, %s%.2f", "Days worked:", getNumDaysWorked(), "Total Hours:", getTotalHours()); 
    	result += String.format("\n%s%.2f, %s %.2f", "Weekday hours:", getWeekdayHours(), "Weekend hours:", getWeekendHours()); 
    	result += String.format("\n%s $%.2f", "Total pay:", getPay());
    	
    	return result;
    }
}
