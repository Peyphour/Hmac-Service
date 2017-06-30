package fr.bnancy.web;

import fr.bnancy.model.account.AccountCreateRequest;
import fr.bnancy.model.account.AccountLoginRequest;
import fr.bnancy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody AccountCreateRequest accountCreateRequest) throws NoSuchAlgorithmException {
        if(accountService.createAccount(accountCreateRequest)) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody AccountLoginRequest accountLoginRequest) {
        String token = accountService.loginAccount(accountLoginRequest);
        if(!token.equals("")) {
            return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
