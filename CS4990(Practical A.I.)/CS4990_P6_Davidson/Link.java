import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class f here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Link extends Actor{
    int delay = 15;
    Temple temple;
    int x, y;
    Node target, current;
    ArrayList<Node> path = new ArrayList<Node>();
    ArrayList<Node> openList = new ArrayList<Node>();
    ArrayList<Node> closedList = new ArrayList<Node>();
    
    public Link(Temple t){
        temple = t;
        this.setImage("link.png");
    }
    
    //add link to the world
    public void drop(){
        int side = (int)(Math.random() * 4);
        int space = (int)(Math.random() * 15);
        
        switch(side){
            case 0: 
                x = 0; 
                y = space;
                break;
            case 1: 
                x = 14; 
                y = space;
                break;
            case 2: 
                x = space; 
                y = 0;
                break;
            case 3: 
                x = space; 
                y = 14;
                break;
        }
        temple.addObject(this, y * 40 + 20, x * 40 + 20);
    }
    
    public void buildPath() 
    {
        openList.clear();
        closedList.clear();
        path.clear();
        
        openList.add(temple.nodes[this.y][this.x]);
        temple.nodes[this.y][this.x].setCost();
        current = openList.get(0);
        
        while(!openList.isEmpty()){
            System.out.println("\nCurrent: " + current + ", Cost - " + current.cost);
            
            if(current == target){
                fillPath();
                System.out.println("Target " + current.toString() + " found");
                temple.orphan();
                
                break;
            }
            
            closedList.add(current);
            openList.remove(current);
            System.out.println(current.toString() + " closed...");
            checkNeighbors();
            
            current = getLeast();
        }
        act();
    }
    public Node getLeast(){
        Node closest = openList.get(0);
        int smallest = closest.cost;
        
        for(Node n : openList){
            n.setCost();
            int nc = n.cost;
            
            if(nc < smallest){
                smallest = nc;
                closest = n;
            }
        }
        return closest;
    }
    void checkNeighbors(){
        for(int i = current.x-1; i < current.x+2; i++){
            for(int j = current.y-1; j < current.y+2; j++){
                
                System.out.print("Node[" + j + "][" + i + "] - ");
                if(i < 0 || i > 14 || j < 0 || j > 14){
                    System.out.println("Out of bounds");
                    continue;
                }
                
                if(temple.nodes[j][i].value == 1){
                    System.out.println("Wall");
                    continue;
                }
                if(closedList.contains(temple.nodes[j][i])){
                    System.out.println("Already closed...");
                    continue;
                }
                if(openList.contains(temple.nodes[j][i])){
                    System.out.println("Already opened...");
                    continue;
                }
                if(temple.nodes[j][i].parent == null)
                    temple.nodes[j][i].parent = current;
                openList.add(temple.nodes[j][i]);
                temple.nodes[j][i].setCost();
                if(i-x != 0 || j-y != 0)
                    temple.nodes[j][i].cost += 1;
                System.out.println("Opened, Cost - " + temple.nodes[j][i].cost);
            }
        }
    }
    public void act(){
        if(delay > 0){
                delay--;
        }
        else{
            if(path.size()>0){
                Node n = path.get(path.size()-1);
                path.remove(path.size()-1);
                move(n);
                delay = 20;
            }
        }    
        
    }
    void fillPath(){
        path.add(current);
        
        Node back = current.parent;
        Node home = temple.nodes[this.x][this.y];
        while(back.parent != null){
            path.add(back);
            back = back.parent;
        }  
    }
    public void move(Node n){
        this.x = n.x;
        this.y = n.y;
        setLocation(y* 40 + 20, x* 40 + 20);
        if(n == current)
            current.plunder();
    }
    
}
