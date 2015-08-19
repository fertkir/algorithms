package com.company.sorts;

/**
 * Created by fertkir on 18.08.15.
 */
public class Heap {

    public static int[] sort(int[] arr) {
        // building max-heap
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            sink(arr, i, arr.length - 1);
        }
        // sorting (moving max element to tail)
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            sink(arr, 0, i - 1);
        }
        return arr;
    }

    private static void sink(int[] arr, int index, int lastElemIndex) {
        int leftInd = index * 2 + 1;
        if (leftInd > lastElemIndex) {
            return;
        }
        int rightInd = leftInd + 1;
        int max = (rightInd > lastElemIndex) ? (leftInd) : ((arr[leftInd] > arr[rightInd]) ? leftInd : rightInd);
        if (arr[max] < arr[index]) {
            return;
        }
        swap(arr, index, max);
        sink(arr, max, lastElemIndex);
    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
