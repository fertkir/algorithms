package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = Common.generate(10);
        System.out.print("Initial: ");
        Common.print(arr);
//        Heap.sort(arr, Order.ASC);
        Merge.sort(arr);
        System.out.print(" Result: ");
        Common.print(arr);
    }
}
