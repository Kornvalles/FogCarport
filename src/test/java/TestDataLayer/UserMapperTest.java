/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataLayer;

import DataLayer.TestConnector;
import DataLayer.TestUserMapper;
import FunctionLayer.Customer;
import FunctionLayer.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        Employee testEmp = new Employee(99, "testEmp", "1234", false);
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of addCustomer method, of class UserMapper.
     */
@Test
    public void testAddCustomer(Customer customer) throws Exception {
        Connection con = TestConnector.connection();
        System.out.println("testing addcustomer");
            String SQL = "INSERT INTO `FogCarport`.`customer` ( name, email, address, zipcode, phoneNumber ) "
                    + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getZipcode());
            ps.setInt(5, customer.getPhoneNumber());
            ps.executeUpdate();
            System.out.println("Customer Created and added");
    }
    /**
     * Test of addEmployee method, of class UserMapper.
     */
    @Test
    public void testAddEmployee(Employee employee) throws Exception {
        Connection con = TestConnector.connection();
        System.out.println("testing addEmployee");
        String SQL = "INSERT INTO `FogCarport`.`employee` ( name, password, isAdmin) "
                    + "VALUES (?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, employee.getUsername());
        ps.setString(2, employee.getPassword());
        ps.setBoolean(3, employee.isAdmin());
        ps.executeUpdate();
        System.out.println("Employee created and added.");
    }

    /**
     * Test of getAllCustomers method, of class UserMapper. 
     * basically just making sure the right amount of customers are in the database.
     * This can definitely be better
     */
    @Test
    public void testGetAllCustomers() throws Exception {
        System.out.println("Testing getAllCustomers");
        int expResult = 3;
        int result = TestUserMapper.getAllCustomers().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployee method, of class UserMapper.
     */
    @Test
    public void testGetEmployee(Employee employee) throws Exception {
        System.out.println("getEmployee");
        int id = 1;
        Employee expResult = new Employee(1, "Admin", "1234", true);
        Employee result = TestUserMapper.getEmployee(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteEmployee method, of class UserMapper.
     */
    @Test
    public void testDeleteEmployee() throws Exception {
        System.out.println("Testing deleteEmployee");
        int id = 99;
        TestUserMapper.deleteEmployee(id);
    }

    /**
     * Test of getAllEmployees method, of class UserMapper.
     */
    @Test
    public void testGetAllEmployees() throws Exception {
        System.out.println("getAllEmployees");
        int expResult = 2;
        int result = TestUserMapper.getAllEmployees().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmployee method, of class UserMapper.
     */
//    @Test
//    public void testSetEmployee() throws Exception {
//        System.out.println("Testing setEmployee");
//        int id = 0;
//        String username = "";
//        String password = "";
//        boolean isAdmin = false;
//        Employee expResult = null;
//        Employee result = TestUserMapper.setEmployee(id, username, password, isAdmin);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    @Test
    public void testLogin() throws Exception {
        System.out.println("testingLogin");
        int id = 1;
        Employee expResult = new Employee("Admin","1234",true);
        Employee result = TestUserMapper.getEmployee(id);
        assertEquals(expResult.toString(), result.toString());
    }
}
