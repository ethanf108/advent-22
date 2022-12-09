package advent22;

import static advent22.Utils.*;

import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent9 {

    private record XY(int x, int y) {

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public static void main_1(String[] args) {
        final String INPUT = readInputFile(9);
        int hx = 0, hy = 0, tx = 0, ty = 0;
        final HashSet<XY> pos = new HashSet<>();
        for (String line : INPUT.split("\r?\n")) {
            for (char c : line.substring(0, 1).repeat(Integer.parseInt(line.split(" ")[1])).toCharArray()) {
                switch (c) {
                    case 'U' -> {
                        hy++;
                    }
                    case 'D' -> {
                        hy--;
                    }
                    case 'L' -> {
                        hx--;
                    }
                    case 'R' -> {
                        hx++;
                    }
                    default -> throw new IllegalArgumentException("BRUH");
                }
                if (Math.abs(tx - hx) > 1 || Math.abs(ty - hy) > 1) {
                    if (hx - tx > 0) {
                        tx++;
                    } else if (tx - hx > 0) {
                        tx--;
                    }
                    if (hy - ty > 0) {
                        ty++;
                    } else if (ty - hy > 0) {
                        ty--;
                    }
                }
                pos.add(new XY(tx, ty));
            }
        }
        System.out.println(pos.size());
    }

    public static void main_2(String[] args) {
        final String INPUT = readInputFile(9);
        XY[] knots = new XY[10];
        Arrays.fill(knots, new XY(0, 0));
        final HashSet<XY> pos = new HashSet<>();
        for (String line : INPUT.split("\r?\n")) {
            for (char c : line.substring(0, 1).repeat(Integer.parseInt(line.split(" ")[1])).toCharArray()) {
                switch (c) {
                    case 'U' -> {
                        knots[0] = new XY(knots[0].x, knots[0].y + 1);
                    }
                    case 'D' -> {
                        knots[0] = new XY(knots[0].x, knots[0].y - 1);
                    }
                    case 'L' -> {
                        knots[0] = new XY(knots[0].x - 1, knots[0].y);
                    }
                    case 'R' -> {
                        knots[0] = new XY(knots[0].x + 1, knots[0].y);
                    }
                    default -> throw new IllegalArgumentException("BRUH");
                }
                for (int i = 1; i < 10; i++) {
                    final XY up = knots[i - 1];
                    final XY th = knots[i];
                    if (Math.abs(th.x - up.x) > 1 || Math.abs(th.y - up.y) > 1) {
                        if (up.x - th.x > 0) {
                            knots[i] = new XY(knots[i].x + 1, knots[i].y);
                        } else if (th.x - up.x > 0) {
                            knots[i] = new XY(knots[i].x - 1, knots[i].y);
                        }
                        if (up.y - th.y > 0) {
                            knots[i] = new XY(knots[i].x, knots[i].y + 1);
                        } else if (th.y - up.y > 0) {
                            knots[i] = new XY(knots[i].x, knots[i].y - 1);
                        }
                    }
                }
                pos.add(knots[9]);
            }
        }
        System.out.println(pos.size());
    }
}
