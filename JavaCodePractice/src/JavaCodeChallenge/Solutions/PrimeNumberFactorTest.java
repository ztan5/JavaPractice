/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Test a number can be divided by all prime numbers input = 6 output = 1, 2, 3
 * input = 25 output = 5, 5 input = 49 output = 7, 7
 *
 * @author tangz
 */
public class PrimeNumberFactorTest {

    public static ArrayList<Integer> primeNumberFactorizer(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0 && n != i) {
                result.add(i);
                n = n / i;
            }

            if (n == i) {
                result.add(n);
            }
        }

        return result;
    }
    
    public static boolean isPrimitive(int n) {
        if (n <= 1) {
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
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> empty = new ArrayList<>();
        expected.add(empty);
        expected.add(empty);
        expected.add(new ArrayList<>(Arrays.asList(2)));
        expected.add(new ArrayList<>(Arrays.asList(3)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2)));
        expected.add(new ArrayList<>(Arrays.asList(5)));
        expected.add(new ArrayList<>(Arrays.asList(2, 3)));
        expected.add(new ArrayList<>(Arrays.asList(7)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 2)));
        expected.add(new ArrayList<>(Arrays.asList(3, 3)));
        expected.add(new ArrayList<>(Arrays.asList(2, 5)));
        expected.add(new ArrayList<>(Arrays.asList(11)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 5, 5)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 5, 5, 7, 11, 13)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 2, 5, 5, 5, 7, 7)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 2,3,3,3,5, 5, 5, 7, 7, 11)));
        
        result.add(primeNumberFactorizer(0));
        result.add(primeNumberFactorizer(1));
        result.add(primeNumberFactorizer(2));
        result.add(primeNumberFactorizer(3));
        result.add(primeNumberFactorizer(4));
        result.add(primeNumberFactorizer(5));
        result.add(primeNumberFactorizer(6));
        result.add(primeNumberFactorizer(7));
        result.add(primeNumberFactorizer(8));
        result.add(primeNumberFactorizer(9));
        result.add(primeNumberFactorizer(10));
        result.add(primeNumberFactorizer(11));
        result.add(primeNumberFactorizer(12));
        result.add(primeNumberFactorizer(100));
        result.add(primeNumberFactorizer(100100));
        result.add(primeNumberFactorizer(49000));
        result.add(primeNumberFactorizer(14553000));

        for (int i = 0; i < expected.size(); i++) {
            ArrayList<Integer> exp = expected.get(i);
            ArrayList<Integer> res = result.get(i);
            if (exp.equals(res) == false) {
                System.out.println("Test failed at test case : " + (i + 1));
                System.out.println("Falied Result : " + res);
                return;
            }
        }

        System.out.println("All Test Cases Passed");
    }
}
