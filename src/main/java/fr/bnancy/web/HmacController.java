package fr.bnancy.web;

import fr.bnancy.model.SignRequestBody;
import fr.bnancy.model.SignResponseBody;
import fr.bnancy.model.VerifyRequest;
import fr.bnancy.model.VerifyRequestResult;
import fr.bnancy.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/hmac")
public class HmacController {

    private SignService signService;

    @Autowired
    public HmacController(SignService signService) {
        this.signService = signService;
    }

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public SignResponseBody sign(@RequestBody SignRequestBody body) {
        return signService.sign(body);
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public VerifyRequestResult verify(@RequestBody VerifyRequest verifyRequest) {
        return new VerifyRequestResult(signService.verify(verifyRequest), verifyRequest.getBody());
    }
}
