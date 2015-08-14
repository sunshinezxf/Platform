package platform.sunshine.utils;

/**
 * Created by sunshine on 2015/8/14.
 */
public class Random {
    private static final java.util.Random SEED = new java.util.Random();
    private static final char[] code = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z'};

    private static int num(int min, int max) {
        return min + SEED.nextInt(max - min);
    }

    private static char generate() {
        return code[num(0, code.length)];
    }

    public static String code(int length) {
        char[] temp = new char[length];
        for (int i = 0; i < length; i++) {
            temp[i] = generate();
        }
        return new String(temp);
    }
}
