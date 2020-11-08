package NCPC;

import java.util.*;


public class DamsInDistress {

    static FlowGraph<String> g;

    static String test = "4 75\n" +
            "0 100 50\n" +
            "1 49 10\n" +
            "1 50 0\n" +
            "3 50 48";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);
        int n = s.nextInt();
        int w = s.nextInt();

        g = new FlowGraph<>();

        HashMap<Integer, Vertex<String>> mapToV = new HashMap<Integer, Vertex<String>>();
        Vertex<String> sink = new Vertex<>("SINK");
        mapToV.put(0, sink);

        Vertex<String> source = new Vertex<>("SOURCE");
        mapToV.put(n + 1, source);


        g.addVertex(source);
        g.addVertex(sink);
        for (int i = 1; i < n + 1; i++) {
            int decendantOf = s.nextInt();
            Vertex<String> u = mapToV.get(decendantOf);
            Vertex<String> v = new Vertex<>(String.valueOf(i));
            mapToV.put(i, v);
            g.addVertex(v);
            int capacity = s.nextInt();
            int current = s.nextInt();
            g.addEdge(u, v, capacity, current);
        }

        System.out.println(maxFlow());
        for (Vertex<String> v : g.findMinCut()) {
            System.out.println(v.label);
        }

    }

    static int augment(int f, List<Edge> P) {
        int b = bottleneck(P, f);
        f += b;
        for (Edge e : P) {
            if (e.forwardEdge) {
                e.capacity -= b;
                e.opposite.capacity += b;
            } else {
                e.capacity += b;
                e.opposite.capacity -= b;
            }
        }
        return f;
    }

    private static int bottleneck(List<Edge> e, int f) {
        return Collections.min(e).capacity;
    }

    static int maxFlow() {
        List<Edge> path;

        boolean hasPath = g.findBFSPath();

        int flow = 0;
        while (hasPath) {
            path = g.getBFSPath();
            flow = augment(flow, path);
            hasPath = g.findBFSPath();
        }

        return flow;

    }

    static class Vertex<V> {
        V label;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        private int id;

        Vertex(V label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Vertex) {
                return this.label.equals(((Vertex) obj).label);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(label, id);
        }
        @Override
        public String toString() {
            return label.toString();
        }

        // equals and hashCode
    }

    static class Edge implements Comparable<Edge> {

        public boolean forwardEdge;

        int capacity;

        Vertex to;
        Vertex from;


        public void setOpposite(Edge opposite) {
            this.opposite = opposite;
        }

        Edge opposite;

        Edge(int capacity, Vertex from, Vertex to, boolean fe) {
            this.capacity = capacity;
            this.forwardEdge = fe;
            this.to = to;
            this.from = from;
        }


        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.capacity, o.capacity);
        }

        @Override
        public String toString() {
            return "[" + from.label + " -> " + to.label + ". Cap: " + this.capacity + "] ";
        }
    }

    static class FlowGraph<V> {

        private Map<Vertex<V>, List<Edge>> adjVertices;

        List<Edge> BFSPath;

        Vertex<String> t;

        Vertex s;

        public void printSEdges() {
            System.out.println(adjVertices.get(t));
        }


        public void setS(Vertex s) {
            this.s = s;
        }


        public void setT(Vertex<String> t) {
            this.t = t;
        }

        FlowGraph() {
            adjVertices = new HashMap<>();
        }

        List<Edge> getBFSPath() {
            return BFSPath;
        }

        boolean findBFSPath() {
            LinkedList<Vertex> toSearch = new LinkedList<>();
            Set<Vertex<V>> visited = new LinkedHashSet<>();
            Map<Vertex, Edge> pathLookup = new HashMap<>();
            toSearch.add(s);
            pathLookup.put(s, null);
            while (!toSearch.isEmpty()) {
                Vertex v = toSearch.poll();
                if (!visited.contains(v)) {
                    visited.add(v);
                    for (Edge e : adjVertices.get(v)) {
                        if (e.capacity != 0 && !visited.contains(e.to)) {
                            pathLookup.put(e.to, e);
                            if (e.to == t) {
                                List<Edge> path = new ArrayList<>();
                                Edge used = e;
                                while (used != null) {
                                    path.add(used);
                                    used = pathLookup.get(used.from);
                                }
                                BFSPath = path;
                                return true;
                            }
                            toSearch.push(e.to);
                        }
                    }
                }
            }
            BFSPath = null;
            return false;
        }

        public Set<Vertex<V>> findMinCut() {
            LinkedList<Vertex> toSearch = new LinkedList<>();
            Set<Vertex<V>> visited = new LinkedHashSet<>();
            toSearch.add(s);

            while (!toSearch.isEmpty()) {
                Vertex v = toSearch.poll();
                if (!visited.contains(v)) {
                    visited.add(v);
                    for (Edge e : adjVertices.get(v)) {
                        if (e.capacity != 0 && !visited.contains(e.to)) {
                            toSearch.push(e.to);
                        }
                    }
                }
            }
            return visited;
        }

        void addEdge(Vertex<V> v1, Vertex<V> v2, int capacity, int current) {
            Edge forwardEdge = new Edge(capacity, v1, v2, true);
            Edge backwardsEdge = new Edge(current, v2, v1, false);

            forwardEdge.setOpposite(backwardsEdge);
            backwardsEdge.setOpposite(forwardEdge);


            adjVertices.get(v1).add(forwardEdge);
            adjVertices.get(v2).add(backwardsEdge);
        }

        void addVertex(Vertex<V> label) {
            adjVertices.putIfAbsent(label, new ArrayList<>());
        }
    }
}