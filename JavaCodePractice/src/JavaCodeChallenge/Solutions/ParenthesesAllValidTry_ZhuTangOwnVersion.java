/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This Implementation failed in teat case 6 when we input number 6
 * It shows less result than Leetcode solution
 * @author tangz
 */
public class ParenthesesAllValidTry_ZhuTangOwnVersion {

    public static String ssl(String str) {
        return "()" + str;
    }

    public static String ssr(String str) {
        return str + "()";
    }

    public static String addLayer(String str) {
        return "(" + str + ")";
    }

    public static List<String> insertLayer(String str){
        List<String> list = new ArrayList<>();
        int n = str.length();
        int cur = 0;
        int next = cur + 1;
        while (next < n){
            if (str.charAt(cur) == '(' && str.charAt(next) == ')'){
                list.add(insertAt(str, "()", cur));
            }
            cur++;
            next++;
        }
        
        return list;
    }
    
    public static String insertAt(String originalStr, String toBeInserted, int index){
        String newString = originalStr.substring(0, index+1) + toBeInserted + originalStr.substring(index + 1);
        return newString;
    }
    
    
    public static List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>(doGen(n));
        return new ArrayList(result);
    }

    public static List<String> doGen(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0){
            return list;
        }
        
        if (n == 1) {
            list.add("()");
            return list;
        }

        if (n == 2) {
            list.add("()()");
            list.add("(())");
            return list;
        }

        Iterator<String> it = doGen(n - 1).iterator();
        while (it.hasNext()) {
            String str = it.next();
            list.add(ssl(str));
            list.add(ssr(str));
            list.add(addLayer(str));
            list.addAll(insertLayer(str));
        }

        return list;
    }

    public static void main(String[] args) {
//        System.out.println(generateParenthesis(0));
//        System.out.println(generateParenthesis(1));
//        System.out.println(generateParenthesis(2));
//        System.out.println(generateParenthesis(3));
//        System.out.println(generateParenthesis(4));
//        System.out.println(generateParenthesis(5));
        System.out.println(generateParenthesis(6));
    }
}
