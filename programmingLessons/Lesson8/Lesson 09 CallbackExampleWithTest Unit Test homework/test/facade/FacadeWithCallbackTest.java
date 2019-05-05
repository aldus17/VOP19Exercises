/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fsan
 */
public class FacadeWithCallbackTest {

    FacadeWithCallback facade;
    CallBackInterface soutCallBack;
    Dice dice;

    public FacadeWithCallbackTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
//        TODO
//        Instantiate your CallBackInterface
//        Instantiate and start your Facade Thread

        facade = new FacadeWithCallback(soutCallBack);
        facade.start();
    }

    @After
    public void tearDown() {
//        TODO
//        Interrupt your facade Thread
        facade.interrupt();
    }

    /**
     * Test of run method, of class FacadeWithCallback.
     */
    @Test
    public void testRun() {
//        TODO
//        Test the run() method
//        Assert if the dice.getDie1() and dice.getDie2() are equal to integer 6
        setUp();
        final int expected = 6;

//        final int actual1 = facade.getDice().getDie1();
//        final int actual2 = facade.getDice().getDie2();
//        
//        Assert.assertEquals(expected, actual1);
//        Assert.assertEquals(expected, actual2);
        int dice1 = 0;
        int dice2 = 0;
        while (!dice.equalsMax()) {
            dice.throwDice();
            dice1 = dice.getDie1();
            dice2 = dice.getDie2();
            soutCallBack.updateMessage(dice.toString());

        }

        System.out.println("success");
    }

}
