package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Udleveret klasse erklæring med main() metode til VOP re-eksamen 20. august
 * 2014
 *
 * @author erso
 */
public class ArrayTester {

    private static Random generator = new Random();
    private final int MAX = 100;
    private int[] intArray;

    public ArrayTester(int size) {
        intArray = new int[size];
        fillArray();
    }

    public void fillArray() {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = generator.nextInt(MAX);
        }
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder("\n");
//        int count = 0;
//        for (int i = 0; i < intArray.length; i++) {
//            if (count == 8) {
//                sb.append("\n");
//                count = 0;
//            } else {
//                
//                sb.append(", ");
//                count++;
//            }
//
//            if (intArray[i] < 10) {
//                sb.append("0");
//            }
//
//            sb.append(intArray[i]);
//
//        }
//        sb.append("\n---------------------\n");
//        return sb.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            if (i % 8 == 0) {
                sb.append("\n");
            } else {
                sb.append(", ");
            }

            if (intArray[i] < 10) {
                sb.append("0");
            }
            sb.append(intArray[i]);
        }
        sb.append("\n---------------------\n");
        return sb.toString();

    }

    public void sort() {
        Arrays.sort(intArray);
    }

    // Udleveret metode, som bytter om på 2 elementer i arrayet.
    // Bør benyttes ved løsning af opg 3d
    public void swap(int fromIndex, int toIndex) {
        int temp = intArray[fromIndex];
        intArray[fromIndex] = intArray[toIndex];
        intArray[toIndex] = temp;

    }

    public void reverse() {
        Arrays.sort(intArray);

        int startIndex = 0;
        int endIndex = intArray.length - 1;
        while (startIndex < endIndex) {
            swap(startIndex, endIndex);
            startIndex++;
            endIndex--;
        }

    }

    // Udleveret main()-metode til test
    // Fjern ud-kommenteringerne efterhånden som opgaven løses.
    public static void main(String[] args) {
        int size = 30;
        ArrayTester arrayTester = new ArrayTester(size);
        System.out.println("constructor: " + arrayTester);

        arrayTester.sort();
        System.out.println("sorted: " + arrayTester);
        arrayTester.reverse();
        System.out.println("reverse: " + arrayTester);
    }

}
