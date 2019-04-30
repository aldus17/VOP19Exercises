package urban_population_exercise;

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
        // Initialisering af variable

        this.popSet = new TreeSet<>(UrbanPopulation::compareTo);
        this.file = new File(fileName);

        readFile();
    }

    private void readFile() {
        // Til indlæsning af data fra file,
        // dannelse af objekter af klassen UrbanPopulation
        // og indsættelse af disse i popSet
        try (Scanner scanFile = new Scanner(this.file)) {

            while (scanFile.hasNext()) {
                String[] stringData = scanFile.nextLine().split("/");
                
                String countryName = stringData[0];
                String country1980Procent = stringData[1];
                String country2008Procent = stringData[4];

                popSet.add(new UrbanPopulation(countryName, country1980Procent, country2008Procent));

            }
        } catch (FileNotFoundException x) {
            System.out.println("File was not found!");
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
