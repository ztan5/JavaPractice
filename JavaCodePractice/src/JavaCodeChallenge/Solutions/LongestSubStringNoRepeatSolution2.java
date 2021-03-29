/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 *
 * @author tangz
 */
public class LongestSubStringNoRepeatSolution2 {

    /**
     * Returns the first longest no repeat sub-string
     *
     * @param s {@link String}
     * @return the first longest none repeat sub-string
     */
    public String lengthOfLongestSubstring(String s) {
        Queue<Character> cue = new LinkedList<Character>();
        Map<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
        String strTemp = "";
        String strNoneRepeat = "";
        if (s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        //Poll very charcters before the first occurance of a repeated character
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (cue.contains(c) == false){
                cue.add(c);
                strNoneRepeat += c;
            } else {  
                map.put(strNoneRepeat.length(), strNoneRepeat);
                strNoneRepeat = "";
                
                while (cue.peek().compareTo(c) != 0){
                    strTemp += cue.poll();
                }
                strTemp += cue.poll(); //Poll the first repeated one
                map.put(strTemp.length(), strTemp);
                cue.add(c);//because the repeated character is removed. we add current one into queue
                strTemp = "";
            }
        }

       String strCue = "";
       //If anything still in the queue, we should add into map
       while(!cue.isEmpty()){
           strCue += cue.poll();
       }
       map.put(strCue.length(), strCue);
        
       
       Iterator<Integer> it = map.keySet().iterator();
       while (it.hasNext()) {
           Integer key = it.next();
           return map.get(key);
       }
       
       return "";
    }

    public static void main(String[] args) {
        LongestSubStringNoRepeatSolution2 so = new LongestSubStringNoRepeatSolution2();
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
