package vop15reexamf15.opg2_polymorphi;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author erso
 */
public class NumberCheckerFacade {

    private int count;

    public List<Integer> checkNumbers(int min, int max, CheckerInterface checker) {
        count = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = min; i < max; i++) {
            if (checker.check(i)) {
                list.add(i);
                count++;
            }
        }
        return list;
    }

    public int getCount() {
        return count;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumberCheckerFacade ncf = new NumberCheckerFacade();

        CheckerInterface checker;
//        List<CheckerInterface> interfaces = new ArrayList<>();
//        interfaces.forEach((CheckerInterface checker) -> {
//            interfaces.add(checker = new EvenChecker());
//            interfaces.add(checker = new PrimeChecker());
//            interfaces.add(checker = new IsPowerOf2Checker());
//            interfaces.add(checker = new SquareChecker());
//
//        });

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
