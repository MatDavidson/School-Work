import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends Actor
{
    ShyGuy shy;
    public Shot(ShyGuy s){
        setImage("drink.png");
        shy = s;
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
            shy.giveBeverage();
    }    
}
