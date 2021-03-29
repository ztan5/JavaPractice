/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * This class is a simple demo of how to use linked list we have two linked list
 * [a, a, a, a, a] and [b, b, b, b, b] how to merge them into a linked list [a,
 * b, a, b, a, b, a, b, a, b] Then can we remove all [a] in the merged linked
 * list
 *
 * @author tangz
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        List<String> aList = new LinkedList<>();
        List<String> bList = new LinkedList<>();
        aList.add("a");
        aList.add("a");
        aList.add("a");
        aList.add("a");
        aList.add("a");
        bList.add("b");
        bList.add("b");
        bList.add("b");
        bList.add("b");
        bList.add("b");
        System.out.println("A list: " + aList);
        System.out.println("B list: " + bList);
        ListIterator<String> aListIterator = aList.listIterator();
        Iterator<String> bIterator = bList.iterator();
        while (bIterator.hasNext()) {
            if (aListIterator.hasNext()) {
                aListIterator.next();
                aListIterator.add(bIterator.next());
            } else {
                bList.add(bIterator.next());
            }
        }
        
        System.out.println("Merged A B List: " + aList);
        
        aList.removeAll(bList);
        
        System.out.println("Remove b list elements: " + aList);
        
    }
}
