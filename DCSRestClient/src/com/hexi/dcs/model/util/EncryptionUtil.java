package com.hexi.dcs.model.util;


import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptionUtil {
    public static final String ENC_KEY = "~!@oApTI0o.o0987";

    public EncryptionUtil() {
        super();
    }

    public static void main(String[] args) throws Exception {
        //        byte [] encrpted = encrypt ("1AumMaaDurga1");
        //        System.err.println (decrypt(encrpted));

        String encrptedTxt = encryptString("extra@4CraWleR");
        System.err.println("----->>>>>" + encrptedTxt);
        System.err.println("----AUM->" + decryptString("91CnLIcHxxddlPkHsCKj0Q=="));

    }

    public static byte[] encrypt(String plainText) throws Exception {
        byte[] encrypted = getCypher(Cipher.ENCRYPT_MODE).doFinal(plainText.getBytes());
        System.err.println(new String(encrypted));
        return encrypted;
    }

    public static String decrypt(byte[] encryptedText) throws Exception {
        byte[] decryptedByte = getCypher(Cipher.DECRYPT_MODE).doFinal(encryptedText);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }

    public static Cipher getCypher(int mode) throws NoSuchAlgorithmException, NoSuchPaddingException,
                                                    InvalidKeyException {
        // Create key and cipher
        Key aesKey = new SecretKeySpec(ENC_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        // encrypt the text
        cipher.init(mode, aesKey);
        return cipher;
    }

    public static String encryptString(String plainText) throws Exception {
        byte[] encrypted = getCypher(Cipher.ENCRYPT_MODE).doFinal(plainText.getBytes());
//        System.err.println(new String(encrypted));
        byte[] enc64 = Base64.encodeBase64(encrypted);
        String encryptedText = new String(enc64);
        return encryptedText;
    }

    public static String decryptString(String encryptedText) throws Exception {
        byte[] encryptedTextByte = Base64.decodeBase64(encryptedText.getBytes());
        byte[] decryptedByte = getCypher(Cipher.DECRYPT_MODE).doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
}


