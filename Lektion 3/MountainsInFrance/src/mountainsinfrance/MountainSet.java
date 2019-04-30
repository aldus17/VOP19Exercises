/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mountainsinfrance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author AleksanderSTUD
 */
public class MountainSet {

    private Set<Mountain> mountainSet;

    public MountainSet() {
        this.mountainSet = new TreeSet<>(Mountain::compareTo);

    }

    public Set<Mountain> getMountainSet() {
        return mountainSet;
    }

    public Set<Mountain> sortByRange(Comparator comp) {
        Set<Mountain> newMountains = new TreeSet<>(comp);
        newMountains.addAll(mountainSet);
        return newMountains;

    }

    public static void main(String[] args) {
        File file = new File("FranskeBjerge.csv");
        MountainSet mSet = new MountainSet();

        try (Scanner scanFile = new Scanner(file)) {
            /**
             * String line; String[] data;
             *
             * line = scanFile.nextLine();
             *
             * data = line.split(";");
             */
            while (scanFile.hasNextLine()) {
                String[] dataOfTheCurrentLine = scanFile.nextLine().split(";");

                String name = dataOfTheCurrentLine[0];
                String heigth = dataOfTheCurrentLine[1];
                String prominence = dataOfTheCurrentLine[2];
                String latitude = dataOfTheCurrentLine[3];
                String longitude = dataOfTheCurrentLine[4];
                String range = dataOfTheCurrentLine[5];

                mSet.mountainSet.add(new Mountain(name, heigth, prominence, latitude, longitude, range));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        System.out.println("List of mountains: ");
        System.out.println(mSet.getMountainSet());
        System.out.println("Mountains sorted by MountainRangeComarator");
        System.out.println(mSet.sortByRange(new MountainRangeComparator()));
    }

}
