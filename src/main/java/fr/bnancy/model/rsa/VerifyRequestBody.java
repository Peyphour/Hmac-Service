package fr.bnancy.model.rsa;

public class VerifyRequestBody {

    private String signature, data;

    public VerifyRequestBody(String signature, String data) {
        this.signature = signature;
        this.data = data;
    }

    public VerifyRequestBody() {

    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
