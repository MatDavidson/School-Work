package prob3;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Player>{

	@Override
	public int compare(Player arg0, Player arg1) {
		if(arg0.getScore() > arg1.getScore())
			return 1;
		else if(arg0.getScore() < arg1.getScore())
			return -1;
		else {
			String name1 = arg0.getName();
			String name2 = arg1.getName();
			return name1.compareTo(name2);
		}	
	}

}
