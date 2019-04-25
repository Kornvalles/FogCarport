package DataLayer;

import FunctionLayer.Carport;
import FunctionLayer.FogException;
import PresentationLayer.Order;
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
     * @throws FunctionLayer.FogException
     */
    public static List<Carport> getStandard() throws FogException {
        List<Carport> standards = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM `carport`.`standard`;";

            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                String details = rs.getString("details");
                int price = rs.getInt("price");
                int id = rs.getInt("id");
                Carport standard = new Carport(id, false, details, price);
                standards.add(standard);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return standards;
    }

    public static Order makeOrder( Carport carport ) throws FogException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (details, price) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, carport.getDetails() );
            ps.setInt( 2, carport.getPrice() );
            ps.executeUpdate();
        } catch ( SQLException ex ) {
            throw new FogException( ex.getMessage() );
        }
        return null;
    }
}
