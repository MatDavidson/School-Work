import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node extends Actor{
    String[] path = {"floor.png", "block.png", "box.png", "empty.png"};
    int y, x, value, heuristic, steps, cost;
    boolean hasCoin, rigid; 
    Node parent;
    Link link;
    
    public Node(int type, int y, int x, Link l) {
        this.y = y;
        this.x = x;
        link = l;
        
        switch(type) {
        case 0:
            hasCoin = false;
            rigid = true;
            value = 0;
            break;
        case 1:
            hasCoin = false;
            rigid = true;
            value = 1;
            break;
        case 2:
            hasCoin = true;
            rigid = true;
            value = 2;
            break;
        case 3:
            hasCoin = false;
            rigid = false;
            value = 0;
            break;      
        }
        setImage(path[value]);
    }   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            if(hasCoin){
                System.out.println("\n*****************************************");
                System.out.println("Target: " + this.toString());
                link.target = this;
                link.buildPath();
            }    
        }   
    }
    
    void flip() {
        if(rigid)
            return;
        
        if(value == 0)
            value = 1;
        else if (value == 1)
            value = 0;
        
        setImage(path[value]);
    }
    void setHeur(){
        int dx = getDiff(this.x, link.target.x);
        int dy = getDiff(this.y, link.target.y);
        
        int less;
        
        if(dx < dy)
            less = dx;
        else
            less = dy;
             
        int heur = getDiff(dy, dx) + less;
        this.heuristic = heur;
    }
    void setSteps(){
        int s = getDiff(this.x, link.x) + getDiff(this.y, link.y);
        this.steps = s;
    }
    void setCost(){
        this.setHeur();
        this.setSteps();
        this.cost = this.heuristic + this.steps;
    }
    int getDiff(int a, int b){
        if(a > b)
            return a-b;
        else
            return b-a;
    }
    public String toString(){
        String s = "Node(" + x + "," + y + ")";
        return s;
    }
    void plunder(){
        this.hasCoin = false;
        this.value = 0;
        setImage(path[3]);
        link.temple.flipGates();
    }
}
