package com.crypto_api.crypto_api_project.util;
import java.security.MessageDigest;

public class HashUtil {
    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash)
                hexString.append(String.format("%02x", b));
            return hexString.toString();
        } catch (Exception e) {
            return "Hashing error: " + e.getMessage();
        }
    }
}
