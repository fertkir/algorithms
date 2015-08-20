package com.company.sorts;

/**
 * @author Kirill Fertikov
 */
public class Selection {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minInd = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minInd] ) {
                    minInd = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = tmp;
        }
    }
}
