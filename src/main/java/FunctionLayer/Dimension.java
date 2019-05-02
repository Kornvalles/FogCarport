package FunctionLayer;

/**
 *
 * @author ibenk
 */
public class Dimension {
    private int length;
    private int width;
    private int height;
    private int startX;
    private int startY;

    public Dimension(int length, int width, int height, int startX, int startY) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
    }

    public Dimension(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Dimension(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

}
