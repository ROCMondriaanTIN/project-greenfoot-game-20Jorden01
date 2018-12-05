import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(600, 600, 1); 
        this.setBackground("bg2.png");
        int[][] map = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,86,-1,77,-1,78,-1,-1},
                {-1,85,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,79,-1,80,-1,81,-1,-1},
                {-1,85,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,82,-1,83,-1,84,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            };

        TileEngine te = new TileEngine(this, 60, 60, map);
    }
}
