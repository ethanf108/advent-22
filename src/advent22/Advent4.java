package advent22;

import static advent22.Utils.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent4 {

    public static void main_1(String[] args) {
        final String INPUT = readInputFile(4);

        int count = 0;
        for (String line : INPUT.split("\r?\n")) {
            final String l = line.split(",")[0];
            final String r = line.split(",")[1];
            final int ll = Integer.parseInt(l.split("-")[0]);
            final int lr = Integer.parseInt(l.split("-")[1]);
            final int rl = Integer.parseInt(r.split("-")[0]);
            final int rr = Integer.parseInt(r.split("-")[1]);
            if ((ll >= rl && lr <= rr) || (rl >= ll && rr <= lr)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        final String INPUT = readInputFile(4);

        int count = 0;
        for (String line : INPUT.split("\r?\n")) {
            final String l = line.split(",")[0];
            final String r = line.split(",")[1];
            final int ll = Integer.parseInt(l.split("-")[0]);
            final int lr = Integer.parseInt(l.split("-")[1]);
            final int rl = Integer.parseInt(r.split("-")[0]);
            final int rr = Integer.parseInt(r.split("-")[1]);
            final Rectangle2D rectr = new Rectangle2D.Double(ll - 0.1, 0, Math.abs(ll - lr) + 0.1, 1);
            final Rectangle2D rectl = new Rectangle2D.Double(rl - 0.1, 0, Math.abs(rl - rr) + 0.1, 1);
            if (rectr.intersects(rectl)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
