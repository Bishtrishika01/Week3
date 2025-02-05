/*StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation
Problem:
Write a program that compares the performance of StringBuffer and StringBuilder for concatenating strings. For large datasets (e.g., concatenating 1 million strings), compare the execution time of both classes.
Approach:
Initialize two StringBuffer and StringBuilder objects.
Perform string concatenation in both objects, appending 1 million strings (e.g., "hello").
Measure the time taken to complete the concatenation using System.nanoTime() for both StringBuffer and StringBuilder.
Output the time taken by both classes for comparison.*/
package com.StringBuffer;

public class ComparingStringBuilderAndStringBuffer {
    public static void main(String[] args){
        int iterations = 1_000_000;
        String text = "hello";

        long startTime1 = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            buffer.append(text);
        }
        long endTime1 = System.nanoTime();
        long stringBufferTime = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append(text);
        }
        long endTime2 = System.nanoTime();
        long stringBuilderTime = endTime2 - startTime2;

        System.out.println("StringBuffer time: " + stringBufferTime / 1_000_000 + " ms");
        System.out.println("StringBuilder time: " + stringBuilderTime / 1_000_000 + " ms");

    }
}
