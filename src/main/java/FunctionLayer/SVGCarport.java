package FunctionLayer;

/**
 *
 * @author ibenk
 */
public class SVGCarport {
    
    public String drawCarport(Dimension dimension) {
        int drawingStartX = dimension.getStartX();
        int drawingStartY = dimension.getStartY();
        int drawingWidth = dimension.getWidth();
        int drawingLength = dimension.getLength();
        int poleWidth = 10;
        int polesMaxDistance = 100;
        int numberPolesOneSide = (int) Math.ceil(drawingLength / polesMaxDistance);
        int polesAvgDistance = drawingLength / numberPolesOneSide;
        int eaves = 30;

        StringBuilder sb = new StringBuilder();
        
        sb.append("<svg>");
        
        sb.append(rectangle(dimension.getStartX(), dimension.getStartY(), dimension.getWidth(), dimension.getLength()));
        
        sb.append("</svg>");
        
        return sb.toString();
    }

    public String rectangle(int x, int y, int width, int length) {
        String text = "<rect x=\"" + x + "\" y=\"" + y + "\" height=\"" + length + "\" width=\"" + width + "\" style=\"stroke:#000000; stroke-width: 3; fill: none\"/>";
        return text;
    }
    
}
