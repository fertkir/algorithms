package com.company.other;

import java.util.ArrayList;

/**
 * Created by fertkir on 31.01.16.
 */
public class Robot {

    public static void main(String[] args) {
        System.out.println(possiblePaths(4));
    }

    public static int possiblePaths(int n) {
        if (n < 1) throw new IllegalArgumentException();
        return possiblePaths(n, 1, 1, 1);
    }

    private static int possiblePaths(int n, int i, int j, int pathsCount) {
        if (i == n && j == n) {
            return pathsCount;
        }
        if (i < n) {
            pathsCount += possiblePaths(n, i + 1, j, 0);
        }
        if (j < n) {
            pathsCount += possiblePaths(n, i, j + 1, i < n ? 1 : 0);
        }
        return pathsCount;
    }
}
