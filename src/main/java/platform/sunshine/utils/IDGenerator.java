package platform.sunshine.utils;

/**
 * Created by sunshine on 2015/8/14.
 */
public class IDGenerator {
    private static String prefix(Class T) {
        String prefix = T.getSimpleName().toLowerCase();
        return prefix;
    }

    public static String generate(int length) {
        return Random.code(length);
    }

}
