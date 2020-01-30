package prob2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobManager {

	private Queue<Job> jobs = new PriorityQueue<>();
	private boolean isPriority;
	private PriorityComparator priComp = new PriorityComparator();
	private SecurityComparator secComp = new SecurityComparator();
	
	public JobManager(boolean isPriority) {
		setPriority(isPriority);
	}
	
	public void offer(Job job) {
		jobs.offer(job);
	}
	
	public Job peak() {
		return jobs.peek();
	}
	
	public Job poll() {
		return jobs.poll();
	}
	
	public void setPriority(boolean isPriority){
		ArrayList<Job> jobsAL = flush();
		this.isPriority = isPriority;
		
		if(isPriority) {
			jobs = new PriorityQueue<Job>(priComp);
			for(Job job: jobsAL) {
				offer(job);
			}
		}	
		else
			jobs = new PriorityQueue<Job>(secComp);
		for(Job job: jobsAL) {
			offer(job);
		}
	}
	
	public boolean getPriority() {
		return isPriority;
	}
	
	public boolean isEmpty() {
		if(jobs.size() == 0)
			return true;
		else 
			return false;
	}
	
	public ArrayList<Job> flush(){
		ArrayList<Job> jobsAL = new ArrayList<>();
		
		while(jobs.size() > 0) {
			Job job = poll();
			jobsAL.add(job);

		}
		return jobsAL;
	}
}
