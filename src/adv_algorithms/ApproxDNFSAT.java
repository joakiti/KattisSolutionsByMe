package adv_algorithms;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ApproxDNFSAT {

    double sizeOfOmega;
    int noVariables;
    int noClauses;
    int variablesInClauses;

    public ApproxDNFSAT(int noVariables, int noClauses, int variablesInClauses) {
        this.noVariables = noVariables;
        this.noClauses = noClauses;
        this.variablesInClauses = variablesInClauses;
        sizeOfOmega = 0;
    }

    public static void main(String[] args) {
        ApproxDNFSAT dnfs = new ApproxDNFSAT(10, 30, 5);
        //int[][] clauses = dnfs.generateDNFSATs();
        //int[][] variablesAssigned = dnfs.assignVariables();
        /**
         * Generate 20 clauses with 1 unique variable in each clause.
         * The size should be 2^n (2^n-1 for the case when all are negative).
         */
        /**
         *         int noVariables = 20;
         *         int[][] clauses = new int[noVariables][1];
         *         int[][] variablesAssigned = new int[noVariables][1];
         *         for (int i = 0; i < noVariables; i++) {
         *             clauses[i] = new int[]{1};
         *             variablesAssigned[i] = new int[]{i};
         *         }
         */
        int noVariables = 10000;
        int[][] clauses = new int[noVariables][noVariables];
        int[][] variablesAssigned = new int[noVariables][noVariables];
        for (int i = 0; i < noVariables; i++) {
            clauses[i] = IntStream.generate(() -> 0).limit(noVariables).toArray();
            clauses[i][i] = 1;
            variablesAssigned[i] = IntStream.range(0, noVariables).toArray();;
        }
        for (int i = 1; i < 75000; i = i * 2) {
            System.out.print(i + ",");
            System.out.print(dnfs.karpLubySampling(clauses, variablesAssigned, i, noVariables));
            System.out.println();
        }
    }

    public double karpLubySampling(int[][] clauses, int[][] variablesAssigned, int sampleCount, int noVariables) {
        noClauses = clauses.length;
        sizeOfOmega = 0;
        this.noVariables = noVariables;
        for (int i = 0; i < clauses.length; i++) {
            sizeOfOmega += Math.pow(2, noVariables - clauses[i].length);
        }
        double[] cummulated = new double[noClauses];
        cummulated[0] = Math.pow(2, noVariables - clauses[0].length) / sizeOfOmega;
        for (int i = 0; i < noClauses - 1; i++) {
            cummulated[i + 1] = Math.pow(2, noVariables - clauses[i + 1].length) / sizeOfOmega + cummulated[i];
        }
        int succesfulSamples = 0;
        for (int sampling = 0; sampling < sampleCount; sampling++) {
            /**
             * First sample I
             */
            int i = sampleI(cummulated);
            int[] chosenClause = clauses[i];
            int[] variablesInClause = variablesAssigned[i];
            /**
             * GenerateSolution
             */
            HashMap<Integer, Integer> a = sampleA(chosenClause, variablesInClause);
            boolean belongsToGamma = checkIfGood(i, a, clauses, variablesAssigned);
            if (belongsToGamma) {
                succesfulSamples++;
            }
        }
        return (succesfulSamples / (double) sampleCount) * sizeOfOmega;
    }

    private boolean checkIfGood(int i, HashMap<Integer, Integer> a, int[][] clauses, int[][] variablesAssigned) {
        continueI:
        for (int j = i - 1; j >= 0; j--) {
            int[] chosenClause = clauses[j];
            int[] variablesInClause = variablesAssigned[j];
            for (int k = 0; k < chosenClause.length; k++) {
                int clauseValue = chosenClause[k];
                int var = variablesInClause[k];
                if (a.get(var) != clauseValue) {
                    continue continueI;
                }
            }
            return false;
        }
        return true;
    }

    private HashMap<Integer, Integer> sampleA(int[] chosenClause, int[] variablesInClause) {
        HashSet<Integer> variablesAvailable = IntStream.range(0, noVariables).boxed().collect(Collectors.toCollection(HashSet::new));
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int j = 0; j < chosenClause.length; j++) {
            int variableNumber = variablesInClause[j];
            int value = chosenClause[j];
            a.put(variableNumber, value);
            variablesAvailable.remove(variableNumber);
        }
        for (Integer remainingVariable : variablesAvailable) {
            a.put(remainingVariable, ThreadLocalRandom.current().nextInt(2));
        }
        return a;
    }

    private int sampleI(double[] cummulated) {
        double iEq = ThreadLocalRandom.current().nextLong((long) sizeOfOmega) / sizeOfOmega;
        int i = 0;
        while (iEq > cummulated[i]) {
            i++;
        }
        return i;
    }

    public int bruteForceSolution(int[][] clauses, int[][] variablesAssigned, int noVariables) {
        HashSet<HashMap<Integer, Integer>> validSolutions = new HashSet<>();
        List<List<Integer>> permutations = new ArrayList<>();
        generateAllPermutations(permutations, noVariables);
        //Try to satisfy every clause for every assignment
        for (int clause = 0; clause < clauses.length; clause++) {
            nextAssignment:
            for (List<Integer> assignment : permutations) {
                HashMap<Integer, Integer> varToAssign = assignment.stream().collect(HashMap::new,
                        (map, streamValue) -> map.put(map.size(), streamValue),
                        (map, map2) -> {
                        });
                //Look at every clause var and see if correct
                for (int clauseIndex = 0; clauseIndex < clauses[0].length; clauseIndex++) {
                    if (varToAssign.get(variablesAssigned[clause][clauseIndex]) != clauses[clause][clauseIndex]) {
                        continue nextAssignment;
                    }
                }
                validSolutions.add(varToAssign);
            }
        }
        return validSolutions.size();
    }

    public void generateAllPermutations(List<List<Integer>> permutations, int numberOfVariables) {
        //Add first all zeroes
        //Then add all permutations
        ArrayList<Integer> withZero = new ArrayList<>();
        withZero.add(0);
        ArrayList<Integer> withOne = new ArrayList<>();
        withOne.add(1);
        permutationHelper(permutations, numberOfVariables, withOne);
        permutationHelper(permutations, numberOfVariables, withZero);
    }

    private void permutationHelper(List<List<Integer>> addWhenFinished, int numberOfVariables, ArrayList<Integer> currList) {
        if (currList.size() == numberOfVariables) {
            addWhenFinished.add(currList);
        } else {
            ArrayList<Integer> withZero = new ArrayList<>(currList);
            withZero.add(0);

            ArrayList<Integer> withOne = new ArrayList<>(currList);
            withOne.add(1);

            permutationHelper(addWhenFinished, numberOfVariables, withZero);
            permutationHelper(addWhenFinished, numberOfVariables, withOne);
        }

    }

    public int[][] assignVariables() {
        Random r = new Random(2L);
        int[][] assignments = new int[noClauses][variablesInClauses];
        for (int i = 0; i < noClauses; i++) {
            assignments[i] = r.ints(0, noVariables)
                    .distinct()
                    .limit(variablesInClauses)
                    .toArray();
        }
        return assignments;
    }

    public int[][] generateDNFSATs() {
        sizeOfOmega = 0;
        Random r = new Random(2L);
        HashSet<List<Integer>> uniqueClauses = new HashSet<>();
        for (int i = 0; i < noClauses; i++) {
            List<Integer> clause = r.ints(0, 2)
                    .limit(variablesInClauses)
                    .boxed()
                    .collect(Collectors.toList());
            uniqueClauses.add(clause);
        }
        int[][] uniques = new int[uniqueClauses.size()][variablesInClauses];
        int i = 0;
        for (List<Integer> clause : uniqueClauses) {
            uniques[i] = clause.stream().mapToInt(x -> x).toArray();
            sizeOfOmega += Math.pow(2, noVariables - clause.size());
            i++;
        }
        noClauses = uniques.length;
        return uniques;
    }

}
