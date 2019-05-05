package TextFile_I_O;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AleksanderStationaer
 */
public class TextFile_I_O_WriteToFile {

    public static void main(String[] args) {
        String filName = "src/TextFile_I_O/out.txt";
        PrintWriter outputStream = null;

        try {

            outputStream = new PrintWriter(filName);
            outputStream.println("This is line 1.");
            outputStream.println("This is line 2.");
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + filName);
            System.exit(0);
        }
    }
}
