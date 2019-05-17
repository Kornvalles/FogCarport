package FunctionLayer;

public class SVGText {

    private String filling = "#000000";
    private String font = "courier";
    private String size = "18";
    private String stroke = "#000000";
    private String placing = "middle";
    private String x;
    private String y;
    private String text;

    public SVGText(String x, String y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    @Override
    public String toString() {
        return "<text fill=\"" + filling
                + "\" font-family=\"" + font
                + "\" font-size=\"" + size
                + "\" stroke=\"" + stroke
                + "\" text-anchor=\"" + placing
                + "\" x=\"" + x
                + "\" y=\"" + y
                + "\">"
                + text
                + "</text>";
    }
    
}
