package fr.bnancy.service;

import fr.bnancy.model.account.Account;
import fr.bnancy.model.account.AccountCreateRequest;
import fr.bnancy.model.account.AccountLoginRequest;
import fr.bnancy.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RsaService rsaService;

    public boolean createAccount(AccountCreateRequest accountCreateRequest) throws NoSuchAlgorithmException {
        Account account = accountRepository.findAccountByMail(accountCreateRequest.getEmail());
        if(account == null) {
            account = new Account();
            account.setMail(accountCreateRequest.getEmail());
            account.setPasswordHash(BCrypt.hashpw(accountCreateRequest.getPassword(), BCrypt.gensalt()));
            KeyPair keyPair = rsaService.generateKeyPair();
            account.setPublicKey(keyPair.getPublic().getEncoded());
            account.setPrivateKey(keyPair.getPrivate().getEncoded());
            accountRepository.save(account);
            return true;
        } else
            return false;
    }

    private String generateAccountToken() {
        return UUID.randomUUID().toString();
    }

    public String loginAccount(AccountLoginRequest accountLoginRequest) {
        Account account = accountRepository.findAccountByMail(accountLoginRequest.getEmail());
        if(account != null) {
            if(BCrypt.checkpw(accountLoginRequest.getPassword(), account.getPasswordHash())) {
                account.setToken(generateAccountToken());
                accountRepository.save(account);
                return account.getToken();
            }
        }
        return "";
    }

    public Account getAccountForToken(String token) {
        return accountRepository.findByToken(token);
    }
}
