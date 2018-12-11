
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MenuTiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuTiles extends Tile
{
    private int buttonInt = 0;
    private String button;
    public static int nummer;
    private int nummer2;
    private boolean activated;
    public MenuTiles(String image,int width,int heigth) {
        super(image,width,heigth);
        int end = image.indexOf(".");
        int begin = image.indexOf("_") + 1;
        button = image.substring(begin,end);        
        if(image != "ComingSoon.png") {
            buttonInt = Integer.parseInt(button);
            nummer2 = nummer;
            nummer ++;
        }
        else{
            nummer2 = -1;
        }
    }

    /**
     * Act - do whatever the MenuTiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        finishedLevels();
    }

    public void worldSelector(){
        switch(button) {
            case "1":
            Greenfoot.setWorld(new TutorialLevel());
            break;
            case "2":
            if(Hero.levelsFinished > 0) {
                Greenfoot.setWorld(new Map1());
            }
            break;
            case "3":
            if(Hero.levelsFinished > 1) {
                Greenfoot.setWorld(new Map2());
            }
            break;
            case "4":
            if(Hero.levelsFinished > 2) {
                Greenfoot.setWorld(new Map3());
            }
            break;
            case "5":
            if(Hero.levelsFinished > 3) {
                Greenfoot.setWorld(new Map4());
            }
            case "11":
            Greenfoot.setWorld(new StartScreen());
            break;   
        }
    }

    public void finishedLevels() {
        if((Hero.levelsFinished >= nummer2 && !activated && nummer2 >= 0) || buttonInt >= 10) {
            getWorld().addObject(new MenuFinished(),x,y);
            activated = true;
        }
    }

}
