/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * [40, 60, 50, 30, 20, 50, 60] Find all pairs make up 100 (whole dollar) output
 * = 3
 *
 * @author tangz
 */
public class FindAllPairsThatMakeUpWholeDollar {

    public static int getCombinedValue(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 3;
        }
        return (n - 1) * (1 + (n - 1)) / 2;
    }

    public static int getWholeDollarPairCount(int[] nums) {
        int result = 0;
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        Map<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < nums.length; i++) {
            Integer val = nums[i];
            Integer value = val % 100;
            if (value == 0) {
                Integer w = map.get(100);
                if (w == null) {
                    map.put(100, 1);
                } else {
                    map.put(100, ++w);
                }
            } else {
                value = val % 50;
                if (value == 0) {
                    Integer r = map.get(50);
                    if (r == null) {
                        map.put(50, 1);
                    } else {
                        map.put(50, ++r);
                    }
                } else {
                    Integer o = map.get(val);
                    if (o == null) {
                        map.put(val, 1);
                    } else {
                        map.put(val, ++o);
                    }
                }
            }
        }

        //Summarize
        Iterator<Integer> it = map.keySet().iterator();
        Set<Integer> processed = new HashSet();
        while (it.hasNext()) {
            Integer val = it.next();
            if (processed.contains(val)) {
                continue;
            }
            Integer count1 = map.get(val);
            if (val % 100 == 0 || val % 50 == 0) {
                result += getCombinedValue(count1);
            } else {
                Integer wval = 100 - (val % 100);
                Integer count2 = map.get(wval);
                if (count1 != null && count2 != null) {
                    result += (count1 > count2 ? count1 : count2);
                    processed.add(wval);
                }
            }
            processed.add(val);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] t1 = {40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30};
        System.out.println("Input Array: " + Arrays.toString(t1));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t1) + "]");

        int[] t2 = {40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30, 40, 60, 50, 20, 80, 70, 30, 150, 100, 50, 100, 30};
        System.out.println("Input Array: " + Arrays.toString(t2));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t2) + "]");

        int[] t3 = {10, 150, 50, 200, 100, 90, 100, 50};
        System.out.println("Input Array: " + Arrays.toString(t3));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t3) + "]");

        int[] t4 = {40, 20, 80, 50, 250, 350, 20, 100};
        System.out.println("Input Array: " + Arrays.toString(t4));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t4) + "]");

        int[] t5 = {10, 10, 10};
        System.out.println("Input Array: " + Arrays.toString(t5));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t5) + "]");

        int[] t6 = {100};
        System.out.println("Input Array: " + Arrays.toString(t6));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t6) + "]");

        int[] t7 = {};
        System.out.println("Input Array: " + Arrays.toString(t7));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t7) + "]");

        int[] t8 = {10, 30, 50, 20, 70, 150, 50, 100, 70, 80, 60};
        System.out.println("Input Array: " + Arrays.toString(t8));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t8) + "]");

        int[] t9 = {40, 60, 50, 30, 20, 50, 60};
        System.out.println("Input Array: " + Arrays.toString(t9));
        System.out.println("Pairs: [" + getWholeDollarPairCount(t9) + "]");
    }
}
