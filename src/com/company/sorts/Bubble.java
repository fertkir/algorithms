package com.company.sorts;

/**
 * @author Kirill Fertikov
 */
public class Bubble {

    public static void sort(int[] arr) {
        for (int k = 0; k < arr.length - 1; k++) {
            boolean sorted = true;
            for (int i = 0; i < arr.length - k - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
}
