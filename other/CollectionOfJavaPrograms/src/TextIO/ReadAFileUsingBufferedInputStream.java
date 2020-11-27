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
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadAFileUsingBufferedInputStream {

    public static void main(String a[]) {

        InputStream is = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        try {
            is = new FileInputStream("/Users/ngootooru/sample.txt");
            bis = new BufferedInputStream(is);
            dis = new DataInputStream(bis);
            String temp = null;
            while ((temp = dis.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
