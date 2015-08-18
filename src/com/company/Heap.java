package com.company;

/**
 * Created by fertkir on 18.08.15.
 */
public class Heap {

    public static int[] sort(int[] arr, Order order) {
        // building heap
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            sink(arr, i, arr.length - 1, order);
        }
        // sorting
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            sink(arr, 0, i - 1, order);
        }
        return arr;
    }

    private static void sink(int[] arr, int index, int lastElemIndex, Order order) {
        int leftInd = index * 2 + 1;
        if (leftInd > lastElemIndex) {
            return;
        }
        int rightInd = leftInd + 1;
        int biggest = (rightInd > lastElemIndex) ? (leftInd) : ((ordered(arr[rightInd], arr[leftInd], order)) ? leftInd : rightInd);
        if (ordered(arr[biggest], arr[index], order)) {
            return;
        }
        swap(arr, index, biggest);
        sink(arr, biggest, lastElemIndex, order);
    }

    private static boolean ordered(int a, int b, Order order) {
        return (order == Order.ASC) ? (a < b) : (a > b);
    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
