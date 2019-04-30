/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moreAboutThreads;

/**
 *
 * @author AleksanderStationaer
 */
// You can use the Runnable interface instead of
// wasting your 1 class extension.
public class GetTheMail implements Runnable {

    // Stores the number of seconds before the code
    // will be executed
    private int startTime;

    // Constructor that sets the wait time for each 
    // new Thread
    public GetTheMail(int startTime) {
        this.startTime = startTime;
    }

    // All of the code that the thread executes must be 
    // in the run method, or be in a method called for
    // from inside of the run method
    @Override
    public void run() {

        try {
            // Don't execute until 10 seconds has passed if 
            // startTime equals 10
            Thread.sleep(startTime * 1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Checking for Mail");
    }

}
