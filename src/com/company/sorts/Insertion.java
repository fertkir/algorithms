package com.company.sorts;

/**
 * @author Kirill Fertikov
 */
public class Insertion {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < current) {
                    break;
                }
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = current;
        }
    }
}
