/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search_test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author AleksanderSTUD
 */
public class IterativBinSearchTest {

    IterativBinSearch ibs;
    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    public IterativBinSearchTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ibs = new IterativBinSearch();
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of find method, of class IterativBinSearch.
     */
    @Test
    public void shouldFindIndexOfNumber() {
        int target = 13;
        int expected = 6;

        int result = ibs.find(FIBOS, target);

        Assert.assertEquals(expected, result);
        System.out.println("Succes in FindIndex");

    }

    @Test
    public void shouldReturnNegativeInsertionPointWhenNotFound() {
        int target = 22;
        int expected = -9;
        
        int result = ibs.find(FIBOS, target);
        
        Assert.assertEquals(expected, result);
        System.out.println("Success in NegativeInsert");
    }

}
