
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Tile extends BasicTile {
    public boolean isSolid = false;
    private static int id;
    public int _id;
    public int x;
    public int y;
    /**
     * Constructor of the tile. Creates a tile based on image, width and height
     *
     * @param image Path to the image file
     * @param width Width of the tile
     * @param heigth Height of the tile
     */
    public Tile(String image, int width, int heigth) {
        super(image, width, heigth);
    }

    /**
     * Constructor of the tile. Creates a tile based on image, width, height and
     * a tile type
     *
     * @param image Path to the image file */
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
