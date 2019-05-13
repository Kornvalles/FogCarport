package FunctionLayer;

import java.sql.SQLException;
import java.io.IOException;

/**
 *
 * @author ibenk
 */
public interface LogicFacade {
    
    void addCustomer( Customer customer ) throws FogException, SQLException ;

    void createOrder( Carport carport, Customer customer ) throws FogException, SQLException ;

    double getMaterialPrice( String name ) throws FogException, SQLException ;
    
    void getEmployee( Employee employee ) throws FogException, SQLException ;
    
    Invoice makeInvoice( Customer customer, Construction costruction ) throws FogException, IOException ;
    
}
