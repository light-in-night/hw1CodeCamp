// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid char grid that represents the inner data of the class
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        if (!containsChar(ch)) return 0;

        int widthStart = Integer.MAX_VALUE;
        int widthEnd = Integer.MIN_VALUE;
        int heightStart = Integer.MAX_VALUE;
        int heightEnd = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    if (i > heightEnd) {
                        heightEnd = i;
                    }
                    if (i < heightStart) {
                        heightStart = i;
                    }
                    if (j > widthEnd) {
                        widthEnd = j;
                    }
                    if (j < widthStart) {
                        widthStart = j;
                    }
                }
            }
        }
        return (widthEnd - widthStart + 1) * (heightEnd - heightStart + 1);
    }

    /**
     * Returns True if this.grid contains the give char
     */
    private boolean containsChar(char ch) {
        for (char[] row : grid) {
            for (char item : row) {
                if (item == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isPlusCenter(i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * returns true if the given coordinates are
     * in the center of a plus sign
     */
    private boolean isPlusCenter(int ctrI, int ctrJ) {
        int wingWidth = calculateWidth(ctrI, ctrJ);
        int wingHeight = calculateHeight(ctrI, ctrJ);
        return wingWidth == wingHeight && wingHeight != 0;
    }

    /**
     * Returns an integer representing vertical height of
     * the Plus sign. 0 is returned when heights are not
     * the same.
     */
    private int calculateHeight(int ctrI, int ctrJ) {
        int upWing = 0;
        int downWing = 0;

        char ch = grid[ctrI][ctrJ];
        for (int i = ctrI + 1; i < grid.length; i++) {
            if (grid[i][ctrJ] == ch) {
                downWing++;
            } else {
                break;
            }
        }

        for (int i = ctrI - 1; i >= 0; i--) {
            if (grid[i][ctrJ] == ch) {
                upWing++;
            } else {
                break;
            }
        }

        if (upWing == downWing)
            return upWing;
        else
            return 0;
    }

    /**
     * Returns an integer representing horisontal width of
     * the Plus sign. 0 is returned when widths are not
     * the same.
     */
    private int calculateWidth(int ctrI, int ctrJ) {
        int leftWing = 0;
        int rightWing = 0;

        char ch = grid[ctrI][ctrJ];
        for (int j = ctrJ + 1; j < grid[ctrI].length; j++) {
            if (grid[ctrI][j] == ch) {
                rightWing++;
            } else {
                break;
            }
        }

        for (int j = ctrJ - 1; j >= 0; j--) {
            if (grid[ctrI][j] == ch) {
                leftWing++;
            } else {
                break;
            }
        }

        if (leftWing == rightWing)
            return leftWing;
        else
            return 0;
    }

}
