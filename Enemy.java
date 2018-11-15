
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
        int x = getX();
        int y = getY();
        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        velocityX = speed;
        applyVelocity();
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
    
}
