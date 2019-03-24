// Test cases for CharGrid -- a few basic tests are provided.
package assign1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharGridTest {

    @Test
    public void testCharArea1() {
        char[][] grid = new char[][]{
                {'a', 'y', ' '},
                {'x', 'a', 'z'},
        };


        CharGrid cg = new CharGrid(grid);

        assertEquals(4, cg.charArea('a'));
        assertEquals(1, cg.charArea('z'));
        assertEquals(1, cg.charArea('x'));
        assertEquals(1, cg.charArea(' '));
    }


    @Test
    public void testCharArea2() {
        char[][] grid = new char[][]{
                {'c', 'a', ' '},
                {'b', ' ', 'b'},
                {' ', ' ', 'a'}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(6, cg.charArea('a'));
        assertEquals(3, cg.charArea('b'));
        assertEquals(1, cg.charArea('c'));
        assertEquals(0, cg.charArea('&'));
    }

    @Test
    public void testCharArea3() {
        char[][] grid = new char[][]{
                {'c', 'a', 'm', 'b'},
                {'b', ' ', 'b', 'b'},
                {' ', ' ', 'a', 'a'},
                {'c', ' ', 'a', 'z'},
                {'z', ' ', ' ', 'z'},
        };
        CharGrid cg = new CharGrid(grid);

        assertEquals(12, cg.charArea('a'));
        assertEquals(8, cg.charArea('b'));
        assertEquals(4, cg.charArea('c'));
        assertEquals(0, cg.charArea('&'));
        assertEquals(8, cg.charArea('z'));
        assertEquals(8, cg.charArea('z'));
        assertEquals(1, cg.charArea('m'));

        grid = new char[][]{
                {'c'}
        };
        cg = new CharGrid(grid);

        assertEquals(1, cg.charArea('c'));
        assertEquals(0, cg.charArea(' '));
    }


    @Test
    public void testCountPlus1() {
        char[][] grid = new char[][]{
                {'x', 'x'},
                {'x', 'x'}
        };

        CharGrid cg = new CharGrid(grid);
        assertEquals(0, cg.countPlus());

        grid = new char[][]{
                {' ', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'b'},
                {'x', 'x', 'x', 'b'},
                {' ', 'x', 'x', 'b'},
        };

        cg = new CharGrid(grid);
        assertEquals(0, cg.countPlus());

        grid = new char[][]{
                {' ', 'x', ' ', ' '},
                {'x', 'x', 'x', ' '},
                {' ', 'x', 'x', 'x'},
                {' ', ' ', 'x', ' '},
        };

        cg = new CharGrid(grid);
        assertEquals(2, cg.countPlus());
    }

    @Test
    public void testCountPlus2() {
        char[][] grid = new char[][]{
                {' ', 'x', ' ', ' '},
                {'x', 'x', 'x', ' '},
                {' ', 'x', ' ', 'x'},
                {' ', ' ', 'x', ' '},
        };

        CharGrid cg = new CharGrid(grid);
        assertEquals(1, cg.countPlus());

        grid = new char[][]{
                {' ', 'x', 'x', 'x'},
                {'x', 'y', 'x', 'b'},
                {'y', 'y', 'b', 'b'},
                {' ', 'y', 'x', 'b'},
        };

        cg = new CharGrid(grid);
        assertEquals(0, cg.countPlus());

        grid = new char[][]{
                {' ', 'x', ' ', ' '},
                {'x', 'x', 'x', 'x'},
                {' ', 'x', ' ', ' '},
                {' ', 'x', ' ', ' '},
        };

        cg = new CharGrid(grid);
        assertEquals(0, cg.countPlus());
    }

    @Test
    public void testCountPlus3() {
        char[][] grid = new char[][]{
                {' '}
        };

        CharGrid cg = new CharGrid(grid);
        assertEquals(0, cg.countPlus());

        grid = new char[][]{
                {' ', 'x', 'x', ' '},
                {'x', 'x', 'a', 'x'},
                {' ', 'a', 'a', 'a'},
                {' ', 'x', 'a', ' '},
        };

        cg = new CharGrid(grid);
        assertEquals(1, cg.countPlus());

        grid = new char[][]{
                {' ', 'x', 'z', 'z', ' '},
                {'x', 'x', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z'},
                {' ', 'x', 'z', ' ', ' '},
                {' ', 'x', 'z', ' ', ' '},
        };

        cg = new CharGrid(grid);
        assertEquals(2, cg.countPlus());

        grid = new char[][]{
                {' '}
        };

        cg = new CharGrid(grid);
        assertEquals(0, cg.countPlus());
    }
}
