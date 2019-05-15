package DataLayer;

import FunctionLayer.Carport;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class OrderMapper {

    
    
    /** Returns the price of a material 
    * @param name
    * @return  */
    public static double getMaterialPrice(String name) throws FogException {
        try {
            String query = "SELECT MSRP FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = '" + name + "';";

            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            double price = 0;

            while (rs.next()) {
                price = rs.getDouble("MSRP");
            }
            return price;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;
    }
    
    public static void makeOrder(Carport carport, Customer customer ) throws FogException, SQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `FogCarport`.`order` (employeeId, customerEmail, customerName, carportHeight"
                    + ", carportWidth, carportLength, hasRoof, hasShed, hasWall, totalPrice) VALUES (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1 , 1 );
            ps.setString( 2 , customer.getEmail() );
            ps.setString( 3 , customer.getName() );
            ps.setInt( 4 , carport.getHeight() );
            ps.setInt( 5 , carport.getWidth() );
            ps.setInt( 6 , carport.getLength() );
            ps.setBoolean( 7 , carport.hasPointyRoof() );
            ps.setBoolean( 8 , carport.hasToolshed() );
            ps.setBoolean( 9 , carport.hasWall() );
            ps.setDouble( 10 , 0);
            ps.executeUpdate();
        } catch ( SQLException ex ) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public static int getMaterialId(String name) throws FogException {
        try {
            String query = "SELECT materialID FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = '" + name + "';";

            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int id = 0;

            while (rs.next()) {
                id = rs.getInt("materialID");
            }
            return id;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;
        
        
    }

    public static String getMaterialDescription(String name) throws FogException {
        
        try {
            String query = "SELECT description FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = '" + name + "';";

            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            String desc = "";

            while (rs.next()) {
                desc = rs.getString("description");
            }
            return desc;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "";
        
    }
}
