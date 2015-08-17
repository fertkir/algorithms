package com.company;

/**
 * Created by fertkir on 18.08.15.
 */
public class Heap {

    public static int[] sort(int[] arr) {
        makeHeap(arr);

        // todo

        return arr;
    }

    private static void makeHeap(int[] arr) {
        int lastElemsParent = (arr.length - 3) / 2; // why 3?
        for (int i = lastElemsParent; i >= 0; i--) {
            int leftInd = i*2 + 1;
            int rightInd = i*2 + 2;
            if (arr[i] > arr[leftInd] || arr[i] > arr[rightInd]) {
                swap(arr, i, (arr[leftInd] > arr[rightInd]) ? leftInd : rightInd);
            }
        }
    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
