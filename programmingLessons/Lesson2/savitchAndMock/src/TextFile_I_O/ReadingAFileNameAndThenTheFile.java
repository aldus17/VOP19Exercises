/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextFile_I_O;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author AleksanderStationaer
 */
public class ReadingAFileNameAndThenTheFile {
    public static void main(String[] args) {
        File fileName;
        System.out.print("Enter file name: ");
        Scanner keyboard = new Scanner(System.in);
        String fileNameString= keyboard.next();
        Scanner inputStream = null;
        
        System.out.println("The file " + fileNameString  +  "\n"
                + "contains the following lines:");
        
        try {
            
            inputStream = new Scanner(fileName = new File(fileNameString));
            if (!fileName.exists()) {
                System.out.println("No file by that name");
            }
            else if (!fileName.canRead()) {
                System.out.println("Not allowed to read from that file!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileNameString);
            System.exit(0);
        }
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            System.out.println(line);
            
        }
        inputStream.close();
    }
}
