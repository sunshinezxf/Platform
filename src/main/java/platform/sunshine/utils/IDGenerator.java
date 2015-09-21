package platform.sunshine.utils;

/**
 * Created by sunshine on 2015/8/14.
 */
public class IDGenerator {
    public static String generate(int length) {
        return Random.code(length);
    }
}
