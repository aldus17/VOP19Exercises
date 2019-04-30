/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author AleksanderStationaer
 */
public class FileToByteArray {
    public static void main(String a[]){
         
        String fileName = "C:/MyFile.txt";
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
            byte content[] = new byte[2*1024];
            int readCount = 0;
            while((readCount = is.read(content)) > 0){
                System.out.println(new String(content, 0, readCount-1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(is != null) is.close();
            } catch(Exception ex){
                 
            }
        }
    }
}
