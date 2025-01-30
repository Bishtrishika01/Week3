/*Circular Tour Problem
Problem: Given a set of petrol pumps with petrol and distance to the next pump, determine the starting point for completing a circular tour.*/
package com.stackandqueue;

class CircularTourProblem {

    public static int findStartingPump(int[] petrol, int[] distance) {
        int totalSurplus = 0;
        int totalDeficit = 0;
        int start = 0;
        int currentSurplus = 0;

        for (int i = 0; i < petrol.length; i++) {
            int netGain = petrol[i] - distance[i];
            currentSurplus += netGain;
            totalSurplus += netGain;

            if (currentSurplus < 0) {
                start = i + 1;
                totalDeficit += currentSurplus;
                currentSurplus = 0;
            }
        }

        return (totalSurplus + totalDeficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {5,8,9,5};
        int[] distance = {9,8,6,4};

        int startIndex = findStartingPump(petrol, distance);
        System.out.println("Starting Pump Index: " + startIndex);
    }
}

