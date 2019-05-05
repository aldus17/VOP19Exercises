package self_test_811;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Question21 {

    public static void main(String[] args) {
        String fileName = null;
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Enter file name here: ");
            fileName = input.next();
        }
        try (
                ObjectInputStream inputSteam = new ObjectInputStream(
                        new FileInputStream(fileName))) {
            System.out.println("The first thing found in the file"
                    + fileName + " is: ");
            String first = inputSteam.readUTF();
            System.out.println(first);
            inputSteam.close();

        } catch (FileNotFoundException e) {
            System.out.println("File was not found !");
        } catch (EOFException e) {
            System.out.println("Unexpected opening the file"
                    + fileName);
        } catch (IOException ex) {
            System.out.println("Problem with input from "
                    + "file " + fileName);
        }
    }
}
