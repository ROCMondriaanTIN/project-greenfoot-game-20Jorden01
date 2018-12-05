import greenfoot.*;
import java.util.List;
/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {
    private int timer;
    private final double gravity;
    private final double acc;
    private final double drag;   
    private int teller;
    private boolean facingRight;
    private boolean keyPressed;
    public String letter2 = new String();
    boolean noLetter = false;
    public int lives;
    static boolean gameOver;
    private boolean firstAct = true;
    private int spawnX;
    private int spawnY;
    static int score;
    private boolean activated;
    private boolean died;
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
        Timer.timer ++;
        getWorld().showText(letter2,50,50);
        getWorld().showText(Integer.toString(ScoreCounter.totalScore),50,550);
        if(!gameOver) {  
            checkLevens();
            animatie2();
            handleInput();
            applyVelocity();
            velocityX *= drag;
            velocityY += acc;
            if (velocityY > gravity) {
                velocityY = gravity;
            }
            detect();
        }
        else if(!activated) {
            if(!died) {
            Hero.score += Timer.secondsOver;
        }
            ScoreCounter.totalScore += Hero.score;
            activated = true;
        }
        if(Greenfoot.isKeyDown("r")) {
            gameOver = false;
            resetWorld();
        }
    }

    public void handleInput() { 
        
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
            facingRight = false;
            if(onGround()){
                loopanimatie();                
            }
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            facingRight = true;
            if(onGround()) {
                loopanimatie();
            }
        }
        if ((Greenfoot.isKeyDown("w") && onGround()) || (Greenfoot.isKeyDown("w") && isTouching(Ladder.class))) {
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
        if(velocityX >= -0.3 && velocityX <= 0.3 && onGround()) {
            setImage("p1_front.png");
            scaleImage();
        }
        if (!onGround()) {
            setImage("p1_jump.png");
            scaleImage();
            mirrorImage();
        }
    }

    public void scaleImage() {
        getImage().scale(56, 78);
    }

    public void mirrorImage() {
        if(!facingRight) {
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
            died = true;
        }
    }

    public void detect() {
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null /*&& timer < 10*/) {
                setLocation(spawnX,spawnY);
                Greenfoot.delay(3);
                lives --;
                //timer = 10;
                break;
            }
            else{
                //timer --; 
            }

        }
        for (Letter letter : getObjectsAtOffset(0,getImage().getHeight() / 2 * -1,Letter.class)) {
            if (letter != null) {
                noLetter = letter2.isEmpty();
                if(noLetter && !letter.getHit()) {
                    if(letter.getUsedLetter()) {
                        letter2 = letter.getLetter2();
                        letter.hitByHero();
                        score += 10;
                    }
                    else {
                        score -= 10;
                        letter.hitByHero();
                    }
                }
                break;
            }
        }
        List <Deathtiles> deathtiles = getObjectsAtOffset(0,0,(Deathtiles.class));
        if(deathtiles.size() != 0) {
            setLocation(spawnX,spawnY); 
            lives --;
        }
    }

    public int getLives() {
        return lives;
    }

    public void resetWorld() {
        if (getWorld() instanceof Map1)  {Greenfoot.setWorld(new Map1());}
         if (getWorld() instanceof Map2)  {Greenfoot.setWorld(new Map2());}
        else if (getWorld() instanceof TutorialLevel)  {Greenfoot.setWorld(new TutorialLevel());}
        //else if (getWorld() instanceof Map2)  {Greenfoot.setWorld(new Map2());}
        //else if (getWorld() instanceof Map2)  {Greenfoot.setWorld(new Map2());}
        //else if (getWorld() instanceof Map2)  {Greenfoot.setWorld(new Map2());}
   
    }
}
