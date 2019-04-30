/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Excercise;

import java.util.Scanner;

/**
 *
 * @author AleksanderStationaer
 */
public class PE_18_7_Fibonacci_Series_Count {

    private static long count = 0;

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        String quit = "quit";

        //!(command = input.next()).equalsIgnoreCase(quit)
        while (true) {
            System.out.print("Enter an index for a Fibonacci number (Type 'quit' to exit): ");
            String index = input.next();
            if (index.equalsIgnoreCase(quit)) {
                break;
            }
            try {

                // Find and display the Fibonacci number
                System.out.println("The Fibonacci number at index "
                        + index + " is " + fib(Long.parseLong(index)));
                System.out.println("The fib method was called "
                        + count + (count == 1 ? " time." : " times."));
                count = 0; // To reset the count, else it counts the previous typed method calls
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, only whole numbers! e.g. 3 or 5 etc "
                        + "or if you wish to exit, type 'quit'");
            }
        }
    }

    /**
     * The method for finding the Fibonacci number
     */
    public static long fib(long index) {
        count++; // Increment

        if (index == 0) // Base case
        {
            return 0;
        } else if (index == 1) // Base case
        {
            return 1;
        } else // Reduction and recursive calls
        {

            return fib(index - 1) + fib(index - 2);

        }

    }
}
