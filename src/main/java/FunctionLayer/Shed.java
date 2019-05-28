package FunctionLayer;

/**
 *
 * @author mikkel
 */
public class Shed {

    private final int length; //measured in centimeters.
    private final int width; //measured in centimeters.

    /**
     *
     * @param length
     * @param width
     */
    public Shed(int length, int width) {
        this.length = length;
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Shed{" + "length=" + length 
                + ", width=" + width 
                ;
    }
    
}
