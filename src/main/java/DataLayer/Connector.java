package DataLayer;

import FunctionLayer.FogException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The purpose of Connector is to...
 *
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class Connector {

    //Constants
    private static final String IP = "localhost";
    private static final String PORT = "3306";
    public static final String DATABASE = "FogCarport";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static synchronized Connection connection() throws SQLException, FogException {
        if (singleton == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
                Properties props = new Properties();
                props.put("user", USERNAME);
                props.put("password", PASSWORD);
                props.put("allowMultiQueries", true);
                props.put("useUnicode", true);
                props.put("useJDBCCompliantTimezoneShift", true);
                props.put("useLegacyDatetimeCode", false);
                props.put("serverTimezone", "CET");
                Connector.singleton = DriverManager.getConnection(url, props);
            } catch (ClassNotFoundException ex) {
                throw new SQLException(ex.getMessage());
            }
        }
        return singleton;
    }

}
