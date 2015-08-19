package com.company.sorts;

/**
 * @author Kirill Fertikov
 */
public class Merge {

    public static void sort(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        sort(arr, 0, arr.length, copy);
    }

    private static void sort(int[] arr, int start, int size, int[] copy) {
        int lsize = size / 2;
        int rstart = start + lsize;
        int rsize = size - lsize;
        if (lsize > 1) {
            sort(arr, start, lsize, copy);
        }
        if (rsize > 1) {
            sort(arr, rstart, rsize, copy);
        }
        // merging
        int lInd = start;
        int rInd = rstart;
        int i = start;
        while (lInd < rstart && rInd < start + size) {
            arr[i++] = (copy[lInd] < copy[rInd]) ? copy[lInd++] : copy[rInd++];
        }
        while (lInd < rstart) {
            arr[i++] = copy[lInd++];
        }
        System.arraycopy(arr, start, copy, start, size);
    }
}
