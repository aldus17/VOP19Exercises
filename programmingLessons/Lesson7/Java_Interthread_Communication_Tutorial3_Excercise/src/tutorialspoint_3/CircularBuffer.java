/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialspoint_3;

/**
 *
 * @author AleksanderStationaer
 */
public class CircularBuffer {

    private Integer[] integerArray;

    public CircularBuffer() {
        this.integerArray = new Integer[5];

    }

    public Integer[] getIntegerArray() {
        return integerArray;
    }
    int n;
    boolean valueSet = false;

    synchronized int get() {
        if (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        if (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }

}
//class Q {
//
//    int n;
//    boolean valueSet = false;
//
//    synchronized int get() {
//        if (!valueSet) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                System.out.println("InterruptedException caught");
//            }
//        }
//        System.out.println("Got: " + n);
//        valueSet = false;
//        notify();
//        return n;
//    }
//
//    synchronized void put(int n) {
//        if (valueSet) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                System.out.println("InterruptedException caught");
//            }
//        }
//        this.n = n;
//        valueSet = true;
//        System.out.println("Put: " + n);
//        notify();
//    }
//}
