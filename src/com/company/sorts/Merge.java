package com.company.sorts;

/**
 * @author Kirill Fertikov
 */
public class Merge {

    public static void sort(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        sort(arr, 0, arr.length - 1, copy);
    }

    private static void sort(int[] arr, int start, int end, int[] copy) {
        int lend = start + (end - start) / 2;
        int rstart = lend + 1;
        if (lend - start > 0) {
            sort(arr, start, lend, copy);
        }
        if (end - rstart > 0) {
            sort(arr, rstart, end, copy);
        }
        // merging
        int i = start;
        int lInd = start;
        int rInd = rstart;
        while (lInd <= lend && rInd <= end) {
            arr[i++] = (copy[lInd] < copy[rInd]) ? copy[lInd++] : copy[rInd++];
        }
        while (lInd <= lend) {
            arr[i++] = copy[lInd++];
        }
        System.arraycopy(arr, start, copy, start, end - start + 1);
    }
}
