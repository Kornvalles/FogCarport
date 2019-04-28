package FunctionLayer;

import DataLayer.OrderMapper;

/**
 * The purpose of LogicFacade is to...
 * 
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class LogicFacade {

//    public static List<Carport> getOrders( int id ) throws FogException, ClassNotFoundException  {
//        return OrderMapper.getStandard();
//    }
//    

//    public static void createOrder( Carport carport, String name, String email ) throws FogException {
//        OrderMapper.makeOrder(carport, name, email);
//    }

    
    public static double getMaterialPrice(String name) throws FogException {
        return OrderMapper.getMaterialPrice(name);
    }
    
}
