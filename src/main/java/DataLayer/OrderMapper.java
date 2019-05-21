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
            PreparedStatement preparedstatement = null;
            double price = 0;
        try {
            String query = "SELECT MSRP FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";

            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("MSRP");
                return price;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        finally {
            if(preparedstatement != null) {
                preparedstatement.close();
            }
    }
    return 0;
    }
    public static void createOrder( Construction construction, Customer customer ) throws FogException {
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
    public static double getCostPrice(String name) throws FogException {
        try {
            String query = "SELECT costPrice FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = '" + name + "';";

            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            double price = 0;

            while (rs.next()) {
                price = rs.getDouble("costPrice");
            }
            return price;
            
        } catch (SQLException ex) {
            System.out.println(ex);
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
        try {
            String query = "UPDATE `FogCarport`.`material` SET `MSRP` = '" + newPrice + "' WHERE (`materialID` = '" + materialId + "');";
            
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            
            con.commit();
        } catch (SQLException ex) {
            System.err.println(" Got an exception! ");
            System.err.println(ex.getMessage());
        }
    }
}
