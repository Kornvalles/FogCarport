package FunctionLayer;

import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import java.sql.SQLException;
import java.util.List;

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
    public double getMaterialCostPrice( String name ) throws FogException, SQLException {
        return OrderMapper.getCostPrice(name);
    }
    
    /**
     *
     * @param customer
     * @param costruction
     * @return
     * @throws FogException
     * @throws IOException
     */
//    @Override
//    public Document makeInvoice(Customer customer, Construction costruction) throws FogException, IOException {
//        Invoice invoice = new Invoice(customer, costruction);
//        return invoice.makeInvoice(customer, costruction, );
//    }
    
    /**
     *
     * @param name
     * @return 
     * @throws FogException
     * @throws SQLException
     */
    @Override
    public int getMaterialId(String name) throws FogException, SQLException {
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
    public String getMaterialDescription(String name) throws FogException, SQLException {
        return OrderMapper.getMaterialDescription(name);
    }
    
    @Override
    public List<Material> getAllMaterials() throws FogException, SQLException {
        return OrderMapper.getAllMaterials();
    }
    
    @Override
    public void setMaterialPrice(int materialId, double newPrice) throws FogException, SQLException {
        OrderMapper.setMaterialPrice(materialId, newPrice);
    }

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws FogException
     */
    @Override
    public Employee login(String username, String password) throws FogException {
        return UserMapper.login(username, password);
    }
}
