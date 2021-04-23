package JavaCodeChallenge.Solutions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Basically this is hard to deal with a down trend situation how to 
 * get correct the worst losing streak in a down trend scenario
 * @author tangz
 */
public class MaxLoseTrade {

    public static int worstLosingStreak(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int result = 0;
        int max = 0;
        int peak = 0;
        int low = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                result += nums[i - 1] - nums[i];
                if (max < result) {
                    max = result;
                }
                if (nums[i] < nums[low]) {
                    low = i;
                }
            } else {
                result = 0;
                if (nums[i] > nums[peak]) {
                    peak = i;
                }
            }
        }
        int diff = 0;
        if (low > peak) {
            diff = nums[peak] - nums[low];
        }
        return max > diff ? max : diff;
    }

    public static void main(String[] args) {
        int[] input = {4, 3, 6, 5, 9};
        System.out.println(worstLosingStreak(input));

        int[] input1 = {6, 3, 6, 3, 7, 2, 8, 1};
        System.out.println(worstLosingStreak(input1));

        int[] input2 = {8, 1, 7, 2, 6, 3, 5, 4};
        System.out.println(worstLosingStreak(input2));

        int[] input3 = {9, 8, 7, 6, 5, 6, 7, 8, 5, 4, 3, 2, 1};
        System.out.println(worstLosingStreak(input3));

        int[] input4 = {3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 1, 9};
        System.out.println(worstLosingStreak(input4));

        int[] input5 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(worstLosingStreak(input5));

        int[] input6 = {3, 3, 3, 1, 1, 1, 4, 4, 4, 5, 5, 5, 6, 6, 6, 1, 1, 1};
        System.out.println(worstLosingStreak(input6));

        int[] input7 = {9, 8, 7, 6, 5, 4, 5};
        System.out.println(worstLosingStreak(input7));

        int[] input8 = {1};
        System.out.println(worstLosingStreak(input8));

        int[] input9 = {};
        System.out.println(worstLosingStreak(input9));
    }
}
