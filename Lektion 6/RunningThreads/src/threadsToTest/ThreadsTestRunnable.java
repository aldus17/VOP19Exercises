/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsToTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AleksanderStationaer
 */
public class ThreadsTestRunnable implements Runnable {

    private int count;

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(500);
                count = count + i;
                System.out.println(count);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadsTestRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadsTestRunnable());

        t1.start();
    }

}
