/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

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
public class CalculatorTest {
    
    public CalculatorTest() {
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
     * Test of getAllPosts method, of class Calculator.
     */
    @Test
    public void testGetAllPosts() {
        System.out.println("getAllPosts");
        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");
        int expResult = 10;
        int result = Calculator.getAllPosts(carport);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostsOnLongside method, of class Calculator.
     */
    @Test
    public void testGetPostsOnLongside() {
        System.out.println("getPostsOnLongside");
        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");
        int expResult = 2;
        int result = Calculator.getPostsOnLongside(carport);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getPostsOnBackside method, of class Calculator.
//     */
    @Test
    public void testGetPostsOnBackside() {
        System.out.println("getPostsOnBackside");
        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");
        int expResult = 2;
        int result = Calculator.getPostsOnBackside(carport);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getRoof method, of class Calculator.
//     */
//    @Test
//    public void testGetRoof() {
//        System.out.println("getRoof");
//        Carport carport = null;
//        int expResult = 0;
//        int result = Calculator.getRoof(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of calcMaterial method, of class Calculator.
//     */
    /*
    Virker ikke TODO forstår ikke helt metoden.
    */
//    @Test
//    public void testCalcMaterial() {
//        System.out.println("calcMaterial");
//        int input1 = 240;
//        int input2 = 240;
//        int materialLength = 100;
//        int materialWidth = 10;
//        int expResult = 138;
//        int result = Calculator.calcMaterial(input1, input2, materialLength, materialWidth);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getSides method, of class Calculator.
//     */
    @Test
    public void testGetSides() {
        System.out.println("getSides");
        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");
        int expResult = 165;
        int result = Calculator.getSides(carport);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of makeShed method, of class Calculator.
//     */
    @Test
    public void testMakeShed() {
        System.out.println("makeShed");
        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");
        int expResult = 55;
        int result = Calculator.makeShed(carport);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getRoofBattens method, of class Calculator.
//     */
    @Test
    public void testGetRoofBattens() {
        System.out.println("getRoofBattens");
        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");;
        int expResult = 480;
        int result = Calculator.getRoofBattens(carport);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getSideBattens method, of class Calculator.
//     */
    @Test
    public void testGetSideBattens() {
        System.out.println("getSideBattens");
        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");;
        int expResult = 480;
        int result = Calculator.getSideBattens(carport);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getScrews method, of class Calculator.
//     */
    @Test
    public void testGetScrews() {
        System.out.println("getScrews");
        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");
        int expResult = 5;
        int result = Calculator.getScrews(carport);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of constructCarport method, of class Calculator. TODO fix this test as well.
//     */
//    @Test
//    public void testConstructCarport() throws Exception {
//        System.out.println("constructCarport");
//        Carport carport = new Carport(230, 240, 240, false, 0, true, false, 15, true, "");;
//        Construction expResult = null;
//        Construction result = Calculator.constructCarport(carport, logic);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
