import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DrunkVignere {

    static String test = "CAACRYY\n" +
            "ABBRTAA";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String cipher = s.next();
        String key = s.next();

        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> charactersToInt = new HashMap<>();
        Map<Integer, Character> integerCharacterMap = new HashMap<>();
        int i = 0;
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            charactersToInt.put(ch, i);
            integerCharacterMap.put(i, ch);
            i++;
        }


        for (int j = 0; j < cipher.length() ; j++) {
            if (j % 2 == 0) {
                int c = charactersToInt.get(cipher.charAt(j));
                c = (c - charactersToInt.get(key.charAt(j))) % charactersToInt.size();
                if (c < 0) {
                    c += charactersToInt.size();
                }
                sb.append(integerCharacterMap.get(c));
            }
            if (j % 2 == 1) {
                int c = charactersToInt.get(cipher.charAt(j));
                c = (c + charactersToInt.get(key.charAt(j))) % charactersToInt.size();
                sb.append(integerCharacterMap.get(c));
            }
        }
        System.out.println(sb.toString());
    }
}
