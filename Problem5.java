/*5. Problem Statement: Recursive vs Iterative Fibonacci Computation
Objective:
Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
Approach:
Recursive:
public static int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

Iterative:
public static int fibonacciIterative(int n) {
    int a = 0, b = 1, sum;
    for (int i = 2; i <= n; i++) {
        sum = a + b;
        a = b;
        b = sum;
    }
    return b;
}
Comparative Analysis:
Fibonacci (N)
Recursive (O(2ⁿ))
Iterative (O(N))
10
1ms
0.01ms
30
5s
0.05ms
50
Unfeasible (>1hr)
0.1ms

Expected Result:
Recursive approach is infeasible for large values of N due to exponential growth.
The iterative approach is significantly faster and memory-efficient.*/
package com.runtimeanalysisandbigonotation;

import java.util.Random;

public class Problem5 {

    public static int fibonacciRecursive(int n) {
            if (n <= 1) return n;
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if(n==0) return 0;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args){
        Random random = new Random();

        int number = random.nextInt(80);

        long startTime = System.currentTimeMillis();
        int result1 = fibonacciIterative(number);
        long totalTimeByIterative= System.currentTimeMillis()- startTime;

        startTime = System.currentTimeMillis();
        int result2=fibonacciRecursive(number);
        long totalTimeByRecursion = System.currentTimeMillis()- startTime;

        System.out.println("Number is: "+ number);
        System.out.println("Result by iterative is: "+ result1);
        System.out.println("Result by recursion is: "+result2);
        System.out.println("Time taken to compute fibonacci by iterative approach is: "+ totalTimeByIterative+ " MS");
        System.out.println("Time taken to compute fibonacci by recursion approach is: "+ totalTimeByRecursion+ " MS");
    }
}