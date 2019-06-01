package dice_statistics;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class RollingDice {

    public static void main(String[] args) {
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        int runTimes = 100000;
        int[] intArr = new int[11];
        for (int i = 0; i < runTimes; i++) {
//            System.out.println("d1: " + d1.roll() + " d2: " + d2.roll() + " sum: " + Math.addExact(d1.roll(), d2.roll()));
            int d1roll = d1.roll();
            int d2roll = d2.roll();
            switch (getSum(d1roll, d2roll)) {
                case 2:
                    intArr[0] += 1;
                    break;
                case 3:
                    intArr[1] += 1;
                    break;
                case 4:
                    intArr[2] += 1;
                    break;
                case 5:
                    intArr[3] += 1;
                    break;
                case 6:
                    intArr[4] += 1;
                    break;
                case 7:
                    intArr[5] += 1;
                    break;
                case 8:
                    intArr[6] += 1;
                    break;
                case 9:
                    intArr[7] += 1;
                    break;
                case 10:
                    intArr[8] += 1;
                    break;
                case 11:
                    intArr[9] += 1;
                    break;
                case 12:
                    intArr[10] += 1;
                    break;
                default:
                    break;
            }

        }

        System.out.println(Arrays.toString(intArr));
        NumberFormat nf = new DecimalFormat("0.00");
        for (int j = 0; j < intArr.length; j++) {
            int q = j + 2;
            System.out.println("Sum: " + q + " in " + nf.format(getPercent(runTimes, intArr[j])) + "%");

        }
        System.out.println();
    }

    public static int getSum(int i1, int i2) {
        return Math.addExact(i1, i2);
    }

    public static double getPercent(int total, int sum) {

        return (double) (sum * 100) / total;
    }
}
