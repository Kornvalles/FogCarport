package FunctionLayer;

public class Carport {
    
    private final int height; //measured in centimeters.
    private final int length; //measured in centimeters.
    private final int width; //measured in centimeters.
    private final boolean toolshed; //false when toolshed is not opted
    private final boolean pointyRoof; //false when roof is not pointy
    private final boolean sides; //false when there are only posts on sides
    private final String details; //details on carport

    public Carport(int height, int length, int width, boolean toolshed, boolean pointyRoof, boolean sides, String details) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.toolshed = toolshed;
        this.pointyRoof = pointyRoof;
        this.sides = sides;
        this.details = details;
    }

    public int getHeight() {
        return height;
    }
    
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
    
    public boolean hasToolshed() {
        return toolshed;
    }

    public boolean hasPointyRoof() {
        return pointyRoof;
    }
    
    public boolean hasSides() {
        return sides;
    }
    
    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Længde= " + length + " cm\nBredde= " + width + " cm\nHøjde= " + height
                + " cm\nSkur= " + toolshed + "\nHøj Rejsning= " + pointyRoof 
                + "\nSider= " + sides + "\nEvt kommentar= " + details; 
    }
    
}