/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.sql.SQLException;

/**
 *
 * @author ibenk
 */
public interface LogicFacade {
    
    void addCustomer( Customer customer ) throws FogException, SQLException ;

    void createOrder( Carport carport, Customer customer ) throws FogException, SQLException ;

    double getMaterialPrice(String name) throws FogException ;
    
}
