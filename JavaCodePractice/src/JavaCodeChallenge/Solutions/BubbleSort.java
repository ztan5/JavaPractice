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
public class BubbleSort {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        while (true) {
            int low = 0;
            int high = low + 1;
            boolean bSorted = true;
            while (high < n) {
                if (nums[high] < nums[low]) {
                    swap(nums, high, low);
                    bSorted = false;
                }
                low++;
                high++;
            }
            if (bSorted) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] n1 = {4, 5, 2, 3, 7, 8, 9};
        System.out.println(Arrays.toString(n1));
        bubbleSort(n1);
        System.out.println(Arrays.toString(n1));

        int[] n2 = {};
        System.out.println(Arrays.toString(n2));
        bubbleSort(n2);
        System.out.println(Arrays.toString(n2));

        int[] n3 = {4};
        System.out.println(Arrays.toString(n3));
        bubbleSort(n3);
        System.out.println(Arrays.toString(n3));

        int[] n4 = {1,1,1,2,2,2,3,3,3,5,5,5,4,4,4,4};
        System.out.println(Arrays.toString(n4));
        bubbleSort(n4);
        System.out.println(Arrays.toString(n4));
    }
}
