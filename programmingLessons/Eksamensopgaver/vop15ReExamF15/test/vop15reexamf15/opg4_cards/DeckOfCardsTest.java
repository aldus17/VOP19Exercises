/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop15reexamf15.opg4_cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ALEKSTUD
 */
public class DeckOfCardsTest {
    
    public DeckOfCardsTest() {
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
     * Test of toString method, of class DeckOfCards.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DeckOfCards instance = new DeckOfCards();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffle method, of class DeckOfCards.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        int swaps = 0;
        DeckOfCards instance = new DeckOfCards();
        instance.shuffle(swaps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DeckOfCards.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DeckOfCards.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
