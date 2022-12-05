package advent22;

import static advent22.Utils.*;

import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent5 {

    public static void main_1(String[] args) {
        final String INPUT = readInputFile(5);
        final ListIterator<String> it = Arrays.asList(INPUT.split("\r?\n")).listIterator();
        final Stack<String> setupLines = new Stack<>();
        int numStacks = -1;
        for (; ; ) {
            final String line = it.next();
            if (!line.contains("[")) {
                final String[] nums = line.strip().split(" +");
                numStacks = nums.length;
                it.next();
                break;
            }
            setupLines.push(line);
        }
        List<Stack<String>> towers = new ArrayList<>(numStacks);
        while (numStacks-- > 0) {
            towers.add(new Stack<>());
        }
        while (!setupLines.isEmpty()) {
            final String setup = setupLines.pop() + " ".repeat(99);
            for (int i = 0; i < towers.size(); i++) {
                if (setup.charAt(i * 4 + 1) != ' ') {
                    towers.get(i).push(setup.charAt(i * 4 + 1) + "");
                }
            }
        }
        while (it.hasNext()) {
            final String[] actions_ = it.next().split("move | from | to ");
            final int[] actions = new int[]{
                    Integer.parseInt(actions_[1]),
                    Integer.parseInt(actions_[2]),
                    Integer.parseInt(actions_[3]),
            };
            final Queue<String> tmp = new ArrayDeque<>();
            while (actions[0]-- > 0) {
                tmp.offer(towers.get(actions[1] - 1).pop());
            }
            while (!tmp.isEmpty()) {
                towers.get(actions[2] - 1).push(tmp.poll());
            }
        }
        for (Stack<String> s : towers) {
            System.out.print(s.peek());
        }
        System.out.println();
    }

    public static void main_2(String[] args) {
        final String INPUT = readInputFile(5);
        final ListIterator<String> it = Arrays.asList(INPUT.split("\r?\n")).listIterator();
        final Stack<String> setupLines = new Stack<>();
        int numStacks = -1;
        for (; ; ) {
            final String line = it.next();
            if (!line.contains("[")) {
                final String[] nums = line.strip().split(" +");
                numStacks = nums.length;
                it.next();
                break;
            }
            setupLines.push(line);
        }
        List<Stack<String>> towers = new ArrayList<>(numStacks);
        while (numStacks-- > 0) {
            towers.add(new Stack<>());
        }
        while (!setupLines.isEmpty()) {
            final String setup = setupLines.pop() + " ".repeat(99);
            for (int i = 0; i < towers.size(); i++) {
                if (setup.charAt(i * 4 + 1) != ' ') {
                    towers.get(i).push(setup.charAt(i * 4 + 1) + "");
                }
            }
        }
        while (it.hasNext()) {
            final String[] actions_ = it.next().split("move | from | to ");
            final int[] actions = new int[]{
                    Integer.parseInt(actions_[1]),
                    Integer.parseInt(actions_[2]),
                    Integer.parseInt(actions_[3]),
            };
            final Stack<String> tmp = new Stack<>();
            while (actions[0]-- > 0) {
                tmp.push(towers.get(actions[1] - 1).pop());
            }
            while (!tmp.isEmpty()) {
                towers.get(actions[2] - 1).push(tmp.pop());
            }
        }
        for (Stack<String> s : towers) {
            System.out.print(s.peek());
        }
        System.out.println();
    }
}
