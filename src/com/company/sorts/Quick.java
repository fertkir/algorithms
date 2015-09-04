package com.company.sorts;

/**
 * Created by fertkir on 20.08.15.
 */
public class Quick {

    public static void sort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    private static void partition(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[end];
        int pIndex = start;
        int i = start;
        while (i < end) {
            if (arr[i] < pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
            i++;
        }
        swap(arr, pIndex, i);
        partition(arr, start, pIndex - 1);
        partition(arr, pIndex + 1, end);
    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
