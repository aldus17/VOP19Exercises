package vop15eksamen.facade;

import java.util.Arrays;
import java.util.Random;

/**
 * Kodeskelet til VOP eksamen F15, opgave 2.
 *
 * @author erso
 */
public class Facade {

    private int[] intArray;
    private Random random;

    public Facade() {
        random = new Random();
    }

    public int[] getIntArray() {
        return intArray;
    }

    public Random getRandom() {
        return random;
    }

    public int[] fillArray(int size, int max) {
        intArray = new int[size];

        for (int i = 0; i < size; i++) {
            intArray[i] = random.nextInt(max);
        }
        return intArray;

    }

    public int sumOfDivisors(int divisor) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % divisor == 0) {
                sum += intArray[i];
            }
        }
        return sum;

    }

    public int[] fillUniqueArray(int size, int max) {

        if (size < max) {
            for (int i = 0; i < intArray.length; i++) {
                int generate = random.nextInt(max);
                if (!contains(generate, i)) {
                    intArray[i] = generate;
                } else {
                    i--;
                }

            }
        } else {
            // size er større end max!
            return null;
        }
        return intArray;

    }

    private boolean contains(int x, int beforeindex) {

        for (int i : intArray) {
            if (i == x) {
                return true;
            }
        }
        return false;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Facade facade = new Facade();

        System.out.println("fillArray: " + Arrays.toString(facade.fillArray(20, 10)));
        int divisor = 3;
        System.out.println("Divisors of " + divisor + " has Sum: " + facade.sumOfDivisors(divisor));

        System.out.println("fillUnique: " + Arrays.toString(facade.fillUniqueArray(20, 30)));

        System.out.println("Error: " + Arrays.toString(facade.fillUniqueArray(20, 20)));
    }

}
