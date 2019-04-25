package FunctionLayer;

import DataLayer.OrderMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * 
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class LogicFacade {

    public static List<Carport> getOrders() throws FogException, ClassNotFoundException  {
        return OrderMapper.getStandard();
    }
    
}
