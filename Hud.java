import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Hud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hud extends Actor
{
    private int heroLives;
    GreenfootImage emptyHeart = new GreenfootImage("hud_heartEmpty.png");
    
    public Hud() {
        for(int i = 0; i < 3; i ++) {
            getWorld().addObject(new Heart("hud_heartFull.png"),i * 10 + 20,30);
        }
    }
    /**
     * Act - do whatever the Hud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkHeroLives();
    }
    public void checkHeroLives() {
        List <Hero> hero = getWorld().getObjects(Hero.class);
        if(hero != null) {
            heroLives = hero.get(0).lives;
        }
    }
    public void showLives() {
        switch(heroLives) {
            case 1:
            //drawImage(emptyHeart, 50, 50);
            break;
            case 2:
            
            break;
            case 3:
            
            break;
        }
    }
}
