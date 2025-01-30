/*Sliding Window Maximum
Problem: Given an array and a window size k, find the maximum element in each sliding window of size k.
Hint: Use a deque (double-ended queue) to maintain indices of useful elements in each window.*/
package com.stackandqueue;

import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] num, int k) {
        if (num == null || k <= 0) return new int[0];

        int n = num.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = num[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = {2,-4,3,4,-3,-4,8,6};
        int k = 3;
        int[] result = maxSlidingWindow(num, k);

        System.out.println("Sliding Window Maximums: " + Arrays.toString(result));
    }
}

