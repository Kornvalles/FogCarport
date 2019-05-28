/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataLayer;

import FunctionLayer.Customer;
import FunctionLayer.Employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import DataLayer.Connector;
import DataLayer.UserMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Benjamin
 */
public class UserMapperTest {
    
    public UserMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addCustomer method, of class UserMapper.
     */
//    @Test
//    public void testAddCustomer(Customer customer) throws Exception {
//        Connection con = TestConnector.connection();
//            String SQL = "INSERT INTO `FogCarport`.`customer` ( name, email, address, zipcode, phoneNumber ) "
//                    + "VALUES (?, ?, ?, ?, ?);";
//            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, customer.getName());
//            ps.setString(2, customer.getEmail());
//            ps.setString(3, customer.getAddress());
//            ps.setInt(4, customer.getZipcode());
//            ps.setInt(5, customer.getPhoneNumber());
//            ps.executeUpdate();
//            System.out.println("Customer Created and added");
//    }

    /**
     * Test of login method, of class UserMapper.
     */

//    @Test
//    public void testLogin() throws Exception {
//        System.out.println("testingLogin");
//        String username = "Admin";
//        Employee expResult = new Employee("Admin","1234",true);
//        Employee result = TestUserMapper.getEmployee(username);
//        assertEquals(expResult.toString(), result.toString());
//    }

}
