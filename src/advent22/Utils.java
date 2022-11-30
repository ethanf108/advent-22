package advent22;

import in.InputReflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public enum Utils {
    ;

    public static int max(int... l) {
        int m = 0;
        for (int i : l) {
            if (i > m) {
                m = i;
            }
        }
        return m;
    }

    public static int min(int... l) {
        int m = 99999999;
        for (int i : l) {
            if (i < m) {
                m = i;
            }
        }
        return m;
    }

    public static String readFully(InputStream in) {
        StringBuilder sb = new StringBuilder();
        int read;
        try {
            while ((read = in.read()) != -1) {
                sb.append((char) read);
            }
        } catch (IOException e) {
            throw new Error(e);
        }
        return sb.toString();
    }

    public static String readInputFile(int num) {
        return readFully(InputReflect.class.getResourceAsStream("in" + num + ".txt"));
    }
}
