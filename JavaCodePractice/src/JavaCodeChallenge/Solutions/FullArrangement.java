/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 全排列Ⅱ
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2] 输出: [ [1,1,2], [1,2,1], [2,1,1] ]
 *
 * @author tangz
 */
public class FullArrangement {

    List<List<Integer>> getFullArrangement(Integer[] array) {

        List resultList = new ArrayList<String>();
        Map index = new HashMap<String, Boolean>();
        //Ascendint order
        Arrays.sort(array);

        doScan(array, index);

        Arrays.sort(array, Collections.reverseOrder());

        doScan(array, index);

        Iterator<String> it = index.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            resultList.add(key);
        }

        return resultList;
    }

    Map<String, Boolean> doScan(Integer[] array, Map<String, Boolean> index) {

        if (array.length == 0) {
            return index;
        }

        Queue scanner = new LinkedList<String>();
        String tmpStr = "";
        for (int i = 0; i < array.length; i++) {
            tmpStr = String.valueOf(array[i]);
            scanner.add(tmpStr);
        }
        index.put(peekAll(scanner), true);
        while (true) {
            String c = (String) scanner.remove();
            scanner.add(c);
            String strNew = peekAll(scanner);
            if (index.get(strNew) == null) {
                index.put(strNew, true);
            } else {
                break;
            }
        }

        return index;
    }

    String peekAll(Queue q) {
        String str = "";
        for (Object s : q.toArray()) {
            str += ((String) s);
        }
        return str;
    }

    public static void main(String[] args) {
        FullArrangement solution = new FullArrangement();
        Integer[] numbers0 = {1, 1};
        List<List<Integer>> result0 = solution.getFullArrangement(numbers0);
        System.out.println(result0);
        
        Integer[] a = {1, 2};
        List<List<Integer>> r = solution.getFullArrangement(a);
        System.out.println(r);

        Integer[] numbers1 = {1, 3, 2};
        List<List<Integer>> result1 = solution.getFullArrangement(numbers1);
        System.out.println(result1);

        Integer[] numbers2 = {1, 1, 2, 2};
        List<List<Integer>> result2 = solution.getFullArrangement(numbers2);
        System.out.println(result2);

        Integer[] numbers3 = {1, 1, 2, 3};
        List<List<Integer>> result3 = solution.getFullArrangement(numbers3);
        System.out.println(result3);

        Integer[] numbers4 = {1, 1, 2, 3, 4, 6};
        List<List<Integer>> result4 = solution.getFullArrangement(numbers4);
        System.out.println(result4);

        Integer[] numbers5 = {9, 9, 9, 9};
        List<List<Integer>> result5 = solution.getFullArrangement(numbers5);
        System.out.println(result5);

        Integer[] numbers6 = {};
        List<List<Integer>> result6 = solution.getFullArrangement(numbers6);
        System.out.println(result6);
    }
}
