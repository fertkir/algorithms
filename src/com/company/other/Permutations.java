package com.company.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fertkir on 30.01.16.
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(permutationsOf1("abcd").toString());
        System.out.println(permutationsOf2("abcd").toString());
    }

    /**
     * Write a method to compute all permutations of a string. Variant 1.
     */
    public static List<String> permutationsOf1(String str) {
        List<String> perms = new ArrayList<>();
        if (str.length() == 1) {
            perms.add(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                for (String s : permutationsOf1(strWithoutCharAtIndex(str, i))) {
                    perms.add(String.valueOf(str.charAt(i)) + s);
                }
            }
        }
        return perms;
    }

    private static String strWithoutCharAtIndex(String str, int i) {
        String str1 = i > 0 ? str.substring(0, i) : "";
        String str2 = i < str.length() - 1 ? str.substring(i + 1) : "";
        return str1 + str2;
    }

    /**
     * Write a method to compute all permutations of a string. Variant 2.
     */
    public static List<String> permutationsOf2(String str) {
        List<String> perms = new ArrayList<>();
        permutationsOf2(str.toCharArray(), new char[str.length()], new HashSet<>(), perms);
        return perms;
    }

    private static void permutationsOf2(char[] source, char[] dest, HashSet<Integer> forbidden, List<String> perms) {
        if (forbidden.size() == source.length) {
            perms.add(new String(dest));
            return;
        }
        for (int i = 0; i < source.length; i++) {
            if (forbidden.contains(i)) {
                continue;
            }
            dest[forbidden.size()] = source[i];
            forbidden.add(i);
            permutationsOf2(source, dest, forbidden, perms);
            forbidden.remove(i);
        }
    }
}
