package com.mathsigit;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Encrypt {
    /**
     *Using AES-256-CBC encryption mode, the key / IV value needs to be 16 characters。
     */
    private static String ivParameter = "APIPlatform25632";
    private static String algorithm = "AES/CBC/PKCS5PADDING";

    public static SecretKeySpec CreateSecretKeySpec(String sKey, String secretKeyFactory) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(secretKeyFactory);
        KeySpec spec = new PBEKeySpec(sKey.toCharArray());
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), "AES");
    }

    public static String encrypt(String sSrc, String sKey) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, CreateSecretKeySpec(sKey,"PBEWithHMACSHA512AndAES_256"), iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        return new BASE64Encoder().encode(encrypted);
    }

    public static String decrypt(String sSrc, String sKey) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, CreateSecretKeySpec(sKey,"PBEWithHMACSHA512AndAES_256"), iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, "utf-8");
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        String encrypt_value = "D1vWl4sHz+kbpHQnnaYPYZwZ69ymg5iCmi3pQ3aN/DY=";
        String sKey = "Stana2Test111111";
        String _value = "2020/01/15 14:11:24,testtoken";
        try {
            String sec = encrypt(_value, sKey);
            String des = decrypt(sec, sKey);
            String des_from_other = decrypt(encrypt_value, sKey);
            System.out.println("encrypt_value: " + sec);
            System.out.println("decrypt_value: " + des);
            System.out.println("decrypt_value from other: " + decrypt(encrypt_value, sKey));
            System.out.println(des.equals(des_from_other)?"The same!":"Different!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
