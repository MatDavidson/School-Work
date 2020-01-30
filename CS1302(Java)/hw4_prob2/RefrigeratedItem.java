package prob2;

public class RefrigeratedItem extends Item {

	protected double temp = 0.0;
	
	public RefrigeratedItem() {
		super("Noname", 0.0);
		temp = 70.0;
	}
	
	public RefrigeratedItem( String name, double weight, double temp) {
		super(name, weight);
		this.temp = temp;
	}
	
	public RefrigeratedItem(Item item, double temp) {
		super(item.name, item.weight);
		this.temp = temp;
	}
	
	public double cost() {
		return super.cost() + (100 - temp)*0.1;
	}
	
	public double getTemp() {
		return temp;
	}
	
	public String toString() {
		String result = String.format("name=%s, cost=$%,.2f, weight=%.2f, temp=%.2f", name, cost(), weight, temp);
		return result;
	}
}
