package com.auth.api.services;


import com.auth.api.models.Credential;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;

public interface CredentialService {

    JSONObject addCredential(Credential credential);

    JSONObject checkCredential(String login, String pass);
}
