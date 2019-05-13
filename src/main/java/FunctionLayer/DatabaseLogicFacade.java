package FunctionLayer;

import DataLayer.Connector;
import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import com.itextpdf.layout.Document;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void addCustomer(Customer customer) throws FogException, SQLException {
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
    public void createOrder(Carport carport, Customer customer) throws FogException, SQLException {
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
        UserMapper.getEmployee(employee);
    }

    @Override
    public boolean checkEmployee(String username, String password) throws FogException, SQLException {
        boolean st =false;
      try{

	 Connection con = Connector.connection();
         PreparedStatement ps =con.prepareStatement
                             ("select * from emplyee where name=? and password=?");
         ps.setString(1, username);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;     
    }
    
}
