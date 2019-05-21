package FunctionLayer;

public class SVGTriangle {
    
    private String filling = "#ffffff";
    private String stroke = "#000000";
    private String strokewidth = "2";
    private String opacity = "1";
    private String sides = "3";
    private String points;

    public SVGTriangle(String points) {
        this.points = points;
    }  
    
    @Override
    public String toString() {
        return "<polygon fill=\"" + filling 
                + "\" stroke=\"" + stroke 
                + "\" stroke-width=\"" + strokewidth 
                + "\" fill-opacity=\"" + opacity 
                + "\" sides=\"" + sides 
                + "\" points=\"" + points 
                + "\"/>";
    }
    
}
