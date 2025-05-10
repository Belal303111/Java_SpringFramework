package com.crypto_api.crypto_api_project.controller;

import com.crypto_api.crypto_api_project.model.CryptoRequest;
import com.crypto_api.crypto_api_project.service.AESService;
import com.crypto_api.crypto_api_project.service.RSAService;
import com.crypto_api.crypto_api_project.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CryptoController {

    @Autowired
    private AESService aesService;

    @Autowired
    private RSAService rsaService;

    @Autowired
    private HashService hashService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody CryptoRequest request) throws Exception {
        switch (request.getAlgorithm().toUpperCase()) {
            case "AES":
                return aesService.encrypt(request.getInputText(), request.getKey());
            case "RSA":
                return rsaService.encrypt(request.getInputText());
            default:
                return "Unsupported algorithm!";
        }
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody CryptoRequest request) throws Exception {
        switch (request.getAlgorithm().toUpperCase()) {
            case "AES":
                return aesService.decrypt(request.getInputText(), request.getKey());
            case "RSA":
                return rsaService.decrypt(request.getInputText());
            default:
                return "Unsupported algorithm!";
        }
    }

    @PostMapping("/hash")
    public String hash(@RequestBody CryptoRequest request) throws Exception {
        return hashService.hash(request.getInputText(), request.getAlgorithm());
    }
}
