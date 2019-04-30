/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aldus17_ta_2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class CharProducer implements Runnable {

    private static final char[] CHARACTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'æ', 'ø', 'å'};

    private static Random generator = new Random();

    private CharBuffer buf;

    public CharProducer(CharBuffer buf) {
        this.buf = buf;
    }

    @Override
    public void run() {
        while (true) {
            try {

                int t = 0;
                Character ch = buf.get();

                for (int i = 1; i <= CHARACTERS.length; i++) {
                    t = generator.nextInt(CHARACTERS[i]);
                    ch = CHARACTERS[t];

                }

                Thread.sleep(50);
                buf.put(ch);
                // buf = temp.charValue();

            } catch (InterruptedException ex) {
                Logger.getLogger(CharProducer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
