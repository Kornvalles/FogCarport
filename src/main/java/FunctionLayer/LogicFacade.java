package FunctionLayer;

import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static List<User> getUsers() throws LoginSampleException {
        return UserMapper.getUsers();
    }
    
    public static void createOrder( int id, int length, int width, int height ) throws LoginSampleException {
        Order order = new Order(id, length, width, height);
        OrderMapper.createOrder( order );
    }

    public static List<Order> getOrders( int id ) throws LoginSampleException  {
        return OrderMapper.getOrders(id);
    }
    
    public static boolean shipOrder( Order order ) throws LoginSampleException {
        return OrderMapper.shipOrder(order);
    }
    
}
