package aStar;

import java.util.ArrayList;

public class AStar {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int[][] map = generateMap();
		Node[][] nodes = new Node[15][15];
		ArrayList<Node> gates = new ArrayList<Node>();
		
		System.out.println("Generating nodes...");
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				Node n = new Node(map[i][j]);
				if(map[i][j] == 3) {
					gates.add(n);
				}
				nodes[i][j] = n;
				System.out.print(n.value + " ");
			}
			System.out.println();
		}
		
		for(Node n: gates) {
			n.flip();
		}
		System.out.println("Generating nodes...");
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				System.out.print(nodes[i][j].value + " ");
			}
			System.out.println();
		}
	}
	
	static int[][] generateMap(){
		int[][] map = new int[15][15];
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				map[i][j] = 0;
			}
		}
		
		for (int i = 1; i< 14; i++) {
			for(int j = 1; j < 14; j++) {
				map[i][j] = 1; 
				if((i-1) % 4 != 0)
					j+=3;
			}
		}
		
		for (int i = 3; i< 12; i+=4) {
			for(int j = 3; j < 12; j+=4) {
				map[i][j] = 2; 
			}
		}
		
		for (int i = 1; i< 14; i+=2) {
			for(int j = 3; j < 14; j+=4) {
				map[i][j] = 3; 
				map[j][i] = 3;
			}
		}
		
		for (int i = 3; i< 12; i+=4) {
			for(int j = 3; j < 12; j+=4) {
				map[i][j] = 2; 
			}
		}
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		return map;
	}
}

class Node{
	Node[] neighbors = new Node[4];
	boolean hasCoin;
	boolean rigid;
	boolean closed; 
	int value;
	
	public Node(int type) {
		switch(type) {
		case 0:
			hasCoin = false;
			rigid = false;
			closed = false;
			value = 0;
			break;
		case 1:
			hasCoin = false;
			rigid = true;
			closed = true;
			value = 1;
			break;
		case 2:
			hasCoin = true;
			rigid = false;
			closed = false;
			value = 0;
			break;
		case 3:
			hasCoin = false;
			rigid = false;
			closed = false;
			value = 0;
			break;		
		}
	}
	
	void close() {
		closed = true;
	}
	void open() {
		closed = false;
	}
	void flip() {
		closed = !closed;
		if(value == 0)
			value = 1;
		else
			value = 0;
	}
}
















