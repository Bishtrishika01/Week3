/*Find All Subarrays with Zero Sum
Problem: Given an array, find all subarrays whose elements sum up to zero.
Hint: Use a hash map to store the cumulative sum and its frequency. If a sum repeats, a zero-sum subarray exists.*/
package com.hashmapandhashfunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays {
    public static List<List<Integer>> findZeroSumSubarrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> sumMap = new HashMap<>();

        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];

            if (cumulativeSum == 0) {
                List<Integer> subarray = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    subarray.add(nums[j]);
                }
                result.add(subarray);
            }

            if (sumMap.containsKey(cumulativeSum)) {
                ArrayList<Integer> list = sumMap.get(cumulativeSum);
                for (int startIndex : list) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = startIndex + 1; j <= i; j++) {
                        subarray.add(nums[j]);
                    }
                    result.add(subarray);
                }
            }

            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,-5,10,9,-6,3,2};

        List<List<Integer>> result = findZeroSumSubarrays(nums);

        for (List<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }
}