package com.crypto_api.crypto_api_project.util;

import java.security.SecureRandom;

public class CryptoUtils {

    public static String generateRandomAESKey(int length) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[length];
        random.nextBytes(key);
        StringBuilder sb = new StringBuilder();
        for (byte b : key) {
            sb.append((char) ('A' + (b & 15)));
        }
        return sb.toString();
    }
}
