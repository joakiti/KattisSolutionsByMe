package adv_algorithms.cover;

import adv_algorithms.SAT.CNFRandom;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

import java.util.*;
import java.util.stream.Collectors;

public class FPTVtxCover {

    static HashMap<Integer, Integer> backwards = new HashMap<>();

    public static void main(String[] args) {
        FPTVtxCover cover = new FPTVtxCover();
        Scanner s = new Scanner(System.in);

        var graph = new HashMap<Integer, List<Integer>>();
        /**
         while (s.hasNext()) {
         int from = s.nextInt();
         int to = s.nextInt();
         graph.putIfAbsent(from, new ArrayList<>());
         graph.putIfAbsent(to, new ArrayList<>());
         graph.get(from).add(to);
         graph.get(to).add(from);
         }**/
        int n = 24;
        int k = 12;
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            graph.get(i).add((i + 1) % n);
        }
        ArrayList<int[]> clauses = generateClauses(graph, k);

        ISolver solver = SolverFactory.newDefault();
        solver.setTimeout(100); // 1 min timeout
        for (int[] clause : clauses) {
            try {
                solver.addClause(new VecInt(clause));
            } catch (ContradictionException e) {
                System.out.println("Clauses was contradictory");
            }
        }
        IProblem problem = solver;
        try {
            if (problem.isSatisfiable()) {
                var values = Arrays.stream(problem.model()).asLongStream().filter(value -> value > 0).map(operand -> backwards.get((int) operand)).boxed().collect(Collectors.toList());
                System.out.println(values);
                System.out.println(Arrays.toString(problem.model()));
            } else {
                System.out.println(String.format("Given n = %d) not able to satisfy ", n));
            }
        } catch (TimeoutException e) {
            System.out.println(String.format("Given n = %d) not satisfied in time ", n));
        }
        System.out.println();
    }

    private static ArrayList<int[]> generateClauses(HashMap<Integer, List<Integer>> graph, int k) {
        ArrayList<int[]> clauses = new ArrayList<>();
        int[][] variables = new int[k][graph.size()];
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= graph.size(); j++) {
                variables[i][j - 1] = i * graph.size() + j;
                backwards.put(variables[i][j - 1], j);
            }
        }
        /**
         * 3
         */
        edgeClauses(graph, k, clauses, variables);
        /**
         * 2
         */
        generateRowClauses(graph, k, clauses, variables);
        /**
         * 1
         */
        generateColumnClauses(graph, k, clauses, variables);

        return clauses;
    }

    private static void generateColumnClauses(HashMap<Integer, List<Integer>> graph, int k, ArrayList<int[]> clauses, int[][] variables) {
        for (int n = 0; n < graph.size(); n++) {
            /**
             * Let a single vertex be set to true
             */
            for (int i = 0; i < k; i++) {
                int[] column = new int[k];
                /**
                 * And all others to false
                 */
                for (int j = 0; j < k; j++) {
                    column[j] = variables[j][n] * -1; //Negation
                }
                /**
                 * Except for i
                 */
                column[i] = variables[i][n];
                clauses.add(column);
            }
            /**
             * Let all vertices be set to false
             */
            int[] column = new int[k];
            for (int j = 0; j < k; j++) {
                column[j] = variables[j][n] * -1; //Negation
            }
            clauses.add(column);
        }
    }

    private static void edgeClauses(HashMap<Integer, List<Integer>> graph, int k, ArrayList<int[]> clauses, int[][] variables) {
        for (Integer key : graph.keySet()) {
            for (Integer neighbour : graph.get(key)) {
                ArrayList<Integer> clause = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        clause.add(variables[i][key] * -1);
                        clause.add(variables[j][neighbour] * -1);
                        clauses.add(convertIntegers(clause));
                        clause = new ArrayList<>();
                    }
                }
            }
        }
    }

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    private static void generateRowClauses(HashMap<Integer, List<Integer>> graph, int k, ArrayList<int[]> clauses, int[][] variables) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < graph.size(); j++) {
                int[] clause = new int[graph.size()];
                for (int v = 0; v < graph.size(); v++) {
                    clause[v] = variables[i][v] * -1; //Negation
                }
                clause[j] = variables[i][j];
                clauses.add(clause);
            }
            /**
             * Also add a clause that forces one variable to be picked
             */
            int[] clause = new int[graph.size()];
            for (int v = 0; v < graph.size(); v++) {
                clause[v] = variables[i][v]; //Negation
            }
            clauses.add(clause);
        }
    }
}
