/*FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader
Problem:
Write a program that uses FileReader and BufferedReader to read a file and count how many times a specific word appears in the file.
Approach:
Create a FileReader to read from the file and wrap it in a BufferedReader.
Initialize a counter variable to keep track of word occurrences.
For each line in the file, split it into words and check if the target word exists.
Increment the counter each time the word is found.
Print the final count.*/
package com.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrenceofWordinFileUsingFileReader {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\lenovo\\Desktop\\Java Fundamental\\Week3\\StringBuilderAndStringBuffer\\src\\main\\java\\com\\filereader\\Problem2.txt";
        String targetWord = "Sunlight";

        int count = 0;

        try (FileReader fileReader = new FileReader(fileName); BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println(targetWord + " - " + count + " times");
        }
        catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

