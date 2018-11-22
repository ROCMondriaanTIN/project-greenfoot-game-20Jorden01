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
    public int doorX;
    public int doorY;
    public int otherDoorX;
    public int otherDoorY;
    private int doorNumber;
    private static int doors;
    public Door(String image,int width,int heigth) {
        super(image,width,heigth);
        this.image = image;
        doors ++;
        doorNumber = doors;  
    }
    /**
     * Act - do whatever the door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstAct) {
            doorY = this.getY();
            doorX = this.getX();
            firstAct = false;
        }
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
    public void findOtherDoor() {
       List <Door> door = getWorld().getObjects(Door.class);
       for(int i = 0; i < door.size(); i ++) {
           /*if(button.get(i).buttonPressed) {
               if((button.get(i).color).equalsIgnoreCase(doorColor)) {
                    iets = button.get(i).buttonPressed;
                }  
           }*/
       if((door.get(i).doorColor).equalsIgnoreCase(doorColor)) {
           if(doorNumber != door.get(i).doorNumber && door.get(i).doorNumber != doorNumberTop()) {
               otherDoorX = door.get(i).doorX;
               otherDoorY = door.get(i).doorY;
            }
        }  
    }
    }
    public int doorNumberTop() {
        Door doortop = (Door)getOneObjectAtOffset(0, getImage().getHeight() * -1,Door.class);
        return doortop.getDoorNumber();
    }
    public int doorX() {
        return otherDoorX;
    }
    public int doorY() {
        return otherDoorY;
    }
    public int getDoorNumber() {
        return doorNumber;
    }
}
