/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author AleksanderStationaer
 */
public class TreeSetWithComparator {

    public static void main(String a[]) {

        Set<String> ts = new TreeSet<String>(new MyComp());
        ts.add("RED");
        ts.add("ORANGE");
        ts.add("BLUE");
        ts.add("GREEN");
        System.out.println(ts);
    }
}

class MyComp implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }

}
