/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;

/**
 * This demo is to illustrate how to use KMP algorithm to search string In KMP
 * we need to use a nextValue[] array to determine target string index position
 * after a mis-match detected
 *
 * @author tangz
 */
public class KMP {

    public static int longestCommomPrefixAndPostfixLength(String sub) {
        if (sub.length() == 0) {
            return 0;
        }

        if (sub.length() == 1) {
            return 0;
        }

        if (sub.length() == 2) {
            if (sub.charAt(0) == sub.charAt(1)) {
                return 1;
            } else {
                return 0;
            }
        }
        //if new string's last char
        // [aa] = 1
        // add one more character c
        // only need to chec [aa] and [ac] is matchint or not
        // if it is matching, [aa]'s value + 1 
        // if it is not matching, set [aac] longest comment prefix and post fix length = 0
        String prevString = sub.substring(0, sub.length() - 1);
        int p = longestCommomPrefixAndPostfixLength(prevString);
        int len = sub.length();
        //Check if we added the last character, still make a common post&pre fix growing later?
        ++p;
        String pre = sub.substring(0, p);
        String post = sub.substring(len - p, len);
        if (pre.equals(post)) {
            return p;
        } else {
            return 0;
        }
    }

    /**
     * -1 0 a 0 ab 1 aba 2 abab ababc so [-1, 0, 0, 1, 2] is the nextValue array
     *
     * @param pattern
     * @param num
     */
    public static void getNextVal(String pattern, int[] num) {
        num[0] = -1;
        for (int i = 1; i < num.length; i++) {
            String str = pattern.substring(0, i);
            num[i] = longestCommomPrefixAndPostfixLength(str);
        }
    }

    public static int KMP_Search(String text, String pattern) {
        int i = 0, j = 0;
        int[] next = new int[pattern.length()];
        getNextVal(pattern, next);
        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        //pattern must>= sub.length because all matching
        if (j >= pattern.length()) {
            return i - pattern.length();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String source, sub;
        int index;
        source = "googlggoogle";
        sub = "google";
        index = KMP_Search(source, sub);
        System.out.println("Substring index is: " + index);
        System.out.println("To Approve it: " + source.substring(index, index + sub.length()));

        source = "abcabccabcccabcccc";
        sub = "abcccc";
        index = KMP_Search(source, sub);
        System.out.println("Substring index is: " + index);
        System.out.println("To Approve it: " + source.substring(index, index + sub.length()));

        source = "ABCCCABCCCABCCCBABCCCABCCCABCCCEABCCCABCCCABCCCGABCCCABCCCABCCCEABCCCABCCCXABCCCEABCCCABCCCABCCCD";
        sub = "ABCCCX";
        index = KMP_Search(source, sub);
        System.out.println("Substring index is: " + index);
        System.out.println("To Approve it: " + source.substring(index, index + sub.length()));

        source = "ABCDEFGADTADGASDTGDAGDSASDFEAWEFASDFASFWQEFQWEFASDFAGASDGASDGGASDFASFEQAWEASDFA aSDFAWEQERQWa  TEQWTQWEDdaFDASDFAsdfADSFASDFQWERQdafadsfAQWErqEWRQdafsdAFDASDFADQE";
        sub = "FQWERQdafadsfAQWErqE";
        index = KMP_Search(source, sub);
        System.out.println("Substring index is: " + index);
        System.out.println("To Approve it: " + source.substring(index, index + sub.length()));

        source = "ABCDEFGADTADGASDTGDAGDSASDFEAWEFASDFASFWQEFQWEFASDFAGASDGASDGGASDFASFEQAWEASDFA aSDFAWEQERQWa  TEQWTQWEDdaabaabaabaabbbbaaaabbaSFASDFQWERQdafadsfAQWErqEWRQdafsdAFDASDFADQE";
        sub = "daabaabaabaabbbbaaaabba";
        index = KMP_Search(source, sub);
        System.out.println("Substring index is: " + index);
        System.out.println("To Approve it: " + source.substring(index, index + sub.length()));

        source = "ABCDEFGADTADGASDTGDAGDSASDFEAWEFASDFASFWQEFQWEFASDFAGASDGASDGGASDFASFEQAWEASDFA aSDFAWEQERQWa  TEQWTQWEDaaabaaacaaabaaadaaabaaaeSFASDFQWERQdafadsfAQWErqEWRQdafsdAFDASDFADQE";
        sub = "aaabaaacaaabaaadaaabaaae";
        index = KMP_Search(source, sub);
        System.out.println("Substring index is: " + index);
        System.out.println("To Approve it: " + source.substring(index, index + sub.length()));

        source = "abcdefg";
        sub = "x";
        index = KMP_Search(source, sub);
        System.out.println("Substring index is: " + index);
        System.out.println("To Approve it: " + (index >= 0 ? source.substring(index, index + sub.length()) :  "[]"));
    }
}
