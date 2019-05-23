package DataLayer;

import FunctionLayer.Carport;
import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.Material;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static double getMaterialPrice(String name) throws FogException, SQLException {
        double price = 0;
        try {
            String query = "SELECT MSRP FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";

            Connection conn = Connector.connection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("MSRP");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return price;
    }

    public static void createOrder(Construction construction, Customer customer) throws FogException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `FogCarport`.`order` (employeeId, customerId, carportHeight"
                    + ", carportLength, carportWidth, hasShed, shedWidth, hasRoof, roofType, roofAngle, hasWall, details, totalPrice) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 1);
            ps.setInt(2, 1);
            ps.setInt(3, construction.getCarport().getHeight());
            ps.setInt(4, construction.getCarport().getLength());
            ps.setInt(5, construction.getCarport().getWidth());
            ps.setBoolean(6, construction.getCarport().hasToolshed());
            ps.setInt(7, construction.getCarport().getShedWidth());
            ps.setBoolean(8, construction.getCarport().hasPointyRoof());
            ps.setBoolean(9, construction.getCarport().roofType());
            ps.setInt(10, construction.getCarport().getRoofAngle());
            ps.setBoolean(11, construction.getCarport().hasWall());
            ps.setString(12, construction.getCarport().getDetails());
            ps.setDouble(13, construction.getTotalPrice());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public static int getMaterialId(String name) throws FogException, SQLException {
        int id = 0;
        try {
            String query = "SELECT materialID FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";

            Connection conn = Connector.connection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("materialID");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public static String getMaterialDescription(String name) throws FogException, SQLException {
        String desc = "";
        try {
            String query = "SELECT description FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";

            Connection conn = Connector.connection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                desc = rs.getString("description");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return desc;
    }

    public static double getCostPrice(String name) throws FogException, SQLException {
        double price = 0;
        try {
            String query = "SELECT costPrice FROM `FogCarport`.`material` "
                    + "WHERE `material`.`name` = ?;";
            Connection conn = Connector.connection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("costPrice");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return price;
    }

    public static List<Material> getAllMaterials() throws FogException {
        List<Material> materials = new ArrayList();
        try {
            String query = "SELECT * FROM FogCarport.material";

            Connection con = Connector.connection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
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

            Connection conn = Connector.connection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(" Got an exception! ");
            System.err.println(ex.getMessage());
        }
    }

    public static List<Order> getAllOrders() throws FogException {
        List<Order> orders = new ArrayList();
        try {
            String query = "SELECT * FROM FogCarport.`order`;";
            
            Connection con = Connector.connection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Carport carport = new Carport(rs.getInt("carportHeight"), rs.getInt("carportLength"), rs.getInt("carportWidth"), rs.getBoolean("hasShed"), rs.getInt("shedWidth"), rs.getBoolean("hasRoof"), rs.getBoolean("roofType"), rs.getInt("roofAngle"), rs.getBoolean("hasWall"), rs.getNString("details"));
                orders.add(new Order(rs.getInt("orderId"), rs.getInt("employeeId"), rs.getInt("customerId"), carport, rs.getDouble("totalPrice")));
            }
        } catch (SQLException ex) {
            System.err.println(" Got an exception! ");
            System.err.println(ex.getMessage());
        }
        return orders;
    }
}
