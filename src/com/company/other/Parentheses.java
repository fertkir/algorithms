package com.company.other;

/**
 * Created by fertkir on 31.01.16.
 */
public class Parentheses {

    public static void main(String[] args) {
        printPar(3);
    }

    public static void printPar(int count) {
        printPar(count, count, new char[count*2], 0);
    }

    private static void printPar(int l, int r, char[] str, int i) {
        if (l < 0 || r < l) return; // invalid state
        if (l == 0 && r == 0) {
            System.out.println(str); // found one, so print it
        } else {
            if (l > 0) { // try a left paren, if there are some available
                str[i] = '(';
                printPar(l - 1, r, str, i + 1);
            }
            if (r > l) { // try a right paren, if there’s a matching left
                str[i] = ')';
                printPar(l, r - 1, str, i + 1);
            }
        }
    }
}
