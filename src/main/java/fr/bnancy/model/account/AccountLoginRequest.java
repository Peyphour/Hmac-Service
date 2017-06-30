package fr.bnancy.model.account;

public class AccountLoginRequest {

    private String email, password;

    public AccountLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountLoginRequest() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
