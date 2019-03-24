package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str string to calculate max run on
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str.isEmpty()) return 0;

        int result = 1;

        int currentBest = 1;
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1)) {
                currentBest++;
                if (currentBest > result)
                    result = currentBest;
            } else {
                currentBest = 1;
            }
        }

        return result;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str string to blowup.
     * @return blown up string
     */
    public static String blowup(String str) {
        if (str.isEmpty()) return "";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                if (i < str.length() - 1) {
                    result.append(nChars(str.charAt(i + 1), Character.getNumericValue(str.charAt(i))));
                }
            } else {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }

    /**
     * Returns N consecutive chars as a String.
     */
    private static String nChars(char charAt, int numericValue) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numericValue; i++) {
            result.append(charAt);
        }
        return result.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (len == 0) return true;

        HashSet<String> aSubstrSet = new HashSet<>();
        for (int i = 0; i < a.length() - len + 1; i++) {
            aSubstrSet.add(a.substring(i, i + len));
        }

        for (int i = 0; i < b.length() - len + 1; i++) {
            if (aSubstrSet.contains(b.substring(i, i + len)))
                return true;
        }
        return false;
    }
}
