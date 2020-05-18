import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShyGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShyGuy extends Actor
{
    int delay = 10;
    int netDelay = 60;
    int dance = 1;
    int[] input;
    Net net;
    double confidence = 1;
    double beverage = 0;
    World world;
    Bro bro;
    public ShyGuy(World w, Bro b){
        setImage("shyGuyIdle.png");
        world = w;
        bro = b;
        input = new int[] {0,0};
        net = new Net(input, this);
        net.act();
    }
    public void act() 
    {
        
        if(confidence < 0.5)
            setImage("shyGuyIdle.png");
        if(confidence > 0.5){
            if(delay > 0){
                    delay--;
                    
            }
            else{
                
                    setImage("shyGuyD" + dance + ".png");
                    
                    delay = 10;
                    dance += 1;
                    if(dance > 4)
                        dance = 1;
                
            }
        }
        if(netDelay > 0){
            netDelay -= 1;          
            if(beverage > 0)
                beverage -= 0.001;
        }
        else{
            setInput();
            net.updateInput(input);
            net.training();
            net.testing(net.training);
            netDelay = 60;
        }
    } 
    public void giveBeverage(){
        beverage += .5;
        if(beverage > 1)
            beverage = 1;
    }
    public void setInput(){
        if(bro.watching)
            input[0] = 0;
        else
            input[0] = 1;
            
        input[1] = (int)Math.round(beverage);
            
    }
}
