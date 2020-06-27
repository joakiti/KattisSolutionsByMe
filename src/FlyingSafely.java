import java.util.*;

public class FlyingSafely {

    static String test = "2\n" +
            "3 3\n" +
            "1 2\n" +
            "2 3\n" +
            "1 3\n" +
            "5 4\n" +
            "2 1\n" +
            "2 3\n" +
            "4 3\n" +
            "4 5\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        while (n-- != 0) {
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            int cities = s.nextInt() + 1;
            int pilots = s.nextInt();

            int lastCity = 1;

            for (int i = 0; i < pilots; i++) {
                int cityOne = s.nextInt();
                int cityTwo = s.nextInt();
                graph.putIfAbsent(cityOne, new ArrayList<>(cities));
                graph.putIfAbsent(cityTwo, new ArrayList<>(cities));

                graph.get(cityOne).add(cityTwo);
                graph.get(cityTwo).add(cityOne);
            }

            LinkedList<Integer> toVisit = new LinkedList<>();
            boolean[] visited = new boolean[cities + 1];

            toVisit.push(lastCity);
            visited[lastCity] = true;
            int edgesUsed = 0;

            while (!toVisit.isEmpty()) {
                Integer city = toVisit.poll();
                for (Integer neighbour :
                        graph.get(city)) {
                    if (!visited[neighbour]) {
                        toVisit.add(neighbour);
                        visited[neighbour] = true;
                        edgesUsed++;
                    }
                }

            }
            System.out.println(edgesUsed);
        }
    }
}
