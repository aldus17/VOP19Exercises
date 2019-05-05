/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmeringsOpgave2;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


/**
 *
 * @author AleksanderSTUD
 */
public class ImplementStack {
    LinkedList<Integer> linkedList = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    //LinkedList<Integer> linkStack = new <>(new Stack<Integer>());
            

   
    
   void push(Integer i) {
        
        linkedList.addFirst(i);
        synchronized (this) {
            stack.push(i);
        }
        
        
        
    }
    Integer pop() {
        Integer numLinkedList = null;
        Integer numStack = null;
        try {
            numLinkedList = linkedList.removeFirst();
            synchronized (this) {
                numStack = stack.pop();
            }
            
        }
        catch (NoSuchElementException e) {
            System.out.println("Element blev ikke fundet");
            return numLinkedList;
        }
        return numLinkedList;
    }
    Integer peek(){
        return linkedList.getFirst();
    }
    boolean isEmpty() {
        for (Integer i : stack) {
            if (stack.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
        
}
