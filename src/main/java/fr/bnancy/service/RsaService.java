package fr.bnancy.service;

import org.springframework.stereotype.Service;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Service
public class RsaService {

    private static final String ALGORITHM = "SHA512withRSA";

    public KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(4096, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    public byte[] sign(byte[] privateKey, byte[] data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        Signature signature = Signature.getInstance(ALGORITHM);

        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKeyDecoded = keyFactory.generatePrivate(privateKeySpec);

        signature.initSign(privateKeyDecoded);
        signature.update(data);
        return signature.sign();
    }

    public boolean verify(byte[] publicKey, byte[] data, byte[] signedData) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKeyDecoded = keyFactory.generatePublic(pubKeySpec);

        System.out.println(signedData.length);

        Signature signature = Signature.getInstance(ALGORITHM);
        signature.initVerify(publicKeyDecoded);
        signature.update(data);

        return signature.verify(signedData);
    }
}
