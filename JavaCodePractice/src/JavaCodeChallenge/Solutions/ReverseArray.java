/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;

/**
 * This demo is to show how to reverse an Array without any help of external
 * data structure. I will use two-pointer method to do it
 *
 * @author tangz
 */
public class ReverseArray {

    public void reserseArray(int[] nums) {
        int n = nums.length;
        if (n ==0 || n==1){
            return;
        }
        
        int smallPointer = 0;
        int bigPointer = n-1;
        while (bigPointer >= smallPointer){
            int tmp = nums[bigPointer];
            nums[bigPointer] = nums[smallPointer];
            nums[smallPointer] = tmp;
            smallPointer++;
            bigPointer--;
        }
        
    }

    public static void main(String[] args) {
        ReverseArray ra = new ReverseArray();
        int[] t1 = {1, 2, 3, 4, 5};
        System.out.println("Original Array : " + Arrays.toString(t1));
        ra.reserseArray(t1);
        System.out.println("Reversed Array : " + Arrays.toString(t1));

        int[] t2 = {2, 4, 5, 6, 7, 22, 21, 145, 55, 0, 17, 9};
        System.out.println("Original Array : " + Arrays.toString(t2));
        ra.reserseArray(t2);
        System.out.println("Reversed Array : " + Arrays.toString(t2));

        int[] t3 = {1};
        System.out.println("Original Array : " + Arrays.toString(t3));
        ra.reserseArray(t3);
        System.out.println("Reversed Array : " + Arrays.toString(t3));

        int[] t4 = {};
        System.out.println("Original Array : " + Arrays.toString(t4));
        ra.reserseArray(t4);
        System.out.println("Reversed Array : " + Arrays.toString(t4));
        
        int[] t5 = {1, 1, 1, 1, 2, 1};
        System.out.println("Original Array : " + Arrays.toString(t5));
        ra.reserseArray(t5);
        System.out.println("Reversed Array : " + Arrays.toString(t5));
        
    }

}
