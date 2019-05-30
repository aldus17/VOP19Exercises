/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopexam2012.opg3_gui_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PCATG
 */
public class TextFile implements FileIOInterface {

    private static File file = new File("Opg4File.txt");

    @Override
    public void writeToFile(String text) {
        try (PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            write.println(text);
//            write.print("\n");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String readFromFile() {
        String fileoutput = "";
        StringBuilder sb = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {

            String currentLine = fileReader.readLine();
            while (currentLine != null) {
                sb.append(currentLine);
                sb.append("\n");
                currentLine = fileReader.readLine();
            }

        } catch (FileNotFoundException ex) {
            return "Text file not found";
        } catch (IOException ex) {
            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

}
