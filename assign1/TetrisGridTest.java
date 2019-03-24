package assign1;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class TetrisGridTest {

    // Provided simple clearRows() test
    // width 2, height 3 grid
    @Test
    public void testClear1() {
        boolean[][] before =
                {
                        {true, true, false,},
                        {false, true, true,}
                };

        boolean[][] after =
                {
                        {true, false, false},
                        {false, true, false}
                };

        TetrisGrid tetris = new TetrisGrid(before);
        tetris.clearRows();

        assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
    }

    @Test
    public void testClear2() {
        boolean[][] before =
                {
                        {true, true, true,},
                        {false, true, true,},
                        {true, true, false,},
                        {false, true, true,}
                };

        boolean[][] after =
                {
                        {true, true, false,},
                        {false, true, false,},
                        {true, false, false,},
                        {false, true, false,}
                };

        TetrisGrid tetris = new TetrisGrid(before);
        tetris.clearRows();

        assertTrue(Arrays.deepEquals(after, tetris.getGrid()));

        before = new boolean[][]{
                {true, true, true,},
                {true, true, true,},
                {true, true, false,},
                {true, true, true,}
        };

        after = new boolean[][]{
                {true, false, false,},
                {true, false, false,},
                {false, false, false,},
                {true, false, false,}
        };
        tetris = new TetrisGrid(before);
        tetris.clearRows();

        assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
    }

    @Test
    public void testClear3() {
        boolean[][] before =
                {
                        {true, true, true,},
                };

        boolean[][] after =
                {
                        {false, false, false,},
                };

        TetrisGrid tetris = new TetrisGrid(before);
        tetris.clearRows();
        assertTrue(Arrays.deepEquals(after, tetris.getGrid()));

        before = new boolean[][]{
                {true},
                {true},
                {true},
                {true}
        };

        after = new boolean[][]{
                {false,},
                {false,},
                {false,},
                {false,}
        };
        tetris = new TetrisGrid(before);
        tetris.clearRows();

        assertTrue(Arrays.deepEquals(after, tetris.getGrid()));

        before = new boolean[][]{
                {true, true, true,},
                {true, true, true,},
                {true, true, true,},
                {true, true, true,}
        };

        after = new boolean[][]{
                {false, false, false,},
                {false, false, false,},
                {false, false, false,},
                {false, false, false,}
        };
        tetris = new TetrisGrid(before);
        tetris.clearRows();

        assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
    }

}
