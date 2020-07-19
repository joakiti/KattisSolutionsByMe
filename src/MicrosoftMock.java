import java.util.*;

class MicrosoftMock {
    static Map<Integer, Integer> minimalDistanceToNode;

    static class Edge {
        int w;
        int to;

        Edge(int w, int to) {
            this.w = w;
            this.to = to;
        }
    }

    static public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, List<Edge>> edges = new HashMap<>();
        for (int[] t :
                times) {
            edges.putIfAbsent(t[0], new ArrayList<>());
            edges.get(t[0]).add(new Edge(t[2], t[1]));
        }
        for (int node: edges.keySet()) {
            Collections.sort(edges.get(node), Comparator.comparingInt(a -> a.w));
        }

        minimalDistanceToNode = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            minimalDistanceToNode.put(i, Integer.MIN_VALUE);
        }

        dfs(edges, K, 0);
        int ans = 0;

        for (int distance :
                minimalDistanceToNode.values()) {
            if (distance == Integer.MIN_VALUE) return -1;
            ans = Math.max(distance, ans);
        }
        //find max arrival
        return ans;
    }

    static public void dfs(Map<Integer, List<Edge>> graph, int node, int elapsed) {
        if (elapsed >= minimalDistanceToNode.get(node)) return;
        minimalDistanceToNode.put(node, elapsed);
        if (graph.get(node) != null) {
            for (Edge e :
                    graph.get(node)) {
                dfs(graph, e.to, elapsed + e.w);
            }
        }
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{
                new int[]{2, 1, 1},
                new int[]{2, 3, 1},
                new int[]{3, 4, 1}
        };
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
}