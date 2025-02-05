/*Challenge Problem (for both Linear and Binary Search)
Problem:
You are given a list of integers. Write a program that uses Linear Search to find the first missing positive integer in the list and Binary Search to find the index of a given target number.
Approach:
Linear Search for the first missing positive integer:
Iterate through the list and mark each number in the list as visited (you can use negative marking or a separate array).
Traverse the array again to find the first positive integer that is not marked.
Binary Search for the target index:
After sorting the array, perform binary search to find the index of the given target number.
Return the index if found, otherwise return -1.*/
package com.challengeproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ComparingLinearSearchBinarySearch {
    List<Integer> list = new LinkedList<>();

    public static int findMissingNumberLinear(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) <= 0 || list.get(i) > n) {
                list.set(i, n + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(list.get(i));
            if (num <= n && list.get(num - 1) > 0) {
                list.set(num - 1, -list.get(num - 1));
            }
        }

        for (int i = 0; i < n; i++) {
            if (list.get(i) > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
    public static int findTargetIndexBinary(List<Integer> list, int target){
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid;
            }

            else if (list.get(mid) > target) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(-1);
        list.add(1);

        int firstMissingPositive =findMissingNumberLinear(list);
        System.out.println("The first missing positive integer is: " + firstMissingPositive);

        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(3);
        sortedList.add(5);
        sortedList.add(7);
        sortedList.add(9);
        sortedList.add(11);

        Collections.sort(sortedList);

        int target = 7;
        int targetIndex = findTargetIndexBinary(sortedList, target);
        if (targetIndex != -1) {
            System.out.println("The index of target " + target + " is: " + targetIndex);
        } else {
            System.out.println("Target " + target + " not found.");
        }
        int targetNotFound = 6;
        int targetNotFoundIndex = findTargetIndexBinary(sortedList, targetNotFound);
        if (targetNotFoundIndex != -1) {
            System.out.println("The index of target " + targetNotFound + " is: " + targetNotFoundIndex);
        } else {
            System.out.println("Target " + targetNotFound + " not found.");
        }
    }
}
