/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * The goal is to find the counter of all prime numbers less than input integer
 * (Positive Integer) input: 10 Output [2, 3, 5, 7] so should be 4 input: 11
 * Output [2, 3, 5, 7] so should be 4 as well
 *
 * Tried brutal force way to check all numbers less than input will not be
 * accepted because it is running slow
 *
 * @author tangz
 */
public class FindPrimeNumbersCounterLessThanCurrentInteger {

    public static int primeNumberBeforeMe(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }

        if (isPrimeNumber(n)) {
            return primeNumberBeforeMe(n - 1);
        } else {
            int diff = 0;
            while (isPrimeNumber(n - diff) == false) {
                diff++;
            }
            n = n - diff;
            return primeNumberBeforeMe(n) + 1;
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n <= 1) {
            return false;
        }

        if (n % 2 == 0 && n > 2) {
            return false;
        }

        if (n % 3 == 0 && n > 3) {
            return false;
        }

        if (n % 5 == 0 && n > 5) {
            return false;
        }

        if (n % 7 == 0 && n > 7) {
            return false;
        }

        for (int i = 2; i <= n; i++) {
            if ((n % i == 0) && (i != n)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(1), 1);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(2), 2);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(3), 3);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(4), 4);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(5), 5);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(6), 6);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(7), 7);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(8), 8);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(9), 9);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(10), 10);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(11), 11);
        System.out.printf("There [%d] prime numbers before %d%n", primeNumberBeforeMe(50000), 50000); //499979

    }
}
