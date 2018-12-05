import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuTiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuTiles extends Tile
{
    private String button;
    public MenuTiles(String image,int width,int heigth) {
        super(image,width,heigth);
        int end = image.indexOf(".");
        int begin = image.indexOf("_") + 1;
        button = image.substring(begin,end);
    }
    /**
     * Act - do whatever the MenuTiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            worldSelector();
        }
    }
    public void worldSelector(){
        switch(button) {
            case "1":
            Greenfoot.setWorld(new TutorialLevel());
            break;
            case "2":
            Greenfoot.setWorld(new Map1());
            break;
            case "3":
            Greenfoot.setWorld(new Map2());
            break;
            case "4":
            Greenfoot.setWorld(new TutorialLevel());
            break;
            case "5":
            Greenfoot.setWorld(new TutorialLevel());
            break;
            
            
            
        }
    }
}
