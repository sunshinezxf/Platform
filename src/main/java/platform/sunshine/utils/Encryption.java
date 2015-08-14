package platform.sunshine.utils;

import java.security.MessageDigest;

/**
 * Created by sunshine on 2015/8/14.
 */
public class Encryption {
    public static String md5(String string) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = string.getBytes("utf8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte[] updateBytes = md.digest();
            int len = updateBytes.length;
            char temp[] = new char[len * 2];
            int k = 0;
            for (int i = 0; i < len; i++) {
                byte byte0 = updateBytes[i];
                temp[k++] = hexDigits[byte0 >>> 4 & 0x0f];
                temp[k++] = hexDigits[byte0 & 0x0f];
            }
            return new String(temp);
        } catch (Exception e) {
            return null;
        }
    }
}
