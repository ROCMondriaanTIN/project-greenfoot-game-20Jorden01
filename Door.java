import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Tile
{
    boolean open;
    private String image;
    private String doorColor;
    private boolean firstAct = true;
    private String buttonColor;
    public Door(String image,int width,int heigth) {
        super(image,width,heigth);
        this.image = image;
        
    }
    /**
     * Act - do whatever the door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
            checkLockColor();
            checkButton();
            changeImage();
    }
    public void checkButton() {
       List <Button> button = getWorld().getObjects(Button.class);
       for(int i = 0; i < button.size(); i ++) {
           /*if(button.get(i).buttonPressed) {
               if((button.get(i).color).equalsIgnoreCase(doorColor)) {
                    iets = button.get(i).buttonPressed;
                }  
           }*/
       if((button.get(i).color).equalsIgnoreCase(doorColor)) {
           open = button.get(i).buttonPressed;
        }  
    }
    }
    public void checkLockColor() {
        if(image.contains("Top")) {
         Lock lock1 = (Lock)getOneObjectAtOffset(0, getImage().getHeight() * 2,Lock.class);
         if (lock1 != null){
               doorColor = lock1.getLockColor();
         }
    }
    else {
         Lock lock1 = (Lock)getOneObjectAtOffset(0, getImage().getHeight(),Lock.class);
         if (lock1 != null){
                doorColor = lock1.getLockColor();
            }
        }
   
      // List <Lock> lock = getObjectsInRange(getImage().getHeight() + 10, Lock.class);
       //List <Lock> lock = getWorld().getObjectsAt(getX(),getY() + getImage().getHeight() / 2,Lock.class);
     //  if(!lock.isEmpty()) {
     //      System.out.print("empty");
      // doorColor = lock.get(0).color;
    //}
       
    }
    public void changeImage() {
        switch(image) {
           case "door_closedMid.png": 
            if (open) {
               setImage("door_openMid.png");
            }
            else {
               setImage("door_closedMid.png");
            }
            break;
           case "door_closedTop.png":
            if (open) {
               setImage("door_openTop.png");
            }
            else {
               setImage("door_closedTop.png");
            }
            break;
        }
    }
    public String color() {
        return doorColor;
    }
}
