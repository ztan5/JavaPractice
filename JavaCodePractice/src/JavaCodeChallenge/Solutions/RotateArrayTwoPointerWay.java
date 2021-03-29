/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;
/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
Memory Usage: 39.5 MB, less than 48.41% of Java online submissions for Rotate Array.
*/

/**
 *
 * @author tangz
 */
public class RotateArrayTwoPointerWay {

    public void roateArrayByKSteps(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        if (k < 0) {
            return;
        }

        int mo = k%n;
        
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, mo - 1);
        reverseArray(nums, mo, n - 1);

    }

    public static void reverseArray(int[] nums, int from, int to) {
        if (from >= to) {
            return;
        }

        if (from < 0 || to < 0) {
            return;
        }

        if (nums.length <= 1) {
            return;
        }

        while (from <= to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        RotateArrayTwoPointerWay rw = new RotateArrayTwoPointerWay();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Original Array: " + Arrays.toString(nums));

        int steps = 1;

        rw.roateArrayByKSteps(nums, steps);
        System.out.printf("After call exchange function Array for %d step: %s%n", steps, Arrays.toString(nums));

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        steps = 2;
        rw.roateArrayByKSteps(nums1, steps);
        System.out.printf("After call exchange function Array for %d step: %s%n", steps, Arrays.toString(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        steps = 3;
        rw.roateArrayByKSteps(nums2, steps);
        System.out.printf("After call exchange function Array for %d step: %s%n", steps, Arrays.toString(nums2));

        int[] nums3 = {1, 2};
        steps = 5;
        rw.roateArrayByKSteps(nums3, steps);
        System.out.printf("After call exchange function Array for %d step: %s%n", steps, Arrays.toString(nums3));
    }
}