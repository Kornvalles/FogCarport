package FunctionLayer;

public class SVGDraw {

    public SVGDraw() {
    }
    
    public String makePost(int x, int y, int height, int width, String color) {
        return "<rect x=\"" + x + "mm\" y=\"" + y + "mm\" height=\"" + height + "mm\" width=\"" + width 
                + "mm\" style=\"stroke:" + color + "; fill: " + color + "\"/>"; 
    }
    
   public static void main(String[] args) {
      SVGDraw svg = new SVGDraw();
       System.out.println(svg.makePost(10,10,100,100,"#ffffff"));
   }
    
}
