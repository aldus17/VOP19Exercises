package ComputeFactorials;


import java.util.Scanner;

public class ComputeFactorial {

    /**
     * Main method
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a nonnegative integer: ");
        int n = input.nextInt();

        // Display factorial
        System.out.println("Factorial of " + n + " is " + factorial(n));

    }

    /**
     * Return the factorial for the specified number
     */
    public static long factorial(int n) {
        if (n == 0) // Base case
        {
            return 1;
        } else {
            return (n * factorial(n - 1)); // Recursive call
        }
        /**
         * When the factorial program is run with certain inputs 13 and above,
         * we get incorrect results - negative numbers or results which do not
         * match with the actual factorial of that number. The reason is that
         * the factorial of numbers greater than or equal to 13 is too large for
         * the int data type. We can use the long data type but still it
         * wouldn't be large enough to hold the factorial of even higher
         * numbers. The solution is to use the BigInteger class which can handle
         * arbitrarily large numbers which is discussed here.
         */
    }
}
