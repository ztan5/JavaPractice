/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Demo for priority queue usage
 * @author tangz
 */
public class PriorityQueueDemo {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<100; i++){
            list.add((int)(Math.random() * 10));
        }
        PriorityQueue<Integer> threadQueue = new PriorityQueue<>();
        threadQueue.addAll(list);
        System.out.println("Waiting threads...");
        for (Integer thread : threadQueue){
            System.out.print(thread + ","); //Noticed if we print out we found it's not sorted
        }
        System.out.println("\nDeploying threads...");
        while(!threadQueue.isEmpty()){
            System.out.print(threadQueue.poll() + ","); //Noticed if we poll them out, they will be in order
        }
    }
}
