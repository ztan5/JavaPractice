/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Demo how to use hashset and scanner to take user input
 * @author tangz
 */
public class DistinctWordSetAndScanner {
    public static void main(String[] args){
//        int count = 0;
//        Set<String> words = new HashSet<>();
//        Scanner in = new Scanner(System.in);
//        String str;
//        while( !(str = in.nextLine()).equals("")) {
//            count++;
//            words.add(str);
//        }
//        
//        System.out.println("...");
//        System.out.println("Total number of words entered: " + count);
//        System.out.println("Distinct words: " + words.size());
//        System.out.println("...");
//        Iterator<String> it = words.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        
        String[] dupStringArray = new String[3];
        dupStringArray[0] = "word";
        dupStringArray[1] = "word";
        dupStringArray[2] = "word";
        Set<String> words1 = new HashSet<>(Arrays.asList(dupStringArray)); //Can easily remove dups
        System.out.println("Test array: " + Arrays.toString(dupStringArray)); //This is how we print array
        System.out.println("Test array to hashset: " + words1); //we can print hashset like this
        
    }
    
}
