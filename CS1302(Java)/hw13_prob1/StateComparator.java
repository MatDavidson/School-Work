package prob1;

import java.util.Comparator;

public class StateComparator implements Comparator<Airport>{

	@Override
	public int compare(Airport arg0, Airport arg1) {
		String state1 = arg0.getState();
		String state2 = arg1.getState();
		
		if(state1.compareTo(state2) != 0)
			return state1.compareTo(state2);
		else {
			String city1 = arg0.getCity();
			String city2 = arg1.getCity();
			
			return city1.compareTo(city2);
		}
			
	}

}
