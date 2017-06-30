package fr.bnancy.model;

public class VerifyRequestResult {

    private boolean result;
    private String body;

    public VerifyRequestResult(boolean result, String body) {
        this.result = result;
        this.body = body;
    }

    public VerifyRequestResult() {

    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
