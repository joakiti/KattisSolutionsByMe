import java.util.HashMap;
import java.util.Scanner;

public class ReverseROT {

    static String test = "1 ABCD\n" +
            "3 YO_THERE.\n" +
            "1 .DOT\n" +
            "14 ROAD\n" +
            "9 SHIFTING_AND_ROTATING_IS_NOT_ENCRYPTING\n" +
            "2 STRING_TO_BE_CONVERTED\n" +
            "1 SNQZDRQDUDQ\n" +
            "0\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        HashMap<Integer, Character> integerCharacterHashMap = new HashMap<>();

        int count = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            characterIntegerHashMap.put(i, count);
            integerCharacterHashMap.put(count, i);
            count++;
        }
        characterIntegerHashMap.put('.', 27);
        characterIntegerHashMap.put('_', 26);
        integerCharacterHashMap.put(26, '_');
        integerCharacterHashMap.put(27, '.');

        while (s.hasNext()) {
            int rotations = s.nextInt();
            if (rotations == 0) {
                System.exit(0);
            }
            String shift = new StringBuilder(s.next()).reverse().toString();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < shift.length(); i++) {
                int toShift = characterIntegerHashMap.get(shift.charAt(i));
                int value = toShift + rotations;
                value %= 28;
                ans.append(integerCharacterHashMap.get(value));
            }
            System.out.println(ans);
        }
    }
}
