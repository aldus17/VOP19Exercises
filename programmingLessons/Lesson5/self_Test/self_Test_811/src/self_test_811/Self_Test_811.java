package self_test_811;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Self_Test_811 {

    public static void main(String[] args) {
        String fileName = "stuff.data";

        try (ObjectOutputStream toFile
                = new ObjectOutputStream(new FileOutputStream(fileName))) {
            double[] doubles = {1.2, 2.4, 3.6};

            toFile.writeDouble(doubles[0]);
            toFile.writeDouble(doubles[1]);
            toFile.writeDouble(doubles[2]);
            toFile.writeInt(5);

        } catch (FileNotFoundException ex) {
            System.out.println("Problem opening the file " + fileName);
        } catch (IOException ex) {
            System.out.println("Problem with output to file " + fileName);
        }
        try (ObjectInputStream fromFile
                = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("Output doubles:");
            double testDouble1 = fromFile.readDouble();
            double testDouble2 = fromFile.readDouble();
            double testDouble3 = fromFile.readDouble();
            System.out.println(testDouble1 + " " + testDouble2 + " " + testDouble3);
            System.out.println("Output test: ");
            int readInt = (int) fromFile.readLong();
            System.out.println(readInt);
        } catch (Exception e) {
        }

    }

}
