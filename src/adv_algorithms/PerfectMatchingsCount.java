package adv_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PerfectMatchingsCount {
    public static void main(String[] args) {
        int n = 1;
        int m = 2;
        List<List<Edge>> omega = new ArrayList<>();
        List<Edge> allEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Vertex src = new Vertex(i,j);
                for (int dir : new int[]{-1,1}) {
                    if (i + dir >= 0 && i + dir < m) {
                        allEdges.add(new Edge(src, new Vertex(i + dir, j)));
                    }
                    if (j + dir >= 0 && j + dir < n){
                        allEdges.add(new Edge(src, new Vertex(i, j + dir)));
                    }
                }
            }
        }
        System.out.println();
    }
    static int binomialCoeff(int n, int k)
    {

        // Base Cases
        if (k == 0 || k == n)
            return 1;

        // Recur
        return binomialCoeff(n - 1, k - 1) +
                binomialCoeff(n - 1, k);
    }
}

class Graph {
    List<Edge> edges;
    Map<Vertex, List<Edge>> vertexToEdge;

    public Graph(List<Edge> edges, Map<Vertex, List<Edge>> vertexToEdge) {
        this.edges = edges;
        this.vertexToEdge = vertexToEdge;
    }
}

class Edge {
    Vertex to, from;

    public Edge(Vertex from, Vertex to) {
        this.to = to;
        this.from = from;
    }
}

class Vertex {
    int x, y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}