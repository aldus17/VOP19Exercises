/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

public class Test1 {

    public static void main(String[] args) {
        Test1 test = new Test1();
        System.out.println(test.toString());
    }

    public Test1() {
        Test1 test = new Test1();
    }
    /**
     * Stackoverflow accurs because it creates an object of type Test1 in main,
     * and calls toString on Object, and under Test1 class it continues to
     * create a new object of type Test1 and call again.
     */
}
