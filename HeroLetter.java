import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class HeroLetter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroLetter extends Hud
{
    private String letter;
    /**
     * Act - do whatever the HeroLetter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List <Hero> hero = getWorld().getObjects(Hero.class);
        if(hero.get(0).letter2.isEmpty()) {
            setImage("Letters/letter.png");
        }
        else {
            setImage("Letters/letter_" + getLetter() + ".png");
        }
        getImage().scale(30,30);
    }

    public String getLetter() {
        List <Hero> hero = getWorld().getObjects(Hero.class);
        letter = hero.get(0).letter2;
        return letter;
    }
}
