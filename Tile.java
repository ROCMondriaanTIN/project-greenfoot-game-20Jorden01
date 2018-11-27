
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Tile extends Actor {

    public boolean isSolid = false;
    private static int id;
    public int _id;
    public int x;
    public int y;

    /**
     * Contructor of the tile. Creates a tile based on image, width and height
     *
     * @param image Path to the image file
     * @param width Width of the tile
     * @param heigth Height of the tile
     */
    public Tile(String image, int width, int heigth) {
        super();
        setImage(image);
        getImage().scale(width, heigth);
        if (CollisionEngine.DEBUG) {
            getImage().drawString("ÏD: " + id, 10, 10);
        }
        _id = id;
        id++;
    }

    @Override
    public String toString() {
        return "id: " + _id + "\n"
                + "X: " + getX() + "\n"
                + "Y: " + getY();
    }
    public boolean getIsSolid() {
        return isSolid;
    }
    public int x() {
        return x;
    }
    public int y() {
        return y;
    }
}
