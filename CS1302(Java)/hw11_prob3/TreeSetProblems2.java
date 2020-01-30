package prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetProblems2 {
	public static List<Player> players1 = new ArrayList<>(Arrays.asList(new Player("Ace", 99), new Player("Walt", 99), new Player("Bob", 38), new Player("Casey", 66), new Player("Dallas", 44), new Player("Ellen", 108), new Player("Fran", 12)));
	public static TreeSet<Player> players2 = new TreeSet<>(new ScoreComparator());
	
 	public static void main(String[] args) {
		for(Player p: players1) {
			System.out.println(p.toString());
		}
		System.out.println("\n");
		
		TreeSet<Player> pTree = highRollers(players1, 50);
		Iterator<Player> iter = pTree.iterator();
		
		while(iter.hasNext()) {
			Player p = iter.next();
			System.out.println(p.toString());
		}
		System.out.println("\n");
		
		TreeSet<Player> players2 = new TreeSet<>(new ScoreComparator());
		players2.add(new Player("Ace", 99));
		players2.add(new Player("Walt", 99));
		players2.add(new Player("Bob", 38));
		players2.add(new Player("Casey", 66));
		players2.add(new Player("Dallas", 44));
		players2.add(new Player("Ellen", 108));
		players2.add(new Player("Fran", 12));
		
		pTree = dividePlayers(players2, 50);
		iter = pTree.iterator();
		
		while(iter.hasNext()) {
			Player p = iter.next();
			System.out.println(p.toString());
		}
		
		System.out.println("\n");
		
		pTree = players2;
		iter = pTree.iterator();

		while(iter.hasNext()) {
			Player p = iter.next();
			System.out.println(p.toString());
		}
		
		System.out.println("\n" + getScores(highRollers(players1, 0)));
	}
	
	public static TreeSet<Player> highRollers(List<Player> players, int score){
		Player p = new Player("", score);
		TreeSet<Player> result = new TreeSet<>(new ScoreComparator());
		
		result.addAll(players);
		
		result = (TreeSet<Player>) result.tailSet(p);
			
		return result;
	}
	
	public static TreeSet<Player> dividePlayers(TreeSet<Player> players, int thold){
		Player p = new Player("", thold);
		TreeSet<Player> result = new TreeSet<>(new ScoreComparator());
		
		result.addAll(players);
		
		result = (TreeSet<Player>) result.headSet(p);
		
		for(Player pl: result) {
			players.remove(pl);
		}

		return result;
	}
	
	public static List<Integer> getScores(TreeSet<Player> players){
		List<Integer> scores = new ArrayList<>();
		
		for(Player p: players) {
			scores.add(p.getScore());
		}
		
		return scores;
	}
}
