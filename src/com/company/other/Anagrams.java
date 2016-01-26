package com.company.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by fertkir on 25.01.16.
 */
public class Anagrams {

    public static void main(String[] args) {
        String[] arr = {"qwerty", "god", "hi", "cat", "dog", "tac", "shoe", "ewrtqy", "act"};
        sortAnagrams(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sort an array of strings so that all the anagrams are next to each other
     */
    public static void sortAnagrams(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            private String sortChars(String str) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }
            @Override
            public int compare(String o1, String o2) {
                return sortChars(o1).compareTo(sortChars(o2));
            }
        });
    }

}
