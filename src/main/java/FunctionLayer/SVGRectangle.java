package FunctionLayer;

public class SVGRectangle {

    private String filling = "#ffffff";
    private String height;
    private String opacity;
    private String stroke = "#000000";
    private String strokewidth = "2";
    private String width;
    private String x;
    private String y;

    public SVGRectangle(String height, String opacity, String width, String x, String y) {
        this.height = height;
        this.opacity = opacity;
        this.width = width;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "<rect fill=\"" + filling 
                + "\" height=\"" + height 
                + "\" opacity=\"" + opacity 
                + "\" stroke=\"" + stroke 
                + "\" stroke-width=\"" + strokewidth 
                + "\" width=\"" + width 
                + "\" x=\"" + x 
                + "\" y=\"" + y
                + "\"/>";
    }

}
