import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Tile
{
    boolean iets;
    public Door(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    /**
     * Act - do whatever the door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
            checkButton();
            if (iets) {
               setImage("door_openMid.png");
            }
            else {
               setImage("door_closedMid.png");
            }
    }
    public void checkButton() {
       List <Button> button = getWorld().getObjects(Button.class);
       iets = button.get(1).buttonPressed;
    }
}
