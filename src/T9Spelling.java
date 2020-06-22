import java.util.HashMap;
import java.util.Scanner;

public class T9Spelling {

    static String test = "4\n" +
            "hi\n" +
            "yes\n" +
            "foo  bar\n" +
            "hello world\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<Character, String> keypad = new HashMap<>();
        keypad.put('a', "2");
        keypad.put('b', "22");
        keypad.put('c', "222");
        keypad.put('d', "3");
        keypad.put('e', "33");
        keypad.put('f', "333");
        keypad.put('g', "4");
        keypad.put('h', "44");
        keypad.put('i', "444");
        keypad.put('j', "5");
        keypad.put('k', "55");
        keypad.put('l', "555");
        keypad.put('m', "6");
        keypad.put('n', "66");
        keypad.put('o', "666");
        keypad.put('p', "7");
        keypad.put('q', "77");
        keypad.put('r', "777");
        keypad.put('s', "7777");
        keypad.put('t', "8");
        keypad.put('u', "88");
        keypad.put('v', "888");
        keypad.put('w', "9");
        keypad.put('x', "99");
        keypad.put('y', "999");
        keypad.put('z', "9999");
        keypad.put(' ', "0");
        int n = s.nextInt();
        s.nextLine();
        int testcasePrint = 1;

        while (n-- != 0) {
            System.out.printf("Case #%d: ", testcasePrint);
            StringBuilder sb = new StringBuilder();
            String text = s.nextLine();
            for (int i = 0; i < text.length(); i++) {
                if (i != 0 && keypad.get(text.charAt(i)).endsWith(keypad.get(text.charAt(i - 1)).substring(0, 1))) {
                    sb.append(" ");
                }
                sb.append(keypad.get(text.charAt(i)));
            }
            System.out.println(sb.toString());
            testcasePrint++;
        }
    }
}
