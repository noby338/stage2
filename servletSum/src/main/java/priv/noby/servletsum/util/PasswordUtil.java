package priv.noby.servletsum.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Noby
 * @since 2022/10/7
 */
public class PasswordUtil {
    public static String getMD5String(String str) {
        try {
            // 创建支持MD5算法加密的核心类
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(str.getBytes());
            //bytes中有16个元素：将每个元素格式化成两位的十六进制，就是标准的32的MD5加密后的编码
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
