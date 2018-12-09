import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Hud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hud extends Actor
{
    boolean firstAct = true;
    public String getal;
    public char getal2 = '0';
    public Hud() {
        setImage("invisible.png");
    }

    /**
     * Act - do whatever the Hud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstAct) {
            firstAct = false;
            for(int i = 0; i < 3; i ++) {
                getWorld().addObject(new Heart("hud_heartFull.png"),i * 55 + 27,27);
            }
            for(int i = 0; i < 4; i ++) {
                getWorld().addObject(new Score(),i * 30 + 490,25);
            }
            for(int i = 0; i < 3; i ++) {
                getWorld().addObject(new Timer(),i * 20 + 280,25);
            }
            getWorld().addObject(new Vraag(),300,580);
            getWorld().addObject(new HeroLetter(),20,70);
        }
    }

}
