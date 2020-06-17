import java.util.*;

public class DiceCup {

    static String test = "12 20\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int dieone = s.nextInt();
        int dietwo = s.nextInt();
        HashMap<Integer, Integer> probmapping = new HashMap<>();
        for (int i = 0; i <= dieone + dietwo; i++) {
            probmapping.put(i, 0);
        }
        int max = 0;
        for (int i = 1; i <= dieone; i++) {
            for (int j = 1; j <= dietwo; j++) {
                probmapping.put(i + j, probmapping.get(i + j) + 1);
                if (probmapping.get(i + j) > max) {
                    max = probmapping.get(i + j);
                }
            }
        }

        int finalMax = max;
        probmapping.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).forEach(integerIntegerEntry -> {
            if (integerIntegerEntry.getValue() == finalMax) {
                System.out.println(integerIntegerEntry.getKey());
            }
        });
    }
}
