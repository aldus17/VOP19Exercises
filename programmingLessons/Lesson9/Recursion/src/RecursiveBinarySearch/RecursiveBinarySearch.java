package RecursiveBinarySearch;

import java.util.Arrays;

public class RecursiveBinarySearch {

    public static int recursiveBinarySearch(int[] list, int key) {
        int low = 0; 
        int high = list.length - 1;
        return recursiveBinarySearch(list, key, low, high);
    }

    private static int recursiveBinarySearch(int[] list, int key,
            int low, int high) {
        if (low > high) // The list has been exhausted without a match
        {   // haven't found the key number
            return -low - 1;
        }

        int mid = (low + high) / 2;
        if (key < list[mid]) { 
            return recursiveBinarySearch(list, key, low, mid - 1);
        } else if (key == list[mid]) {
            return mid;
        } else {
            return recursiveBinarySearch(list, key, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40, 45, 66, 77, 88, 99, 101, 150};
        System.out.println(Arrays.toString(arr));
        int findInt = 99;
        int i = recursiveBinarySearch(arr, findInt);
        System.out.println(i);
    }
}
