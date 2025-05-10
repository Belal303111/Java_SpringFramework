package com.crypto_api.crypto_api_project.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class HashService {

    public String hash(String input, String algorithm) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm.toUpperCase());
        byte[] hashBytes = digest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
