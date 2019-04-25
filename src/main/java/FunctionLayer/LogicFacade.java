package FunctionLayer;

import DataLayer.OrderMapper;
import PresentationLayer.Order;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * 
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class LogicFacade {

    public static List<Carport> getOrders( int id ) throws FogException, ClassNotFoundException  {
        return OrderMapper.getStandard();
    }
    
    public static Order createOrder( Carport carport, String name, String email ) throws FogException {
        return OrderMapper.makeOrder(carport, name, email);
    }
    
}
