package fr.bnancy.model;

public class SignResponseBody {

    private String body, hash, algorithm;

    public SignResponseBody(String body, String hash, String algorithm) {
        this.body = body;
        this.hash = hash;
        this.algorithm = algorithm;
    }

    public SignResponseBody() {

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
}
