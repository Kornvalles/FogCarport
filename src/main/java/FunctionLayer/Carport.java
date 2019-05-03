package FunctionLayer;

public class Carport {

    private final int height; //measured in centimeters.
    private final int length; //measured in centimeters.
    private final int width; //measured in centimeters.
    private final boolean toolshed; //false when toolshed is not opted
    private final boolean pointyRoof; //false when roof is not pointy
    private final int roofAngle;
    private final boolean wall; //false when there are only posts on wall
    private final String details; //details on carport

    public Carport( int height, int length, int width, boolean toolshed, boolean pointyRoof,int roofAngle, 
                    boolean wall, String details) 
    {
        this.height = height;
        this.length = length;
        this.width = width;
        this.toolshed = toolshed;
        this.pointyRoof = pointyRoof;
        this.roofAngle = roofAngle;
        this.wall = wall;
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

    public boolean hasWall() {
        return wall;
    }

    public String getDetails() {
        return details;
    }

    public int getRoofAngle() {
        return roofAngle;
    }

    @Override
    public String toString() {
        return "Længde: " + length + " cm\n\nBredde: " + width + " cm\n\nHøjde: " + height
                + " cm\n\n Skur: " + toolshed + "\n\n Høj rejsning: " + pointyRoof
                + "\n\nVægbeklædning: " + wall + "\n\nEvt kommentar: " + details;
    }

}
