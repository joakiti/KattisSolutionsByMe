package LTHChallenge;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class First {

    static class Command {
        String sound;
        Runnable func;

        public Command(String sound, Runnable func) {
            this.sound = sound;
            this.func = func;
        }
    }

    static StringBuilder sb = new StringBuilder();

    static boolean hasCapslock = false;

    static void appendLetter(String letter) {
        if (hasCapslock) {
            sb.append(letter.toUpperCase());
        } else {
            sb.append(letter);
        }
    }

    static void removeLetter() {
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
    }

    static void setCapsLock() {
        hasCapslock = !hasCapslock;
    }


    static Command cmds[] = {
            new Command("clank", () -> appendLetter("a")),
            new Command("bong", () -> appendLetter("b")),
            new Command("click", () -> appendLetter("c")),
            new Command("tap", () -> appendLetter("d")),
            new Command("poing", () -> appendLetter("e")),
            new Command("clonk", () -> appendLetter("f")),
            new Command("clack", () -> appendLetter("g")),
            new Command("ping", () -> appendLetter("h")),
            new Command("tip", () -> appendLetter("i")),
            new Command("cloing", () -> appendLetter("j")),
            new Command("tic", () -> appendLetter("k")),
            new Command("cling", () -> appendLetter("l")),
            new Command("bing", () -> appendLetter("m")),
            new Command("pong", () -> appendLetter("n")),
            new Command("clang", () -> appendLetter("o")),
            new Command("pang", () -> appendLetter("p")),
            new Command("clong", () -> appendLetter("q")),
            new Command("tac", () -> appendLetter("r")),
            new Command("boing", () -> appendLetter("s")),
            new Command("boink", () -> appendLetter("t")),
            new Command("cloink", () -> appendLetter("u")),
            new Command("rattle", () -> appendLetter("v")),
            new Command("clock", () -> appendLetter("w")),
            new Command("toc", () -> appendLetter("x")),
            new Command("clink", () -> appendLetter("y")),
            new Command("tuc", () -> appendLetter("z")),
            new Command("whack", () -> appendLetter(" ")),
            new Command("bump", First::setCapsLock),
            new Command("pop", First::removeLetter),
            new Command("dink", () -> {}),
            new Command("thumb", () -> {}),

    };

    static Command findCommand(String input) {
        for (Command c : cmds) {
            if (input.equals(c.sound)) {
                return c;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        while (n-- > 0) {
            String input = s.next();
            Command c = findCommand(input);
            c.func.run();
        }
        System.out.println(sb.toString());
    }
}
