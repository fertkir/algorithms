package com.company.other;

/**
 * Created by fertkir on 06.09.15.
 */
public class Fib {

    public static long fib_bad(int n) {
        if (n < 1) throw new IllegalArgumentException();
        if (n == 1) return 0;
        if (n == 2) return 1;
        return fib_bad(n - 2) + fib_bad(n - 1);
    }

    public static long fib_good(int n) {
        if (n < 1) throw new IllegalArgumentException();
        long[] pair = new long[2];
        fib_good(n, pair);
        return pair[1];
    }

    private static void fib_good(int n, long[] pair) {
        if (n == 1) {
            pair[0] = 0;
            pair[1] = 0;
            return;
        }
        if (n == 2) {
            pair[0] = 0;
            pair[1] = 1;
            return;
        }
        fib_good(n - 1, pair);
        long prev = pair[1];
        pair[1] = pair[0] + pair[1];
        pair[0] = prev;
    }

    public static long fib_iter(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        long prev = 0;
        long cur = 1;
        for (int i = 3; i <= n; i++) {
            long newPrev = cur;
            cur += prev;
            prev = newPrev;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(fib_good(70));
        System.out.println(fib_iter(70));
    }
}
