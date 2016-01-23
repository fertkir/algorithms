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

}
