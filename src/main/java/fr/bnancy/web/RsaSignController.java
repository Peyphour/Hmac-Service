package fr.bnancy.web;

import fr.bnancy.model.account.Account;
import fr.bnancy.model.rsa.SignRequestBody;
import fr.bnancy.model.rsa.SignResponseBody;
import fr.bnancy.model.rsa.VerifyRequestBody;
import fr.bnancy.service.AccountService;
import fr.bnancy.service.RsaService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

@Controller
@RequestMapping("/rsa")
public class RsaSignController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RsaService rsaService;

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SignResponseBody> sign(@RequestHeader("Authorization") String token, @RequestBody SignRequestBody signRequestBody) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Account account = accountService.getAccountForToken(token);

        if (account == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        byte[] signed = rsaService.sign(account.getPrivateKey(), signRequestBody.getData().getBytes());

        SignResponseBody signResponseBody = new SignResponseBody(Base64.encodeBase64String(signed), signRequestBody.getData());
        return new ResponseEntity<>(signResponseBody, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity verify(@RequestHeader("Authorization") String token, @RequestBody VerifyRequestBody verifyRequestBody) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        Account account = accountService.getAccountForToken(token);

        if (account == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        boolean ok = rsaService.verify(account.getPublicKey(), verifyRequestBody.getData().getBytes(), Base64.decodeBase64(verifyRequestBody.getSignature()));

        if(ok)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
}
