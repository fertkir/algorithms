package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] arr = Common.generate(10);
        System.out.print("Initial: ");
        Common.print(arr);

        // sorting with standard algorithm for control
        int[] checkCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(checkCopy);

        Common.control(arr, checkCopy, "Heap");
        Common.control(arr, checkCopy, "Merge");
        Common.control(arr, checkCopy, "Bubble");
    }
}
