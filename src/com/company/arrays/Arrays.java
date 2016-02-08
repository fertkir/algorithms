package com.company.arrays;

import com.company.Common;

/**
 * Created by fertkir on 23.01.16.
 */
public class Arrays {

    public static void main(String[] args) {
        int[] a = Common.generate(5);
        int[] b = Common.generate(5);
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);
        a = java.util.Arrays.copyOf(a, a.length + b.length);
        System.out.println("a: " + java.util.Arrays.toString(a));
        System.out.println("b: " + java.util.Arrays.toString(b));
        merge(a, 5, b);
        System.out.println("a: " + java.util.Arrays.toString(a));
        System.out.println("max subsequence: " + java.util.Arrays.toString(maxSequence(new int[] { -1, 8, -4, 0, 100, -12 })));
    }

    /**
     * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B.
     * Write a method to merge B into A in sorted order.
     */
    public static void merge(int[] a, int sizeA, int[] b) {
        int curA = sizeA - 1;
        int curB = b.length - 1;
        int curTo = a.length - 1;
        while (curA >= 0 && curB >= 0) {
            a[curTo--] = (a[curA] > b[curB]) ? a[curA--] : b[curB--];
        }
        if (curB >= 0) {
            System.arraycopy(b, 0, a, 0, curB + 1);
        }
    }

    /**
     * Given an unsorted integer array containing values that are >, == or < 0.
     * Return the subarray of values, whose sum is maximum.
     */
    public static int[] maxSequence(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        int[] result = new int[maxEnd - maxStart + 1];
        System.arraycopy(arr, maxStart, result, 0, maxEnd - maxStart + 1);
        return result;
    }

}
