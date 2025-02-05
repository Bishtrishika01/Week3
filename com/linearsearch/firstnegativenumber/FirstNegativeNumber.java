//Search for the First Negative Number
//Problem:
//You are given an integer array. Write a program that performs Linear Search to find the first negative
// number in the array. If a negative number is found, return its index. If no negative number is found,
// return -1.
//Approach:
//Iterate through the array from the start.
//        Check if the current element is negative.
//If a negative number is found, return its index.
//If the loop completes without finding a negative number, return -1.

package com.linearsearch.firstnegativenumber;

public class FirstNegativeNumber {
    public static int firstNegativeNumber(int[] arr){
        int length=arr.length;
        for(int start=0; start<length; start++){
            //If we found any value less 0 directly returning the idx
            if(arr[start]<0){
                return start;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,3,7,-6,3,6,-2,23,9};
        int[] arr2={2,4,5,6,7,3,4,5,6,7};
        System.out.println(firstNegativeNumber(arr)); //3
        System.out.println(firstNegativeNumber(arr2)); //-1
    }
}
