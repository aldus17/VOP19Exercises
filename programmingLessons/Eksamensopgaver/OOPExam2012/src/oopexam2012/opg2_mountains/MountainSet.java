/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopexam2012.opg2_mountains;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author PCATG
 */
public class MountainSet {

    private Set<Mountain> mountainSet;
    private File file;

    public MountainSet() {
        mountainSet = new TreeSet<>(Mountain::compareTo);
    }

    public void add(Mountain m) {
        mountainSet.add(m);
    }

    public Set<Mountain> getMountainSet() {
        return mountainSet;
    }

    public static void main(String[] args) {
        MountainSet mountainSet = new MountainSet();

        try (Scanner scanFile = new Scanner(new File("franskeBjerge.txt"))) {

            while (scanFile.hasNext()) {
                String[] stringData = scanFile.nextLine().split(";");
               // System.out.println(Arrays.toString(stringData));
                String name = stringData[0];
                String height = stringData[1];
                String prominence = stringData[2];
                String latitude = stringData[3];
                String longitude = stringData[4];
                String range = stringData[5];

                
                mountainSet.add(
                        new Mountain(name, height, prominence, latitude, longitude, range));

            }
        } catch (FileNotFoundException x) {
            System.out.println("File was not found!");
        }
        System.out.println(Arrays.asList(mountainSet.mountainSet));
    }
}
