package opg4_babynames_mysolution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * VOP ReEksamen F16 Kodeskelet til opgave 4b
 *
 * @author erso
 */
public class GirlsAndBoys {

    private final Map<String, Integer> girlsMap;
    private final Map<String, Integer> boysMap;
    private Set<CommonName> commonSet;

    public GirlsAndBoys() {
        boysMap = createNameMap(new File("Boys.txt"));
        girlsMap = createNameMap(new File("Girls.txt"));
    }

    private Map<String, Integer> createNameMap(File file) {
        Map<String, Integer> nameMap = new HashMap<>();
        String name = "";
        String total = "";
        try (Scanner sc = new Scanner(file)) {

            String[] linesFromFile;
            while (sc.hasNextLine()) {
                linesFromFile = sc.nextLine().split("\t");
                Integer tot = new Integer(linesFromFile[2]);
                nameMap.put(linesFromFile[1], tot);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return nameMap;
    }

    public void makeCommonNames() {
        commonSet = new TreeSet<>(CommonName::compareTo);
        CommonName commonName;
        for (String name : boysMap.keySet()) {
            if (girlsMap.containsKey(name)) {

                commonName = new CommonName(name, girlsMap.get(name), boysMap.get(name));
                commonSet.add(commonName);
            }
        }

    }

    @Override
    public String toString() {
        String st = commonSet.toString();
        // substring used to remove Arrays.toString method of printing an array
        // e.g. [test1, test2] -> test1 test2
        st = st.substring(1);
        st = st.substring(0, st.length() - 1);
        st = st.replace(", ", "");
        return st;
    }

    public void sortCommonByName(Comparator<CommonName> comparator) {
        Set<CommonName> newCommonSet = new TreeSet<>(comparator);
        for (CommonName name : commonSet) {
            newCommonSet.add(name);

        }
        commonSet = newCommonSet;

    }

    public void write2file(File f) {
        // Print formatted and append to file
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(f, true))) {
            for (CommonName cn : commonSet) {
                pw.println(cn.toString());
                // Check if any error occured while printing to the stream. True if error occured.
                if (pw.checkError()) {
                    System.out.println("Print stream encountered an error");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GirlsAndBoys gAndB = new GirlsAndBoys();
        gAndB.makeCommonNames();

        System.out.println("Common Names sort by total:\n" + gAndB.toString());
        gAndB.write2file(new File("CommonSortByNumber.txt"));

        gAndB.sortCommonByName(new CommonNamesComparator());
        System.out.println("Common Names sort by name:\n" + gAndB.toString());
        gAndB.write2file(new File("CommonSortByName.txt"));
    }

}
