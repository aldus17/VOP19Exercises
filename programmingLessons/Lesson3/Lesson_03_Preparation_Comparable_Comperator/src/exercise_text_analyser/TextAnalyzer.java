package exercise_text_analyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class TextAnalyzer {

    private File file;

    public TextAnalyzer(String fileName) {
        file = new File(fileName);
    }

    // Opgave 2A     
    // Parameteren sorted afgør om der skal benyttes et sorteret Set
    //
    public Set<String> findUniqueWords(boolean sorted) {
        Set<String> set = null;
        if (sorted) {
            //set =  //initialiser et sorteret Set
            set = new TreeSet<>();
        } else {
            //set = // initialiser et usorteret Set
            set = new HashSet<>();
        }

        // gennemlæs filen et ord ad gangen
        // kald clean() metoden på hvert ord
        // og tilføj ordet til settet.
        try (Scanner scanFile = new Scanner(this.file)) {
            List<String> listOfUniqueWords = new ArrayList<>();
            while (scanFile.hasNext()) {
                listOfUniqueWords.add(scanFile.next());
            }

            for (String s : listOfUniqueWords) {
                set.add(clean(s));
            }
            //set.forEach(list -> set.add(clean(word)));
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }

        return set;
    }

    // Opgave 2B:   Nearly as Listing 21.9 from Liang
    //
    public Map<String, Integer> countWords(boolean sorted) {
        Map<String, Integer> map = null;
        if (sorted) {
            //map = // sorteret mappe
            map = new TreeMap<>();
        } else {
            //map = // usorteret mappe
            map = new HashMap<>();
        }
        // gennemlæs filen et ord ad gangen
        // kald clean() metoden på hvert ord
        // benyt mappen til at tælle forekomsten af hvert ord

        try (Scanner scanFile = new Scanner(this.file)) {
            List<String> listOfCountWords = new ArrayList<>();
            while (scanFile.hasNext()) {
                listOfCountWords.add(clean(scanFile.next()));
            }
            for (String s : listOfCountWords) {
                if (s.length() > 0) {
                    if (!map.containsKey(s)) {
                        map.put(s, 1);
                    } else {
                        int value = map.get(s);
                        value++;
                        map.put(s, value);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        return map;
    }

    // Opgave 2C:     Udvidelse af P15.1
    //
    public Map<Integer, Set<String>> lengtOfWords(boolean sorted) {
        Map<Integer, Set<String>> mapOfSets = null;
        Set<String> newSet;
        if (sorted) {
            //mapOfSets = // sorteret
            mapOfSets = new TreeMap<>();

        } else {
            //mapOfSets = // usorteret
            mapOfSets = new HashMap<>();

        }
        // gennemlæs filen et ord ad gangen
        // kald clean() metoden på hvert ord
        // Indsæt hvert ord i det Set<String> som er værdi til ordlængden som key
        // Hint: nyt Set<String> skal oprettes hver gang en længde opdages første gang.
        try (Scanner scanFile = new Scanner(this.file)) {
            List<String> listOfCountWords = new ArrayList<>();
            while (scanFile.hasNext()) {
                listOfCountWords.add(clean(scanFile.next()));
            }

            for (String s : listOfCountWords) {

                int lengthOfWord = s.length();
                List<String> addWordsToListArray = new ArrayList<>();
                addWordsToListArray.add(s);
                if (mapOfSets.containsKey(lengthOfWord)) {

                    mapOfSets.get(lengthOfWord).add(s);
                } else {
                    if (sorted) {
                        newSet = new TreeSet<>(addWordsToListArray);
                    } else {
                        newSet = new HashSet<>(addWordsToListArray);
                    }
                    mapOfSets.put(lengthOfWord, newSet);
                }

            }

//            for (String s : listOfCountWords) {
//                if (s.length() > 0) {
//                    int lengthOfWord = s.length();
//                    mapOfSets.put(lengthOfWord, newSet);
//
//                }
//            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        return mapOfSets;

    }

    // Denne metode forsøger at fjerne alt 'snavs' fra en String,
    // så kun bogstaver bevares og store gøres til små
    private String clean(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        TextAnalyzer ta = new TextAnalyzer("src/exercise_text_analyser/alice30.txt");

        // Opgave 2A. Find alle unikke ord i filen
        Set<String> set = ta.findUniqueWords(true);
        System.out.println(set);
        System.out.println("Number of unique words: " + set.size());
        System.out.println("\n------------------------------------------------------------------\n");

        // Opgave 2B. Tæl forekomster af ord
        System.out.println("Count word occurances: ");
        Map<String, Integer> map = ta.countWords(true);
        System.out.println(map);

        System.out.println("\n------------------------------------------------------------------\n");

        // Opgave 2C. Benyt en mappe til at gruppere ord efter længde
        Map<Integer, Set<String>> map2 = ta.lengtOfWords(true);
        System.out.println(map2);
    }

}
