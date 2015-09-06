package com.company.other;

/**
 * Created by fertkir on 06.09.15.
 */
public class Fib {

    public static long fib_bad(long i) {
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return fib_bad(i - 2) + fib_bad(i - 1);
    }

    public static long fib_good(long i) {
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        long[] pair = new long[] {0, 0};
        fib_good(i, pair);
        return pair[1];
    }

    private static void fib_good(long i, long[] pair) {
        if (i == 1) {
            return;
        }
        if (i == 2) {
            pair[1] += 1;
            return;
        }
        fib_good(i - 1, pair);
        pair[1] = pair[0] + pair[1];
        pair[0] = pair[1] - pair[0];
    }

    public static void main(String[] args) {
        System.out.println(fib_good(70));
    }
}
