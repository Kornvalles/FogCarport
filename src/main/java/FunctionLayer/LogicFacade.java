package FunctionLayer;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ibenk
 */
public interface LogicFacade {
    
    Customer addCustomer( String name, String email, String address, int zipcode, int phoneNumber ) throws FogException, SQLException;
    
    List<Customer> getAllCustomers() throws FogException;

    void createOrder( Construction construction, Customer customer ) throws FogException, SQLException;
    
    List<Order> getAllOrders() throws FogException, SQLException;

    double getMaterialPrice( String name ) throws FogException, SQLException;
    
    double getMaterialCostPrice( String name ) throws FogException, SQLException;
    
    int getMaterialId( String name ) throws FogException, SQLException;
    
    String getMaterialDescription( String name ) throws FogException, SQLException;
    
    List<Material> getAllMaterials() throws FogException, SQLException;
    
    void setMaterialPrice( int materialId, double newPrice ) throws FogException, SQLException;
    
    Employee addEmployee( Employee newEmployee ) throws FogException, SQLException;
    
    Employee getEmployee( int id ) throws FogException;
    
    Employee setEmployee( int id, String username, String password, boolean isAdmin ) throws FogException;
    
    List<Employee> getAllEmployees() throws FogException;
    
    void deleteEmployee( int id ) throws FogException;
    
    void deleteOrder( int id ) throws FogException;
    
}
