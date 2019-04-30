/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search_test;

import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author AleksanderSTUD
 */
public class RecursiveBinSearchTest {

    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
    
    

    public RecursiveBinSearchTest() {
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
     * Test of recursiveFind method, of class RecursiveBinSearch.
     */
    @Test
    public void shouldFindIndexOfNumber() {
        System.out.println("recursiveFind");
        
        // Key = Target
        int key = 0;
        int expResult = 0;
        int result = RecursiveBinSearch.recursiveFind(FIBOS, key);
        assertEquals(expResult, result);

    }

    /**
     * Test of recursiveFind method, of class RecursiveBinSearch.
     */
    @Test
    public void shouldReturnNegativeInsertionPointWhenNotFound() {
        System.out.println("recursiveFind");
        
        // Key target
        int key = 0;
        int low = 0;
        int high = 0;
        int expResult = 0;
        int result = RecursiveBinSearch.recursiveFind(FIBOS, key, low, high);
        assertEquals(expResult, result);

    }

}
