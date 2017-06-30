package fr.bnancy.model.account;

public class AccountCreateRequest {

    private String email, password;

    public AccountCreateRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountCreateRequest() {

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
