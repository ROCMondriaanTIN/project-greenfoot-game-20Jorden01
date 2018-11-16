import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemySpawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySpawn extends Tile
{
    private boolean spawn = true;
    int i;
    public EnemySpawn(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    /**
     * Act - do whatever the EnemySpawn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(spawn) {
            spawn = false;
            getWorld().addObject(new Enemy(),getX(),getY() + 4);
        }
    }
}
