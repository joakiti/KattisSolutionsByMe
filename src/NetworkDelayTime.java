import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class NetworkDelayTime {

    static HashMap<Integer, List<Edge>> graph = new HashMap<>();
    static HashMap<Integer, Integer> timeElapsed = new HashMap<>();

    public static void main(String[] args) {
        int[][] times = new int[][]{
                new int[]{2,1,1},
                new int[]{2,3,1},
                new int[]{3,4,1}
        };
        System.out.println(networkDelayTime(times, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<Edge>());
            graph.get(time[0]).add(new Edge(time[2], time[1]));
        }

        for (List<Edge> ls : graph.values()) {
            ls.sort(Comparator.comparingInt(o -> o.weight));
        }

        for (int i = 1; i <= N; i++) {
            timeElapsed.put(i, Integer.MAX_VALUE);
        }

        bfs(K, 0);
        int max = 0;
        for (Integer i : timeElapsed.values()) {
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, i);

        }
        return max;
    }


    public static void bfs(int root, int elapsed) {
        if (elapsed >= timeElapsed.get(root)) {
            return;
        }  else {
            timeElapsed.put(root, elapsed);
            if (graph.containsKey(root)) {
                for (Edge e : graph.get(root)) {
                    bfs(e.to, elapsed + e.weight);
                }
            }
        }
    }


    static class Edge {
        int weight;
        int to;

        Edge(int weight, int to) {
            this.weight = weight;
            this.to = to;
        }
    }
}