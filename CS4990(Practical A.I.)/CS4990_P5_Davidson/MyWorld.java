import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    ShyGuy shy;
    Bro bro;
    Meter meter;
    Meter bMeter;
    Pip pip;
    Pip bPip;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(new GreenfootImage("club.jpg"));
        bro = new Bro();
        addObject(bro, 450, 275);
        shy = new ShyGuy(this, bro);
        addObject(shy, 250, 330);
        shy.act();
        meter = new Meter();
        addObject(meter, 40, 200);
        pip = new Pip(shy, 0);
        addObject(pip, 41, 340);
        pip.act();
        bMeter = new Meter();
        bMeter.setImage("bMeter.png");
        addObject(bMeter, 130, 200);
        bPip = new Pip(shy, 1);
        addObject(bPip, 131, 340);
        pip.act();
        addObject(new Shot(shy), 500, 100);
    }
}
