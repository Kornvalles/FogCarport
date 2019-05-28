package FunctionLayer;

public class Shed {

    private final int length; //measured in centimeters.
    private final int width; //measured in centimeters.

    public Shed(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

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
