
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
    private int teller;
    private boolean mirror;
    private boolean facingRight;
    private boolean keyPressed;
    private String letter2;
    boolean heeftLetter = false;
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_front.png");
        scaleImage();
    }

    @Override
    public void act() {
        if(velocityX >= -0.3 && velocityX <= 0.3 && onGround) {
            setImage("p1_front.png");
            scaleImage();
        }
        if (!onGround) {
            setImage("p1_jump.png");
            scaleImage();
            mirrorImage();
        }
        handleInput();
        getWorld().showText(getX() + "," + getY(),500,50);
        getWorld().showText(letter2,50,50);
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
        for (Letter letter : getObjectsAtOffset(0,-80,Letter.class)) {
            if (letter != null) {
                //heeftLetter = letter2.isEmpty();
                //if(!heeftLetter) {
                    letter2 = letter.getLetter2();
                //}
                break;
            }
        }
    }

    public void handleInput() {        
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
            facingRight = false;
            if(onGround){
                loopanimatie();                
            }
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            facingRight = true;
            if(onGround) {
                loopanimatie();
            }
        }
        if ((Greenfoot.isKeyDown("w") && onGround) || (Greenfoot.isKeyDown("w") && isTouching(Ladder.class))) {
            velocityY = -13;
        }
        if(Greenfoot.isKeyDown("space") && !keyPressed) {
            checkDoor();
            keyPressed = true;
        }
        if(!Greenfoot.isKeyDown("space") && keyPressed) {
            keyPressed = false;
        }
         if(Greenfoot.isKeyDown("e")) {
            letter2 = null;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    public void loopanimatie() {
        switch(teller) {
            case 1:
            setImage("p1_walk01.png");
            break;
            case 2:
            setImage("p1_walk02.png");
            break;
            case 3:
            setImage("p1_walk03.png");
            break;
            case 4:
            setImage("p1_walk04.png");
            break;
            case 5:
            setImage("p1_walk05.png");
            break;
            case 6:
            setImage("p1_walk06.png");
            break;
            case 7:
            setImage("p1_walk07.png");
            break;
            case 8:
            setImage("p1_walk08.png");
            break;
            case 9:
            setImage("p1_walk09.png");
            break;
            case 10:
            setImage("p1_walk10.png");
            teller = 0;
            break;
            default:
            teller = 0;
            break;            
        }
        teller ++;
        scaleImage();
        mirrorImage();
    }
    public void scaleImage() {
        getImage().scale(56, 78);
    }
    public void mirrorImage() {
        if(mirror && facingRight) {
           getImage().mirrorHorizontally();
        }
        else if(!mirror && !facingRight) {
            getImage().mirrorHorizontally();
        }
    }
    public void checkDoor() {
        Door door = (Door)getOneObjectAtOffset(0,0,Door.class);
        if(door != null) {
            if(door.open) {
            door.findOtherDoor();
            setLocation(door.doorX(),door.doorY());
        }
        }
        
    }
    
}
