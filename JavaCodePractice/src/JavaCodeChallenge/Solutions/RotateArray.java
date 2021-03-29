/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;

/**
 * Rotate Array K position from the end to the front Input: nums =
 * [1,2,3,4,5,6,7], k = 3 Output [5, 6, 7, 1, 2, 3, 4]
 *
 * @author tangz
 */
public class RotateArray {

    public static void rotateOnce(int[] nums) {
        int n = nums.length;
        int tail =nums[n-1];
        for (int i = n-1; i>0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = tail;
    }

    public static void roateArrayByKSteps(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1 || k < 0){
            return;
        }
        for (int i=0; i < k; i++){
            rotateOnce(nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Original Array: " + Arrays.toString(nums));

        int steps = 1;

        roateArrayByKSteps(nums, steps);
        System.out.printf("After call exchange function Array for %d step: %s%n", steps, Arrays.toString(nums));

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        steps = 2;
        roateArrayByKSteps(nums1, steps);
        System.out.printf("After call exchange function Array for %d step: %s%n", steps, Arrays.toString(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        steps = 3;
        roateArrayByKSteps(nums2, steps);
        System.out.printf("After call exchange function Array for %d step: %s%n", steps, Arrays.toString(nums2));
    }
}
