/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * Demo of how to generate prime numbers in a Java Thread
 *
 * @author tangz
 */
public class PrimeNumberGenerator {

    public static void main(String[] args) {
        int TEST_INT = 10000000;
        int THREAD_SIZE = 12;
        int ELEMENT_SIZE = THREAD_SIZE;
        int nThreads = TEST_INT / THREAD_SIZE;
        int remain = TEST_INT % THREAD_SIZE;

        if (remain > 0) {
            THREAD_SIZE = THREAD_SIZE + 1; //Because we have a remaining group
        }

        ArrayList<PrimeNumberGenerateThread> workers = new ArrayList<>();
        final CyclicBarrier barrier = new CyclicBarrier(THREAD_SIZE, new Runnable() {
            @Override
            public void run() {
                System.out.println("Computing seriers sum: ");
                int sum = 0;
                for (PrimeNumberGenerateThread p : workers) {
                    sum += p.getResult();
                }
                if (PrimeNumberGenerateThread.isPrimeNumber(TEST_INT)){
                    sum--;//Deduct the last number because we are looking for all prime numbers before TEST_INT
                }
                System.out.println("Sum of prime numbers before " + TEST_INT + " is: [" + sum + "]");
                return; //Return here
            }
        });

        int start = 0;
        int end = 0;
        for (int i = 0; i < ELEMENT_SIZE; i++) {
            start = nThreads * i + 1;
            end = nThreads * (i + 1);
            PrimeNumberGenerateThread worker = new PrimeNumberGenerateThread(start, end, barrier);
            workers.add(worker);
        }

        if (remain > 0) {
            PrimeNumberGenerateThread lastWorker = new PrimeNumberGenerateThread(end + 1, end + remain, barrier);
            workers.add(lastWorker);
        }

        for (PrimeNumberGenerateThread p : workers) {
            Thread t = new Thread(p);
            t.start();
        }
    }
}
