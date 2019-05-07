package FunctionLayer;
import DataLayer.OrderMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iben
 */
public class MainTest {
    
    public static void main(String[] args) throws FogException {
        
        OrderMapper mapper = new OrderMapper();
        
        Customer c = new Customer("Mikkel", "mikkel@mail.dk", "Markvej 8", "3440", "65329298");
        Carport cp = new Carport(300, 200, 500, true, true, 0, true, "");
        Material m = new Material("Screw", 0, "", 10.0);
        Material m2 = new Material("Wood", 0, "", 14.0);
        List<Material> list = new ArrayList();
        list.add(m);
        list.add(m2);
        Construction o = new Construction(cp, list, 0);
        Invoice i = new Invoice(c, o);
        i.makeInvoice(c, o);
        
        /* Test carport with height, length, width */
//        Carport carport = new Carport(230,400,200,false,false,true,"");
//        
//        //This works
//        //System.out.println(Calculator.getPosts(carport));
//        
//        //This works
//        //System.out.println(Calculator.getRoof(carport));
//        
//        //This works
//        System.out.println(Calculator.getAllMaterial(carport));
//        System.out.println(Calculator.getTotalPrice(carport));
        
        
        //This works
//        OrderMapper mapper = new OrderMapper();
//        System.out.println(mapper.getMaterialPrice("screw"));
//        System.out.println(mapper.getMaterialPrice("wood board"));
    }
    
}
