/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a string s, find the length of the longest substring without repeating
 * characters. Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc",
 * with the length of 3.
 *
 * @author tangz
 */
public class LongestSubStringNoRepeat {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 1) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();
        int maxSize = 0;
        int tmpSize = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int distance = stack.search(c);
            if (distance == -1) {
                stack.push(c);
            } else {
                ArrayList tmpArray = new ArrayList();
                while (!stack.isEmpty()) {
                    Character tmpC = stack.pop();
                    tmpSize++;
                    if (distance > 1) {
                        tmpArray.add(tmpC);
                        distance--;
                    }
                }

                if (tmpSize > maxSize) {
                    maxSize = tmpSize;
                }

                for (int x = tmpArray.size()-1; x >= 0; x--) {
                    stack.push((Character) tmpArray.get(x));
                }

                stack.push(c);
                tmpSize = 0;
            }
        }
        //Before return check is there anyting left in the stack
        if (!stack.isEmpty()) {
            tmpSize = stack.size();
            maxSize = tmpSize > maxSize ? tmpSize : maxSize;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        LongestSubStringNoRepeat so = new LongestSubStringNoRepeat();
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
    }
}
