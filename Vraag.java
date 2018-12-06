import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Vraag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vraag extends Hud
{
    private boolean firstAct = true;
    static String vraag;
    /**
     * Act - do whatever the Vraag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstAct) {
            firstAct = false;
            GreenfootImage image = new GreenfootImage(vraag, 30, Color.BLUE,null);
            setImage(image);
        }
        if (getWorld() instanceof TutorialLevel) {
            tutorialLevel();
        }
    }
    public void tutorialLevel() {
        List <Hero> hero = getWorld().getObjects(Hero.class);
        if(hero.get(0).worldX < 2500) {
          GreenfootImage image = new GreenfootImage("Zet de letters in de goede volgorde. Woord: Test", 30, Color.BLUE,null);
            setImage(image);  
        }
        if(hero.get(0).worldX < 1900) {
          GreenfootImage image = new GreenfootImage("Door een enemy verlies je een leven en ga je terug naar het begin van het level", 20, Color.BLUE,null);
            setImage(image);  
        }
        if(hero.get(0).worldX < 1200) {
          GreenfootImage image = new GreenfootImage("Druk spatie om door de deur te gaan", 30, Color.BLUE,null);
            setImage(image);  
        }
        if(hero.get(0).worldX < 500) {
          GreenfootImage image = new GreenfootImage("Druk W om te springen", 30, Color.BLUE,null);
            setImage(image);  
        }
        
    }
}
