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
    public Button(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkHero();
        getWorld().showText(button,500,100);
    }
    public void checkHero(){
        if(isTouching(Hero.class)) {
            button = "true";
            setImage("buttonBlue_pressed.png");
            buttonPressed = true;
        }
        else {
            button = "false";
            setImage("buttonBlue.png");
            buttonPressed = false;
        }
    }
    public boolean buttonPressed() {
        return buttonPressed;
    }
}
