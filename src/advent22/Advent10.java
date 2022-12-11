package advent22;

import static advent22.Utils.*;

import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent10 {

    public static void main_2(String[] args) {
        final String INPUT = readInputFile(10);
        int inst = 0;
        int sum = 0;
        int x = 1;
        Integer addNext = null;
        final ListIterator<String> lines = Arrays.asList(INPUT.split("\r?\n")).listIterator();
        while (lines.hasNext() || addNext != null) {
            inst++;
            if ((inst - 20) % 40 == 0) {
                sum += inst * x;
            }
            if (addNext != null) {
                x += addNext;
                addNext = null;
            } else {
                final String line = lines.next();
                if (line.startsWith("a")) {
                    addNext = Integer.parseInt(line.substring(5));
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        final String INPUT = readInputFile(10);
        int inst = 0;
        int x = 1;
        Integer addNext = null;
        final ListIterator<String> lines = Arrays.asList(INPUT.split("\r?\n")).listIterator();
        while (lines.hasNext() || addNext != null) {
            inst++;
            if (addNext != null) {
                x += addNext;
                addNext = null;
            } else {
                final String line = lines.next();
                if (line.startsWith("a")) {
                    addNext = Integer.parseInt(line.substring(5));
                }
            }
            System.out.print(Math.abs(x - (inst % 40)) < 2 ? "#" : ".");
            if (inst % 40 == 0) {
                System.out.println();
            }
        }
    }
}
