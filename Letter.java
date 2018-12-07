import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Letter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letter extends Tile
{
    static String word;
    static int counter;
    String word2 = "A";
    public String letter;
    private String image;
    static int nummer;
    public int nummer2;
    boolean iets = false;
    String test;
    private boolean firstAct = true;
    private boolean hit;
    public boolean usedLetter;
    public Letter(String image,int width,int heigth) {
        super(image,width,heigth);
        nummer2 = nummer;
        nummer ++;   
    }

    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstAct) {            
            firstAct = false;                        
            setImage("Letters/letter_" + getLetter() + ".png");
            getImage().scale(60,60);            
        }    
    }

    public String getLetter() {
        String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};        
        int teller = 0;
        if(nummer2 == 0) {            
            word2 = word.substring(0).toUpperCase();
            //System.out.print(word2 + ", ");
        }
        else{
            word2 = getword();
        }
        while(!iets) {
            letter = letters[Greenfoot.getRandomNumber(26)];
            iets = word2.contains(letter);
            if(iets) {
                word2 = word2.replaceFirst(letter,"");
                usedLetter = true;
                //System.out.print(word2 + ", ");
                teller ++;
                if(teller >= word.length()) {
                    break;
                }
            }
            else if((counter > 0 && (Greenfoot.getRandomNumber(10) == 1)) || (word2.length() == 0)) {
                counter --;
                break;
            }
        }
        return letter;
    }

    public String getword() {
        List <Letter> letter = getWorld().getObjects(Letter.class);
        for(int i = 0; i < letter.size(); i ++) {
            if(letter.get(i).nummer2 == nummer2 - 1) {
                word2 = letter.get(i).word2;
            }
        }
        return word2;
    }
    public void hitByHero() {
        setImage("bg3.png");
        isSolid = false;
        hit = true;
    }

    public String getLetter2() {
        return letter;
    }
    public boolean getHit() {
        return hit;
    }
    public boolean getUsedLetter() {
        return usedLetter;
    }
}
