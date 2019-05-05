/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_manipulation;

/**
 *
 * @author erso
 */
import java.util.Arrays;
import java.util.Random;

/**
 * OOP test eksamen f09 opg 1
 *
 * @author erso
 */
public class ArrayManip {
    // Skal lave en metode der tager et array. Må gerne omdøbes

    public int[] oddEven(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {

            // odd number
            if (array[i] % 2 != 0) {
                //array[startIndex++] = array[i];
//                System.out.println("CHECK1");
//                System.out.println(Arrays.toString(array));
                temp[startIndex] = array[i];
                startIndex++;

            } // Even numbers
            else if (array[i] % 2 == 0) {
                // array[endIndex--] = array[i];
                temp[endIndex] = array[i];

                endIndex--;

            }
        }
        System.out.println("oddEven output: " + Arrays.toString(temp));
        sort(temp, startIndex);
        return temp;

    }

    // Sortere at ulige står i stigende og lige i falende orden. 
    private void sort(int[] array, int splitIndex) {
        //int[] temp = new int[array.length];
//        int startIndex = 0;
//        int endIndex = array.length - 1;

        Arrays.sort(array, 0, splitIndex);

        for (int i = splitIndex; i < array.length; i++) {

            array[i] = -array[i];

            /**
             * [1, 59, 71, 81, 89, 22, 70, 36, 68, 2]
             *
             * [1, 59, 71, 81, 89, -22, 70, 36, 68, 2]
             *
             * [1, 59, 71, 81, 89, -22, 70, 36, 68, 2]
             *
             * [1, 59, 71, 81, 89, -22, -70, 36, 68, 2]
             *
             * [1, 59, 71, 81, 89, -22, -70, 36, 68, 2]
             *
             * [1, 59, 71, 81, 89, -22, -70, -36, 68, 2]
             *
             * [1, 59, 71, 81, 89, -22, -70, -36, 68, 2]
             *
             * [1, 59, 71, 81, 89, -22, -70, -36, -68, 2]
             *
             * [1, 59, 71, 81, 89, -22, -70, -36, -68, 2]
             *
             * [1, 59, 71, 81, 89, -22, -70, -36, -68, -2]
             */
        }
        Arrays.sort(array, splitIndex, array.length);

        /**
         * [1, 59, 71, 81, 89, -70, -68, -36, -22, -2]
         */
        for (int i = splitIndex; i < array.length; i++) {
            array[i] = -array[i];

        }

    }

    public static void main(String[] arg) {
        Random generator = new Random(222);
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);

        }
        // int[] array = {71, 1, 2, 68, 36, 59, 70, 22, 81, 89};
        System.out.println("Input:  " + Arrays.toString(array));

        ArrayManip arrMani = new ArrayManip();

        int result[] = arrMani.oddEven(array);
        System.out.println("Output: " + Arrays.toString(result));

    }
}
