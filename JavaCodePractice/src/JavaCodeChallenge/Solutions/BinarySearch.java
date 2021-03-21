/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 * Binary Search practice Binary search only applies to sorted array
 *
 * @author tangz
 */
public class BinarySearch {

    /**
     * If found target X, return true, otherwise return false
     *
     * @param input integer array
     * @param x int value that we are looking for
     * @return true if found otherwise return false
     */
//    public boolean binarySearch(int[] input, int x) {
//        if (input.length == 0) {
//            return false;
//        }
//        int low = 0;
//        int high = input.length - 1;
//        while (low <= high) {
//            int mid = (high + low) / 2;
//            if (input[mid] == x) {
//                return true;
//            } else if (input[mid] < x) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return false;
//    }
    
    public boolean binarySearch(int [] arr, int x) {
        if (arr.length == 0){
            return false;
        } 
        int low =0;
        int high = arr.length -1; //Here is the place easy to have error
        while (low <= high) {
            int mid = (low + high)/2;
            if (arr[mid] == x){
                return true;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int[] a = {-100, -1, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        int x = 9;
        if (b.binarySearch(a, x)) {
            System.out.println("Found " + x);
        } else {
            System.out.println("Not Found " + x);
        }
        
        x = 25;
        if (b.binarySearch(a, x)) {
            System.out.println("Found " + x);
        } else {
            System.out.println("Not Found " + x);
        }

        x = 21;
        if (b.binarySearch(a, x)) {
            System.out.println("Found " + x);
        } else {
            System.out.println("Not Found " + x);
        }

        x = 0;
        if (b.binarySearch(a, x)) {
            System.out.println("Found " + x);
        } else {
            System.out.println("Not Found " + x);
        }

        x = -1;
        if (b.binarySearch(a, x)) {
            System.out.println("Found " + x);
        } else {
            System.out.println("Not Found " + x);
        }

        x = 100;
        if (b.binarySearch(a, x)) {
            System.out.println("Found " + x);
        } else {
            System.out.println("Not Found " + x);
        }
    }
}
