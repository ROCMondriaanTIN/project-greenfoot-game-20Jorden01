import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Tile
{
    private String button;
    public int buttonNumber;
    public boolean buttonPressed;
    public String color;
    public Button(String image,int width,int heigth) {
        super(image,width,heigth);
        int begin = 6;
        int end = image.indexOf(".");
        color = image.substring(begin,end);
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkHero();
    }
    public void checkHero(){
        if(isTouching(Hero.class)) {
            button = "true";
            setImage("button" + color + "_pressed.png");
            buttonPressed = true;
            for(int i = 0; i < 100; i ++) {
                
            }
        }
        else {            
            button = "false";
            setImage("button" + color + ".png");
            buttonPressed = false;
        }
    }
    public String checkButtonColor() {
        return color;
    }
}
