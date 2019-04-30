/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aldus17_ta_2;

/**
 *
 * @author erso
 */
public class CharConsumer implements Runnable {

    private String name;
    private CharBuffer buf;

    public CharConsumer(CharBuffer buf, String name) {
        this.buf = buf;
        this.name = name.toLowerCase();

    }

    @Override
    public void run() {
        while (!name.equals(name.toUpperCase())) {

            try {

                Thread.sleep(50);
                for (int i = 0; i < name.length(); i++) {
                    Character ch = name.charAt(i);
                    name = name.replace(ch, Character.toUpperCase(ch));
                }
                
            } catch (InterruptedException ex) {

            }
        }
    }

}
