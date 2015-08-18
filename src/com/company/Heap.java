package com.company;

/**
 * Created by fertkir on 18.08.15.
 */
public class Heap {

    public static int[] sort(int[] arr, Order order) {
        // building heap
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            toPlace(i, arr, arr.length - 1, order);
        }
        // deleting maximums
        int lastElem = arr.length - 1;
        while (lastElem > 0) {
            swap(arr, 0, lastElem);
            lastElem--;
            toPlace(0, arr, lastElem, order);
        }
        return arr;
    }

    private static void toPlace(int index, int[] arr, int lastElemIndex, Order order) {
        while (true) {
            int leftInd = index * 2 + 1;
            if (leftInd > lastElemIndex) {
                break;
            }
            int rightInd = index * 2 + 2;
            int biggest = leftInd;
            if (rightInd <= lastElemIndex) {
                biggest = (compare(arr[rightInd], arr[leftInd], order)) ? leftInd : rightInd;
            }
            if (compare(arr[index], arr[biggest], order)) {
                swap(arr, index, biggest);
            }
            index = biggest;
        }
    }

    private static boolean compare(int a, int b, Order order) {
        return (order == Order.ASC) ? (a < b) : (a > b);
    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
