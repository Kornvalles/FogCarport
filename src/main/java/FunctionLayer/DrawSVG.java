package FunctionLayer;

/**
 *
 * @author mikkel
 */
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

    /**
     *
     */
    public DrawSVG() {
        }

    /**
     *
     * @param height
     * @param opacity
     * @param width
     * @param x
     * @param y
     * @return
     */
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

    /**
     *
     * @param points
     * @return
     */
    public String makeTriangle(String points) {
            return "<polygon fill=\"" + filling
                    + "\" stroke=\"" + stroke
                    + "\" stroke-width=\"" + strokewidth
                    + "\" fill-opacity=\"" + opacity
                    + "\" sides=\"" + sides
                    + "\" points=\"" + points
                    + "\"/>";
        }

    /**
     *
     * @param x
     * @param y
     * @param text
     * @return
     */
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

    /**
     *
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     */
    public String makeMarker(int x1, int x2, int y1, int y2) {
            return "<defs> "
                    + "<marker id='beginArrow' markerHeight='9' markerWidth='9' orient='auto' refX='0' refY='4'> "
                    + "<path d='m0,4l8,-4l0,8l-8,-4' fill='#000000s' id='svg_2'/> </marker> "
                    + "<marker id='endArrow' markerHeight='9' markerWidth='9' orient='auto' refX='8' refY='4'> "
                    + "<path d='m0,0l8,4l-8,4l0,-8' fill='#000000' id='svg_3'/> </marker> "
                    + "</defs>"
                    + "<line marker-end='url(#endArrow)' marker-start='url(#beginArrow)' stroke='#000000' "
                    + "x1=\'" + x1 
                    + "\' x2=\'" + x2
                    + "\' y1=\'" + y1 
                    + "\' y2=\'" + y2
                    + "\'/>";
        }
   
}
