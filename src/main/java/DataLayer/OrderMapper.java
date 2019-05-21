package DataLayer;

import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class OrderMapper {
    
    
    /** Returns the price of a material 
    * @param name
    * @return  */
    public static double getMaterialPrice(String name) throws FogException, SQLException {
            double price = 0;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = null;
        try {
            String query = "SELECT MSRP FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";

             conn = Connector.connection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("MSRP");
                return price;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        /*
        close connection and statements to prevent memoryleak 
        no need to close resultset since it closes with the preparedstatement
        */
        finally {
                if(ps != null) {
                    ps.close();
                }
                if(conn != null) {
                    conn.close();
                }
                
                
    }
    return 0;
    }
    public static void makeOrder( Construction construction, Customer customer ) throws FogException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `FogCarport`.`order` (employeeId, customerEmail, customerName, carportHeight"
                    + ", carportWidth, carportLength, hasRoof, hasShed, hasWall, totalPrice) VALUES (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1 , 1 );
            ps.setString( 2 , customer.getEmail() );
            ps.setString( 3 , customer.getName() );
            ps.setInt( 4 , construction.getCarport().getHeight() );
            ps.setInt( 5 , construction.getCarport().getWidth() );
            ps.setInt( 6 , construction.getCarport().getLength() );
            ps.setBoolean( 7 , construction.getCarport().hasPointyRoof() );
            ps.setBoolean( 8 , construction.getCarport().hasToolshed() );
            ps.setBoolean( 9 , construction.getCarport().hasWall() );
            ps.setDouble( 10 , construction.getTotalPrice());
            ps.executeUpdate();
        } catch ( SQLException ex ) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public static int getMaterialId(String name) throws FogException, SQLException {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = null;
            int id = 0;
        try {
            String query = "SELECT materialID FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";

            conn = Connector.connection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();


            if (rs.next()) {
                id = rs.getInt("materialID");
                return id;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        /*
        close connection and statements to prevent memoryleak 
        no need to close resultset since it closes with the preparedstatement
        */
        finally {
            if(ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
    }
        return 0;
        
        
    }

    public static String getMaterialDescription(String name) throws FogException, SQLException {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = null;
            String desc = "";
        try {
            String query = "SELECT description FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";

            conn = Connector.connection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                desc = rs.getString("description");
            }
            return desc;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        /*
        close connection and statements to prevent memoryleak 
        no need to close resultset since it closes with the preparedstatement
        */
        finally {
            if(ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
    }
        return "";
        
    }
    public static double getCostPrice(String name) throws FogException, SQLException {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = null;
            double price = 0;
        try {
            String query = "SELECT costPrice FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";

            conn = Connector.connection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("costPrice");
                return price;
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        /*
        close connection and statements to prevent memoryleak 
        no need to close ResultSet since it closes with the preparedstatement
        */
        finally {
            if(ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
    }
        return 0;
    }
    
    public static List<Material> getAllMaterials() throws FogException {
        List<Material> materials = new ArrayList();
        try {
            String query = "SELECT * FROM FogCarport.material";
            
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                materials.add(new Material(rs.getNString(2), rs.getInt(1), rs.getInt(5), "", rs.getDouble(3), rs.getDouble(4), rs.getNString(6)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return materials;
    }

    public static void setMaterialPrice(int materialId, double newPrice) throws FogException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String query = "UPDATE `FogCarport`.`material` SET `MSRP` = ? WHERE (`materialID` = ?);";

            conn = Connector.connection();
            ps.setDouble(1, newPrice);
            ps.setInt(2, materialId);
            ps = conn.prepareStatement(query);
            ps.execute();
            conn.commit();
        } catch (SQLException ex) {
            System.err.println(" Got an exception! ");
            System.err.println(ex.getMessage());
        }
    }
}
