package liang_7_15_eliminateduplicatesinarray;

import java.util.Scanner;

public class Liang_7_15_eliminateDuplicatesInArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];

        // Prompt the user to enter ten numbers
        System.out.print("Enter ten number: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        // Get distinct numbers
        int[] distinctNumbers = eliminateDuplicates(numbers);

        // Display the result
        System.out.print("The distinct numbers are:");
        for (int e : distinctNumbers) {
            if (e > 0) {
                System.out.print(" " + e);
            }
        }
        System.out.println();
    }

    /**
     * public static int[] eliminateDuplicates(int[] list)
     *
     * eleminateDuplicates returns a new array with duplicate values eliminated
     *
     * @param list of type int[]
     * @return int[], with all unique numbers and no duplicates
     */
    public static int[] eliminateDuplicates(int[] list) {
        int[] distinctList = new int[list.length];
//        int i = 0;
//        for (int e : list) {
//
//            if (linearSearch(distinctList, e) == -1) {
//                distinctList[i] = e;
//                i++;
//            }
//
//        }

        // In linaerSearch we check whether a specific key is equal to the pointer
        // In the linaerSearch method we check if key is equal to the pointer if not then return -1
        for (int j = 0; j < list.length; j++) {
            if (linearSearch(distinctList, list[j]) == -1) {
                distinctList[j] = list[j];
            }
        }
        return distinctList;
    }

    /**
     * public static int linearSearch(int[] array, int key)
     *
     * linaerSearch we check whether a specific key is equal to the pointer
     *
     * @param array of type int[], the array for linaerSearch
     * @param key, of type int, key to search for
     * @return int, if the value found it returns the int number of the found
     * value, -1 if value was not found
     */
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {

            if (key == array[i]) {
                return i;
            }
        }

        return -1;
    }
}
