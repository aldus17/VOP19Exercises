/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files_in_dirs;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author erso
 */
public class FindFilesRecursive {

    private int noDirs;
    private int noFiles;

    // Exercise: If a file is a directory: Call all files recurcively, 
    // else print full path to the file. Count both dirs and atomic files.
    // Check den fil der kommer in i paramteren, kan vi bruge File[] files = file.listfiles();
    private void findFiles(File file) {

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            noDirs++;
            for (int i = 0; i < files.length; i++) {
                findFiles(files[i]);

            }
        } else {
            noFiles++;
            System.out.println(file.getAbsolutePath());
        }
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isDirectory()) {
//                noDirs++;
//                findFiles(files[i]);
//                
//            } else {
//                String fullpath = files[i].getAbsolutePath();
//                File printToFile = new File(fullpath);
//                System.out.println(printToFile);
//                
//                noFiles++;
//            }

    }

    @Override
    public String toString() {
        return "FindFilesRecursive{" + "noDirs=" + noDirs + ", noFiles=" + noFiles + '}';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
        File startDir = new File(directory);

        FindFilesRecursive ffr = new FindFilesRecursive();
        ffr.findFiles(startDir);
        System.out.println("\n*************\n" + ffr);
    }

}
