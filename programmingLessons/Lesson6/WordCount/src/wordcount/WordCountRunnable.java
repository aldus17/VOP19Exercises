/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author AleksanderStationaer
 */
public class WordCountRunnable implements Runnable {

    private File file;
    private int wordCount;

    public WordCountRunnable(String file) {
        this.file = new File(file);
    }

    @Override
    public void run() {
        try (Scanner scanFile = new Scanner(file)) {
            while (scanFile.hasNext()) {
                scanFile.next();
                wordCount++;
            }
            System.out.println(file + " has: " + wordCount + " words");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
