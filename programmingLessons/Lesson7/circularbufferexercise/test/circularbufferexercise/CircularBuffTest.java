/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbufferexercise;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author AleksanderSTUD
 */
public class CircularBuffTest {
    
    public CircularBuffTest() {
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
     * Test of put method, of class CircularBuff.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        int i = 0;
        CircularBuff instance = null;
        instance.put(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class CircularBuff.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        CircularBuff instance = null;
        Integer expResult = null;
        Integer result = instance.get();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CircularBuff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CircularBuff instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
