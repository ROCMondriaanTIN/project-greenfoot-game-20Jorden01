import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class TotalScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TotalScore extends Hud
{
    /**
     * Act - do whatever the TotalScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scoreToString();
        updateScore();
        updateImage();
    }
    public void updateScore() {
        List <TotalScore> score = getWorld().getObjects(TotalScore.class);
        switch(getal.length()) {
            case 5:
            score.get(0).getal2 = getal.charAt(getal.length() - 5); 
            case 4:
            score.get(1).getal2 = getal.charAt(getal.length() - 4); 
            case 3:
            score.get(2).getal2 = getal.charAt(getal.length() - 3);
            case 2:
            score.get(3).getal2 = getal.charAt(getal.length() - 2);
            case 1:
            score.get(4).getal2 = getal.charAt(getal.length() - 1);
            break;
        }
    }
    public void scoreToString() {
        getal = Integer.toString(Hero.totalScore);
    }
    public void updateImage() {
        setImage("Score/hud_" + getal2 +  ".png");
    }    
}
