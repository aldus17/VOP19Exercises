package opg4_babynames_mysolution;

import java.util.Arrays;

/**
 * VOP ReEksamen F16 Kodeskelet til opgave 4a
 *
 * @author erso
 */
public class CommonName implements Comparable<CommonName> {
// Erklær variable, constructor og de to get()-metoder.

    private String name;

    private int girls;
    private int boys;

    public CommonName(String name, Integer girls, Integer boys) {
        this.name = name;
        this.girls = girls;
        this.boys = boys;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return this.boys + this.girls;
    }
// Fjern udkommenteringen herunder, når variable, constructor og get()-metoder er implementeret.

    @Override
    public String toString() {
        return String.format("%-12s Girls:%6d Boys:%6d Total:%6d \n", name, girls, boys, getTotal());

    }

    @Override
    public int compareTo(CommonName o) {

        int r = o.getTotal() - this.getTotal();
        if (r == 0) {
            r = this.name.compareTo(o.name);
        }
        return r;
    }

    public static void main(String[] a) {
        CommonName[] testArray = new CommonName[4];

// Fjern udkommenteringen herunder, når constructor, variable og get()-metoder er implementeret.        
        testArray[0] = new CommonName("Ibi", 10, 20);
        testArray[1] = new CommonName("Ib", 20, 10);
        testArray[2] = new CommonName("Ea", 20, 20);
        testArray[3] = new CommonName("Eva", 20, 5);
        System.out.println("Usorteret:\n" + Arrays.toString(testArray));

// Fjern udkommenteringen herunder, når compareTo()-metoden er implementeret.        
        Arrays.sort(testArray);
        System.out.println("Sorteret:\n" + Arrays.toString(testArray));
    }

}
