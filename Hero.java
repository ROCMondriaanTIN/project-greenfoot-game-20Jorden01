
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;   
    private boolean onGround;
    private String onGround2;
    private String button;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }

    @Override
    public void act() {        
        handleInput();
        getWorld().showText(getX() + "," + getY(),500,50);
        onGround = onGround();
        if(onGround || isTouching(Ladder.class)) {
            onGround2 = "true";
        }
        else {
            onGround2 = "false";
        }
        getWorld().showText(onGround2,500,80);
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
    }

    public void handleInput() {
        if ((Greenfoot.isKeyDown("w") && onGround) || (Greenfoot.isKeyDown("w") && isTouching(Ladder.class))) {
            velocityY = -13;
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
}
