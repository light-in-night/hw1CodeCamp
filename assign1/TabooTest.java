// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class TabooTest {
    /**
     * Utillity method, creates a new list from a string
     * using its chars as new list elements
     *
     * @param s string to be converted to string list
     * @return a strings list
     */
    private List<String> stringToList(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'X') {
                list.add(String.valueOf(s.charAt(i)));
            } else {
                list.add(null);
            }
        }
        return list;
    }

    /**
     * Utillity method, creates a new set from string's chars
     *
     * @param s string to be put into a new set
     * @return a new set of strings
     */
    private Set<String> stringToSet(String s) {
        if (s == null || s.isEmpty()) return Collections.emptySet();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
        }
        return set;
    }

    @Test
    public void testNoFollow1() {
        Taboo<String> tb = new Taboo<>(stringToList("abc"));
        assertTrue(stringToSet("b").equals(tb.noFollow("a")));

        tb = new Taboo<>(stringToList("abc"));
        assertTrue(stringToSet("c").equals(tb.noFollow("b")));

        tb = new Taboo<>(stringToList("abX"));
        assertTrue(stringToSet("").equals(tb.noFollow("b")));
    }

    @Test
    public void testNoFollow2() {
        Taboo<String> tb = new Taboo<>(stringToList("XaXcXaXbcacXaXac"));
        assertTrue(stringToSet("a").equals(tb.noFollow("c")));

        tb = new Taboo<>(stringToList("XaXcXbXbcacXaXac"));
        assertTrue(stringToSet("c").equals(tb.noFollow("b")));

        tb = new Taboo<>(stringToList("bbbbbb"));
        assertTrue(stringToSet("b").equals(tb.noFollow("b")));

        Taboo<Integer> tbInt = new Taboo<>(Arrays.asList(100, -2000, 2000, null, 3000, 400, 5000));
        Set<Integer> ans = new HashSet<>();
        ans.add(2000);
        assertTrue(ans.equals(tbInt.noFollow(-2000)));

        tbInt = new Taboo<>(Arrays.asList(100, -2000, null, 2000, 3000, 400, 5000));
        ans = Collections.emptySet();
        assertTrue(ans.equals(tbInt.noFollow(-2000)));
    }


    @Test
    public void testNoFollow3() {
        Taboo<String> tb = new Taboo<>(stringToList("XXXX"));
        assertTrue(stringToSet("").equals(tb.noFollow("c")));

        tb = new Taboo<>(stringToList(""));
        assertTrue(stringToSet("").equals(tb.noFollow("")));

        tb = new Taboo<>(stringToList(""));
        assertTrue(stringToSet("").equals(tb.noFollow("a")));

        tb = new Taboo<>(stringToList("aXa"));
        assertTrue(stringToSet("").equals(tb.noFollow("a")));

        tb = new Taboo<>(stringToList("aXa"));
        assertTrue(stringToSet("").equals(tb.noFollow("a")));
    }

    @Test
    public void testReduce1() {
        Taboo<String> tb = new Taboo<>(stringToList("bc"));
        List<String> test = stringToList("abcd");
        tb.reduce(test);
        assertEquals(test, (stringToList("abd")));

        tb = new Taboo<>(stringToList("bc"));
        test = stringToList("abccccccd");
        tb.reduce(test);
        assertEquals(test, (stringToList("abd")));

        tb = new Taboo<>(stringToList("bb"));
        test = stringToList("bbbbbb");
        tb.reduce(test);
        assertEquals(test, (stringToList("b")));
    }

    @Test
    public void testReduce2() {
        Taboo<String> tb = new Taboo<>(Arrays.asList("b", null, "c", null, "d"));
        List<String> test = stringToList("abcd");
        tb.reduce(test);
        assertEquals(test, (stringToList("abcd")));

        tb = new Taboo<>(stringToList("abcde"));
        test = stringToList("abcde");
        tb.reduce(test);
        assertEquals(test, (stringToList("ace")));

        tb = new Taboo<>(stringToList("XXXX"));
        test = stringToList("one");
        tb.reduce(test);
        assertEquals(test, (stringToList("one")));

        Taboo<Integer> tbInt = new Taboo<>(Arrays.asList(1, 2, 2, 3));
        List<Integer> testInt = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        tbInt.reduce(testInt);
        assertEquals(testInt, (Arrays.asList(1, 3, 4)));

        tbInt = new Taboo<>(Arrays.asList(1000, 2000, null, 3000, 4000, 5000));
        testInt = new ArrayList<>(Arrays.asList(2000, null, 3000, 4000));
        tbInt.reduce(testInt);
        assertEquals(testInt, (Arrays.asList(2000, null, 3000)));
    }

    @Test
    public void testReduce3() {
        Taboo<String> tb = new Taboo<>(stringToList("X"));
        List<String> test = stringToList("abcd");
        tb.reduce(test);
        assertEquals(test, stringToList("abcd"));

        tb = new Taboo<>(stringToList("a"));
        test = stringToList("aX");
        tb.reduce(test);
        assertEquals(test, stringToList("aX"));

        tb = new Taboo<>(stringToList(""));
        test = stringToList("o");
        tb.reduce(test);
        assertEquals(test, stringToList("o"));

        Taboo<Integer> tbInt = new Taboo<>(Arrays.asList(1));
        List<Integer> testInt = new ArrayList<>(Arrays.asList(1, null));
        tbInt.reduce(testInt);
        assertEquals(testInt, Arrays.asList(1, null));
    }
}
