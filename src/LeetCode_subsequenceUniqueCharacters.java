import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_subsequenceUniqueCharacters {

    static int[][] cost;
    static boolean[][] edges;
    static List<String> words;

    public static int maxLength(List<String> arr) {
        arr = arr.stream().filter(s -> {
            for (char c : s.toCharArray()) {
                if (s.indexOf(c) != s.lastIndexOf(c)) {
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList());

        words = arr;
        cost = new int[arr.size()][arr.size()];
        edges = new boolean[arr.size()][arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            String word = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                String otherWord = arr.get(j);
                boolean hasEdge = true;
                for (char c : otherWord.toCharArray()) {
                    if (word.indexOf(c) != -1) {
                        hasEdge = false;
                        break;
                    }
                }
                if (hasEdge) {
                    edges[i][j] = true;
                    cost[i][j] = otherWord.length();
                }

            }
        }
        int max = 0;

        for (int i = 0; i < arr.size(); i++) {
            int[] cache = new int[arr.size()];
            dfs(i, cache, words.get(i));
            for (int c : cache) {
                max = Math.max(max, c);
            }
        }
        return max;
    }

    private static int dfs(int pos, int[] cache, String current) {
        cache[pos] = Math.max(cache[pos], current.length());
        for (int i = 0; i < edges.length; i++) {
            if (edges[pos][i]) {
                boolean hasEdge = true;
                String otherWord = words.get(i);
                for (char c : otherWord.toCharArray()) {
                    if (current.indexOf(c) != -1) {
                        hasEdge = false;
                        break;
                    }
                }
                if (hasEdge) {
                    dfs(i, cache, current + words.get(i));
                }
            }
        }
        return cache[pos];
    }

    public static void main(String[] args) {
        System.out.println(maxLength(List.of("yy", "bkhwmpbiisbldzknpm")));
    }
}
