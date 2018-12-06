import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MenuFinished here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuFinished extends Hud
{
    public MenuFinished() {
        setImage("Finished.png");
        getImage().scale(60,60);
    }
    /**
     * Act - do whatever the MenuFinished wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMouse();
    }
    public void checkMouse() {
        List <MenuTiles> menutiles = getIntersectingObjects(MenuTiles.class);
        
        if(Greenfoot.mouseClicked(this)) {
            menutiles.get(0).worldSelector();
        }
    }
}
