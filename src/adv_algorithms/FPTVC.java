package adv_algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FPTVC {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FPTVC fptvc = new FPTVC();
        ArrayList<Edge> graph = new ArrayList<>();
        int n = 3;
        /**
         * Radu graph
         */
        while (s.hasNext()) {
            graph.add(new Edge(s.nextInt(), s.nextInt()));
        }
        int k = 11;
        fptvc.VC(graph, k, new ArrayList<>()).forEach(integer -> System.out.printf("%d ", integer));

    }

    private static ArrayList<Edge> completeGraph(ArrayList<Edge> graph, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    graph.add(new Edge(i, j));
                }
            }
        }
        return graph;
    }

    public ArrayList<Edge> removeEdge(int i, ArrayList<Edge> edges) {
        return edges.stream().filter(edge -> edge.from != i && edge.to != i).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> VC(ArrayList<Edge> graph, Integer k, List<Integer> solution) {
        boolean edgesLeft = graph.size() > 0;
        if (!edgesLeft) {
            return solution;
        } else if (k == 0) {
            return List.of();
        } else {
            var keyAsLeftOut = graph.stream().findFirst().get().from;
            var firstNeighbourLeftOur = graph.stream().findFirst().get().to;
            var keyList = new ArrayList<>(List.copyOf(solution));
            var neigList = new ArrayList<>(List.copyOf(solution));
            keyList.add(keyAsLeftOut);
            neigList.add(firstNeighbourLeftOur);
            var key = VC(removeEdge(keyAsLeftOut, new ArrayList<>(graph)), k - 1, keyList);
            var neig = VC(removeEdge(firstNeighbourLeftOur, new ArrayList<>(graph)), k - 1, neigList);
            if (key.size() > 0) {
                return key;
            } else if (neig.size() > 0) {
                return neig;
            } else {
                return List.of();
            }
        }
    }

    static class Edge {
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }


}
