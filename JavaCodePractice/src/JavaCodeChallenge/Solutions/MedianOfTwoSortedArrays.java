/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays. Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
 * [1,2,3] and median is 2.
 *
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0] Output: 0.00000
 *
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1] Output: 1.00000
 *
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = [] Output: 2.00000
 *
 * @author tangz
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0d; //Todo
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 3, 1, 8, 10, 13};
        Solution s1 = new Solution();
        int[] result = new int[2];
        result = s1.twoSum(numbers, 9);
        System.out.println("Result : [" + result[0] + "," + result[1] + "]");
    }
}
