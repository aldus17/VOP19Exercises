/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialspoint_3;

/**
 *
 * @author erso Created on 08-02-2010, 09:35:14
 */
public class Consumer implements Runnable {

    CircularBuffer q;

    Consumer(CircularBuffer q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}
