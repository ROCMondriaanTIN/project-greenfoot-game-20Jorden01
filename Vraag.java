import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vraag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vraag extends Hud
{
    private boolean firstAct = true;
    static String vraag;
    /**
     * Act - do whatever the Vraag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstAct) {
            firstAct = false;
            //setImage("invisible.png");
            //getImage().drawString("Dit is een vraag:",getX(),getY());
            //getWorld().showText("\u87CEEB Dit is een vraag.",getX(),getY());
            GreenfootImage image = new GreenfootImage(vraag, 30, Color.BLUE,null);
            setImage(image);
        }
    }    
}
