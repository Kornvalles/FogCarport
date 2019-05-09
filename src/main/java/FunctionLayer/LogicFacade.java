package FunctionLayer;

import java.sql.SQLException;
import com.itextpdf.layout.Document;

/**
 *
 * @author ibenk
 */
public interface LogicFacade {
    
    void addCustomer( Customer customer ) throws FogException, SQLException ;

    void createOrder( Carport carport, Customer customer ) throws FogException, SQLException ;

    double getMaterialPrice( String name ) throws FogException, SQLException ;
    
    Document makeInvoice( Customer customer, Construction costruction ) throws FogException;
    
}
