package fr.bnancy.model.account;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, length = 95)
    private String mail;

    @Column
    private String passwordHash;

    @Column
    private String token;

    @Column(length = 4096)
    private byte[] publicKey;

    @Column(length = 4096)
    private byte[] privateKey;

    public Account() {

    }

    public Account(String mail, String passwordHash, String token, byte[] publicKey, byte[] privateKey) {
        this.mail = mail;
        this.passwordHash = passwordHash;
        this.token = token;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public byte[] getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
    }

    public byte[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(byte[] privateKey) {
        this.privateKey = privateKey;
    }
}
