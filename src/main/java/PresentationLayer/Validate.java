/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ndupo
 */
class Validate {

    static boolean checkEmployee(String username, String password) {
        boolean st =false;
      try{

	 Connection con = Connector.connection();
         PreparedStatement ps =con.prepareStatement
                             ("select * from emplyee where name=? and password=?");
         ps.setString(1, username);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;       
    }
    
}
