/*Selection Sort - Sort Exam Scores
Problem Statement:
A university needs to sort students’ exam scores in ascending order. Implement Selection Sort to achieve this.
Hint:
Find the minimum element in the array.
Swap it with the first unsorted element.
Repeat the process for the remaining elements.*/
package com.selectionsort;
import java.util.Arrays;

public class SelectionSort {
    public static void sorting(int[] examScores){
        int n = examScores.length;
        for(int i=0;i<=n-1;i++){
            int smallest = i;
            for(int j=i+1;j<= n-1;j++){
                if(examScores[smallest]>examScores[j]){
                    smallest = j;
                }
            }
            int temp = examScores[smallest];
            examScores[smallest] = examScores[i];
            examScores[i] = temp;
        }
    }
    public static void main(String[] args){
        int[] examScores = {87,69,93,55,42,76};
        System.out.println("Students Exam Scores before sorting : "+Arrays.toString(examScores));
        sorting(examScores);
        System.out.println("Students Exam Scores after sorting : "+Arrays.toString(examScores));
    }
}
