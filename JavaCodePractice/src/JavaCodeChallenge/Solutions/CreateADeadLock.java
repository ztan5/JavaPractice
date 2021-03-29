/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This demo is to create a deadlock situation
 *
 * @author tangz
 */
public class CreateADeadLock {

    private Lock lockA = new ReentrantLock();
    private Lock lockB = new ReentrantLock();

    public void processThis() {
        lockA.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ;
        }
        lockB.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ;
        }
        lockA.unlock();
        lockB.unlock();
    }

    public void processThat() {
        lockB.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ;
        }
        lockA.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ;
        }
        lockB.unlock();
        lockA.unlock();
    }

    public static void main(String[] args) {
        CreateADeadLock task = new CreateADeadLock();
        Thread A = new Thread(new CreateADeadLockWorkerA(task));
        Thread B = new Thread(new CreateADeadLockWorkerB(task));
        A.setDaemon(true);
        B.setDaemon(true);
        A.start();
        B.start();
        try {
            A.join();
            B.join();
        } catch (InterruptedException ie) {
            ;
        }
        System.out.println("Thread A, and B are all done..... exit from here");
    }
}
