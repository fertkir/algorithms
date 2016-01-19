package com.company.bitwise;

import static java.lang.System.out;

/**
 * Created by fertkir on 18.01.16.
 */
public class Bitwise {

    public static void main(String[] args) {
        out.println(numberOfOnes(9));
        out.println(findOddWhenOthersEven(new int[] {2, 3, 2, 2, 3, 6, 5, 5, 5, 6, 2}));
        out.println(findUniqueWhenTriple(new int[] {2, 3, 6, 2, 3, 6, 3, 5, 6, 2}));
        out.println(bitsToConvert1(31, 14));
        out.println(bitsToConvert2(31, 14));
        out.println(Integer.toBinaryString(swapEvenOddBits(0b011010110101)));
        out.println(Integer.toBinaryString(insert1(0b10000000000, 0b10101, 2, 6)));
        out.println(Integer.toBinaryString(insert2(0b10000000000, 0b10101, 2, 6)));
        out.println(Integer.toBinaryString(nextLargestWithSameOnesCount(0b101011)));
        out.println(Integer.toBinaryString(nextSmallestWithSameOnesCount(0b101011)));
    }

    /**
     * Please implement a function to get the number of 1s in an integer.
     * For example, the integer 9 is 1001 in binary, so it returns 2 since there are two bits of 1s.
     */
    public static int numberOfOnes(int value) {
        int count = 0;
        do {
            count += value & 1;
            value >>>= 1;
        } while (value != 0);
        return count;
    }

    /**
     * In an array, all numbers appear even number of times except one which appears odd number of times.
     * Please find the unique number.
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

    /**
     * Write a function to determine the number of bits required to convert integer A to integer B.
     */
    public static int bitsToConvert1(int a, int b) {
        return numberOfOnes(a^b);
    }

    public static int bitsToConvert2(int a, int b) {
        int count = 0;
        for (int xor = a ^ b; xor != 0; xor >>= 1) {
            count += xor & 1;
        }
        return count;
    }

    /**
     * Write a program to swap odd and even bits in an integer with as few instructions as
     * possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).
     */
    public static int swapEvenOddBits(int value) {
        return ((value & 0x55555555) << 1) | ((value & 0xAAAAAAA) >> 1);
    }

    /**
     * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
     * Write a method to set all bits between i and j in N equal to M
     * (e.g., M becomes a substring of N located at i and starting at j).
     *
     * EXAMPLE:
     * Input: N = 10000000000, M = 10101, i = 2, j = 6
     * Output: N = 10001010100
     */
    public static int insert1(int n, int m, int i, int j) {
        int mask = (~0 << (j + 1)) + (~0 >>> (32 - i));
        return (n & mask) + (m << i);
    }

    public static int insert2(int n, int m, int i, int j) {
        int mask = (~0 << (j + 1)) | ((1 << i) - 1);
        return (n & mask) | (m << i);
    }

    public static int nextLargestWithSameOnesCount(int value) {
        int onesCount = numberOfOnes(value);
        return ~0 << (32 - onesCount);
    }

    public static int nextSmallestWithSameOnesCount(int value) {
        int newValue = value;
        int zeroCount = 0;
        while (newValue % 2 == 0) {
            newValue >>= 1;
            zeroCount++;
        }
        int onesCount = 0;
        while (newValue % 2 != 0) {
            newValue >>= 1;
            onesCount++;
        }
        return value + (((1 << onesCount) - 1) << zeroCount);
    }
}
