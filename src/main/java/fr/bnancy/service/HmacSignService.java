package fr.bnancy.service;

import fr.bnancy.model.hmac.SignRequestBody;
import fr.bnancy.model.hmac.SignResponseBody;
import fr.bnancy.model.hmac.VerifyRequest;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HmacSignService {

    @Value("${application.signKey}")
    private String applicationKey;

    public HmacSignService(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public HmacSignService() {

    }

    private String calculateHash(String body, String algorithm) {
        String hash;
        switch (algorithm) {
            case "SHA1":
                hash = HmacUtils.hmacSha1Hex(this.applicationKey, body);
                break;
            case "MD5":
                hash = HmacUtils.hmacMd5Hex(this.applicationKey, body);
                break;
            case "SHA256":
                hash = HmacUtils.hmacSha256Hex(this.applicationKey, body);
                break;
            case "SHA512":
                hash = HmacUtils.hmacSha512Hex(this.applicationKey, body);
                break;
            default:
                throw new IllegalArgumentException("Algorithm '" + algorithm + "' is not supported");
        }
        return hash;
    }

    public SignResponseBody sign(SignRequestBody body) {
        return new SignResponseBody(body.getBody(), this.calculateHash(body.getBody(), body.getAlgorithm()), body.getAlgorithm());
    }

    public boolean verify(VerifyRequest verifyRequest) {
        String calculatedHash = this.calculateHash(verifyRequest.getBody(), verifyRequest.getAlgorithm());
        return calculatedHash.equals(verifyRequest.getHash());
    }
}
