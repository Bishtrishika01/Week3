/*Bubble Sort - Sort Student Marks
Problem Statement:
A school maintains student marks in an array. Implement Bubble Sort to sort the student marks in ascending order.
Hint:
Traverse through the array multiple times.
Compare adjacent elements and swap if needed.
Repeat the process until no swaps are required.*/
package com.bubblesort;
import java.util.Arrays;

public class BubbleSort {
    public static int[] bubblesort(int[] marks){
        int n = marks.length;
        boolean isSwapped;
        for(int i=0; i<n-1;i++){
            isSwapped = false;
            for(int j=0;j<n-1-i;j++){
                if (marks[j]>marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
        return marks;
    }
    public static void main(String[] args){
        int[] marks = {85,62,57,61};
        System.out.println("Student marks before sort : "+Arrays.toString(marks));
        bubblesort(marks);
        System.out.println("Student marks after sort : "+Arrays.toString(marks));
    }
}