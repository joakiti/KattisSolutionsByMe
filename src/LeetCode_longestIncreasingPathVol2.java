import java.util.ArrayList;
import java.util.List;

public class LeetCode_longestIncreasingPathVol2 {
    static Node[] directions = new Node[]{
            new Node(1,0),
            new Node(0,1),
            new Node(-1,0),
            new Node(0, -1),
    };

    public static int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        //In order to avoid border cases, we make a slightly bigger matrix - to avoid the hassle of edges.
        int[][] grid = new int[rows+2][cols+2];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, grid[i + 1], 1, cols);
        }

        int[][] outdegrees = new int[rows+2][cols+2];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int vertex = grid[i][j];
                for (Node node : directions) {
                    int neighbour = grid[i + node.x][j + node.y];
                    if (neighbour > vertex) {
                        outdegrees[i][j]++;
                    }
                }
            }
        }

        rows += 2;
        cols += 2;
        ArrayList<Node> leaves = new ArrayList<>();
        for (int i = 1; i < rows - 1; ++i) {
            for (int j = 1; j < cols - 1; ++j) {
                int vertex = grid[i][j];
                if (outdegrees[i][j] == 0) {
                    leaves.add(new Node(i, j));
                }
            }
        }

        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            ArrayList<Node> newLeaves = new ArrayList<>();
            for (Node n : leaves) {
                int vertex = grid[n.x][n.y];
                for (Node dir : directions) {
                    int x = n.x + dir.x;
                    int y = n.y + dir.y;
                    int neighbour = grid[x][y];
                    if (vertex > neighbour) {
                        outdegrees[x][y]--;
                        if (outdegrees[x][y] == 0) {
                            newLeaves.add(new Node(x,y));
                        }
                    }
                }
            }
            leaves = newLeaves;
        }

        return height;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{9,9,4},
                new int[]{6,6,8},
                new int[]{2,1,1},

        };
        System.out.println(longestIncreasingPath(grid));
    }

    static class Node {
        int x,y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
