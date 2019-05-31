package liang_7_18_bubblesort;

import java.util.Scanner;

public class Liang_7_18_bubbleSort {

    /**
     * Main method
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        double[] numbers = new double[10]; 

        // Prompt the user to enter ten numbers
        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextDouble();
        }

        // Invoke bubblesort method
        bubbleSort(numbers);

        // display the sorted numbers
        for (double e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    /**
     * 
     * @param list, of type double[], the list to be sorted 
     */
    public static void bubbleSort(double[] list) {
        double temp;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                // If a neighboring pair is not in order, swap values
                if (list[i] > list[i + 1]) {
//                    System.out.println("current number is bigger than neigbor: " + list[i]);
                    temp = list[i];
//                    System.out.println("temp value: " + temp);
                    list[i] = list[i + 1];
//                    System.out.println("Switch 1: " + list[i]);
                    list[i + 1] = temp;
//                    System.out.println("Give neigbor the temp: " + list[i + 1]);
                    swapped = true;
                }
            }
        } while (swapped); // Repeat if a value was swapped
    }
}
