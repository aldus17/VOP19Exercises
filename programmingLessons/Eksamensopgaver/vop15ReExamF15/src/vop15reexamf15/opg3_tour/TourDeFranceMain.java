package vop15reexamf15.opg3_tour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TourDeFranceMain {

    private List<RacingCyclist> list;
    private File fileName;

    public TourDeFranceMain(String fileName) {
        this.fileName = new File(fileName);
        this.list = new ArrayList<>();

    }

    public List<RacingCyclist> getList() {
        return list;
    }

    public File getFileName() {
        return fileName;
    }

    public void sort() {
        Collections.sort(list);
    }

    public void readFile() {

        try (Scanner scan = new Scanner(fileName)) {
            while (scan.hasNext()) {
                String[] dataFromFile = scan.nextLine().split("\t");

                String name = dataFromFile[0];
                String team = dataFromFile[1];
                String nationality = dataFromFile[2];
                String timeLoss = dataFromFile[3];
                String mountainPoints = dataFromFile[4];
                String sprintPoints = dataFromFile[5];
                // RacingCyclist(String name, String team, String country, String time, int mountains, int points)
                list.add(new RacingCyclist(name, team, nationality, timeLoss, Integer.valueOf(mountainPoints), Integer.valueOf(sprintPoints)));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IllegalStateException e) {
            System.out.println("This scanner is closed");
        }

    }

    public Set<RacingCyclist> makeSortedSet(Comparator comp) {
        Set<RacingCyclist> sortedSet = new TreeSet<>(comp);

        for (RacingCyclist r : list) {

            sortedSet.add(r);

        }

        return sortedSet;
    }

    public static void main(String[] args) {
        TourDeFranceMain tfm = new TourDeFranceMain("tourdefrance.txt");
        tfm.readFile();
        System.out.println("List:\n" + tfm.getList().subList(0, 10));
        tfm.sort();
        System.out.println("Sort:\n" + tfm.getList().subList(0, 10));
        Comparator<RacingCyclist> comp = new CountryMountainComparator();
        Set<RacingCyclist> countryMountainSet = tfm.makeSortedSet(comp);
        System.out.println("Country/Mountain:\n" + countryMountainSet);
    }
}
