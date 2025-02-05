/*StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to remove all duplicate characters from a given string while maintaining the original order.
Approach:
Initialize an empty StringBuilder and a HashSet to keep track of characters.
Iterate over each character in the string:
If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
Return the StringBuilder as a string without duplicates.*/
package com.StringBuilder;
import java.util.HashSet;

public class RemoveDuplicatesFromString {
    public static void main(String[] args){
        String str = "abcvcvxvxvxvxcba";
        System.out.println("Before removing duplicate: "+str);
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
        }
        System.out.println("After removing duplicate: "+sb);
    }
}
