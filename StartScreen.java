import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{ 
    private boolean activated;
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        super(600, 600,1);
        this.setBackground("StartScreen.png");
        Hero.totalScore = 0;
        Hero.levelsFinished = 0;
    }
    @Override
    public void act() {
        if(Greenfoot.isKeyDown("Space") && !activated) {
            activated = true;
            Greenfoot.setWorld(new Menu());
        }
    }
}
