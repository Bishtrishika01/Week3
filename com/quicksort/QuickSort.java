/*Quick Sort - Sort Product Prices
Problem Statement:
An e-commerce company wants to display product prices in ascending order. Implement Quick Sort to sort the product prices.
Hint:
Pick a pivot element (first, last, or random).
Partition the array such that elements smaller than the pivot are on the left and larger ones are on the right.
Recursively apply Quick Sort on left and right partitions.
*/
package com.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] productPrices = {350, 290, 529, 269, 699, 59};
        System.out.println("Product price before sorting - " + Arrays.toString(productPrices));

        //Method calling
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("Product price after sorting - " +Arrays.toString(productPrices));
    }
}