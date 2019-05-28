package FunctionLayer;

/**
 *
 * @author mikkel
 */
public class Carport {

    private final int height; //measured in centimeters.
    private final int length; //measured in centimeters.
    private final int width; //measured in centimeters.
    private final boolean toolshed; //false when toolshed is not opted
    private final int shedWidth;
    private final boolean pointyRoof; //false when roof is not pointy
    private final boolean roofType;
    private final int roofAngle;
    private final boolean wall; //false when there are only posts on wall
    private final String details; //details on carport

    /**
     *
     * @param height
     * @param length
     * @param width
     * @param toolshed
     * @param shedWidth
     * @param pointyRoof
     * @param roofType
     * @param roofAngle
     * @param wall
     * @param details
     */
    public Carport( int height, int length, int width, boolean toolshed, int shedWidth, boolean pointyRoof, boolean roofType, int roofAngle, boolean wall, String details) 
    {
        this.height = height;
        this.length = length;
        this.width = width;
        this.toolshed = toolshed;
        this.shedWidth = shedWidth;
        this.pointyRoof = pointyRoof;
        this.roofType = roofType;
        this.roofAngle = roofAngle;
        this.wall = wall;
        this.details = details;
    }    

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
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

    /**
     *
     * @return
     */
    public boolean hasToolshed() {
        return toolshed;
    }

    /**
     *
     * @return
     */
    public boolean hasPointyRoof() {
        return pointyRoof;
    }

    /**
     *
     * @return
     */
    public boolean hasWall() {
        return wall;
    }

    /**
     *
     * @return
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * @return
     */
    public int getRoofAngle() {
        return roofAngle;
    }

    /**
     *
     * @return
     */
    public boolean roofType() {
        return roofType;
    }

    /**
     *
     * @return
     */
    public int getShedWidth() {
        return shedWidth;
    }
    
    

    @Override
    public String toString() {
        return "Carport:" + " Højde: " + height 
                          + " | Længde: " + length 
                          + " | Bredde: " + width 
                          + " | Redskabsskur tilkøbt: " + toolshed 
                          + " | Vinklet tag: " + pointyRoof 
                          + " | Tagbelægning: " + roofType 
                          + " | Taghældning: " + roofAngle + "°"
                          + " | Vægge: " + wall 
                          + " | Kommentar: " + details;
    }
    
    

}
