package prob2;

import java.util.ArrayList;

public class JobManagerTester {
	public static ArrayList<Job> jobs = new ArrayList<>();
	
	public static void main(String[] args) {
		JobManager jm = new JobManager(true);
		
		System.out.print("*****Test 1*****");
		System.out.println("\nA new job manager object has been created.");
		System.out.println("jobs priority: " + jm.getPriority());
		
		jm.offer(new Job(1, 20));
		System.out.println("\nJob(1, 20) has been added");		
		jm.offer(new Job(3, 20));
		System.out.println("Job(3, 20) has been added");
		jm.offer(new Job(5, 20));
		System.out.println("Job(5, 20) has been added");
		jm.offer(new Job(4, 20));
		System.out.println("Job(4, 20) has been added");
		jm.offer(new Job(2, 20));
		System.out.println("Job(2, 20) has been added");
		
		System.out.println("\nExpected order: J(5,20), J(4,20), J(3,20), J(2,20), J(1,20)");
		System.out.print("\nJobs actual order: "); 
		
		jobs = jm.flush();
		for(Job job: jobs) {
			System.out.print(job.toString() + ", ");
		}
		
		System.out.print("\n*****Test 2*****");
		jobs.clear();
		System.out.println("\nIs jobs empty? :" + jm.isEmpty());
		jm.setPriority(false);
		System.out.println("\nThe priority has been changed to False.");
		System.out.println("jobs priority: " + jm.getPriority());
		
		jm.offer(new Job(10, 10));
		System.out.println("\nJob(10, 10) has been added");		
		jm.offer(new Job(10, 7));
		System.out.println("Job(10, 7) has been added");
		jm.offer(new Job(10, 6));
		System.out.println("Job(10, 6) has been added");
		jm.offer(new Job(10, 9));
		System.out.println("Job(10, 9) has been added");
		jm.offer(new Job(10, 8));
		System.out.println("Job(10, 8) has been added");
		
		System.out.println("\nExpected order: J(10,10), J(10,9), J(10,8), J(10,7), J(10,6)");
		System.out.print("\nJobs actual order: "); 
		
		jobs = jm.flush();
		for(Job job: jobs) {
			System.out.print(job.toString() + ", ");
		}
		
		System.out.print("\n*****Test 3*****");
		jobs.clear();
		System.out.println("\nIs jobs empty? :" + jm.isEmpty());
		jm.setPriority(true);
		System.out.println("\nThe priority has been changed to True. \nSorting based on priority while priorty is all the same.");
		System.out.println("jobs priority: " + jm.getPriority());
		
		jm.offer(new Job(10, 10));
		System.out.println("\nJob(10, 10) has been added");		
		jm.offer(new Job(10, 7));
		System.out.println("Job(10, 7) has been added");
		jm.offer(new Job(10, 6));
		System.out.println("Job(10, 6) has been added");
		jm.offer(new Job(10, 9));
		System.out.println("Job(10, 9) has been added");
		jm.offer(new Job(10, 8));
		System.out.println("Job(10, 8) has been added");
		
		System.out.println("\nExpected order: J(10,10), J(10,9), J(10,8), J(10,7), J(10,6)");
		System.out.print("\nJobs actual order: "); 
		
		jobs = jm.flush();
		for(Job job: jobs) {
			System.out.print(job.toString() + ", ");
		}
		
		System.out.print("\n*****Test 4*****");
		jobs.clear();
		System.out.println("\nIs jobs empty? :" + jm.isEmpty());
		jm.setPriority(false);
		System.out.println("\nThe priority has been changed to False. \nSorting based on security while security is all the same.");
		System.out.println("jobs priority: " + jm.getPriority());
		
		jm.offer(new Job(1, 20));
		System.out.println("\nJob(1, 20) has been added");		
		jm.offer(new Job(3, 20));
		System.out.println("Job(3, 20) has been added");
		jm.offer(new Job(5, 20));
		System.out.println("Job(5, 20) has been added");
		jm.offer(new Job(4, 20));
		System.out.println("Job(4, 20) has been added");
		jm.offer(new Job(2, 20));
		System.out.println("Job(2, 20) has been added");
		
		System.out.println("\nExpected order: J(5,20), J(4,20), J(3,20), J(2,20), J(1,20)");
		System.out.print("\nJobs actual order: "); 
		
		jobs = jm.flush();
		for(Job job: jobs) {
			System.out.print(job.toString() + ", ");
		}
		
		System.out.print("\n*****Test 5*****");
		jobs.clear();
		System.out.println("\nIs jobs empty? :" + jm.isEmpty());

		System.out.println("\nTesting changing priority while the list is not empty.");
		System.out.println("jobs priority: " + jm.getPriority());
		
		jm.offer(new Job(1, 2));
		System.out.println("\nJob(1, 2) has been added");		
		jm.offer(new Job(2, 1));
		System.out.println("Job(2, 1) has been added");
		
		System.out.println("\nPeak expected result: J(1,2)");
		System.out.println("Peak actual reult: " + jm.peak());
		
		System.out.println("\nChanging Priority.");
		jm.setPriority(true);
		System.out.println("jobs priority: " + jm.getPriority());
		
		System.out.println("\nPeak expected result: J(2,1)");
		System.out.println("Peak actual reult: " + jm.peak());
	}
}
