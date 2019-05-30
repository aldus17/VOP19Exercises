/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop15reexamf15.opg3_tour;

import java.util.Comparator;

/**
 *
 * @author ALEKSTUD
 */
public class CountryMountainComparator implements Comparator<RacingCyclist> {

    @Override
    public int compare(RacingCyclist o1, RacingCyclist o2) {
        int i = o1.getCountry().compareToIgnoreCase(o2.getCountry());
        if (i == 0) {
            i = o2.getMountains() - o1.getMountains();
        }
        return i;
    }

}
