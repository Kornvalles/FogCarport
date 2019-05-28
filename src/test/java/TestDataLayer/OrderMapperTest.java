/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataLayer;

import DataLayer.OrderMapper;
import DataLayer.TestOrderMapper;
import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.Material;
import FunctionLayer.Order;
import java.sql.SQLException;
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
     * Test of getMaterialPrice method, of class TestOrderMapper.
     */
   @Test
    public void testGetMaterialPrice() throws Exception {
        try {
        System.out.println("getMaterialPrice");
        String name = "stolpe(r)";
        double expResult = 240.95;
        double result = TestOrderMapper.getMaterialPrice(name);
        assertEquals(expResult, result, 0.0);
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    } 

    /**
     * Test of deleteOrder method, of class TestOrderMapper.
     */
    @Test
    public void testDeleteOrder() throws Exception {
        System.out.println("deleteOrder");
        int id = 0;
        TestOrderMapper.deleteOrder(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrder method, of class TestOrderMapper.
     */
    @Test
    public void testCreateOrder() throws Exception {
        System.out.println("createOrder");
        Construction construction = null;
        Customer customer = null;
        TestOrderMapper.createOrder(construction, customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterialId method, of class TestOrderMapper.
     */
 @Test
    public void testGetMaterialId() throws Exception {
        try{
        System.out.println("getMaterialId");
        String name = "taglaegte(r)";
        int expResult = 1020;
        int result = TestOrderMapper.getMaterialId(name);
        assertEquals(expResult, result);
    }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Test of getMaterialDescription method, of class TestOrderMapper.
     */
    @Test
    public void testGetMaterialDescription() throws Exception {
        try {
        System.out.println("getMaterialDescription");
        String name = "skruer 200 stk";
        String expResult = "Staal. Kan iskrues uden forboring.";
        String result = TestOrderMapper.getMaterialDescription(name);
        assertEquals(expResult, result);
    }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Test of getCostPrice method, of class TestOrderMapper.
     */
    @Test
    public void testGetCostPrice() throws Exception {
        System.out.println("getCostPrice");
        String name = "";
        double expResult = 0.0;
        double result = TestOrderMapper.getCostPrice(name);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllMaterials method, of class TestOrderMapper.
     */
    @Test
    public void testGetAllMaterials() throws Exception {
        System.out.println("getAllMaterials");
        List<Material> expResult = null;
        List<Material> result = TestOrderMapper.getAllMaterials();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaterialPrice method, of class TestOrderMapper.
     */
    @Test
    public void testSetMaterialPrice() throws Exception {
        System.out.println("setMaterialPrice");
        double newPrice = 0.0;
        int materialId = 0;
        TestOrderMapper.setMaterialPrice(newPrice, materialId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllOrders method, of class TestOrderMapper.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        System.out.println("getAllOrders");
        List<Order> expResult = null;
        List<Order> result = TestOrderMapper.getAllOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
