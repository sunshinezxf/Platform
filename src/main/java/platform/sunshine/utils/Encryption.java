package platform.sunshine.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;

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

    public static String desEncode(String data, String key) {
        try {
            byte[] bt = encrypt(data.getBytes(), key.getBytes());
            return new BASE64Encoder().encode(bt);
        } catch (Exception e) {
            return null;
        }
    }

    public static String desDecode(String data, String key) {
        if (data == null)
            return null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] buf = decoder.decodeBuffer(data);
            byte[] bt = decrypt(buf, key.getBytes());
            return new String(bt);
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();

        DESKeySpec dks = new DESKeySpec(key);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();

        DESKeySpec dks = new DESKeySpec(key);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
}
