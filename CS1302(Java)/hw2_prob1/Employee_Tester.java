//package prob1;
//
//public class Employee_Tester {
//
//	public static void main(String[] args) {
//		
//		Employee e1 = new Employee("Tom", 25.0);
//		
//		e1.setHours(0, 8);
//		e1.setHours(1, 8);
//		e1.setHours(2, 8);
//		e1.setHours(3, 8);
//		e1.setHours(4, 8);
//		e1.setHours(5, 0);
//		e1.setHours(6, 0);
//		
//		System.out.print(e1.toString());
//		
//		Employee e2 = new Employee("Linda", 10.0);
//		
//		e2.setHours(0, 8);
//		e2.setHours(1, 8);
//		e2.setHours(2, 4);
//		e2.setHours(3, 0);
//		e2.setHours(4, 0);
//		e2.setHours(5, 0);
//		e2.setHours(6, 0);
//		
//		System.out.print(e2.toString());
//		
//		Employee e3 = new Employee("Linda", 10.0);
//		
//		e3.setHours(0, 0);
//		e3.setHours(1, 0);
//		e3.setHours(2, 0);
//		e3.setHours(3, 0);
//		e3.setHours(4, 0);
//		e3.setHours(5, 5);
//		e3.setHours(6, 5);
//		
//		System.out.print(e3.toString());
//		
//		System.out.println("\n\nLinda submitted two time sheets this week.\nThis is the correct pay stub.");
//		e2.mergeEmployee(e3);
//		System.out.print(e2.toString());
//		
//		Employee e4 = new Employee("Steve", 25.0);
//		
//		e4.setHours(0, 0);
//		e4.setHours(1, 8);
//		e4.setHours(2, 8);
//		e4.setHours(3, 8);
//		e4.setHours(4, 0);
//		e4.setHours(5, 8);
//		e4.setHours(6, 0);
//		
//		System.out.print(e4.toString());
//		
//		Employee e5 = new Employee("Kate", 25.0);
//		
//		e5.setHours(0, 10);
//		e5.setHours(1, 10);
//		e5.setHours(2, 10);
//		e5.setHours(3, 10);
//		e5.setHours(4, 10);
//		e5.setHours(5, 0);
//		e5.setHours(6, 0);
//		
//		System.out.print(e5.toString());
//		
//		Employee e6 = new Employee("Billy", 10.0);
//		
//		e6.setHours(0, 10);
//		e6.setHours(1, 10);
//		e6.setHours(2, 10);
//		e6.setHours(3, 10);
//		e6.setHours(4, 10);
//		e6.setHours(5, 12);
//		e6.setHours(6, 12);
//		
//		System.out.print(e6.toString());
//		
//		System.out.print("\n\nStart of a new week\n\n");
//		
//		e1.newWeek();
//		System.out.print(e1.toString());
//
//	}
//}