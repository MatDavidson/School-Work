package prob2;

import java.util.Comparator;

public class SalesComparator implements Comparator<Sales>{

	@Override
	public int compare(Sales arg0, Sales arg1) {
		if(arg0.getSales() > arg1.getSales())
			return 1;
		else if(arg0.getSales() < arg1.getSales())
			return -1;
		else {
			if(arg0.getId() > arg1.getId())
				return 1;
			else if(arg0.getId() < arg1.getId())
				return -1;
			else {
				if(arg0.getWeek() > arg1.getWeek())
					return 1;
				else if(arg0.getWeek() < arg1.getWeek())
					return -1;
				else 
					return 0;
			}
		}
	}

}
