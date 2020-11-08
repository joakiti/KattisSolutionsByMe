package NCPC;

import java.util.*;

public class CoinStacks {

    static String test = "3\n" +
            "1 1 1";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Value[] coinstacks = new Value[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            coinstacks[i] = new Value(i, s.nextInt());
            sum += coinstacks[i].value;
        }
        if (sum % 2 == 1) {
            System.out.println("no");
            System.exit(0);
        }
        int start = 0;
        int end = coinstacks.length -1;
        List<Tuple> moves = new ArrayList<>();
        Arrays.sort(coinstacks, Comparator.comparingInt(o -> o.value));

        while (start < end) {
            if (coinstacks[start].value < 1) {
                start++;
                continue;
            }
            if (coinstacks[end].value < 1) {
                end--;
                continue;
            }
            coinstacks[start].value--;
            coinstacks[end].value--;
            sum -= 2;
            moves.add(new Tuple(coinstacks[start].origIndex, coinstacks[end].origIndex));
            coinstacks = Arrays.stream(coinstacks).filter(value -> value.value > 0).toArray(Value[]::new);
            Arrays.sort(coinstacks, Comparator.comparingInt(o -> o.value));
            start = 0;
            end = coinstacks.length - 1;
        }

        if (sum < 1) {
            System.out.println("yes");
            for (Tuple t : moves) {
                System.out.printf("%d %d%n", t.a + 1, t.b + 1);
            }
        }
        else {
            System.out.println("no");
        }
    }
    static class Tuple {
        public Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int a, b;
    }
    static class Value {
        public Value(int origIndex, int value) {
            this.origIndex = origIndex;
            this.value = value;
        }

        int origIndex;
        int value;
    }
}
