package fr.bnancy.web;

import fr.bnancy.model.hmac.SignRequestBody;
import fr.bnancy.model.hmac.SignResponseBody;
import fr.bnancy.model.hmac.VerifyRequest;
import fr.bnancy.model.hmac.VerifyRequestResult;
import fr.bnancy.service.HmacSignService;
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

    private HmacSignService hmacSignService;

    @Autowired
    public HmacController(HmacSignService hmacSignService) {
        this.hmacSignService = hmacSignService;
    }

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public SignResponseBody sign(@RequestBody SignRequestBody body) {
        return hmacSignService.sign(body);
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public VerifyRequestResult verify(@RequestBody VerifyRequest verifyRequest) {
        return new VerifyRequestResult(hmacSignService.verify(verifyRequest), verifyRequest.getBody());
    }
}
