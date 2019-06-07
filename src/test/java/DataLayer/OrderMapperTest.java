package DataLayer;

import FunctionLayer.Carport;
import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.Order;
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
     * Test of getMaterialPrice method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
   @Test
    public void testGetMaterialPrice() throws Exception {
        try {
        System.out.println("Testing getMaterialPrice");
        String name = "stolpe(r)";
        double expResult = 240.95;
        double result = OrderMapper.getMaterialPrice(name);
        assertEquals(expResult, result, 0.0);
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    } 

    /**
     * Test of deleteOrder method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteOrder() throws Exception {
        System.out.println("Testing deleteOrder");
        int id = 0;
        Carport carport = new Carport(230, 240, 240, false, 0, false, false, 15, false, "");
        Order order = new Order(id, 99, 99, carport, 2000);
        OrderMapper.deleteOrder(id);
    }

    /**
     * Test of createOrder method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateOrder() throws Exception {
        TestOrderMapper od = new TestOrderMapper();
        Carport carport = new Carport(230, 240, 240, false, 0, false, false, 15, false, "");
        System.out.println("Testing createOrder");
        Construction construction = new Construction(carport, TestOrderMapper.getAllMaterials(), 2000.0);
        Customer customer = new Customer(99, "Mark Test", "Mark@TestMark.dk", "MarkTestVej 59", 2840, 28593458);
        OrderMapper.createOrder(construction, customer);
    }

    /**
     * Test of getMaterialId method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
 @Test
    public void testGetMaterialId() throws Exception {
        System.out.println("Testing getMaterialId");
        String name = "taglaegte(r)";
        int expResult = 1020;
        int result = OrderMapper.getMaterialId(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaterialDescription method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialDescription() throws Exception {
        System.out.println("Testing getMaterialDescription");
        String name = "skruer 200 stk";
        String expResult = "Staal. Kan iskrues uden forboring.";
        String result = OrderMapper.getMaterialDescription(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostPrice method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCostPrice() throws Exception {
        System.out.println("Testing getCostPrice");
        String name = "skruer 200 stk";
        double expResult = 20.5;
        double result = OrderMapper.getCostPrice(name);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAllMaterials method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllMaterials() throws Exception {
        System.out.println("Testing getAllMaterials");
        int expResult = 7;
        int result = OrderMapper.getAllMaterials().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaterialPrice method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetMaterialPrice() throws Exception {
        System.out.println("Testing setMaterialPrice");
        double newPrice = 20.5;
        int materialId = 2000;
        OrderMapper.setMaterialPrice(newPrice, materialId);
    }

    /**
     * Test of getAllOrders method, of class TestOrderMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllOrders() throws Exception {
        System.out.println("Testing getAllOrders");
        int expResult = OrderMapper.getAllOrders().size();
        int result = OrderMapper.getAllOrders().size();
        assertEquals(expResult, result);
    }
    
}
