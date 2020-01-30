package prob1;

import java.util.ArrayList;

public class GenericMartianManager<E> {

	private ArrayList<E> martians = new ArrayList<E>();
	
	public boolean addMartian(E m) {
		if( !martians.contains(m)) {
			martians.add(m);
			return true;
		}
		else
			return false;
	}
	
	public int getNumMartians() {
		return martians.size();
	}
	
	public E getMartian(E m){
		if(martians.contains(m)) {
			int i = martians.indexOf(m);
			return martians.get(i);
		}
		else
			return null;
	}
	
	public void mergeMartians(ArrayList<? extends E> marts) {
		for(E m: marts) {
			martians.add(m);
		}
	}
	
	public boolean removeMartian(E m) {
		if(martians.contains(m)) {
			int i = martians.indexOf(m);
			martians.remove(i);
			return true;
		}
		else
			return false;
	}
}
