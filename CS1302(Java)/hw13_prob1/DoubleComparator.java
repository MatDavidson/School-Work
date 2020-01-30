package prob1;

import java.util.Comparator;

public class DoubleComparator implements Comparator<Double>{

	@Override
	public int compare(Double arg0, Double arg1) {
		if(arg0 > arg1)
			return 1;
		else if(arg0 < arg1)
			return -1;
		else
			return 0;
	}

}
