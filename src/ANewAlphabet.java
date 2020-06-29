import java.util.HashMap;
import java.util.Scanner;

public class ANewAlphabet {

    static String test = "A new alphabet!\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<Character, String> charMapping = new HashMap<>();
        charMapping.put('a', "@");
        charMapping.put('b', "8");
        charMapping.put('c', "(");
        charMapping.put('d', "|)");
        charMapping.put('e', "3");
        charMapping.put('f', "#");
        charMapping.put('g', "6");
        charMapping.put('h', "[-]");
        charMapping.put('i', "|");
        charMapping.put('j', "_|");
        charMapping.put('k', "|<");
        charMapping.put('l', "1");
        charMapping.put('m', "[]\\/[]");
        charMapping.put('n', "[]\\[]");
        charMapping.put('o', "0");
        charMapping.put('p', "|D");
        charMapping.put('q', "(,)");
        charMapping.put('r', "|Z");
        charMapping.put('s', "$");
        charMapping.put('t', "']['");
        charMapping.put('u', "|_|");
        charMapping.put('v', "\\/");
        charMapping.put('w', "\\/\\/");
        charMapping.put('x', "}{");
        charMapping.put('y', "`/");
        charMapping.put('z', "2");

        StringBuilder sb = new StringBuilder();
        s.nextLine().toLowerCase().chars().forEach(value -> sb.append(charMapping.getOrDefault((char) value, String.valueOf((char) value))));
        System.out.println(sb.toString());

    }
}
