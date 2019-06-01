/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Udleveret kodeskelet til VOP F18 re-eksamen opg 2b
 *
 * @author erso
 */
public class TownStatistics {

    private List<DanishTown> townList;

    public TownStatistics() {
        this.townList = new ArrayList<>();
    }

    @Override
    public String toString() {
        String s = townList.toString();
        return "TownStatistics:\n" + s.substring(1, s.length() - 1) + "\n";
    }

    public void sort() {
        Collections.sort(townList);

    }

    public void readFile(String fileName) {
        if (!townList.isEmpty()) {
            townList.removeAll(townList);
        }

        try (Scanner scanFile = new Scanner(new File(fileName))) {

            while (scanFile.hasNext()) {
                String[] stringData = scanFile.nextLine().split("/");

                String countryName = stringData[1];
                String popu2012 = stringData[2];
                String popu2018 = stringData[3];

                townList.add(new DanishTown(countryName, popu2012, popu2018));

            }
        } catch (FileNotFoundException x) {
            System.out.println("File was not found!");
        }

    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        TownStatistics ts = new TownStatistics();
//        ts.readFile("Danske Byer.txt");
//        System.out.println("Unsorted " + ts);
//        ts.sort();
//        System.out.println("Sorted " + ts);
//
//    }

}
