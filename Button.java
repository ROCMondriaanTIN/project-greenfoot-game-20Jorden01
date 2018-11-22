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
    private int counter;
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
        image();
    }
    public void checkHero(){
        if(isTouching(Hero.class)) {
            //setImage("button" + color + "_pressed.png");
            buttonPressed = true;
        }
        else if (buttonPressed){
            counter ++;
            if(counter > 100) {
            //setImage("button" + color + ".png");
            buttonPressed = false;
            counter = 0;
        }
        }
        else {
             buttonPressed = false;
            }
    }
    public String checkButtonColor() {
        return color;
    }
    public void image() {
        if (buttonPressed) {
            setImage("button" + color + "_pressed.png");
        }
        else {
            setImage("button" + color + ".png");
        }
    }
}
