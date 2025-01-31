/*Merge Sort - Sort an Array of Book Prices
Problem Statement:
A bookstore maintains a list of book prices in an array. Implement Merge Sort to sort the prices in ascending order.
Hint:
Divide the array into two halves recursively.
Sort both halves individually.
Merge the sorted halves by comparing elements.*/
package com.mergesort;
import java.util.Arrays;

public class MergeSort {
    public static void conquer(int[] arr,int si,int mid,int ei){
        int[] merge = new int[ei-si+1];
        int n = si;
        int m = mid+1;
        int x = 0;

        while(n<=mid && m<=ei){
            if(arr[n]<arr[m]){
                merge[x++] = arr[n++];
            }
            else{
                merge[x++] = arr[m++];
            }
        }

        while(n<=mid){
            merge[x++] = arr[n++];
        }

        while(m<=ei){
            merge[x++] = arr[m++];
        }

        for(int i=0,j=si;i<= merge.length-1;i++,j++){
            arr[j] = merge[i];
        }
    }
    public static void divide(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei - si)/2;

        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }
    public static void main(String[] args){
        int[] arr = {700,350,120,900,210};
        System.out.println("Bookstore book price before sorting : "+Arrays.toString(arr));
        int n = arr.length;
        divide(arr,0,n-1);
        System.out.println("Bookstore book price after sorting : "+Arrays.toString(arr));
    }
}
