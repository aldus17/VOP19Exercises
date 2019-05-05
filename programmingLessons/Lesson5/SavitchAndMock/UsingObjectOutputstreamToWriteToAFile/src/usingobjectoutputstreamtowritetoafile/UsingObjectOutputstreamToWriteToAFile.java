package usingobjectoutputstreamtowritetoafile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class UsingObjectOutputstreamToWriteToAFile {

    public static void main(String[] args) {
        String fileName = "numbers.dat";

        try (Scanner keyboard = new Scanner(System.in);
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {

            System.out.println("Enter nonnegative integers.");
            System.out.println("Place a negative number at the end.");

            int anInteger;
            String keyboardInput;
            do {
                anInteger = keyboard.nextInt();
                outputStream.writeInt(anInteger);

            } while (!(keyboardInput = keyboard.nextLine()).equalsIgnoreCase("quit") && anInteger >= 0);

            System.out.println("Numbers and sentinel value");
            System.out.println("written to the file " + fileName);

        } catch (FileNotFoundException ex) {
            System.out.println("Problem opening the file " + fileName);
        } catch (IOException ex) {
            System.out.println("Problem with output to file " + fileName);
        }
    }

}
