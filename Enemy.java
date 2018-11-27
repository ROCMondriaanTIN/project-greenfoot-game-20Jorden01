
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Enemy extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    private static int number;
    private int timer;
    private boolean facingRight;
    public Enemy() {       
        super();
        walkRange();
        number ++;
        setImage("blockerMad.png");
        getImage().mirrorHorizontally();       
        firstAct = true;
        speed = 1;
    }

    @Override
    public void act() {
        //enemy1();
        enemy2();
        getWorld().showText(Integer.toString(timer),500,130);
        velocityX = speed;
        applyVelocity();
        timer ++;
    }
    public void walkRange()
    {
        switch (number) {
            case 0:
            this.walkRange = 350;
            break;
            case 1:
            this.walkRange = 198;
            break;
            default:
            number = 0;
            break;
        }
    }
    public void enemy1() {
       int x = getX();
        int y = getY();
        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        
        
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
            getImage().mirrorHorizontally();
        } else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
            getImage().mirrorHorizontally();
        } 
    }
    public void enemy2() {
        //check for wall
        Tile tile = (Tile)getOneObjectAtOffset(getImage().getWidth() / 2,0,Tile.class);
        if (tile != null)
        {
            if (tile.getIsSolid() && facingRight) {
               speed = -1;
               facingRight = false;
            }
        }
        Tile tile2 = (Tile)getOneObjectAtOffset(getImage().getWidth() / 2 * -1,0,Tile.class);
        if (tile2 != null)
        {
            if (tile2.getIsSolid() && !facingRight) {
               speed *= 1;
               facingRight = true;
            }
        }
        //check for ground
        Tile tile3 = (Tile)getOneObjectAtOffset(0, getImage().getHeight() + 5/ 2,Tile.class);
        //boolean onGround = tile3.getIsSolid();
        if (tile3 != null)
        {
            if(timer > 20) {
            if (timer > 20 && !tile3.getIsSolid()) {
                System.out.print("true");
                speed *= -1;
                facingRight = !facingRight;
            }
            timer = 0;
        }
        } 
        
    }
    
}
