package vop15reexamf15.opg2_polymorphi;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author erso
 */
public class NumberCheckerFacade {

    public List<Integer> checkNumbers(int min, int max, CheckerInterface checker) {

        List<Integer> list = new LinkedList<>();
        for (int i = min; i < max; i++) {
            if (checker.check(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumberCheckerFacade ncf = new NumberCheckerFacade();

        CheckerInterface checker;

        checker = new EvenChecker();
        System.out.println("Evens: " + ncf.checkNumbers(10, 100, checker));

        checker = new PrimeChecker();
        System.out.println("Primes: " + ncf.checkNumbers(10, 100, checker));

        checker = new IsPowerOf2Checker();
        System.out.println("Power of 2's: " + ncf.checkNumbers(10, 100, checker));

        checker = new SquareChecker();
        System.out.println("Squares: " + ncf.checkNumbers(10, 100, checker));
    }

}
