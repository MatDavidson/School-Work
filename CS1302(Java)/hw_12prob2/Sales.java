package prob2;

public class Sales {
	private int id, week;
	private double sales;
	
	public Sales(int id, double sales, int week) {
		this.id = id;
		this.sales  = sales;
		this.week = week;
	}
	
	public int getId() {
		return id;
	}
	
	public double getSales() {
		return sales;
	}
	
	public int getWeek() {
		return week;
	}
	
	public String toString() {
		String s = String.format("sales=%.2f, id=%d, week=%d", getSales(), getId(), getWeek());
		
		return s;
	}
}
