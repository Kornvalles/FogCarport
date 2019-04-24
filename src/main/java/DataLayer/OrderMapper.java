package DataLayer;

import FunctionLayer.Carport;
import java.sql.Connection;
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
     * @return  */
    public List<Carport> getStandard() throws ClassNotFoundException {
        try {
            conn = new Connector();

            String query = "SELECT * FROM `Carport`.`standard`;";

            Connection connection = conn.connection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<Carport> standards = new ArrayList<>();
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
