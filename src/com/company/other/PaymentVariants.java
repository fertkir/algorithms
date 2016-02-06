package com.company.other;

/**
 * Created by fertkir on 31.01.16.
 */
public class PaymentVariants {
    public static void main(String[] args) {
        System.out.println(paymentVariants(200));
        System.out.println(makeChange(200, 25));
    }

    /**
     * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
     * write code to calculate the number of ways of representing n cents. VARIANT 1.
     */
    public static int paymentVariants(int n) {
        if (n <= 0) {
            return 0;
        }
        return paymentVariants(n, new int[] {25, 10, 5, 1}, 0);
    }

    private static int paymentVariants(int n, int[] coins, int since) {
        if (n == 0) {
            return 1;
        }
        int variants = 0;
        if (n > 0) {
            for (int i = since; i < coins.length; i++) {
                variants += paymentVariants(n - coins[i], coins, i);
            }
        }
        return variants;
    }

    /**
     * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
     * write code to calculate the number of ways of representing n cents. VARIANT 2.
     */
    public static int makeChange(int n, int denom) {
        int nextDenom = 0;
        switch (denom) {
            case 25:
                nextDenom = 10;
                break;
            case 10:
                nextDenom = 5;
                break;
            case 5:
                nextDenom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange(n - i * denom, nextDenom);
        }
        return ways;
    }
}
