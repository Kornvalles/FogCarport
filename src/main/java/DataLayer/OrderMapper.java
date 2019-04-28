package DataLayer;

import FunctionLayer.FogException;
import java.sql.Connection;
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
            String query = "SELECT price FROM `carport`.`material` "
                    + "WHERE `carport`.`material`.`name` = '" + name + "';";

            Connection connection = Connector.connection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            double price = 0;

            while (rs.next()) {
                price = rs.getDouble("price");
            }
            return price;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;
    }
    
//    public static List<Carport> getStandard() throws FogException {
//        List<Carport> standards = new ArrayList<>();
//        try {
//            String SQL = "SELECT * FROM `fog`.`carport`;";
//
//            Connection con = Connector.connection();
//            PreparedStatement ps = con.prepareStatement( SQL );
//            ResultSet rs = ps.executeQuery(SQL);
//
//            while ( rs.next() ) {
//                String details = rs.getString("details");
//                int price = rs.getInt("price");
//                int id = rs.getInt("id");
//                Carport standard = new Carport(id, false, details, price);
//                standards.add(standard);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return standards;
//    }
//
//    public static void makeOrder(Carport carport, Customer customer ) throws FogException {
//        try {
//            Connection con = Connector.connection();
//            String SQL = "INSERT INTO orders (details, price) VALUES (?, ?)";
//            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
//            ps.setString( 1, carport.getDetails() );
//            ps.setInt( 2, carport.getPrice() );
//            ps.executeUpdate();
//        } catch ( SQLException ex ) {
//            throw new FogException( ex.getMessage() );
//        }
//    }
}
