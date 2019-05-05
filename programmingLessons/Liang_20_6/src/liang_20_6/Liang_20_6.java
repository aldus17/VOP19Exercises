/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liang_20_6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author AleksanderSTUD
 */
public class Liang_20_6 {

    private static List<Integer> linkedList;

    public static void main(String[] args) {
        linkedList = new LinkedList<>();
        
        for (int i = 0; i <= 100000; i++) {
            linkedList.add(i);

        }
        System.out.println(Arrays.asList(linkedList));
        
        
        //System.out.println(linkedList.get(100000));
        Integer num = 100000;
        //linkedList.iterator();
        
    }

}
