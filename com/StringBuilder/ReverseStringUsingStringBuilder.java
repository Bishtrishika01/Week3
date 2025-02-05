/*StringBuilder Problem 1: Reverse a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello", the output should be "olleh".
Approach:
Create a new StringBuilder object.
Append the string to the StringBuilder.
Use the reverse() method of StringBuilder to reverse the string.
Convert the StringBuilder back to a string and return it.*/
package com.StringBuilder;

public class ReverseStringUsingStringBuilder {
    public static void main(String[] args){
        String str = "Hello";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
        }
        System.out.println("Before : "+sb);
        for(int i=0;i<sb.length()/2;i++){
            int first = i;
            int last = sb.length()-1-i;
            char charAtFront = sb.charAt(first);
            char charAtBack = sb.charAt(last);
            sb.setCharAt(first,charAtBack);
            sb.setCharAt(last,charAtFront);
        }
        System.out.println("After : "+sb);
    }
}
