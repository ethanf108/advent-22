package advent22;

import static advent22.Utils.*;

import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent2 {

    public static void main_1(String[] args) {
        final String INPUT = readInputFile(2);
        int score = 0;
        for (String line : INPUT.split("\r?\n")) {
            String[] l = line.split(" ");
            score += switch (l[0]) {
                case "A" -> switch (l[1]) {
                    case "X" -> 4;
                    case "Y" -> 8;
                    case "Z" -> 3;
                    default -> throw new IllegalArgumentException("HOW");
                };
                case "B" -> switch (l[1]) {
                    case "X" -> 1;
                    case "Y" -> 5;
                    case "Z" -> 9;
                    default -> throw new IllegalArgumentException("HOW");
                };
                case "C" -> switch (l[1]) {
                    case "X" -> 7;
                    case "Y" -> 2;
                    case "Z" -> 6;
                    default -> throw new IllegalArgumentException("HOW");
                };
                default -> throw new IllegalArgumentException("HOW");
            };
        }
        System.out.println(score);
    }

    public static void main_2(String[] args) {
        final String INPUT = readInputFile(2);
        int score = 0;
        for (String line : INPUT.split("\r?\n")) {
            String[] l = line.split(" ");
            score += switch (l[0]) {
                case "A" -> switch (l[1]) {
                    case "X" -> 3;
                    case "Y" -> 4;
                    case "Z" -> 8;
                    default -> throw new IllegalArgumentException("HOW");
                };
                case "B" -> switch (l[1]) {
                    case "X" -> 1;
                    case "Y" -> 5;
                    case "Z" -> 9;
                    default -> throw new IllegalArgumentException("HOW");
                };
                case "C" -> switch (l[1]) {
                    case "X" -> 2;
                    case "Y" -> 6;
                    case "Z" -> 7;
                    default -> throw new IllegalArgumentException("HOW");
                };
                default -> throw new IllegalArgumentException("HOW");
            };
        }
        System.out.println(score);
    }
}
