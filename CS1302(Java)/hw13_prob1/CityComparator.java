package prob1;

import java.util.Comparator;

public class CityComparator implements Comparator<Airport>{

	@Override
	public int compare(Airport arg0, Airport arg1) {
		String city1 = arg0.getCity();
		String city2 = arg1.getCity();

		if(city1.compareTo(city2) != 0)
			return city1.compareTo(city2);
		else {
			String state1 = arg0.getState();
			String state2 = arg1.getState();
			
			return state1.compareTo(state2);
		}
	}

}
