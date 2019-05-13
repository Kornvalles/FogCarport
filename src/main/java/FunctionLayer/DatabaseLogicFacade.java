package FunctionLayer;

import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import com.itextpdf.layout.Document;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The purpose of LogicFacade is to...
 * 
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class DatabaseLogicFacade implements LogicFacade {

    /**
     *
     * @param customer
     * @throws FogException
     * @throws SQLException
     */
    @Override
    public void addCustomer( Customer customer ) throws FogException, SQLException {
        UserMapper.addCustomer(customer);
    }

    /**
     *
     * @param carport
     * @param customer
     * @throws FogException
     * @throws SQLException
     */
    @Override
    public void createOrder( Carport carport, Customer customer ) throws FogException, SQLException {
        OrderMapper.makeOrder(carport, customer);
    }

    /**
     *
     * @param name
     * @return
     * @throws FogException
     * @throws SQLException
     */
    @Override
    public double getMaterialPrice(String name) throws FogException, SQLException {
        return OrderMapper.getMaterialPrice(name);
    }

    @Override
    public Invoice makeInvoice(Customer customer, Construction costruction) throws FogException, IOException {
        Invoice invoice = new Invoice(customer, costruction);
        invoice.makeInvoice(customer, costruction);
        return invoice;
    }

    @Override
    public void getEmployee(Employee employee) throws FogException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
