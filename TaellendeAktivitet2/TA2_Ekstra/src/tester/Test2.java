/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

/**
 *
 * @author AleksanderSTUD
 */
public class Test2 {

    public static void main(String[] args) {
        int[] a = {22, 33, 44, 55, 66, 77, 88, 99};

    }

    public int binSearch(int[] a, int low, int high, int value) {
        int count = 0;

        if (low <= high) {
            int countt = 0;
            int mid = (low + high) / 2;

            if (a[mid] == value) {
                return mid;
                countt++;

            } else if (a[mid] < value) {
                return binSearch(a, mid + 1, high, value);
            } else {
                return binSearch(a, low, mid - 1, value);
            }
        } else {
            return -low - 1;
        }
    }

}
