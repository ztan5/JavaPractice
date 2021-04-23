/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.Arrays;

/**
 * This demo is to illustrate how to do a quick sort
 *
 * @author tangz
 */
public class QuickSortDemo {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }

            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }

            arr[high] = arr[low];
        }
        arr[low] = pivot;

        //System.out.println("Partition End " + Arrays.toString(arr));
        return low;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotPos = partition(arr, low, high);
            quickSort(arr, low, pivotPos - 1);
            quickSort(arr, pivotPos + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] test1 = {5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1};
        System.out.println("Before Sort: " + Arrays.toString(test1));
        quickSort(test1, 0, 11);
        System.out.println("After Sort:" + Arrays.toString(test1));

        int[] test2 = {12, 10, 9, 7};
        System.out.println("Before Sort: " + Arrays.toString(test2));
        quickSort(test2, 0, 3);
        System.out.println("After Sort:" + Arrays.toString(test2));

        int[] test3 = {5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1, 5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1,5, 4, 3, 7, 9, -1, -4, -5, 12, 10, 2, 1};
        System.out.println("Before Sort: " + Arrays.toString(test3));
        int high = test3.length - 1;
        quickSort(test3, 0, high);
        System.out.println("After Sort:" + Arrays.toString(test3));
    }
}
