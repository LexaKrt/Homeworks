package ru.itis.inf304.lab2_7_test;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap elements
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            n--; // Optimization: Last element is already sorted
        } while (swapped);
        return arr;
    }
}
