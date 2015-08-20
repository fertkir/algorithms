package com.company.sorts;

/**
 * @author Kirill Fertikov
 */
public class Insertion {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int holeId = i;
            while (holeId > 0 && arr[holeId-1] > current) {
                arr[holeId] = arr[holeId-1];
                holeId--;
            }
            arr[holeId] = current;
        }
    }
}
