package com.company.other;

import com.company.Common;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by fertkir on 06.09.15.
 */
public class BinSearch {

    public static int binSearch(int[] arr, int value) {
        return binSearch(arr, 0, arr.length - 1, value);
    }

    private static int binSearch(int[] arr, int start, int end, int value) {
        if (end - start < 0 ) {
            return -1;
        }
        int mid = (end - start + 1) / 2 + start;
        if (arr[mid] < value) {
            return binSearch(arr, mid + 1, end, value);
        } else if (arr[mid] > value) {
            return binSearch(arr, start, mid - 1, value);
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = Common.generate(10);
        Arrays.sort(arr);
        System.out.print("Array: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
        int value = new Random().nextInt(20);
        System.out.print("Value " + value);
        int index = binSearch(arr, value);
        System.out.println((index == -1) ? (" not found") : (" has index " + index));
    }
}
