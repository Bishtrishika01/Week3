/* Counting Sort - Sort Student Ages
Problem Statement:
A school collects students’ ages (ranging from 10 to 18) and wants them sorted. Implement Counting Sort for this task.
Hint:
Create a count array to store the frequency of each age.
Compute cumulative frequencies to determine positions.
Place elements in their correct positions in the output array.*/
package com.countingsort;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - minAge]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--; // Decrease count
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 14, 11, 16, 18, 10, 15, 12, 17, 13, 11};
        System.out.println("Ages before sorting: " + Arrays.toString(studentAges));

        countingSort(studentAges, 10, 18);

        System.out.println("Ages after sorting: " + Arrays.toString(studentAges));
    }
}