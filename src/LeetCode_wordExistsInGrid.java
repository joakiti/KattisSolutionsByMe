import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

class LeetCode_wordExistsInGrid {

    static Position[] dirs = new Position[]{
            new Position(0, 1),
            new Position(0, -1),
            new Position(1, 0),
            new Position(-1, 0)
    };

    static String wordGoal;


    public static void main(String[] args) {
        String word = "ABCESEEEFS";
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'E', 'S'},
                new char[]{'A', 'D', 'E', 'E'},

        };
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        wordGoal = word;
        int rows = board.length;
        int cols = board[0].length;

        char[][] grid = new char[rows + 2][cols + 2];
        for (int i = 0; i < rows + 2; i++) {
            for (int j = 0; j < cols + 2; j++) {
                grid[i][j] = '-';
            }
        }
        for (int i = 0; i < rows; i++) {
            System.arraycopy(board[i], 0, grid[i + 1], 1, cols);
        }
        rows += 2;
        cols += 2;
        //find possible starting positions
        Stack<Position> possibleStartingPositions = new Stack<Position>();

        char beginningOfWord = word.charAt(0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == beginningOfWord) {
                    possibleStartingPositions.push(new Position(i, j));
                }
            }
        }

        while (!possibleStartingPositions.isEmpty()) {
            Position startingPosition = possibleStartingPositions.pop();
            HashSet<Position> visited = new HashSet<>();
            boolean canWrite = dfs(startingPosition, grid, 0, visited);
            if (canWrite) {
                return true;
            }
        }

        return false;
    }

    static boolean dfs(Position startingPosition, char[][] grid, int indexOfWord, HashSet<Position> visited) {
        if (grid[startingPosition.row][startingPosition.col] != wordGoal.charAt(indexOfWord)) return false;
        if (indexOfWord == wordGoal.length() - 1) return true;
        boolean canWriteWord = false;
        visited.add(startingPosition);
        for (Position neighbours : dirs) {
            int row = startingPosition.row + neighbours.row;
            int col = startingPosition.col + neighbours.col;
            Position neighbour = new Position(row, col);
            if (!visited.contains(neighbour)) {
                canWriteWord = canWriteWord || dfs(neighbour, grid, indexOfWord + 1, new HashSet<>(visited));
            }
        }
        return canWriteWord;
    }

    static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return String.format("row: %d, col: %d", row, col);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row &&
                    col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}