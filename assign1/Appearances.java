package assign1;

import java.util.*;

public class Appearances {

    /**
     * Returns the number of elements that appear the same number
     * of times in both collections. Static method. (see handout).
     *
     * @return number of same-appearance elements
     */
    public static <T> int sameCount(Collection<T> a, Collection<T> b) {
        Map<T, Integer> countA = countHistogram(a);
        Map<T, Integer> countB = countHistogram(b);
        int result = 0;
        for (T item : countA.keySet()) {
            if (countA.get(item).equals(countB.get(item))) {
                result++;
            }
        }
        return result;
    }

    /**
     * Makes a histogram of frequency of character occurrences.
     */
    private static <T> Map<T, Integer> countHistogram(Collection<T> items) {
        Map<T, Integer> count = new HashMap<>();
        for (T item : items) {
            if (!count.containsKey(item)) {
                count.put(item, 1);
            } else {
                count.put(item, count.get(item) + 1);
            }
        }
        return count;
    }
}
