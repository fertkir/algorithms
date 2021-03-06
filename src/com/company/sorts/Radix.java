package com.company.sorts;

import java.util.*;

/**
 * @author Kirill Fertikov
 */
public class Radix {

    public static void sort(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int digitsCount = (int) Math.log10(maxValue) + 1;
        Bucket bucket = new Bucket();
        for (int radix = 0; radix < digitsCount; radix++) {
            for (int val : arr) {
                bucket.put(getDigit(val, radix), val);
            }
            bucket.toArray(arr);
        }
    }

    public static int getDigit(int number, int radix) {
        return number % (int) Math.pow(10, radix + 1) / (radix == 0 ? 1 : (int) Math.pow(10, radix));
    }

    private static class Bucket {

        private static final int BASE = 10;

        private List[] lists = new List[BASE];

        {
            for (int i = 0; i < BASE; i++) {
                lists[i] = new ArrayList<>();
            }
        }

        public void put(int key, int value) {
            lists[key].add(value);
        }

        public void toArray(int[] arr) {
            int j = 0;
            for (int i = 0; i < BASE; i++) {
                for (Object val : lists[i]) {
                    arr[j++] = (int) val;
                }
                lists[i].clear();
            }
        }
    }
}
