package DataLayer;

import FunctionLayer.Carport;
import FunctionLayer.FogException;
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
//establish database connection
    
    private Connector conn;
    
/** Returns a list of all toppings
     * @return
     * @throws java.lang.ClassNotFoundException  
     */
    public static List<Carport> getStandard() throws ClassNotFoundException {
        List<Carport> standards = new ArrayList<>();
        try {

            String SQL = "SELECT * FROM `Carport`.`standard`;";

            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();

            int id = 0;
            String details = "";
            int price = 0;

            while (rs.next()) {
                details = rs.getString("details");
                price = rs.getInt("price");
                id = rs.getInt("id");
                Carport standard = new Carport(id, price, false, details);
                standards.add(standard);
            }
            return standards;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
