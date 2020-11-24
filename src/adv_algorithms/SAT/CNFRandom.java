package adv_algorithms.SAT;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.*;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CNFRandom {

    public static void main(String[] args) {
        for (double r = 1; r <= 20; r += 1) {

            int n = 1000;
            /**
             * Pick c between 500 - 1000
             */
            int C = new Random().nextInt(100) + 100;
            /**
             * Pick fraction between 1 and 15.
             */
            List<List<CNFClause>> random4CNFS = new ArrayList<>();
            Random rand = new Random();
            for (int i = 0; i < C; i++) {
                List<CNFClause> CNFFormulas = new ArrayList<>();
                for (int j = 0; j < (int) r * n; j++) {
                    List<Integer> clause = rand.ints(1, n + 1)
                            .limit(4)
                            .boxed()
                            .collect(Collectors.toList());

                    List<Boolean> assignments = rand.ints(0, 2)
                            .limit(4)
                            .mapToObj(value -> value == 0 ? Boolean.TRUE : Boolean.FALSE)
                            .collect(Collectors.toList());
                    /**
                     * If set to negative, change sign of i.
                     */
                    int[] casted = new int[clause.size()];
                    for (int k = 0; k < clause.size(); k++) {
                        casted[k] = assignments.get(k) ? clause.get(k) : -clause.get(k);
                    }
                    var CNFClause = new CNFClause(casted);
                    CNFFormulas.add(CNFClause);
                }
                random4CNFS.add(CNFFormulas);
            }
            int satisfied = 0;
            long totalTime = 0;
            for (List<CNFClause> clauses : random4CNFS) {
                long startTime = System.currentTimeMillis();
                ISolver solver = SolverFactory.newDefault();
                solver.newVar(n);
                solver.setExpectedNumberOfClauses((int) r * n);
                solver.setTimeoutMs(10000); // 1 min timeout
                for (CNFClause clause : clauses) {
                    try {
                        solver.addClause(new VecInt(clause.clause));
                    } catch (ContradictionException e) {
                        System.out.println("Clauses was contradictory");

                    }
                }
                IProblem problem = solver;
                try {
                    if (problem.isSatisfiable()) {
                        satisfied++;
                    } else {
                        System.out.println(String.format("Given (r,n) = (%f, %d) not able to satisfy ", r, n));
                    }
                } catch (TimeoutException e) {

                }
                long endTime = System.currentTimeMillis();
                totalTime += endTime - startTime;
            }
            System.out.printf("f(%f) = %d\n", r, satisfied);
            System.out.printf("g(%f) = %d\n", r, C);
            System.out.printf("t(%f) = %f\n", r, totalTime/(double)C);
        }

    }

    static class CNFClause {

        public CNFClause(int[] clause) {
            this.clause = clause;
        }

        int[] clause;
    }
}
