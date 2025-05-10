package com.crypto_api.crypto_api_project.util;

import javax.crypto.Cipher;
import java.security.*;

public class RSAUtil {

    private static KeyPair keyPair;

    static {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            keyPair = keyGen.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException("RSA Key generation failed: " + e.getMessage());
        }
    }

    public static String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        return java.util.Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decrypted = cipher.doFinal(java.util.Base64.getDecoder().decode(cipherText));
        return new String(decrypted);
    }
}
