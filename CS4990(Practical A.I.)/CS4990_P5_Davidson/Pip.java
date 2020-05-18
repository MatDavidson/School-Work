import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pip extends Actor
{
    ShyGuy shy;
    int type;
    public Pip(ShyGuy s, int t){
        setImage("pip.png");
        type = t;
        shy = s;
    }
    public void act() 
    {
        if(type == 0)
            setLocation(this.getX(), 340 - (int)(shy.confidence * 250));
        else
            setLocation(this.getX(), 340 - (int)(shy.beverage * 250));
    }    
}
