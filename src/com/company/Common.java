package com.company;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by fertkir on 18.08.15.
 */
public class Common {

    public static int[] generate(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(size * 2);
        }
        return arr;
    }

    public static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(", ");
        }
        System.out.println(sb.toString());
    }

    public static void control(int[] arr, int[] checkCopy, String name) throws Exception {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Class.forName("com.company.sorts." + name).getMethod("sort", int[].class).invoke(null, copy);
        boolean sortedCorrectly = Arrays.equals(checkCopy, copy);
        System.out.print(name + " sort" + (sortedCorrectly ? "" : " (ERROR!!)") + ": ");
        Common.print(copy);
    }
}
