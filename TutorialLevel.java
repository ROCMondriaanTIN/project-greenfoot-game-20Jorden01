import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialLevel extends World
{
    private CollisionEngine ce;
    private int spawnX = 100;
    private int spawnY = 800;
    private String word = "Test";
    private String vraag = "dit wordt een vraag.";
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public TutorialLevel() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1, false);
        resetStatic();
        this.setBackground("bg2.png");
        int[][] map = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,72,-1,50,-1,72,72,72,72,75,69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{72,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,72,72,-1,-1,66,-1,-1,-1,-1,69,69,69,69,72,72,72,69,69,69,69,74,69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,65,-1,-1,47,-1,69,69,69,69,69,69,69,69,69,69,69,74,69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72},
{69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,72,42,72,72,72,72,69,69,69,69,69,69,69,69,69,69,69,74,69,76,76,76,76,-1,-1,-1,-1,-1,-1,-1,-1,69},
{69,-1,-1,-1,-1,51,52,-1,-1,-1,-1,-1,-1,-1,-1,66,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,74,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,69},
{69,-1,48,-1,-1,52,51,-1,-1,-1,-1,-1,-1,-1,57,65,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,74,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,69},
{69,72,72,72,72,72,72,41,41,41,72,72,72,72,72,42,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,72,72,72,72,72,72,72,72,49,49,49,49,72,72,69},
{69,69,69,69,69,69,69,40,40,40,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69},

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
        addObject(hero, spawnX,spawnY);
        addObjects();
        
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
        Hero.level = 0;
        Letter.nummer = 0;
        Letter.word = word;
        LetterFinish.nummer = 0;
        Door.doors = 0;
        LetterFinish.placedLetters = Letter.word.length();
        Heart.nummer2 = 0;
        Hero.score = 0;
        Vraag.vraag = vraag;
        Hero.gameOver = false;
    }
    public void addObjects() {
        addObject(new Hud(),0,0);
    }
}