/*4. Problem Statement: Large File Reading Efficiency
Objective:
Compare FileReader (Character Stream) and InputStreamReader (Byte Stream) when reading a large file (500MB).
Approach:
FileReader: Reads character by character (slower for binary files).
InputStreamReader: Reads bytes and converts to characters (more efficient).
Comparative Analysis:
File Size
FileReader Time
InputStreamReader Time
1MB
50ms
30ms
100MB
3s
1.5s
500MB
10s
5s

Expected Result:
InputStreamReader is more efficient for large files.
FileReader is preferable for text-based data.*/
package com.runtimeanalysisandbigonotation;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Problem4 {
    public static void readWithFileReader(String filePath){
        try(FileReader fr = new FileReader(filePath)){
            int character;
            while((character = fr.read()) != -1) {
                //Reading character by character
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void readWithInputStreamReader(String filePath){

        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            int character;
            while((character = inputStreamReader.read()) != -1) {
                // Reading character by character
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        String []filePaths={"C:\\Users\\lenovo\\Desktop\\Java Fundamental\\Week3\\untitled\\src\\main\\java\\com\\runtimeanalysisandbigonotation\\1mb-examplefile-com.txt", "C:\\Users\\lenovo\\Desktop\\Java Fundamental\\Week3\\untitled\\src\\main\\java\\com\\runtimeanalysisandbigonotation\\100mb-examplefile-com.txt", "C:\\Users\\lenovo\\Desktop\\Java Fundamental\\Week3\\untitled\\src\\main\\java\\com\\runtimeanalysisandbigonotation\\500mb-example-com.txt"};

        int []fileSize={1,100,500};
        int idx=0;
        for(String filePath : filePaths ){
            long startTime= System.currentTimeMillis();
            readWithFileReader(filePath);
            long totalTimeForFileReader = System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();
            readWithInputStreamReader(filePath);
            long totalTimeForInputStreamReader = System.currentTimeMillis() - startTime;

            System.out.println("File size: "+ fileSize[idx]+ " MB");
            System.out.println("Total time for file reading by File Reader: "+ totalTimeForFileReader/1000.0 + " S");
            System.out.println("Total time for file reading by Input Stream Reader: "+ totalTimeForInputStreamReader/1000.0+ " S");
            System.out.println("_______________________________________________________________________________________________");
            idx++;
        }
    }
}
