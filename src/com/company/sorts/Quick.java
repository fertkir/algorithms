package com.company.sorts;

/**
 * Created by fertkir on 20.08.15.
 */
public class Quick {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        int pivot = end;
//        for () {
//
//        }
    }

    private static void partition() {

    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
