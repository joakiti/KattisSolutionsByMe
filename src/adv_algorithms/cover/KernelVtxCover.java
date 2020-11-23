package adv_algorithms.cover;

import java.util.*;

public class KernelVtxCover {

    public static void main(String[] args) {
        KernelVtxCover cover = new KernelVtxCover();
        Scanner s = new Scanner(System.in);

        var graph = new HashMap<Integer, List<Integer>>();

        while (s.hasNext()) {
            int from = s.nextInt();
            int to = s.nextInt();
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        /**
         *
         for (int i = 0; i < 100; i++) {
         graph.put(i, IntStream.generate(() -> r.nextInt(100)).limit(r.nextInt(20)).boxed().collect(Collectors.toList()));
         }
         */
        for (int k = 0; k < 60; k++) {
            var result = cover.run(graph, k);
            if (result.isPresent()) {
                System.out.println("Has solution for " + k);
            } else {
                System.out.println("No solution for " + k);
            }
        }
    }

    void removeVertex(int vertex, HashMap<Integer, List<Integer>> graph) {
        if (graph.containsKey(vertex)) {
            for (Integer neigh : graph.get(vertex)) {
                graph.get(neigh).remove((Object) vertex);
            }
            graph.remove(vertex);
        }
    }


    Optional<HashMap<Integer, List<Integer>>> run(HashMap<Integer, List<Integer>> graph, int k) {
        HashMap<Integer, List<Integer>> returnGraph = new HashMap<>(graph);
        boolean changesToBeMade = true;
        while (changesToBeMade && k >= 0) {
            changesToBeMade = false;
            /**
             * Avoid error for changing collections as we pass, so use originalGraph to look into return graph
             */
            for (Integer key : graph.keySet()) {
                /**
                 * If exit conditions apply, break for loop.
                 */
                if (ruleThree(k, returnGraph)) {
                    break;
                }
                if (returnGraph.containsKey(key)) {
                    /**
                     * Rule one
                     */
                    if (returnGraph.get(key).size() >= k + 1) {
                        removeVertex(key, returnGraph);
                        k--;
                        changesToBeMade = true;
                    }
                    /**
                     * Rule two
                     */
                    else if (returnGraph.get(key).size() == 0) {
                        removeVertex(key, returnGraph);
                        changesToBeMade = true;
                    }
                }
            }
        }
        if (ruleThree(k, returnGraph) || returnGraph
                .values()
                .stream()
                .reduce(0,
                        (integer, integers) -> integers.size() + integer,
                        Integer::sum)
                > Math.pow(k, 2)) {
            return Optional.empty();
        }
        return Optional.of(returnGraph);
    }

    private boolean ruleThree(int k, HashMap<Integer, List<Integer>> returnGraph) {
        return k < 0;
    }
}
