/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextIO;

/**
 *
 * @author AleksanderStationaer
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadLinesFromFile {

    public static void main(String a[]) {
        BufferedReader br = null;
        String strLine = "";
        try {
            br = new BufferedReader(new FileReader("fileName"));
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName");
        }
    }
}
