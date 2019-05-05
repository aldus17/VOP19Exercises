/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package self_test_804;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Self_Test_804 {

    public static void main(String[] args) {
        String fileName = "stuff.data";
        // Opg 12, 13, 14
        // opg 15, we use following import statements:
        /**
         * import java.io.FileNotFoundException;
         *
         * import java.io.FileOutputStream;
         *
         * import java.io.IOException;
         *
         * import java.io.ObjectOutputStream;
         */
        try (ObjectOutputStream toFile = new ObjectOutputStream(new FileOutputStream(fileName))) {
            double[] doubles = {1.2, 2.4, 3.6};
            
            toFile.writeDouble(doubles[0]);
            toFile.writeDouble(doubles[1]);
            toFile.writeDouble(doubles[2]);
        } catch (FileNotFoundException ex) {
            System.out.println("Problem opening the file " + fileName);
        } catch (IOException ex) {
            System.out.println("Problem with output to file " + fileName);
        }
    }

}
