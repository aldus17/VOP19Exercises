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
public class C {

    public static void main(String[] args) {
        B b = new B();
    }

    static class A {

        public A() {
            System.out.println(
                    "The default constructor of A is invoked");
        }
    }

    static class B extends A {

        public B() {
            System.out.println(
                    "The default constructor of B is invoked");
        }
    }
}
