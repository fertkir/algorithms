package com.company.sorts;

/**
 * @author Kirill Fertikov
 */
public class Merge {

    public static void sort(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        split(arr, 0, arr.length, copy);
    }

    private static void split(int[] arr, int start, int size, int[] copy) {
        int lstart = start;
        int lsize = size / 2;
        int rstart = start + lsize;
        int rsize = size - lsize;
        if (lsize > 1) {
            split(arr, lstart, lsize, copy);
        }
        if (rsize > 1) {
            split(arr, rstart, rsize, copy);
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
        while (rInd < start + size) {
            arr[i++] = copy[rInd++];
        }
        System.arraycopy(arr, start, copy, start, size);
    }
}
