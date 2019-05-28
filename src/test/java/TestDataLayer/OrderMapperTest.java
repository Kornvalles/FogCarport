/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataLayer;

import DataLayer.OrderMapper;
import java.sql.SQLException;
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
public class OrderMapperTest {
    
    public OrderMapperTest() {
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
     * Test of getMaterialPrice method, of class OrderMapper.
     
    @Test
    public void testGetMaterialPrice() throws Exception {
        try {
        System.out.println("getMaterialPrice");
        String name = "stolpe(r)";
        double expResult = 240.95;
        double result = OrderMapper.getMaterialPrice(name);
        assertEquals(expResult, result, 0.0);
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    } */

    /**
     * Test of makeOrder method, of class OrderMapper.
     */
//    @Test
//    public void testMakeOrder() throws Exception {
//        System.out.println("makeOrder");
//        Carport carport = null;
//        Customer customer = null;
//        OrderMapper.makeOrder(carport, customer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getMaterialId method, of class OrderMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialId() throws Exception {
        try{
        System.out.println("getMaterialId");
        String name = "taglaegte(r)";
        int expResult = 1020;
        int result = OrderMapper.getMaterialId(name);
        assertEquals(expResult, result);
    }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    /**
     * Test of getMaterialDescription method, of class OrderMapper.
     */
    @Test
    public void testGetMaterialDescription() throws Exception {
        try {
        System.out.println("getMaterialDescription");
        String name = "skruer 200 stk";
        String expResult = "Staal. Kan iskrues uden forboring.";
        String result = OrderMapper.getMaterialDescription(name);
        assertEquals(expResult, result);
    }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
