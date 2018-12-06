import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends Actor
{
    private boolean firstAct = true;
    private int nummer;
    public EndScreen(int nummer) {
        this.nummer = nummer;
        if(nummer == 1) {
        setImage("EndScreen.png");
    }
    else{
        GreenfootImage image = new GreenfootImage(Integer.toString(Hero.score), 30, Color.GREEN,null);
            setImage(image);
    }
    }
    /**
     * Act - do whatever the EndScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstAct) {
        firstAct = false;
        getWorld().addObject(new EndScreen(2),320,385);
    }
    if(Greenfoot.isKeyDown("enter")) {
        Greenfoot.setWorld(new Menu());
        getWorld().removeObject(this);
    }
    }    
}
