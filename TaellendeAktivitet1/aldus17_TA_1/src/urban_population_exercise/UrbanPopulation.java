package urban_population_exercise;

/**
 * Udleveret kodeskelet til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class UrbanPopulation implements Comparable<UrbanPopulation> {

    private String countryName;
    private int countryPeopleCount1980Procent;
    private int countryPeopleCount2008Procent;

    public UrbanPopulation(String countryName, String countryPeopleCount1980, String countryPeopleCount2008) {
        this.countryName = countryName;
        this.countryPeopleCount1980Procent = Integer.parseInt(countryPeopleCount1980);
        this.countryPeopleCount2008Procent = Integer.parseInt(countryPeopleCount2008);
    }

    public int getDiff() {
        return this.countryPeopleCount2008Procent - this.countryPeopleCount1980Procent;
    }

    @Override
    public String toString() {
        return this.countryName + " 1980: " + this.countryPeopleCount1980Procent + " 2008: " + this.countryPeopleCount2008Procent + " Diff: " + getDiff() + "\n";
    }

    @Override
    public int compareTo(UrbanPopulation o) {
        int i = getDiff() - o.getDiff();

        if (i == 0) {
            i = this.countryName.compareTo(o.countryName);
        }
        return i;

    }
}
