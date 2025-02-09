/*1.Problem Statement: Search a Target in a Large Dataset
Objective:
Compare the performance of Linear Search (O(N)) and Binary Search (O(log N)) on different dataset sizes.
Approach:
Linear Search: Scan each element until the target is found.
Binary Search: Sort the data first (O(N log N)), then perform O(log N) search.
Comparative Analysis:
Dataset Size (N)
Linear Search (O(N))
Binary Search (O(log N))
1,000
1ms
0.01ms
10,000
10ms
0.02ms
1,000,000
1s
0.1ms

Expected Result:
Binary Search performs much better for large datasets, provided data is sorted.*/

package com.runtimeanalysisandbigonotation;

import java.util.Arrays;
import java.util.Random;

public class Problem1 {

    public static int binarySearch(int[] arr, int target, int si, int ei) {
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] < target) {
                si = mid + 1;
            } else if (arr[mid] > target) {
                ei = mid - 1;
            } else {
                return mid;  // Correct match
            }
        }
        return -1;
    }

    public static int linearSearch(int[] arr,int target){
        for(int i=0;i<= arr.length-1;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {1000,10000,1000000};
        Random random = new Random();

        for(int i =0; i < arr.length;i++){
            int[] arrElement = new int[arr[i]];
            for(int j=0;j<arr[i];j++){
                arrElement[j] = j;
            }
            int target = random.nextInt(arr[i]);

            long start = System.nanoTime();
            linearSearch(arrElement,target);
            long end = System.nanoTime();
            System.out.println("Linear Search Time : "+(end-start)/100000.0+" ms.");

            Arrays.sort(arrElement);
            start =System.nanoTime();
            binarySearch(arrElement,target,0,arrElement.length-1);
            end = System.nanoTime();
            System.out.println("Binary Search Time : "+(end-start)/100000.0+" ms.");
            System.out.println();
        }
    }
}