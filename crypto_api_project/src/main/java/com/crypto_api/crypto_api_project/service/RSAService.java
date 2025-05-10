package com.crypto_api.crypto_api_project.service;

import com.crypto_api.crypto_api_project.util.RSAUtil;

import org.springframework.stereotype.Service;

@Service
public class RSAService {

    public String encrypt(String plainText) throws Exception {
        return RSAUtil.encrypt(plainText);
    }

    public String decrypt(String cipherText) throws Exception {
        return RSAUtil.decrypt(cipherText);
    }
}
