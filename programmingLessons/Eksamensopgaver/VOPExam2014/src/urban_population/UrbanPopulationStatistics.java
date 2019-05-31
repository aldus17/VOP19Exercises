package urban_population;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Udleveret kodeskelet til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class UrbanPopulationStatistics {

    private Set<UrbanPopulation> popSet;
    private File file;

    public UrbanPopulationStatistics(String fileName) {
        popSet = new TreeSet<>();
        file = new File(fileName);

        readFile();
    }

    private void readFile() {
        // Til indlæsning af data fra file,
        // dannelse af objekter af klassen UrbanPopulation
        // og indsættelse af disse i popSet
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String[] s = sc.nextLine().split("/");

                String country = s[0];
                String p1980 = s[1];
                String p2008 = s[4];

                popSet.add(new UrbanPopulation(country, p1980, p2008));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File was not found, check file name");
        }
    }

// Udleveret toString() metode, som giver en "pæn" formatering.
    @Override
    public String toString() {
        String s = popSet.toString().replaceAll(", ", "");
        return "UrbanPopulationStatistics:\n" + s.substring(1, s.length() - 1) + "\n";
    }

    //Udleveret test-metode
    public static void main(String[] args) {
        UrbanPopulationStatistics stats = new UrbanPopulationStatistics("ByBefolkning.txt");
        System.out.println(stats);
    }

}
