import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bro extends Actor
{
    boolean watching = true;
    public Bro(){
        setImage("beardBro2.png");
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            watching = !watching;
            if(watching)
                setImage("beardBro2.png");
            else
                setImage("beardBro.png");
        }
    }    
}
