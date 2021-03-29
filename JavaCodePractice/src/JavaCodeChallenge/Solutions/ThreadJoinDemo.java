/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.concurrent.Semaphore;

/**
 * This demo is to test Thread Join Mechanism
 * @author tangz
 */
public class ThreadJoinDemo {
 
    
    public static void main(String [] args){
        ThreadJoinDemoWorker worker1 = new ThreadJoinDemoWorker();
        Thread t1 = new Thread(worker1);
        t1.setDaemon(true);
        t1.start();
        try{
            Thread.sleep(1000);
                    t1.join();
        } catch (InterruptedException it){
            ;
        }
        System.out.println("Thread JoinDemoWorkder counter = " + worker1.counter);
    }
}
