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
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {
    
    private static final Logger logger = Logger.getLogger(OrderMapper.class.getName());

    /**
     * <p>This method executes a sql query to get the price of a material.
     * 
     * @param name
     * @return Price of the given material from the database as a double
     * @throws FogException
     * @throws SQLException 
     */
    public static double getMaterialPrice(String name) throws FogException, SQLException {
        double price = 0;
        try {
            String query = "SELECT MSRP FROM `FogCarport`.`materials` "
                    + "WHERE `materials`.`name` = ?;";

            try (Connection con = new Connector().connection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("MSRP");
            }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
        return price;
    }
    
    /**
     * <p>Deletes order from database.
     * 
     * @param id of the order which is wanted to be deleted.
     * @throws FogException 
     */
    public static void deleteOrder(int id) throws FogException {
        try {
            try (Connection con = new Connector().connection()) {
            String SQL =  "DELETE FROM `FogCarport`.`orders` WHERE `orders`.`orderId` = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
    }

    /**
     * <p>Creates an order in the database.
     * 
     * @param construction which holds the carport and totalprice.
     * @param customer infomation on customer.
     * @throws FogException 
     */
    public static void createOrder(Construction construction, Customer customer) throws FogException {
        try {
            try (Connection con = new Connector().connection()) {
            String SQL = "INSERT INTO `FogCarport`.`orders` (employeeId, customerId, carportHeight"
                    + ", carportLength, carportWidth, hasShed, shedWidth, hasRoof, roofType, roofAngle, hasWall, details, totalPrice) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 1);
            ps.setInt(2, customer.getId());
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
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
    }

    /**
     * Gets an Id that matches a material from the database.
     * 
     * @param name Of the material
     * @return int id
     * @throws FogException 
     */
    public static int getMaterialId(String name) throws FogException {
        int id = 0;
        try {
            String query = "SELECT materialID FROM `FogCarport`.`materials` "
                    + "WHERE `materials`.`name` = ?;";

            try (Connection con = new Connector().connection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("materialID");
            }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
        return id;
    }

    /**
     * <p>Gets the description of a material from the database.
     * 
     * @param name Of the material
     * @return String description of material
     * @throws FogException 
     */
    public static String getMaterialDescription(String name) throws FogException {
        String desc = "";
        try {
            String query = "SELECT description FROM `FogCarport`.`materials` "
                    + "WHERE `materials`.`name` = ?;";

            try (Connection con = new Connector().connection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                desc = rs.getString("description");
            }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
        return desc;
    }

    /**
     * Gets the cost price of a material from the database.
     * 
     * @param name Of the material
     * @return double cost price of material
     * @throws FogException 
     */
    public static double getCostPrice(String name) throws FogException {
        double price = 0;
        try {
            String query = "SELECT costPrice FROM `FogCarport`.`materials` "
                    + "WHERE `materials`.`name` = ?;";
            try (Connection con = new Connector().connection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("costPrice");
            }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
        return price;
    }

    /**
     * Gets a list of all materials in the database.
     * 
     * @return Arraylist of materials
     * @throws FogException 
     */
    public static List<Material> getAllMaterials() throws FogException {
        List<Material> materials = new ArrayList();
        try {
            String query = "SELECT * FROM FogCarport.materials";

            try (Connection con = new Connector().connection()) {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                materials.add(new Material(rs.getNString(2), rs.getInt(1), rs.getInt(5), "", rs.getDouble(3), rs.getDouble(4), rs.getNString(6)));
            }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
        return materials;
    }

    /**
     * Changes the price of the material with the given material id
     * 
     * @param newPrice which is the new value for the material
     * @param materialId id of the material which is wanted to change the price on.
     * @throws FogException 
     */
    public static void setMaterialPrice(double newPrice, int materialId) throws FogException {
        try {
            String query = "UPDATE `FogCarport`.`materials` SET `MSRP` = ? WHERE `materialID` = ?;";

            try (Connection con = new Connector().connection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, newPrice);
            ps.setInt(2, materialId);
            ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
    }
    
    /**
     * Changes the cost price of the material with the given material id
     * 
     * @param newPrice which is the new value for the material
     * @param materialId id of the material which is wanted to change the price on.
     * @throws FogException 
     */
    public static void setMaterialCostPrice(double newPrice, int materialId) throws FogException {
        try {
            String query = "UPDATE `FogCarport`.`materials` SET `costPrice` = ? WHERE `materialID` = ?;";

            try (Connection con = new Connector().connection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, newPrice);
            ps.setInt(2, materialId);
            ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
    }

    /**
     * Gets a list of all orders in the database.
     * 
     * @return Arraylist of orders
     * @throws FogException 
     */
    public static List<Order> getAllOrders() throws FogException {
        List<Order> orders = new ArrayList();
        try {
            String query = "SELECT * FROM FogCarport.`orders`;";
            
            try (Connection con = new Connector().connection()) {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Carport carport = new Carport(rs.getInt("carportHeight"), rs.getInt("carportLength"), rs.getInt("carportWidth"), rs.getBoolean("hasShed"), rs.getInt("shedWidth"), rs.getBoolean("hasRoof"), rs.getBoolean("roofType"), rs.getInt("roofAngle"), rs.getBoolean("hasWall"), rs.getNString("details"));
                orders.add(new Order(rs.getInt("orderId"), rs.getInt("employeeId"), rs.getInt("customerId"), carport, rs.getDouble("totalPrice")));
            }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new FogException( ex.getMessage() );
        }
        return orders;
    }
}
