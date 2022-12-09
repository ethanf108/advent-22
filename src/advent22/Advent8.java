package advent22;

import static advent22.Utils.*;

import java.nio.IntBuffer;
import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent8 {

    public static void main_1(String[] args) {
        final String INPUT = readInputFile(8);
        List<int[]> build = new ArrayList<>();
        for (String line : INPUT.split("\r?\n")) {
            IntBuffer buf = IntBuffer.allocate(line.length());
            for (char c : line.toCharArray()) {
                buf.put(Integer.parseInt(c + ""));
            }
            build.add(buf.array());
        }
        int[][] grid = new int[build.size()][0];
        for (int i = 0; i < build.size(); i++) {
            grid[i] = build.get(i);
        }
        boolean[][] yes = new boolean[grid.length][grid[0].length];
        for (boolean[] booleans : yes) {
            Arrays.fill(booleans, false);
        }
        for (int x = 0; x < grid.length; x++) {
            int bsf = -1;
            for (int y = 0; y < grid[x].length; y++) {
                final int val = grid[x][y];
                if (val > bsf) {
                    yes[x][y] = true;
                    bsf = val;
                }
            }
        }
        for (int y = 0; y < grid[0].length; y++) {
            int bsf = -1;
            for (int x = 0; x < grid.length; x++) {
                final int val = grid[x][y];
                if (val > bsf) {
                    yes[x][y] = true;
                    bsf = val;
                }
            }
        }
        for (int x = 0; x < grid.length; x++) {
            int bsf = -1;
            for (int y = grid[x].length - 1; y >= 0; y--) {
                final int val = grid[x][y];
                if (val > bsf) {
                    yes[x][y] = true;
                    bsf = val;
                }
            }
        }
        for (int y = 0; y < grid[0].length; y++) {
            int bsf = -1;
            for (int x = grid.length - 1; x >= 0; x--) {
                final int val = grid[x][y];
                if (val > bsf) {
                    yes[x][y] = true;
                    bsf = val;
                }
            }
        }
        int count = 0;
        for (boolean[] b : yes) {
            for (boolean bb : b) {
                if (bb) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        final String INPUT = readInputFile(8);
        List<int[]> build = new ArrayList<>();
        for (String line : INPUT.split("\r?\n")) {
            IntBuffer buf = IntBuffer.allocate(line.length());
            for (char c : line.toCharArray()) {
                buf.put(Integer.parseInt(c + ""));
            }
            build.add(buf.array());
        }
        int[][] grid = new int[build.size()][0];
        for (int i = 0; i < build.size(); i++) {
            grid[i] = build.get(i);
        }
        int bsf = -1;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1) {
                    continue;
                }
                final int val = grid[x][y];
                int mul = 1;
                int d = 0;
                //up
                try {
                    for (d = 1; grid[x][y + d] < val; d++) {
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    d--;
                }
                mul *= d;
                //down
                try {
                    for (d = 1; grid[x][y - d] < val; d++) {
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    d--;
                }
                mul *= d;
                //right
                try {
                    for (d = 1; grid[x + d][y] < val; d++) {
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    d--;
                }
                mul *= d;
                //left
                try {
                    for (d = 1; grid[x - d][y] < val; d++) {
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    d--;
                }
                mul *= d;
                if (mul > bsf) {
                    bsf = mul;
                }
            }
        }
        System.out.println(bsf);
    }
}
