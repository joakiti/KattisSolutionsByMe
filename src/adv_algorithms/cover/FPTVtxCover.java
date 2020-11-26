package adv_algorithms.cover;

import Codeforces_654.F;

import java.lang.reflect.Array;
import java.util.*;

public class FPTVtxCover {

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        /**
         * Testing
        for (int i = 0; i < 24; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            graph.get(i).add(i + 1);
            graph.putIfAbsent(i + 1, new ArrayList<>());
            graph.get(i + 1).add(i);
        }
        **/
        Scanner s = new Scanner(System.in);

        graph = new HashMap<>();
        while (s.hasNext()) {
            int from = s.nextInt();
            int to = s.nextInt();
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        FPTVtxCover alg = new FPTVtxCover();
        System.out.println(alg.run(graph, 12, new ArrayList<>()));
    }


    ArrayList<Integer> run(HashMap<Integer, ArrayList<Integer>> graph, int k, ArrayList<Integer> ans) {
        int E = graph.values()
                .stream()
                .reduce(0,
                        (integer, integers) -> integers.size() + integer,
                        Integer::sum);
        if (E == 0) {
            return ans;
        } else if (k == 0 && E >= 0) {
            return new ArrayList<>();
        }
        int vtx = graph.keySet().stream().findAny().get();
        int neighbour = graph.get(vtx).stream().findAny().get();

        var G1 = clone(graph);
        var G2 = clone(graph);
        removeVtx(G1, vtx);
        removeVtx(G2, neighbour);

        var ans1 = new ArrayList<>(ans);
        ans1.add(vtx);
        var ans2 = new ArrayList<>(ans);
        ans2.add(neighbour);


        ans1 = run(G1, k-1, ans1);
        ans2 = run(G2, k-1, ans2);

        if (ans1.isEmpty()) {
            return ans2;
        }
        else {
            return ans1;
        }
    }

    void removeVtx(HashMap<Integer, ArrayList<Integer>> graph, int vtx) {
        for (int neighbour : graph.get(vtx)) {
            graph.get(neighbour).remove((Object)vtx);
            if (graph.get(neighbour).isEmpty()) {
                graph.remove(neighbour);
            }
        }
        graph.remove(vtx);
    }

    HashMap<Integer, ArrayList<Integer>> clone(HashMap<Integer, ArrayList<Integer>> graph) {
        HashMap<Integer, ArrayList<Integer>> ans = new HashMap<>();
        for (var entry : graph.entrySet()) {
            ans.put(new Integer(entry.getKey()), new ArrayList<>(entry.getValue()));
        }
        return ans;
    }
}
