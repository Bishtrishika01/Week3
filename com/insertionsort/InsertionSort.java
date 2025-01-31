/*Insertion Sort - Sort Employee IDs
Problem Statement:
A company stores employee IDs in an unsorted array. Implement Insertion Sort to sort the employee IDs in ascending order.
Hint:
Divide the array into sorted and unsorted parts.
Pick an element from the unsorted part and insert it into its correct position in the sorted part.
Repeat for all elements.*/
package com.insertionsort;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionsort(int[] employeeId){
        int n = employeeId.length;
        for(int i=1; i<n; i++){
            int current = employeeId[i];
            int j = i-1;
            while(j >= 0 && employeeId[j]>current){
                employeeId[j+1] = employeeId[j];
                j--;
            }
            employeeId[j+1] = current;
        }
    }
    public static void main(String[] args){
        int[] employeeId ={114,118,112,115,111};
        System.out.println("Employee Ids Before Sorting : "+Arrays.toString(employeeId));
        insertionsort(employeeId);
        System.out.println("Employee Ids After Sorting : "+Arrays.toString(employeeId));
    }
}
