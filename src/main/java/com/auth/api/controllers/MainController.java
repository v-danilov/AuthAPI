package com.auth.api.controllers;

import com.auth.api.models.Credential;
import com.auth.api.services.CredentialService;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    private CredentialService credentialService;

    @Autowired(required = true)
    public void setCredentialService(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @RequestMapping(value = "/reg", params = {"login", "pass"}, method = RequestMethod.GET)
    public @ResponseBody String registrate(@RequestParam(value = "login") String login,
                           @RequestParam(value = "pass") String pass)
    {
        Credential newCred = new Credential(login, DigestUtils.md5Hex(pass));
        return credentialService.addCredential(newCred).toString();
    }

    @RequestMapping(value = "/auth", params = {"login", "pass"}, method = RequestMethod.GET)
    public @ResponseBody String authorize(@RequestParam(value = "login") String login,
                         @RequestParam(value = "pass") String pass)
    {
        return credentialService.checkCredential(login, DigestUtils.md5Hex(pass)).toString();
    }
}
