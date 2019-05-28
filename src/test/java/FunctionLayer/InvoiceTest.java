/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import com.itextpdf.layout.Document;
import java.io.OutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikkel
 */
public class InvoiceTest {
    
    public InvoiceTest() {
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
     * Test of getCustomer method, of class Invoice.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        Invoice instance = null;
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrder method, of class Invoice.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        Invoice instance = null;
        Construction expResult = null;
        Construction result = instance.getOrder();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeInvoice method, of class Invoice.
     */
    @Test
    public void testMakeInvoice() throws Exception {
        System.out.println("makeInvoice");
        Customer customer = null;
        Construction order = null;
        OutputStream dest = null;
        Document expResult = null;
        Document result = Invoice.makeInvoice(customer, order, dest);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
