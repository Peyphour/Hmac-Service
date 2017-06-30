package fr.bnancy.model.hmac;

public class SignRequestBody {

    private String body, algorithm;

    public SignRequestBody(String body, String algorithm) {
        this.body = body;
        this.algorithm = algorithm;
    }

    public SignRequestBody() {

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
