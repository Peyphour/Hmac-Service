package fr.bnancy.model.hmac;

public class VerifyRequest {
    private String body, hash, algorithm;

    public VerifyRequest(String body, String hash, String algorithm) {
        this.body = body;
        this.hash = hash;
        this.algorithm = algorithm;
    }

    public VerifyRequest() {

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String toString() {
        return "VerifyRequest{" +
                "body='" + body + '\'' +
                ", hash='" + hash + '\'' +
                ", algorithm='" + algorithm + '\'' +
                '}';
    }
}
