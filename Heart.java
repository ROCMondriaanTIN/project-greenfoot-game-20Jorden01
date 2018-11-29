import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Hud
{
    private int heroLives;
    static int nummer2;
    private int nummer;
    GreenfootImage emptyHeart = new GreenfootImage("hud_heartEmpty.png");
    GreenfootImage fullHeart = new GreenfootImage("hud_heartFull.png");
    public Heart(String image) {
        setImage(image);
        nummer = nummer2;
        nummer2 ++;
    }
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkHeroLives();
        showLives();
    }
    public void checkHeroLives() {
        List <Hero> hero = getWorld().getObjects(Hero.class);
        if(hero != null) {
            heroLives = hero.get(0).lives;
        }
    }
    public void showLives() {
        switch(nummer) {
            case 0:
            if(heroLives < 1) {
            setImage(emptyHeart);
        }
            break;
            case 1:
            if(heroLives < 2) {
            setImage(emptyHeart);
        }
            break;
            case 2:
            if(heroLives < 3) {
            setImage(emptyHeart);
        }
            break;
        }
    }
}
