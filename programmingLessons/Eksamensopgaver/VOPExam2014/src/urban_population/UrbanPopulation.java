package urban_population;

/**
 * Udleveret kodeskelet til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class UrbanPopulation implements Comparable<UrbanPopulation> {

    private String countryName;
    private int populationIn1980;
    private int populationIn2008;

    public UrbanPopulation(String countryName, String populationIn1980, String populationIn2008) {
        this.countryName = countryName;
        this.populationIn1980 = Integer.parseInt(populationIn1980);
        this.populationIn2008 = Integer.parseInt(populationIn2008);
    }

    private int getDiff() {
        return this.populationIn2008 - this.populationIn1980;
    }

    @Override
    public String toString() {
        return countryName + " 1980: " + this.populationIn1980
                + " 2008: " + this.populationIn2008 + " Diff: "
                + getDiff() + " \n";
    }

    @Override
    public int compareTo(UrbanPopulation o) {
        int i = getDiff() - o.getDiff();

        if (i == 0) {
            i = this.countryName.compareTo(o.countryName);
        }
        return i;

    }

    public String getCountryName() {
        return countryName;
    }

}
