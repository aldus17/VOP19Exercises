/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmeringsOpgave1;

/**
 *
 * @author AleksanderSTUD
 */
public class Opgave1 {

    public static void main(String[] args) {
        System.out.println("Udprint af beregning");
        System.out.println(recursiveMethod(2, 3));
        System.out.println("Udprint af fejl");
        System.out.println(recursiveMethod(2, -3));

    }

    public static double recursiveMethod(double x, double n) {
        double d = 0;
        if (n >= 0) {
            d = Math.pow(x, n);

        } else if (n < 0) {
            System.out.println("Fejlmeddelse");
        } else {
            return recursiveMethod(n - 1, x);
        }
        return d;

    }
}
