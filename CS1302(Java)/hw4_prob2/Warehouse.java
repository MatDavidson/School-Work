package prob2;

import java.util.ArrayList;

public class Warehouse {

	protected ArrayList<Item> items = new ArrayList<Item>();
	
	public Warehouse() {
		
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public Item getItem(Item item){
		if(items.contains(item)) {
			int i = items.indexOf(item);
			return items.get(i);
		}
		else
			return null;
	}

	public Item getItem(String name) {
		Item item = new Item(name, 0.0);
		return getItem(item);
	}
	
	public int getNumItems() {
		return items.size();
	}
	
	public ArrayList<RefrigeratedItem> getRefrigeratedItems() {
		ArrayList<RefrigeratedItem> refItems = new ArrayList<RefrigeratedItem>();
		
		for(Item i: items) {
			if( i instanceof RefrigeratedItem) {
				refItems.add((RefrigeratedItem)i);
			}	
		}
		return refItems;
	}
	
	public double getTotalCost() {
		double cost = 0.0;
		
		for(Item i: items) {
			cost += i.cost();
		}
		return cost;
	}
	
	public double getTotalCostRefrigerated() {
		double cost = 0.0;
		
		for(RefrigeratedItem r: getRefrigeratedItems()) {
			cost += r.cost();
		}
		return cost;
	}
	
	public Item removeItem(Item item) {
		if( items.contains(item)) {
			items.remove(items.indexOf(item));
			return item;
		}
		else
			return null;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		for( Item i: items) {
			result.append("\n" + i.toString());
		}
		return result.toString();
	}
}
