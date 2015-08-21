package com.company.sorts;

/**
 * @author Kirill Fertikov
 */
public class Bubble {

    public static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            boolean sorted = true;
            for (int i = 0; i < arr.length - k; i++) {
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
