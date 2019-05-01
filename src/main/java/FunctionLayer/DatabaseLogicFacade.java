package FunctionLayer;

import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import java.sql.SQLException;

/**
 * The purpose of LogicFacade is to...
 * 
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class DatabaseLogicFacade implements LogicFacade {

    public void addCustomer( Customer customer ) throws FogException, SQLException {
        UserMapper.addCustomer(customer);
    }

    public void createOrder( Carport carport, Customer customer ) throws FogException, SQLException {
        OrderMapper.makeOrder(carport, customer);
    }

    public double getMaterialPrice(String name) throws FogException {
        return OrderMapper.getMaterialPrice(name);
    }
    
}
