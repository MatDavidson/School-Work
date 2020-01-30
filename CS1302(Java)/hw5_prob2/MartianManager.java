package prob2;

import java.util.ArrayList;
import java.util.Collections;

public class MartianManager implements Cloneable {
	ArrayList<Martian> martians = new ArrayList<Martian>();
	ArrayList<Teleporter> teleporters = new ArrayList<Teleporter>();
	
	//MartianManager constructor
	public MartianManager() {
		
	}

	//Will add a martian to the martians list if it is not already in the list. Also adds it to the 
	//	teleporters list if it is a GreenMartian
	public boolean addMartian(Martian m) {
		if(!martians.contains(m)) {
			martians.add(m);
			if(m instanceof GreenMartian) {
				teleporters.add((Teleporter)m);
			}
			return true;
		}
		else
			return false;
	}
	
	public Object clone() throws CloneNotSupportedException {
		MartianManager clonedManager = (MartianManager)super.clone();
		ArrayList<Martian> clonedMartians = (ArrayList<Martian>)martians.clone();
		this.martians = clonedMartians;
		clonedManager.setMartians(clonedMartians);
		return clonedManager;
	}
	
	public void setMartians(ArrayList<Martian> martians) throws CloneNotSupportedException {
		for(int i = 0; i < martians.size(); i++) {
			Martian clonedMartian = (Martian)martians.get(i).clone();
			this.martians.set(i, clonedMartian);
		}
	}
	
	//Returns the Martian at i in martians or null if it is not present
	public Martian getMartianAt(int i) {
		if(i > martians.size() || i < 0) {
			return null;
		}
		else if(martians.get(i) != null) {
			return martians.get(i);
		}
		else
			return null;
	}
	
	public Martian getMartianClosestTo(int id) {
		Martian dummy = new GreenMartian(id);
		Martian closest = martians.get(0);
		int diff = 0;
		int leastDiff = 1000000;
		for(Martian m: martians) {
			if(m.getId() > dummy.getId()) {
				diff = m.getId() - dummy.getId();
			}
			else
				diff = dummy.getId() - m.getId();
		
			if(diff < leastDiff) {
				leastDiff = diff;
				closest = m;
			}
		}
		return closest;
	}
	
	public Martian getMartianWithId(int id) {
		RedMartian dummy = new RedMartian(id);
		if(martians.contains(dummy)) {
			int index = martians.indexOf(dummy);
			if(martians.get(index) != null) {
				return martians.get(index);
			}
			else
				return null;
		}
		else 
			return null;
		}
	
	//Returns the total number of Martians
	public int getNumMartians() {
		return martians.size();
	}
	
	//Returns the number of teleporters
	public int getNumTeleporters() {
		return teleporters.size();
	}
	
	public Teleporter getTeleporterAt(int i) {
		if(i > teleporters.size() || i < 0) {
			return null;
		}
		else if(teleporters.get(i) != null) {
			return teleporters.get(i);
		}
		else
			return null;
	}
	
	//Returns a String of the Martian objects in martians speaking
	public String groupSpeak() {
		StringBuilder s = new StringBuilder();
		for(Martian m: martians) {
			s.append("\n" + m.speak());
		}
		return s.toString();
	}
	
	//Returns a String of the Teleporters in telporters showing them teleporting to the destination
	public String groupTeleport(String dest) {
		StringBuilder s = new StringBuilder();
		for(Teleporter t: teleporters) {
			s.append("\n" + t.teleport(dest));
		}
		return s.toString();
	}
	
	public void obliterateTeleporters() {
		for(int i = teleporters.size()-1; i >= 0; i--) {
			Martian dummy = (Martian)teleporters.get(i);
			int index = martians.indexOf(dummy);
			martians.remove(index);
		}
		teleporters.clear();
	}
	
	public boolean removeMartian(int id) {
		Martian dummy = new GreenMartian(id);
		Martian target;
		int index = martians.indexOf(dummy);
		if(martians.get(index) != null) {
			target = martians.get(index);
			martians.remove(index);
			if(target instanceof Teleporter) {
				index = teleporters.indexOf((Teleporter)target);
				teleporters.remove(index);
			}
			return true;	
		}
		else
			return false;
	}
	
	public ArrayList<Martian> sortedMartians() throws CloneNotSupportedException{
		ArrayList<Martian> sortedMartians = (ArrayList<Martian>)martians.clone();
		Collections.sort(sortedMartians);
		return sortedMartians;
	}
}
