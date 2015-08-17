package com.company;

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
}
