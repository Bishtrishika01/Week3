/*6. Problem Statement: Comparing Different Data Structures for Searching
Objective:
Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching elements.
Approach:
Array: Linear search (O(N)).
HashSet: Uses hashing (O(1) on average).
TreeSet: Balanced BST (O(log N)).
Comparative Analysis:
Dataset Size (N)
Array Search (O(N))
HashSet Search (O(1))
TreeSet Search (O(log N))
1,000
1ms
0.01ms
0.1ms
100,000
100ms
0.01ms
10ms
1,000,000
1s
0.01ms
20ms

Expected Result:
HashSet is fastest for lookups but requires extra memory.
TreeSet maintains order but is slightly slower than HashSet.*/
package com.runtimeanalysisandbigonotation;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Random;

public class Problem6 {
    public class LinearSearch {
        public static boolean search(int[] array, int key) {
            //Method to time comparison at linear search
            long startTime = System.currentTimeMillis();
            for (int num : array) {
                if (num == key) {
                    return true;
                }
            }
            return false;
        }
    }

    public class HashSetComparison {
        public static boolean search(HashSet<Integer> hashSet, int key) {
            return hashSet.contains(key);
        }
    }

    public class TreeSetComparison {
        public static boolean search(TreeSet<Integer> treeSet, int key) {
            return treeSet.contains(key);
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {

            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size);
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            int key = array[random.nextInt(size)];

            long startTime = System.nanoTime();
            boolean arraySearchResult = LinearSearch.search(array, key);
            long arraySearchTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            boolean hashSetSearchResult = HashSetComparison.search(hashSet, key);
            long hashSetSearchTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            boolean treeSetSearchResult = TreeSetComparison.search(treeSet, key);
            long treeSetSearchTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + arraySearchTime / 1000000.0 + " ms");
            System.out.println("HashSet Search Time: " + hashSetSearchTime / 1000000.0 + " ms");
            System.out.println("TreeSet Search Time: " + treeSetSearchTime / 1000000.0 + " ms");
            System.out.println("____________________________________________________________________");
        }
    }
}