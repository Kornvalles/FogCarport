package FunctionLayer;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ibenk
 */
public interface LogicFacade {
    
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
    Customer addCustomer( String name, String email, String address, int zipcode, int phoneNumber ) throws FogException, SQLException;
    
    /**
     *
     * @return
     * @throws FogException
     */
    List<Customer> getAllCustomers() throws FogException;

    /**
     *
     * @param construction
     * @param customer
     * @throws FogException
     * @throws SQLException
     */
    void createOrder( Construction construction, Customer customer ) throws FogException, SQLException;
    
    /**
     *
     * @return
     * @throws FogException
     * @throws SQLException
     */
    List<Order> getAllOrders() throws FogException, SQLException;

    /**
     *
     * @param name
     * @return
     * @throws FogException
     * @throws SQLException
     */
    double getMaterialPrice( String name ) throws FogException, SQLException;
    
    /**
     *
     * @param name
     * @return
     * @throws FogException
     * @throws SQLException
     */
    double getMaterialCostPrice( String name ) throws FogException, SQLException;
    
    /**
     *
     * @param name
     * @return
     * @throws FogException
     * @throws SQLException
     */
    int getMaterialId( String name ) throws FogException, SQLException;
    
    /**
     *
     * @param name
     * @return
     * @throws FogException
     * @throws SQLException
     */
    String getMaterialDescription( String name ) throws FogException, SQLException;
    
    /**
     *
     * @return
     * @throws FogException
     * @throws SQLException
     */
    List<Material> getAllMaterials() throws FogException, SQLException;
    
    /**
     *
     * @param id
     * @param newPrice
     * @throws FogException
     * @throws SQLException
     */
    void setMaterialPrice( int id, double newPrice ) throws FogException, SQLException;
    
    /**
     *
     * @param newEmployee
     * @return
     * @throws FogException
     * @throws SQLException
     */
    Employee addEmployee( Employee newEmployee ) throws FogException, SQLException;
    
    /**
     *
     * @param id
     * @return
     * @throws FogException
     */
    Employee getEmployee( int id ) throws FogException;
    
    /**
     *
     * @param id
     * @param username
     * @param password
     * @param isAdmin
     * @return
     * @throws FogException
     */
    Employee setEmployee( int id, String username, String password, boolean isAdmin ) throws FogException;
    
    /**
     *
     * @return
     * @throws FogException
     */
    List<Employee> getAllEmployees() throws FogException;
    
    /**
     *
     * @param id
     * @throws FogException
     */
    void deleteEmployee( int id ) throws FogException;
    
    /**
     *
     * @param id
     * @throws FogException
     */
    void deleteOrder( int id ) throws FogException;

    /**
     *
     * @param id
     * @param newPrice
     * @throws FogException
     */
    public void setMaterialCostPrice(int id, double newPrice) throws FogException;
    
}
