package prob1;

import emps.Employee;

public class Store {
	Employee[] emps = new Employee[20];   //Array to hold employees
	int numEmps = 0;   //int variable to keep track of the number of employees
	
	//main method for the provided test code
	public static void main(String[] args) {
		
		// Test to verify signatures correct.
		Store s = new Store();
		s.addEmp(new Employee("a",10.0));
		Employee e = s.getEmp(0);
		int numEmps = s.getNumEmps();
		double totHours = s.getTotalHours();
		double totPay = s.getTotalPay();
		Employee e2 = s.removeEmployee(0);
		String str = s.toString();
		
	}
	//Getter for the number of employees
	public int getNumEmps(){
		return numEmps;
	}
	//Method to add a new employee to the employee array
	public void addEmp(Employee e){
		//Check to ensure that the employee array is not full. If so, do nothing.
		if (numEmps >= 20) {
			return;
		}
		emps[numEmps] = e;
		numEmps++;
	}
	//Method to remove an employee from the emps array and return it. Also manipulates the 
	//	array so that the empty space is filled
	public Employee removeEmployee(int i){
		//Checks to ensure that the accepted index holds an employee. If not, return null
		if( i >= numEmps) {
			return null;
		}
		Employee temp = emps[i];   //Place the employee at the index into a temp holder
		
		//Loop through the rest of the employees starting at the index. Shift each employee
		//	one slot to the left to fill in the empty space.
		for( int j = i; j < numEmps; j++){
			if(numEmps == 20 && j == 19) {
				emps[j] = null;
				continue;
			}
			else {
				emps[j] = emps[j+1];
			}
		}
		numEmps--;
		emps[numEmps] = null;
		return temp;
	}
	//Getter for the employee at the passed index
	public Employee getEmp(int i){
		//Checks to ensure there is an employee at the index, if not return null
		if(emps[i] != null) {
			return emps[i];
		}
		else {
			return null;
		}
	}
	//Getter for total hours for all employees
	public double getTotalHours(){
		double totalHours = 0.0;   //double to hold the hours for each employee
		
		//Loop through the employee array and add the hours from each one to totalHours
		for( int i = 0; i < numEmps; i++) {
			totalHours += emps[i].getTotalHours();
		}
		return totalHours;
	}
	//Getter for total pay for all employees
	public double getTotalPay(){
		double totalPay = 0.0;//double to hold the pay for each employee
		
		//Loop through the employee array and add the pay from each one to totalPay
		for( int i = 0; i < numEmps; i++) {
			totalPay += emps[i].getPay();
		}
		return totalPay;
	}
	
	public String toString(){
		StringBuilder report = new StringBuilder();
		
		report.append("Payroll Report\n\n");
		report.append(String.format("Num Employees:%d, total hrs:%.2f, total pay=$%,.2f\n\n", numEmps, getTotalHours(), getTotalPay()));
		
		for( int i = 0; i < numEmps; i++) {
			report.append(emps[i].toString());
		}
		return report.toString();
	}
}
