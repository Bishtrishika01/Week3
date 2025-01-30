/*Two Sum Problem
Problem: Given an array and a target sum, find two indices such that their values add up to the target.
Hint: Use a hash map to store the index of each element as you iterate. Check if target - current_element exists in the map.*/
package com.hashmapandhashfunction;

import java.util.HashMap;

public class TwoSumProblem {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {

                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result != null) {
            System.out.println("Indices of the two elements: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
}
