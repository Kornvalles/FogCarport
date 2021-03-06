package DataLayer;

import FunctionLayer.FogException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mikkel
 */
public class TestConnector {

    //Constants
    private static final String IP = "165.227.175.89";
    private static final String PORT = "3306";

    /**
     *
     */
    public static final String DATABASE = "FogCarportTestDB";
    private static final String USERNAME = "FogGroup";
    private static final String PASSWORD = "FogCarport1234.";

    private static Connection singleton;

    /**
     *
     * @param con
     */
    public static void setConnection(Connection con) {
        singleton = con;
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws FogException
     */
    public static Connection connection() throws SQLException, FogException {
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
                props.put("autocommit", true);
                TestConnector.singleton = DriverManager.getConnection(url, props);
            } catch (ClassNotFoundException ex) {
                throw new SQLException(ex.getMessage());
            }
        }
        return singleton;
    }

}
