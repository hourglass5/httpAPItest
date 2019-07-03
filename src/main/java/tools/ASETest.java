package tools;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class ASETest {
    /**
     * 加密
     */
    public static byte[] Encrypt(String src) throws Exception {
        String key = "kaledaimall98765";
        // 判断密钥是否为空
        if (key == null) {
            System.out.print("密钥不能为空");
            return null;
        }

        // 密钥补位
        int plus= 16-key.length();
        byte[] data = key.getBytes("utf-8");
        byte[] raw = new byte[16];
        byte[] plusbyte={ 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
        for(int i=0;i<16;i++)
        {
            if (data.length > i)
                raw[i] = data[i];
            else
                raw[i] = plusbyte[plus];
        }

        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        SecureRandom random = new SecureRandom();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // 算法/模式/补码方式
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec,iv);
        byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));

        return encrypted;
//        return new Base64().encodeToString(encrypted);//base64
//        return binary(encrypted, 16); //十六进制
    }

    /**
     * 解密
     */
    public static String Decrypt(String src, String key) throws Exception {
        try {
            // 判断Key是否正确
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }

            // 密钥补位
            int plus= 16-key.length();
            byte[] data = key.getBytes("utf-8");
            byte[] raw = new byte[16];
            byte[] plusbyte={ 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
            for(int i=0;i<16;i++)
            {
                if (data.length > i)
                    raw[i] = data[i];
                else
                    raw[i] = plusbyte[plus];
            }

            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(key.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.DECRYPT_MODE, skeySpec,iv);

            //byte[] encrypted1 = new Base64().decode(src);//base64
            byte[] encrypted1 = toByteArray(src);//十六进制

            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    /**
     * 将byte[]转为各种进制的字符串
     * @param bytes byte[]
     * @param radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix){
        return new BigInteger(1, bytes).toString(radix);    // 这里的1代表正数
    }

    /**
     * 16进制的字符串表示转成字节数组
     *
     * @param hexString 16进制格式的字符串
     * @return 转换后的字节数组
     **/
    public static byte[] toByteArray(String hexString) {
        if (hexString.isEmpty())
            throw new IllegalArgumentException("this hexString must not be empty");

        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }
    //    利用MD5进行加密
    public static  String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return binary(md5.digest(str.getBytes("utf-8")), 16);
    }

    // Base64 加密
    public static void Base64En(String password) throws Exception{
        // 加密
        byte[] enString = Encrypt(password);
//        Base64 Base64 = new Base64();
//        return new Base64().encodeToString(enString);
    }

    public static void main(String[] args) throws Exception {
        // 密钥
        String key = "kaledaimall98765";
        // 需要加密的字符串
        String src = "456456";
        String password = "111111";

        System.out.println(src);

        // Base64 加密
        byte[] enString = Encrypt(src);
        System.out.println(enString);
//        System.out.println("加密后的字串是(Base64)：" + Base64En(password));
//        System.out.println(toByteArray(Base64En(password)));
        System.out.println("加密后的字串是(十六进制)：" + binary(enString, 16));

        // 解密
        String DeString = Decrypt(binary(enString, 16), key);
        System.out.println("解密后的字串是：" + DeString);

        System.out.println("md5加密后的字串是：" + EncoderByMd5("1589544b351297a40b18cb5252eb7cdedd600876020"));
    }
}