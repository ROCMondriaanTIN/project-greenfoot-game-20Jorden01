
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
    private boolean facingRight = true;
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
            if (tile.getIsSolid()) {
                speed = -1;
                facingRight = false;
            }
        }
        Tile tile2 = (Tile)getOneObjectAtOffset(getImage().getWidth() / 2 * -1,0,Tile.class);
        if (tile2 != null)
        {
            if (tile2.getIsSolid()) {
                speed = 1;
                facingRight = true;
            }
        }
        //check for ground
        if ((!onGroundRight() || !onGroundLeft()) && timer > 20) {
                if(facingRight) {
                    facingRight = false;
                }
                else {
                    facingRight = true;
                }
                timer = 0;
                speed *= -1;
        }
        if(timer > 100) {
            timer = 0;
        }
    }
}
