/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population;

/**
 * Udleveret kodeskelet til VOP F18 re-eksamen opg 2a
 *
 * @author erso
 */
public class DanishTown implements Comparable<DanishTown> {

    private String townName;
    private int population2012;
    private int population2018;

    public DanishTown(String townName, String population2012, String population2018) {
        this.townName = townName;
        this.population2012 = Integer.valueOf(population2012);
        this.population2018 = Integer.valueOf(population2018);
    }

    private int getDiff() {
        return this.population2018 - this.population2012;
    }

    public String getTownName() {
        return townName;
    }

    @Override
    public String toString() {
        return "\n" + townName + " Diff: " + getDiff();
    }

    @Override
    public int compareTo(DanishTown o) {
        int i = this.getDiff() - o.getDiff();
        if (i == 0) {
            i = o.getTownName().compareTo(this.townName);
        }
        return i;
    }

}
