/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mountainsinfrance;

import java.util.Comparator;

/**
 *
 * @author AleksanderSTUD
 */
public class MountainRangeComparator implements Comparator<Mountain> {

    @Override
    public int compare(Mountain o1, Mountain o2) {
        int i = o1.getRange().compareTo(o2.getRange());
        if (i == 0) {
            i = o1.compareTo(o2);
        }
        return i;
    }

}
