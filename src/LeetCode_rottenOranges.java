import java.util.LinkedList;

public class LeetCode_rottenOranges {


    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{
                new int[]{2,1,1},
                new int[]{1,1,0},
                new int[]{0,1,1}
        }));
    }

    static Position[] dirs = new Position[]{
            new Position(1, 0),
            new Position(0, 1),
            new Position(-1, 0),
            new Position(0, -1)
    };

    static final int FRESH_ORANGE = 1;
    static final int ROTTEN_ORANGE = 2;

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        if (rows < 1) return -1;
        int cols = grid[0].length;

        int freshOranges = 0;
        LinkedList<Position> rottens = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col ++) {
                if (grid[row][col] == FRESH_ORANGE) {
                    freshOranges++;
                }
                else if (grid[row][col] == ROTTEN_ORANGE) {
                    rottens.add(new Position(row, col));
                }
            }
        }

        int minute = 0;
        boolean hasInfested;
        while (!rottens.isEmpty()) {
            hasInfested = false;
            minute++;
            LinkedList<Position> newRottens = new LinkedList<>();
            for (Position rottenOrange : rottens) {
                int row = rottenOrange.row;
                int col = rottenOrange.col;
                for (Position dir : dirs) {
                    int nextRow = dir.row + row;
                    int nextCol = dir.col + col;
                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                        continue;
                    }
                    else {
                        if (grid[nextRow][nextCol] == FRESH_ORANGE) {
                            hasInfested = true;
                            grid[nextRow][nextCol] = ROTTEN_ORANGE;
                            newRottens.add(new Position(nextRow, nextCol));
                            freshOranges--;
                        }
                    }
                }
            }
            rottens = newRottens;
            if (!hasInfested) {
                minute--;
            }
        }
        if (freshOranges > 0) {
            return -1;
        }
        else {
            return minute;
        }

    }

    static class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
