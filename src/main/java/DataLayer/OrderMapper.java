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

            while ( rs.next() ) {
                String details = rs.getString("details");
                int price = rs.getInt("price");
                int id = rs.getInt("id");
                Carport standard = new Carport(id, price, false, details);
                standards.add(standard);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return standards;
    }
}
