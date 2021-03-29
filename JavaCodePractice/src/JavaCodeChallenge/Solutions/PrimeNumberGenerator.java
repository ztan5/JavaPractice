/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 * Demo of how to generate prime numbers in a Java Thread
 * @author tangz
 */
public class PrimeNumberGenerator {
    public static void main(String[] args){
        Thread primeGenThread = new Thread(new PrimeNumberGenerateThread());
        primeGenThread.setDaemon(true);
        primeGenThread.start();
        
        System.out.printf("Number of active threads in the %s group equals %d%n", primeGenThread.getThreadGroup().getName(), Thread.activeCount());
        
        try{
            Thread.sleep(5);
        } catch (InterruptedException e){
            
        }
        
    }
}
