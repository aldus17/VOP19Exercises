package RecursiveSelectionSort;

import java.util.Arrays;

public class RecursiveSelectionSort {

    public static void sort(double[] list) {
        sort(list, 0, list.length - 1); // Sort the entire list

    }

    private static void sort(double[] list, int low, int high) {
        if (low < high) {
            // Find the smallest number and its index in list[low .. high]
            int indexOfMin = low;
            double min = list[low];
            for (int i = low + 1; i <= high; i++) {
                if (list[i] < min) {
                    min = list[i];
                    indexOfMin = i;
                }
            }

            // Swap the smallest in list[low .. high] with list[low]
            list[indexOfMin] = list[low];
            list[low] = min;

            // Sort the remaining list[low+1 .. high]
            sort(list, low + 1, high);
        }
    }

    public static void main(String[] args) {
        double[] myList = {4.8, 5.3, 2.9, 2.4, 7.8, 5.1, 3.5, 17.6, 2.2, 9.7, 9.9, 10.2, 1.9, 2.3, 3.4, 3.5};
        System.out.println("Not sorted: ");
        System.out.println(Arrays.toString(myList));
        sort(myList);
        System.out.println("Sorted: ");
        System.out.println(Arrays.toString(myList));
    }
}
