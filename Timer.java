import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Hud
{
    public String getal;
    public char getal2 = '0';
    private boolean firstAct = true;
    static int secondsOver;
    static public int timer;
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Timer() {
        setImage("Score/hud_0.png");
        
    }
    public void act() 
    {
        if(firstAct) {
            firstAct = false;
            secondsOver = 600;
        }
        
        if(timer > 60) {
            secondsOver --;
            timer = 0;
        }
        scoreToString();
        updateScore();
        updateImage();    
    }

    public void updateScore() {
        List <Timer> timer = getWorld().getObjects(Timer.class);
        switch(getal.length()) {
            /*case 4:
            score.get(0).getal2 = getal.charAt(getal.length() - 4); */
            case 3:
            timer.get(0).getal2 = getal.charAt(getal.length() - 3);
            case 2:
            timer.get(1).getal2 = getal.charAt(getal.length() - 2);
            case 1:
            timer.get(2).getal2 = getal.charAt(getal.length() - 1);
            default:
            break;
        }
    }

    public void scoreToString() {
        getal = Integer.toString(secondsOver);
    }

    public void updateImage() {
        setImage("Score/hud_" + getal2 +  ".png");
        getImage().scale(20,20);
    }
}
