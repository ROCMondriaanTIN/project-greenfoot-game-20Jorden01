import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lock extends Tile
{
    public String color;
    public Lock(String image,int width,int heigth) {
        super(image,width,heigth);
        int end = image.indexOf(".");
        int begin = image.indexOf("_") + 1;
        color = image.substring(begin,end);
    }
    // lock_green.png
    /**
     * Act - do whatever the Lock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public String getLockColor() {
        return color;
    }
}
