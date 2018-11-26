import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends World
{
    private CollisionEngine ce;
    static int y = 600;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public World2() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1, false);
        resetStatic();
        this.setBackground("bg.png");
        int[][] map = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,307,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6},
{8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6},
{6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6},
{6,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6},
{6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,66,6,6},
{6,307,-1,-1,-1,-1,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,270,65,6,6},
{6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,305,-1,-1,-1,-1,8,8,310,310,310,310,310,310,8,104,6,6},
{6,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,8,8,8,8,8,8,8,8,6,6,6,6,6,6,6,6,6,6,6,6},
{6,8,-1,-1,-1,-1,-1,8,8,8,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
{6,6,96,-1,-1,8,8,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
{6,6,95,8,8,6,6,6,6,6,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
{6,6,95,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,307,-1,-1,-1,-1,6},
{6,6,95,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,66,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
{6,6,95,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,65,-1,-1,-1,-1,-1,-1,305,-1,-1,-1,-1,-1,-1,96,6},
{6,6,8,8,8,8,8,8,8,8,8,8,8,8,8,8,103,8,-1,-1,8,8,8,8,8,8,8,8,8,8,95,6},
{6,6,6,6,6,307,6,6,6,6,6,6,6,6,6,6,6,6,-1,-1,6,6,6,6,6,6,6,6,6,6,95,6},
{6,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,95,6},
{6,6,6,6,6,-1,268,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,95,6},
{6,6,6,6,6,8,8,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,95,6},
{6,6,6,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,-1,-1,-1,-1,-1,-1,-1,95,6},
{6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,95,8,8,-1,-1,8,8,8,8,6},
{6,-1,-1,307,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,307,-1,-1,-1,-1,95,6,6,-1,-1,6,6,6,6,6},
{6,66,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,66,-1,95,6,6,-1,-1,6,6,6,6,6},
{6,65,-1,-1,-1,-1,-1,1,0,-1,-1,305,-1,-1,0,-1,-1,-1,-1,-1,65,-1,95,6,6,-1,-1,6,6,6,6,6},
{6,104,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,103,8,8,6,6,11,11,6,6,6,6,6},
{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,10,10,6,6,6,6,6},
{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,10,10,6,6,6,6,6},



};
        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero();

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(hero, 200,1700);
        //addObject(new Enemy(), 1550, 994);
        //addObject(new Enemy(), 539, 634);
        
        // Force act zodat de camera op de juist plek staat.
        camera.act();
        hero.act();

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
    }

    @Override
    public void act() {
        ce.update();
    }
    public void resetStatic() {
        Letter.nummer = 0;
        Letter.word = "Finish";
        LetterFinish.nummer = 0;
        Door.doors = 0;
        LetterFinish.placedLetters = Letter.word.length();
    }
}