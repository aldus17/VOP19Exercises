/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbufferexercise;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso Created on 08-02-2010, 09:33:34
 */
public class CircularBuff {

    private Integer[] buf;
    private int size;
    int putIndex = 0;
    int getIndex = 0;

    public CircularBuff(int size) {
        buf = new Integer[size];
        this.size = size;
    }

    // Implementer put() metoden
    synchronized public void put(int i) {

        while (buf[putIndex++ % size] != null) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CircularBuff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        buf[putIndex++ % size] = i;
        System.out.println("put:" + i);
        notify();

    }
// Implementer get() metoden

    synchronized public Integer get() {
        while(buf[getIndex % size] == null) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CircularBuff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Integer intName = buf[getIndex % size];
        buf[getIndex++ % size] = null;
        System.out.println("Get: " + intName);
        notify();
        return intName;
    }

    @Override
    public String toString() {
        return "Buff: " + Arrays.toString(buf);
    }
}
