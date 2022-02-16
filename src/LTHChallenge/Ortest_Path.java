package LTHChallenge;

import java.util.*;

public class Ortest_Path {

    static String test = "6 7 0 3\n" +
            "0 1 0\n" +
            "1 2 0\n" +
            "2 3 0\n" +
            "2 4 1\n" +
            "4 5 0\n" +
            "3 5 0\n" +
            "0 3 0\n";

    static class Edge {
        int cap;
        boolean isForward;
        Edge opposite;

        public Edge(int cap, boolean isForward) {
            this.cap = cap;
            this.isForward = isForward;
        }
    }

    static int n;

    static HashMap<Integer, HashMap<Integer, Edge>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(test);
        n = s.nextInt();
        int m = s.nextInt();
        int start = s.nextInt();
        int terminate = s.nextInt();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }
        ArrayList<int[]> required = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            boolean isRequired = s.nextInt() == 1;
            if (isRequired)
                required.add(new int[]{u, v});
            addEdge(u, v, 1);
            addEdge(v, u, 1);
        }
        int flow = 0;
        int sink = graph.size();

        graph.put(sink, new HashMap<>());
        int source = graph.size();
        graph.put(source, new HashMap<>());

        for (int[] uToV : required) {
            graph.get(source).clear();
            int must = uToV[0];
            int have = uToV[1];

            addSourceOrSink(source, must + n);
            addSourceOrSink(source, have + n);
            addSourceOrSink(start, sink);
            addSourceOrSink(terminate, sink);

            while (true) {
                ArrayList<Integer> path = BFS(source, sink);
                if (path == null) {
                    break;
                }
                flow += 1;
                for (int i = 0; i < path.size() - 1; i++) {
                    int u = path.get(i);
                    int v = path.get(i + 1);
                    Edge e = graph.get(u).get(v);
                    if (e.isForward) {
                        graph.get(u).get(v).cap -= 1;
                        graph.get(u).get(v).opposite.cap += 1;
                    }
                    else {
                        graph.get(u).get(v).cap += 1;
                        graph.get(u).get(v).opposite.cap -= 1;
                    }

                }
            }
            if (flow == 2)
                break;
            flow = 0;
        }
        if (flow == 2) {
            findSolution(start, terminate, source);
        } else {
            System.out.println("-1");
        }
    }

    private static void addSourceOrSink(int source, int must) {
        Edge forward = new Edge(1, true);
        Edge backward = new Edge(0, false);
        forward.opposite = backward;
        backward.opposite = forward;

        graph.get(source).put(must , forward);
        graph.get(must).put(source, backward);
    }

    private static void findSolution(int start, int terminate, int source) {
        ArrayList<Integer> startpath = new ArrayList<>();
        ArrayList<Integer> terminationPath = new ArrayList<>();
        for (int uAndV : graph.get(source).keySet()) {
            ArrayList<Integer> path = new ArrayList<>();
            int s = uAndV;
            while (s != start && s != terminate) {
                if (s < n)
                    path.add(s);
                for (Map.Entry<Integer, Edge> edges : graph.get(s).entrySet()) {
                    if (edges.getValue().cap == 0) {
                        s = edges.getKey();
                        break;
                    }
                }
            }
            path.add(s);
            if (s == start) {
                Collections.reverse(path);
                startpath = path;
            } else {
                terminationPath = path;
            }
        }
        for (int s : startpath) {
            System.out.printf("%d ", s);
        }
        for (int s : terminationPath) {
            System.out.printf("%d ", s);
        }
    }

    static void addEdge(int from, int to, int cap) {
        if (!graph.containsKey(from + n)) {
            graph.put(from + n, new HashMap<>());

            Edge forward = new Edge(cap, true);
            Edge backward = new Edge(0, false);
            forward.opposite = backward;
            backward.opposite = forward;

            graph.get(from+n).put(from, forward);
            graph.get(from).put(from+n, backward);
        }
        if (!graph.containsKey(to + n)) {
            graph.put(to + n, new HashMap<>());

            Edge forward = new Edge(cap, true);
            Edge backward = new Edge(0, false);
            forward.opposite = backward;
            backward.opposite = forward;

            graph.get(to+n).put(to, forward);
            graph.get(to).put(to+n, backward);
        }
        Edge forward = new Edge(cap, true);
        Edge backward = new Edge(0, false);
        forward.opposite = backward;
        backward.opposite = forward;

        Edge forward2 = new Edge(cap, true);
        Edge backward2 = new Edge(0, false);
        forward2.opposite = backward2;
        backward2.opposite = forward2;

        graph.get(from).put(to + n, forward);
        graph.get(to + n).put(from, backward);

        graph.get(to).put(from + n, forward2);
        graph.get(from + n).put(to, backward2);
    }

    static ArrayList<Integer> BFS(int start, int sink) {
        LinkedList<Integer> toVisit = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        toVisit.add(start);
        HashMap<Integer, Integer> path = new HashMap<>();
        path.put(start, start);
        while (!toVisit.isEmpty()) {
            int vtx = toVisit.pop();
            visited.add(vtx);
            if (vtx == sink) {
                return findPath(path, sink);
            }
            for (int neighbour : graph.get(vtx).keySet()) {
                if (!visited.contains(neighbour) && graph.get(vtx).get(neighbour).cap != 0) {
                    path.put(neighbour, vtx);
                    visited.add(neighbour);
                    toVisit.add(neighbour);
                }
            }
        }
        return null;
    }

    private static ArrayList<Integer> findPath(HashMap<Integer, Integer> path, int sink) {
        ArrayList<Integer> thePath = new ArrayList<>();
        while (path.get(path.get(sink)) != sink) {
            thePath.add(sink);
            sink = path.get(sink);
        }
        thePath.add(sink);
        Collections.reverse(thePath);
        return thePath;
    }


}
