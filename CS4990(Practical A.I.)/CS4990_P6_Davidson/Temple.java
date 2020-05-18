import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Temple extends World{
    Node[][] nodes = new Node[15][15];
    ArrayList<Node> gates;
    int[][] map;
    int delay = 15;
    Link link;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Temple()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        link = new Link(this);
        map = generateMap();
        gates = new ArrayList<Node>();
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                Node n = new Node(map[i][j], i, j, link);
                if(map[i][j] == 3) {
                    gates.add(n);
                }
                nodes[i][j] = n;
                addObject(n, i*40 + 20, j*40 + 20);
            }
        }
        link.drop();
        setGates();
    }
        
    int[][] generateMap(){
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
        
        return map;
    }
    
    void setGates(){
        nodes[3][1].flip();
        nodes[11][1].flip();
        nodes[9][3].flip();
        nodes[3][5].flip();
        nodes[7][5].flip();
        nodes[5][7].flip();
        nodes[13][7].flip();
        nodes[11][9].flip();
        nodes[1][11].flip();
        nodes[5][11].flip();
        nodes[9][11].flip();
    } 
    void flipGates(){
        for(Node n: gates){
            n.flip();
        }   
    }
    void orphan(){
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                nodes[i][j].parent = null;
            }
        }
    }
}