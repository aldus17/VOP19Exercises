package vop15reexamf15.opg1_facade;

/**
 *
 * @author erso
 */
public class SpecialNumbers {

    public boolean isEven(int x) {
        if (x % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean isPrime(int x) {
        if (x == 2) {
            return true;
        }
        if (x < 2 || x % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= x; i += 2) {

            if (x % i == 0) {

                return false;
            }

        }

        return true;
    }

    public boolean isSquare(int x) {
        double y = Math.sqrt(x);
        if (y == (int) y) {
            return true;

        }
        return false;
    }

    public boolean isPowerOf2(int x) {
        if (x == 0) {
            return false;
        }

        while (x != 1) {
            if (x % 2 != 0) {
                return false;
            }
            x = x / 2;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpecialNumbers sn = new SpecialNumbers();
        int x = 1024;
        int y = 1021;
        System.out.println("Even\t" + x + ": " + sn.isEven(x) + "\t" + y + ": " + sn.isEven(y));
        System.out.println("Prime\t" + x + ": " + sn.isPrime(x) + "\t" + y + ": " + sn.isPrime(y));
        System.out.println("Pow 2\t" + x + ": " + sn.isPowerOf2(x) + "\t" + y + ": " + sn.isPowerOf2(y));
        System.out.println("Square \t" + x + ": " + sn.isSquare(x) + "\t" + y + ": " + sn.isSquare(y));

    }

}
