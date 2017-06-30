package fr.bnancy.model.rsa;

public class SignRequestBody {

    private String data;

    public SignRequestBody(String data) {
        this.data = data;
    }

    public SignRequestBody() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
