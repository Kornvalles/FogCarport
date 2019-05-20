package FunctionLayer;

import java.sql.SQLException;

/**
 *
 * @author ibenk
 */
public interface LogicFacade {
    
    void addCustomer( Customer customer ) throws FogException, SQLException ;

    void createOrder( Construction construction, Customer customer ) throws FogException, SQLException ;

    double getMaterialPrice( String name ) throws FogException, SQLException ;
    
    int getMaterialId( String name ) throws FogException, SQLException ;
    
    String getMaterialDescription( String name ) throws FogException, SQLException ;
    
    Employee login(String username, String password) throws FogException;
    
}
