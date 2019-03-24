//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {

    boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     *
     * @param grid 2d grid of booleans to construct tetris grid from.
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }

    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        for (int j = 0; j < grid[0].length; j++) {
            while (isFull(j)) {
                cleanShiftDown(j);
            }
        }
    }

    /**
     * Cleans and shifts down the specified row,
     * as it is required by the rules of tetris
     */
    private void cleanShiftDown(int rowJ) {
        for (int j = rowJ; j < grid[0].length - 1; j++) {
            for (int i = 0; i < grid.length; i++) {
                grid[i][j] = grid[i][j + 1];
            }
        }
        for (int i = 0; i < grid.length; i++) {
            grid[i][grid[0].length - 1] = false;
        }
    }

    /**
     * returns true if the selected row
     * is full of booleans 'true'
     */
    private boolean isFull(int rowJ) {
        for (boolean[] row : grid) {
            if (!row[rowJ]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the internal 2d grid array.
     *
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        boolean[][] newGrid = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < newGrid.length; i++)
            for (int j = 0; j < newGrid[i].length; j++)
                newGrid[i][j] = grid[i][j];
        return newGrid;
    }
}
