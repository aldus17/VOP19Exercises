/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfTest_10_3_practicePrograms1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class practicePrograms1 {

    public static void main(String[] args) throws FileNotFoundException {

        String FileName = "src/selfTest_10_3_practicePrograms1/Doubles.txt";

        Scanner lineReader = new Scanner(new File(FileName));

        List<Double> doubleValues = new ArrayList<>();
        double max_value = 0;
        double min_value = 0;
        double sum = 0, average = 0;
        
        while (lineReader.hasNext()) {
            // Add doubles to arraylist<Double>
            doubleValues.add(Double.parseDouble(lineReader.next()));
            // Sort the double array, to get the lower value, as 
            // it will sort from low to high where index 0 will be the 
            // lowest value
            Collections.sort(doubleValues);
            for (Double d : doubleValues) {
                // Max value
                if (d > max_value) {
                    max_value = d;
                } else {
                    sum = sum(doubleValues);            // Sum numbers save in local sum
                    min_value = doubleValues.get(0);    // get index 0 from double array, as it is sorted from low to high    
                    average = sum / doubleValues.size(); // Calculate average of the double array
                }
            }

//                if (doubleValues. > max_value) {
//                    max_value = doubleValues[i];
//                } else if (doubleValues[i] < min_value) {
//                    min_value = doubleValues[i];
//                } else {
//                    doubleValues[i] += sum;
//                    average = sum / doubleValues.length;
//                }
        }
        lineReader.close();
        System.out.println("The max value: " + max_value + "\nThe min value: " + min_value
                + "\nThe average value: " + average + "\nThe sum of all: " + sum);
    }
    // Sum any numbers in list of type Double
    public static double sum(List<Double> s) {
        double sum = 0;
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
        }
        return sum;
    }
}
