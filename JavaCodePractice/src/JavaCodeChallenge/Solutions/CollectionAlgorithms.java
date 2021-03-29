/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This demo is to show how to use some of the built in Algorithm of Java Collections interface
 * @author tangz
 */
public class CollectionAlgorithms {
    
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<100; i++){
            list.add( (int)(Math.random() * 100) );
        }
        
        Collections.sort(list);
        
        
        System.out.println("Sorted Array: " + list);
        
        int testNumber = 10;
        
        int index = Collections.binarySearch(list, testNumber);
        if (index >= 0){
            System.out.println("Number " + testNumber + " found at index: " + index);
        } else {
            System.out.println("Number " + testNumber + " is not found");
        }
        
        System.out.println("Max number: " + Collections.max(list));
        System.out.println("Min number: " + Collections.min(list));
        System.out.println("Frequency of " + testNumber + ": " + Collections.frequency(list, testNumber));
        
        Set<Integer> sortedList = new HashSet<>();
        sortedList.addAll(list);
        System.out.println("Number of distinct elements: " + sortedList.size());
        
        list.clear();
        list.addAll(sortedList);
        Collections.shuffle(list);
        List<Integer> topTenList = list.subList(0, 10);
        Collections.sort(topTenList);
        System.out.println("Top 10: " + topTenList);
    }
    
}
