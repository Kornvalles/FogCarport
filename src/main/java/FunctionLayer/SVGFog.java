package FunctionLayer;

/**
 *
 * @author ibenk
 */
public class SVGFog {
    
    int width, length, height, angles;
    
    public SVGFog(int width, int length, int height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public void setAngles(int angles)
    {
        this.angles = angles;
    }

    @Override
    public String toString()
    {
        return "SVGDrawingFOG{" + "width=" + width + ", length=" + length + ", height=" + height + ", angles=" + angles + '}';
    }
    
    public String drawTop()
    {
        String drawingTop = "";
        
        int carportWidth = width + 20;
        int carportLength = length + 20;
        
        drawingTop += "<svg viewbox='0 0 " + carportWidth + " " + carportLength + "'>";
        drawingTop += "<rect x='0' y ='0' width='" + carportWidth + "' height='" + carportLength + "' fill='yellow' />";
        
        for(int polesCount = 0; polesCount <= length; polesCount += 10)
        {
            int poleX = polesCount + 10;
            drawingTop += "<rect x='" + poleX + "' y='10' width='5' height='" + length +"' fill='gray' />";
        }
        
        drawingTop += "</svg>";
        
        return drawingTop;
    }
    
}
