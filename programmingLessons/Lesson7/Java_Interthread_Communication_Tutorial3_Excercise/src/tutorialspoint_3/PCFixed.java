/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialspoint_3;

/**
 *
 * @author erso Created on 08-02-2010, 09:35:50
 */
public class PCFixed {

    public static void main(String args[]) {
        CircularBuffer q = new CircularBuffer();
        new Producer(q);
        new Consumer(q);
    }
}
