package DataLayer;

import FunctionLayer.FogException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    //Constants
    private static final String IP = "165.227.175.89";
    private static final String PORT = "3306";
    private static final String DATABASE = "FogCarport";
    private static final String USERNAME = "FogGroup";
    private static final String PASSWORD = "FogCarport1234.";

    private static Connection singleton;

    /**
     *
     * @param con
     */
    public static void setConnection( Connection con ) {
        singleton = con;
    }

    /**
     *
     * <p>
     * This method takes the constants and makes the connection to our database
     * using mySQL JDBC driver.
     *
     * @return A instance of Connection
     * @throws java.lang.ClassNotFoundException
     * @throws SQLException
     */
    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
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
            props.put("autocommit", true);
            Connector.singleton = DriverManager.getConnection(url, props);
        }
        return singleton;
    }
}
