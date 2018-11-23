import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class LetterFinish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetterFinish extends Tile
{
    static public int nummer;
    public int nummer2;
    public String letter;
    private boolean firstAct = true;
    private boolean activated;
    public LetterFinish(String image,int width,int heigth) {
        super(image,width,heigth);
        nummer2 = nummer;
        nummer ++;
    }
    /**
     * Act - do whatever the LetterFinish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstAct) {
            firstAct = false;
            toLetter();
        }
        for (Hero hero : getObjectsAtOffset(0,-80,Hero.class)) {
            if (hero != null) {
                if(hero.getLetter().equalsIgnoreCase(letter) && !activated) {
                    System.out.print("true");
                    setImage("Letters/letter_" + letter.toUpperCase() + ".png");
                    getImage().scale(60,60);
                    hero.resetLetter();
                    activated = true;
                }
                break;
            }
        }
    }
    public void toLetter() {
        letter = Letter.word.substring(nummer2,nummer2 + 1);
    }
    public String getLetter() {
        return letter;
    }
}
