/*StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
Problem:
You are given an array of strings. Write a program that uses StringBuffer to concatenate all the strings in the array efficiently.
Approach:
Create a new StringBuffer object.
Iterate through each string in the array and append it to the StringBuffer.
Return the concatenated string after the loop finishes.
Using StringBuffer ensures efficient string concatenation due to its mutable nature.*/
package com.StringBuffer;

public class ConcatenateStringUsingStringBuffer {
    public static void main(String[] args){
        String[] arr = {"My","Name","is","Rishika"};

        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
            buffer.append(arr[i]+" ");
        }
        System.out.println("Concatenation of String Array Using String Buffer : "+buffer);
    }
}
