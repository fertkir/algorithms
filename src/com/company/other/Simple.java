package com.company.other;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by fertkir on 06.09.15.
 */
public class Simple {

    public static List<Integer> simple(int limit) {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 2; i <= limit; i++) {
            numbers.add(i);
        }
        int p = 0;
        while (p < numbers.size()) {
            int pVal = numbers.get(p);
            for (ListIterator<Integer> iter = numbers.listIterator(p + 1); iter.hasNext();) {
                if (iter.next() % pVal == 0) {
                    iter.remove();
                }
            }
            p++;
        }
        return numbers;
    }

    public static void main(String[] args) {
        List<Integer> simpleNumbers = simple(100000);
        for (Integer val : simpleNumbers) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
