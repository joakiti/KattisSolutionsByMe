import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeakVertices {

    static String test = "9\n" +
            "0 1 1 1 0 0 0 0 0\n" +
            "1 0 0 0 0 0 1 0 0\n" +
            "1 0 0 1 0 1 0 0 0\n" +
            "1 0 1 0 0 1 1 0 0\n" +
            "0 0 0 0 0 0 1 1 0\n" +
            "0 0 1 1 0 0 0 0 0\n" +
            "0 1 0 1 1 0 0 1 0\n" +
            "0 0 0 0 1 0 1 0 1\n" +
            "0 0 0 0 0 0 0 1 0\n" +
            "1\n" +
            "0\n" +
            "-1";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            int n = s.nextInt();
            if (n == -1) {
                System.exit(0);
            }

            Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int isNeighbour = s.nextInt();
                    if (isNeighbour == 1) {
                        graph.get(i).add(j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> neighbours = graph.get(i);
                if (neighbours.size() <= 1) {
                    System.out.print(i + " ");
                    continue;
                }
                boolean isWeak = true;
                for (int neighbour :
                        neighbours) {
                    int finalI = i;
                    if (graph.get(neighbour).stream().anyMatch(integer -> integer != finalI && neighbours.contains(integer))) {
                        isWeak = false;
                        break;
                    }
                }
                if (isWeak) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
