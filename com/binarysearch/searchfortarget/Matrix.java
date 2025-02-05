/*Binary Search Problem 3: Search for a Target Value in a 2D Sorted Matrix
Problem:
You are given a 2D matrix where each row is sorted in ascending order, and the first element of each row is greater than the last element of the previous row. Write a program that performs Binary Search to find a target value in the matrix. If the value is found, return true. Otherwise, return false.
Approach:
Treat the matrix as a 1D array (flattened version).
Initialize left as 0 and right as rows * columns - 1.
Perform binary search:
Find the middle element index mid = (left + right) / 2.
Convert mid to row and column indices using row = mid / numColumns and col = mid % numColumns.
Compare the middle element with the target:
If it matches, return true.
If the target is smaller, search the left half by updating right = mid - 1.
If the target is larger, search the right half by updating left = mid + 1.
If the element is not found, return false.*/
package com.binarysearch.searchfortarget;

public class Matrix {
    public static void main(String[] args) {
        int [][] input = { {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}};

        int target = 16;

        boolean result = searchTargetValue(input,target);

        System.out.println("Target " + target + " found : "+ result );
    }
    public static boolean searchTargetValue(int[][] input, int target){
        int rows = input.length;
        int columns = input[0].length;

        int left = 0;
        int right = rows * columns -1;

        while(left <= right){

            int mid = (left + right) / 2;

            int midValue = input[mid / columns][mid % columns];

            if(midValue == target){
                return true;
            }

            else if(midValue < target){
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
