package com.company.bitwise;

/**
 * Created by fertkir on 18.01.16.
 */
public class Bitwise {

    public static void main(String[] args) {
        System.out.println(findOddWhenOthersEven(new int[] {2, 3, 2, 2, 3, 6, 5, 5, 5, 6, 2}));
        System.out.println(findUniqueWhenTriple(new int[] {2, 3, 6, 2, 3, 6, 3, 5, 6, 2}));
    }

    /**
     * In an array, all numbers appear even number of times except one which appears odd number of times.
     * Please find the unique number.
     *
     * @param arr
     * @return
     */
    public static int findOddWhenOthersEven(int[] arr) {
        int unique = 0;
        for (int value : arr) {
            unique ^= value;
        }
        return unique;
    }

    /**
     * In an array, all numbers appear three times except one which only appears only once.
     * Please find the unique number.
     *
     * @param arr
     * @return
     */
    static int findUniqueWhenTriple(int[] arr) {
        int result = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int value : arr) {
                bits[i] += (value >>> i) & 1;
            }
            if (bits[i] % 3 != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }
}
