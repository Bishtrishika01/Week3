/*3.Problem Statement: String Concatenation Performance
Objective:
Compare the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating a million strings.
Approach:
Using String (Immutable, creates new object each time)
Using StringBuilder (Fast, mutable, thread-unsafe)
Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
Comparative Analysis:
Operations Count (N)
String (O(N²))
StringBuilder (O(N))
StringBuffer (O(N))
1,000
10ms
1ms
2ms
10,000
1s
10ms
12ms
1,000,000
30m (Unusable)
50ms
60ms

Expected Result:
StringBuilder & StringBuffer are much more efficient than String.
Use StringBuilder for single-threaded operations and StringBuffer for multi-threaded*/
package com.runtimeanalysisandbigonotation;

public class Problem3 {

    public static void concatUsingString(String[] dataElement) {
        String result = "";
        for (String s : dataElement) {
            result = result + s;  // Inefficient due to immutability
        }
    }

    public static void concatUsingStringBuilder(String[] dataElement) {
        StringBuilder result = new StringBuilder();
        for (String s : dataElement) {
            result.append(s);
        }
    }

    public static void concatUsingStringBuffer(String[] dataElement) {
        StringBuffer result = new StringBuffer();
        for (String s : dataElement) {
            result.append(s);
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        String data = "Rishika";

        for (int size : sizes) {
            String[] dataElement = new String[size];
            for (int j = 0; j < size; j++) {
                dataElement[j] = data;
            }

            System.out.println("___________________________________________");
            System.out.println("Array size: " + size);

            long start = System.nanoTime();
            concatUsingString(dataElement);
            long end = System.nanoTime();
            System.out.println("String Time: " + (end - start) / 1_000_000 + " ms.");

            start = System.nanoTime();
            concatUsingStringBuilder(dataElement);
            end = System.nanoTime();
            System.out.println("\nStringBuilder Time: " + (end - start) / 1_000_000 + " ms.");

            start = System.nanoTime();
            concatUsingStringBuffer(dataElement);
            end = System.nanoTime();
            System.out.println("\nStringBuffer Time: " + (end - start) / 1_000_000 + " ms.");
        }
    }
}
