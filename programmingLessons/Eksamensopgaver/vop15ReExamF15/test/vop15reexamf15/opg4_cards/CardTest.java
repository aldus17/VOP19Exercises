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
public class CardTest implements CardInterface {

    private static Card card;

    public CardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        card = new Card(KING, HEARTS);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
        assertEquals("Hjerter - Ko", card.toString());

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {

    }

}
