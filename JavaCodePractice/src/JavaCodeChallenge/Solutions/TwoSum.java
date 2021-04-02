/**
 *
 * @author tangz
 */
package JavaCodeChallenge.Solutions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

class Solution {

//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[]{map.get(complement), i};
//            }
//            map.put(nums[i], i);
//        }
//
//        throw new IllegalArgumentException("No two sum solution");
//    }
    public int[] twoSum(int[] input, int targetValue) {

        int[] result = new int[2];
        int pointerOne = 0;
        int pointerTwo = input.length - 1;

        while (pointerOne < pointerTwo) {
            int sum = input[pointerOne] + input[pointerTwo];

            if (sum == targetValue) {
                result[0] = input[pointerOne];
                result[1] = input[pointerTwo];
                break;
            } else if (sum < targetValue) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9};
        Solution s1 = new Solution();
        int[] result = new int[2];
        result = s1.twoSum(numbers, 9);
        System.out.println("Result : [" + result[0] + "," + result[1] + "]");

        int n = 11;
        MathContext mc = new MathContext(3, RoundingMode.UP);
        BigDecimal sqt = new BigDecimal(Math.sqrt(n), mc);
        System.out.printf("Big Decimal Scale is %d%n", sqt.scale());
        
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("The number of cores of CPU of current PC is: " + cores);
    }
}
