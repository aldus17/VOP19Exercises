package opg4_babynames;

import java.io.File;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/**
 * VOP ReEksamen F16
 * Kodeskelet til opgave 4b
 * @author erso
 */
public class GirlsAndBoys {

    private Map<String, Integer> girlsMap;
    private Map<String, Integer> boysMap;
    private Set<CommonName> commonSet;

    public GirlsAndBoys() {
        boysMap = createNameMap(new File("Boys.txt"));
        girlsMap = createNameMap(new File("Girls.txt"));
    }

    private Map<String, Integer> createNameMap(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void makeCommonNames() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        String st = commonSet.toString();
        st = st.substring(1);
        st = st.substring(0, st.length() - 1);
        st = st.replace(", ", "");
        return st;
    }

    public void sortCommonByName(Comparator<CommonName> comparator) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void write2file(File f) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GirlsAndBoys gAndB = new GirlsAndBoys();
        gAndB.makeCommonNames();

        System.out.println("Common Names sort by total:\n" + gAndB.toString());
//        gAndB.write2file(new File("CommonSortByNumber.txt"));

        gAndB.sortCommonByName(new CommonNamesComparator());
        System.out.println("Common Names sort by name:\n" + gAndB.toString());
//        gAndB.write2file(new File("CommonSortByName.txt"));    
    }


}
