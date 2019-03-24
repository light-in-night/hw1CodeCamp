// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

package assign1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCodeTest {
    @Test
    public void testBlowup1() {
        // basic cases
        assertEquals("abcd", StringCode.blowup("abcd"));
        assertEquals("xxxx", StringCode.blowup("3x"));
        assertEquals("3xxxx", StringCode.blowup("13x"));
        assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
        assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
        assertEquals("attttxzzz", StringCode.blowup("a3tx2z"));
    }

    @Test
    public void testBlowup2() {
        // things with digits

        // digit at end
        assertEquals("axxx", StringCode.blowup("a2x3"));

        // digits next to each other
        assertEquals("a33111", StringCode.blowup("a231"));

        // try a 0
        assertEquals("aabb", StringCode.blowup("aa0bb"));
        assertEquals("2xxx", StringCode.blowup("12x"));
        assertEquals("233444", StringCode.blowup("1234"));
        assertEquals("233444555566666", StringCode.blowup("123456"));
    }

    @Test
    public void testBlowup3() {
        // weird chars, empty string
        assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
        assertEquals("", StringCode.blowup(""));

        // string with only digits
        assertEquals("1", StringCode.blowup("11"));
        assertEquals("", StringCode.blowup("2"));
        assertEquals("33", StringCode.blowup("23"));
        assertEquals("111", StringCode.blowup("1111"));
    }


    @Test
    public void testRun1() {
        assertEquals(2, StringCode.maxRun("hoopla"));
        assertEquals(3, StringCode.maxRun("hoopllla"));
        assertEquals(4, StringCode.maxRun("aaabbbba"));
    }

    @Test
    public void testRun2() {
        assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
        assertEquals(0, StringCode.maxRun(""));
        assertEquals(3, StringCode.maxRun("hhhooppoo"));
        assertEquals(3, StringCode.maxRun("xxx"));
    }

    @Test
    public void testRun3() {
        // "evolve" technique -- make a series of test cases
        // where each is change from the one above.
        assertEquals(1, StringCode.maxRun("123"));
        assertEquals(2, StringCode.maxRun("1223"));
        assertEquals(2, StringCode.maxRun("112233"));
        assertEquals(3, StringCode.maxRun("1112233"));

        assertEquals(1, StringCode.maxRun("a"));
        assertEquals(0, StringCode.maxRun(""));
        assertEquals(3, StringCode.maxRun("   "));
    }

    @Test
    public void testStringIntersect1() {
        assertTrue(StringCode.stringIntersect("123", "234", 2));
        assertFalse(StringCode.stringIntersect("213111", "23112", 4));
        assertTrue(StringCode.stringIntersect("xazay", "y", 1));
    }

    @Test
    public void testStringIntersect2() {
        assertTrue(StringCode.stringIntersect("x x x", " x ", 1));
        assertTrue(StringCode.stringIntersect("...a", ".a.a.", 2));
        assertFalse(StringCode.stringIntersect("xyba", "zyba", 4));
    }

    @Test
    public void testStringIntersect3() {
        assertFalse(StringCode.stringIntersect("", ".", 1));
        assertTrue(StringCode.stringIntersect("", "", 0));

        assertFalse(StringCode.stringIntersect("aba", "bbabb", 10));
        assertFalse(StringCode.stringIntersect("aaaa", "a", 2));
        assertFalse(StringCode.stringIntersect("a", "aaaaa", 2));
        assertTrue(StringCode.stringIntersect("b", "aaaab", 1));

        assertTrue(StringCode.stringIntersect("1234", "1234", 2));
        assertTrue(StringCode.stringIntersect("1234", "1234", 4));
    }
}
