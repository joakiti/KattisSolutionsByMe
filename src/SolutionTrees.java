import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SolutionTrees {
    public int cutOffTree(List<List<Integer>> forest) {
        List<Pair> trees = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            List<Integer> positions = forest.get(i);
            for (int j = 0; j < positions.size(); j++) {
                if (positions.get(j) != 1) {
                    trees.add(new Pair(i, j, positions.get(j)));
                }
            }
        }
        trees.sort(Comparator.comparingInt(o -> o.tree));
        return 1;

    }

    class Pair {

        int x;
        int y;

        int tree = 0;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, int tree) {
            this.x = x;
            this.y = y;
            this.tree = tree;
        }

        boolean hasTree() {
            return tree == 0;
        }

    }
}