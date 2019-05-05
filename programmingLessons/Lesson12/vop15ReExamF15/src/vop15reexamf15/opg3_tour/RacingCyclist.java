package vop15reexamf15.opg3_tour;

/**
 *
 * @author erso
 */
public class RacingCyclist implements Comparable<RacingCyclist> {

    private String name;
    private String team;
    private String country;

    private String time;
    private int mountains;
    private int points;

    @Override
    public String toString() {
        return name + " " + team + " " + country + " " + time + " " + mountains + " " + points + "\n";
    }

    @Override
    public int compareTo(RacingCyclist o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
