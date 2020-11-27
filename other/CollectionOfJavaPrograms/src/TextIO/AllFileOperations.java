/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextIO;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author AleksanderStationaer
 */
public class AllFileOperations {

    public static void main(String[] a) {

        try {
            File file = new File("fileName");
            //Tests whether the application can read the file 
            System.out.println(file.canRead());
            //Tests whether the application can modify the file
            System.out.println(file.canWrite());
            //Tests whether the application can modify the file 
            System.out.println(file.createNewFile());
            //Deletes the file or directory
            System.out.println(file.delete());
            //Tests whether the file or directory exists.
            System.out.println(file.exists());
            //Returns the absolute pathname string.
            System.out.println(file.getAbsolutePath());
            //Tests whether the file is a directory or not.
            System.out.println(file.isDirectory());
            //Tests whether the file is a hidden file or not.
            System.out.println(file.isHidden());
            //Returns an array of strings naming the 
            //files and directories in the directory.
            System.out.println(file.list());
        } catch (IOException ex) {

        }
    }
}
