
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {
    private int timer;
    private final double gravity;
    private final double acc;
    private final double drag;   
    private boolean onGround;
    private String button;
    private int teller;
    private boolean mirror;
    private boolean facingRight;
    private boolean keyPressed;
    public String letter2 = new String();
    boolean noLetter = false;
    public int lives;
    private boolean gameOver;
    private boolean firstAct = true;
    private int spawnX;
    private int spawnY;
    static int score;
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_front.png");
        scaleImage();
        lives = 3;
    }

    @Override
    public void act() {
        if(firstAct) {
            firstAct = false;
            spawnX = getX();
            spawnY = getY();
        }
        if(Greenfoot.isKeyDown("h")) {
            gameOver = false;
            if (getWorld() instanceof World2) {
                Greenfoot.setWorld(new World2());
            }
        }
        getWorld().showText(getX() + "," + getY(),500,50);
        getWorld().showText(Integer.toString(lives),500,100);
        getWorld().showText(letter2,50,50);
        if(!gameOver) {  
            checkLevens();
            animatie2();
            handleInput();
            onGround = onGround();
            applyVelocity();
            velocityX *= drag;
            velocityY += acc;
            if (velocityY > gravity) {
                velocityY = gravity;
            }
            detect();
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
        if(Greenfoot.isKeyDown("f")) {
            score ++;
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

    public void animatie2() {
        if(velocityX >= -0.3 && velocityX <= 0.3 && onGround) {
            setImage("p1_front.png");
            scaleImage();
        }
        if (!onGround) {
            setImage("p1_jump.png");
            scaleImage();
            mirrorImage();
        }
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

    public String getLetter() {
        return letter2;
    }

    public void resetLetter() {
        letter2 = "";
    }

    public void checkLevens() {
        if(lives == 0) {
            getWorld().addObject(new GameOver(),300,300);
            gameOver = true;
        }
    }

    public void detect() {
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null && timer < 10) {
                setLocation(spawnX,spawnY); 
                lives --;
                timer = 10;
                break;
            }
            else{
               timer --; 
            }
            
        }
        for (Letter letter : getObjectsAtOffset(0,-80,Letter.class)) {
            if (letter != null) {
                noLetter = letter2.isEmpty();
                if(noLetter && !letter.getHit()) {
                    letter2 = letter.getLetter2();
                    letter.hitByHero();
                }
                break;
            }
        }
        if(isTouching(Deathtiles.class)) {
              setLocation(spawnX,spawnY); 
              lives --;
        }
    }
    public int getLives() {
        return lives;
    }
}
