package com.company;

/**
 * @author Kirill Fertikov
 */
public class Merge {

    public static int[] sort(int[] arr) {
        split(arr, 0, arr.length);
        return arr;
    }

    private static void split(int[] arr, int start, int size) {
        int lstart = start;
        int lsize = size / 2;
        int rstart = lsize;
        int rsize = size - lsize;
        if (lsize > 1) {
            split(arr, lstart, lsize);
        }
        if (rsize > 1) {
            split(arr, rstart, rsize);
        }
        // merging
        int[] mergedArr = new int[size];
        int lInd = 0;
        int rInd = 0;
        int i = 0;
        while (lInd < lsize && rInd < rsize) {
            if (arr[lstart + lInd] > arr[rstart + rInd]) {
                mergedArr[i] = arr[lstart + lInd];
                lInd++;
            } else {
                mergedArr[i] = arr[rstart + rInd];
                rInd++;
            }
            i++;
        }
        while (lInd < lsize) {
            mergedArr[i] = arr[lstart + lInd];
            lInd++;
            i++;
        }
        while (rInd < rsize) {
            mergedArr[i] = arr[rstart + rInd];
            rInd++;
            i++;
        }
        System.arraycopy(mergedArr, 0, arr, start, size);
    }
}
