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
<<<<<<< HEAD
    public static void createOrder( Carport carport, Customer customer ) throws FogException {
      //  OrderMapper.makeOrder(carport, customer);
    }
=======
//    public static void createOrder( Carport carport, String name, String email ) throws FogException {
//        OrderMapper.makeOrder(carport, name, email);
//    }
>>>>>>> 32ead7e3df45af3e0fe3beab9128df8894652c7b
    
    public static double getMaterialPrice(String name) throws FogException {
        return OrderMapper.getMaterialPrice(name);
    }
    
}
