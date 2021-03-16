/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author tangz
 */
public class LongestSubStringNoRepeatQueueSolution {

    public int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int maxValue = 0;
        Queue<Character> queue = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Character firstChar = queue.peek();
            if (firstChar == null) {
                queue.offer(c);
                maxValue = maxValue > queue.size() ? maxValue : queue.size();
            }
            if (queue.contains(c)) {
                while (Character.compare(queue.poll(), c) != 0) {
                    continue;
                }
            }
            queue.offer(c);
            maxValue = maxValue > queue.size() ? maxValue : queue.size();
        }

        return maxValue;
    }

    public static void main(String[] args) {
        LongestSubStringNoRepeatQueueSolution so = new LongestSubStringNoRepeatQueueSolution();
        //test 1
        String test1 = "abcabcbb";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test1));

        String test2 = "bbbbb";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test2));

        String test3 = "pwwkew";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test3));

        String test4 = "";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test4));

        String test5 = " ";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test5));

        String test6 = "au";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test6));

        String test7 = "ABCDefg";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test7));

        String test8 = "dvdf";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test8));

        String test9 = "bpfbhmipx";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test9));

        String test10 = "abcabcbb";
        System.out.println("Max none repeated substring size is: " + so.lengthOfLongestSubstring(test10));
    }
}
