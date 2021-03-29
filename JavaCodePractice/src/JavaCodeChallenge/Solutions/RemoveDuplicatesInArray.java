/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;

/**
 *
 * @author tangz
 */
public class RemoveDuplicatesInArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesInArray r = new RemoveDuplicatesInArray();
        int[] num = {1, 1, 1, 2, 3, 4, 4};
        int length = r.removeDuplicates(num);
        System.out.println("Removed Duplicated Array length is: " + length);
        int[] cpy = Arrays.copyOfRange(num, 0, length);
        System.out.println("Removed Duplicated Array is: " + Arrays.toString(cpy));

        int[] num1 = {};
        length = r.removeDuplicates(num1);
        System.out.println("Removed Duplicated Array length is: " + length);
        int[] cpy1 = Arrays.copyOfRange(num1, 0, length);
        System.out.println("Removed Duplicated Array is: " + Arrays.toString(cpy1));

        int[] num2 = {1};
        length = r.removeDuplicates(num2);
        System.out.println("Removed Duplicated Array length is: " + length);
        int[] cpy2 = Arrays.copyOfRange(num2, 0, length);
        System.out.println("Removed Duplicated Array is: " + Arrays.toString(cpy2));

        int[] num3 = {1, 2};
        length = r.removeDuplicates(num3);
        System.out.println("Removed Duplicated Array length is: " + length);
        int[] cpy3 = Arrays.copyOfRange(num3, 0, length);
        System.out.println("Removed Duplicated Array is: " + Arrays.toString(cpy3));

        int[] num4 = {0, 0, 0, 0, 3};
        length = r.removeDuplicates(num4);
        System.out.println("Removed Duplicated Array length is: " + length);
        int[] cpy4 = Arrays.copyOfRange(num4, 0, length);
        System.out.println("Removed Duplicated Array is: " + Arrays.toString(cpy4));

    }
}
