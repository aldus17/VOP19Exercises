/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialspoint_3;

/**
 *
 * @author erso Created on 08-02-2010, 09:34:25
 */
public class Producer implements Runnable {

    CircularBuffer q;

    Producer(CircularBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        for (Integer num : q.getIntegerArray()) {
            System.out.println(num);
            Integer[] na = new Integer[num];
            
            if (!(num == null)) {
                q.put(na[i++]);
                if (na[num] == 0) {
                    
                }
            } else {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println("Inturrupt ");
                }
            }
        }

//      int i = 0;
//      while(true) {
//         q.put(i++);
//      }
    }
}
