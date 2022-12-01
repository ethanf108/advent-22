package advent22;

import static advent22.Utils.*;

import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;
import java.time.*;

public class Advent1 {

    public static void main(String[] args) {
        final String INPUT = readInputFile(1);
        int c = 0;
        List<Integer> all = new ArrayList<>();
        for (String line : INPUT.split("\r?\n")) {
            if (line.isBlank()) {
                all.add(c);
                c = 0;
                continue;
            }
            int i = Integer.parseInt(line);
            c += i;
        }
        all.add(c);
        Collections.sort(all);
        Collections.reverse(all);
        System.out.println(all.get(0) + all.get(1) + all.get(2));
        System.out.println(all.get(1));
        System.out.println(all.get(2));
    }
}
