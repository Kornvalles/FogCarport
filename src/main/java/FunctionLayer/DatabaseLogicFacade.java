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
    public void setMaterialPrice( int materialId, double newPrice ) throws FogException, SQLException {
        OrderMapper.setMaterialPrice(newPrice, materialId );
    }

    @Override
    public Employee addEmployee( Employee newEmployee ) throws FogException, SQLException {
        return UserMapper.addEmployee(newEmployee);
    }
    
    @Override
    public Employee getEmployee( String username ) throws FogException {
        return UserMapper.getEmployee(username);
    }
    
    @Override
    public void deleteOrder( int id ) throws FogException {
        OrderMapper.deleteOrder(id);
    }
}
