package com.company.other;

/**
 * Created by fertkir on 23.01.16.
 */
public class CommonNumber {

    public static void main(String[] args) {
        int[] x = new int[] {1,2,3,4,5,6,7,8,9};
        int[] y = new int[] {0,4,6,7,8,9,9,9,9,9};
        int[] z = new int[] {3,4,5,6,7,8,8,8,8};
        System.out.println(findCommonNumber(x, y, z));
    }

    /**
     * Find one of the numbers which exists in each of three nondecreasing arrays x[p], y[q], z[r].
     * Algorithm complexity should be O(p+q+r).
     */
    public static int findCommonNumber(int[] x, int[] y, int[] z) {
        int i = 0; int j = 0; int k = 0;
        while (i < x.length && j < y.length && k < z.length) {
            if (x[i] < y[j]) {
                i++;
            } else if (x[i] > y[j]) {
                j++;
            } else {
                if (x[i] < z[k]) {
                    i++; j++;
                } else if (x[i] > z[k]) {
                    k++;
                } else {
                    return z[k];
                }
            }
        }
        throw new IllegalArgumentException("Arrays do not contain same values, or they are not nondecreasing");
    }
}
