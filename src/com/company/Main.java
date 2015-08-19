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

        control(arr, checkCopy, "Heap");
        control(arr, checkCopy, "Merge");
    }

    public static void control(int[] arr, int[] checkCopy, String name) throws Exception {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Class.forName("com.company.sorts." + name).getMethod("sort", int[].class).invoke(null, copy);
        boolean sortedCorrectly = Arrays.equals(checkCopy, copy);
        System.out.print(name + " sort" + (sortedCorrectly ? "" : " (ERROR!!)") + ": ");
        Common.print(copy);
    }
}
