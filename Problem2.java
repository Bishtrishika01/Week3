/*2.Problem Statement: Sorting Large Data Efficiently
Objective:
Compare sorting algorithms Bubble Sort (O(N²)), Merge Sort (O(N log N)), and Quick Sort (O(N log N)).4
Approach:
Bubble Sort: Repeated swapping (inefficient for large data).
Merge Sort: Divide & Conquer approach (stable).
Quick Sort: Partition-based approach (fast but unstable).



Comparative Analysis:
Dataset Size (N)
Bubble Sort (O(N²))
Merge Sort (O(N log N))
Quick Sort (O(N log N))
1,000
50ms
5ms
3ms
10,000
5s
50ms
30ms
1,000,000
Unfeasible (>1hr)
3s
2s

Expected Result:
Bubble Sort is impractical for large datasets.
Merge Sort & Quick Sort perform well.*/
package com.runtimeanalysisandbigonotation;

import java.util.Random;

public class Problem2 {
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length > 999999) {
                System.out.println("Not feasible");
                break;
            }
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void conquer(int[] arr,int si,int mid,int ei){
        int[] merge = new int[ei-si+1];
        int n = si;
        int m = mid+1;
        int j =0;
        while(n<=mid && m<=ei){
            if (arr[n] <= arr[m]) {
                merge[j++] = arr[n++];
            } else {
                merge[j++] = arr[m++];
            }
        }
        while(n<=mid){
            merge[j++] = arr[n++];
        }
        while(m<=ei){
            merge[j++] = arr[m++];
        }
        System.arraycopy(merge,0,arr,si,merge.length);
    }
    public static void divide(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }
    public static void mergeSort(int[] arr, int si,int ei){
        divide(arr,si,ei);
    }
    public static int partition(int[] arr,int si,int ei){
        int pivot = arr[ei];
        int j=si-1;
        for(int i =si;i<=ei-1;i++){
            if (arr[i] <= pivot) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        j++;
        int temp = arr[ei];
        arr[ei] = arr[j];
        arr[j] = temp;

        return j;
    }
    public static void quickSort(int[] arr,int si,int ei){
        if(si<ei){
            int pIdx = partition(arr,si,ei);
            quickSort(arr,si,pIdx-1);
            quickSort(arr,pIdx+1,ei);

        }
    }
    public static void main(String[] args){
        int[] array = {1000,10000,1000000};
        Random random = new Random();
        for(int i =0;i<array.length;i++){
            int[] arr = new int[array[i]];
            int si = 0;
            int ei = arr.length-1;

            for(int j =0; j<array[i];j++){
                arr[j] = random.nextInt(array[i]) ;
            }
            System.out.println("______________________________________________");
            System.out.println("Array size : "+array[i]);
            long start = System.nanoTime();
            bubbleSort(arr.clone());
            long end = System.nanoTime();
            System.out.println("Bubble Sort Time : "+ (end-start)/1000000.0+" ms.");

            start = System.nanoTime();
            mergeSort(arr.clone(),si,ei);
            end = System.nanoTime();
            System.out.println("\nMerge Sort Time : "+ (end-start)/1000000.0+" ms.");

            start = System.nanoTime();
            quickSort(arr.clone(),si,ei);
            end = System.nanoTime();
            System.out.println("\nQuick Sort Time : "+ (end-start)/1000000.0+" ms.");
        }

    }
}