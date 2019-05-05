/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classspeciesserializedforbinaryfileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author AleksanderStationaer
 */
public class ClassObjectIODemo {

    public static void main(String[] args) {
        ObjectOutputStream outputStream = null;
        String fileName = "species.records";
        try {
            outputStream = new ObjectOutputStream(
                    new FileOutputStream(fileName));
        } catch (IOException e) {
            System.out.println("Error opening output file "
                    + fileName + ".");
            System.exit(0);
        }
        Species califCondor
                = new Species("Calif. Condor", 27, 0.02);
        Species blackRhino
                = new Species("Black Rhino", 100, 1.0);
        try {
            outputStream.writeObject(califCondor);
            outputStream.writeObject(blackRhino);
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error wring to file "
                    + fileName + ".");
            System.exit(0);
        }
        System.out.println("Records sent to file "
                + fileName + ".");
        System.out.println(
                "Now let's reopen the file and echo "
                + "the records.");
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(
                    new FileInputStream("species.records"));
        } catch (IOException e) {
            System.out.println("Error opening input file "
                    + fileName + ".");
            System.exit(0);
        }
        Species readOne = null, readTwo = null;
        try {
            // Notice the type casts.
            readOne = (Species) inputStream.readObject();
            readTwo = (Species) inputStream.readObject();
            inputStream.close();
            /**
             * A separate catch block for each type of exception would be
             * better. We use only one to save space.
             */
        } catch (Exception e) {
            System.out.println("Error reading from file "
                    + fileName + ".");
            System.exit(0);
        }
        System.out.println("The following were read\n"
                + "from the file " + fileName + ".");
        System.out.println(readOne);
        System.out.println();
        System.out.println(readTwo);
        System.out.println("End of program.");
    }
}
