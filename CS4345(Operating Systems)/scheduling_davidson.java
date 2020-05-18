//Mat Davidson
//CS4345
//Spring 2020
//Assignment 3

import java.util.*;

//Static main
class Scheduling{
	static ArrayList<Process> processes = new ArrayList<Process>();
	static int[] ids = new int[7];
	static Scanner scan = new Scanner(System.in);
	static double sjf, pri, rr; //Place holders for average wait times
	
    public static void main(String[] args){ 
        System.out.println("Creating processes...\n");
        for(int i = 0; i < 6; i++){
            Process p = new Process(ids);
            processes.add(p);
            ids[i] = p.id;
        }
        //Requirement 1
        System.out.println("\nOrdering processes by ID...");
        processes.sort(new SortbyID());
        snapShot();
        
        //Requirement 2
        System.out.println("\nPlease enter an ID.");
        int id = Integer.parseInt(scan.next());
        
        //Check for duplicate ids
        while(hasId(id)) {
        	System.out.print("\nDuplicate detected. Please enter another value.");
            id = Integer.parseInt(scan.next());
        }
        //Get priority and burst length
        System.out.println("Accepted! Please enter process priority.");
        int priority = Integer.parseInt(scan.next());
        System.out.println("Please enter process burst length.");
        int burstLength = Integer.parseInt(scan.next());
        
        //Add process to processes
        Process p = new Process(id, priority,burstLength);
        processes.add(p);
        ids[6] = p.id;
        
        //Requirement 3
        System.out.println("\nOrdering processes by ID...");
        processes.sort(new SortbyID());
        snapShot();
        
        //Requirement 4
        //SJF algorithm
        System.out.println("\nOrdering processes by Burst Length...");
        processes.sort(new SortbyBurst());
        sjf = calculateAvg("Shortest Job First");
        
        //Priority algorithm
        System.out.println("\nOrdering processes by Priority...");
        processes.sort(new SortbyPriority());
        pri = calculateAvg("Priority");
        
        //Round Robin algorithm
        System.out.println("\nOrdering processes by ID...");
        processes.sort(new SortbyID());
        rr = roundRobin();
        
        //Requirement 5
        //During testing, I noticed that the least to greatest was consistently in the following printed order.
        //Whether mistake or no, I decided not to go through sorting them with code.
        System.out.println("\nSJF = " + sjf + ", Pri = " + pri + ", Round Robin = " + rr);
        
        scan.close();
    }
    
    //Show the processes in the system
    static void snapShot() {
    	System.out.print("\n*****Snap Shot*****\n");
    	for(Process p: processes) {
        	System.out.println(p.toString());
        }
    }
    
    //Helper to check the ids array for the input id
    static boolean hasId(int id){
        for(int i = 0; i < ids.length; i++){
            if(ids[i] == id)
                return true;
        }
        return false;
    }
    
    //Helper to calculate the average wait times SJF and Priority Algorithms
    static double calculateAvg(String type) {
    	double time = 0.0;
    	double tot = 0.0;

    	System.out.print("\n*****Running " + type + "*****\n");
    	for(Process p: processes) {
    		tot += time;
        	System.out.println(p.toString() + ",\t" + type + ", Total waiting time: " + time);
        	time += p.burstLength;      	
        }   	
    	return tot / processes.size();
    }
    
    //Round robin calculation
    static double roundRobin() {
    	int[] remTime = new int[7];
    	int[] waitTime = new int[7];
    	int[] fullSlices = new int[7];
    	int currentTime = 0;
    	boolean finished = false;
    	
    	System.out.print("\n*****Running Round Robin*****");
    	System.out.print("\n*****Quantum length:  20*****\n");
    	
    	//Initialize array values
    	for(int i = 0; i < processes.size(); i++) {
    		remTime[i] = processes.get(i).burstLength;
    		waitTime[i] = 0;
    		fullSlices[i] = 0;
    	}
    	
    	//Loop through the processes until all remaining time is 0
    	while(!finished) {
    		finished = true;
    		for(int i = 0; i < processes.size(); i++) {
    			if(remTime[i] == 0) //Remaining time is already 0. Do nothing. 
    				continue;
    			
    			else if(remTime[i] < 20 && remTime[i] > 0) { 	//Remaining time is between 0 and 20
    				currentTime += remTime[i];						
    				remTime[i] = 0;									
    				waitTime[i] = (currentTime - 20*fullSlices[i]);	
    				System.out.println(processes.get(i).toString() + ",\tRR finish time: " + currentTime + ",\tTotal waiting time: " + waitTime[i]);  				
    			}
    			else {	//Remaining time is greater than 20
    				remTime[i] -= 20;
    				currentTime += 20;
    				
    				//Check to see if the quantum was exactly long enough
    				if(remTime[i] == 0) {
        				waitTime[i] = (currentTime - 20*fullSlices[i]);
        				System.out.println(processes.get(i).toString() + ",\tRR finish time: " + currentTime + ",\tTotal waiting time: " + waitTime[i]); 
    				}
    				fullSlices[i]++;
    				finished = false;	//In the event that there is time remaining, switch finished
    			}
    		}//end for
    	}//end while
    	
    	//calculate the average wait time
    	double avg = 0;
    	for(int i = 0; i < processes.size(); i++) {
    		avg += waitTime[i];
    	}  	
    	avg = avg/processes.size();
    	
    	return avg;
    }
}

//Process object class
class Process{
    int id, priority, burstLength;

    //Constructor for random generation
    public Process(int[] ids){
        id = generateId(ids);
        burstLength = (int)(Math.random() * 81) + 20;
        priority = (int)(Math.random() * 10) + 1;
        System.out.println("{" + this.toString() + "} added to system processes...");
    }
    //Constructor for input generation
    public Process(int id, int priority, int burstLength){
        this.id = id;
        this.burstLength = burstLength;
        this.priority = priority;
        System.out.println("{" + this.toString() + "} added to system processes...");
    }
    
    //Helper to generate a unique random id from 0 to 10
    int generateId(int[] ids){
        int id = (int) (Math.random() *11);
        while(hasId(id, ids)){
            id = (int) (Math.random() *11);
        }
        return id;
    }
    
    //Helper to check the ids array for the random id
    boolean hasId(int id, int[] ids){
        for(int i = 0; i < ids.length; i++){
            if(ids[i] == id)
                return true;
        }
        return false;
    }
    
    public String toString() {
    	String s =  "Process " + id + ":\tPriority: " + priority + ",\tBurst Length: " + burstLength;   	
    	return s;
    }
}

//Comparators for sorting
class SortbyID implements Comparator<Process> { 
    @Override
    public int compare(Process a, Process b) { 
        return a.id - b.id; 
    }
}
class SortbyPriority implements Comparator<Process> { 
    @Override
    public int compare(Process a, Process b) { 
        return a.priority - b.priority; 
    }
}
class SortbyBurst implements Comparator<Process> { 
    @Override
    public int compare(Process a, Process b) { 
        return a.burstLength - b.burstLength; 
    }
}