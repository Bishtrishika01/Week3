/*Check for a Pair with Given Sum in an Array
Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
Hint: Store visited numbers in a hash map and check if target - current_number exists in the map.*/
package com.hashmapandhashfunction;

import java.util.*;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;

            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,8,12};
        int target = 18;

        if (hasPairWithSum(nums, target)) {
            System.out.println("Pair with given sum exists.");
        } else {
            System.out.println("No pair with the given sum exists.");
        }
    }
}