/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;

/**
 * Shell sort is an algorithm that first sorts the elements far apart from each
 * other and successively reduces the interval between the elements to be
 * sorted. It is a generalized version of insertion sort. In shell sort,
 * elements at a specific interval are sorted. The interval between the elements
 * is gradually decreased based on the sequence used. The performance of the
 * shell sort depends on the type of sequence used for a given input array.
 *
 * @author tangz
 */
public class ShellSort {

    public void InsertionSort(int[] arr, int dk) {
        int n = arr.length;
        for (int i = dk; i < n; i+=dk) {
            int key = arr[i];
            int prev = i - dk;
            while (prev >= 0 && key < arr[prev]) {
                arr[prev + dk] = arr[prev];
                arr[prev] = key;
                prev-=dk;
            }
        }
    }

    public void shellSort(int[] arr) {
        int n = arr.length;
        for (int dk = n / 2; dk >= 1; dk = dk / 2) {
            InsertionSort(arr, dk);
        }
    }

    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        int[] a1 = {1, 4, 5, 2, 3, 7, 9, 5, 12, 99, 0, 14, 29, 31, 110, -10, 12, 56};
        System.out.println("Original Array: " + Arrays.toString(a1));
        ss.shellSort(a1);
        System.out.println("After shell sorting Array: " + Arrays.toString(a1));
    }
}
