/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moreAboutThreads;
public class moreAboutThreadsMain{
	
	public static void main(String[] args){
		
		// Create a new Thread that executes the code in GetTime20
		
		Thread getTime = new GetTime20();
		
		// Create a new Thread created using the Runnable interface
		// Execute the code in run after 10 seconds
		
		Runnable getMail = new GetTheMail(10);
		
		Runnable getMailAgain = new GetTheMail(20);
		
		// Call for the code in the method run to execute
		
		getTime.start();
		
		new Thread(getMail).start();
		new Thread(getMailAgain).start();
		
	}
	
}