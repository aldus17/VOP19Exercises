/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runningthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author AleksanderStationaer
 */
public class ThreadRunner {

    public static void main(String[] args) {
        GreetingRunnable greet1 = new GreetingRunnable("Hello");
        GreetingRunnable greet2 = new GreetingRunnable("Goodbye");
        GreetingRunnable greet3 = new GreetingRunnable("no");
//        Thread t1 = new Thread(greet1);
//        Thread t2 = new Thread(greet2);
//        t1.start();
//        t2.start();
//        greet1.run();
//        greet2.run();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(greet1);
        pool.execute(greet2);
        pool.execute(greet3);
    }
}
