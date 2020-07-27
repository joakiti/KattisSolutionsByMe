import java.util.ArrayList;
import java.util.List;

// Topological Sort Based Solution
// An Alternative Solution
public class LeetCode_longestIncreasingPath {

    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m, n;

    public static int longestIncreasingPath(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        // padding the matrix with zero as boundaries
        // assuming all positive integer, otherwise use INT_MIN as boundaries
        int[][] matrix = new int[m + 2][n + 2];
        for (int i = 0; i < m; ++i)
            System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);

        // calculate outdegrees
        int[][] outdegree = new int[m + 2][n + 2];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j) {
                int vertex = matrix[i][j];
                for (int[] d : dir) {
                    int neighbour = matrix[i + d[0]][j + d[1]];
                    if (vertex < neighbour)
                        outdegree[i][j]++;
                }
            }

        // find leaves who have zero out degree as the initial level
        n += 2;
        m += 2;
        List<Node> leaves = new ArrayList<>();
        for (int i = 1; i < m - 1; ++i)
            for (int j = 1; j < n - 1; ++j) {
                int vertex = matrix[i][j];
                if (outdegree[i][j] == 0) {
                    leaves.add(new Node(i, j));
                }
            }

        // remove leaves level by level in topological order
        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            List<Node> newLeaves = new ArrayList<>();
            for (Node node : leaves) {
                for (int[] d : dir) {
                    int x = node.x + d[0];
                    int y = node.y + d[1];
                    int vertex = matrix[node.x][node.y];
                    int neighbour = matrix[x][y];
                    if (vertex > neighbour) {
                        outdegree[x][y]--;
                        if (outdegree[x][y] == 0)
                            newLeaves.add(new Node(x,y));
                    }

                }
            }
            leaves = newLeaves;
        }
        return height;
    }

    static class Node {
        int x, y;
        Node(int xcord, int ycord) {
            x = xcord;
            y = ycord;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{1, 3},
                new int[]{2, 4}
        };
        System.out.println(longestIncreasingPath(grid));
    }
}