/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.math.BigDecimal;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Try to make it runnable and make it to be run in multiple cores to speedup
 * calculation
 *
 * @author tangz
 */
public class PrimeNumberGenerateThread implements Runnable {

    private CyclicBarrier barrier;
    private int result = 0;
    private int nFrom = 0;
    private int nTo = 0;

    public PrimeNumberGenerateThread(int from, int to, CyclicBarrier barrier) {
        nFrom = from;
        nTo = to;
        this.barrier = barrier;
    }

    public int getResult() {
        return result;
    }

    public static boolean isPrimeNumber(int n) {

        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 && n != 2) {
            return false;
        }
        if (n % 3 == 0 && n != 3) {
            return false;
        }
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }

        BigDecimal sqt = new BigDecimal(Math.sqrt(n));
        if (sqt.scale() == 0) {
            return false;
        }
        long lower = sqt.longValue();
        for (int i = 5; i <= lower; i += 6) {
            if ((n % i == 0) || (n % (i + 2) == 0)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void run() {
        int start = nFrom;
        int end = nTo;
        while (start <= end) {
            if (isPrimeNumber(start)) {
                result++;
                if (start == 2) {
                    start++;
                } else {
                    start += 2;
                }
            } else {

                if (start == 1) {
                    start++;
                } else {
                    if (start % 2 == 1) {
                        start += 2;
                    } else {
                        start++;
                    }
                }
            }
        }

        try {
            barrier.await(); //When calculation is finished, we have to wait others finished as well until broken barrier occurs
            System.out.println("Prime number counter from " + nFrom + " to " + nTo + " are [" + result + "]");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (BrokenBarrierException be) {
            be.printStackTrace();
        }
    }
}
