package fr.bnancy.model.rsa;

public class SignResponseBody {

    private String signature, data;

    public SignResponseBody(String signature, String data) {
        this.signature = signature;
        this.data = data;
    }

    public SignResponseBody() {

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
