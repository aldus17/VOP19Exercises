/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camelwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author erso
 */
public class CamelWriter {

    private File inFile;

    public CamelWriter(String fileName) {
        inFile = new File(fileName);
    }

    public void readLines() {
        try (Scanner scanner = new Scanner(inFile, "UTF-8")) {
            while (scanner.hasNextLine()) {
                convert2camel(scanner.nextLine());
                System.out.println("");
                
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found, check the path of the file");
        }
        
    }

    private void convert2camel(String line) {
        // Split line til et String[] af de enkelte ord i linjen
        // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        // Sammensæt ordene til ét langt ord og udskriv.
        String[] strings = line.split(" ");

        for (int i = 0; i < strings.length; i++) {
            if (i == 0) {
                System.out.print(strings[i].toLowerCase());

            } else {
                String[] newStringArray = strings[i].split("");
                for (int j = 0; j < newStringArray.length; j++) {
                    if (j == 0) {
                        System.out.print(newStringArray[j].toUpperCase());
                        
                    } 
                    else {
                        System.out.print(newStringArray[j].toLowerCase());
                        
                    }
                }
            }
//            if (Character.isUpperCase(strings[i].charAt(0))) {
//                strings[i] = strings[i].toLowerCase();
//            } else if (i > 0 && strings[i].length() > 1) {
//                strings[i] = strings[i].substring(0, 1).toUpperCase() + strings[i].substring(1).toLowerCase();
//            } else {
//                strings[i] = strings[i].substring(0, 1).toUpperCase() + "";
//            }
//            System.out.println(String.join("", strings));
//        }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------------Reading file MaryAnn: ");
        CamelWriter maryAnn = new CamelWriter("src/camelwriter/MaryAnn.txt");
        maryAnn.readLines();
        System.out.println(maryAnn);
        System.out.println("-------------------Reading file DryLips: ");
        CamelWriter dryLips = new CamelWriter("src/camelwriter/Drylips.txt");
        dryLips.readLines();
        System.out.println(dryLips);
        System.out.println("-------------------Reading file OhLand: ");
        CamelWriter ohland = new CamelWriter("src/camelwriter/OhLand.txt");
        ohland.readLines();
        System.out.println(ohland);
    }

}
