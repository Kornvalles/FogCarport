package FunctionLayer;

import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mikkel
 */
public class DatabaseLogicFacade implements LogicFacade {

    /**
     * 
     * @param name 
     * @param email
     * @param address
     * @param zipcode
     * @param phoneNumber
     * @return
     * @throws FogException
     * @throws SQLException 
     */
    @Override
    public Customer addCustomer( String name, String email, String address, int zipcode, int phoneNumber ) throws FogException, SQLException {
        return UserMapper.addCustomer(name, email, address, zipcode, phoneNumber);
    }
    
    /**
     * 
     * @return
     * @throws FogException 
     */
    @Override
    public List<Customer> getAllCustomers() throws FogException {
        return UserMapper.getAllCustomers();
    }
    
    /**
     * 
     * @param construction
     * @param customer
     * @throws FogException
     * @throws SQLException 
     */
    @Override
    public void createOrder( Construction construction, Customer customer ) throws FogException, SQLException {
        OrderMapper.createOrder(construction, customer);
    }
    /**
     * 
     * @return
     * @throws FogException
     * @throws SQLException 
     */
    @Override
    public List<Order> getAllOrders() throws FogException, SQLException {
        return OrderMapper.getAllOrders();
    }

    /**
     * 
     * @param name
     * @return
     * @throws FogException
     * @throws SQLException 
     */
    @Override
    public double getMaterialPrice( String name ) throws FogException, SQLException {
        return OrderMapper.getMaterialPrice(name);
    }
    
    /**
     * 
     * @param name
     * @return
     * @throws FogException
     * @throws SQLException 
     */
    @Override
    public double getMaterialCostPrice( String name ) throws FogException, SQLException {
        return OrderMapper.getCostPrice(name);
    }
    
    /**
     * 
     * @param name
     * @return
     * @throws FogException
     * @throws SQLException 
     */
    @Override
    public int getMaterialId( String name ) throws FogException, SQLException {
        return OrderMapper.getMaterialId(name);
    }
     /**
      * 
      * @param name
      * @return
      * @throws FogException
      * @throws SQLException 
      */
    @Override
    public String getMaterialDescription( String name ) throws FogException, SQLException {
        return OrderMapper.getMaterialDescription(name);
    }
     /**
      * 
      * @return
      * @throws FogException
      * @throws SQLException 
      */
    @Override
    public List<Material> getAllMaterials() throws FogException, SQLException {
        return OrderMapper.getAllMaterials();
    }
    
    /**
     * 
     * @param id
     * @param newPrice
     * @throws FogException
     * @throws SQLException 
     */
    @Override
    public void setMaterialPrice( int id, double newPrice ) throws FogException, SQLException {
        OrderMapper.setMaterialPrice(newPrice, id);
    }

    /**
     * 
     * @param newEmployee
     * @return
     * @throws FogException
     * @throws SQLException 
     */
    @Override
    public Employee addEmployee( Employee newEmployee ) throws FogException, SQLException {
        return UserMapper.addEmployee(newEmployee);
    }
    
    /**
     * 
     * @param id
     * @return
     * @throws FogException 
     */
    @Override
    public Employee getEmployee( int id ) throws FogException {
        return UserMapper.getEmployee(id);
    }
    
    /**
     * 
     * @param id
     * @throws FogException 
     */
    @Override
    public void deleteEmployee( int id ) throws FogException {
        UserMapper.deleteEmployee(id);
    }
    
    /**
     * 
     * @param id
     * @throws FogException 
     */
    @Override
    public void deleteOrder( int id ) throws FogException {
        OrderMapper.deleteOrder(id);
    }
    
    /**
     * 
     * @return
     * @throws FogException 
     */
    @Override
    public List<Employee> getAllEmployees() throws FogException {
        return UserMapper.getAllEmployees();
    }

    /**
     * 
     * @param id
     * @param username
     * @param password
     * @param isAdmin
     * @return
     * @throws FogException 
     */
    @Override
    public Employee setEmployee(int id, String username, String password, boolean isAdmin) throws FogException {
        return UserMapper.setEmployee(id, username, password);
    }

    /**
     * 
     * @param id
     * @param newPrice
     * @throws FogException 
     */
    @Override
    public void setMaterialCostPrice(int id, double newPrice) throws FogException {
        OrderMapper.setMaterialCostPrice(newPrice, id);
    }

    
}
