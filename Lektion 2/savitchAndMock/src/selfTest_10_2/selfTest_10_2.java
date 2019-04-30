/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfTest_10_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author AleksanderStationaer
 */
public class selfTest_10_2 {

    public static void main(String[] args) {

        String fileName = "sam.txt";
        PrintWriter outStream = null;
        Scanner scanner = new Scanner(System.in);
        //ArrayList<String> list = new ArrayList<>();
        System.out.print("Enter text to file: ");
        String keyboardInput;
        try {
            outStream = new PrintWriter(new FileOutputStream(fileName, true));
            while (!(keyboardInput = scanner.nextLine()).equalsIgnoreCase("quit")) {

                outStream.append(keyboardInput + "\n");
                System.out.println("You can type 'quit' to save&exit or enter the next line to save: ");
            }

            outStream.close();
            System.out.println("Files were written to " + fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, check the path of file");

        }

    }
}
