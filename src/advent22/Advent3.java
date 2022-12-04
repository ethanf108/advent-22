package advent22;

import static advent22.Utils.*;

import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent3 {

    public static void main_1(String[] args) {
        final String INPUT = readInputFile(3);
        long sum = 0;
        for (String line : INPUT.split("\r?\n")) {
            final String a = line.substring(0, line.length() / 2);
            final String b = line.substring(line.length() / 2);
            for (char c : a.toCharArray()) {
                if (b.contains(c + "")) {
                    if (Character.isLowerCase(c)) {
                        sum += c - 'a' + 1;
                    } else {
                        sum += c - 'A' + 27;
                    }
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        final String INPUT = readInputFile(3);
        long sum = 0;
        final String[] lines = INPUT.split("\r?\n");
        final Iterator<String> it = Arrays.stream(lines).iterator();
        for (; it.hasNext(); ) {
            final String a = it.next();
            final String b = it.next();
            final String c = it.next();
            for (char ch : "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
                if (a.contains(ch + "") && b.contains(ch + "") && c.contains(ch + "")) {
                    if (ch >= 'a') {
                        sum += ch - 'a' + 1;
                    } else {
                        sum += ch - 'A' + 27;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
