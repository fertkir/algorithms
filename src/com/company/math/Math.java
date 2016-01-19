package com.company.math;

import static java.lang.System.out;

/**
 * Created by fertkir on 19.01.16.
 */
public class Math {

    public static void main(String[] args) {
        out.println(findMissing(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 10, 11}));
    }

    /**
     * Find missing number in unsorted natural sequence 1..N
     * If the input array is not correct, the result is unexpected.
     */
    public static int findMissing(int[] naturalSequence) {
        int sum = 0;
        for (int value : naturalSequence) {
            sum += value;
        }
        int n = naturalSequence.length;
        int pairsNumber = n + 1;
        int sumOfPairs = (n % 2 == 0) ? sum : (sum - pairsNumber / 2);
        return pairsNumber - sumOfPairs % pairsNumber;
    }
}
