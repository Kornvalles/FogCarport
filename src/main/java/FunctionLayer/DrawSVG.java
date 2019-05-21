package FunctionLayer;

public class DrawSVG {

    private String filling = "#ffffff";
    private String stroke = "#000000";
    private String strokewidth = "2";
    private String font = "courier";
    private String size = "18";
    private String placing = "left";
    private String sides = "3";
    private String opacity;

    private String height;
    private String width;
    private String x;
    private String y;
    private String text;
    private String points;

    public DrawSVG() {
    }

    public String makeRectangle(String height, String opacity, String width, String x, String y) {
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

    public String makeTriangle(String points) {
        return "<polygon fill=\"" + filling
                + "\" stroke=\"" + stroke
                + "\" stroke-width=\"" + strokewidth
                + "\" fill-opacity=\"" + opacity
                + "\" sides=\"" + sides
                + "\" points=\"" + points
                + "\"/>";
    }

    public String makeText(String x, String y, String text) {
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

    public String makeLine() {
        String line = "";

        return line;
    }

    public String makeMarker() {
        String marker = "";

        return marker;
    }
}
