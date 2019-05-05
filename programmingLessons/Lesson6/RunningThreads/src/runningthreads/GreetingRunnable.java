/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runningthreads;

import java.util.Date;

/**
 *
 * @author AleksanderStationaer
 */
public class GreetingRunnable implements Runnable {

    private String greeting;
    

    public GreetingRunnable(String aGreeting) {
        greeting = aGreeting;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i++) {
                Date timeNow = new Date();
                System.out.println(timeNow + " " + this.greeting);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Inturrupt exception - ERROR");
        }
    }

}
