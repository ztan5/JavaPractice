/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 * Very basic sort algorithm : Insertion Sort
 *
 * @author tangz
 */
public class InsertSort {
    public int[] InsertionSortAsc(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int prev = i - 1;
            while (prev >= 0 && key < arr[prev]) {
                arr[prev + 1] = arr[prev];
                arr[prev] = key;
                prev--;
            }
        }
        return arr;
    }

    public String print(int[] inputArray) {
        StringBuilder s1 = new StringBuilder();
        s1.append("[");

        if (inputArray.length == 0) {
            s1.append("]");
        } else {
            for (int j = 0; j < inputArray.length; j++) {
                s1.append(inputArray[j]);
                if (j < inputArray.length - 1) {
                    s1.append(", ");
                } else {
                    s1.append("]");
                }
            }
        }
        return s1.toString();
    }

    public static void main(String[] args) {
        InsertSort s = new InsertSort();
        //Test one 
        int[] a = {1, 4, 5, 2, 3, 7, 9, 5};
        System.out.println(s.print(s.InsertionSortAsc(a)));

        int[] a1 = {4, 5, 1, 66, 29, 20, 20, -10, 0, 21, 12};
        System.out.println(s.print(s.InsertionSortAsc(a1)));

        int[] a2 = {12, 44, 5, 6, 2, 1, 23, 43, 7, 99};
        System.out.println(s.print(s.InsertionSortAsc(a2)));

        int[] a3 = {12};
        System.out.println(s.print(s.InsertionSortAsc(a3)));

        int[] a4 = {};
        System.out.println(s.print(s.InsertionSortAsc(a4)));
    }
}
