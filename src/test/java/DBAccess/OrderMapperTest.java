/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import DataLayer.Connector;
import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import FunctionLayer.Carport;
import PresentationLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mikkel
 */
public class OrderMapperTest {
    
    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "root";
    private static String DBNAME = "LegoHouse";
    private static String HOST = "localhost";

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test 
                Connector.setConnection( testConnection );
            }
//            // reset test database
//            try ( Statement stmt = testConnection.createStatement() ) {
//                stmt.execute( "drop table if exists Users" );
//                stmt.execute( "create table Users like UsersTest" );
//                stmt.execute( "insert into Users select * from UsersTest" );
//            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }
    
//    @Test
//    public void testCreateOrder() throws LoginSampleException {
//        // Can we create a new user - Notice, if login fails, this will fail
//        // but so would login01, so this is OK
//        Order original = new Order(1, 13, 9, 4);
//        OrderMapper.createOrder( original );
//        List<Order> orders = OrderMapper.getOrders( 1 );
//        Order retrieved = orders.get(0);
//        assertEquals(retrieved, original);
//    }
}
