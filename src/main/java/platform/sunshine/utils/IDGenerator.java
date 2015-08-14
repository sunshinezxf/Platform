package platform.sunshine.utils;

/**
 * Created by pandora on 2015/8/14.
 */
public class IDGenerator {
    private static String prefix(Class T) {
        String prefix = T.getSimpleName().toLowerCase();
        return prefix;
    }

    private static String credit(int length) {
        return Random.code(length);
    }

    public static String generate(Class T, int length) {
        return Encryption.md5(prefix(T) + credit(length));
    }

    public static void main(String[] args) {
        System.out.println(generate(IDGenerator.class, 10));
    }
}
