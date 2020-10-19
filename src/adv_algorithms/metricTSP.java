package adv_algorithms;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class metricTSP {

    public static void main(String[] args) {
        Vertex Copenhagen = new Vertex(55.676, 12.566);
        Vertex Aarhus = new Vertex(56.157, 10.211);
        Vertex Odense = new Vertex(55.396, 10.388);
        Copenhagen.name = "Copenhagen";
        Aarhus.name = "Aarhus";
        Odense.name = "Odense";
                /**
        Vertex Aalborg = new Vertex(57.048, 9.919);
        Vertex Esbjerg = new Vertex(55.47, 8.452);
        Vertex Horsens = new Vertex(55.861, 9.85);
        Vertex Randers = new Vertex(56.461, 10.036);
        Vertex Kolding = new Vertex(55.49, 9.472);
        Vertex Vejle = new Vertex(55.709, 9.536);
        Vertex Greve = new Vertex(55.583, 12.3);
        Vertex Svendborg = new Vertex(55.060337, 10.611613);
        Vertex Thisted = new Vertex(56.956957, 8.686066);
        Vertex Holstebro = new Vertex(56.358404, 8.613281);
        Vertex Aabenraa = new Vertex(55.045335, 9.419403);
        Vertex Faaborg = new Vertex(55.098016, 10.244751);
        Vertex Grenaa = new Vertex(56.413142, 10.879211);
         **/
        List<Vertex> cities = new ArrayList<>();
        cities.add(Copenhagen);
        cities.add(Aarhus);
        cities.add(Odense);
        HashMap<Vertex, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < cities.size(); i++) {
            List<Edge> edgesForCity = new ArrayList<>();
            Vertex city = cities.get(i);
            for (int j = 0; j < cities.size() ; j++) {
                if (i == j) continue;
                Vertex neighbour = cities.get(j);
                edgesForCity.add(new Edge(city, neighbour, distance(city.lat, neighbour.lat, city.lon, neighbour.lon)));
            }
            map.put(city, edgesForCity);
        }
        Graph g = new Graph(map);
        MST mst = new MST(g);
        System.out.println(g.isCycle(g.edges));
        g = mst.run();
        System.out.println(g.isCycle(g.edges));
    }

    static double distance(double lat1, double lat2, double lon1, double lon2) {
        double R = 6371e3; // metres
        double φ1 = lat1 * Math.PI / 180; // φ, λ in radians
        double φ2 = lat2 * Math.PI / 180;
        double Δφ = (lat2 - lat1) * Math.PI / 180;
        double Δλ = (lon2 - lon1) * Math.PI / 180;

        double a = Math.sin(Δφ / 2) * Math.sin(Δφ / 2) +
                Math.cos(φ1) * Math.cos(φ2) *
                        Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; // in metres

        return d;
    }

    static class MST {
        public MST(Graph g) {
            this.g = g;
        }

        Graph g;

        Graph run() {
            g.edges.sort(Comparator.comparingDouble(o -> o.cost));
            LinkedList<Edge> sortedEdges = new LinkedList<>(g.edges);
            while (g.isCycle(sortedEdges)) {
                Edge e = sortedEdges.pollLast();
                if (!g.formsCycle(sortedEdges, e)) {
                    sortedEdges.addFirst(e);
                }
                else {
                    g.mapToedge.get(e.src).remove(e);
                }
            }
            g = new Graph(g.mapToedge);
            return g;
        }

    }

    static class Graph {
        Map<Vertex, List<Edge>> mapToedge;
        List<Edge> edges;

        Graph(Map<Vertex, List<Edge>> mapToedge) {
            this.mapToedge = mapToedge;
            this.edges = mapToedge.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        }

        boolean isCycle(List<Edge> edges) {
            Map<Vertex, Vertex> parent = new HashMap<>();
            for (int i = 0; i < edges.size(); ++i) {
                Vertex x = find(parent, edges.get(i).src);
                Vertex y = find(parent, edges.get(i).dst);

                if (x == y)
                    return true;

                Union(parent, x, y);
            }
            return false;
        }

        boolean formsCycle(List<Edge> edges, Edge e) {
            Map<Vertex, Vertex> parent = new HashMap<>();
            for (int i = 0; i < edges.size(); ++i) {
                Vertex x = find(parent, edges.get(i).src);
                Vertex y = find(parent, edges.get(i).dst);

                Union(parent, x, y);
            }
            return find(parent, e.src) == find(parent, e.dst);
        }

        Vertex find(Map<Vertex, Vertex> parent, Vertex i) {
            if (!parent.containsKey(i))
                return i;
            else {
                if (parent.get(i) == i) {
                    return i;
                }
            }
            return find(parent, parent.get(i));
        }

        void Union(Map<Vertex, Vertex> parent, Vertex x, Vertex y) {
            Vertex xset = find(parent, x);
            Vertex yset = find(parent, y);
            parent.put(xset, yset);
        }
    }

    static class Vertex {
        double lat, lon;
        String name;

        Vertex(double x, double y) {
            this.lat = x;
            this.lon = y;
        }
    }

    static class Edge {
        Vertex src, dst;
        double cost;

        public Edge(Vertex src, Vertex dst, double cost) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dst);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Edge) {
                Edge casted = (Edge) obj;
                return (casted.src == src && casted.dst == dst) || (casted.src == dst && casted.dst == src);
            }
            return super.equals(obj);
        }
    }
}
