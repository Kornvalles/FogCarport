package FunctionLayer;

import DataLayer.OrderMapper;

/**
 *
 * @author iben
 */
public class MainTest {
    
    public static void main(String[] args) throws FogException {
    
        /* Test carport with height, length, width */
        CarportWithSides carport = new CarportWithSides(230, 400, 200);
        
        //This works
        //System.out.println(Calculator.getPosts(carport));
        
        //This works
        //System.out.println(Calculator.getRoof(carport));
        
        //This works
        System.out.println(Calculator.getAllMaterial(carport));
        System.out.println(Calculator.getTotalPrice(carport));
        
        
        //This works
//        OrderMapper mapper = new OrderMapper();
//        System.out.println(mapper.getMaterialPrice("screw"));
//        System.out.println(mapper.getMaterialPrice("wood board"));
    }
    
}
