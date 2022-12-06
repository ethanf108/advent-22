package advent22;

import static advent22.Utils.*;

import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent6 {

    private static int solve(String INPUT, int size) {
        for (int i = 0; i < INPUT.length() - size + 1; i++) {
            Set<String> s = new HashSet<>();
            for (char c : INPUT.substring(i, i + size).toCharArray()) {
                s.add("" + c);
            }
            if (s.size() == size) {
                return i + size;
            }
        }
        throw new IllegalStateException("OOPS");
    }

    public static void main_1(String[] args) {
        final String INPUT = readInputFile(6);
        System.out.println(solve(INPUT, 4));
    }

    public static void main(String[] args) {
        final String INPUT = readInputFile(6);
        System.out.println(solve(INPUT, 14));
    }
}
