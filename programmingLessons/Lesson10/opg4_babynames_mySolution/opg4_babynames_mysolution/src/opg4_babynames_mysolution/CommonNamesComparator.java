package opg4_babynames_mysolution;

import java.util.Comparator;

/**
 * VOP ReEksamen F16 Kodeskelet til opgave 4c
 *
 * @author erso
 */
public class CommonNamesComparator implements Comparator<CommonName> {

    @Override
    public int compare(CommonName o1, CommonName o2) {
       return o1.getName().compareTo(o2.getName());
    }

}
