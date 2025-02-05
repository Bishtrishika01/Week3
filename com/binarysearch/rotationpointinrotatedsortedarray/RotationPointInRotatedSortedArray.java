/*Find the Rotation Point in a Rotated Sorted Array
Problem:
You are given a rotated sorted array. Write a program that performs Binary Search to find the index of the smallest element in the array (the rotation point).
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[right], then the smallest element is in the right half, so update left = mid + 1.
If arr[mid] < arr[right], the smallest element is in the left half, so update right = mid.
Continue until left equals right, and then return arr[left] (the rotation point).*/

package com.binarysearch.rotationpointinrotatedsortedarray;

public class RotationPointInRotatedSortedArray {
    public static int rotationPointInRotatedSortedArray(int[] arr){
        int left =0;
        int right = arr.length -1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid]>arr[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {

        int[] arr={4,5,6,7,8,9,1,2,3};
        int idx= rotationPointInRotatedSortedArray(arr);
        System.out.println(idx);

        int[] arr2={1,2,3,4,5,6};
        idx=rotationPointInRotatedSortedArray(arr2);
        System.out.println(idx);

    }
}
