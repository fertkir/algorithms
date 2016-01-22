package com.company.other;

import java.time.LocalTime;
import java.util.Arrays;

import static java.time.LocalTime.of;

/**
 * In the office each visitor’s arrival and departure times are registered. So at the end of the day for N
 * visitors there are N pairs of values: the first value in pair is arrival time and the second – departure time.
 * Need to find time interval during the day when there are maximum visitors in the office.
 *
 * OR
 *
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that no train waits
 *
 * Complexity: O(nlogn)
 */
public class TimePeriod {

    public static void main(String[] args) {
        LocalTime[] arrivals = new LocalTime[] {
                of(9, 0), of(9, 40), of(9, 50), of(11, 0), of(15, 0), of(18, 0)
        };
        LocalTime[] departures = new LocalTime[] {
                of(9, 10), of(12, 0), of(11, 20), of(11, 30), of(19, 0), of(20, 0)
        };
        Result result = getTimePeriod(arrivals, departures);

        System.out.println("There were " + result.count +
                " visitors since " + result.arrival + " till " + result.departure);

        System.out.println("Minimum number of platforms required " + result.count +
                " (between " + result.arrival + " and " + result.departure + ")");
    }

    static class Result {
        LocalTime arrival;
        LocalTime departure;
        int count;
    }

    public static Result getTimePeriod(LocalTime[] arrivals, LocalTime[] departures) {
        arrivals = Arrays.copyOf(arrivals, arrivals.length);
        departures = Arrays.copyOf(departures, departures.length);
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        int i = 0; int j = 0;
        int bestI = 0; int bestJ = 0;
        while (i < arrivals.length && j < departures.length) {
            if (arrivals[i].compareTo(departures[j]) < 0) {
                if ((i - j) > (bestI - bestJ)) {
                    bestI = i; bestJ = j;
                }
                i++;
            } else {
                j++;
            }
        }
        Result result = new Result();
        result.count = bestI - bestJ + 1;
        result.arrival = arrivals[bestI];
        result.departure = departures[bestJ];
        return result;
    }
}
