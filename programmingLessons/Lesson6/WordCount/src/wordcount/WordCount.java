/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcount;

/**
 *
 * @author AleksanderStationaer
 */
public class WordCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] fileNames = {"alice30.txt", "Boscombe.txt", "Snow White.txt"};
        for (int i = 0; i < fileNames.length; i++) {
            Runnable wcr = new WordCountRunnable(fileNames[i]);
            Thread wordthread = new Thread(wcr);
            wordthread.start();
        }
    }

}
