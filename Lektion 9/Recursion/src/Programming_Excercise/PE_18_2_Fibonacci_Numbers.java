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
public class PE_18_2_Fibonacci_Numbers {

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        String quit = "quit";
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
        long f0 = 0; // For fib(0)         
        long f1 = 1; // For fib(1)
        long currentFib = 0;

        if (index == 0) {
            return f0;
        } else if (index == 1) {
            return f1;
        } else {
            for (int i = 1; i <= index; i++) {
                currentFib = f0 + f1;
                f0 = f1;
                f1 = currentFib;
            }
            return currentFib;
        }
    }
}
