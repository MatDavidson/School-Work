package prob2;

import java.util.Comparator;

public class SecurityComparator implements Comparator<Job>{

	@Override
	public int compare(Job arg0, Job arg1) {
		int diff = arg0.getSecurityLevel() - arg1.getSecurityLevel();

		if(diff > 0)
			return -1;
		else if(diff < 0)
			return 1;
		else { 
			diff = arg0.getPriority() - arg1.getPriority();
			
			if(diff > 0)
				return -1;
			else if(diff < 0)
				return 1;
			else 
				return 0;
		}
	}
	
}
