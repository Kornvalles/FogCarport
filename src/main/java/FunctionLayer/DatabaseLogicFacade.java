package FunctionLayer;

import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import java.sql.SQLException;
import java.util.List;

public class DatabaseLogicFacade implements LogicFacade {

    
    @Override
    public Customer addCustomer( String name, String email, String address, int zipcode, int phoneNumber ) throws FogException, SQLException {
        return UserMapper.addCustomer(name, email, address, zipcode, phoneNumber);
    }
    
    @Override
    public List<Customer> getAllCustomers() throws FogException {
        return UserMapper.getAllCustomers();
    }

    @Override
    public void createOrder( Construction construction, Customer customer ) throws FogException, SQLException {
        OrderMapper.createOrder(construction, customer);
    }
    
    @Override
    public List<Order> getAllOrders() throws FogException, SQLException {
        return OrderMapper.getAllOrders();
    }

    @Override
    public double getMaterialPrice( String name ) throws FogException, SQLException {
        return OrderMapper.getMaterialPrice(name);
    }
    
    @Override
    public double getMaterialCostPrice( String name ) throws FogException, SQLException {
        return OrderMapper.getCostPrice(name);
    }
    
    @Override
    public int getMaterialId( String name ) throws FogException, SQLException {
        return OrderMapper.getMaterialId(name);
    }

    @Override
    public String getMaterialDescription( String name ) throws FogException, SQLException {
        return OrderMapper.getMaterialDescription(name);
    }
    
    @Override
    public List<Material> getAllMaterials() throws FogException, SQLException {
        return OrderMapper.getAllMaterials();
    }
    
    @Override
    public void setMaterialPrice( int id, double newPrice ) throws FogException, SQLException {
        OrderMapper.setMaterialPrice(newPrice, id);
    }

    @Override
    public Employee addEmployee( Employee newEmployee ) throws FogException, SQLException {
        return UserMapper.addEmployee(newEmployee);
    }
    
    @Override
    public Employee getEmployee( int id ) throws FogException {
        return UserMapper.getEmployee(id);
    }
    
    @Override
    public void deleteEmployee( int id ) throws FogException {
        UserMapper.deleteEmployee(id);
    }
    
    @Override
    public void deleteOrder( int id ) throws FogException {
        OrderMapper.deleteOrder(id);
    }

    @Override
    public List<Employee> getAllEmployees() throws FogException {
        return UserMapper.getAllEmployees();
    }

    @Override
    public Employee setEmployee(int id, String username, String password, boolean isAdmin) throws FogException {
        return UserMapper.setEmployee(id, username, password, isAdmin);
    }

    @Override
    public void setMaterialCostPrice(int id, double newPrice) throws FogException {
        OrderMapper.setMaterialCostPrice(newPrice, id);
    }

    
}
